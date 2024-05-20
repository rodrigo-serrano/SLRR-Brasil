package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.render.osd.dialog.*;	//Text
import java.sound.*;

public class CarMarket extends Scene implements GameState
{
	// resource ID constants
	final static int  RID_MAP_DEALER = misc.dealer:0x0001r;
	final static int  RID_MAP_DEALER2 = misc.dealer2:0x0001r;

	final static int  RID_STUFF_DEALER = misc.dealer:0x000Fr;
	final static int  RID_STUFF_DEALER2 = misc.dealer2:0x0002r;

	final static float	FLOOR_HEIGHT =3.3;

	final static float PRICERATIO_NEW = 1.50;	// Valor Loja 0km
	final static float PRICERATIO_USED = 1.15;	// Valor Ferro Velho
	final static float PRICERATIO_BUY = 0.90;	//dealer ar-szorzo
	final static float PRESTIGE_RATIO_BUY = 0.50;	//dealer prestige-szorzo
	final static float PRESTIGE_RATIO_SELL = 0.35;	//dealer prestige-szorzo

	final static int	CMD_PREVCAR = 0;
	final static int	CMD_NEXTCAR = 1;

	Player			player;
	GameState		parentState;

	GameRef			cam;
	int				move;

	//display
	Osd				osd;
	Text			moneytxt;
	Text			carName;
	Gadget			buyButton;

	int				used;
	DealerData		positions;
	int				numpos;
	int				welcomeTextureId, sellTextureId;
	float			priceRatio;

	RenderRef		stuff1;

	VehicleDescriptor[] carDescriptors;
	Vehicle[]		cars;
	int				curcar;

	public static VehicleDescriptor[] getInitialCars( int used )
	{
		VehicleDescriptor[] result = new VehicleDescriptor[58];

		int	i;
		int	vt;

		if( used )//fix kezdeti szett a hasznalt dealernel!
		{
			vt = VehicleType.VS_USED;

                         

                        // Carros Iniciais
			//Primeiro Carro
			result[i] = new VehicleDescriptor();
			result[i].id = cars.racers.DelRey:0x00000F30r;
			result[i].power = 0.50;
			result[i].optical = 0.90;
			result[i].tear = 0.75;
			result[i].wear = 0.65;
			result[i].stockPrestige = 297;
			result[i].fullPrestige = 317;
			result[i].stockQM = VehicleType.qm_stock_cht1600;
			result[i].fullQM = VehicleType.qm_full_cht1600;
			result[i].vehicleName = "Delrey Automatico";
			result[i++].colorIndex = Math.random()*GameLogic.CARCOLORS.length;

			//segundo Carro
			result[i] = new VehicleDescriptor();
			result[i].id = cars.racers.fusca:0x00000006r;
			result[i].power = 0.25;
			result[i].optical = 1.0;
			result[i].tear = 0.85;
			result[i].wear = 0.80;
			result[i].stockPrestige = 235;
			result[i].fullPrestige = 281;
			result[i].stockQM = VehicleType.qm_stock_ar_1600;
			result[i].fullQM = VehicleType.qm_full_ar_1600;
			result[i].vehicleName = "Fuscao";
			result[i++].colorIndex = Math.random()*GameLogic.CARCOLORS.length;

			//terceiro Carro
			result[i] = new VehicleDescriptor();
			result[i].id = cars.racers.FiatOggiTC:0x00000AD9r;
			result[i].power = 0.50;
			result[i].optical = 0.80;
			result[i].tear = 0.5;
			result[i].wear = 0.5;
			result[i].stockPrestige = 297;
			result[i].fullPrestige = 317;
			result[i].stockQM = VehicleType.qm_stock_fiasa_1300;
			result[i].fullQM = VehicleType.qm_full_fiasa_1300;
			result[i].vehicleName = "Fiat 147 C";
			result[i++].colorIndex = Math.random()*GameLogic.CARCOLORS.length;

			//quarto Carro
			result[i] = new VehicleDescriptor();
			result[i].id = cars.racers.Volkswagen_Brasilia:0x00000006r;
			result[i].power = 0.5;
			result[i].optical = 0.75;
			result[i].tear = 0.75;
			result[i].wear = 0.75;
			result[i].stockPrestige = 204;
			result[i].fullPrestige = 244;
			result[i].stockQM = VehicleType.qm_stock_ar_1600;
			result[i].fullQM = VehicleType.qm_full_ar_1600;
			result[i].vehicleName = "Volkswagen Brasilia";
			result[i++].colorIndex = Math.random()*GameLogic.CARCOLORS.length;


		}
		else
		{
			vt = VehicleType.VS_STOCK;
		}
			
        for( ; i<result.length; i++ )	
		result[i] = GameLogic.getVehicleDescriptor( vt );

		return result;
		
	}

	public static void alterCars( int used, VehicleDescriptor[] cars, float hoursPassed )
	{
		int	vt;
		if( used )
			vt = VehicleType.VS_USED;
		else
			vt = VehicleType.VS_STOCK;

		for( int i = 0; i<cars.length; i++ )
		{
			
			if( !cars[i] || Math.random() < 0.02*hoursPassed )
			{//ures volt: feltoltjuk, vagy orankent 2% esellyel csereljuk
				cars[i] = GameLogic.getVehicleDescriptor( vt );
			}
			else
			{//ha nem valtozott, 2% hogy megvette valaki
				if( Math.random() < 0.02*hoursPassed )
					cars[i] = null;
			}
		}
	}
	

	public CarMarket( int used, VehicleDescriptor[] carDescriptors )
	{
		createNativeInstance();

		this.used = used;
		this.carDescriptors = carDescriptors;
		this.player = GameLogic.player;
	}
	
	public Vector3 getCarPos( int n )
	{
		return new Vector3( positions.carPos[n] );
	}

	public Ypr getCarOri( int n )
	{
		Ypr ypr = new Ypr( positions.carOri[n] );
		ypr.y += 0.2-Math.random()*0.4;
		return ypr;
	}

	public void moveCamera()
	{
		if( cars[curcar] )
		{
			int price = cars[curcar].getTotalPrice();

			if( used && curcar == 0 )
			{
				price *= 1.0+((cars[curcar].getPrestigeMultiplier()-1.0)*PRESTIGE_RATIO_BUY);
				price *= PRICERATIO_BUY;
				carName.changeText( "Pagamos  $" + price + " no seu Carro" );
			}
			else
			{
				price *= 1.0+((cars[curcar].getPrestigeMultiplier()-1.0)*PRESTIGE_RATIO_SELL);
				price *= priceRatio;
				carName.changeText( cars[curcar].toString() + " $" + price );
			}

			cam.command( "move " + cars[curcar].id() + " 0,0,0 4.5" );
			cam.command( "look " + cars[curcar].id() + " 0,0,0 0,0,0" );
			cam.command( "height 1.9");

			if( used && curcar == 0 )
				buyButton.changeTexture( new ResourceRef( frontend:0x012Fr ) ); //sel our car
			else
				buyButton.changeTexture( new ResourceRef( frontend:0x0125r ) ); //buy a car

		}
	}


	public void enter( GameState prevState )
	{
		if( prevState instanceof CarInfo )
		{
			osd.show();
		}
		else
		{
			parentState=prevState;

			if( used )
			{
				map = new GroundRef( RID_MAP_DEALER2 );
				positions = new DealerSHData();
				stuff1 = new RenderRef( map, RID_STUFF_DEALER2, null );
				welcomeTextureId = frontend:0x00A4r;
				sellTextureId = frontend:0x00CEr;
				priceRatio = PRICERATIO_USED;
			}
			else
			{
				map = new GroundRef( RID_MAP_DEALER );
				positions = new DealerNewData();
				stuff1 = new RenderRef( map, RID_STUFF_DEALER, null );
				welcomeTextureId = frontend:0x00CAr;
				sellTextureId = frontend:0x00CDr;
				priceRatio = PRICERATIO_NEW;
			}

			Frontend.loadingScreen.show(new ResourceRef(welcomeTextureId));


			numpos = positions.carPos.length;
			cars = new Vehicle[numpos];


			osd = new Osd();
			osd.globalHandler = this;

			carName=osd.createText( null,	Frontend.mediumFont, Text.ALIGN_CENTER, 0.0, -0.98 );
			moneytxt=osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,	0.95, -0.98);

			osd.createHeader( "Loja de carros" );

			osd.createRectangle( 1.01, -0.82, 1.2, 0.22, -1, new ResourceRef(frontend:0x0024r) );

			Style buttonStyle = new Style( 0.12, 0.12, Frontend.mediumFont, Text.ALIGN_LEFT, null );
			Menu m = osd.createMenu( buttonStyle, 0.45, -0.82, 0, Osd.MD_HORIZONTAL );

			m.addItem( new ResourceRef( Osd.RID_ARROWLF ), Input.AXIS_MENU_LEFT, null );
			m.addItem( new ResourceRef( Osd.RID_ARROWRG ), Input.AXIS_MENU_RIGHT, null );
			m.addItem( new ResourceRef( frontend:0x0124r ), Input.AXIS_HELP, null );
			buyButton = m.addItem( new ResourceRef( frontend:0x0125r ), Input.AXIS_SELECT, null );
			m.addSeparator();
			m.addSeparator();
			m.addItem( new ResourceRef( Osd.RID_BACK ), Input.AXIS_CANCEL, null );

			lockPlayerCar();

			//---------------------------------time of day dependent stuff:
			addSceneElements( GameLogic.getTime() );

			if( !used )
				//habar ez nem internal scene, de gyorsan ujra-at-allitjuk az envmapot!
				GfxEngine.setGlobalEnvmap( new ResourceRef(maps.skydome:0x003Ar) );
			//-----------------------------------------------------------------------

			int emptySpaces = cars.length-carDescriptors.length-used;

			//hasznaltnal a 0-n a player parkol
			int	offsetVd;
			for( int i=used; i<cars.length; i++ )	
			{
				if( ( emptySpaces && Math.random() < 0.4 ) || cars.length-emptySpaces<=i)
				{
					--emptySpaces;
				}
				else
				{
					VehicleDescriptor vd = carDescriptors[offsetVd++];

					if( vd )
					{
						Vehicle	car = new Vehicle( map, vd.id, vd.colorIndex, vd.optical, vd.power, vd.wear, vd.tear );
						car.chassis.setMileage( (1-vd.wear)*150000000f );
						addCar( car, i );
					}
				}
			}

			//hogy mozoghasson es renderelhessen a kamera!
			System.timeWarp(1.0);
			osd.getViewport().activate( Viewport.RENDERFLAG_CLEARDEPTH | Viewport.RENDERFLAG_CLEARTARGET );


			if( used )
				cam = new GameRef( map, GameRef.RID_CAMERA, "-3,2,0, 0,0,0, 0x13, 1.8,0.0, 0.05", "Car Dealer camera" );
			else
				cam = new GameRef( map, GameRef.RID_CAMERA, "10,2,-3, 0,0,0, 0x13, 1.8,0.0, 0.05", "Car Dealer camera" );

			cam.command( "render " + osd.getViewport().id() + " 0 0 1 " + (Viewport.RENDERFLAG_CLEARDEPTH | Viewport.RENDERFLAG_CLEARTARGET) );
			cam.command( "dist 2.5 4.6");
			cam.command( "smooth 0.05 0.5");
			cam.command( "force 0.3 0.5 -0.7" );
			cam.command( "torque 0.06" );
			cam.command( "zoom 60 5");

			goRight();
			goLeft();

			refreshMoneyString();

			
			//megvarjuk mig befejezi.. osd keyek nem elnek csak utana!
			Frontend.loadingScreen.userWait( 5.0 );


			osd.createHotkey( Input.AXIS_MENU_LEFT, Input.VIRTUAL|Osd.HK_STATIC, Input.AXIS_MENU_LEFT, this );
			osd.createHotkey( Input.AXIS_MENU_RIGHT, Input.VIRTUAL|Osd.HK_STATIC, Input.AXIS_MENU_RIGHT, this );
			osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL|Osd.HK_STATIC, Input.AXIS_CANCEL, this );

			osd.show();

			setEventMask( EVENT_CURSOR );
		}

		// special request: reset mouse and set sensitivity to 0
		Input.getAxis (1, -1);
		Input.cursor.enable(1);
		Input.cursor.addHandler(this);	//kivancsiak vagyunk ra, mit csinal az eger
		Input.cursor.enableCameraControl( cam );
	}

	public void exit( GameState nextState )
	{
		Input.cursor.enable(0);
		Input.cursor.remHandler(this);
		Input.cursor.disableCameraControl();

		if( nextState instanceof CarInfo )
		{
 			osd.hide();
		}
		else
		{
			clearEventMask( EVENT_ANY );

			cam.destroy();

			releasePlayerCar();

			for( int i=0; i<cars.length; i++ )
				if( cars[i] )
				{
					cars[i].destroy();	//
					cars[i]=null;		//eleg lenne..
				}

			remSceneElements();

			map.unload();

			osd.hide();
			osd=null;

			stuff1.destroy();

			parentState=null;
		}
	}


	public void lockPlayerCar()
	{
		if( used && GameLogic.player.car )
		{
			addCar( GameLogic.player.car, 0 );
			GameLogic.player.car=null;
		}
	}

	public void releasePlayerCar()
	{
		if( used && cars[0] )
		{
			cars[0].command( "start" );	//release
			GameLogic.player.car = cars[0];
			GameLogic.player.car.setParent( GameLogic.player );

			cars[0] = null;
		}
	}

	public int addCar( Vehicle car, int slot )
	{
		if( car )
		{
			if( !cars[slot] )
			{
				cars[slot] = car;

				car.setParent( map );
				Vector3 pos = getCarPos(slot);
				pos.z += Math.random()*0.1;
				pos.x += Math.random()*0.1;
				car.setMatrix( pos, getCarOri(slot) );
				car.command( "reset" );
				car.command( "setsteer "+ (-0.7+(Math.random()*1.4)) );
				car.command( "stop" );	//grab

				return 1;
			}
		}

		return 0;
	}

	public GameRef createCar( GameRef carType )
	{
		Vehicle car;

		float opti, engi, wear, tear;

		if( used )
		{
			opti = 0.3 + Math.random()*1.5;	//0.3-1.8
			engi = 0.5 + Math.random()*1.0;	//0.5-1.5
			wear = 0.4 + Math.random()*0.6;
			tear = 0.7 + Math.random()*0.3;
		}
		else
		{
			opti = 1.0;
			engi = 1.0;
			wear = 1.0;
			tear = 1.0;
		}

		car = new Vehicle( map, carType.id(), Math.random(), opti, engi, wear, tear );
		car.chassis.setMileage( (1-wear)*10000000f );

		return car;
	}

	public void refreshMoneyString()
	{
		new SfxRef( Frontend.SFX_MONEY ).play(); 
		moneytxt.changeText( "$" + Integer.toString( player.money ) );
	}

//----------------------------------------------------------------------
	public void osdCommand( int cmd )
	{
		if( cmd == Input.AXIS_MENU_LEFT )
		{
			goLeft();
		}
		else
		if( cmd == Input.AXIS_MENU_RIGHT )
		{
			goRight();
		}
		else
		if( cmd == Input.AXIS_CANCEL )
		{
			GameLogic.changeActiveSection( parentState );
		}
		else
		if( cmd == Input.AXIS_HELP )
		{
			if( cars[curcar] )
			{
				GameLogic.changeActiveSection( new CarInfo( cars[curcar] ) );
			}
		}
		else
		if( cmd == Input.AXIS_SELECT )
		{
			buyCar();
		}
	}

	public void goLeft()
	{
		while(1)
		{
			if( --curcar < 0 )
				curcar=numpos-1;

			if( cars[curcar] )
				break;
		}

		moveCamera();
	}

	public void goRight()
	{
		while(1)
		{
			if( ++curcar >= numpos )
				curcar=0;

			if( cars[curcar] )
				break;
		}

		moveCamera();
	}

	public void changePointer()
	{
		if( move )
			Input.cursor.setPointer( Frontend.pointers, "M");
		else
			Input.cursor.setPointer( Frontend.pointers, "J");
	}

	public void handleEvent( GameRef obj_ref, int event, String param )
	{
		int	tok = -1;

		if( event == EVENT_CURSOR )
		{
			int	ec = param.token( ++tok ).intValue();

			int	cursor_id = param.token( ++tok ).intValue();

//left button handling: car selection
			if (ec == GameType.EC_LCLICK)
			{
				GameRef dest = new GameRef(param.token( ++tok ).intValue());
				int cat = dest.getInfo(GameType.GII_CATEGORY);
				if( cat == GIR_CAT_PART || cat == GIR_CAT_VEHICLE )
				{
					int carID = dest.getScriptInstance().getCar();
					for( int i=0; i<cars.length; i++ )
					{
						if (cars[i])
						if (cars[i].chassis)
						if (cars[i].chassis.id() == carID)
						{
							curcar = i;
							moveCamera();
							break;
						}
					}
				}
			} else

//right button handling: camera control
			if (ec == GameType.EC_RCLICK)
			{
				GameRef dest = new GameRef(param.token( ++tok ).intValue());
				int cat = dest.getInfo(GameType.GII_CATEGORY);
				if( cat == GIR_CAT_PART || cat == GIR_CAT_VEHICLE )
				{
					int carID = dest.getScriptInstance().getCar();
					if (cars[curcar])
					if (cars[curcar].chassis)
					if (cars[curcar].chassis.id() == carID)
					{
						cam.command( "look " + dest.id() + " " + param.token( ++tok ) + "," + param.token( ++tok ) + "," + param.token( ++tok ) );
					}
				}
			} else
			if (ec == GameType.EC_RDRAGBEGIN)
			{
				move=1;
				changePointer();
				//enable camera control with mouse
				player.controller.user_Add( Input.AXIS_LOOK_UPDOWN,	ControlSet.MOUSE, 1,	-1.0f, 1.0f, -1.0f, 1.0f);
				player.controller.user_Add( Input.AXIS_LOOK_LEFTRIGHT,	ControlSet.MOUSE, 0,	-1.0f, 1.0f, -1.0f, 1.0f);
				//disable cursor movement
				player.controller.user_Del( Input.AXIS_CURSOR_X,	ControlSet.MOUSE, 0 );
				player.controller.user_Del( Input.AXIS_CURSOR_Y,	ControlSet.MOUSE, 1 );
				Input.cursor.cursor.command( "lock" );
			}  else
			if (ec == GameType.EC_RDRAGEND)
			{
				move=0;
				changePointer();
				//disable camera control with mouse
				player.controller.user_Del( Input.AXIS_LOOK_UPDOWN,	ControlSet.MOUSE, 1 );
				player.controller.user_Del( Input.AXIS_LOOK_LEFTRIGHT,	ControlSet.MOUSE, 0 );
				//enable cursor movement
				player.controller.user_Add( Input.AXIS_CURSOR_X,	ControlSet.MOUSE, 0,	-1.0f, 1.0f, -1.0f, 1.0f);
				player.controller.user_Add( Input.AXIS_CURSOR_Y,	ControlSet.MOUSE, 1,	-1.0f, 1.0f, -1.0f, 1.0f);
				Input.cursor.cursor.command( "unlock" );
			} else
				;

		}
	}

//----------------------------------------------------------------------

	public void buyCar()
	{
		if( cars[curcar] )
		{
			int	price = cars[curcar].getTotalPrice();

			if( used && curcar == 0)		//eladjuk a kocsinkat!
			{
				price *= 1.0+((cars[curcar].getPrestigeMultiplier()-1.0)*PRESTIGE_RATIO_BUY);
				price *= PRICERATIO_BUY;
				Dialog d = new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Vender", "Deseja vender seu carro por $" + price +" ?" ); 
				if( d.display() == 0 )
				{
					player.money+=price;
					refreshMoneyString();

 					//remove car;
					cars[curcar].command( "reset" );
					cars[curcar].command( "start" );	//stoppolva volt!

					//find a new spot for it:
					for( int i=numpos-1; i; i-- )
					{
						if( !cars[i] )
						{
							addCar( cars[curcar], i );
							cars[curcar]=null;
							goRight();
						}
					}

					//kereskedo vesi a kocsinkat:
					Frontend.loadingScreen.display( new SimpleLoadingDialog( Dialog.DF_FULLSCREEN|Dialog.DF_MODAL, new ResourceRef(frontend:0x00A3r) ), 5.0 ); 
				}
			}
			else		//kocsit veszunk!
			{
				price *= 1.0+((cars[curcar].getPrestigeMultiplier()-1.0)*PRESTIGE_RATIO_SELL);
				price*=priceRatio;

				if( price <= player.money )
				{
					//lesz hely az uj jovevenynek?
					releasePlayerCar();
					player.carlot.lockPlayerCar();
					int	freeSlot=player.carlot.getFreeSlot();
					player.carlot.releasePlayerCar();
					lockPlayerCar();

					if( freeSlot >= 0 )
					{
						Dialog dialog = new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.DF_WIDE, "Comprar", "Deseja comprar este " + cars[curcar].toString()  + " por $" + price + " ? \n \n Informacoes " +cars[curcar].toString()+ ": " + cars[curcar].chassis.description );
						if( dialog.display() == 0 )
						{
							player.money-=price;
							refreshMoneyString();

							//ha kocsival jottunk, visszarakjuk a garazsba
							releasePlayerCar();

							//ha all kocsi a garazsban, bevagjuk a carlotba
							player.carlot.lockPlayerCar();
							player.carlot.saveCar( player.carlot.curcar );
							player.carlot.flushCars();

							//az uj kerul a garazsba
							player.car=cars[curcar];
							GameLogic.garage.releaseCar(); //pont ez kell nekunk!

							cars[curcar] = null;

							//kiutjuk a memory listabol is
							for( int i=0; i<carDescriptors.length; i++ )
								if( carDescriptors[i] && player.car.getInfo( GII_TYPE ) == carDescriptors[i].id )
									carDescriptors[i] = null;

							//kereskedo atad kocsikulcs:
							Frontend.loadingScreen.display( new SimpleLoadingDialog( Dialog.DF_FULLSCREEN|Dialog.DF_MODAL, new ResourceRef(sellTextureId) ), 5.0 );

							osdCommand( Input.AXIS_CANCEL );
						}
					}
					else
					{
						new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Estacionamento Lotado", "Seus estacionamento esta lotado, Venda algum carro!" ).display();
					}
				}
				else
				{
					new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Sem Dinheiro", "Voce nao tem $" + price + " para comprar este !"+ cars[curcar].toString() ).display();
				}
			}
		}
	}
}

public class DealerData
{
	Vector3[]	carPos;
	Ypr[]		carOri;
}

public class DealerNewData extends DealerData
{
	public DealerNewData()
	{
		carPos = new Vector3[7];
		carOri = new Ypr[7];

		carPos[0] = new Vector3( 3.901, 0.000, -3.499 );
		carOri[0] = new Ypr( -1.963, 0.000, 0.000 );
		carPos[1] = new Vector3( 3.901, 0.000, -7.603 );
		carOri[1] = new Ypr( -1.963, 0.000, 0.000 );
		carPos[2] = new Vector3( 5.099, 0.000, -12.927 );
		carOri[2] = new Ypr( -1.876, 0.000, 0.000 );
		carPos[3] = new Vector3( 10.922, 0.000, -11.930 );
		carOri[3] = new Ypr( -2.923, 0.000, 0.000 );
		carPos[4] = new Vector3( 17.295, 0.000, -13.173 );
		carOri[4] = new Ypr( 1.981, 0.000, 0.000 );
		carPos[5] = new Vector3( 17.226, 0.000, -7.603 );
		carOri[5] = new Ypr( 1.981, 0.000, 0.000 );
		carPos[6] = new Vector3( 17.226, 0.000, -3.267 );
		carOri[6] = new Ypr( 1.981, 0.000, 0.000 );
	}
}

public class DealerSHData extends DealerData
{
	public DealerSHData()
	{
		carPos = new Vector3[16];
		carOri = new Ypr[16];

		carPos[0] = new Vector3( 0.380, -0.400, 3.916 );		//itt all a player kocsija, ha azzal jon
		carOri[0] = new Ypr( 2.618, 0.000, 0.000 );
		//carPos[0] = new Vector3( 4.644, -0.400, 3.916 );	//nem egy csomoban vannak, epuletbe belemegy a kamera miattuk
		//carOri[0] = new Ypr( 2.618, 0.000, 0.000 );
		//carPos[0] = new Vector3( 9.140, -0.400, 3.916 );
		//carOri[0] = new Ypr( 2.618, 0.000, 0.000 );

		carPos[1] = new Vector3( -18.903, -0.400, -3.666 );
		carOri[1] = new Ypr( -1.552, 0.000, 0.000 );
		carPos[2] = new Vector3( -18.903, -0.400, -7.852 );
		carOri[2] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[3] = new Vector3( -18.903, -0.400, -12.563 );
		//carOri[3] = new Ypr( -1.552, 0.000, 0.000 );
		carPos[3] = new Vector3( -18.903, -0.400, -17.468 );
		carOri[3] = new Ypr( -1.552, 0.000, 0.000 );

		//carPos[5] = new Vector3( 15.575, -0.400, -16.392 );
		//carOri[5] = new Ypr( 1.592, 0.000, 0.000 );
		carPos[4] = new Vector3( 15.515, -0.400, -13.522 );
		carOri[4] = new Ypr( 1.592, 0.000, 0.000 );
		//carPos[7] = new Vector3( 14.475, -0.400, -10.401 );
		//carOri[7] = new Ypr( 1.592, 0.000, 0.000 );
		carPos[5] = new Vector3( 14.475, -0.400, -7.521 );
		carOri[5] = new Ypr( 1.592, 0.000, 0.000 );
		//carPos[9] = new Vector3( 15.575, -0.400, -4.507 );
		//carOri[9] = new Ypr( 1.592, 0.000, 0.000 );
		carPos[6] = new Vector3( 15.575, -0.400, -1.507 );
		carOri[6] = new Ypr( 1.592, 0.000, 0.000 );
		//carPos[11] = new Vector3( 15.975, -0.400, 1.875 );
		//carOri[11] = new Ypr( 1.592, 0.000, 0.000 );
		carPos[7] = new Vector3( 19.675, -0.400, 0.400 );
		carOri[7] = new Ypr( 0.000, 0.000, 0.000 );
		//carPos[13] = new Vector3( 15.975, -0.400, 4.475 );
		//carOri[13] = new Ypr( 1.592, 0.000, 0.000 );
		carPos[8] = new Vector3( 19.695, -0.400, 5.100 );
		carOri[8] = new Ypr( 0.000, 0.000, 0.000 );
		//carPos[15] = new Vector3( 19.655, -0.400, 9.900 );
		//carOri[15] = new Ypr( 0.000, 0.000, 0.000 );
		carPos[9] = new Vector3( 19.705, -0.400, 14.300 );
		carOri[9] = new Ypr( 0.000, 0.000, 0.000 );
		//carPos[17] = new Vector3( 18.600, -0.400, 21.050 );
		//carOri[17] = new Ypr( 0.000, 0.000, 0.000 );
		carPos[10] = new Vector3( 15.808, -0.400, 19.805 );
		carOri[10] = new Ypr( 0.000, 0.000, 0.000 );
		//carPos[19] = new Vector3( 16.820, -0.400, 15.305 );
		//carOri[19] = new Ypr( -3.000, 0.000, 0.000 );
		carPos[11] = new Vector3( 16.745, -0.400, 10.920 );
		carOri[11] = new Ypr( -2.850, 0.000, 0.000 );
		//carPos[21] = new Vector3( 15.840, -0.400, 7.375 );
		//carOri[21] = new Ypr( 1.592, 0.000, 0.000 );
		carPos[12] = new Vector3( 13.190, -0.400, 20.330 );
		carOri[12] = new Ypr( -3.000, 0.000, 0.000 );
		//carPos[23] = new Vector3( 10.590, -0.400, 20.420 );
		//carOri[23] = new Ypr( -2.900, 0.000, 0.000 );
		carPos[13] = new Vector3( 7.790, -0.400, 20.650 );
		carOri[13] = new Ypr( -2.900, 0.000, 0.000 );
		//carPos[25] = new Vector3( 4.790, -0.400, 20.650 );
		//carOri[25] = new Ypr( -2.900, 0.000, 0.000 );
		carPos[14] = new Vector3( 4.790, -0.400, 15.660 );
		carOri[14] = new Ypr( 0.010, 0.000, 0.000 );
		//carPos[27] = new Vector3( 7.790, -0.400, 15.660 );
		//carOri[27] = new Ypr( -2.900, 0.000, 0.000 );
		//carPos[15] = new Vector3( 10.590, -0.400, 15.665);
		//carOri[15] = new Ypr( -2.900, 0.000, 0.000 );
		//carPos[29] = new Vector3( 13.190, -0.400, 15.700 );
		//carOri[29] = new Ypr( -3.000, 0.000, 0.000 );
		carPos[14] = new Vector3( 13.390, -0.400, 10.780 );
		carOri[14] = new Ypr( -3.000, 0.000, 0.000 );
		//carPos[31] = new Vector3( 10.390, -0.400, 10.780 );
		//carOri[31] = new Ypr( 0.000, 0.000, 0.000 );
		carPos[15] = new Vector3( 7.790, -0.400, 10.780 );
		carOri[15] = new Ypr( 0.000, 0.000, 0.000 );
		//carPos[33] = new Vector3( 4.780, -0.400, 10.790 );
		//carOri[33] = new Ypr( 0.000, 0.000, 0.000 );
		//carPos[18] = new Vector3( -0.190, -0.400, 20.650 );
		//carOri[18] = new Ypr( 0.000, 0.000, 0.000 );
		//carPos[35] = new Vector3( -3.190, -0.400, 20.650 );
		//carOri[35] = new Ypr( 0.000, 0.000, 0.000 );
		//carPos[19] = new Vector3( -6.000, -0.400, 20.850 );
		//carOri[19] = new Ypr( -3.000, 0.000, 0.000 );
		//carPos[37] = new Vector3( -17.100, -0.400, 20.980 );
		//carOri[37] = new Ypr( -3.000, 0.000, 0.000 );
		//carPos[16] = new Vector3( -20.100, -0.400, 20.980 );
		//carOri[16] = new Ypr( 0.000, 0.000, 0.000 );
		//carPos[39] = new Vector3( -18.733, -0.400, 17.666 );
		//carOri[39] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[40] = new Vector3( -18.767, -0.400, 14.668 );
		//carOri[40] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[41] = new Vector3( -14.743, -0.400, 14.666 );
		//carOri[41] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[42] = new Vector3( -18.803, -0.400, 11.388 );
		//carOri[42] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[43] = new Vector3( -14.663, -0.400, 11.388 );
		//carOri[43] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[44] = new Vector3( -18.903, -0.400, 8.888 );
		//carOri[44] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[45] = new Vector3( -14.783, -0.400, 9.150 );
		//carOri[45] = new Ypr( -1.572, 0.000, 0.000 );
		//carPos[46] = new Vector3( -18.803, -0.400, 6.388 );
		//carOri[46] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[47] = new Vector3( -14.663, -0.400, 6.388 );
		//carOri[47] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[48] = new Vector3( -14.673, -0.400, -3.666 );
		//carOri[48] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[49] = new Vector3( -14.668, -0.400, -7.842 );
		//carOri[49] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[50] = new Vector3( -14.664, -0.400, -12.463 );
		//carOri[50] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[51] = new Vector3( -14.663, -0.400, -17.468 );
		//carOri[51] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[52] = new Vector3( -6.663, -0.400, -18.768 );
		//carOri[52] = new Ypr( -0.552, 0.000, 0.000 );
		//carPos[53] = new Vector3( -1.663, -0.400, -19.968 );
		//carOri[53] = new Ypr( 0.252, 0.000, 0.000 );
		//carPos[54] = new Vector3( 2.660, -0.400, -19.988 );
		//carOri[54] = new Ypr( 0.100, 0.000, 0.000 );
		//carPos[55] = new Vector3( 5.663, -0.400, -20.200 );
		//carOri[55] = new Ypr( -3.000, 0.000, 0.000 );
		//carPos[56] = new Vector3( -4.320, -0.400, -14.889 );
		//carOri[56] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[57] = new Vector3( -0.000, -0.400, -14.899 );
		//carOri[57] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[58] = new Vector3( 4.320, -0.400, -14.897 );
		//carOri[58] = new Ypr( -1.552, 0.000, 0.000 );
		//carPos[59] = new Vector3( 4.310, -0.400, -10.997 );
		//carOri[59] = new Ypr( -1.552, 0.000, 0.000 );
	}
}
