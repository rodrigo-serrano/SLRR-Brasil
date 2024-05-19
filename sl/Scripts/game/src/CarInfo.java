package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.sound.*;
import java.game.parts.*;
import java.game.parts.bodypart.*;
import java.game.parts.enginepart.*;
import java.game.parts.enginepart.block.*;
import java.game.parts.enginepart.slidingenginepart.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.camshaft.*;
import java.game.parts.enginepart.slidingenginepart.reciprocatingenginepart.charger.*;

public class CarInfo extends GameType implements GameState
{
	// resource ID constants
	final static int  RID_CAR_BG = frontend:0x0095r;
	final static int  RID_ENGINE_BG = frontend:0x0087r;
	final static int  RID_FINANCIAL_BG = frontend:0x0097r;
	final static int  RID_RECORDS_BG = frontend:0x0096r;

	// commands
	final static int	CMD_CAR_PAGE = 1;
	final static int	CMD_ENGINE_PAGE = 2;
	final static int	CMD_FINANCIAL_PAGE = 3;
	final static int	CMD_RECORDS_PAGE = 4;
	final static int	CMD_EXIT = 5;
	final static int	CMD_SCROLL_UP = 6;
	final static int	CMD_SCROLL_DOWN = 7;

	// 408,718 - 914,292
	// -0.20, 0.40 - 0.78, -0.43
	final static float graphX = -0.205;
	final static float graphY = 0.395;
	final static float graphW = 1.02;
	final static float graphH = 0.85;
	
	float			graphRPMMin = 0.00;
	float			graphRPMMax = 10000.00;
	float			graphHPMin = 0.00;
	float			graphHPMax = 900.00;
	float			graphTorqueMin = 0.00;	//ft-lbs!!
	float			graphTorqueMax = 600.00;	//ft-lbs!!

	GameState		parentState;

	Osd				osd;

	Vehicle			car;

	int				carGroup, engineGroup, financialGroup, recordsGroup, actGroup;
	int				firstPart;
	int				nParts;

	Text[]			partText = new Text[100];
	ResourceRef		graphFont;

	public CarInfo( Vehicle car_ )
	{
		createNativeInstance();

		car=car_;
	}

	public void page( int pg )
	{
		if( actGroup != pg )
		{
			osd.hideGroup( carGroup );
			osd.hideGroup( engineGroup );
			osd.hideGroup( financialGroup );
			osd.hideGroup( recordsGroup );
			actGroup = pg;
			osd.showGroup( actGroup );
		}
	}

	public void enter( GameState prevState )
	{
		parentState=prevState;

		osd = new Osd();
		osd.globalHandler = this;

		firstPart = 0;
		nParts = 0;
		createOSDObjects();
		osd.show();

		Input.cursor.enable(1);

		setEventMask( EVENT_CURSOR );
	}

	public void exit( GameState nextState )
	{
		clearEventMask( EVENT_ANY );

		Input.cursor.enable(0);
		osd.hide();
		deleteOSDObjects();
		parentState=null;
	}

	public int wearColor( float f )
	{
		int	color;

		if( f > 1.0 )
			f = 1.0;
		if( f < 0.0 )
			f = 0.0;

		if( f >= 0.5 )
		{
			color = ((1.0 - f) * 2.0) * 0xFF;
			color = ((color & 0xFF) << 16) + 0xFF00FF00;
		}
		else
		{
			color = (f * 2.0) * 0xFF;
			color = ((color & 0xFF) << 8) + 0xFFFF0000;
		}
		return color;
	}

	public float listParts( Vehicle car, int first )
	{
		int i;
		int	iv;
		float fv;

		float totalValue;
		nParts = 0;

		if( car.iteratePartsInit() )
		{
			Part part;
			while( part = car.iterateParts() )
			{
				float value = part.currentPriceNoAttach();
				float SILfine = part.police_check_fine_value;
				if( first > 0 )
				{
					first--;
				}
				else
				{
					if( i < 100 )
					{
						partText[i++].changeText( part.name );
						fv = part.getWear();
						iv = fv * 100.0;
						partText[i].changeColor( wearColor( fv ) );
						partText[i++].changeText( iv + "%" );
						fv = part.getTear();
						iv = fv * 100.0;
						partText[i].changeColor( wearColor( fv ) );
						partText[i++].changeText( iv + "%" );
						if (SILfine>0.0)
						{
							iv = SILfine;
							partText[i++].changeText( "$" + iv );
						}
						else
							partText[i++].changeText( "" );
						iv = value;
						partText[i++].changeText( "$" + iv );
					}
				}
				totalValue += value;
				nParts++;
			}
		}

		while( i < 100 )
		{
			partText[i++].changeText( "" );
		}

		return totalValue;
	}

	public void createButtons()
	{
		osd.createRectangle( 1.01, -0.82, 1.2, 0.22, -1, new ResourceRef(frontend:0x0024r) );

		Style buttonStyle = new Style( 0.12, 0.12, Frontend.smallFont, Text.ALIGN_LEFT, null );
		Menu m = osd.createMenu( buttonStyle, 0.45, -0.82, 0, Osd.MD_HORIZONTAL );

		m.addItem( new ResourceRef( frontend:0x0124r ), CMD_CAR_PAGE, "Informacoes Gerais" );
		m.addItem( new ResourceRef( frontend:0x00B5r ), CMD_ENGINE_PAGE, "Dinamometro" );
		m.addItem( new ResourceRef( frontend:0x00B4r ), CMD_FINANCIAL_PAGE, "Informacoes Pecas" );
		m.addItem( new ResourceRef( frontend:0x0123r ), CMD_RECORDS_PAGE, "Records" );
		m.addSeparator();
		m.addSeparator();
		m.addItem( new ResourceRef( Osd.RID_BACK ), CMD_EXIT, null );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL|Osd.HK_STATIC, CMD_EXIT, this );
	}

	public String driveType()
	{
		int dt = car.getInfo( 52/*GII_CAR_DRIVETYPE*/ );
		if( dt == 0 )
			return "Sem Tracao";
		else if( dt == 1 )
			return "Integral";
		else if( dt == 2 )
			return "Dianteira";
		else if( dt == 3 )
			return "Traseira";
		else if( dt == 4 )
			return "4x4";

		return "?";
	}

	public String exists( int ex )
	{
		if( ex == 0 )
			return "Not exists";

		return "Exists";
	}

	public void createOSDObjects()
	{
		int		i, val, line;
		float	xpos, xpos2, xpos3, ypos, fval, gx, gy;
		String	name;

		graphFont = Frontend.smallFont;

		float fontCenter = ( (1.2*osd.createText( "", graphFont, Text.ALIGN_LEFT, 0, 0).getFontSize( graphFont ))/(Config.video_y * osd.getViewport().getHeight()) );

		Chassis chas = car.chassis;

		//-------------------------------------------------
		osd.createBG( new ResourceRef(RID_CAR_BG) );
		osd.createHeader( "Informacoes do Carro" );
		createButtons();

		if( chas )
			name = chas.name.token(0);
		else
			name = "undefined";

		Vector3	CM = chas.getCM();		//ToDo: display
		Vector3	Min = chas.getMin();
		Vector3	Max = chas.getMax();

		int	wheels = chas.getWheels();
		Vector3[]	WP = new Vector3[wheels];
		float[]		R = new float[wheels];
		for (int i=0; i<wheels; i++)
		{
			WheelRef whl = chas.getWheel(i);

			WP[i] = whl.getPos();//chas.getWheelPos(i);
			R[i] = whl.getRadius();
		}

		xpos = -0.95;
		xpos2 = -0.55;
		ypos = -0.53;
		osd.createText( chas.vehicleName, Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line ); line++;
		line++;
//		osd.createText( "Drag:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line ); // it's the _main.java drag, doesn't seem to change a thing
//		osd.createText( chas.C_drag, Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line ); line++;

		fval = car.chassis.getMileage();
		osd.createText( "Kilometragem:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		osd.createText( (int)(fval*0.01) +" km" + "  /  " + (int)(fval*0.00621) + " mi", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line++ );
		//osd.createText( (int)(fval*0.00621) + " mi", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line++ );
		line++;

		val = chas.getMass();
		osd.createText( "Peso:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		osd.createText( val + " kg" + "  /  " + Float.toString(val*2.2, "%1.0f pounds"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line );
		line++;
		line++;
		//osd.createText( Float.toString(val*2.2, "%1.0f pounds"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line ); line++;
		osd.createText( "Comprimento:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		osd.createText( Float.toString((Max.z - Min.z)*1000.0, "%1.0f mm") + "  /  " + Float.toString((Max.z - Min.z)*100.0/2.54, "%1.1f inch"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line );
		line++;
		line++;
		//osd.createText( Float.toString((Max.z - Min.z)*100.0/2.54, "%1.1f inch"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line ); line++;
		osd.createText( "Largura:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		osd.createText( Float.toString((Max.x - Min.x)*1000.0, "%1.0f mm") + "  /  " + Float.toString((Max.x - Min.x)*100.0/2.54, "%1.1f inch"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line );
		line++;
		line++;
		//osd.createText( Float.toString((Max.x - Min.x)*100.0/2.54, "%1.1f inch"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line ); line++;
		osd.createText( "Altura:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		osd.createText( Float.toString((Max.y - Min.y)*1000.0, "%1.0f mm") + "  /  " + Float.toString((Max.y - Min.y)*100.0/2.54, "%1.1f inch"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line );
		line++;
		line++;
		//osd.createText( Float.toString((Max.y - Min.y)*100.0/2.54, "%1.1f inch"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line ); line++;
		osd.createText( "Vao Livre:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		osd.createText( Float.toString((R[0]-WP[0].y+Min.y)*1000.0, "%1.0f mm") + "  /  " + Float.toString((R[0]-WP[0].y+Min.y)*100.0/2.54, "%1.1f inch"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line );
		line++;
		line++;
		//osd.createText( Float.toString((R[0]-WP[0].y+Min.y)*100.0/2.54, "%1.1f inch"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line ); line++;
		// centre of gravity
		// not sure if 100% correct, as it uses ground clearance equation, which seems to be inaccurate.
		osd.createText( "Centro de Gravidade:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		osd.createText( Float.toString((Math.sqrt(((R[0]-WP[0].y+Min.y)-CM.y)*((R[0]-WP[0].y+Min.y)-CM.y)))*1000.0, "%1.0f mm") + "  /  " + Float.toString((Math.sqrt(((R[0]-WP[0].y+Min.y)-CM.y)*((R[0]-WP[0].y+Min.y)-CM.y)))*100.0/2.54, "%1.1f inch"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line );
		line++;
		line++;
		//osd.createText( Float.toString((Math.sqrt(((R[0]-WP[0].y+Min.y)-CM.y)*((R[0]-WP[0].y+Min.y)-CM.y)))*100.0/2.54, "%1.1f inch"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line ); line++;
		// end
		osd.createText( "Tracao:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		osd.createText( driveType(), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line ); line++;
		line++;
		
		// 2D weight distribution
		float front = ((WP[0].z+WP[1].z)*0.5)-CM.z;
		float rear = ((WP[2].z+WP[3].z)*0.5)-CM.z;
		float weightz = -front/(rear-front); // rear, use 1.0*weightz to get front

		float left = ((WP[0].x+WP[2].x)*0.5)-CM.x;
		float right = ((WP[1].x+WP[3].x)*0.5)-CM.x;
		float weightx = -left/(right-left);

		float weightxzf = (1.0-weightz + weightx)*0.5; // front right wheel, use 1.0*weightxz to get left	???
		float weightxzr = (weightz + weightx)*0.5; // rear right wheel, use 1.0*weightxz to get left
		
		// front view
		osd.createText( Float.toString((1.0-weightxzf)*100.0,"%1.1f%%") + "          " + "Distribuicao de Peso" + "          " + Float.toString(weightxzf*100.0,"%1.1f%%"), Frontend.smallFont, Text.ALIGN_CENTER, 0.08, -0.125, 0 );
		fval = WP[1].x - WP[0].x;
		osd.createText( "Eixo Dianteiro", Frontend.smallFont, Text.ALIGN_CENTER, 0.08, -0.125, 1 );
		osd.createText( Float.toString(fval*1000.0,"%1.0f mm"), Frontend.smallFont, Text.ALIGN_CENTER, 0.08, -0.125, 2 );
		osd.createText( Float.toString(fval*100.0/2.54,"%1.1f inch"), Frontend.smallFont, Text.ALIGN_CENTER, 0.08, -0.125, 3 );
		
		// rear view
		osd.createText( Float.toString((1.0-weightxzr)*100.0,"%1.1f%%") +  "        " + "Distribuicao de Peso" + "        " + Float.toString(weightxzr*100.0,"%1.1f%%"), Frontend.smallFont, Text.ALIGN_CENTER, 0.68, -0.125, 0 );
		fval = WP[3].x - WP[2].x;
		osd.createText( "Eixo Traseiro", Frontend.smallFont, Text.ALIGN_CENTER, 0.68, -0.125, 1 );
		osd.createText( Float.toString(fval*1000.0,"%1.0f mm"), Frontend.smallFont, Text.ALIGN_CENTER, 0.68, -0.125, 2 );
		osd.createText( Float.toString(fval*100.0/2.54,"%1.1f inch"), Frontend.smallFont, Text.ALIGN_CENTER, 0.68, -0.125, 3 );

		// top view
		fval = (WP[2].z+WP[3].z)*0.5 - (WP[0].z+WP[1].z)*0.5;
		osd.createText( Float.toString((1.0-weightz)*100.0,"%1.1f%%") +  "                                        " + "Distribuicao de Peso" + "                                        " + Float.toString(weightz*100.0,"%1.1f%%"), Frontend.smallFont, Text.ALIGN_CENTER, 0.35, 0.50, 0 );
		osd.createText( "Entre Eixos", Frontend.smallFont, Text.ALIGN_CENTER, 0.35, 0.50, 1 );
		osd.createText( Float.toString(fval*1000.0,"%1.0f mm"), Frontend.smallFont, Text.ALIGN_CENTER, 0.35, 0.50, 2 );
		osd.createText( Float.toString(fval*100.0/2.54,"%1.1f inch"), Frontend.smallFont, Text.ALIGN_CENTER, 0.35, 0.50, 3 );
		// end 
		
		osd.hideGroup( carGroup = osd.endGroup() );

		//-------------------------------------------------
		osd.createBG( new ResourceRef(RID_ENGINE_BG) );
		osd.createHeader( "Dinamometro" );
		createButtons();

		int engineInstalled;
		Block engine;
		int its_vee=0;
		int has_crank=0;
		int has_pistons=0;
		int has_heads=0;

		ypos = -0.53;
		line = 0;

		//megkeressuk a motorblokkot, hogy tobb adatot kapjunk
		if( car.iteratePartsInit() )
		{
			Part part;
			while( part = car.iterateParts() )
			{
				if ( part instanceof Block )
				{
					engine = part;
					if (part instanceof Block_Vee )
						its_vee = 1;
				} 
				else
				if ( part instanceof Crankshaft ) 
					has_crank = 1; 
				else
				if ( part instanceof Piston ) 
					has_pistons = 1; 
				else
				if ( part instanceof CylinderHead )
					has_heads++;
			}
		}

		int comp_ok=0;

		/*
		System.log("its_vee="+its_vee);
		System.log("has_heads="+has_heads);
		System.log("has_pistons="+has_pistons);
		System.log("comp_ok="+comp_ok);
		*/

		if (its_vee && has_heads==2)
			comp_ok=1;
		else
		if (!its_vee && has_heads==1)
			comp_ok=1;

		if (comp_ok && has_pistons)
			comp_ok=1;
		else
			comp_ok=0;

		String error_text = null;

		DynoData dyno = null;

		if( engine )
		{
			if( car.iteratePartsInit() )
			{
				Part part;
				while( part = car.iterateParts() )
				{
					error_text = part.isDynoable();
					if (error_text)
						break;
				}
			}

			dyno = engine.dynodata;

			val = dyno.cylinders;
			osd.createText( "Cilindros:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			osd.createText( val, Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;
			val = dyno.Displacement*1000000.0;
			osd.createText( "Cilindrada:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			osd.createText( val +  " cc ", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;
			osd.createText( "Diametro:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			osd.createText( Float.toString(dyno.bore*1000.0, "%1.1f mm"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;

//----------------BB's Random Bullshit--------------------------------------------------------------------------------------------------------------------------
			osd.createText( "Altura Camisa:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			osd.createText( Float.toString(engine.cylinder_length_from_top, "%1.1f mm"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;
			osd.createText( "Altura Do Bloco:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			osd.createText( Float.toString(engine.crank_center_to_cylinder_top, "%1.1f mm"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;
//---------------------------------------------------------------------------------------------------------------------------------------------------------------

			osd.createText( "Curso:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			if (has_crank)
				osd.createText( Float.toString(dyno.stroke*1000.0, "%1.1f mm"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line);
			else
				osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line);
			line++;

			osd.createText( "Compressao.:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			if (comp_ok)
				osd.createText( Float.toString(dyno.Compression, "%1.1f:1"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line);
			else
				osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line);
			line++;

			osd.createText( "Cv/Litro:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			if (error_text)
				osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line);
			else
				osd.createText( Float.toString(dyno.maxHP / (dyno.Displacement*1000.0), "%1.1f"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line);
			line++;

			osd.createText( "kg/Cv:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			if (error_text)
				osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line);
			else
				osd.createText( Float.toString(chas.getMass()/dyno.maxHP, "%1.3f"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line);
			line++;

			osd.createText( "Kg/Nm:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			if (error_text)
				osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line);
			else
				osd.createText( Float.toString(chas.getMass()/dyno.maxTorque/10.0, "%1.3f"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line);
			line++;

			line++;
			osd.createText( "Marchas:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line); line++;
			String[] gear_names = new String[6];
			gear_names[0] = " Primeira:";
			gear_names[1] = " Segunda:";
			gear_names[2] = " Terceira:";
			gear_names[3] = " Quarta:";
			gear_names[4] = " Quinta:";
			gear_names[5] = " Sexta:";
			for ( i = 1; i <= chas.gears; i++ )
			{
				osd.createText( gear_names[i-1], Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
				osd.createText( chas.ratio[i], Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;
			}
			osd.createText( " Re:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			osd.createText( -chas.ratio[7], Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;
			osd.createText( " Diferencial:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			osd.createText( chas.rearend_ratio+":1", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;
			line++;
			val = chas.engine_rpm_idle;
			osd.createText( "Lenta:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			osd.createText( val+" RPM", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;
			val = chas.RPM_limit;
			osd.createText( "Corte de Giro:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			osd.createText( val+" RPM", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;
			val = dyno.maxRPM;
			osd.createText( "Ponto de Destruicao:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			osd.createText( val+" RPM", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;

			osd.createText( "Torque no Motor:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			if (error_text)
			{
				osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;
				osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line);
			}
			else
			{
				osd.createText( Float.toString(dyno.maxTorque*0.7353, "%1.0f ft-lbs"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;
				osd.createText( Float.toString(dyno.maxTorque, "%1.0f Nm"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line);
			}
			val = dyno.RPM_maxTorque;

			if (!error_text)
				osd.createText( " a "+val+" RPM", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			line++;

			osd.createText( "Potencia no Motor:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);
			if (error_text)
			{
				osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;
				osd.createText( "N/A", Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line);
			}
			else
			{
				osd.createText( Float.toString(dyno.maxHP/1.256, "%1.0f HP"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line); line++;
				osd.createText( Float.toString(dyno.maxHP/1.256*0.7355, "%1.0f KW"), Frontend.smallFont, Text.ALIGN_LEFT, xpos2, ypos, line);
			}
			val = dyno.RPM_maxHP;

			if (!error_text)
				osd.createText( " a "+val+" RPM", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);

			line++;
			line++;

			osd.createText( "Combustivel:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line); line++;
			osd.createText( " "+dyno.fuelType, Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line); line++;
		}
		else
			osd.createText( "Sem Motor!", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line);

		if (error_text)
			osd.createTextBox( "Informacao de Dinanometro Indisponivel, por "+error_text, Frontend.smallFont, Text.ALIGN_LEFT, graphX, ypos, graphW );
		else
			if (dyno)
			{
				graphRPMMin = 0.00;
				graphHPMin = 0.00;
				graphHPMax = 100.00;
				graphTorqueMin = 0.00;		//ft-lbs!!
				graphTorqueMax = 100.00;	//ft-lbs!!
				
				float horse;
				float torq;

				horse = dyno.maxHP/1.256;
				torq = dyno.maxTorque*0.7353;

				graphRPMMax = dyno.RPM_limit;

				if(horse >= torq)
				{
					if(graphHPMax < horse)
					{
						if( horse > 0 && horse <= 2000)
						{
							while( graphHPMax < horse )
							{
								graphHPMax += 100;
								graphTorqueMax += 100;
							}
						}
						if( horse > 2000)
						{
							while( graphHPMax < horse )
							{
								graphHPMax += 500;
								graphTorqueMax += 500;
							}
						}
					}
				}
				if(horse <= torq)
				{
					if(graphTorqueMax < torq)
					{
						if( torq > 0 && torq <= 2000)
						{
							while( graphTorqueMax < torq )
							{
								graphHPMax += 100;
								graphTorqueMax += 100;
							}
						}
						if( torq > 2000)
						{
							while( graphTorqueMax < torq )
							{
								graphHPMax += 500;
								graphTorqueMax += 500;
							}
						}
					}
				}
				for (i = 1; i <= 6; i++)
				{
					gx = graphX + 0.03;
					gy = graphY - i * (graphH / 6.0) - fontCenter;
					val = i * (graphTorqueMax / 6.0);
					osd.createText( val, graphFont, Text.ALIGN_LEFT, gx, gy).changeColor(0xFFFFFFFF);
					gx = graphX + graphW + 0.03;
					val = i * (graphHPMax / 6.0);
					osd.createText( val, graphFont, Text.ALIGN_LEFT, gx, gy).changeColor(0xFFFFFFFF);
				}
				for (i = 0; i <= 10; i += 2)
				{
					gx = graphX + i * (graphW / 9.80) - 0.03;
					gy = graphY + fontCenter;
					val = i * (graphRPMMax / 10.0);
					osd.createText( val, graphFont, Text.ALIGN_LEFT, gx, gy).changeColor(0xFFFFFFFF);
				}

				float torque;
				float hp;
				float RPM;

				RPM = graphRPMMin;
				while(RPM<=graphRPMMax)
				{
					hp = dyno.getHP(RPM,0)*0.001f*1.341f/1.256;
					gx = graphX+(RPM-graphRPMMin)/(graphRPMMax-graphRPMMin)*graphW;
					gy = graphY-(hp-graphHPMin)/(graphHPMax-graphHPMin)*graphH - fontCenter;
					osd.createText( "-", graphFont, Text.ALIGN_LEFT, gx, gy).changeColor(0xFF8080FF);

					RPM += 50.0;
				}

				RPM = graphRPMMin;
				while(RPM<=graphRPMMax)
				{
					torque = dyno.getTorque(RPM, 0.0) * 0.7376;	//normal ft-lbs!!
					gx = graphX+(RPM-graphRPMMin)/(graphRPMMax-graphRPMMin)*graphW;
					gy = graphY-(torque-graphTorqueMin)/(graphTorqueMax-graphTorqueMin)*graphH - fontCenter;
					osd.createText( "-", graphFont, Text.ALIGN_LEFT, gx, gy).changeColor(0xFFFF8080);

					RPM += 50.0;
				}
			}

		osd.hideGroup( engineGroup = osd.endGroup() );

		//-------------------------------------------------
		osd.createBG( new ResourceRef(RID_FINANCIAL_BG) );
		osd.createHeader( "Informacao Financeira" );
		createButtons();

		ypos = -0.60;
		osd.createText( "Nome", Frontend.smallFont, Text.ALIGN_LEFT, -0.90, ypos);
		osd.createText( "Destruicao", Frontend.smallFont, Text.ALIGN_LEFT, 0.08, ypos);
		osd.createText( "Desgaste", Frontend.smallFont, Text.ALIGN_LEFT, 0.26, ypos);
		osd.createText( "Multas", Frontend.smallFont, Text.ALIGN_LEFT, 0.39, ypos);
		osd.createText( "Valor", Frontend.smallFont, Text.ALIGN_LEFT, 0.57, ypos);
		ypos += 0.10;

		for( i = 0; i < 100; )
		{
			partText[i] = osd.createText( "", Frontend.smallFont, Text.ALIGN_LEFT, -0.90, ypos);
			partText[i].changeColor(0xFFC0C0C0);
			i++;
			partText[i] = osd.createText( "", Frontend.smallFont, Text.ALIGN_LEFT, 0.08, ypos);
			partText[i].changeColor(0xFFC0C0C0);
			i++;
			partText[i] = osd.createText( "", Frontend.smallFont, Text.ALIGN_LEFT, 0.26, ypos);
			partText[i].changeColor(0xFFC0C0C0);
			i++;
			partText[i] = osd.createText( "", Frontend.smallFont, Text.ALIGN_RIGHT, 0.49, ypos);
			partText[i].changeColor(0xFFFF2020);
			i++;
			partText[i] = osd.createText( "", Frontend.smallFont, Text.ALIGN_RIGHT, 0.67, ypos);
			partText[i].changeColor(0xFFC0C0C0);
			i++;
			ypos+=0.05;
		}

		int totalValue = listParts( car, 0 );

		ypos += 0.05;
		osd.createText( "Valor Total", Frontend.smallFont, Text.ALIGN_LEFT, -0.90, ypos);
		osd.createText( "$" + totalValue, Frontend.smallFont, Text.ALIGN_RIGHT, 0.60, ypos);

		Style btnUp = new Style( 0.10, 0.10, 1.0, Frontend.smallFont, Text.ALIGN_CENTER, new ResourceRef( Osd.RID_ARROWUP ) );
		osd.createButton( btnUp, 0.80, -0.45, CMD_SCROLL_UP, null );

		Style btnDn = new Style( 0.10, 0.10, 1.0, Frontend.smallFont, Text.ALIGN_CENTER, new ResourceRef( Osd.RID_ARROWDN ) );
		osd.createButton( btnDn, 0.80,  0.45, CMD_SCROLL_DOWN, null );


		osd.hideGroup( financialGroup = osd.endGroup() );

		//-------------------------------------------------
		osd.createBG( new ResourceRef(RID_RECORDS_BG) );
		osd.createHeader( "Records" );
		createButtons();

		ypos = -0.64;
		line = 0;
		xpos2 = 0.25;
		xpos3 = -0.1;

		osd.createText( "Estatistica para "+chas.vehicleName+":", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line ); line++;
		line++;

		osd.createText( "Melhor tempo Test Track:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line ); line++;

		osd.createText( " Velocidade Final:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		if( car.maxTestTrackSpeedSq < 0.10 )
			osd.createText( "Nenhum", Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		else
		{
			osd.createText( Float.toString(Math.sqrt( car.maxTestTrackSpeedSq ) * 2.24 * 1.61, "%1.1f KPH"), Frontend.smallFont, Text.ALIGN_RIGHT, xpos3, ypos, line );
			osd.createText( Float.toString(Math.sqrt( car.maxTestTrackSpeedSq ) * 2.24, "%1.1f MPH"), Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		}
		line++;

		osd.createText( " 0-100 KM/H (0-62.1 MPH):", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		if( car.bestTestTrackAcc < 0.10 )
			osd.createText( "Nenhum", Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		else
			osd.createText( String.timeToString( car.bestTestTrackAcc, String.TCF_NOMINUTES ), Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line);
		line++;

		osd.createText( " 0-200 KM/H (0-124.2 MPH):", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		if( car.bestTestTrackAcc120 < 0.10 )
			osd.createText( "Nenhum", Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		else
			osd.createText( String.timeToString( car.bestTestTrackAcc120, String.TCF_NOMINUTES ), Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		line++;

		osd.createText( " Tempo 402m:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		if( car.bestTestTrackTime2 < 0.10 )
			osd.createText( "Nenhum", Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		else
			osd.createText( String.timeToString( car.bestTestTrackTime2, String.TCF_NOMINUTES ), Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line);
		line++;

		osd.createText( " Velocidade 402m:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		if( car.bestTestTrackTime2_speedSq < 0.10 )
			osd.createText( "Nenhum", Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		else
		{
			osd.createText( Float.toString(Math.sqrt( car.bestTestTrackTime2_speedSq ) * 2.24 * 1.61, "%1.1f KPH"), Frontend.smallFont, Text.ALIGN_RIGHT, xpos3, ypos, line );
			osd.createText( Float.toString(Math.sqrt( car.bestTestTrackTime2_speedSq ) * 2.24, "%1.1f MPH"), Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		}
		line++;

		osd.createText( " Tempo 1 Milha:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		if( car.bestTestTrackTime0 < 0.10 )
			osd.createText( "Nenhum", Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		else
			osd.createText( String.timeToString( car.bestTestTrackTime0, String.TCF_NOMINUTES ), Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line);
		line++;

		osd.createText( " Velocidade 1 Milha:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		if( car.bestTestTrackTime0_speedSq < 0.10 )
			osd.createText( "Nenhum", Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		else
		{
			osd.createText( Float.toString(Math.sqrt( car.bestTestTrackTime0_speedSq ) * 2.24 * 1.61, "%1.1f KPH"), Frontend.smallFont, Text.ALIGN_RIGHT, xpos3, ypos, line );
			osd.createText( Float.toString(Math.sqrt( car.bestTestTrackTime0_speedSq ) * 2.24, "%1.1f MPH"), Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		}
		line++;

		osd.createText( " Melhor Volta:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		if( car.bestTestTrackTime1 < 0.10 )
			osd.createText( "Nenhum", Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		else
			osd.createText( String.timeToString( car.bestTestTrackTime1, String.TCF_NOHOURS ), Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		ypos += 0.10;

		osd.createText( "Sua historia com esse carro:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		line++;

		osd.createText( " Corridas:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		osd.createText( car.races_won + car.races_lost, Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line ); line++;
		osd.createText( " Vitorias:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		osd.createText( car.races_won, Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line ); line++;
		osd.createText( " Derrotas:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		osd.createText( car.races_lost, Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line ); line++;
		osd.createText( "Historico de Prestigio:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		osd.createText( Float.toString(car.getPrestigeMultiplier()*100.0, "%1.1f %%"), Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line ); line++;

		osd.createText( " Melhor Tempo 402m Noturno:", Frontend.smallFont, Text.ALIGN_LEFT, xpos, ypos, line );
		if( car.bestNightQM < 0.10 )
			osd.createText( "Nenhum", Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		else
			osd.createText( String.timeToString( car.bestNightQM, String.TCF_NOMINUTES ), Frontend.smallFont, Text.ALIGN_RIGHT, xpos2, ypos, line );
		line++;

		osd.hideGroup( recordsGroup = osd.endGroup() );

		actGroup = -1;
		page( carGroup );
	}	

	public void deleteOSDObjects()
	{
	}

//----------------------------------------------------------------------

	public void osdCommand (int command)
	{
		if (command < 0)
			return;
		else
		if (command == CMD_CAR_PAGE)
		{
			page( carGroup );
		}
		else
		if (command == CMD_ENGINE_PAGE)
		{
			page( engineGroup );
		}
		else
		if (command == CMD_FINANCIAL_PAGE)
		{
			page( financialGroup );
		}
		else
		if (command == CMD_RECORDS_PAGE)
		{
			page( recordsGroup );
		}
		else
		if (command == CMD_EXIT)
		{
			GameLogic.changeActiveSection( parentState );
		}
		else
		if( command == CMD_SCROLL_UP )
		{
			if( firstPart > 0 )
			{
				firstPart-=20;
				if( firstPart < 0 )
					firstPart = 0;

				listParts( car, firstPart );
			}
		}
		else
		if( command == CMD_SCROLL_DOWN )
		{
			if( firstPart < nParts - 20 )
			{
				firstPart+=20;
				if( firstPart > nParts - 20 )
					firstPart = nParts - 20;

				listParts( car, firstPart );
			}
		}
	}
}
