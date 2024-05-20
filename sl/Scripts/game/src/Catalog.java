package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;
import java.render.osd.*;
import java.render.osd.dialog.*;
import java.sound.*;

import java.game.parts.*;
import java.game.parts.bodypart.*;
import java.game.parts.rgearpart.reciprocatingrgearpart.*;

public class Catalog extends GameType implements GameState
{
	final static ResourceRef RR_ICON_CAR_COMP = new ResourceRef( misc.catalog:0x0004r );
	final static ResourceRef RR_ICON_CAR_1STEP = new ResourceRef( misc.catalog:0x0005r );
	final static ResourceRef RR_ICON_INV_COMP = new ResourceRef( misc.catalog:0x0007r );


	final static int DECALPRICE = 20;

	final static int SC_ENGINE	= 0;
	final static int SC_BODY	= 1;
	final static int SC_RGEAR	= 2;
	final static int SC_NONE	= 3;	//max+1

	final static int CMD_EXIT  = 0;
	final static int CMD_FRONTPAGE = 1;
	final static int CMD_MAIN1 = 2;
	final static int CMD_MAIN2 = 3;
	final static int CMD_MAIN3 = 4;
	final static int CMD_MAIN4 = 5;
	final static int CMD_MAIN5 = 6;
	final static int CMD_MAIN6 = 7;

	final static int CMD_MAIN1_1 = 8;
	final static int CMD_MAIN1_2 = 9;
	final static int CMD_MAIN1_3 =10;
	final static int CMD_MAIN1_4 =11;
	final static int CMD_MAIN1_5 =12;
	final static int CMD_MAIN1_6 =13;
	final static int CMD_MAIN1_7 =14;
	final static int CMD_MAIN1_8 =15;
	final static int CMD_MAIN1_9 =16;
	final static int CMD_MAIN1_10 =17;
	final static int CMD_MAIN1_11 =18;
	final static int CMD_MAIN1_12 =19;
	final static int CMD_MAIN1_13 =20;
	final static int CMD_MAIN1_14 =21;
	final static int CMD_MAIN1_15 =22;
	final static int CMD_MAIN1_16 =23;
	final static int CMD_MAIN1_17 =24;
	final static int CMD_MAIN1_18 =25;
	final static int CMD_MAIN1_19 =26;

	final static int CMD_MAIN2_1 =27;
	final static int CMD_MAIN2_2 =28;
	final static int CMD_MAIN2_3 =29;
	final static int CMD_MAIN2_4 =30;
	final static int CMD_MAIN2_5 =31;
	final static int CMD_MAIN2_6 =32;
	final static int CMD_MAIN2_7 =33;

	final static int CMD_MAIN3_1 =34;
	final static int CMD_MAIN3_2 =35;
	final static int CMD_MAIN3_3 =36;
	final static int CMD_MAIN3_4 =37;
	final static int CMD_MAIN3_6 =38;
	final static int CMD_MAIN3_7 =39;
	final static int CMD_MAIN3_8 =40;

	//Rims
	final static int CMD_MAIN3_9 =41;
	final static int CMD_MAIN3_10 =42;
	final static int CMD_MAIN3_11 =43;
	final static int CMD_MAIN3_12 =44;
	final static int CMD_MAIN3_13 =45;
	final static int CMD_MAIN3_14 =46;
	final static int CMD_MAIN3_15 =47;
	final static int CMD_MAIN3_16 =48;
	final static int CMD_MAIN3_17 =49;
	final static int CMD_MAIN3_18 =50;

	//Tyres
	final static int CMD_TYRE1 =52;
	final static int CMD_TYRE14 =53;
	final static int CMD_TYRE15 =54;
	final static int CMD_TYRE16 =55;
	final static int CMD_TYRE17 =56;
	final static int CMD_TYRE18 =57;
	final static int CMD_TYRE19 =58;
	final static int CMD_TYRE20 =59;
	final static int CMD_TYRE21 =60;
	final static int CMD_TYRE22 =61;
	final static int CMD_TYRE23 =62;

	final static int CMD_MAIN4_1 =63;
	final static int CMD_MAIN4_2 =64;
	final static int CMD_MAIN4_3 =65;
	final static int CMD_MAIN4_4 =66;
	final static int CMD_MAIN4_5 =67;
	final static int CMD_MAIN4_6 =68;
	final static int CMD_MAIN4_7 =69;
	final static int CMD_MAIN4_8 =70;

	final static int CMD_MAIN5_1 =72;
	final static int CMD_MAIN5_2 =73;
	final static int CMD_MAIN5_3 =74;
	final static int CMD_MAIN5_4 =75;
	final static int CMD_MAIN5_5 =76;
	final static int CMD_MAIN5_6 =77;

	final static int CMD_MAIN6_1 =78;
	final static int CMD_MAIN6_2 =79;
	final static int CMD_MAIN6_3 =80;
	final static int CMD_MAIN6_4 =81;
	final static int CMD_MAIN6_5 =82;
	final static int CMD_MAIN6_6 =83;
	final static int CMD_MAIN6_7 =84;


	final static int CMD_DB0 =85;
	final static int CMD_DB1 =86;
	final static int CMD_DB2 =87;
	final static int CMD_DB3 =88;
	final static int CMD_DB4 =89;
	final static int CMD_DB5 =90;
	final static int CMD_DB6 =91;
	final static int CMD_DB7 =92;

	final static int CMD_PREVDECALPAGE =93;
	final static int CMD_NEXTDECALPAGE =94;

	final static int CMD_PREVPARTPAGE =95;
	final static int CMD_NEXTPARTPAGE =96;

	// Chassis shop
	final static int CMD_VEHICLE =100;
	final static int CMD_VEH0	 =101;
	final static int CMD_VEH1	 =102;
	final static int CMD_VEH2	 =103;
	final static int CMD_VEH3	 =104;
	final static int CMD_VEH4	 =105;
	final static int CMD_VEH5	 =106;
	final static int CMD_VEH6	 =107;
	final static int CMD_VEH7	 =108;
	final static int CMD_VEH8	 =109;
	final static int CMD_VEH9	 =110;
	final static int CMD_UP		 =111;
	final static int CMD_DOWN	 =112;
	final static int CMD_VEHI	 =113;
	final static int CMD_CHAS	 =114;
	final static int CMD_VBUY	 =115;
	final static int CMD_VCOLOR	 =116;

	final static int NO_FILTER	 =120;
	final static int RIMS_FILTER	 =121;
	final static int TYRES_FILTER	 =122;


	final static String pageNumberPrefix;

	final static float PRICERATIO = 1.1;	//katalogus ar-szorzo

	PhysicsRef		Wall = new PhysicsRef();

	Player			player;

	Osd				osd,vehicleBackgroundOsd;

	int				actGroup;

	Text			moneytxt, pgNumberL, pgNumberR, sectionstxt;
	Text[]			pageNumberL = new Text[7];
	Text[]			pageNumberR = new Text[7];

	CatalogInventory	inventory;
	Vector			collector;
	GameRef			parts;

	int				curpage=1;

	int				step, filter, currentCarPackId, partsPackId;

	Decal[]			curDecals;
	Button[]		decalButtons;
	Vector			decals;
	int				showDecals;

	int				mainGroup, VehicleGroup, main1Group, main2Group, main3Group, main4Group, main5Group, main6Group, main7Group;
	int				decalsGroup, parts1Group, parts2Group, parts3Group, parts4Group, parts5Group, parts7Group;

	ResourceRef[]	carTypes;
	Button			VColor_Button, VehButton0, VehButton1, VehButton2, VehButton3, VehButton4, VehButton5, VehButton6, VehButton7, VehButton8, VehButton9, UpButton, DownButton;
	int				Rim_size, Tyre_size, VehAmount, ColorIDX, CurrentPage, CurrentName, CompleteCar, RetailP, DeliveryP, TotalP, ButtonNum;
	Text			CurrentPageText;
	GameRef			CarScene, Cam;
	//Camera		Cam;
	RenderRef		SceneSun;
	Thread			CamThread;
	Ypr				CamYpr;
	Vector3			CamVector;
	Viewport		CarViewport;
	Vehicle			CurrentCar;
	GameRef			CurrentChassis;
	Text			CurrentCarName, RetailText, DeliveryText, TotalText;
	TextBox			CurrentCarDescription;
	Vector3			Size;

	public Catalog()
	{
		createNativeInstance();

		player = GameLogic.player;

		carTypes = GameLogic.VEHICLETYPE_ROOT.getChildNodes();
	}

	public static Vector collectDecals( String subdir )
	{
		Vector ds = new Vector();

		FindFile ff = new FindFile();
		String name=ff.first( "decals/textures/catalog/" + subdir + "/*.png" );
		while( name )
		{
			Decal decal = new Decal( "decals/textures/catalog/" +subdir + "/" + name );	//extends ResourceRef
			ds.addElement( decal );
			name = ff.next();
		}
		ff.close();

		return ds;
	}

	public void clearObjectCache()
	{
		if( inventory )
		{
			inventory.hide();
			inventory.flushAll();
			inventory = null;
		}

		collector = null;
	}

	//puts parts of the given category and car type (+common parts) to the given inventory
	public void collectObjectsBegin()
	{
		clearObjectCache();

		inventory = new CatalogInventory( this, player, 0.02, 0.25, 0.96, 0.50 );
		collector = new Vector();

		if( player.car )
			currentCarPackId = player.car.getInfo( GII_TYPE ) >> 16;
		else
			currentCarPackId = 0;

		partsPackId = System.openLib( "parts.rpk" );
	}

	public void collectObjectsEnd()
	{
		collectObjectsStep(9);

		inventory.update();
		inventory.show();
	}

	public void collectObjects( GameRef root )
	{
		collectObjects( root, null, null, null, null);
	}

	public void collectObjects( GameRef root1, GameRef root2 )
	{
		collectObjects( root1, root2, null, null, null);
	}

	public void collectObjects( GameRef root1, GameRef root2, GameRef root3 )
	{
		collectObjects( root1, root2, root3, null, null);
	}

	public void collectObjects( GameRef root1, GameRef root2, GameRef root3, GameRef root4 )
	{
		collectObjects( root1, root2, root3, root4, null);
	}

	public void collectObjects( GameRef root1, GameRef root2, GameRef root3, GameRef root4, GameRef root5 )
	{
		if( root1 ) collector.addElement( root1 );
		if( root2 ) collector.addElement( root2 );
		if( root3 ) collector.addElement( root3 );
		if( root4 ) collector.addElement( root4 );
		if( root5 ) collector.addElement( root5 );
	}

	//return false if finished collecting
	public int collectObjectsStep( int int_step )
	{
		step = int_step;

		if( collector )
		{
			while( !collector.isEmpty() && step )
			{
				parts=collector.removeLastElement();

				if( parts.isScripted( "java.game.parts.Part" ) )//it's a part
				{
					//inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
					//step--;
					osdCommand( filter );// run parts filter
				}
				else
				if( parts.isScripted( "java.game.parts.Set" ) )	//set?
				{
					Set set = parts.create( null, parts, null, "set_loader" );

					InventoryItem_Folder tmp = new InventoryItem_Folder( inventory );
					tmp.set = set;
					set.build( tmp.inv );
					inventory.items.addElement( tmp );
				}
				else
				{	//dummy eloszto node!
					if( parts=parts.getFirstChild() )
					{
						while( parts )
						{
							if( parts.isScripted() )
								collector.addElement( parts );
							else
							{
								int	carPack;
								int packId = parts.id() >> 16;

								for( int i=carTypes.length-1; i>=0; i-- )
								{
									if( packId == carTypes[i].id()>>16 )
									{
										carPack=1;
										break;
									}
								}

								if( !carPack || packId == currentCarPackId )
									collector.addElement( parts );
								//
							}

							parts=parts.getNextChild();
						}
					}
				}
			}

			inventory.update();

			return !collector.isEmpty();
		}

		return 0;
	}

	public void setDecalButtons()
	{
		int	max = decals.size();

		clearDecalButtons();

		for( int i=0; i<decalButtons.length; i++ )
		{
			//a gomb tipus (nagy)
			RenderRef	base = new RenderRef( frontend:0x00AEr );

			if( max > showDecals+i )
			{
				curDecals[i] = decals.elementAt( showDecals+i );
				decalButtons[i].rect.changeTexture( decals.elementAt( showDecals+i ) );
			}
		}
	}

	public void clearDecalButtons()
	{
		for( int i=0; i<decalButtons.length; i++ )
		{
			decalButtons[i].rect.changeTexture( Osd.RRT_EMPTY );
			if( curDecals[i] )
			{
				curDecals[i].unload();
				curDecals[i] = null;
			}
		}
	}

	public void enter( GameState prev_state )
	{
		osd = new Osd();
		vehicleBackgroundOsd = new Osd(1,0,0);
		osd.globalHandler = this;

		showDecals=0;

		setEventMask( EVENT_TIME );

		createOSDObjects();
		osd.show();

		Input.cursor.enable(1);
		setEventMask( EVENT_CURSOR );

		GfxEngine.setGlobalEnvmap( new ResourceRef( MW_Mod:0x0069r ));
	}

	public void VehicleScene()
	{
		CarScene = new GroundRef( Maps.Addon_Maps.Home:0x00000001r );
		//CarScene = new Dummy( WORLDTREEROOT );

		CurrentCar = new Vehicle();

		CarViewport = new Viewport( 5, 0.0, 0.1245, 1.00, 0.7519 );
		CarViewport.activate( Viewport.RENDERFLAG_CLEARDEPTH | Viewport.RENDERFLAG_CLEARTARGET );
		//Cam = new Camera( CarScene, CarViewport, 0 );
		Cam = new GameRef( CarScene, GameRef.RID_CAMERA, "0,0,0 , 0,0,0 ,0", "camera" );
		Cam.setMatrix( new Vector3( 0, 0, 0), new Ypr( 0, 0, 0));
		Cam.command( "render " + CarViewport.id() + " 0 0 1 " + (Viewport.RENDERFLAG_CLEARDEPTH | Viewport.RENDERFLAG_CLEARTARGET) );
		//cam.command( "look " + player.car.id() + " " + "0,0,0" + " 0,0,0" );
		Cam.command( "look " + CurrentCar.id() + " 0.3,-0.6,0" );
		Cam.command( "zoom 25 60");

		RenderRef CarSun = new RenderRef(misc.garage:0x001Dr);
		SceneSun = new RenderRef( CarScene, CarSun, "light for this scene" );

		//CurrentCar.wakeUp();

		// Reset at start
		ColorIDX = 0;
		CurrentPage = 0;
		CompleteCar = 0;

		osdCommand( CMD_UP ); // Refresh page
		osdCommand( CMD_VEH0 );// Show 1st car

		//getInfo( GameType.GII_SIZE )/100.0, 1 );	//size, enableRotate

		CamThread = new Thread( this, "Cam Animate Refresher" );
		CamThread.start();
	}

	public void createOSDObjects()
	{
		Style bsm = new Style( 0.70, 0.13, Frontend.largeFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );
		Style bs = new Style( 0.70, 0.13, Frontend.mediumFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );

		Style bbsr = new Style( 0.12, 0.12, 1.0, Frontend.mediumFont, Text.ALIGN_RIGHT, new ResourceRef(Osd.RID_ARROWRG) );
		Style bbsl = new Style( 0.12, 0.12, 1.0, Frontend.mediumFont, Text.ALIGN_LEFT, new ResourceRef(Osd.RID_ARROWLF) );

		Style bex = new Style( 0.12, 0.12, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef(Osd.RID_EXIT) );
		Style bek = new Style( 0.12, 0.12, 1.0, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef(Osd.RID_BACK) );

		Style Menu_Left = new Style( 0.7, 0.13, Frontend.mediumFont, Text.ALIGN_LEFT, Osd.RRT_TEST );
		Style Menu_Right = new Style( 0.7, 0.13, Frontend.mediumFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );
		Style Menu_Center = new Style( 0.4, 0.13, Frontend.mediumFont, Text.ALIGN_CENTER, Osd.RRT_TEST );
		Style Menu_Button = new Style( 0.12, 0.12, Frontend.mediumFont, Text.ALIGN_CENTER, null );
		Style Midle_Button = new Style( 0.17, 0.17, Frontend.mediumFont, Text.ALIGN_CENTER, null );
		Style Big_Button = new Style( 0.2, 0.25, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef( frontend:0x0125r ) );

		Menu m;

		//always visible objects:
		moneytxt=osd.createText( null, Frontend.mediumFont, Text.ALIGN_CENTER,	0.50, -0.94 );
		osd.endGroup();

		//----------------------------------------Grand Index

		osd.createBG( new ResourceRef(misc.catalog:0x0006r) );

		m= osd.createMenu( bsm, 1.0, -0.55, 0.18 );
		m.addItem( "Veiculos", CMD_VEHICLE );
		m.addItem( "Motor", CMD_MAIN1 );
		m.addItem( "Carroceria", CMD_MAIN2 );
		m.addItem( "Suspensao", CMD_MAIN3 );
		m.addItem( "Interior", CMD_MAIN4 );
		m.addItem( "Audio", CMD_MAIN5 );
		m.addItem( "Adesivos", CMD_MAIN6 );

		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_EXIT, this );
		actGroup = mainGroup = osd.endGroup();

		//----------------------------------------Engine Index

		osd.createBG( new ResourceRef(misc.catalog:0x0009r) );

		m= osd.createMenu( Menu_Left, -0.98, -0.65, 0.14 );
		m.addItem( "Blocos De Motor", CMD_MAIN1_1 );
		m.addItem( "Virabrequins E Mancal", CMD_MAIN1_2 );
		m.addItem( "Bielas", CMD_MAIN1_3 );
		m.addItem( "Pistoes", CMD_MAIN1_4 );
		m.addItem( "Cabecotes", CMD_MAIN1_6 );
		m.addItem( "Comandos E Mancal", CMD_MAIN1_7 );
		m.addItem( "Admissao", CMD_MAIN1_8 );
		m.addItem( "Carburacao E Injetores", CMD_MAIN1_9 );
		m.addItem( "Embreagem E Volante", CMD_MAIN1_10 );
		m.addItem( "Cambios", CMD_MAIN1_11 );

		m= osd.createMenu( bs, 1.0, -0.65, 0.14 );
		m.addItem( "Escapamentos", CMD_MAIN1_12 );
		m.addItem( "Ponteiras", CMD_MAIN1_13 );
		m.addSeparator();
		m.addItem( "Correias", CMD_MAIN1_14 );
		m.addItem( "Acessorios etc", CMD_MAIN1_15 );
		m.addItem( "Baterias", CMD_MAIN1_16 );
		m.addItem( "Carter", CMD_MAIN1_5 );
		m.addSeparator();
		m.addItem( "Sobrealimentacao", CMD_MAIN1_17 );
		m.addItem( "Pro Tuning", CMD_MAIN1_18 );
		m.addItem( "Motores Completos", CMD_MAIN1_19 );

		osd.createButton( bek, 0.85, -0.94, CMD_FRONTPAGE, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_FRONTPAGE, this );
		osd.hideGroup( main1Group = osd.endGroup() );

		//----------------------------------------Vehicle Page

		//osd.createBG( new ResourceRef(misc.catalog:0x0026r) ); // Background
		vehicleBackgroundOsd.show();
		vehicleBackgroundOsd.createBG( new ResourceRef(misc.catalog:0x0026r) );

		CurrentName = CurrentPage*10;

		m = osd.createMenu( Menu_Center, 0.175, -0.655, Osd.MD_HORIZONTAL );
		m.addItem( "Veiculos", CMD_VEHI );

		m = osd.createMenu( Menu_Center, -0.175, -0.655, Osd.MD_HORIZONTAL );
		m.addItem( "Chassis", CMD_CHAS );

		m = osd.createMenu( Midle_Button, 0.798, 0.41, 0, Osd.MD_VERTICAL );
		VColor_Button = m.addItem( new ResourceRef( frontend:0x00AFr ), CMD_VCOLOR, "Change color" );
		VColor_Button.disable();

		CurrentPageText = osd.createText( "Pagina: " + (CurrentPage+1), Frontend.largeFont, Text.ALIGN_CENTER, 0, 0.635 ); CurrentPageText.changeColor(0xFFF0F0F0);// "Unmolested" white

		CurrentCarName = osd.createText( "-Nenhuma Veiculos Selecionado-", Frontend.largeFont, Text.ALIGN_CENTER, 0.0, -0.625 ); CurrentCarName.changeColor(0xFFF0F0F0);// "Unmolested" white

		CurrentCarDescription = osd.createTextBox( "Descricao: N/A", Frontend.smallFont, Text.ALIGN_CENTER, 0.485, -0.435, 0.48, null/*, 10*/ ); CurrentCarDescription.changeColor(0xFFF0F0F0);// text box, 10 lines max

		//CurrentCarDescription = osd.createTextBox( "Description: N/A", Frontend.smallFont, Text.ALIGN_CENTER, -0.3, 0.025, 1.0 );
		//CurrentCarDescription.changeColor(0xFFF0F0F0);

		osd.createText( "Valor:", Frontend.smallFont, Text.ALIGN_LEFT, 0.25, 0.60 ).changeColor(0xFFF0F0F0);// "Unmolested" white
		RetailText = osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_RIGHT, 0.70, 0.60 ); RetailText.changeColor(0xFFF0F0F0);// "Unmolested" white

		osd.createText( "Custo De Transporte:", Frontend.smallFont, Text.ALIGN_LEFT, 0.25, 0.65 ).changeColor(0xFFF0F0F0);// "Unmolested" white
		DeliveryText = osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_RIGHT, 0.70, 0.65 ); DeliveryText.changeColor(0xFFF0F0F0);// "Unmolested" white

		osd.createText( "Total:", Frontend.smallFont, Text.ALIGN_LEFT, 0.25, 0.70 ).changeColor(0xFFF0F0F0);// "Unmolested" white
		TotalText = osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_RIGHT, 0.70, 0.70 ); TotalText.changeColor(0xFFF0F0F0);// "Unmolested" white

		//osd.createText( "What you want to have today?", Frontend.smallFont, Text.ALIGN_CENTER, -0.45, 0.80 ).changeColor(0xFFF0F0F0);// "Unmolested" white

		osd.createText( "Escolha entre " + GameLogic.ChassisBox.size() + " diferentes modelos." , Frontend.smallFont, Text.ALIGN_CENTER, 0, 0.70 ).changeColor(0xFFF0F0F0);// "Unmolested" white

		VehAmount = GameLogic.ChassisBox.size()-1;

		m= osd.createMenu( Menu_Left, -0.98, -0.60, 0 );
		if( CurrentName + 0 <= VehAmount ) VehButton0 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+0].vehicleName, CMD_VEH0 ); else { VehButton0 = m.addItem( "", CMD_VEH0 ); VehButton0.disable(); }
		if( CurrentName + 1 <= VehAmount ) VehButton1 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+1].vehicleName, CMD_VEH1 ); else { VehButton1 = m.addItem( "", CMD_VEH1 ); VehButton0.disable(); }
		if( CurrentName + 2 <= VehAmount ) VehButton2 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+2].vehicleName, CMD_VEH2 ); else { VehButton2 = m.addItem( "", CMD_VEH2 ); VehButton0.disable(); }
		if( CurrentName + 3 <= VehAmount ) VehButton3 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+3].vehicleName, CMD_VEH3 ); else { VehButton3 = m.addItem( "", CMD_VEH3 ); VehButton0.disable(); }
		if( CurrentName + 4 <= VehAmount ) VehButton4 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+4].vehicleName, CMD_VEH4 ); else { VehButton4 = m.addItem( "", CMD_VEH4 ); VehButton0.disable(); }
		if( CurrentName + 5 <= VehAmount ) VehButton5 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+5].vehicleName, CMD_VEH5 ); else { VehButton5 = m.addItem( "", CMD_VEH5 ); VehButton0.disable(); }
		if( CurrentName + 6 <= VehAmount ) VehButton6 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+6].vehicleName, CMD_VEH6 ); else { VehButton6 = m.addItem( "", CMD_VEH6 ); VehButton0.disable(); }
		if( CurrentName + 7 <= VehAmount ) VehButton7 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+7].vehicleName, CMD_VEH7 ); else { VehButton7 = m.addItem( "", CMD_VEH7 ); VehButton0.disable(); }
		if( CurrentName + 8 <= VehAmount ) VehButton8 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+8].vehicleName, CMD_VEH8 ); else { VehButton8 = m.addItem( "", CMD_VEH8 ); VehButton0.disable(); }
		if( CurrentName + 9 <= VehAmount ) VehButton9 = m.addItem(GameLogic.ChassisBox.elementData[CurrentName+9].vehicleName, CMD_VEH9 ); else { VehButton9 = m.addItem( "", CMD_VEH9 ); VehButton0.disable(); }

		m = osd.createMenu( Menu_Button, -0.35,   -0.675, Osd.MD_VERTICAL );
		UpButton = m.addItem( new ResourceRef( frontend:0x00AFr ), CMD_UP, "Ant" );

		m = osd.createMenu( Menu_Button, -0.35,   0.675, Osd.MD_VERTICAL );
		DownButton = m.addItem( new ResourceRef( frontend:0x0084r ), CMD_DOWN, "Prox" );

		osd.createButton( bek, 0.85, -0.94, CMD_FRONTPAGE, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createButton( Big_Button, 0.656, 0.41, CMD_VBUY, "Comprar Este Veiculo" );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_FRONTPAGE, this );
		osd.hideGroup( VehicleGroup = osd.endGroup() );

		//----------------------------------------Body Index

		osd.createBG( new ResourceRef(misc.catalog:0x0010r) );

		m= osd.createMenu( bs, 1.0, -0.55, 0.18 );
		m.addItem( "Paineis De Carroceria", CMD_MAIN2_1 );
		m.addItem( "Pecas Aftermarket", CMD_MAIN2_2 );
		m.addItem( "Iluminacao E Vidros", CMD_MAIN2_3 );
		m.addItem( "Neon", CMD_MAIN2_4 );
		m.addItem( "Aerofolios", CMD_MAIN2_5 );
		m.addItem( "Outros", CMD_MAIN2_6 );
		m.addItem( "Body Kit", CMD_MAIN2_7 );

		osd.createButton( bek, 0.85, -0.94, CMD_FRONTPAGE, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_FRONTPAGE, this );
		osd.hideGroup( main2Group = osd.endGroup() );

		//----------------------------------------Running Gear Index

		osd.createBG( new ResourceRef(misc.catalog:0x0011r) );

		m= osd.createMenu( Menu_Right, 0.98, -0.6, 0.15 );
		m.addItem( "Montante De Roda", CMD_MAIN3_1 );
		m.addItem( "Amortecedores", CMD_MAIN3_2 );
		m.addItem( "Molas", CMD_MAIN3_3 );
		m.addItem( "Freios", CMD_MAIN3_4 );
		m.addSeparator();
		m.addItem( "Pneus", CMD_TYRE1 );
		m.addSeparator();
		m.addItem( "Outros", CMD_MAIN3_6 );
		m.addItem( "Barra Estabilizadora", CMD_MAIN3_7 );
		m.addItem( "Kit Suspensão", CMD_MAIN3_8 );

		m= osd.createMenu( Menu_Left, -0.98, -0.6, 0.133 );
		m.addItem( "Aros Menores", CMD_MAIN3_9 );
		m.addItem( "Aros 15''", CMD_MAIN3_10 );
		m.addItem( "Aros 16''", CMD_MAIN3_11 );
		m.addItem( "Aros 17''", CMD_MAIN3_12 );
		m.addItem( "Aros 18''", CMD_MAIN3_13 );
		m.addItem( "Aros 19''", CMD_MAIN3_14 );
		m.addItem( "Aros 20''", CMD_MAIN3_15 );
		m.addItem( "Aros 21''", CMD_MAIN3_16 );
		m.addItem( "Aros 22''", CMD_MAIN3_17 );
		m.addItem( "Aros Maiores ", CMD_MAIN3_18 );

		//------------------------------------------------------------------DEBUG(on the main running gear page)
		/*m= osd.createMenu( Menu_Left, 0.00, -0.6, 0.133 );
		m.addItem( "SMALLER TYRES", CMD_TYRE14 );
		m.addItem( "TYRES 15''", CMD_TYRE15 );
		m.addItem( "TYRES 16''", CMD_TYRE16 );
		m.addItem( "TYRES 17''", CMD_TYRE17 );
		m.addItem( "TYRES 18''", CMD_TYRE18 );
		m.addItem( "TYRES 19''", CMD_TYRE19 );
		m.addItem( "TYRES 20''", CMD_TYRE20 );
		m.addItem( "TYRES 21''", CMD_TYRE21 );
		m.addItem( "TYRES 22''", CMD_TYRE22 );
		m.addItem( "BIGGER TYRES ", CMD_TYRE23 );*/

		osd.createButton( bek, 0.85, -0.94, CMD_FRONTPAGE, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_FRONTPAGE, this );
		osd.hideGroup( main3Group = osd.endGroup() );

		//----------------------------------------Tyres Index

		osd.createBG( new ResourceRef(misc.catalog:0x0011r) );

		m= osd.createMenu( Menu_Left, -0.98, -0.6, 0.133 );
		m.addItem( "Pneus Menores", CMD_TYRE14 );
		m.addItem( "Pneus 15''", CMD_TYRE15 );
		m.addItem( "Pneus 16''", CMD_TYRE16 );
		m.addItem( "Pneus 17''", CMD_TYRE17 );
		m.addItem( "Pneus 18''", CMD_TYRE18 );
		m.addItem( "Pneus 19''", CMD_TYRE19 );
		m.addItem( "Pneus 20''", CMD_TYRE20 );
		m.addItem( "Pneus 21''", CMD_TYRE21 );
		m.addItem( "Pneus 22''", CMD_TYRE22 );
		m.addItem( "Pneus Maiores ", CMD_TYRE23 );

		osd.createButton( bek, 0.85, -0.94, CMD_MAIN3, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN3, this );
		osd.hideGroup( main7Group = osd.endGroup() );

		//----------------------------------------Interior Index

		osd.createBG( new ResourceRef(misc.catalog:0x001Er) );

		m= osd.createMenu( bs, 1.0, -0.55, 0 );
		m.addItem( "Volante", CMD_MAIN4_1 );
		m.addItem( "Painel", CMD_MAIN4_2 );
		m.addItem( "Alavancas", CMD_MAIN4_3 );
		m.addItem( "Pedaleiras", CMD_MAIN4_4 );
		m.addItem( "Manometros", CMD_MAIN4_5 );
		m.addItem( "Bancos", CMD_MAIN4_6 );
		m.addItem( "Santo Antonio", CMD_MAIN4_7 );
		m.addItem( "Outros", CMD_MAIN4_8 );

		osd.createButton( bek, 0.85, -0.94, CMD_FRONTPAGE, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_FRONTPAGE, this );
		osd.hideGroup( main4Group = osd.endGroup() );

		//----------------------------------------Audio Index

		osd.createBG( new ResourceRef(misc.catalog:0x001Fr) );

		m= osd.createMenu( bs, 1.0, -0.55, 0.2 );
		m.addItem( "Aparelho", CMD_MAIN5_1 );
		m.addItem( "Aplificador", CMD_MAIN5_2 );
		m.addItem( "Caixas", CMD_MAIN5_3 );
		m.addItem( "Auto Falante", CMD_MAIN5_4 );
		m.addItem( "Acessorios", CMD_MAIN5_5 );
		m.addItem( "Kit De Som", CMD_MAIN5_6 );

		osd.createButton( bek, 0.85, -0.94, CMD_FRONTPAGE, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_FRONTPAGE, this );
		osd.hideGroup( main5Group = osd.endGroup() );

		//----------------------------------------Decal Index

		osd.createBG( new ResourceRef(misc.catalog:0x0022r) );

		m= osd.createMenu( bs, 1.0, -0.55, 0.18 );
		m.addItem( "Fabricantes", CMD_MAIN6_1 );
		m.addItem( "Logos", CMD_MAIN6_2 );
		m.addItem( "Numeros", CMD_MAIN6_3 );
		m.addItem( "Digitos", CMD_MAIN6_4 );
		m.addItem( "Smiles", CMD_MAIN6_5 );
		m.addItem( "Animais", CMD_MAIN6_6 );
		m.addItem( "Outros", CMD_MAIN6_7 );

		osd.createButton( bek, 0.85, -0.94, CMD_FRONTPAGE, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_FRONTPAGE, this );
		osd.hideGroup( main6Group = osd.endGroup() );

		//----------------------------------------Akatreszlista oldalak 1

		osd.createBG( new ResourceRef(misc.catalog:0x0009r) );

		pageNumberL[0] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,	-0.88,  0.65);
		pageNumberR[0] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,	0.88,  0.65);

		osd.createButton( bbsl, -0.96, 0.675, CMD_PREVPARTPAGE, null );
		osd.createButton( bbsr, 0.96, 0.675, CMD_NEXTPARTPAGE, null );

		osd.createButton( bek, 0.85, -0.94, CMD_MAIN1, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN1, this );
		osd.hideGroup( parts1Group = osd.endGroup() );

		//----------------------------------------Akatreszlista oldalak 2
		osd.createBG( new ResourceRef(misc.catalog:0x0010r) );

		pageNumberL[1] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,	-0.88,  0.65);
		pageNumberR[1] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,	0.88,  0.65);

		osd.createButton( bbsl, -0.96, 0.675, CMD_PREVPARTPAGE, null );
		osd.createButton( bbsr, 0.96, 0.675, CMD_NEXTPARTPAGE, null );

		osd.createButton( bek, 0.85, -0.94, CMD_MAIN2, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN2, this );
		osd.hideGroup( parts2Group = osd.endGroup() );

		//----------------------------------------Akatreszlista oldalak 3
		osd.createBG( new ResourceRef(misc.catalog:0x0011r) );

		pageNumberL[2] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,	-0.88,  0.65);
		pageNumberR[2] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,	0.88,  0.65);

		osd.createButton( bbsl, -0.96, 0.675, CMD_PREVPARTPAGE, null );
		osd.createButton( bbsr, 0.96, 0.675, CMD_NEXTPARTPAGE, null );

		osd.createButton( bek, 0.85, -0.94, CMD_MAIN3, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN3, this );
		osd.hideGroup( parts3Group = osd.endGroup() );

		//----------------------------------------Akatreszlista oldalak 3_5(TYRES)
		osd.createBG( new ResourceRef(misc.catalog:0x0011r) );

		pageNumberL[3] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,	-0.88,  0.65);
		pageNumberR[3] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,	0.88,  0.65);

		osd.createButton( bbsl, -0.96, 0.675, CMD_PREVPARTPAGE, null );
		osd.createButton( bbsr, 0.96, 0.675, CMD_NEXTPARTPAGE, null );

		osd.createButton( bek, 0.85, -0.94, CMD_TYRE1, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_TYRE1, this );
		osd.hideGroup( parts7Group = osd.endGroup() );

		//----------------------------------------Akatreszlista oldalak 4
		osd.createBG( new ResourceRef(misc.catalog:0x001Er) );

		pageNumberL[4] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,	-0.88,  0.65);
		pageNumberR[4] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,	0.88,  0.65);

		osd.createButton( bbsl, -0.96, 0.675, CMD_PREVPARTPAGE, null );
		osd.createButton( bbsr, 0.96, 0.675, CMD_NEXTPARTPAGE, null );

		osd.createButton( bek, 0.85, -0.94, CMD_MAIN4, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN4, this );
		osd.hideGroup( parts4Group = osd.endGroup() );

		//----------------------------------------Akatreszlista oldalak 5
		osd.createBG( new ResourceRef(misc.catalog:0x001Fr) );

		pageNumberL[5] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,	-0.88,  0.65);
		pageNumberR[5] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,	0.88,  0.65);

		osd.createButton( bbsl, -0.96, 0.675, CMD_PREVPARTPAGE, null );
		osd.createButton( bbsr, 0.96, 0.675, CMD_NEXTPARTPAGE, null );

		osd.createButton( bek, 0.85, -0.94, CMD_MAIN5, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN5, this );
		osd.hideGroup( parts5Group = osd.endGroup() );

		//----------------------------------------Altalanos decallista oldal

		osd.createBG( new ResourceRef(misc.catalog:0x0022r) );

		Style dbs = new Style( 0.45, 0.45, Frontend.largeFont, Text.ALIGN_CENTER, Osd.RRT_TEST );

		curDecals = new Decal[8];
		decalButtons=new Button[8];
		decalButtons[0] = osd.createButton( dbs, -0.75, -0.35, "", CMD_DB0 );
		decalButtons[1] = osd.createButton( dbs, -0.25, -0.35, "", CMD_DB1 );
		decalButtons[2] = osd.createButton( dbs,  0.25, -0.35, "", CMD_DB2 );
		decalButtons[3] = osd.createButton( dbs,  0.75, -0.35, "", CMD_DB3 );
		decalButtons[4] = osd.createButton( dbs, -0.75,  0.40, "", CMD_DB4 );
		decalButtons[5] = osd.createButton( dbs, -0.25,  0.40, "", CMD_DB5 );
		decalButtons[6] = osd.createButton( dbs,  0.25,  0.40, "", CMD_DB6 );
		decalButtons[7] = osd.createButton( dbs,  0.75,  0.40, "", CMD_DB7 );

		pageNumberL[6] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_LEFT,	-0.88,  0.65);
		pageNumberR[6] = osd.createText( null, Frontend.mediumFont, Text.ALIGN_RIGHT,	0.88,  0.65);

		osd.createButton( bbsl, -0.96, 0.675, CMD_PREVDECALPAGE, null );
		osd.createButton( bbsr, 0.96, 0.675, CMD_NEXTDECALPAGE, null );

		osd.createButton( bek, 0.85, -0.94, CMD_MAIN6, null );
		osd.createButton( bex, 0.92, -0.94, CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN6, this );
		osd.hideGroup( decalsGroup = osd.endGroup() );

		//------------------------------------------

		refreshMoneyString();
		refreshPage();
	}

	public void exit( GameState next_state )
	{
		Frontend.loadingScreen.hide();

		clearEventMask( EVENT_ANY );
		removeAllTimers();
		Input.cursor.enable(0);

		if(CurrentCar)
		{
			SceneSun.destroy();
			CamThread.stop();
			CarViewport.deactivate();
			//CamThread=null;
		}

		pageNumberPrefix=null;

		osd.hide();
		vehicleBackgroundOsd.hide();
	}


	public void changeGroup(int group)
	{
		if( actGroup != group )
		{
			if (actGroup >= 0)
			{
				osd.hideGroup (actGroup);

				//group deinit code:
				if( actGroup == decalsGroup )
				{
					clearDecalButtons();
				}
				else
				if( actGroup >= parts1Group && actGroup <= parts5Group )
				{
					clearObjectCache();
				}
			}

			actGroup = group;

			if (actGroup >= 0)
			{
				osd.showGroup (actGroup);
				osd.changeSelection2( -1, 0 );
			}
		}
	}


	public void refreshMoneyString()
	{
		new SfxRef( Frontend.SFX_MONEY ).play();
		moneytxt.changeText( "$" + Integer.toString( player.money ) );
	}

	public void refreshPage()
	{
		if( pageNumberPrefix )
		{
			pgNumberL.changeText( pageNumberPrefix + curpage );
			pgNumberR.changeText( pageNumberPrefix + (curpage+1) );
		}
	}

//----------------------------------------------------------------------

	public void decalButtonPressed( int n )
	{
		if( showDecals+n < decals.size() )
		{
			int price=DECALPRICE;
			if( price <= player.money )
			{
				Decal decal = decals.elementAt( showDecals+n );

				Dialog dialog = new YesNoDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "COMPRAR DECALQUE", "Pretende comprar este conjunto de decalques por $" + price + " ?\n(Cada conjunto possui 5 decalques)" );
				if( dialog.display() == 0 )
				{
					player.money-=price;
					player.decals.addElement( new Decal( decal.id() ) );
					refreshMoneyString();
				}
			}
			else
			{
				new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "SEM DINHEIRO", "Voce nao tem $" + price + " para comprar este decalque!" ).display();
			}
		}
	}

	//----------------------------------------------------------------------
	public void osdCommand( int cmd )
	{
		if( cmd == CMD_VCOLOR )
		{
			if(CurrentCar)
			{
				if( ColorIDX == GameLogic.CARCOLORS.length - 1)
					ColorIDX = 0;
				else
					ColorIDX += 1;

				CurrentCar.command( "texture " + GameLogic.CARCOLORS[ColorIDX] + " 1" );
				VColor_Button.changeTexture( new ResourceRef(GameLogic.CARCOLORS[ColorIDX]) );
				//CurrentCar.wakeUp();
			}
		}
		if( cmd == CMD_VBUY )
		{
			if( TotalP <= player.money )
			{
				// Create name: car name or chassis name
				String Vname;
				if( CompleteCar > 0 ) Vname = CurrentCar.chassis.vehicleName;
				else Vname = CurrentCar.chassis.name;

				// Check for free space at garage
				int	GarageFree;

				if( GameLogic.player.car )
				{
					//GameLogic.garage.releaseCar();
					GameLogic.player.carlot.lockPlayerCar();
					GarageFree = GameLogic.player.carlot.getFreeSlot();
					GameLogic.player.carlot.releasePlayerCar();

					//Reset car pos at garage
					GameLogic.garage.StartPos = new Vector3 (5.340, -2.2394, -1.144);
					GameLogic.garage.StartYpr = new Ypr ( 2.525*(Math.random()*3.147), 0.000, 0.000);
				}
				else
					GarageFree = 1;

				if( GarageFree >= 0 )
				{
					Dialog dialog = new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "COMPRAR VEICULO", "Pretende comprar este " + Vname  + " por $" + TotalP + " ?" );
					if( dialog.display() == 0 )
					{
						player.money-=TotalP;
						refreshMoneyString();

						player.carlot.addCar( player.car );
						player.carlot.saveCar( player.carlot.curcar );
						player.carlot.flushCars();

						//CurrentCar.command( "start" );	//release

						if (File.exists("save/temp/CopyCar"))
						{
							File.delete( "save/temp/CopyCar" );
							File.delete( "save/temp/CopyCar.*" );
						}
						CurrentCar.save( "save/temp/CopyCar" );

						if(CurrentCar) CurrentCar.destroy();
						if(CurrentChassis) CurrentChassis.destroy();

						GameLogic.player.car = Vehicle.load( "save/temp/CopyCar", GameLogic.player );

						changeGroup( -1 );
						GameLogic.changeActiveSection( GameLogic.garage );
					}
				}
				else
				{
					new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Lote De Carros Cheio", "Não há mais espaço livre no seu lote de carros. \n Venda alguns carros para liberar espaço no estacionamento!" ).display();
				}
			}
			else
			{
				new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Sem Dinheiro", "Você não possui $" + TotalP + " para comprar este carro!" ).display();
			}
		}
		if( cmd == CMD_CHAS )
		{
			if(CompleteCar > 0)
			{
				if(CurrentCar) CurrentCar.destroy();
				if(CurrentChassis) CurrentChassis.destroy();

				CurrentCar = new Vehicle();
				CurrentCar.chassis = new Chassis();
				CurrentCar.chassis = create(CarScene, new GameRef(GameLogic.ChassisRoot[GameLogic.ChassisResNoumber[CurrentName+ButtonNum]]), "0,1.2,0,0,0,0,", "chassis");
				CurrentCar = new Vehicle(CurrentCar.chassis);
				//CurrentCar.wakeUp();

				CurrentCarName.changeText( CurrentCar.chassis.vehicleName );
				CurrentCarDescription.changeText( CurrentCar.chassis.description );

				RetailP = CurrentCar.getTotalPrice()*PRICERATIO; // Clac retail price
				RetailText.changeText( "$" + RetailP );// show text

				DeliveryP = CurrentCar.chassis.getMass()*5.8; // Calc delivery price
				DeliveryText.changeText( "$" + DeliveryP );// show text

				TotalP = RetailP + DeliveryP; // Calc total price
				TotalText.changeText( "$" + TotalP );// show text

				VColor_Button.disable();
				VColor_Button.changeTexture( new ResourceRef( frontend:0x00AFr ) );
			}

			CompleteCar = 0;
		}
		if( cmd == CMD_VEHI )
		{
			if(CompleteCar == 0 && CurrentCar)
			{
				CurrentCar.chassis.addStockParts( new Descriptor( CurrentCar.chassis.getTexture(), 1, 1, 1, 1) );
				CurrentCar.chassis.command( "reset" );
				CurrentCar.chassis.command( "setsteer -0.6" );
				CurrentCar.command( "idle" );
				CurrentCar.wakeUp();

				RetailP = CurrentCar.getTotalPrice()*PRICERATIO; // Clac retail price
				RetailText.changeText( "$" + RetailP );// show text

				DeliveryP = CurrentCar.chassis.getMass()*5.8; // Calc delivery price
				DeliveryText.changeText( "$" + DeliveryP );// show text

				TotalP = RetailP + DeliveryP; // Calc total price
				TotalText.changeText( "$" + TotalP );// show text

				VColor_Button.enable();
				VColor_Button.changeTexture( new ResourceRef(CurrentCar.chassis.getTexture()) );
			}
			CompleteCar = 1;
		}
		if( cmd >= CMD_VEH0 && cmd <= CMD_VEH9 ) // All 10 buttons
		{
			if(cmd == CMD_VEH0) ButtonNum = 0;
			if(cmd == CMD_VEH1) ButtonNum = 1;
			if(cmd == CMD_VEH2) ButtonNum = 2;
			if(cmd == CMD_VEH3) ButtonNum = 3;
			if(cmd == CMD_VEH4) ButtonNum = 4;
			if(cmd == CMD_VEH5) ButtonNum = 5;
			if(cmd == CMD_VEH6) ButtonNum = 6;
			if(cmd == CMD_VEH7) ButtonNum = 7;
			if(cmd == CMD_VEH8) ButtonNum = 8;
			if(cmd == CMD_VEH9) ButtonNum = 9;

			if(CurrentCar) CurrentCar.destroy();
			if(CurrentChassis) CurrentChassis.destroy();

			CurrentCar = new Vehicle();
			CurrentCar.chassis = new Chassis();
			CurrentCar.chassis = create(CarScene, new GameRef(GameLogic.ChassisRoot[GameLogic.ChassisResNoumber[CurrentName+ButtonNum]]), "0,1.2,0,0,0,0,", "chassis");
			CurrentCar = new Vehicle(CurrentCar.chassis);
			//CurrentCar.wakeUp();

			Size = CurrentCar.chassis.getMin();
			//Cam.command( "move " + CarScene.id() +" "+(Size.x*2.2)+","+(Size.y*2.2)+","+(Size.z*2.2)+" 1.0 0, -0.2, 0" );

			//Cam.setMatrix( new Vector3(-(Max.x-Min.x+1), Max.y, -(Max.z-Min.z+1)), new Ypr(-2.358, -0.5, 0));
			//float size = CurrentCar.chassis.getInfo(GameType.GII_SIZE)/100.0;

			if(CompleteCar)
			{
				CurrentCar.chassis.addStockParts( new Descriptor( CurrentCar.chassis.getTexture(), 1, 1, 1, 1) );
				CurrentCar.chassis.command( "reset" );
				CurrentCar.chassis.command( "setsteer -0.6" );
				CurrentCar.command( "idle" );
				CurrentCar.wakeUp();

				VColor_Button.enable();
				VColor_Button.changeTexture( new ResourceRef(CurrentCar.chassis.getTexture()) );
			}

			CurrentCarName.changeText( CurrentCar.chassis.vehicleName );
			CurrentCarDescription.changeText( CurrentCar.chassis.description );

			RetailP = CurrentCar.getTotalPrice()*PRICERATIO; // Clac retail price
			RetailText.changeText( "$" + RetailP );// show text

			DeliveryP = CurrentCar.chassis.getMass()*5.8; // Calc delivery price
			DeliveryText.changeText( "$" + DeliveryP );// show text

			TotalP = RetailP + DeliveryP; // Calc total price
			TotalText.changeText( "$" + TotalP );// show text
		}
		else
		if( cmd == CMD_UP )
		{
			if (CurrentPage > 0)
				CurrentPage -= 1;

			CurrentName = CurrentPage*10;
			CurrentPageText.changeText( "Pagina Atual: " + (CurrentPage+1) );

			VehAmount = GameLogic.ChassisBox.size()-1;

			DownButton.changeTexture( new ResourceRef( frontend:0x0084r ) ); // Arrow down
			DownButton.enable();

			if (CurrentPage == 0)
			{
				UpButton.changeTexture( new ResourceRef( frontend:0x00AFr ) ); // Empty.ptx
				UpButton.disable();
			}

			if( CurrentName + 0 <= VehAmount ) { VehButton0.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+0].vehicleName); VehButton0.enable(); } else { VehButton0.changeLabelText( "" ); VehButton0.disable(); }
			if( CurrentName + 1 <= VehAmount ) { VehButton1.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+1].vehicleName); VehButton1.enable(); } else { VehButton1.changeLabelText( "" ); VehButton1.disable(); }
			if( CurrentName + 2 <= VehAmount ) { VehButton2.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+2].vehicleName); VehButton2.enable(); } else { VehButton2.changeLabelText( "" ); VehButton2.disable(); }
			if( CurrentName + 3 <= VehAmount ) { VehButton3.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+3].vehicleName); VehButton3.enable(); } else { VehButton3.changeLabelText( "" ); VehButton3.disable(); }
			if( CurrentName + 4 <= VehAmount ) { VehButton4.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+4].vehicleName); VehButton4.enable(); } else { VehButton4.changeLabelText( "" ); VehButton4.disable(); }
			if( CurrentName + 5 <= VehAmount ) { VehButton5.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+5].vehicleName); VehButton5.enable(); } else { VehButton5.changeLabelText( "" ); VehButton5.disable(); }
			if( CurrentName + 6 <= VehAmount ) { VehButton6.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+6].vehicleName); VehButton6.enable(); } else { VehButton6.changeLabelText( "" ); VehButton6.disable(); }
			if( CurrentName + 7 <= VehAmount ) { VehButton7.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+7].vehicleName); VehButton7.enable(); } else { VehButton7.changeLabelText( "" ); VehButton7.disable(); }
			if( CurrentName + 8 <= VehAmount ) { VehButton8.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+8].vehicleName); VehButton8.enable(); } else { VehButton8.changeLabelText( "" ); VehButton8.disable(); }
			if( CurrentName + 9 <= VehAmount ) { VehButton9.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+9].vehicleName); VehButton9.enable(); } else { VehButton9.changeLabelText( "" ); VehButton9.disable(); }
		}
		else
		if( cmd == CMD_DOWN )
		{
			if (GameLogic.ChassisRoot.length >= CurrentName+10)
				CurrentPage += 1;

			CurrentName = CurrentPage*10;

			CurrentPageText.changeText( "Pagina Atual: " + (CurrentPage+1) );

			UpButton.changeTexture( new ResourceRef(frontend:0x004Cr) ); // Arrow up
			UpButton.enable();

			VehAmount = GameLogic.ChassisBox.size()-1;

			if (VehAmount < CurrentName+10)
			{
				DownButton.changeTexture( new ResourceRef(frontend:0x00AFr) ); // Empty.ptx
				DownButton.disable();
			}

			if( CurrentName + 0 <= VehAmount ) { VehButton0.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+0].vehicleName); VehButton0.enable(); } else { VehButton0.changeLabelText( "" ); VehButton0.disable(); }
			if( CurrentName + 1 <= VehAmount ) { VehButton1.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+1].vehicleName); VehButton1.enable(); } else { VehButton1.changeLabelText( "" ); VehButton1.disable(); }
			if( CurrentName + 2 <= VehAmount ) { VehButton2.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+2].vehicleName); VehButton2.enable(); } else { VehButton2.changeLabelText( "" ); VehButton2.disable(); }
			if( CurrentName + 3 <= VehAmount ) { VehButton3.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+3].vehicleName); VehButton3.enable(); } else { VehButton3.changeLabelText( "" ); VehButton3.disable(); }
			if( CurrentName + 4 <= VehAmount ) { VehButton4.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+4].vehicleName); VehButton4.enable(); } else { VehButton4.changeLabelText( "" ); VehButton4.disable(); }
			if( CurrentName + 5 <= VehAmount ) { VehButton5.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+5].vehicleName); VehButton5.enable(); } else { VehButton5.changeLabelText( "" ); VehButton5.disable(); }
			if( CurrentName + 6 <= VehAmount ) { VehButton6.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+6].vehicleName); VehButton6.enable(); } else { VehButton6.changeLabelText( "" ); VehButton6.disable(); }
			if( CurrentName + 7 <= VehAmount ) { VehButton7.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+7].vehicleName); VehButton7.enable(); } else { VehButton7.changeLabelText( "" ); VehButton7.disable(); }
			if( CurrentName + 8 <= VehAmount ) { VehButton8.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+8].vehicleName); VehButton8.enable(); } else { VehButton8.changeLabelText( "" ); VehButton8.disable(); }
			if( CurrentName + 9 <= VehAmount ) { VehButton9.changeLabelText(GameLogic.ChassisBox.elementData[CurrentName+9].vehicleName); VehButton9.enable(); } else { VehButton9.changeLabelText( "" ); VehButton9.disable(); }
		}
		else
		if( cmd==CMD_EXIT )							//main index pages
		{
			changeGroup( -1 );
			GameLogic.changeActiveSection( GameLogic.garage );

			if(CurrentCar) CurrentCar.destroy();
			if(CurrentChassis) CurrentChassis.destroy();
		}
		else
		if( cmd==CMD_FRONTPAGE )
		{
			changeGroup( mainGroup );

			if(CurrentCar) CurrentCar.destroy();
			if(CurrentChassis) CurrentChassis.destroy();
		}
		else
		if( cmd==CMD_VEHICLE )
		{
			//pgNumberL=pageNumberL[0];
			//pgNumberR=pageNumberR[0];
			changeGroup( VehicleGroup );
			VehicleScene();
		}
		else
		if( cmd==CMD_MAIN1 )
		{
			pgNumberL=pageNumberL[0];
			pgNumberR=pageNumberR[0];
			changeGroup( main1Group );
		}
		else
		if( cmd==CMD_MAIN2 )
		{
			pgNumberL=pageNumberL[1];
			pgNumberR=pageNumberR[1];
			changeGroup( main2Group );
		}
		else
		if( cmd==CMD_MAIN3 )
		{
			pgNumberL=pageNumberL[2];
			pgNumberR=pageNumberR[2];
			changeGroup( main3Group );
		}
		else
		if( cmd==CMD_TYRE1 )
		{
			changeGroup( main7Group );
		}
		else
		if( cmd==CMD_MAIN4 )
		{
			pgNumberL=pageNumberL[4];
			pgNumberR=pageNumberR[4];
			changeGroup( main4Group );
		}
		else
		if( cmd==CMD_MAIN5 )
		{
			pgNumberL=pageNumberL[5];
			pgNumberR=pageNumberR[5];
			changeGroup( main5Group );
		}
		else
		if( cmd==CMD_MAIN6 )
		{
			pgNumberL=pageNumberL[6];
			pgNumberR=pageNumberR[6];
			changeGroup( main6Group );
		}
		else
		if( cmd>=CMD_DB0 && cmd<=CMD_DB7 )			//decal buttons
		{
			decalButtonPressed( cmd - CMD_DB0 );
		}
		if( cmd>=CMD_MAIN6_1 && cmd<=CMD_MAIN6_7 )	//decal subsections
		{
			String decalsDir;
			if( cmd == CMD_MAIN6_1 )
			{
				pageNumberPrefix="D-I/";
				decalsDir = "Fabricantes";
			}
			else
			if( cmd == CMD_MAIN6_2 )
			{
				pageNumberPrefix="D-II/";
				decalsDir = "Logos";
			}
			else
			if( cmd == CMD_MAIN6_3 )
			{
				pageNumberPrefix="D-III/";
				decalsDir = "Numeros";
			}
			else
			if( cmd == CMD_MAIN6_4 )
			{
				pageNumberPrefix="D-IV/";
				decalsDir = "Digitos";
			}
			else
			if( cmd == CMD_MAIN6_5 )
			{
				pageNumberPrefix="D-V/";
				decalsDir = "Smiles";
			}
			else
			if( cmd == CMD_MAIN6_6 )
			{
				pageNumberPrefix="D-VI/";
				decalsDir = "Animais";
			}
			else
			if( cmd == CMD_MAIN6_7 )
			{
				pageNumberPrefix="D-VII/";
				decalsDir = "Outros";
			}

			decals = collectDecals( decalsDir );

			curpage=1;
			showDecals=0;

			setDecalButtons();
			refreshPage();
			changeGroup( decalsGroup );
		}
		else
		if( cmd == CMD_PREVDECALPAGE )					//page control
		{
			if( showDecals >= decalButtons.length )
			{
				showDecals-=decalButtons.length;
				setDecalButtons();

				curpage-=2;
				refreshPage();
			}
		}
		else
		if( cmd == CMD_NEXTDECALPAGE )
		{
			int	max = decals.size();
			if( showDecals+decalButtons.length < max )
			{
				showDecals+=decalButtons.length;
				setDecalButtons();

				curpage+=2;
				refreshPage();
			}
		}
		else
		if( cmd == CMD_PREVPARTPAGE )
		{
			if( inventory.upScroll() )
			{
				curpage-=2;
				refreshPage();
			}
		}
		else
		if( cmd == CMD_NEXTPARTPAGE )
		{
			//biztositsuk, hogy a kov oldal is tele van (az init csak a legelsot tolti fel rendesen!)
			//ha az user cselez, atugrik masik sectionbe, aztan visszalapoz, megszivja!
			collectObjectsStep( 8 );

			if(	inventory.downScroll() )
			{
				curpage+=2;
				refreshPage();
			}
		}
		else
			// Collector filters:
			if( cmd == NO_FILTER )
			{
				inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
				step--;
			}
			else
			if( cmd == RIMS_FILTER )
			{
				Wheel rim = new Wheel();
				rim = create( null, new GameRef(parts), "0,0,0,0,0,0,", "temp rim");

				if( Rim_size <= 14 ) // Smaller rims
				{
					if( rim.getRadius() <= 14)
					{
						inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
						step--;
					}
				}
				else
				if( Rim_size >= 23 ) // Bigger rims
				{
					if( rim.getRadius() >= 23)
					{
						inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
						step--;
					}
				}
				else // 15"-22"
				{
					if( rim.getRadius() >= Rim_size && rim.getRadius() < Rim_size+1)
					{
						inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
						step--;
					}
				}
			}
			else
			if( cmd == TYRES_FILTER )
			{
				Tyre rubber = new Tyre();
				rubber = create( null, new GameRef(parts), "0,0,0,0,0,0,", "temp rubber");

				if( Tyre_size <= 14 ) // Smaller tyres
				{
					if( rubber.wheel_radius*2/25.4 <= 14)
					{
						inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
						step--;
					}
				}
				else
				if( Tyre_size >= 23 ) // Bigger tyres
				{
					if( rubber.wheel_radius*2/25.4 >= 23)
					{
						inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
						step--;
					}
				}
				else // 15"-22"
				{
					if( rubber.wheel_radius*2/25.4 >= Tyre_size && rubber.wheel_radius*2/25.4 < Tyre_size+1)
					{
						inventory.items.addElement( new InventoryItem_Part( inventory, parts.id() ) );
						step--;
					}
				}
			}
			else
				// Parts collector buttons:
				if( cmd >= CMD_MAIN1_1 && cmd < CMD_MAIN3_18 ) // all parts pages buttons before CMD_TYRE1
				//if( cmd >= CMD_MAIN1_1 && cmd < CMD_MAIN6_1 ) // all parts pages buttons // original collector
				{
					collectObjectsBegin();
					if( cmd >= CMD_MAIN1_1 && cmd < CMD_MAIN2_1 ) //all engine part page
					{
						changeGroup( parts1Group );

						if( cmd == CMD_MAIN1_1 )						//engine subsections
						{
							pageNumberPrefix="E-I/";
							collectObjects( new GameRef(parts:0x025Cr) ); // Engine Blocks
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN1_2 )
						{
							pageNumberPrefix="E-II/";
							collectObjects( new GameRef(parts:0x025Er) ); // Crankshafts & Bearning
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN1_3 )
						{
							pageNumberPrefix="E-III/";
							collectObjects( new GameRef(parts:0x00B7r) ); // Connecting Rods
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN1_4 )
						{
							pageNumberPrefix="E-IV/";
							collectObjects( new GameRef(parts:0x00B6r) ); // Pistons
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN1_5 )
						{
							pageNumberPrefix="E-V/";
							collectObjects( new GameRef(parts:0x0252r) ); // Oil Pans
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN1_6 )
						{
							pageNumberPrefix="E-VI/";
							collectObjects( new GameRef(parts:0x025Dr) ); // Cylinder Heads
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN1_7 )
						{
							pageNumberPrefix="E-VII/";
							collectObjects(  new GameRef(parts:0x025Fr) ); // Intake & Exhaust Crankshafts
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN1_8 )
						{
							pageNumberPrefix="E-VIII/";
							collectObjects( new GameRef(parts:0x0255r), new GameRef(parts:0x026Fr) ); // Air Delivery
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN1_9 )
						{
							pageNumberPrefix="E-IX/";
							collectObjects( new GameRef(parts:0x026Br), new GameRef(parts:0x026Er) ); // Fuel Delivery
							filter = NO_FILTER;
						}
						if( cmd == CMD_MAIN1_10 )
						{
							pageNumberPrefix="E-X/";
							collectObjects( new GameRef(parts:0x0249r), new GameRef(parts:0x023Cr) ); // Clutchs & Flywheels
							filter = NO_FILTER;
						}
						if( cmd == CMD_MAIN1_11 )
						{
							pageNumberPrefix="E-XI/";
							collectObjects( new GameRef(parts:0x024Ar), new GameRef(parts:0x023Br) ); // Transmission & Drivetrain
							filter = NO_FILTER;
						}
						if( cmd == CMD_MAIN1_12 )
						{
							pageNumberPrefix="E-XII/";
							collectObjects( new GameRef(parts:0x0282r), new GameRef(parts:0x0250r) ); // Exhaust System
							filter = NO_FILTER;
						}
						if( cmd == CMD_MAIN1_13 )
						{
							pageNumberPrefix="E-XIII/";
							collectObjects( new GameRef(parts:0x00C9r) ); // Exhaust Tips
							filter = NO_FILTER;
						}
						if( cmd == CMD_MAIN1_14 )
						{
							pageNumberPrefix="E-XIIV/";
							collectObjects( new GameRef(parts:0x00BEr) ); // Drive Belts
							filter = NO_FILTER;
						}
						if( cmd == CMD_MAIN1_15 )
						{
							pageNumberPrefix="E-XIV/";
							collectObjects( new GameRef(parts:0x0012r) ); // Accesories & Others
							filter = NO_FILTER;
						}
						if( cmd == CMD_MAIN1_16 )
						{
							pageNumberPrefix="E-XV/";
							collectObjects( new GameRef(parts:0x0010r) ); // Batteries
							filter = NO_FILTER;
						}
						if( cmd == CMD_MAIN1_17 )
						{
							pageNumberPrefix="E-XVI/";
							collectObjects( new GameRef(parts:0x00BDr), new GameRef(parts:0x0281r), new GameRef(parts:0x0279r) ); // Charging System
							filter = NO_FILTER;
						}
						if( cmd == CMD_MAIN1_18 )
						{
							pageNumberPrefix="E-XVII/";
							collectObjects( new GameRef(parts:0xF27Dr), new GameRef(parts:0x0117r), new GameRef(parts:0x00B4r), new GameRef(parts:0x0277r) ); // Pro tunning
							filter = NO_FILTER;
						}
						if( cmd == CMD_MAIN1_19 )
						{
							pageNumberPrefix="E-XVIII/";
							collectObjects( new GameRef(parts:0xF23Cr) ); // Engine Kits
							filter = NO_FILTER;
						}
					}
					else
					if( cmd >= CMD_MAIN2_1 && cmd < CMD_MAIN3_1 )		//body subs
					{
						changeGroup( parts2Group );
						if( cmd == CMD_MAIN2_1 )
						{
							pageNumberPrefix="B-I/";
							collectObjects( new GameRef(parts:0xF242r) ); // Body Panels
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN2_2 )
						{
							pageNumberPrefix="B-II/";
							collectObjects( new GameRef(parts:0xF24Fr) ); // Replacement Parts
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN2_3 )
						{
							pageNumberPrefix="B-III/";
							collectObjects( new GameRef(parts:0xF24cr) ); // Lights & Windows
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN2_4 )
						{
							pageNumberPrefix="B-IV/";
							collectObjects( new GameRef(parts:0xF24Br), new GameRef(parts:0xF266r) ); // Neon Lights
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN2_5 )
						{
							pageNumberPrefix="B-V/";
							collectObjects( new GameRef(parts:0xF233r) ); // Areodynamic Tunning
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN2_6 )
						{
							pageNumberPrefix="B-VI/";
							collectObjects( new GameRef(parts:0xF228r) ); // Others
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN2_7 )
						{
							pageNumberPrefix="B-VII/";
							collectObjects( new GameRef(parts:0xF23Br) ); // Body Kits
							filter = NO_FILTER;
						}
					}
					//------------------------------------------------------------------
					if( cmd >= CMD_MAIN3_1 && cmd <= CMD_MAIN3_18 )
					{
						changeGroup( parts3Group );

						if( cmd >= CMD_MAIN3_9 && cmd <= CMD_MAIN3_18 )	//all Rims buttons
						{
							collectObjectsBegin();
							collectObjects( new GameRef(parts:0xF235r) );
							filter = RIMS_FILTER;

							int buttonNumber;

							if( cmd == CMD_MAIN3_9 ) buttonNumber = 14; // Smaller than 15"
							if( cmd == CMD_MAIN3_10 ) buttonNumber = 15;
							if( cmd == CMD_MAIN3_11 ) buttonNumber = 16;
							if( cmd == CMD_MAIN3_12 ) buttonNumber = 17;
							if( cmd == CMD_MAIN3_13 ) buttonNumber = 18;
							if( cmd == CMD_MAIN3_14 ) buttonNumber = 19;
							if( cmd == CMD_MAIN3_15 ) buttonNumber = 20;
							if( cmd == CMD_MAIN3_16 ) buttonNumber = 21;
							if( cmd == CMD_MAIN3_17 ) buttonNumber = 22;
							if( cmd == CMD_MAIN3_18 ) buttonNumber = 23; // Bigger than 22"

							Rim_size = buttonNumber; // Info for RIMS_FILTER
							pageNumberPrefix="R-R"+buttonNumber+"''/";
						}
						else
						if( cmd == CMD_MAIN3_1 )	//running gear subsections
						{
							pageNumberPrefix="R-I/";
							collectObjects( new GameRef(parts:0xF229r) ); // Suspension
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN3_2 )
						{
							pageNumberPrefix="R-II/";
							collectObjects( new GameRef(parts:0x001Cr) ); // Shock Absorbers
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN3_3 )
						{
							pageNumberPrefix="R-III/";
							collectObjects( new GameRef(parts:0xF22Ar) ); // Springs
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN3_4 )
						{
							pageNumberPrefix="R-IV/";
							collectObjects( new GameRef(parts:0xF22Dr) ); // Brakes
							filter = NO_FILTER;
						}
						//------------------------------------------------------------------Ex-MAIN INSTANCE(gives odd problems, dont even bother to try it since the above works finely already lol)
				/*else
				if( cmd == CMD_TYRE1 )
				{
					changeGroup( main7Group );

					if( cmd >= CMD_TYRE14 && cmd <= CMD_TYRE23 )	//all Tyres buttons
					{
						collectObjects( new GameRef(parts:0xF23Er) );
						filter = TYRES_FILTER;

						int buttonNumber;

						if( cmd == CMD_TYRE14 ) buttonNumber = 14; // Smaller than 15"
						if( cmd == CMD_TYRE15 ) buttonNumber = 15;
						if( cmd == CMD_TYRE16 ) buttonNumber = 16;
						if( cmd == CMD_TYRE17 ) buttonNumber = 17;
						if( cmd == CMD_TYRE18 ) buttonNumber = 18;
						if( cmd == CMD_TYRE19 ) buttonNumber = 19;
						if( cmd == CMD_TYRE20 ) buttonNumber = 20;
						if( cmd == CMD_TYRE21 ) buttonNumber = 21;
						if( cmd == CMD_TYRE22 ) buttonNumber = 22;
						if( cmd == CMD_TYRE23 ) buttonNumber = 23; // Bigger than 22"

						Tyre_size = buttonNumber; // Info for TYRES_FILTER
						pageNumberPrefix="R-V"+buttonNumber+"''/";
					}
				}*/
						else
						if( cmd == CMD_MAIN3_6 )
						{
							pageNumberPrefix="R-VI/";
							collectObjects( new GameRef(parts:0xD120r), new GameRef(parts:0xD121r) ); // Others
							filter = NO_FILTER;
						}
						else
						if( cmd == CMD_MAIN3_7 )
						{
							pageNumberPrefix="R-VII/";
							collectObjects( new GameRef(parts:0x021Fr) ); // Sway Bars
							filter = NO_FILTER;
						}
						if( cmd == CMD_MAIN3_8 )
						{
							pageNumberPrefix="R-VIII/";
							collectObjects( new GameRef(parts:0xF249r) ); // RG kits
							filter = NO_FILTER;
						}
					}

					collectObjectsEnd();
					refreshPage();
				}

		if( cmd >= CMD_TYRE14 && cmd < CMD_MAIN6_1 ) // all parts pages buttons after CMD_TYRE1
		{
			collectObjectsBegin();
			//------------------------------------------------------------------MAIN INSTANCE (Ex-DEBUG on the main running gear page, it does still have that functionality as well, you might have to change group to "parts3Group")
			if( cmd >= CMD_TYRE14 && cmd <= CMD_TYRE23 )	//all Tyres buttons
			{
				changeGroup( parts7Group );

				collectObjects( new GameRef(parts:0xF23Er) );
				filter = TYRES_FILTER;

				int buttonNumber;

				if( cmd == CMD_TYRE14 ) buttonNumber = 14; // Smaller than 15"
				if( cmd == CMD_TYRE15 ) buttonNumber = 15;
				if( cmd == CMD_TYRE16 ) buttonNumber = 16;
				if( cmd == CMD_TYRE17 ) buttonNumber = 17;
				if( cmd == CMD_TYRE18 ) buttonNumber = 18;
				if( cmd == CMD_TYRE19 ) buttonNumber = 19;
				if( cmd == CMD_TYRE20 ) buttonNumber = 20;
				if( cmd == CMD_TYRE21 ) buttonNumber = 21;
				if( cmd == CMD_TYRE22 ) buttonNumber = 22;
				if( cmd == CMD_TYRE23 ) buttonNumber = 23; // Bigger than 22"

				Tyre_size = buttonNumber; // Info for TYRES_FILTER
				pageNumberPrefix="R-V"+buttonNumber+"''/";
			}
			else
			if( cmd >= CMD_MAIN4_1 && cmd < CMD_MAIN5_1 )
			{
				changeGroup( parts4Group );
				if( cmd == CMD_MAIN4_1 )						//interior subsection
				{
					pageNumberPrefix="I-I/";
					collectObjects( new GameRef(parts:0xF243r) );	//steerwheels
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN4_2 )
				{
					pageNumberPrefix="I-II/";
					collectObjects( new GameRef(parts:0xF245r) );	//dashes
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN4_3 )
				{
					pageNumberPrefix="I-III/";
					collectObjects( new GameRef(parts:0xF23fr) );	//gearknobs
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN4_4 )
				{
					pageNumberPrefix="I-IV/";
					collectObjects( new GameRef(parts:0xF241r) );	//pedals
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN4_5 )
				{
					pageNumberPrefix="I-V/";
					collectObjects( new GameRef(parts:0xF244r) );	//gauges
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN4_6 )
				{
					pageNumberPrefix="I-VI/";
					collectObjects( new GameRef(parts:0xF246r) );	//seats
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN4_7 )
				{
					pageNumberPrefix="I-VII/";
					collectObjects( new GameRef(parts:0xF247r) );	//rollbars
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN4_8 )
				{
					pageNumberPrefix="I-VIII/";
					collectObjects( new GameRef(parts:0xF248r) );	//decoration
					filter = NO_FILTER;
				}
			}
			if( cmd >= CMD_MAIN5_1 && cmd < CMD_MAIN6_1 ) //audio subsection
			{
				changeGroup( parts5Group );
				if( cmd == CMD_MAIN5_1 )
				{
					pageNumberPrefix="A-I/";
					collectObjects( new GameRef(parts:0xF240r) );	//head units
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN5_2 )
				{
					pageNumberPrefix="A-II/";
					collectObjects( new GameRef(parts:0x0246r) );	// Amplifiers
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN5_3 )
				{
					pageNumberPrefix="A-III/";
					collectObjects( new GameRef(parts:0x0247r) );	// Boxes
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN5_4 )
				{
					pageNumberPrefix="A-IV/";
					collectObjects( new GameRef(parts:0x0248r) );	// Subwoofers
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN5_5 )
				{
					pageNumberPrefix="A-V/";
					collectObjects( new GameRef(parts:0x024Br) );	// Accesories
					filter = NO_FILTER;
				}
				else
				if( cmd == CMD_MAIN5_6 )
				{
					pageNumberPrefix="A-VI/";
					collectObjects( new GameRef(parts:0x025Br) );	// Audio Kits
					filter = NO_FILTER;
				}
			}

			collectObjectsEnd();
			refreshPage();
		}
	}

	public void run()
	{
		for(;;)
		{
			CamYpr = new Ypr( -0.01f+System.currentTime()*0.5f,-0.15,0 );
			CamVector = new Vector3( 0.0, 1.5, 8.5 );
			CamVector.rotate( CamYpr );
			CamYpr.p = -0.23;
			Cam.setMatrix( CamVector, CamYpr );

			CamThread.sleep(35);
		}
	}
}

//----------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------

public class CatalogInventory extends VisualInventory
{
	Osd			osd;	//for da namez
	TextBox[]	names;

	Catalog	catalog;

	public CatalogInventory( Catalog cat, Player player, float left, float top, float width, float height )
	{
		super(player, left, top, width, height );
		catalog=cat;
	}

	public void initVisuals( float left, float top, float width, float height  )
	{
		linesPerPage=2;
		partsPerLine=4;

		//mely itemek lehetnek lathatoak kezdetben?
		cline=0;
		start = cline * partsPerLine;
		stop = start + linesPerPage * partsPerLine;

		//0..1 viewport coordinatarendszerben!
		float	itemWidth=0.20, itemHeight=0.15;
		float	hSpacing = (width-itemWidth*partsPerLine)/partsPerLine;
		float	vSpacing = (height-itemHeight*linesPerPage)/(linesPerPage-1);

		//backObject = new RenderRef( misc.catalog:0x00000020r );
		panels=new InventoryPanel[partsPerLine*linesPerPage];
		names=new TextBox[panels.length];

		//eggyel magasabb pri vp kell, mint maga a katalogus, kulonben eltunnek a szovegek!
		osd = new Osd( 1.0, 0.0, 11 );
		osd.iLevel = Osd.IL_NONE;

		int	index;
		float cheight=top;
		for( int i=0; i<linesPerPage; i++ )
		{
			float cwidth=left;
			for( int j=0; j<partsPerLine; j++ )
			{
				if( j == partsPerLine/2 )
					cwidth+=hSpacing;

				index = i*partsPerLine+j;
				panels[index]=new CatalogInventoryPanel( this, index, cwidth, cheight, itemWidth, itemHeight, player );
				names[index]=osd.createTextBox( null, Frontend.smallFont, Text.ALIGN_CENTER, (cwidth)*2-1, ((cheight+itemHeight)*2)-1, itemWidth*2 );
				//kicsit patch, sajnos a fontnak nics olyan propertyje, hogy multicolor-e!
				if( Frontend.smallFont.id() == Text.RID_CONSOLE10 || Frontend.smallFont.id() == Text.RID_CONSOLE5 )
					names[index].changeColor( 0xFF000000 );

				cwidth+=itemWidth+hSpacing;
			}
			cheight+=itemHeight+vSpacing;
		}
	}

	public int upScroll()
	{
		if( cline )
		{
			cline-=linesPerPage;
			update();
			return 1;
		}
		return 0;
	}

	public int downScroll()
	{
		if( cline+linesPerPage < pages()*linesPerPage )
		{
			cline+=linesPerPage;
			update();
			return 1;
		}
		return 0;
	}

	//number of twin pages in a catalog section
	public int	pages()
	{
		if( items.size() > 1)
			return (items.size()-1)/(partsPerLine*linesPerPage)+1;

		return 1;
	}

	public void panelLeftClick( int index )
	{
		index += currentLine()*partsPerLine;

		if( index<items.size() )
		{
			InventoryItem item = items.elementAt( index );

			int price = item.getPrice() * Catalog.PRICERATIO;
			if( price <= player.money )
			{
				Dialog d = new BuyCatalogItemDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.DF_WIDE, item, price );
				if( d.display() == 0 )
				{
					player.money-= price;
					item.copyToInventory( player.parts );
					catalog.refreshMoneyString();
					//kap egy bonus matricat is, ha spec alkatresz:
					int decalID = item.getLogo();
					if( decalID )
					{
						player.decals.addElement( new Decal( decalID ) );
					}
				}
			}
			else
			{
				new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "NOT ENOUGHT MONEY", "Voce nao tem dinheiro para comprar esta peca" ).display();
			}
		}
	}

	public void update()
	{
		//hol kapcsolodnak ki a buttonok?
		int begin = start;
		int end = stop;

		//mibol lesznek buttonok?
		start = cline * partsPerLine;
		stop = start + linesPerPage * partsPerLine;

		int i, vis;

		//clear changed ones
		vis=0;
		for( i=begin; i<end; i++ )
		{
			names[vis++].changeText( null );
		}

		//add new ones
		vis=0;
		for( i=start; i<stop; i++ )
		{
			if( i<items.size() )
			{
				InventoryItem item = items.elementAt(i);
				names[vis++].changeText( item.getName() + " $"+ (int)(item.getPrice() * Catalog.PRICERATIO) );
			}
		}

		super.update();
	}

	public void show()
	{
		super.show();
		osd.show();
	}

	public void hide()
	{
		osd.hide();
		super.hide();
	}
}

//----------------------------------------------------------------------------------------------

public class CatalogInventoryPanel extends InventoryPanel
{
	Player	player;

	ResourceRef	infoTex0, infoTex1;
	Rectangle infoRect0, infoRect1;

	public CatalogInventoryPanel( CatalogInventory inventory, int index, float left, float top, float width, float height, Player p )
	{
		super( inventory, index, left, top, width, height );

		infoRect0 = inventory.osd.createRectangle( (left+width/2)*2-1, ((top-0.04)*2)-1, 0.1, 0.1, 1.0, -0.5, 0.0, 0, null );
		infoRect1 = inventory.osd.createRectangle( (left+width/2)*2-1, ((top-0.04)*2)-1, 0.1, 0.1, 1.0,  0.5, 0.0, 0, null );
		player = p;
	}

	public void swap( int index_a, int index_b )
	{
		//nincs swap!!
	}

	public void attachItem( InventoryItem invitem )
	{
		ypr = new Ypr( -1.4, -0.7, 0.0 );

		super.attachItem( invitem );

		infoTex0 = infoTex1 = null;

		if( invitem && invitem instanceof InventoryItem_Part)
		{
			((InventoryItem_Part)invitem).compatibility = 0;

			Part p=invitem.getPart();
			if( player.car )
				if( p.getInfo( p.GII_COMPATIBLE, player.car.id() + "" ) )
				{
					if( p.getInfo( p.GII_INSTALL_OK, player.car.id() + "" ) )
					{
						infoTex0 = Catalog.RR_ICON_CAR_1STEP;
						((InventoryItem_Part)invitem).compatibility |= 1;
					}
					else
					{
						infoTex0 = Catalog.RR_ICON_CAR_COMP;
						((InventoryItem_Part)invitem).compatibility |= 2;
					}
				}


			int compatibleParts;
			for( int i=player.parts.size()-1; i>=0; i-- )
			{
				if( player.parts.items.elementAt(i) instanceof InventoryItem_Part )
					if( p.getInfo( p.GII_INSTALL_OK, player.parts.items.elementAt(i).getPart().id() + "" ) )
					{
						compatibleParts++;
						((InventoryItem_Part)invitem).compatibility |= 4;
						break;	//inkabb ne nezzuk tovabb, lassit
					}
			}

			if( compatibleParts )
				infoTex1 = Catalog.RR_ICON_INV_COMP;

		}

		infoRect0.changeTexture( infoTex0 );
		infoRect1.changeTexture( infoTex1 );
	}

}

public class BuyCatalogItemDialog extends YesNoDialog
{
	//inventory panel part
	Osd		panelosd;
	RenderRef light;
	Camera cam;
	InventoryItem invItem;
	Ypr		ypr = new Ypr( -2.5, -0.26, 0.0 );
	final static int RID_INVENTORY_LIGHT = misc.garage:0x00000024r;
	float staticYZ = 2.5;		//OLD CUSTOM VALUES - NO ZOOM
	float sizeX, sizeY, sizeZ;

	Thread			spinnerThread;

	public BuyCatalogItemDialog( Controller ctrl, int myflags, InventoryItem item, int price )
	{
		super( ctrl, myflags, "Comprar", genBody( item, price) );
		panelosd = new Osd( new Viewport( 23, 0.5, 0.628, 0.7, 42.0/15.0, -0.5, -0.5) );
		invItem = item;
	}

	public String genBody( InventoryItem item, int price )
	{
		String body = "Deseja Comprar " + item.getName()  + " Por $" + price + " ? \n \n \n" + item.getDescription() + " \n \n Nota: ";
//		String body = "Deseja Comprar " + item.getName()  + " Por $" + price + " ? \n \n Note: ";

		if( item instanceof InventoryItem_Part )
		{

			if( !((InventoryItem_Part)item).compatibility )
				body = body + "Imcompativel Com Seu Carro / Motor";
			else
			{
				if( ((InventoryItem_Part)item).compatibility & 1 )
					body = body + "Instalavel no seu carro";
				if( ((InventoryItem_Part)item).compatibility & 2 )
					body = body + "Intercambiavel Com suas Pecas";
				if( ((InventoryItem_Part)item).compatibility & 4 )
				{
					if( ((InventoryItem_Part)item).compatibility & 3 )
						body = body + " and ";
					body = body + "Talvez Seja Compativel";
				}

			}
		}

		return body;
	}

	public void show()
	{
		if (invItem instanceof InventoryItem_Folder)
		{
			cam = new Camera( invItem.localroot, panelosd.getViewport(), 1, 75, 0.001, 10.0 );
			Vector3 camPos = new Vector3( 0.0, staticYZ, staticYZ );
			camPos.rotate( new Ypr( ypr.y, 0.0, 0.0 ) );
			cam.setMatrix( camPos, ypr );
		}
		else
		{
			sizeZ = invItem.getPart().getInfo( GameType.GII_SIZE )/35.0; //-----------this was 40, might change later
			sizeX = invItem.getPart().getInfo( GameType.GII_SIZE )/10000.0;
			sizeY = invItem.getPart().getInfo( GameType.GII_SIZE )/250.0;
			cam = new Camera( invItem.localroot, panelosd.getViewport(), 1, 75, 0.001, 10.0 );
			Vector3 camPos = new Vector3( sizeX, sizeY, sizeZ );
			camPos.rotate( new Ypr( ypr.y, 0.0, 0.0 ) );
			cam.setMatrix( camPos, ypr );
		}
		light = new RenderRef( invItem.localroot, RID_INVENTORY_LIGHT, null );
		panelosd.show();
		spinnerThread = new Thread( this, "Mechanic inventory part spinner" );
		spinnerThread.start();
		super.show();
	}

	public void hide()
	{
		clearEventMask( EVENT_ANY );

		if( spinnerThread )
		{
			spinnerThread.stop();
			spinnerThread=null;
		}

		if( light )
		{
			light.destroy();
			light = null;
		}

		if( cam )
		{
			cam.destroy();	//stop rendering right now
			light = null;
		}

		panelosd.hide();

		super.hide();
	}


	public void run()
	{
		for(;;)
		{
			if( cam )
			{
				if (invItem instanceof InventoryItem_Folder)
				{
					ypr.y+=0.03;
					Vector3 v = new Vector3( 0.0, 0.5, staticYZ );
					v.rotate( new Ypr( ypr.y, 0.0, 0.0 ) );
					cam.setMatrix( v, ypr );
				}
				else
				{
					ypr.y+=0.03;
					//Vector3 v = new Vector3( 0.0, 0.5, zoom );	//OLD CUSTOM VALUES - NO ZOOM
					Vector3 v = new Vector3( sizeX, sizeY, sizeZ );
					v.rotate( new Ypr( ypr.y, 0.0, 0.0 ) );
					cam.setMatrix( v, ypr );
				}
			}
			spinnerThread.sleep(20);	//40:25fps  20:50fps
		}
	}
}
