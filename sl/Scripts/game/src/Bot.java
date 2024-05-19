package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.sound.*;

public class Bot extends Racer
{
    int		fileid;
    int		seed;
    float   aiLevel;
    int		debugid;

	//int		carID;
	VehicleDescriptor botVd;
	VehicleDescriptor nightVd;

	GameRef	dummycar;	//dublor, native-only instance

	//random generalashoz:
	float	color, optical, engine;

	int		imaPoliceDriver;
	int             nightWins = 0;
	int             nightLoses = 0;
        float           bestNightQM = 0.0;

	static	String[]	botNames;

	GameRef world;

    GameRef brain;          //ha ai-kent mukodik
    GameRef controller;		// ==brain :o), patch
    int		traffic_id;     //ha a forgalomban van
	int		horn;

    public Bot( int savefileid, int rndseed, float col, float opti, float eng, float ai)
	{
        fileid=savefileid;
        seed=rndseed;
        name=constructName( seed );
		fileid %= 20;
		character = new RenderRef( RID_FEJ + fileid );

		//------
		color = col;
		optical = opti;
		engine = eng;
		aiLevel = ai;
		//------

		if( name.length() % 2 )
			//driverID = GameLogic.HUMAN_OPPONENT;
			driverID = new RenderRef(GameLogic.HUMAN_OPPONENT);
		else
			//driverID = GameLogic.HUMAN_OPPONENT2;
			driverID = new RenderRef(GameLogic.HUMAN_OPPONENT2);

        setEventMask( EVENT_COMMAND );
	}

	public Bot( int savefileid, int rndseed, float level )	//level: [0..1)
    {
		if( !botNames )
			patchCreateBotNames();

        fileid=savefileid;
        seed=rndseed;
        name=botNames[fileid];
		fileid %= 20;
		character = new RenderRef( RID_FEJ + fileid );


		//------
		int tmp;	//tortresz :)
		color = rndseed*1.36785; tmp=color; color-=tmp;
		optical= rndseed*3.13771; tmp=optical; optical-=tmp;
		engine= rndseed*4.75835; tmp=engine; engine-=tmp;

		engine = 1.0 + engine*level;	//
		optical += 1.0;

		aiLevel=level;
		//------

		if( name.length() % 2 )
			//driverID = GameLogic.HUMAN_OPPONENT;
			driverID = new RenderRef(GameLogic.HUMAN_OPPONENT);
		else
			//driverID = GameLogic.HUMAN_OPPONENT2;
			driverID = new RenderRef(GameLogic.HUMAN_OPPONENT2);

        setEventMask( EVENT_COMMAND );
    }

	public RenderRef getMarker()
	{
		if( club == 2 )
			return Marker.RR_CAR3;
		if( club == 1 )
			return Marker.RR_CAR2;

		return Marker.RR_CAR1;
	}

	public float getCarPrestige()
	{
		if( !car && botVd )
			return botVd.estimatePrestige();

		return super.getCarPrestige();
	}				

	public void setDriverObject( int id )
	{
		driverID = new RenderRef(id);
	}

    //letrehozas, megszuntetes:

	//fajlbol:
    public void createCar( GameRef map, String filename )
	{
		Vehicle vhc = Vehicle.load( filename, this );

		if( !vhc )
			System.exit( "Fatal: Cannot create car using file " + filename );

		createCar( map, vhc );
	}

	//automatikusan:
    public void createCar( GameRef map )
	{
		Vehicle vhc;

		if( botVd )
		{
			vhc = new Vehicle( this, botVd.id,  botVd.colorIndex, botVd.optical, botVd.power, botVd.wear, botVd.tear );
		}
		else
		{
			System.exit( "Bot.createCar(): VehicleDescriptor null" );
		}

		createCar( map, vhc );
	}

	//atadjuk neki direktbe:
    public void createCar( GameRef map, Vehicle c )
    {
        world=map;
		deleteCar();

		car = c;
		debugid = car.id();

		enterCar( car );
    }


    public void deleteCar()
    {
		if( car )
		{
			leaveCar(0);

			//kocsi bezuzva
			if( car.id() )
//			System.log( "deleted: " + car.id() );
			car.destroy();
			car=null;       //eleg lenne csak ez, majd teszteljuk le!
		}
    }

	public void enterCar( Vehicle c )
	{
		if (!c)	return;

		c.setTransmission( Vehicle.TRANSMISSION_SEMIAUTO );
        
        //megcsinaljuk az agyat
		//if( brain )	//pl volt mar ha epp forgalomba maszott vissza a dummycar, es kihivtuk
		//	brain.destroy();


		brain = new GameRef( world, sl:0x0000006Er, "", "BOTBRAIN");
		controller = brain;

		//ilyen okos vagy:
        brain.queueEvent( null, GameType.EVENT_COMMAND, "AI_level " + aiLevel );

        //ultetunk bele emberket is:
		c.command( "corpse 0 0" );	//kiszedjuk ha mar volt hullaja :)

        render = new RenderRef( world, driverID, "botfigura" );
        brain.queueEvent( null, GameType.EVENT_COMMAND, "renderinstance " + render.id() );

        //ezt a kocsit vezessed ni:
        brain.queueEvent( null, GameType.EVENT_COMMAND, "controllable " + c.id() );
        brain.queueEvent( null, GameType.EVENT_COMMAND, "AI_suspend" );


		//addNotification( c, EVENT_COMMAND, EVENT_SAME, null );
        //setEventMask( EVENT_COMMAND );
	}

	public void leaveCar( int leaveInTraffic )
	{
		//clearEventMask( EVENT_COMMAND );

		if( !leaveInTraffic )
		{
			leaveTraffic();	//kiszedi a forgalombol, ha ott volt
		}
	
		//sofor killed
		if( render )
			render.destroy();

		//agya is killed
		if (brain)
		{
			brain.queueEvent( null, GameType.EVENT_COMMAND, "leave " + car.id() );
			brain.destroy();
			brain = null;
			controller = null;
		}

		//remNotification( car, EVENT_COMMAND );

		if( leaveInTraffic )
		{
			//native gamerefbol keszult vehicles:
			//ha forgalomba engedjuk vissza, ki kell torolnunk a Vehicle-bol, kulonben torolni fogja a gc!
			if( car )	//ez miert kelll???!!!
			{
				car.release();
				car=null;
			}
		}
		
	}

    public void handleEvent( GameRef obj_ref, int event, int param )
    {
		if( event == EVENT_TIME )
		{
			clearEventMask( EVENT_TIME );

			reJoinTraffic();
		}
	}

    //itt szinkronizalunk az automatikus forgalomkezeles esemenyeihez:
    //ha karambolozik az auto, automatikusan kikerul a forgalombol, (denes kuld infot)
    //visszakuldom a forgalomba, (AI_GoToTraffic)
    //majd visszakerul a forgalomba. (klampi csinalja)
    public void handleEvent( GameRef obj_ref, int event, String param )
    {
		if( event == EVENT_COMMAND )
		{
			String t0 = param.token(0);
			if( t0 == "ai_info_entertraffic" )
			{
				traffic_id = param.token(1).intValue();

				if( imaPoliceDriver )
				{
					remNotification( car, EVENT_COMMAND );
					leaveCar(1); //lassu! de ez nincs olyan gyakran...
					//majd a traffic id miatt eszreveszi a city!
				}
				else
				{
					//leaveCar(1); lassu!

					brain.destroy();
					brain = null;
					controller = null;

					RenderRef render = new RenderRef( world, driverID, "botfigura-leavetraffic" );
					car.command( "corpse 0 " + render.id() );

					car.release();
					car = null;

				}
			}
			else
			if( t0 == "ai_info_leavetraffic" )
			{
				traffic_id = 0;

				car = new Vehicle(dummycar);
				//enterCar( car ); lassu!

				brain = new GameRef( world, sl:0x0000006Er, "", "BOTBRAIN");
				controller = brain;

				dummycar.command( "corpse 0 0" );
				RenderRef render = new RenderRef( world, driverID, "botfigura-leavetraffic" );
				brain.command( "renderinstance " + render.id() );

				brain.queueEvent( null, GameType.EVENT_COMMAND, "controllable " + car.id() );


				stop();

				setEventMask( EVENT_TIME );
				addTimer( 3.0, 0 );
			}
		}
    }


    //parancsok:
    public void setTrafficBehaviour( int mode )
    {
		if( traffic_id && world instanceof GroundRef )
		{
			((GroundRef)world).setTrafficCarBehaviour( traffic_id, mode );
		}
    }

    //az adott poziciohoz legkozelebbi keresztezodesnel csatlakozik a forgalomhoz
    public void joinTraffic( Vector3 pos )
    {
		if( !traffic_id )
        {
	        beStupid();
			traffic_id = world.addTrafficCar( car, pos );
        }
	}

    public void reJoinTraffic()
    {
		if( !traffic_id )
		{
            //leaveTraffic(); elvarjuk, hogy hivaskor mar ne legyen benne
			if (brain)
	            brain.queueEvent( null, GameType.EVENT_COMMAND, "AI_GoToTraffic" );
            //ha odaert, onmukododen traficce valik... ekkor notificationt kapok rola (az ai lesuspendelodik, ha en csinaltam)
		}
    }

    public void leaveTraffic()
    {
        if( traffic_id )
        {
			world.remTrafficCar( traffic_id );
			traffic_id = 0;
        }
    }

    public void beStupid()
    {
            brain.queueEvent( null, GameType.EVENT_COMMAND, "AI_suspend" );
    }

    public void followCar( GameRef playercar, float dest )
    {
            leaveTraffic();
            brain.queueEvent( null, GameType.EVENT_COMMAND, "AI_follow 0,0," + dest + " " + playercar.id() );
    }

    public void stopCar( GameRef playercar )
    {
            leaveTraffic();
            brain.queueEvent( null, GameType.EVENT_COMMAND, "AI_follow 0,0,-2 " + playercar.id() );
    }

    public void startRace( Vector3 destination, Racer opponent )
    {
            leaveTraffic();
            brain.queueEvent( null, GameType.EVENT_COMMAND, "AI_race " + destination.toString() + " " + opponent.car.id() );
    }

    public void driveStraightTo( Vector3 destination )
    {
            leaveTraffic();
            brain.queueEvent( null, GameType.EVENT_COMMAND, "AI_GoToTarget " + destination.toString() );
    }

    public void pressHorn()
    {
		if (horn) return;
//              brain.queueEvent( null, GameType.EVENT_COMMAND, "AI_horn 1" );
		if (car)
		{
            car.queueEvent( null, GameType.EVENT_COMMAND, "sethorn 1" );
			horn = 1;
		} else
		if (dummycar)
		{
            dummycar.queueEvent( null, GameType.EVENT_COMMAND, "sethorn 1" );
			horn = 1;
		}
    }

    public void releaseHorn()
    {
		if (!horn) return;
//              brain.queueEvent( null, GameType.EVENT_COMMAND, "AI_horn 0" );
		if (car)
		{
            car.queueEvent( null, GameType.EVENT_COMMAND, "sethorn 0" );
			horn = 0;
		} 
		else
		if (dummycar)
		{
            dummycar.queueEvent( null, GameType.EVENT_COMMAND, "sethorn 0" );
			horn = 0;
		}
    }

    public void stop()
    {
		leaveTraffic();
		if (brain)
			brain.queueEvent( null, GameType.EVENT_COMMAND, "AI_stop" );
		//beStupid();
    }

	public void followSplineTrack( float width, String splineFile, int oppCarId )
	{
		brain.queueEvent( null, EVENT_COMMAND, "AI_spline " + width + " " + splineFile + " " + oppCarId );					
	}

    public String constructName( int seed )
    {
             String[] pre = new String[20];
            pre[0]="";
            pre[1]="";

            String[] first = new String[12];
            first[0]="Julio ";
            first[1]="Davis ";
            first[2]="Carlos ";
            first[3]="Estenio ";
            first[4]="Flavio ";
            first[5]="Paulo ";
            first[6]="Alan ";
            first[7]="Marcus ";
            first[8]="Geovane ";
            first[9]="Vitor ";
            first[10]="Antonio ";
            first[11]="Leo ";

            String[] mid = new String[40];
            mid[0]="'Sortudo' ";
            mid[1]="'Rapido' ";
            mid[2]="'Noob' ";
            mid[3]="'Louco' ";
            mid[4]="'Cearense' ";
            mid[5]="'Maluco' ";
            mid[6]="'Zoeiro' ";
            mid[7]="'Mexicanico' ";
            mid[8]="'Mecanino' ";
            mid[9]="'Gordo' ";
            mid[10]="'Cupim' ";
            mid[11]="'GearHead' ";
            mid[12]="'Magrelo' ";

            String[] last = new String[22];
            last[0]="Costa";
            last[1]="Borboleta";
            last[2]="Robson";
            last[3]="Ferreira";
            last[4]="Pereira";
            last[5]="Pedra";
            last[6]="Andrade";
            last[7]="Pequeno";
            last[8]="Silva";
            last[9]="Silveira";
            last[10]="Barreto";
            last[11]="Falador";
            last[12]="Malandro";
            last[13]="Marques";
            last[14]="Pereira";
            last[15]="da Silva";
            last[16]="Santos";
            last[17]="Oliveira";
            last[18]="Souza";
            last[19]="Ramos";
            last[20]="Rodrigues";
            last[21]="Gomes";

            String[] post = new String[1];
            post[0]="";

            return //pre[(seed*3)%pre.length] +
                    first[(seed*19)%first.length] +
              //      mid[(seed*31)%mid.length] +
                    last[(seed*23)%last.length] +
                    post[(seed*17)%post.length];

    }

	public String getPrestigeString()
	{
			return getPrestigeString(-1);
	}

	public String getPrestigeString(int racemode)
	{
		int pprestige, cprestige, aprestige;
		pprestige = prestige*PRESTIGE_SCALE;

		if( car )
			cprestige = car.getPrestige() * VHC_PRESTIGE_SCALE;
                else
                if (racemode == 0 || racemode == 1)
                  cprestige = nightVd.estimatePrestige() * VHC_PRESTIGE_SCALE;
                else
//                if (racemode == 4 || racemode == 5)
                  cprestige = botVd.estimatePrestige() * VHC_PRESTIGE_SCALE;

		aprestige = pprestige*0.5 + cprestige*0.5;

//		return aprestige + " (" + pprestige +  ":" + cprestige + ")";
		return pprestige +  "/" + cprestige;
	}

	public void patchCreateBotNames()
	{
		botNames = new String[GameLogic.CLUBS*GameLogic.CLUBMEMBERS];
		
		botNames[0]  = "Adnan Pedroso";
		botNames[1]  = "Wellington Nyckolas";
		botNames[2]  = "Arthur Binotto";
		botNames[3]  = "Henrique Cocca";
		botNames[4]  = "Sergio NightRider";
		botNames[5]  = "Diego Borges";
		botNames[6]  = "Daniel Xavier";
		botNames[7]  = "Otavio Nogadachi";
		botNames[8]  = "Willian Santos";
		botNames[9]  = "Leandro Silva";	//G!
		botNames[10] = "Gustavo da Arrancada";
		botNames[11] = "Thomas Turbo";
		botNames[12] = "Lucas Borges";
		botNames[13] = "Jailson da Mecanica";
		botNames[14] = "Nelson Alves";
		botNames[15] = "Jefferson Massa";	//G!
		botNames[16] = "Emerson Piquet";
		botNames[17] = "Roberto Moreno";
		botNames[18] = "Denilson Fonseca";
		botNames[19] = "Oliveira da Arrancada";
		botNames[20] = "Kleber Machado";
		botNames[21] = "Sebastian Ferreira";
		botNames[22] = "Seu Julio";
		botNames[23] = "Luiz Pedroso";
		botNames[24] = "Enzo Henrique";
		botNames[25] = "Cesar Coito";
		botNames[26] = "Danilo Nunes";
		botNames[27] = "Luis Melo";
		botNames[28] = "Murilo Rorato";	//G!
		botNames[29] = "Carlos Eduardo";
		botNames[30] = "Nilton da Luz";
		botNames[31] = "Daniel Barreto";
		botNames[32] = "Bruno Freitas";
		botNames[33] = "Felipe Marques";
		botNames[34] = "Pablo Martins";
		botNames[35] = "Vitor Costa";
		botNames[36] = "Pedro Duarte";
		botNames[37] = "Derek Freitas";
		botNames[38] = "Winderson Machado";
		botNames[39] = "Bob Oliveira";	//G!
		botNames[40] = "Altair Gonsalves";
		botNames[41] = "Fabio Perez";
		botNames[42] = "Alan Nascimento";	//G!
		botNames[43] = "Ricardo Sousa";
		botNames[44] = "Yamoto Iimu";
		botNames[45] = "Beto dos Santos";
		botNames[46] = "Danilo Cestary";
		botNames[47] = "Fernando da Silva";
		botNames[48] = "Robson Batista";
		botNames[49] = "Rodrigo Barcelos";
		botNames[50] = "Eduardo Silveiro";
		botNames[51] = "Julio Garcia";
		botNames[52] = "Michel Ramos";
		botNames[53] = "Nathanel Rodrigues";
		botNames[54] = "Raymundo Gomes";
		botNames[55] = "Juliano Sabodo";	//G!
		botNames[56] = "Pedro Cupim de Ferro";
		botNames[57] = "Wilson Souza";
		botNames[58] = "Anderson Silva";
		botNames[59] = "Claudio Pereira";
		botNames[60] = "Aidan Lima";
		botNames[61] = "Thiago Rilton";
		botNames[62] = "Wanderson Charles";
		botNames[63] = "Alan Marques";
		botNames[64] = "Julio Amaral";
		botNames[65] = "Leandro Pinto";
		botNames[66] = "Fabio Roberto";
		botNames[67] = "Josias Bianco";
		botNames[68] = "Jorge Walter";
		botNames[69] = "Mariano Nortano";
		botNames[70] = "Wander Kentani";
		botNames[71] = "Carlinhos do Som";
		botNames[72] = "Junior Gonzales";
		botNames[73] = "Kleber Pedralha";
		botNames[74] = "Renato Silveira";
		botNames[75] = "Arthur Pedroso";
		botNames[76] = "Esmael da Silva";
		botNames[77] = "Julio Marciano";
		botNames[78] = "Cesar Garcia";
		botNames[79] = "Jhonatan Megani";
		botNames[80] = "Charles Velasquez";
		botNames[81] = "Antonio Richard";
		botNames[82] = "Wagner Nascimento";
		botNames[83] = "Felipe Nobre";
		botNames[84] = "Lucas Martins";
		botNames[85] = "Raul Vincente";
		botNames[86] = "Pablo Mackenzie";
		botNames[87] = "Iago Reynaldo";
		botNames[88] = "Gabriel Ferreira";
		botNames[89] = "Paulo de Souza";
		botNames[90] = "Jonatas Giles";
		botNames[91] = "Jeferson Couto";
		botNames[92] = "Higor da Cunha";
		botNames[93] = "Yuri Gomes";
		botNames[94] = "Bruno Silveira";
		botNames[95] = "Marlon Esteves";
		botNames[96] = "Dejair Hickman";
		botNames[97] = "Gilson Trindade";
		botNames[98] = "Edmilson de Macedo";
		botNames[99] = "Denis Aparecido";
		botNames[100] = "Manoel Santos";
		botNames[101] = "Danilo Araujo";
		botNames[102] = "Marcos da Costa";
		botNames[103] = "Adriano Rocha";
		botNames[104] = "Wesley Silvano";
		botNames[105] = "Pedro Romeiro";
		botNames[106] = "Dener Alves";
		botNames[107] = "Ricardo de Galles";
		botNames[108] = "Barreto Filho";
		botNames[109] = "Jorge Clemente";
		botNames[110] = "Nilton Cesar";
		botNames[111] = "Fabiano Carvalho";
		botNames[112] = "Neltair Ferraz";
		botNames[113] = "Mario Cabral";
		botNames[114] = "Cadu Alves";
		botNames[115] = "Samuel Bezerra";
		botNames[116] = "Claudio Bandeira";
		botNames[117] = "Ronaldo Farias";
		botNames[118] = "Cristano Lira";
		botNames[119] = "Diego Naves";
	}

	public void save( File saveGame )
	{
		super.save(saveGame);

		int save_ver = 1;
		saveGame.write(save_ver);
		if (save_ver >= 1)
		{
			saveGame.write(nightWins);
			saveGame.write(nightLoses);
			saveGame.write(bestNightQM);
		}
	}

	public void load( File saveGame )
	{
               super.load(saveGame);

		int save_ver;
		save_ver = saveGame.readInt();

		if (save_ver >= 1)
		{
			nightWins = saveGame.readInt();
			nightLoses = saveGame.readInt();
			bestNightQM = saveGame.readFloat();
		}
	}
}
