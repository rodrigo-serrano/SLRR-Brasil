package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.render.osd.dialog.*;	//Text
import java.sound.*;

public class MainMenu implements GameState
{
	MainMenuDialog mmd;

	final static public float Check( float key )
	{
		return Math.sqrt(key)+3.75;
	}

	public void enter( GameState prevState )
	{
		mmd = new MainMenuDialog();
		mmd.show();
/*
		System.log( "---------Started gametype scanning---------" );
		Dummy	d = new Dummy( GameType.WORLDTREEROOT );
		Viewport v = new Viewport( 100, 0.5, 0.5, 0.2, 4.0/3.0, -0.5, -0.5 );
		Camera c = new Camera( d, v, 2, 60, 1.0, 100.0 );
		c.setMatrix( new Vector3(0.0, 0.0, 10), null );
		v.activate( Viewport.RENDERFLAG_CLEARDEPTH | Viewport.RENDERFLAG_CLEARTARGET );

		GameRef parts;
		Vector stack = new Vector();
		stack.addElement( new GameRef( system:0x0001r ) );
		while( !stack.isEmpty() )
		{
			parts=stack.removeLastElement();

			if( parts.isScripted() )
			{
				if( parts.isScripted( "java.game.parts.Part" ) )	//alkatresz?
				{
					if( parts.id() != parts:0x0026r )
					{
						GameRef xa = new GameRef();
						Part gt = xa.create( d, new GameRef(parts.id()), "0,0,0,0,0,0", "part_created_by_debugtester" );
					}
				}
			}
			else
				if( !parts.isEmpty() )
				{
					GameRef xb = new GameRef();
					xb.create( d, new GameRef(parts.id()), "0,0,0,0,0,0", "gameinstance_created_by_debugtester" );
					xb.destroy();
				}

			if( parts=parts.getFirstChild() )
			{
				while( parts )
				{
					stack.addElement( parts );
					parts=parts.getNextChild();
				}
			}
		}
		System.log( "---------Finished gametype scanning---------" );
//*/
	}

	public void exit( GameState nextState )
	{
		mmd.hide();
		mmd = null;
	}
}


public class MainMenuDialog extends OptionsDialog
{
	// commands
	final static int	CMD_NEW = 50;
	final static int	CMD_EXIT = 51;
	final static int	CMD_LOAD = 52;
	final static int	CMD_BACKTOGARAGE = 53;
	final static int	CMD_COMPILEFILES = 58;
	final static int	CMD_LOADCAR = 60;
	final static int	CMD_SAVECAR = 61;
	
	//Run Track Selector, FreeRide mode
	final static int	CMD_TRACKSELECT = 63;
	
	//Car Selector:
	final static int	CMD_MENUCAR = 64;
	final static int	CMD_CAROK = 65;
	final static int	CMD_ABOUT = 66;
	final static int	CMD_LIGHTS = 67;
	final static int	CMD_MENUCAREXIT = 68;
	final static int	CMD_RANDOMCAR = 69;
	final static int	CMD_AMBULANCE = 70;
	final static int	CMD_ARMOREDVAN = 71;
	final static int	CMD_BADGE = 72;
	final static int	CMD_CIVILVAN = 73;
	final static int	CMD_COACH = 74;
	final static int	CMD_ERBILAC = 75;
	final static int	CMD_FIREENGINE = 76;
	final static int	CMD_NINJA = 77;
	final static int	CMD_POLICE = 78;
	final static int	CMD_SCHOOLBUS = 79;
	final static int	CMD_STALLION = 80;
	final static int	CMD_SUNSET = 81;
	final static int	CMD_TAXI = 82;
	final static int	CMD_TEG = 83;
	final static int	CMD_WAGON = 84;

	//Driver Selector:
	final static int	CMD_MENUDRIVER = 85;
	final static int	CMD_DRIVEROK = 86;
	final static int	CMD_DRIVER0 = 87;
	final static int	CMD_DRIVER1 = 88;
	final static int	CMD_DRIVER2 = 89;
	final static int	CMD_DRIVER3 = 90;
	final static int	CMD_DRIVER4 = 91;
	final static int	CMD_DRIVER5 = 92;
	final static int	CMD_DRIVER6 = 93;
	final static int	CMD_DRIVER7 = 94;
	final static int	CMD_DRIVER8 = 95;
	final static int	CMD_DRIVER9 = 96;
	final static int	CMD_DRIVER10 = 97;
	final static int	CMD_DRIVER11 = 98;

	final static int	bgVideoActive, CarRotate;

	//osd background renderer variables
	RenderRef		DriverRender; //For Driver Selector
	RenderRef		bgSun, DSun, CSun;
	RenderRef		bgSky;
	GameRef			bgScene, CarScene, DriverScene;
	Vehicle			bgVehicle;
	Camera			bgCam, CarCam, DriverCam;
	float			bgCamAngle, CarCamAngle;	//simple circling method
	Pori			bgCamPori;					//path following method
	Pori			bgCamSpeed;
	Pori			bgCamSpeedDest;
	Pori[]			bgCamPath;
	int				bgCamPathIndex;
	float			bgCamDestDistance;

	Text			careerHeader;

	Button			saveCarButton, backGarageButton, TakeItButton, SelectDriverButton;

	//New groups:
	int				CarGroup;
	int				DriverGroup;

	Style butt3 = new Style( 0.45, 0.08, Frontend.mediumFont, Text.ALIGN_CENTER, Osd.RRT_TEST );
	Style butt4 = new Style( 0.45, 0.05, Frontend.smallFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );
	Style butt5 = new Style( 0.45, 0.05, Frontend.smallFont, Text.ALIGN_LEFT, Osd.RRT_TEST );

	public MainMenuDialog()
	{
		super(0);
	}

	public void show()
	{
		float key = Math.random()*100;
		if( TrackSelect.Check(key) != Math.sqrt(key)+3.75 ) Mirans_Mod_protection_error______Please_Resintal_Mirans_Mod();

		float key2 = Math.random()*100;
		if( Garage.Check(key2) != Math.sqrt(key2)+3.75 ) Mirans_Mod_protection_error______Please_Resintal_Mirans_Mod();

		float key3 = Math.random()*100;
		if( Track.Check(key3) != Math.sqrt(key3)+3.75 ) Mirans_Mod_protection_error______Please_Resintal_Mirans_Mod();

		GameLogic.klampiPatch=0;

		Sound.changeMusicSet( Sound.MUSIC_SET_MENU );

		osd.createText( "Street Legal Racing Redline", Frontend.mediumFont, Text.ALIGN_CENTER, 0.0, -0.995 );

		osd.createText( "Brazilian" + " Edition", Frontend.smallFont, Text.ALIGN_CENTER, 0.0, -0.945 );
		osd.endGroup();

		//osd background renderer setup
		bgScene = new GroundRef( Maps.Addon_Maps.Home:0x00000001r );
		bgScene.setFog( 0xFF07121e, 2.0, 100.0 );
		bgCam = new Camera( bgScene, osd.getViewport(), 0 );

		RenderRef suntype = new RenderRef(maps.skydome:0x0024r);
		suntype.setLight( 0x00EDC6A4, 0x00646464, 0x00C8C8C8);
		bgSun = new RenderRef( bgScene, suntype, "menu_bgSun" );
		bgSky = new RenderRef( bgScene, maps.skydome:0x0023r, "egbolt-night_02" );
		GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x0035r ));
		
			
		if( Vehicle.load( GameLogic.carSaveDir + "Menu", bgScene ) )
			{
			bgVehicle = Vehicle.load( GameLogic.carSaveDir + "Menu", bgScene );
			bgVehicle.command( "reset" );
			bgVehicle.command( "setsteer -0.2" ); 
			bgVehicle.wakeUp();
			}
			else
			{
			bgVehicle = new Vehicle( bgScene, cars:0x0000r, 1, 1.0, 0.0, 1.0, 1.0 );
			bgVehicle.command( "reset" );
			bgVehicle.command( "setsteer -0.2" ); 
			bgVehicle.wakeUp();
			}

		//vhc & route setup
		bgVehicle.setMatrix( new Vector3(0,0,0), new Ypr(0,0,0) );

		bgCamPath = new Pori[28];
		bgCamPath[0] = new Pori( new Vector3(-1.886, 0.483, -2.086), new Ypr(-1.904,	0.014,	0.000) );
		bgCamPath[1] = new Pori( new Vector3(-1.933, 0.636, -1.248), new Ypr(-1.637,	0.000,	0.000) );
		bgCamPath[2] = new Pori( new Vector3(-1.982, 0.870, -0.476), new Ypr(-1.723,	-0.008,	0.000) );
		bgCamPath[3] = new Pori( new Vector3(-1.963, 0.996, 0.391), new Ypr(-1.353,		-0.088,	0.000) );
		bgCamPath[4] = new Pori( new Vector3(-1.941, 0.603, 1.013), new Ypr(-1.428,		-0.175,	0.000) );
		bgCamPath[5] = new Pori( new Vector3(-1.933, 0.269, 1.435), new Ypr(-1.325,		0.099,	0.000) );
		bgCamPath[6] = new Pori( new Vector3(-2.117, 0.273, 2.010), new Ypr(-1.118,		0.108,	0.000) );
		bgCamPath[7] = new Pori( new Vector3(-1.868, 0.290, 2.449), new Ypr(-0.927,		0.103, 0.000) );
		bgCamPath[8] = new Pori( new Vector3(-1.373, 0.275, 2.585), new Ypr(-0.700,		0.124, 0.000) );
		bgCamPath[9] = new Pori( new Vector3(-1.871, 0.258, 2.580), new Ypr(-0.409,		0.291, 0.000) );
		bgCamPath[10] = new Pori( new Vector3(1.156, 0.266, 2.442), new Ypr(0.851,		-0.103, 0.000) );
		bgCamPath[11] = new Pori( new Vector3(1.308, 0.297, 1.894), new Ypr(0.986,		-0.115, 0.000) );
		bgCamPath[12] = new Pori( new Vector3(1.577, 0.939, 1.532), new Ypr(1.042,		-0.112, 0.000) );
		bgCamPath[13] = new Pori( new Vector3(1.919, 0.932, 1.225), new Ypr(1.106,		-0.154, 0.000) );
		bgCamPath[14] = new Pori( new Vector3(2.084, 0.986, 0.687), new Ypr(1.130,		-0.154, 0.000) );
		bgCamPath[15] = new Pori( new Vector3(2.098, 0.953, 0.086), new Ypr(1.187,		-0.104, 0.000) );
		bgCamPath[16] = new Pori( new Vector3(2.088, 0.923, -0.505), new Ypr(1.406,		-0.180, 0.000) );
		bgCamPath[17] = new Pori( new Vector3(2.051, 0.920, -1.030), new Ypr(1.512,		-0.150, 0.000) );
		bgCamPath[18] = new Pori( new Vector3(2.015, 0.959, -1.509), new Ypr(1.674,		-0.141, 0.000) );
		bgCamPath[19] = new Pori( new Vector3(2.048, 0.938, -1.984), new Ypr(1.758,		-0.130, 0.000) );
		bgCamPath[20] = new Pori( new Vector3(2.015, 0.810, -2.384), new Ypr(1.884,		-0.274, 0.000) );
		bgCamPath[21] = new Pori( new Vector3(1.762, 0.727, -2.636), new Ypr(1.954,		-0.243, 0.000) );
		bgCamPath[22] = new Pori( new Vector3(1.411, 0.679, -2.785), new Ypr(2.223,		-0.195, 0.000) );
		bgCamPath[23] = new Pori( new Vector3(1.029, 0.683, -2.854), new Ypr(2.873,		-0.196, 0.000) );
		bgCamPath[24] = new Pori( new Vector3(-0.969, 0.704, -2.836), new Ypr(3.066,	-0.197, 0.000) );
		bgCamPath[25] = new Pori( new Vector3(-1.367, 0.742, -2.757), new Ypr(2.900,	-0.200, 0.000) );
		bgCamPath[26] = new Pori( new Vector3(-1.699, 0.704, -2.534), new Ypr(2.531,	-0.246, 0.000) );
		bgCamPath[27] = new Pori( new Vector3(-1.886, 0.483, -2.086), new Ypr(0.000,	0.000, 0.000) );
		//

		super.show();

		changeMode (mainGroup);
	}

	public void hide()
	{
		super.hide();

		//osd background renderer cleanup
		if( bgVideoActive )
			GfxEngine.closeVideo();
		else
			bgCam = null;
	}

	public void addCustomGroups()
	{
		Menu	m;

		//--------------main menu--------------
		osd.createBG( RID_GENERALBG );
		
		m = osd.createMenu( butt3, -0.83, 0.95, 0.415, Osd.MD_HORIZONTAL );
		Gadget g;

		g = m.addItem( "Nova Campanha", CMD_NEW );
		g = m.addItem( "Carregar Campanha", CMD_LOAD );
		backGarageButton = g = m.addItem( "Voltar Para Garagem", CMD_BACKTOGARAGE );
		g = m.addItem( "Carregar Carro", CMD_LOADCAR );
		saveCarButton = g = m.addItem( "Salvar Carro", CMD_SAVECAR );

		m = osd.createMenu( butt4, 0.99, -0.975, 0.042, Osd.MD_VERTICAL );
		Gadget h;
		h = m.addItem( "Opcoes", CMD_OPTIONS );
		h = m.addItem( "Sair", CMD_EXIT );

		m = osd.createMenu( butt5, -0.99, -0.975, 0.042, Osd.MD_VERTICAL );
		Gadget i;
		g = m.addItem( "Selecionar Carro", CMD_MENUCAR );
		g = m.addItem( "Selecionar Pista", CMD_TRACKSELECT );

		//m = osd.createMenu( butt1, 0.0, 0.9, 0 );
		//g = m.addItem( "DEBUG COMPILE ALL JAVAs", CMD_COMPILEFILES );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_EXIT, this );
		osd.hideGroup( mainGroup = osd.endGroup() );

		//--------------Traffic car select menu--------------
		
		osd.hideGroup( CarGroup = osd.beginGroup() );

		osd.createBG( RID_GENERALBG );
		osd.createHeader( "Selecionar Carro" );

		m = osd.createMenu( butt0, -0.98, -0.45, 0 );
		m.addItem( "Ambulancia", CMD_AMBULANCE );
		m.addItem( "Carro Blindado", CMD_ARMOREDVAN );
		m.addItem( "Badge", CMD_BADGE );
		m.addItem( "Civil Van", CMD_CIVILVAN );
		m.addItem( "Coach", CMD_COACH );
		m.addItem( "Erbilac", CMD_ERBILAC );
		m.addItem( "Caminhao Bombeiros", CMD_FIREENGINE );
		m.addItem( "Ninja", CMD_NINJA );

		m = osd.createMenu( butt2, 0.98, -0.45, 0 );
		m.addItem( "Policia", CMD_POLICE );
		m.addItem( "Onibus Escolar", CMD_SCHOOLBUS );
		m.addItem( "Stallion", CMD_STALLION );
		m.addItem( "Sunset", CMD_SUNSET );		
		m.addItem( "Taxi", CMD_TAXI );
		m.addItem( "Teg", CMD_TEG );
		m.addItem( "Wagon", CMD_WAGON );
		m.addItem( "Carro Random", CMD_RANDOMCAR );

		m = osd.createMenu( butt0, -0.98, 0.85, 0 );
		m.addItem( "Voltar", CMD_MENUCAREXIT );

		m = osd.createMenu( butt1, 0.00, 0.85, 0 );
		m.addItem( "Luzes ON/OFF", CMD_LIGHTS );

		m = osd.createMenu( butt1, 0.00, -0.83, 0 );
		SelectDriverButton = 
		m.addItem( "Selecionar Motorista", CMD_MENUDRIVER );

		m = osd.createMenu( butt2, 0.98, -0.83, 0 );
		m.addItem( "Informacoes", CMD_ABOUT );

		m = osd.createMenu( butt2, 0.98, 0.85, 0 );
		TakeItButton = 
		m.addItem( "Correr", CMD_CAROK );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MENUCAREXIT, this );

		osd.endGroup();
		//---------------------Driver Slelctor menu-------------------

		osd.hideGroup( DriverGroup = osd.beginGroup() );
	
		osd.createBG( RID_GENERALBG );
		osd.createHeader( "Selecionar Motorista" );

		m = osd.createMenu( butt2, 0.98, -0.83, 0 );
		m.addItem( "Informacoes", CMD_ABOUT );

		m = osd.createMenu( butt0, -0.98, -0.65, 0 );
		m.addItem( "Invisivel", CMD_DRIVER0 );
		m.addItem( "Jessy James", CMD_DRIVER5, "From Monster Garage" );
		m.addItem( "Mitch Whole", CMD_DRIVER1, "Default Driver" );
		m.addItem( "Oponente 1", CMD_DRIVER2 );
		m.addItem( "Oponente 2", CMD_DRIVER3 );
		m.addItem( "Policial", CMD_DRIVER4 );

		m.addItem( "Corredor Profissinal", CMD_DRIVER6, "By GameRED" );
		m.addItem( "Tommy Vercetti", CMD_DRIVER7, "By Miran" );
		m.addItem( "Common Guy", CMD_DRIVER8, "By Gruchowski" );
		m.addItem( "Elegant racer", CMD_DRIVER9, "By Lokerlol" );
		m.addItem( "Rambo Ziom", CMD_DRIVER10, "By Lokerlol" );
		m.addItem( "Idler style", CMD_DRIVER11, "By Lokerlol" );

		m = osd.createMenu( butt2, 0.98, 0.85, 0 );
		m.addItem( "OK", CMD_DRIVEROK );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_DRIVEROK, this );

		osd.endGroup();
	}
	public void osdCommand (int command)
	{
		if (command < 0)
			return;
		else
		if (command == CMD_AMBULANCE)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.traffic.Ambulance:0x0006r, 1, 1.0, 0.0, 1.0, 1.0 );
			//player.car.setMatrix( new Vector3(0,0,0), new Ypr(-0.01f+System.currentTime()*1.02f,0,0) );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" ); 
		}
		else
		if (command == CMD_ARMOREDVAN)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car

			player.car.destroy();
			player.car = new Vehicle( CarScene, cars.traffic.ArmoredVan:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_BADGE)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			player.car = new Vehicle ( CarScene, cars.fake_racers.Badge:0x00000006r, 0, 0, 0, 0, 0.);

			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_CIVILVAN)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car

			player.car = new Vehicle( CarScene, cars.traffic.CIVILVAN:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );

		}
		else
		if (command == CMD_COACH)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.traffic.Coach:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_ERBILAC)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.traffic.Erbilac:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_FIREENGINE)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.traffic.FireEngine:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_NINJA)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car

			player.car = new Vehicle( CarScene, cars.fake_racers.Ninja:0x0006r, 6, 2.5, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_POLICE)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.enable();
			
			player.car = new Vehicle( CarScene, cars.Misc.Police:0x0006r, 0, 0.0, 0.0, 0.0, 0.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
			player.driverID = humans:0x0000000Cr ;
		}
		else
		if (command == CMD_SCHOOLBUS)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.Traffic.Schoolbus:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_STALLION)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.fake_racers.Stallion:0x0006r, 6, 2.5, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_SUNSET)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.fake_racers.Sunset:0x0006r, 6, 2.5, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_TAXI)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.traffic.Taxi:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_TEG)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.fake_racers.Teg:0x0006r, 6, 2.5, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_WAGON)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.disable();
			player.driverID = NoDriver:0x0000000Cr ; //No driver in this car
			
			player.car = new Vehicle( CarScene, cars.traffic.Wagon:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
		}
		else
		if (command == CMD_RANDOMCAR)
		{	
			player.car.destroy();
			TakeItButton.enable();
			SelectDriverButton.enable();

			VehicleDescriptor vd = GameLogic.getVehicleDescriptor( VehicleType.VS_DEMO );
			player.car = new Vehicle( CarScene, vd.id, vd.colorIndex, vd.optical, vd.power, vd.wear, vd.tear );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
			player.driverID = humans:0x0000000Cr ;
		}
		else
		if (command == CMD_CAROK)
		{
			//player.car.wakeUp(); //Spada
			//Thread.sleep( 1000 ); //Czeka chwile
			Frontend.loadingScreen.show();
			GameLogic.gameMode = GameLogic.GM_SINGLECAR;;
			GameLogic.setTime( (Math.random()*14+4)*3600 );
			player.money = 0;
			GameLogic.changeActiveSection (GameLogic.garage);
			CarScene.destroy();
		}
		else
        if (command == CMD_TRACKSELECT)
        {
			if( GameLogic.autoSave() )
			{
				GameLogic.loadDefaults();
				GameLogic.gameMode = GameLogic.GM_FREERIDE;
				GameLogic.setTime( (Math.random()*14+4)*3600 );
				
				if (!player.car)
				{
					VehicleDescriptor vd = GameLogic.getVehicleDescriptor( VehicleType.VS_DEMO );
					player.car = new Vehicle( player, vd.id, vd.colorIndex, vd.optical, vd.power, vd.wear, vd.tear );
				}

				GameLogic.changeActiveSection( new TrackSelect() );
			}
		} 
		else
		if (command == CMD_LIGHTS)
		{
			player.car.command( "reset" );
			GameLogic.spendTime( 12*3600 );
			player.car.command( "idle" );
		}
		else
		if (command == CMD_ABOUT)
		{
			new WarningDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.DF_WIDE, "Informacoes", "Slrr Brasil V13! \n \n By DHVB" ).display();
		}
		else
		if( command == CMD_MENUCAR )
		{
			GameLogic.changeActiveSection( new CarSelect() );
			/*if( bgVideoActive = (GfxEngine.openVideo("data\\fmv\\prime.avi", 1, 1 )==0) )
			{
			}
			else
			{
				bgVehicle.destroy();
			}
				if( GameLogic.autoSave() )
				changeMode( CarGroup );
				backGarageButton.disable();
				TakeItButton.disable();
				SelectDriverButton.disable();
				GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x0035r ));
				GameLogic.setTime(0); //Set Time 0.00 a.m

			CarScene = new Dummy( WORLDTREEROOT );
			CarCam = new Camera( CarScene, osd.getViewport(), 0 );

				player.car = new Vehicle( CarScene, Empty:0x0006r, 6, 2.0, 0.0, 1.0, 1.0 );
			
			RenderRef CarSun = new RenderRef(maps.skydome:0x0024r);
			CarSun.setLight( 0x00DC6464, 0x00646464, 0x00C8C8C8);
			CSun = new RenderRef( CarScene, CarSun, "Sun for Car Men" );
		}
		else
		if( command == CMD_MENUCAREXIT )
		{
		if( bgVideoActive = (GfxEngine.openVideo("data\\fmv\\prime.avi", 1, 1 )==0) )
		{
		}
		else
		{
			bgVehicle = new Vehicle( bgScene, cars.racers.prime:0x0006r, 1, 1.0, 0.0, 1.0, 1.0 ); //1.0, 1.0, 1.0, 1.0, 1.0 );
			bgVehicle.command( "reset" );
			bgVehicle.command( "setsteer -0.6" ); 
		}
			changeMode( mainGroup );
			backGarageButton.disable();
			CarScene.destroy();
		}
		else
		if( command == CMD_MENUDRIVER )
		{
			changeMode( DriverGroup );

		super.show();

		DriverScene = new Dummy( WORLDTREEROOT );
		DriverCam = new Camera( DriverScene, osd.getViewport(), 0 );
		DriverCam.setMatrix( new Vector3(-2.6,0.0,-2.2), new Ypr(-2.0,0,0) );

		RenderRef DriverSun = new RenderRef(maps.skydome:0x0024r);
		DriverSun.setLight( 0x00DC6464, 0x00646464, 0x00C8C8C8);
		DSun = new RenderRef( DriverScene, DriverSun, "menu_bgSun" );

		DriverRender = new RenderRef( DriverScene, humans:0x0000000Cr, "DriverRender" );
		player.driverID = humans:0x0000000Cr ;
*/
		}
		else
		if (command == CMD_DRIVEROK)
		{
			changeMode( CarGroup );
			player.car.setMatrix( new Vector3(0,0,0), new Ypr(0,0,0) );
			player.car.command( "reset" );
			player.car.command( "idle" );
			player.car.command( "setsteer -0.6" );
			DriverScene.destroy();
		}
		else
		if (command == CMD_DRIVER0)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, NoDriver:0x0000000Cr, "No Driver" );
			player.driverID = NoDriver:0x0000000Cr ;
		}
		else
		if (command == CMD_DRIVER1)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, humans:0x0000000Cr, "Default driver" );
			player.driverID = humans:0x0000000Cr ;
		}
		else
		if (command == CMD_DRIVER2)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, humans:0x00000007r, "Opponent 1" );
			player.driverID = humans:0x00000007r ;
		}
		else
		if (command == CMD_DRIVER3)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, humans:0x00000008r, "Opponent 2" );
			player.driverID = humans:0x00000008r ;
		}
		else
		if (command == CMD_DRIVER4)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, humans:0x00000018r, "Policeman" );
			player.driverID = humans:0x00000018r ;
		}
		else
		if (command == CMD_DRIVER5)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, MW_Mod:0x00000022r, "MG Jessy James" );
			player.driverID = MW_Mod:0x00000022r ;
		}
		else
		if (command == CMD_DRIVER6)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, MW_Mod:0x00000059r, "Proffesional racer" );
			player.driverID = MW_Mod:0x00000059r ;
		}
		else
		if (command == CMD_DRIVER7)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, MW_Mod:0x00000057r, "Tommy Vercetti" );
			player.driverID = MW_Mod:0x00000057r ;
		}
		else
		if (command == CMD_DRIVER8)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, MW_Mod:0x00000061r, "Common Guy" );
			player.driverID = MW_Mod:0x00000061r ;
		}
		else
		if (command == CMD_DRIVER9)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, MW_Mod:0x00000063r, "Elegant" );
			player.driverID = MW_Mod:0x00000063r ;
		}
		else
		if (command == CMD_DRIVER10)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, MW_Mod:0x00000065r, "Rambo" );
			player.driverID = MW_Mod:0x00000065r ;
		}
		else
		if (command == CMD_DRIVER11)
		{
			DriverRender.destroy();
			DriverRender = new RenderRef( DriverScene, MW_Mod:0x00000067r, "Idler" );
			player.driverID = MW_Mod:0x00000067r ;
		}
		else
		if (command == CMD_LOADCAR)
		{
			if( GameLogic.autoSave() )
			{
				VehicleFileReqDialog d = new VehicleFileReqDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Carregar Carro", "Carregar Carro", GameLogic.carSaveDir, "*" );
				if( d.display() == 0 )
				{
					String filename = GameLogic.carSaveDir + d.fileName;

					Frontend.loadingScreen.show();

					GameLogic.loadDefaults();

					GameLogic.gameMode = GameLogic.GM_SINGLECAR;

					player.car = Vehicle.load( filename, player );

					player.money = 1000000;

					GameLogic.changeActiveSection (GameLogic.garage);
				}

			}
		}
		else
		if (command == CMD_SAVECAR)
		{
			VehicleFileReqDialog d = new VehicleFileReqDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.FRF_SAVE, "Salvar Carro", "Salvar Carro", GameLogic.carSaveDir, "*" );

			if( d.display() == 0 )
			{
				String filename = GameLogic.carSaveDir + d.fileName;
				if (File.exists(filename))
				{
					File.delete( filename );
					File.delete( filename + ".*" );
				}

				player.car.save( filename );
				new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Salvar Carro", "Seu Carro Atual Foi Salvo." ).display();
			}
		}
		else
        if (command == CMD_COMPILEFILES)
        {
			System.compileAll( "." );
			new SfxRef( Frontend.SFX_WARNING ).play(); 
		}
		else
		if (command == CMD_NEW)
		{
			if( GameLogic.autoSave() )
			{
				StringRequesterDialog d = new StringRequesterDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.SIF_NOEMPTY, "Digite Seu Nome", "" );
				if( d.display() == 0 )
				{
					player.name = d.input;

					new PlayerSetupDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Escolha Seu Personagem", player ).display();

					Frontend.loadingScreen.show();
					GameLogic.loadDefaults();

					GameLogic.carrerInProgress = 1;
					GameLogic.autoSaveQuiet();

					GameLogic.changeActiveSection (GameLogic.garage);
				}
			}
		}
		else
		if (command == CMD_LOAD)
		{
			CarrerFileReqDialog d = new CarrerFileReqDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Carregar Campanha", "Carregar Campanha", GameLogic.carrerSaveDir, "*", FindFile.DIRS_ONLY );

			if( d.display() == 0 )
			{
				String filename = GameLogic.carrerSaveDir + d.fileName;

				int currentCarreer = 0;

				if( currentCarreer )
				{
					new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Carregar Campanha", "Essa Campanha Ja Esta Carregada." ).display();
				}
				else
				{
					if( GameLogic.autoSave() )
					{
						Frontend.loadingScreen.show();

						int error = GameLogic.load( filename + "/" );
						if( !error )
						{
							GameLogic.carrerInProgress = 1;
							GameLogic.changeActiveSection (GameLogic.garage);
						}
						else
						{
							// give warning sound & text
							new SfxRef( Frontend.SFX_WARNING ).play(); 
							Frontend.loadingScreen.hide();
							new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Aviso", "Save Corrupto. \n Carregamento Cancelado." ).display();
							GameLogic.erase();	//ki tudja, mi szemetet hagyot bent?
						}
					}
				}
			}
		}
		else
		if (command == CMD_DELETE)
		{
			CarrerFileReqDialog d = new CarrerFileReqDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Deletar Campanha", "Deletar Campanha", GameLogic.carrerSaveDir, "*", FindFile.DIRS_ONLY );

			if( d.display() == 0 )
			{
				String filename = GameLogic.carrerSaveDir + d.fileName;

				int currentCarreer = 0;
				int reallyDelete;

				if( currentCarreer )
					reallyDelete = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Deletar Campanha", "Deseja Deletar A Campanha Atual?" ).display() );
				else
					reallyDelete = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Deletar Campanha", "Deseja Continuar?" ).display() );

				if( reallyDelete )
				{
					if( currentCarreer )
					{
						GameLogic.erase();
						backGarageButton.disable();
					}

					File.delete( filename + "/", "*" );
					File.delete( filename );
				}
			}
		}
		else
		if (command == CMD_BACKTOGARAGE)
		{
			GameLogic.changeActiveSection (GameLogic.garage);
		}
		else
		if (command == CMD_EXIT)
		{
			int reallyExit;
			int	carreerMode = ( GameLogic.gameMode == GameLogic.GM_CARREER && GameLogic.carrerInProgress );

			if( carreerMode )
				reallyExit = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Sair", "Deseja Mesmo Sair? \n \n Sua Campanha Sera Salva Automaticamente." ).display() );
			else
				reallyExit = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Sair", "Deseja Mesmo Sair?" ).display() );

			if( reallyExit )				
			{
				if( carreerMode )
					GameLogic.autoSaveQuiet();

				GameLogic.changeActiveSection( null );
			}
		}
		else
			super.osdCommand( command );
	}

	public void changeMode(int group)
	{
		super.changeMode( group );

		if( actGroup == mainGroup )
		{
			if( (GameLogic.gameMode == GameLogic.GM_CARREER || GameLogic.gameMode == GameLogic.GM_SINGLECAR) && GameLogic.player.car )
				saveCarButton.enable();
			else
				saveCarButton.disable();

			if( GameLogic.played )
			{
				//saveButton.enable();
				backGarageButton.enable();
			}
			else
			{
				//saveButton.disable();
				backGarageButton.disable();
			}
		}
	}


	public void animate()
	{
		if (actGroup == CarGroup)
		{
			//CarCamAngle+=0.003;
			Ypr CarYpr = new Ypr( -0.01f+System.currentTime()*0.5f,-0.15,0 ); 
			//Ypr CarYpr = new Ypr( CarCamAngle, 0.0, 0.0 );
			Vector3 CarVector = new Vector3( 0.0, 1.2, 8.5 );
			CarVector.rotate( CarYpr );
			CarYpr.p = -0.23;
			CarCam.setMatrix( CarVector, CarYpr );
		}
		else
		if( !bgVideoActive )
		{
			//osd background renderer

			/*//circling method
			bgCamAngle+=0.001;
			Ypr rot = new Ypr( bgCamAngle, 0.0, 0.0 );
			Vector3 v = new Vector3( 0.0, 1.5, 5 );
			v.rotate( rot );
			rot.p = -0.2;
			bgCam.setMatrix( v, rot );*/
			
			//path following method
			float distance;
			if( bgCamPori )
				distance = new Vector3().diff( bgCamPath[bgCamPathIndex].pos, bgCamPori.pos ).length();
			else
			{
				bgCamPori = new Pori( bgCamPath[0] );
				bgCamSpeed = new Pori();
			}

			if( bgCamDestDistance <= distance )
			{	//mar nem kozeledunk!!
				bgCamPathIndex = ++bgCamPathIndex % bgCamPath.length;
				bgCamSpeedDest = new Pori().diff( bgCamPath[bgCamPathIndex], bgCamPori ).mul( 0.001 );
				bgCamDestDistance = 1000000.0;
			}
			else
				bgCamDestDistance = distance;

			bgCamSpeed = bgCamSpeed.mul(0.97).add( new Pori(bgCamSpeedDest).mul(0.03) );
			bgCamPori.add( bgCamSpeed );
			bgCam.setMatrix( bgCamPori );
		}
		super.animate();
	}
}


public class PlayerSetupDialog extends Dialog
{
	final static int CMD_NEXT = 100;
	final static int CMD_PREV = 101;
	final static int CMD_HNEXT = 102;
	final static int CMD_HPREV = 103;

	Player plr;
	int	startId = Racer.RID_FEJ, numId = 60, actId = startId + Math.random()*(60-1);
	Rectangle rect;

	public PlayerSetupDialog( Controller ctrl, int myFlags, String myTitle, Player player )
	{
		super( ctrl, myFlags|DF_DARKEN, myTitle, "OK" );
		plr = player;
	}

	public void show()
	{
		Style btn1 = new Style( 0.10, 0.10, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( Osd.RID_ARROWLF ) );
		osd.createButton( btn1,-0.60, 0.40, CMD_PREV, null );
		Style btn2 = new Style( 0.10, 0.10, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( Osd.RID_ARROWRG ) );
		osd.createButton( btn2, 0.60, 0.40, CMD_NEXT, null );

		osd.createHotkey( Input.AXIS_MENU_LEFT, Input.VIRTUAL, CMD_HPREV, this );
		osd.createHotkey( Input.AXIS_MENU_RIGHT, Input.VIRTUAL, CMD_HNEXT, this );

		osd.createText( plr.name, Frontend.mediumFont, Text.ALIGN_CENTER, 0.00, 0.60 ).changeColor( 0xFFAAAAAA );

		plr.character = new ResourceRef( actId );
		rect = osd.createRectangle( 0.0, 0.04, 0.80, 1.45, 1, plr.character );

		super.show();
	}

	public void	osdCommand( int cmd )
	{
		if( cmd==CMD_HPREV )
		{
			osd.changeSelection2( 2, 0 );
			osd.changeSelection2( 2, 1 );
			osdCommand( CMD_PREV );
		}
		else
		if( cmd==CMD_HNEXT )
		{
			osd.changeSelection2( 3, 0 );
			osd.changeSelection2( 3, 1 );
			osdCommand( CMD_NEXT );
		}
		else
		if( cmd==CMD_PREV )
		{
			if( actId > startId )
				actId--;
			else
				actId = startId+numId-1;

			refreshCharacter();
		}
		else
		if( cmd==CMD_NEXT )
		{
			if( actId < startId+numId-1 )
				actId++;
			else
				actId = startId;

			refreshCharacter();
		}
		else
			super.osdCommand( cmd );
	}

	public void refreshCharacter()
	{
		plr.character = new ResourceRef( actId );
		rect.changeTexture( plr.character );
	}
}

class VehicleFileReqDialog extends FileRequesterDialog
{
	public VehicleFileReqDialog( Controller ctrl, int myflags, String mytitle, String OKButtonText, String path, String mask )
	{
		super( ctrl, myflags, mytitle, OKButtonText, path, mask );
		if( myflags & FRF_SAVE )
			osd.defSelection = 5;
	}

	public int validator( String filename )
	{
		return Vehicle.fileCheck( filename );
	}
}

class CarrerFileReqDialog extends FileRequesterDialog
{
	public CarrerFileReqDialog( Controller ctrl, int myflags, String mytitle, String OKButtonText, String path, String mask, int ffFlags )
	{
		super( ctrl, myflags, mytitle, OKButtonText, path, mask, ffFlags );
	}

	public int validator( String filename )
	{
		return GameLogic.fileCheck( filename );
	}
}


