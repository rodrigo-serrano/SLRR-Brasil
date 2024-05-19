 package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.render.osd.dialog.*;	//Text
import java.sound.*;

public class OptionsDialog extends Dialog
{
	final static ResourceRef	RID_GENERALBG = new ResourceRef( frontend:0x0016r );
	
	// commands
	final static int	CMD_OPTIONS = 0;
	final static int	CMD_VIDEO_OPTIONS = 1;
	final static int	CMD_CONTROL_OPTIONS = 2;
	final static int	CMD_SOUND_OPTIONS = 3;
	final static int	CMD_REDEFINE_CONTROLS = 4;
	final static int	CMD_MAIN = 5;
	final static int	CMD_REDEFINE_DONE = 6;
	final static int	CMD_RESET_CONTROLS = 7;
	final static int	CMD_LOAD_CONTROLS = 8;
	final static int	CMD_SAVE_CONTROLS = 9;
	final static int	CMD_RESOLUTION = 10;
	final static int	CMD_VIDEO_OPTIONS_DONE = 11;
	final static int	CMD_TEXTURE_DETAIL = 12;
	final static int	CMD_SHADOW_DETAIL = 13;
	final static int	CMD_VIEW_RANGE = 14;
	final static int	CMD_EFFECTS_VOL = 15;
	final static int	CMD_MUSIC_VOL = 16;
	final static int	CMD_ENGINE_VOL = 17;
	final static int	CMD_GAME_OPTIONS = 18;
	final static int	CMD_DIFFICULTY = 19;
	final static int	CMD_TRAFFICDENSITY = 20;
	final static int	CMD_PEDESTRIANDENSITY = 21;
	final static int	CMD_CLUTCH = 22;
	final static int	CMD_STEERHELP = 23;
	final static int	CMD_ARCADE = 55;
	final static int	CMD_GAME_OPTIONS_DONE = 24;
	final static int	CMD_MOUSE_SENS = 25;
	final static int	CMD_DELETE = 54;
	final static int	CMD_DELETE2 = 56;
	final static int	CMD_DELETE3 = 57;

	final static int	CMD_REDEFINE_CONTROLS2 = 26;
	final static int	CMD_REDEFINE_CONTROLS3 = 27;
	final static int	CMD_METRIC = 28;
	final static int	CMD_GAMMA = 29;
	final static int	CMD_OBJECT_DETAIL = 30;
	final static int	CMD_LOD_DETAIL = 31;
	final static int	CMD_ABS_SLIDER = 32;
	final static int	CMD_ASR_SLIDER = 33;
	final static int	CMD_GPSMODE = 34;
	final static int	CMD_AXISCHECK = 35;
	final static int	CMD_AXISCHECK_DONE = 36;
	final static int	CMD_UNUSED = 37;
	final static int	CMD_SOUND_3D = 38;
	final static int	CMD_SOUND_HW = 39;
	final static int	CMD_GAME_OPTIONS2 = 40;
	final static int	CMD_HMF_1 = 41;
	final static int	CMD_HMF_2 = 42;
	final static int	CMD_HMF_3 = 43;
	final static int	CMD_PARTICLE = 44;
	final static int	CMD_HEADLIGHTS = 45;
	final static int	CMD_FLARES = 46;
	
	final static int	CMD_SKIDMARK = 402;
	final static int	CMD_SHADOW_RANGE = 403;
	final static int	CMD_REFRESH_TEXT = 404;
	final static int	CMD_MIRROR_DISTANCE = 405;
	final static int	CMD_DEPTH = 406;
	final static int	CMD_MODE = 407;
	final static int	CMD_UNRES = 408;
	final static int	CMD_MIRROR = 409;
	final static int	CMD_BGSCENE = 410;
	final static int	CMD_M_GROUP = 411;
	final static int	CMD_LP = 412;
	final static int	CMD_RED_SUSP = 413;

	final static int	CMD_GETKEY = 100;
	final static int	CMD_DEAD_ZONE = 200;
	final static int	CMD_POWER = 300;
	final static int	CMD_FFB = 400;
	final static int	CMD_COMPILE= 401;
	
	final static int	CMD_GARCARS= 414;

	final static int	NCONTROLS = ControlSet.NCONTROLS;

	static String[] soundHWText;
	static String[] TextureSizeText;
	static String[] ShadowSizeText;
	static String[] LP_TexList;
	static String[] detailTextOO;
	static String[] metricSystemText;
	static String[] gpsText = new String[4];
	static String[] drift_list = new String[3];
	static String[] grgcrs_list = new String[6];
	static int[]	ResX_list, ResY_list;
	
	final static float	aspectX, aspectY;
	String	Res_Aspect;
	int		Current_Resolution, aspect, color_depth, windowed, loading_primary, tmp_lp, drift_mode, tmp_drft, grgcrs_mode, tmp_grgcrs;

	Button			Resolution_button, MirrorDist_Text, Dist_Text, Gamma_Text, ShadowDist_Text, Particle_Text, SkidMark_Text, Depth_button, windowed_button, Arcade_Text, Garage_button;

	Player			player;

	int				getKey = -1;
	int				getName = -1;
	int				getKeyStat = 0;

	Text[]			keyText = new Text[NCONTROLS];

	String[]		clutchText = new String[4];
	int[]			clutchTrf, clutchTrfInv;

	Text			accelerateText,	brakeText, steeringText;

	int				axisCheckCallerGroup;

	int				mainGroup, optionsGroup, videoGroup, soundGroup, controlGroup, gameGroup, game2Group, MirrorGroup;
	int				redefineSuspGroup, redefineGroup, redefine2Group, redefine3Group, axisCheckGroup;

	int				actGroup;

	int				textureDetail;
	int				shadow_size;
	int				shadow_distance;

	MultiChoice		soundHWMulti;

	Slider[]		powerSlider;
	Slider[]		dzSlider;
	Slider[]		ffbSlider;

	Slider			acGasSlider, acBreakSlider, acSteerSlider, acClutchSlider, TextureSlider;

	
	ControlSet		controlSet;

	Style butt0 = new Style( 0.45, 0.12, Frontend.mediumFont, Text.ALIGN_LEFT, Osd.RRT_TEST );
	Style butt1 = new Style( 0.45, 0.12, Frontend.mediumFont, Text.ALIGN_CENTER, Osd.RRT_TEST );
	Style butt2 = new Style( 0.45, 0.12, Frontend.mediumFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );

	Style buttX = new Style( 0.1, 0.1, Frontend.mediumFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );

	Style sld1 = new Style( 0.45, 0.06, Frontend.mediumFont, Text.ALIGN_LEFT, new ResourceRef(Osd.RID_SLD_BACK) );
	Style sldk =  new Style( 0.04, 0.05, Frontend.mediumFont, Text.ALIGN_RIGHT, new ResourceRef(Osd.RID_SLD_KNOB) );
	Style sld2 = new Style( 0.8, 0.06, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef(Osd.RID_SLD_BACK) );

	Style Menu_Left = new Style( 0.6, 0.1, Frontend.mediumFont, Text.ALIGN_LEFT, Osd.RRT_TEST );
	Style Menu_Right = new Style( 0.6, 0.1, Frontend.mediumFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );
	Style Menu_Center = new Style( 0.6, 0.1, Frontend.mediumFont, Text.ALIGN_CENTER, Osd.RRT_TEST );

	Style Menu_Left_Small = new Style( 0.6, 0.1, Frontend.smallFont, Text.ALIGN_LEFT, Osd.RRT_TEST );
	Style Menu_Right_Small = new Style( 0.6, 0.1, Frontend.smallFont, Text.ALIGN_RIGHT, Osd.RRT_TEST );
	Style Menu_Center_Small = new Style( 0.6, 0.1, Frontend.smallFont, Text.ALIGN_CENTER, Osd.RRT_TEST );

	public OptionsDialog( int additionalFlags )
	{
		super( GameLogic.player.controller, additionalFlags|DF_FULLSCREEN|DF_LOWPRI, null, null );

		float key = Math.random()*100;
		if( MainMenu.Check(key) != Math.sqrt(key)+3.75 ) Mirans_Mod_protection_error______Please_Resintal_Mirans_Mod();

		player=GameLogic.player;

		osd.globalHandler = this;

		actGroup = -1;

		ResX_list = new int[8];
		ResX_list[0] = 1152;
		ResX_list[1] = 1280;
		ResX_list[2] = 1360;
		ResX_list[3] = 1366;
		ResX_list[4] = 1600;
		ResX_list[5] = 1776;
		ResX_list[6] = 1920;
		ResX_list[7] = 2560;

		ResY_list = new int[8];
		ResY_list[0] = 648;
		ResY_list[1] = 720;
		ResY_list[2] = 768;
		ResY_list[3] = 768;
		ResY_list[4] = 900;
		ResY_list[5] = 1000;
		ResY_list[6] = 1080;
		ResY_list[7] = 1440;

		detailTextOO = new String[2];
		detailTextOO[0] = "Off";		
		detailTextOO[1] = "On";	
		
		LP_TexList = new String[3];
		LP_TexList[0] = "Baixo";		
		LP_TexList[1] = "Medio";
		LP_TexList[2] = "Alto";
		
		TextureSizeText = new String[5];
		TextureSizeText[0] = "Super Baixo";//64 PTX
		TextureSizeText[1] = "Baixo";//128
		TextureSizeText[2] = "Medio";//256
		TextureSizeText[3] = "Alto";//512
		TextureSizeText[4] = "Super Alto";//1024

		ShadowSizeText = new String[6];
		ShadowSizeText[0] = "Off";
		ShadowSizeText[1] = "Super Baixo"; //"256 PTX"; 
		ShadowSizeText[2] = "Baixo"; //"512 PTX"; 
		ShadowSizeText[3] = "Medio";//"1024 PTX";
		ShadowSizeText[4] = "Alto";//"2048 PTX";
		ShadowSizeText[5] = "Super Alto";//"4096 PTX";

		//
		soundHWText = new String[4];
		soundHWText[0] = "SOFTWARE (Lerdo!)";
		soundHWText[1] = "HARDWARE (2D Apenas)";
		soundHWText[2] = "HARDWARE (FULL 3D)";
		soundHWText[3] = "AUTO";

		//
		clutchText[0] = "Auto+Autoembreagem";
		clutchText[1] = "Semiauto+Autoembreagem";
		clutchText[2] = "Manual+Autoembreagem";
		clutchText[3] = "Manual+Embreagem";

		clutchTrf = new int[6];	//player_transmission values -> clutch mode name indexes
		clutchTrf[0] = 2;
		clutchTrf[1] = 0;
		clutchTrf[2] = 3;
		clutchTrf[3] = -1;
		clutchTrf[4] = -1;
		clutchTrf[5] = 1;

		clutchTrfInv = new int[4];	//clutch mode name indexes -> player_transmission values
		clutchTrfInv[0] = 1;
		clutchTrfInv[1] = 5;
		clutchTrfInv[2] = 0;
		clutchTrfInv[3] = 2;

		metricSystemText = new String[2];
		metricSystemText[0]="Milhas";
		metricSystemText[1]="Kilometors";

		gpsText[0] = "Seguir carro, Relativo ao Mapa";
		gpsText[1] = "Seguir carro, Relativo ao Carro";
		gpsText[2] = "Seguir Camera, Relativo ao Mapa";
		gpsText[3] = "Seguir Camera, Relativo a Camera";

		drift_list[0] = "Off";
		drift_list[1] = "Medio";
		drift_list[2] = "Alto";

		grgcrs_list[0] = "Um";
		grgcrs_list[1] = "Dois";
		grgcrs_list[2] = "Tres";
		grgcrs_list[3] = "Quatro";
		grgcrs_list[4] = "Cinco";
		grgcrs_list[5] = "Nenhum";
	}

	public void show()
	{
	// protection
		float key = Math.random()*100;
		if( MainMenu.Check(key) != Math.sqrt(key)+3.75 )
		{
			new WarningDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "PROTECTION ERROR", "Miran Wichur Mod protection error: \n \n CORRUPTED FILES \n \n Sorry game will be close. \n Please reinstall Miran Wichur Mod." ).display();
			GameLogic.changeActiveSection( null );
		}
	
	// find the settings
		aspectX = Config.video_x;
		aspectY = Config.video_y;
		color_depth = Config.video_depth;
		windowed = Config.video_windowed;

	// Look for current resolution mode
		for (int i=0; i<=ResX_list.length-1; i++ ) 
		{
			if( aspectX == ResX_list[i] ) // identical only X size (used UNCOMMON RES, or similar mode)
			{
				Current_Resolution = i; 

				if(aspectX == ResX_list[i]) // found identical mode
				{
					Current_Resolution = i;
					i += ResX_list.length; //end 'for' loop
				}
			}
		}

	// Set current texture size
		textureDetail = 4-Config.texture_size; // if 5=>0, if 2=>3 ...

	// Set loading pimary

		if( Config.resource_refreshrate == 512 )
			loading_primary = 0;
		else
		if( Config.resource_refreshrate == 2048 )
			loading_primary = 1;
		else
		if( Config.resource_refreshrate == 4096 )
			loading_primary = 2;

		tmp_lp = loading_primary;

		// Set drift mode

		if( Config.ground_friction == 1.0 )
			drift_mode = 0;
		else
		if( Config.ground_friction == 0.8 )
			drift_mode = 1;
		else
		if( Config.ground_friction == 0.6 )
			drift_mode = 2;

		tmp_drft = drift_mode;

		// Set garage cars

		if( Config.garage_cars == 1 )
			grgcrs_mode = 0;
		else
		if( Config.garage_cars == 2 )
			grgcrs_mode = 1;
		else
		if( Config.garage_cars == 3 )
			grgcrs_mode = 2;
		else
		if( Config.garage_cars == 4 )
			grgcrs_mode = 3;
		else
		if( Config.garage_cars == 5 )
			grgcrs_mode = 4;
		else
		if( Config.garage_cars == 0 )
			grgcrs_mode = 5;

		tmp_grgcrs = grgcrs_mode;

	// Set current shadow size
		if( Config.shadow_size == 4096 )
			shadow_size = 5;
		else 
		if( Config.shadow_size == 2048 )
			shadow_size = 4;
		else 
		if( Config.shadow_size == 1024 )
			shadow_size = 3;
		else 
		if( Config.shadow_size == 512 )
			shadow_size = 2;
		else 
		if( Config.shadow_size == 256 )
			shadow_size = 1;
		else 
		if( Config.shadow_size < 64 )
			shadow_size = 0;

		float x, y, spc;
		float lpos = -1.0, mpos = -0.10;

		//--------------main menu--------------
		addCustomGroups();

		//--------------options menu--------------
		Menu m;

		osd.createBG( RID_GENERALBG );
		osd.createHeader( "Opcoes" );

		m = osd.createMenu( butt1, 0.0, -0.6, 0 );
		m.addItem("Opcoes de Video", CMD_VIDEO_OPTIONS);
		m.addItem("Opcoes de Som", CMD_SOUND_OPTIONS);
		m.addItem("Opcoes de Controle", CMD_CONTROL_OPTIONS);
		m.addItem("Opcoes de Jogo", CMD_GAME_OPTIONS);
		m.addItem("Opcoes Avancadas de Jogo", CMD_GAME_OPTIONS2);
		m.addItem("Excluir Campanha", CMD_DELETE);
		m.addItem("Excluir Carro", CMD_DELETE2);
		m.addItem("Excluir Pintura", CMD_DELETE3);

		m = osd.createMenu(butt0, -0.98, 0.95, 0);
		m.addItem("Compilar todos os Javas", CMD_COMPILE);

		m = osd.createMenu(butt2, 0.98, 0.95, 0);
		m.addItem("Voltar", CMD_MAIN);

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_MAIN, this );
		osd.hideGroup( optionsGroup = osd.endGroup() );

		//-----------video options menu--------------

osd.createBG(RID_GENERALBG);
osd.createHeader("Opcoes de Video");

// Lado esquerdo:
m = osd.createMenu(Menu_Center, -0.5, -0.5, 0);
Resolution_button = m.addItem("Resolucao de tela: --- X --- (---)", CMD_RESOLUTION, "Obter proxima resolução padrao");

m.addItem("Resolucao Incomum", CMD_UNRES, "Definir resolucao nao comum");
windowed_button = m.addItem("Modo Exibicao: ---", CMD_MODE, null);

Depth_button = m.addItem("Profundida de cor: ---", CMD_DEPTH, null);

m = osd.createMenu(Menu_Left, -0.5, 0.0, 0);
m.addItem("Farois:", CMD_HEADLIGHTS, Config.headlight_rays, detailTextOO, null);

m.addItem("Flares:", CMD_FLARES, Config.flares, detailTextOO, null);
// m.addItem( "MENU 3D SCENE:", CMD_BGSCENE, Config.BgScene, detailTextOO, null );
// m.addItem( "MIRROR OPTIONS", CMD_M_GROUP, "Configurações do espelho" );

m.addItem("Detalhe de Textura", CMD_TEXTURE_DETAIL, textureDetail, TextureSizeText, null);

m.addItem("Carregamento Primario:", CMD_LP, loading_primary, LP_TexList, "Use Baixo para um jogo mais rapido");

m.addItem("Detalhe de Sombra", CMD_SHADOW_DETAIL, shadow_size, ShadowSizeText, "Tamanho maximo da textura de sombra");

// m = osd.createMenu( Menu_Left, 0.5, -0.5, 0 );
// m.setSliderStyle( sld1, sldk );
// m.addItem( "GAMMA", CMD_GAMMA, Config.video_gamma, 0.4, 4.0, 0, "Max shadow texture size" ).printValue( "%.2f" );

// Lado direito:
m = osd.createMenu(Menu_Center, 0.5, -0.45, 0.15);

Gamma_Text = m.addItem("Gamma: " + Float.toString(Config.video_gamma, "%0.2f"), CMD_UNUSED, "Configurar o gamma do video");

m.addItem("Detalhe de Objeto", CMD_UNUSED, "Quantos detalhes sao visiveis");

m.addItem("Detalhe LOD", CMD_UNUSED, "Distancia de simplificação de objetos");

Dist_Text = m.addItem("Distancia da Visao: " + Float.toString(Config.cameras_viewrange, "%.0f m"), CMD_UNUSED, null);

ShadowDist_Text = m.addItem("Distancis de Visao Sombras: " + Float.toString(1 / Config.shadow_detail * 10, "%.0f m"), CMD_UNUSED, "Distancia maxima de visao da sombra");

SkidMark_Text = m.addItem("Comprimento das Marcas Pneu: " + Config.skidmark_max / 4 + " m", CMD_UNUSED, "Comprimento maximo das marcas de derrapagem");

Particle_Text = m.addItem("Densidade de Particulas: " + Float.toString(Config.particle_density * 100, "%.0f") + "%", CMD_UNUSED, "Densidade de fumaca de pneus, faiscas etc.");


		m = osd.createMenu(Menu_Center, 0.5, -0.5, 0.15);

m.setSliderStyle(sld2, sldk);
m.addItem(null, CMD_GAMMA, Config.video_gamma, 0.4, 4.0, 0, null);//.printValue( "%.2f" );

m.setSliderStyle(sld2, sldk);
m.addItem(null, CMD_OBJECT_DETAIL, Config.object_detail, 0.074, 0.01, 11, "Quantos detalhes sao visiveis");//.printValue( "%2f" );

m.setSliderStyle(sld2, sldk);
m.addItem(null, CMD_LOD_DETAIL, Config.object_detail_amp, 35.0, 0.2, 11, "Distancia de simplificacao de objetos");//.printValue( "%.1f" );

m.setSliderStyle(sld2, sldk);
m.addItem(null, CMD_VIEW_RANGE, Config.cameras_viewrange, 50, 2050, 81, null);

m.setSliderStyle(sld2, sldk);
m.addItem(null, CMD_SHADOW_RANGE, 1 / Config.shadow_detail * 10, 10, 100, 10, "Distancia maxima de visao da sombra");

m.setSliderStyle(sld2, sldk);
m.addItem(null, CMD_SKIDMARK, Config.skidmark_max / 4, 50, 500, 10, "Comprimento maximo das marcas de derrapagem");//.printValue( "%.0f m" );

m.setSliderStyle(sld2, sldk);
m.addItem(null, CMD_PARTICLE, Config.particle_density, 0.0, 5.0, 21, "Densidade de fumaca de pneus, faiscas, etc.");//.printValue( "%.2f" );


m = osd.createMenu(butt2, 0.98, 0.95, 0);
m.addItem("Voltar", CMD_VIDEO_OPTIONS_DONE);


		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_VIDEO_OPTIONS_DONE, this );
		osd.hideGroup( videoGroup = osd.endGroup() );

	// Mirror setings		
		//osd.createBG( RID_GENERALBG );
		/*osd.createHeader( "MIRROR OPTIONS" );

		m = osd.createMenu( Menu_Left, -0.5, 0.5, 0 );
		m.addItem( "MIRROR:", CMD_MIRROR, Config.mirror, detailTextOO, null );

		m = osd.createMenu( Menu_Center_Small, -0.5, -0.05, 0 );
		MirrorDist_Text = m.addItem( "VIEW DISTANCE: " + Float.toString(Config.camera_mirror_viewrange, "%.0f m"), CMD_UNUSED, null );
		m = osd.createMenu( Menu_Left_Small, -0.5, 0.0, 0 );
		m.setSliderStyle( sld2, sldk );
		m.addItem( null, CMD_MIRROR_DISTANCE, Config.camera_mirror_viewrange, 5, 105, 41, null );

		m = osd.createMenu( Menu_Center_Small, -0.5, 0.10, 0 );
		m.addItem( "OBJECT DETAIL", CMD_UNUSED, "How much details is visable" );
		m = osd.createMenu( Menu_Left_Small, -0.5, 0.15, 0 );
		m.setSliderStyle( sld2, sldk );
		m.addItem( null, CMD_OBJECT_DETAIL, Config.object_detail, 0.074, 0.01, 11, "How much details is visable" );//.printValue( "%2f" );

		m = osd.createMenu( Menu_Center_Small, -0.5, 0.25, 0 );
		m.addItem( "LOD DETAIL", CMD_UNUSED, "Distance of objects simplification" );
		m = osd.createMenu( Menu_Left_Small, -0.5, 0.30, 0 );
		m.setSliderStyle( sld2, sldk );
		m.addItem( null, CMD_LOD_DETAIL, Config.object_detail_amp, 35.0, 4.0, 11, "Distance of objects simplification" );//.printValue( "%.1f" );

		// right side
		m = osd.createMenu( Menu_Left, 0.6, -0.04, 0 );
		m.addItem( "SHADOW DETAIL", CMD_SHADOW_DETAIL, shadow_size, ShadowSizeText, "Max shadow texture size" );

		m = osd.createMenu( Menu_Center_Small, 0.5, 0.10, 0 );
		m.addItem( "SHADOW VIEW DISTANCE: " + Float.toString(1/Config.shadow_detail*10, "%.0f m"), CMD_UNUSED, "Max shadow view distance" );
		m = osd.createMenu( Menu_Left_Small, 0.5, 0.15, 0 );
		m.setSliderStyle( sld2, sldk );
		m.addItem( null, CMD_SHADOW_RANGE, 1/Config.shadow_detail*10, 10, 210, 21, "Max shadow view distance" );

		m = osd.createMenu( butt2, 0.98, 0.85, 0 );
		m.addItem( "BACK", CMD_VIDEO_OPTIONS );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_VIDEO_OPTIONS, this );
		osd.hideGroup( MirrorGroup = osd.endGroup() );*/


		//-----------sound options menu--------------

		osd.createBG( RID_GENERALBG );
		osd.createHeader( "Opcoes de Audio" );

		m = osd.createMenu( butt0, 0.0, -0.6, 0 );
		m.setSliderStyle( sld1, sldk );

		m.addItem( "Volume De Efeitos", CMD_EFFECTS_VOL, Sound.getVolume(Sound.CHANNEL_EFFECTS), null );
		m.addItem( "Volume Musica", CMD_MUSIC_VOL, Sound.getVolume(Sound.CHANNEL_MUSIC), null );
		m.addItem( "Ronco Do Motor", CMD_ENGINE_VOL, Sound.getVolume(Sound.CHANNEL_ENGINE), null );
		m.addSeparator();
		soundHWMulti = m.addItem( "Mixing", CMD_SOUND_HW, 0, soundHWText, null );

		m = osd.createMenu( butt2, 0.98, 0.95, 0 );
		m.addItem( "Voltar", CMD_OPTIONS );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_OPTIONS, this );
		osd.hideGroup( soundGroup = osd.endGroup() );

		//---------controller options menu--------------

		osd.createBG( RID_GENERALBG );
		osd.createHeader( "Opcoes de Controle" );

		m = osd.createMenu( butt1, 0.0, -0.6, 0 );

m.addItem("Redefinir Controles do Carro", CMD_REDEFINE_CONTROLS);
m.addItem("Redefinir Controles do Jogo", CMD_REDEFINE_CONTROLS2);
m.addItem("Configuracoes Avancadas", CMD_REDEFINE_CONTROLS3);
m.addItem("Restaurar Padrao", CMD_RESET_CONTROLS);
m.addItem("Carregar Controles", CMD_LOAD_CONTROLS);
m.addItem("Salvar Controles", CMD_SAVE_CONTROLS);

		m = osd.createMenu( butt2, 0.98, 0.95, 0 );
		m.addItem( "Voltar", CMD_OPTIONS );

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_OPTIONS, this );
		osd.hideGroup( controlGroup = osd.endGroup() );

		//-------car controller options menu--------------

osd.createBG(RID_GENERALBG);
osd.createHeader("Redefinir Controles do Carro - Dirigindo");

m = osd.createMenu(Menu_Left, -0.98, -0.83, 0, Osd.MD_HORIZONTAL);
m.addItem("Dirigindo", CMD_REDEFINE_CONTROLS);
m.addItem("Suspensao", CMD_RED_SUSP);

osd.createText("    Teclado", Frontend.mediumFont, Text.ALIGN_LEFT, lpos, -0.7);

m = osd.createMenu(butt0, -0.95, -0.45, 0);
m.addItem("Acelerar", CMD_GETKEY + 0);
m.addItem("Frear", CMD_GETKEY + 1);
m.addItem("Virar Esquerda", CMD_GETKEY + 2);
m.addItem("Virar Direita", CMD_GETKEY + 3);
m.addItem("Freio de Mao", CMD_GETKEY + 4);
m.addItem("Subir Marcha", CMD_GETKEY + 5);
m.addItem("Reduzir Marcha", CMD_GETKEY + 6);
m.addItem("Embreagem", CMD_GETKEY + 7);
m.addItem("Nitro", CMD_GETKEY + 8);
m.addItem("Buzina", CMD_GETKEY + 9);

osd.createText(" Controle", Frontend.mediumFont, Text.ALIGN_LEFT, mpos, -0.7);

m = osd.createMenu(butt0, -0.1, -0.45, 0);
m.addItem("Acelerar", CMD_GETKEY + 15);
m.addItem("Frear", CMD_GETKEY + 16);
m.addItem("Virar Esquerda", CMD_GETKEY + 17);
m.addItem("Virar Direita", CMD_GETKEY + 18);
m.addItem("Freio de Mao", CMD_GETKEY + 19);
m.addItem("Subir Marcha", CMD_GETKEY + 20);
m.addItem("Reduzir Marcha", CMD_GETKEY + 21);
m.addItem("Embreagem", CMD_GETKEY + 22);
m.addItem("Nitro", CMD_GETKEY + 23);
m.addItem("Buzina", CMD_GETKEY + 24);

m = osd.createMenu(butt2, 0.98, 0.95, 0, Osd.MD_HORIZONTAL);
m.addItem("Voltar", CMD_REDEFINE_DONE);
m.addItem("Verificar Eixos", CMD_AXISCHECK);


		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_REDEFINE_DONE, this );

		x = -0.40;
		y = -0.48;
		for (int i = 0; i < 25; i++)
		{
			if( i == 10 )
			{
				y += 0.6;
			}
			if( i == 15 )
			{
				x = 0.50;
				y = -0.48;
			}
			if (i < 10 || i > 14)
				keyText[i] = osd.createText ("Undefined", Frontend.mediumFont, Text.ALIGN_LEFT, x, y);
			y += 0.12;
		}

		osd.hideGroup( redefineGroup = osd.endGroup() );

		//-------car pneumatis suspension--------------

		osd.createBG(RID_GENERALBG);
osd.createHeader("REDEFINIR CONTROLES DO CARRO - SUSPENSAO");
osd.createRectangle(0.0, 0.0, 1.65, 1.15, -1, new ResourceRef(MW_Mod:0x0097r)); //background do carro

m = osd.createMenu(Menu_Left, -0.98, -0.83, 0, Osd.MD_HORIZONTAL);
m.addItem("DIRIGINDO", CMD_REDEFINE_CONTROLS);
m.addItem("SUSPENSAO", CMD_RED_SUSP);

osd.createText("Redefinir controles de suspensao pneumatica:", Frontend.mediumFont, Text.ALIGN_CENTER, 0.0, -0.7);

m = osd.createMenu(Menu_Center, 0.54, -0.38, 0);
m.addItem("FL", CMD_GETKEY + 65);
keyText[65] = osd.createText("Indefinido", Frontend.mediumFont, Text.ALIGN_CENTER, 0.54, -0.32);

m = osd.createMenu(Menu_Center, 0.54, -0.03, 0);
m.addItem("Frontal", CMD_GETKEY + 66);
keyText[66] = osd.createText("Indefinido", Frontend.mediumFont, Text.ALIGN_CENTER, 0.54, 0.03);

m = osd.createMenu(Menu_Center, 0.54, 0.32, 0);
m.addItem("FR", CMD_GETKEY + 67);
keyText[67] = osd.createText("Indefinido", Frontend.mediumFont, Text.ALIGN_CENTER, 0.54, 0.38);

m = osd.createMenu(Menu_Center, 0.0, -0.38, 0);
m.addItem("Esquerda", CMD_GETKEY + 68);
keyText[68] = osd.createText("Indefinido", Frontend.mediumFont, Text.ALIGN_CENTER, 0.0, -0.32);

m = osd.createMenu(Menu_Center, 0.0, -0.03, 0);
m.addItem("Todos", CMD_GETKEY + 69);
keyText[69] = osd.createText("Indefinido", Frontend.mediumFont, Text.ALIGN_CENTER, 0.0, 0.03);

m = osd.createMenu(Menu_Center, 0.0, 0.32, 0);
m.addItem("Direita", CMD_GETKEY + 70);
keyText[70] = osd.createText("Indefinido", Frontend.mediumFont, Text.ALIGN_CENTER, 0.0, 0.38);

m = osd.createMenu(Menu_Center, -0.54, -0.4, 0);
m.addItem("RL", CMD_GETKEY + 71);
keyText[71] = osd.createText("Indefinido", Frontend.mediumFont, Text.ALIGN_CENTER, -0.54, -0.32);

m = osd.createMenu(Menu_Center, -0.54, -0.03, 0);
m.addItem("Traseira", CMD_GETKEY + 72);
keyText[72] = osd.createText("Indefinido", Frontend.mediumFont, Text.ALIGN_CENTER, -0.54, 0.03);

m = osd.createMenu(Menu_Center, -0.54, 0.32, 0);
m.addItem("RR", CMD_GETKEY + 73);
keyText[73] = osd.createText("Indefinido", Frontend.mediumFont, Text.ALIGN_CENTER, -0.54, 0.38);

m = osd.createMenu(Menu_Right, 0.2, 0.7, 0);
m.addItem("Mudar Modo (Cima/Baixo)", CMD_GETKEY + 74);
keyText[74] = osd.createText("Indefinido", Frontend.mediumFont, Text.ALIGN_LEFT, 0.22, 0.66);

m = osd.createMenu(butt2, 0.98, 0.95, 0);
m.addItem("Voltar", CMD_REDEFINE_DONE);

		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_REDEFINE_DONE, this );

		osd.hideGroup( redefineSuspGroup = osd.endGroup() );

		//-------game controller options menu--------------

		osd.createBG(RID_GENERALBG);
osd.createHeader("Redefinir Controles do Jogo");
osd.createText("    Teclado", Frontend.mediumFont, Text.ALIGN_LEFT, lpos, -0.7);

m = osd.createMenu(butt0, -0.95, -0.45, 0);
//m.addItem("PAUSE", CMD_GETKEY + 10);
m.addSeparator();
m.addSeparator();
m.addItem("Proxima estacao de Radio", CMD_GETKEY + 11);
m.addItem("Estacao de Radio Anterior", CMD_GETKEY + 12);
m.addItem("Aumentar Volume", CMD_GETKEY + 13);
m.addItem("Diminuir Volume", CMD_GETKEY + 14);
m.addItem("Piloto Automatico", CMD_GETKEY + 75);
m.addItem("Olhar para Tras", CMD_GETKEY + 76);
m.addItem("Mapa", CMD_GETKEY + 77);
m.addItem("Screenshoot", CMD_GETKEY + 25);
m.addItem("Zoom +", CMD_GETKEY + 63);
m.addItem("Zoom -", CMD_GETKEY + 64);

osd.createText(" Controle", Frontend.mediumFont, Text.ALIGN_LEFT, mpos, -0.7);

m = osd.createMenu(butt0, -0.1, -0.45, 0);
m.addItem("Pausar", CMD_GETKEY + 78);
m.addItem("Proxima estacao de Radio", CMD_GETKEY + 79);
m.addItem("Estacao de Radio Anterior", CMD_GETKEY + 80);
m.addItem("Aumentar Volume", CMD_GETKEY + 81);
m.addItem("Diminuir Volume", CMD_GETKEY + 82);
m.addItem("Piloto Automatico", CMD_GETKEY + 83);
m.addItem("Olhar para Tras", CMD_GETKEY + 84);
m.addItem("Mapa", CMD_GETKEY + 85);
m.addItem("Screenshoot", CMD_GETKEY + 86);

m = osd.createMenu(butt2, 0.98, 0.95, 0);
m.addItem("Voltar", CMD_REDEFINE_DONE);


		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_REDEFINE_DONE, this );

		x =  -0.40;
		y = -0.36;
		for (int i = 11; i <= 14; i++)
		{
			keyText[i] = osd.createText ("Indefinido", Frontend.mediumFont, Text.ALIGN_LEFT, x, y);
			y += 0.12;
		}

		y = 0.12;
		for (int i = 75; i <= 77; i++)
		{
			keyText[i] = osd.createText ("Indefinido", Frontend.mediumFont, Text.ALIGN_LEFT, x, y);
			y += 0.12;
		}

		y = 0.48;
		for (int i = 25; i <= 25; i++)
		{
			keyText[i] = osd.createText ("Indefinido", Frontend.mediumFont, Text.ALIGN_LEFT, x, y);
			y += 0.12;
		}

		y = 0.60;
		for (int i = 63; i <= 64; i++)
		{
			keyText[i] = osd.createText ("Indefinido", Frontend.mediumFont, Text.ALIGN_LEFT, x, y);
			y += 0.12;
		}

		x =  0.40;
		y = -0.48;
		for (int i = 78; i <= 86; i++)
		{
			keyText[i] = osd.createText ("Indefinido", Frontend.mediumFont, Text.ALIGN_LEFT, x, y);
			y += 0.12;
		}

		/*x =  0.30;
		y = -0.63;
		for (int i = 11; i <= 14; i++)
		{
			keyText[i] = osd.createText ("Undefined", Frontend.mediumFont, Text.ALIGN_LEFT, x, y);
			y += 0.12;
		}

		y = -0.09;
		for (int i = 75; i <= 77; i++)
		{
			keyText[i] = osd.createText ("Undefined", Frontend.mediumFont, Text.ALIGN_LEFT, x, y);
			y += 0.12;
		}*/

		osd.hideGroup( redefine2Group = osd.endGroup() );

		//-------------advanced settings menu----------------

		powerSlider = new Slider[4];
		dzSlider = new Slider[4];
		ffbSlider = new Slider[2];

osd.createBG(RID_GENERALBG);
osd.createHeader("Configuracoes Avancadas de Controle");

m = osd.createMenu(butt1, 0.0, -0.6, 0);
m.setSliderStyle(sld1, sldk);

powerSlider[0] = m.addItem("Gamma do Acelerador", CMD_POWER + 0, 0.0, null);
powerSlider[1] = m.addItem("Gamma do Freio", CMD_POWER + 1, 0.0, null);
powerSlider[2] = m.addItem("Gamma da Direcao", CMD_POWER + 2, 0.0, null);
powerSlider[3] = m.addItem("Gamma da Embreagem", CMD_POWER + 3, 0.0, null);

m.addItem("Sensibilidade do Mouse", CMD_MOUSE_SENS, Config.mouseSensitivity, null);

dzSlider[0] = m.addItem("Zona Morta do Acelerador", CMD_DEAD_ZONE + 0, 0.0, null);
dzSlider[1] = m.addItem("Zona Morta do Freio", CMD_DEAD_ZONE + 1, 0.0, null);
dzSlider[2] = m.addItem("Zona Morta da Direcao", CMD_DEAD_ZONE + 2, 0.0, null);
dzSlider[3] = m.addItem("Zona Morta da Embreagem", CMD_DEAD_ZONE + 3, 0.0, null);

m.addSeparator();
ffbSlider[0] = m.addItem("Forca real do FFB", CMD_FFB + 0, Config.FFB_strength, 0.0f, 20.0f, 0, null);
ffbSlider[1] = m.addItem("Forca emulada do FFB", CMD_FFB - 1, Config.FFB_strength_emulated, 0.0f, 20.0f, 0, null);

m = osd.createMenu(butt2, 0.98, 0.95, 0, Osd.MD_HORIZONTAL);
m.addItem("Voltar", CMD_REDEFINE_DONE);
m.addItem("Verificar Eixos", CMD_AXISCHECK);


		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_REDEFINE_DONE, this );

		osd.hideGroup( redefine3Group = osd.endGroup() );

		//-------------axis checker menu----------------

		osd.createBG(RID_GENERALBG);
osd.createHeader("Visualizar eixos de Controle");
osd.createText("Revise como os eixos respondem aos controles do carro:", Frontend.mediumFont, Text.ALIGN_LEFT, -0.95, -0.7);

Style sldac = new Style(0.85, 0.06, Frontend.mediumFont, Text.ALIGN_CENTER, new ResourceRef(Osd.RID_SLD_BACK));

m = osd.createMenu(butt1, 0.0, -0.45, 0);
m.setSliderStyle(sldac, sldk);

acGasSlider = m.addItem("Acelerador", CMD_UNUSED, 0.0, 0.0, 1.0, 0, null);
acGasSlider.nofocus = 1;
m.addSeparator();
acBreakSlider = m.addItem("Freio", CMD_UNUSED, 0.0, 0.0, 1.0, 0, null);
acBreakSlider.nofocus = 1;
m.addSeparator();
acSteerSlider = m.addItem("Direcao", CMD_UNUSED, 0.5, 0.0, 1.0, 0, null);
acSteerSlider.nofocus = 1;
m.addSeparator();
acClutchSlider = m.addItem("Embreagem", CMD_UNUSED, 0.5, 0.0, 1.0, 0, null);
acClutchSlider.nofocus = 1;

m = osd.createMenu(butt2, 0.98, 0.95, 0);
m.addItem("Voltar", CMD_AXISCHECK_DONE);


		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_AXISCHECK_DONE, this );

		osd.hideGroup( axisCheckGroup = osd.endGroup() );

		//-------------game options menu----------------

osd.createBG(RID_GENERALBG);
osd.createHeader("Opcoes do Jogo");

m = osd.createMenu(butt0, 0.0, -0.6, 0);
m.setSliderStyle(sld1, sldk);

m.addItem("Cambio", CMD_CLUTCH, clutchTrf[Config.player_transmission], clutchText, null);
m.addItem("Sistema Metrico", CMD_METRIC, Config.metricSystem, metricSystemText, null);
m.addItem("Modo GPS", CMD_GPSMODE, Config.gpsMode, gpsText, null);
m.addItem("Modo DRIFT", CMD_ARCADE, drift_mode, drift_list, null);
m.addItem("Carros na Garagen: ", CMD_GARCARS, grgcrs_mode, grgcrs_list, null);
m.addSeparator();
m.addItem("Nivel de Dificuldade", CMD_DIFFICULTY, Config.deformation, 0.5, 1.5, 0, null);
m.addSeparator();
m.addItem("Controle Estabilidade", CMD_STEERHELP, Config.player_steeringhelp, null);
m.addItem("Freio ABS", CMD_ABS_SLIDER, Config.player_abs, null);
m.addItem("Controle Tracao", CMD_ASR_SLIDER, Config.player_asr, null);

m = osd.createMenu(butt2, 0.98, 0.95, 0);
m.addItem("Voltar", CMD_GAME_OPTIONS_DONE);

osd.createHotkey(Input.AXIS_CANCEL, Input.VIRTUAL, CMD_GAME_OPTIONS_DONE, this);
osd.hideGroup(gameGroup = osd.endGroup());


		//-------------game options 2 menu----------------

		osd.createBG(RID_GENERALBG);
osd.createHeader("Opcoes Avancadas do Jogo");

m = osd.createMenu(butt0, 0.0, -0.6, 0);
m.setSliderStyle(sld1, sldk);

m.addItem("Movimento do Motorista/Direcao", CMD_HMF_1, Config.head_move_steer, 0.0, 2.0, 0, "Como a Posicao do volante Afeta o Movimento do Motorista");
m.addItem("Movimento do Motorista/Velocidade", CMD_HMF_2, Config.head_move_vel, 0.0, 2.0, 0, "Como a Velocidade do carro Afeta o Movimento do Motorista");
m.addItem("Movimento do Motorista/Aceleracao", CMD_HMF_3, Config.head_move_acc, 0.0, 2.0, 0, "Como a Aceleracao do carro Afeta o Movimento do Motorista");
m.addSeparator();
m.addItem("Densidade de Transito", CMD_TRAFFICDENSITY, Config.trafficDensity, 0.0, 5.0, 0, null);
m.addItem("Densidade de Pedestres", CMD_PEDESTRIANDENSITY, Config.pedestrianDensity, 0.0, 1.5, 0, null);

m = osd.createMenu(butt2, 0.98, 0.95, 0);
m.addItem("Voltar", CMD_GAME_OPTIONS_DONE);


		osd.createHotkey( Input.AXIS_CANCEL, Input.VIRTUAL, CMD_GAME_OPTIONS_DONE, this );
		osd.hideGroup( game2Group = osd.endGroup() );

		super.show();

		enableAnimateHook();
	}

	public void hide()
	{
		disableAnimateHook();
		super.hide();
	}


	public void addCustomGroups()
	{
	}


//--------------------------------------------------------------------------------------
	public void setDetailText( Text txt, int detail )
	{
		if( detail == Config.OFF )
			txt.changeText( "Off" );
		else
		if( detail == Config.LOW )
			txt.changeText( "Baixo" );
		else
		if( detail == Config.MID )
			txt.changeText( "Medio" );
		else
		if( detail == Config.HIGH )
			txt.changeText( "Alto" );
		/*else
		if( detail == Config.SHIGH )
			txt.changeText( "Super High" );*/
	}

	public void setEnabledText( Text txt, int enabled )
	{
		if( enabled == 0 )
			txt.changeText( "Desativado" );
		else
			txt.changeText( "Ativado" );
	}

	public int ChangeDetail (int value, int delta, int min, int max)
	{
		value += delta;
		if( value < min )
			value = max;
		if( value > max )
			value = min;
		return value;
	}

	public int fequal( float v1, float v2 )
	{
		float d = v1 - v2;
		if( d < 0 )
			d = -d;
		if( d < 0.001 )
			return 1;

		return 0;
	}

	public void osdCommand (int command)
	{
		if (command < 0)
			return;
		else
		if(command == CMD_COMPILE)
		{
			System.compileAll( "." );
			new SfxRef(DestructionTools:0x0039r).play(); // SFX
		}
		if (command == CMD_AXISCHECK)
		{
			axisCheckCallerGroup = actGroup;
			changeMode (axisCheckGroup);

			//a redefine menuk -ahonnan mi elerhetoek vagyunk- mar beallitottak, de meg nem mentettek a beallitasokat
			player.controller.setcontrol( controlSet );
		}
		else
		if (command == CMD_AXISCHECK_DONE)
		{
			changeMode (axisCheckCallerGroup);
		}
		else
		if (command == CMD_EFFECTS_VOL)
		{
			Sound.setVolume ( Sound.CHANNEL_EFFECTS, osd.sliderValue );
		}
		else
		if (command == CMD_MUSIC_VOL)
		{
			Sound.setVolume ( Sound.CHANNEL_MUSIC, osd.sliderValue );
		}
		else
		if (command == CMD_ENGINE_VOL)
		{
			Sound.setVolume ( Sound.CHANNEL_ENGINE, osd.sliderValue );
		}
		else
		if (command == CMD_OPTIONS)
		{
			changeMode (optionsGroup);
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
					reallyDelete = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Deletar Campanha", "Deseja deletar a campanha atual?" ).display() );
				else
					reallyDelete = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Deletar Campanha", "Deseja continuar?" ).display() );

				if( reallyDelete )
				{
					File.delete( filename );
					File.delete( filename + ".1" );
					File.delete( filename + ".2" );
					File.delete( filename + ".3" );
					File.delete( filename + ".4" );
					File.delete( filename + ".5" );
					File.delete( filename + ".6" );
					File.delete( filename + ".7" );
					File.delete( filename + ".8" );
					File.delete( filename + ".9" );
					File.delete( filename + ".10" );
					File.delete( filename + ".11" );
					File.delete( filename + ".12" );
					File.delete( filename + ".13" );
					File.delete( filename + ".14" );
					File.delete( filename + ".15" );
					File.delete( filename + ".16" );
					File.delete( filename + ".17" );
					File.delete( filename + ".18" );
					File.delete( filename + ".19" );
					File.delete( filename + ".20" );
					File.delete( filename + ".21" );
					File.delete( filename + ".22" );
					File.delete( filename + ".23" );
					File.delete( filename + ".24" );
					File.delete( filename + ".25" );
					File.delete( filename + ".26" );
					File.delete( filename + ".27" );
					File.delete( filename + ".28" );
					File.delete( filename + ".29" );
					File.delete( filename + ".30" );
					File.delete( filename + ".31" );
					File.delete( filename + ".32" );
					File.delete( filename + ".33" );
					File.delete( filename + ".34" );
					File.delete( filename + ".35" );
					File.delete( filename + ".36" );
					File.delete( filename + ".37" );
					File.delete( filename + ".38" );
					File.delete( filename + ".39" );
					File.delete( filename + ".40" );
				}
			}
		}
		else
		if (command == CMD_DELETE2)
		{
			VehicleFileReqDialog d = new VehicleFileReqDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Deletar Carro", "Deletar Carro", GameLogic.carSaveDir, "*" );

			if( d.display() == 0 )
			{
				String filename = GameLogic.carSaveDir + d.fileName;

				int selectedCar = 0;
				int deleteCar;

				if( selectedCar )
					deleteCar = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Deletar Carro", "Deseja mesmo deletar este Carro?" ).display() );
				else
					deleteCar = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Deletar Carro", "Deseja Continuar?" ).display() );

				if (deleteCar)
				{						
					File.delete( filename );
					File.delete( filename + ".1" );
					File.delete( filename + ".2" );
					File.delete( filename + ".3" );
					File.delete( filename + ".4" );
					File.delete( filename + ".5" );
					File.delete( filename + ".6" );
					File.delete( filename + ".7" );
					File.delete( filename + ".8" );
					File.delete( filename + ".9" );
					File.delete( filename + ".10" );
					File.delete( filename + ".11" );
					File.delete( filename + ".12" );
					File.delete( filename + ".13" );
					File.delete( filename + ".14" );
					File.delete( filename + ".15" );
					File.delete( filename + ".16" );
					File.delete( filename + ".17" );
					File.delete( filename + ".18" );
					File.delete( filename + ".19" );
					File.delete( filename + ".20" );
					File.delete( filename + ".21" );
					File.delete( filename + ".22" );
					File.delete( filename + ".23" );
					File.delete( filename + ".24" );
					File.delete( filename + ".25" );
					File.delete( filename + ".26" );
					File.delete( filename + ".27" );
					File.delete( filename + ".28" );
					File.delete( filename + ".29" );
					File.delete( filename + ".30" );
					File.delete( filename + ".31" );
					File.delete( filename + ".32" );
					File.delete( filename + ".33" );
					File.delete( filename + ".34" );
					File.delete( filename + ".35" );
					File.delete( filename + ".36" );
					File.delete( filename + ".37" );
					File.delete( filename + ".38" );
					File.delete( filename + ".39" );
					File.delete( filename + ".40" );
				}
			}
		}
		else
		if (command == CMD_DELETE3)
		{
			VehicleSkinFileReqDialog d = new VehicleSkinFileReqDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Deletar Carro", "Deletar Carro", GameLogic.skinSaveDir, "*" );

			if( d.display() == 0 )
			{
				String filename = GameLogic.skinSaveDir + d.fileName;

				int selectedPJ = 0;
				int deletePJ;

				if( selectedPJ )
					deletePJ = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Deletar Pintura", "Deseja Deletar essa Pintura?" ).display() );
				else
					deletePJ = ( 0 == new NoYesDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Deletar Pintura", "Deseja Continuar?" ).display() );

				if (deletePJ)
				{						
					File.delete( filename );
					File.delete( filename + ".1" );
					File.delete( filename + ".2" );
					File.delete( filename + ".3" );
					File.delete( filename + ".4" );
					File.delete( filename + ".5" );
					File.delete( filename + ".6" );
					File.delete( filename + ".7" );
					File.delete( filename + ".8" );
					File.delete( filename + ".9" );
					File.delete( filename + ".10" );
					File.delete( filename + ".11" );
					File.delete( filename + ".12" );
					File.delete( filename + ".13" );
					File.delete( filename + ".14" );
					File.delete( filename + ".15" );
					File.delete( filename + ".16" );
					File.delete( filename + ".17" );
					File.delete( filename + ".18" );
					File.delete( filename + ".19" );
					File.delete( filename + ".20" );
					File.delete( filename + ".21" );
					File.delete( filename + ".22" );
					File.delete( filename + ".23" );
					File.delete( filename + ".24" );
					File.delete( filename + ".25" );
					File.delete( filename + ".26" );
					File.delete( filename + ".27" );
					File.delete( filename + ".28" );
					File.delete( filename + ".29" );
					File.delete( filename + ".30" );
					File.delete( filename + ".31" );
					File.delete( filename + ".32" );
					File.delete( filename + ".33" );
					File.delete( filename + ".34" );
					File.delete( filename + ".35" );
					File.delete( filename + ".36" );
					File.delete( filename + ".37" );
					File.delete( filename + ".38" );
					File.delete( filename + ".39" );
					File.delete( filename + ".40" );
				}
			}
		}
		else
		if (command == CMD_VIDEO_OPTIONS)
		{
			changeMode (videoGroup);
		}
		else
		if (command == CMD_VIDEO_OPTIONS_DONE)
		{
			System.getConfigOptions();

			if(Config.video_x != aspectX || Config.video_y != aspectY || Config.video_depth != color_depth || Config.video_windowed != windowed )
			{
				int Correct_Mode = 0;

				if(Config.video_windowed == 1)
				{
					int d = ( 0 == new NoYesDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Aviso", "E Necessario Reiniciar o Jogo. \n Deseja fazer isso agora? \n \n Sua Campanha sera Salva." ).display() );

					Config.video_windowed = windowed;
					Config.video_x=aspectX;
					Config.video_y=aspectY;
					Config.video_depth=color_depth;

					if( d == 1 )
					{
						//if( carreerMode )
							GameLogic.autoSaveQuiet(); // Save

						GameLogic.changeActiveSection( null ); // Exit game
					}
					else
					{
						changeMode(optionsGroup);
					}
				}
				else
				{
					if(Config.video_windowed != windowed)
					{
						int d = ( 0 == new NoYesDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Aviso", "E Necessario Reiniciar o Jogo. \n Deseja fazer isso agora? \n \n Sua Campanha sera Salva." ).display() );

						Config.video_windowed = windowed;
						Config.video_x=aspectX;
						Config.video_y=aspectY;
						Config.video_depth=color_depth;

						if( d == 1 )
						{
							//if( carreerMode )
								GameLogic.autoSaveQuiet(); // Save

							GameLogic.changeActiveSection( null ); // Exit game
						}
						else
						{
							changeMode(optionsGroup);
						}
					}
					else
					{
						// check resolution
						for (int i=2; i<=ResX_list.length-1; i++ ) 
						{
							if(aspectX == ResX_list[i] && aspectY == ResY_list[i]) // found corect mode
							{
								Correct_Mode = 1;
								i += ResX_list.length; //end 'for' loop
							}
						}

						if( Correct_Mode )
						{
							Config.video_windowed=windowed;
							Config.video_x=aspectX;
							Config.video_y=aspectY;
							Config.video_depth=color_depth;

							GfxEngine.changeVideoMode( 320, 240, 16 ); // refresh for more compatible
							GfxEngine.changeVideoMode( 640, 480, 32 ); // refresh for more compatible
							GfxEngine.changeVideoMode( Config.video_x, Config.video_y, Config.video_depth );

							Frontend.setFonts();

							changeMode(optionsGroup);
						}
						else
						{
							new WarningDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Aviso", "Essa Resolucao nao e Valida! \n \n Troque a Resolucao ou o Modo de Exibicao." ).display();
						}
					}
				}
			}
			else
			{
				changeMode(optionsGroup);

				if( tmp_lp != loading_primary )
				{
					if( 0 == new NoYesDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Aviso", "E Necessario Reiniciar o Jogo. \n Deseja fazer isso agora? \n \n Sua Campanha sera Salva." ).display() )
					{
						GameLogic.autoSaveQuiet(); // Save
						GameLogic.changeActiveSection( null ); // Exit game
					}
				}
			}
		}
		else
		if (command == CMD_M_GROUP)
		{
			changeMode(MirrorGroup);
		}
		if (command == CMD_RESOLUTION)
		{
			if(Current_Resolution < ResX_list.length-1)
				Current_Resolution += 1;
			else
				Current_Resolution = 0;

			aspectX = ResX_list[Current_Resolution];
			aspectY = ResY_list[Current_Resolution];

			osdCommand(CMD_REFRESH_TEXT);
		}
		else
		if (command == CMD_REFRESH_TEXT)
		{
			if(!aspectX)
			{
				aspectX = Config.video_x;
				aspectY = Config.video_y;
			}

			int TMPasp = 10*aspectX/aspectY;
			aspect = TMPasp;

			if(aspect == 10)	Res_Aspect = "1:1"; else
			if(aspect == 12)	Res_Aspect = "5:4"; else
			if(aspect == 13)	Res_Aspect = "4:3"; else
			if(aspect == 14)	Res_Aspect = "13:9"; else
			if(aspect == 15)	Res_Aspect = "14:9"; else
			if(aspect == 16)	Res_Aspect = "5:3"; else
			if(aspect == 17)	Res_Aspect = "16:9"; else
			if(aspect == 20)	Res_Aspect = "6:3"; else
			if(aspect == 23)	Res_Aspect = "12:5"; else
			if(aspect == 24)	Res_Aspect = "12:5"; else
			Res_Aspect = "Outra";

			if(Resolution_button)
			{
				Resolution_button.changeLabelText( "Resolucao: "+Float.toString(aspectX, "%.0f")+" X "+Float.toString(aspectY, "%.0f")+" ("+Res_Aspect+")");
				Depth_button.changeLabelText("Profundidade de Cor: "+color_depth);
				
				if(windowed == 0)
					windowed_button.changeLabelText( "Modo Tela: Fullscreen" );
				else
					windowed_button.changeLabelText( "Modo Tela: Janela" );
			}
		}
		else
		if(command == CMD_DEPTH)
		{
			if(Config.video_depth == 16)
				color_depth = 32;
			else
				color_depth = 16;
				
			Depth_button.changeLabelText("Profundidade de Cor: "+color_depth);
		}
		if(command == CMD_MODE)
		{
			if(windowed == 0)
			{
				windowed = 1;
				windowed_button.changeLabelText( "Modo Tela: Janela" );
			}
			else
			{
				windowed = 0;
				windowed_button.changeLabelText( "Modo Tela: Fullscreen" );
			}
		}
		if(command == CMD_UNRES)
		{
			new UR_Dialog().display();
			osdCommand(CMD_REFRESH_TEXT);
		}
		if (command == CMD_TEXTURE_DETAIL)
		{
			textureDetail = osd.multiValue;
			Config.texture_size = 4-textureDetail;
		}
		else
		if (command == CMD_ABS_SLIDER)
		{
			Config.player_abs = osd.sliderValue;
		}
		else
		if (command == CMD_ASR_SLIDER)
		{
			Config.player_asr = osd.sliderValue;
		}
		else
		if (command == CMD_GARCARS)
		{
			grgcrs_mode = osd.multiValue;

			if(grgcrs_mode == 0) // ONE CAR
			{
				Config.garage_cars = 1;
			}
			else
			if(grgcrs_mode == 1) // TWO CARS
			{
				Config.garage_cars = 2;
			}
			if(grgcrs_mode == 2) // THREE CARS
			{
				Config.garage_cars = 3;
			}
			if(grgcrs_mode == 3) // FOUR CARS
			{
				Config.garage_cars = 4;
			}
			if(grgcrs_mode == 4) // FIVE CARS
			{
				Config.garage_cars = 5;
			}
			if(grgcrs_mode == 5) // NO CARS
			{
				Config.garage_cars = 0;
			}
		}
		else
		if (command == CMD_HMF_1)
		{
			Config.head_move_steer = osd.sliderValue;
		}
		else
		if (command == CMD_HMF_2)
		{
			Config.head_move_vel = osd.sliderValue;
		}
		else
		if (command == CMD_HMF_3)
		{
			Config.head_move_acc = osd.sliderValue;
		}
		else
		if (command == CMD_SHADOW_DETAIL)
		{
			shadow_size = osd.multiValue;

			if( shadow_size == 5 )
			{
				Config.shadow_size = 4096;
				Config.shadows = 2;
			}
			else
			if( shadow_size == 4 )
			{
				Config.shadow_size = 2048;
				Config.shadows = 2;
			}
			else
			if( shadow_size == 3 )
			{
				Config.shadow_size = 1024;
				Config.shadows = 2;
			}
			else
			if( shadow_size == 2 )
			{
				Config.shadow_size = 512;
				Config.shadows = 1;
			}
			else
			if( shadow_size == 1 )
			{
				Config.shadow_size = 256;
				Config.shadows = 1;
			}
			else
			{
				Config.shadow_size = 32;
				Config.shadows = 0;
			}
			//CMD_VIDEO_OPTIONS_DONE hatasara lep ervenybe!
			refreshCameras();
		}
		else
		if (command == CMD_SHADOW_RANGE)
		{
			Config.shadow_detail = 1/osd.sliderValue;
			Config.shadow_detail = Config.shadow_detail*10;
			ShadowDist_Text.changeLabelText("Distancia de Sombras: " + Float.toString(1/Config.shadow_detail*10, "%.0f m") );

			refreshCameras();
		}
		else
		if(command == CMD_LP)
		{
			loading_primary = osd.multiValue;

			if(loading_primary == 0) // LOW
			{
				Config.resource_refreshrate = 512;
				Config.resource_loadrate = 512;
			}
			else
			if(loading_primary == 1) // MEDIUM
			{
				Config.resource_refreshrate = 2048;
				Config.resource_loadrate = 2048;
			}
			if(loading_primary == 2) // HIGHT
			{
				Config.resource_refreshrate = 4096;
				Config.resource_loadrate = 4096;
			}
		}
		if (command == CMD_FLARES)
		{
			Config.flares = osd.multiValue;
			refreshCameras();
		}
		else
		if (command == CMD_HEADLIGHTS)
		{
			Config.headlight_rays = osd.multiValue;
			refreshCameras();
		}
		/*else
		if (command == CMD_BGSCENE)
		{
			Config.BgScene = osd.multiValue;
		}
		else
		if (command == CMD_MIRROR)
		{
			Config.mirror = osd.multiValue;
		}*/
		else
		if (command == CMD_VIEW_RANGE)
		{
			Config.cameras_viewrange = osd.sliderValue;
			Config.camera_ext_viewrange = osd.sliderValue;
			Config.camera_int_viewrange = osd.sliderValue/2;
			Dist_Text.changeLabelText("Distancia de Visao: " + Float.toString(Config.cameras_viewrange, "%.0f m"));
			refreshCameras();
		}
		/*else
		if (command == CMD_MIRROR_DISTANCE)
		{
			Config.camera_mirror_viewrange = osd.sliderValue;
			MirrorDist_Text.changeLabelText("MIRROR VIEW DISTANCE: " + Float.toString(Config.camera_mirror_viewrange, "%.0f m"));
			refreshCameras();
		}*/
		else
		if (command == CMD_OBJECT_DETAIL)
		{
			Config.object_detail = osd.sliderValue;
			refreshCameras();
		}
		else
		if (command == CMD_LOD_DETAIL)
		{
			Config.object_detail_amp = osd.sliderValue;
			refreshCameras();
		}
		else
		if (command == CMD_PARTICLE)
		{
			Config.particle_density = osd.sliderValue;
			Particle_Text.changeLabelText("Densidade de Particulas: " + Float.toString(Config.particle_density*100, "%.0f")+"%");
			refreshCameras();
		}
		else
		if (command == CMD_GAMMA)
		{
			Config.video_gamma = osd.sliderValue;
			Gamma_Text.changeLabelText("Gamma: " + Float.toString(Config.video_gamma, "%.2f"));
			refreshCameras();
		}
		else
		if (command == CMD_CONTROL_OPTIONS)
		{
			changeMode (controlGroup);
		}
		else
		if (command == CMD_GAME_OPTIONS)
		{
			changeMode (gameGroup);
		}
		else
		if (command == CMD_GAME_OPTIONS2)
		{
			changeMode (game2Group);
		}
		else
		if (command == CMD_GPSMODE)
		{
			Config.gpsMode = osd.multiValue;
		}
		if (command == CMD_METRIC)
		{
			Config.metricSystem = osd.multiValue;		// miles, kilometers, 
			if( Config.metricSystem == 0 )
				System.setMeasure( 1600 );
			else
				System.setMeasure( 1000 );
		}
		else
		if (command == CMD_DIFFICULTY)
		{
			Config.deformation = osd.sliderValue;
			Config.internal_damage = osd.sliderValue;
			Config.player_damage_multiplier = osd.sliderValue / 2.0;
		}
		else
		if (command == CMD_TRAFFICDENSITY)
		{
			Config.trafficDensity = osd.sliderValue;
		}
		else
		if (command == CMD_PEDESTRIANDENSITY)
		{
			Config.pedestrianDensity = osd.sliderValue;
		}
		if (command == CMD_SKIDMARK)
		{
			Config.skidmark_max = osd.sliderValue * 4.0;
			SkidMark_Text.changeLabelText("Comprimento das marcas de Derrapagem: "+Config.skidmark_max/4+" m");
		}
		else
		if (command == CMD_CLUTCH)
		{
			Config.player_transmission = clutchTrfInv[osd.multiValue];
		}
		else
		if (command == CMD_STEERHELP)
		{
			Config.player_steeringhelp = osd.sliderValue;
		}
		else
		if (command == CMD_ARCADE)
		{
			drift_mode = osd.multiValue;

			if(drift_mode == 0) // OFF
			{
				Config.ground_friction = 1.0;
			}
			else
			if(drift_mode == 1) // MEDIUM
			{
				Config.ground_friction = 0.8;
			}
			if(drift_mode == 2) // HIGH
			{
				Config.ground_friction = 0.6;
			}
		}
		else
		if (command == CMD_GAME_OPTIONS_DONE)
		{
			System.getConfigOptions();
			{
				changeMode(optionsGroup);

				if( tmp_drft != drift_mode )
				{
					if( 0 == new NoYesDialog( GameLogic.player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Aviso", "E Necessario Reiniciar o Jogo. \n Deseja fazer isso agora? \n \n Sua Campanha sera Salva." ).display() )
					{
						GameLogic.autoSaveQuiet(); // Save
						GameLogic.changeActiveSection( null ); // Exit game
					}
				}
			}
		}
		else
		if (command == CMD_SOUND_OPTIONS)
		{
			//lehetseges modeok, es kijelzesuk
			//MIX	OFF	ON	ON	AUTO
			//3D	OFF	OFF	ON	AUTO
			//		OFF	2D	3D	AUTO

			int soundHW = Config.Sound_Mix_HW;
			if( soundHW == 2 )
				soundHW++;
			if( Config.Sound_Mix_HW == 1 && Config.Sound_3D_HW == 1 )
				soundHW++;

			soundHWMulti.setValue( soundHW );

			changeMode (soundGroup);
		}
		else
		if (command == CMD_SOUND_HW)
		{
			switch( osd.multiValue )
			{
			case 0:
				Config.Sound_Mix_HW = 0;
				Config.Sound_3D_HW = 0;
				break;
			case 1:
				Config.Sound_Mix_HW = 1;
				Config.Sound_3D_HW = 0;
				break;
			case 2:
				Config.Sound_Mix_HW = 1;
				Config.Sound_3D_HW = 1;
				break;
			case 3:
				Config.Sound_Mix_HW = 2;
				Config.Sound_3D_HW = 2;
				break;
			}
			//TODO: tell the sound engine to apply the changes
		}
		else
		if (command == CMD_MAIN)
		{
			changeMode (mainGroup);
		}
		else
		if (command == CMD_RED_SUSP || command == CMD_REDEFINE_CONTROLS || command == CMD_REDEFINE_CONTROLS2 || command == CMD_REDEFINE_CONTROLS3)
		{
			int	i;

			controlSet = new ControlSet();
			controlSet.load( GameLogic.activeControlFile );

			for( int i = 0; i < NCONTROLS; i++ )
			{
				if( keyText[i] )
				{
					if (controlSet.deviceID[i] < 0 || controlSet.axisID[i] < 0)
						keyText[i].changeText( "Indefinido" );
					else
						keyText[i].changeText( Input.axisName (controlSet.deviceID[i], controlSet.axisID[i]) );
				}
			}

			powerSlider[0].setValue( (controlSet.vasp.elementAt(0).power - 1.0) / 4.0 );	// value: 1.0..5.0
			powerSlider[1].setValue( (controlSet.vasp.elementAt(1).power - 1.0) / 4.0 );
			powerSlider[2].setValue( (controlSet.vasp.elementAt(2).power - 1.0) / 4.0 );
			powerSlider[3].setValue( (controlSet.vasp.elementAt(3).power - 1.0) / 4.0 );

			dzSlider[0].setValue( controlSet.dead_zone[0] / 0.2 );							// value: 0.0..0.2
			dzSlider[1].setValue( controlSet.dead_zone[1] / 0.2 );
			dzSlider[2].setValue( controlSet.dead_zone[2] / 0.2 );
			dzSlider[3].setValue( controlSet.dead_zone[7] / 0.2 );

			if(command == CMD_REDEFINE_CONTROLS)
				changeMode (redefineGroup);
			else 
			if(command == CMD_REDEFINE_CONTROLS2)
				changeMode (redefine2Group);
			else 
			if(command == CMD_RED_SUSP)
				changeMode (redefineSuspGroup);
			else
				changeMode (redefine3Group);
		}
		else
		if (command == CMD_REDEFINE_DONE)
		{
			controlSet.save( GameLogic.activeControlFile );
			changeMode (controlGroup);
		}
		else
		if (command == CMD_RESET_CONTROLS)
		{
			controlSet = new ControlSet();
			controlSet.save( GameLogic.activeControlFile );
			player.controller.setcontrol( controlSet );
		}
		else
		if (command == CMD_LOAD_CONTROLS)
		{
			ControlsFileReqDialog d = new ControlsFileReqDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG, "Carregar Definicoes de Controle", "Carregar Controles", GameLogic.controlSaveDir, "*" );

			if( d.display() == 0 )
			{
				String filename = GameLogic.controlSaveDir + d.fileName;

				controlSet = new ControlSet();
				controlSet.load( filename );
				controlSet.save( GameLogic.activeControlFile );
				player.controller.setcontrol( controlSet );
			}
		}
		else
		if (command == CMD_SAVE_CONTROLS)
		{
			ControlsFileReqDialog d = new ControlsFileReqDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.FRF_SAVE, "Salvar Definicoes de Controle", "Salvar Controles", GameLogic.controlSaveDir, "*" );

			if( d.display() == 0 )
			{
				String filename = GameLogic.controlSaveDir + d.fileName;

				if( File.exists( GameLogic.activeControlFile ) )
				{
					File.copy( GameLogic.activeControlFile, filename );
				}
				else
				{	//elso inditas, meg nem letezik a file!!
					controlSet = new ControlSet();
					controlSet.save( filename );
				}
			}
		}
		else
		if (command >= CMD_GETKEY && command < CMD_GETKEY + NCONTROLS)
		{
			if (getKey == -1)
			{
				getKey = command - CMD_GETKEY;
				keyText[getKey].changeText("_");
				getKeyStat = 0;
				// special request: reset mouse and set sensitivity
				Input.getAxis (1, -1 - (Config.mouseSensitivity * 100.0f));
			}
		}
		else
		if (command >= CMD_DEAD_ZONE && command < CMD_DEAD_ZONE + 4)
		{
			int		dz;

			dz = command - CMD_DEAD_ZONE;	// remap 0,1,2,3 -> 0,1,2,7
			if (dz == 3)
			{
				dz = 7;
			}
			controlSet.dead_zone[dz] = osd.sliderValue * 0.2f;
			controlSet.dead_zone[dz + 15] = osd.sliderValue * 0.2f;
			player.controller.setcontrol( controlSet );
		}
		else
		if (command >= CMD_POWER && command < CMD_POWER + 4)
		{
			float pow = 1.125 + 4.0 * osd.sliderValue;
			int ipower = pow * 4;
			pow = ipower;
			pow = pow / 4.0;
			controlSet.vasp.elementAt( command - CMD_POWER ).power = pow;
			player.controller.setcontrol( controlSet );
		}
		else
		if (command == CMD_FFB + 0)
		{
			Config.FFB_strength = osd.sliderValue;
			System.getConfigOptions();
		} 
		else
		if (command == CMD_FFB + 1)
		{
			Config.FFB_strength_emulated = osd.sliderValue;
			System.getConfigOptions();
		} 
		else
		if (command == CMD_MOUSE_SENS)
		{
			Config.mouseSensitivity = osd.sliderValue;
			if (Config.mouseSensitivity < 0.1)
				Config.mouseSensitivity = 0.1;
			// special request: reset mouse and set sensitivity
			Input.getAxis (1, -1 - (Config.mouseSensitivity * 100.0f));
			//send command to cursor
			Input.cursor.config();
		}
	}

	public void changeMode(int group)
	{
		if( actGroup != group )
		{
			if (actGroup >= 0)
			{
				osd.hideGroup (actGroup);
			}

			actGroup = group;

			osd.showGroup (actGroup);

			osd.changeSelection2( -1, 0 );

			if(actGroup == videoGroup)
				osdCommand(CMD_REFRESH_TEXT);
		}
	}

	public void animate()
	{	
		//control remapper
		if (actGroup == redefineGroup || actGroup == redefine2Group || actGroup == redefineSuspGroup)
		{
			if (getKey >= 0 && getKey < NCONTROLS)
			{
				int		device;
				int		axis = -1;

				for( device = 0; device < controlSet.nDevices; device++ )
				{
					axis = Input.activeAxis (device);
					if( axis >= 0 )
						break;
				}

				if (getKeyStat == 0) 
				{
					if (axis < 0) 
					{
						getKeyStat = 1;
					}
				} 
				else 
				if (getKeyStat == 1)
				{
					if( device == 0 && axis == Input.RCDIK_ESCAPE )
					{
						keyText[getKey].changeText( "Indefinido" );
						controlSet.change( getKey, -1, -1 );
						player.controller.setcontrol( controlSet );
						getKeyStat = 2;
					}
					else
					{
						if (axis >= 0) 
						{
							float val = Input.getAxis (device, axis);
							keyText[getKey].changeText (Input.axisName (device, axis));
							controlSet.change( getKey, device, axis);
							int i;
							for (i = 0; i < NCONTROLS; i++) 
							{
								if (i != getKey && controlSet.deviceID [i] == device && controlSet.axisID [i] == axis)
									break;
							}
							if (device == 0 || val > 0.95f) 
							{
								controlSet.from_min [getKey] = 0.0f;
								controlSet.from_max [getKey] = 1.0f;
							} 
							else 
							{
								if (i < NCONTROLS) 
								{
									if (val < 0.0f) 
									{
										controlSet.from_min [getKey] = 0.0f;
										controlSet.from_max [getKey] = -1.0f;
										controlSet.from_min [i] = 0.0f;
										controlSet.from_max [i] = 1.0f;
									} 
									else 
									{
										controlSet.from_min [getKey] = 0.0f;
										controlSet.from_max [getKey] = 1.0f;
										controlSet.from_min [i] = 0.0f;
										controlSet.from_max [i] = -1.0f;
									}
								} 
								else 
								{
									controlSet.from_min [getKey] = -1.0f;
									controlSet.from_max [getKey] = 1.0f;
								}
							}
							player.controller.setcontrol( controlSet );
							getKeyStat = 2;
						}
					}
				} 
				else 
				{
					if (axis < 0) 
					{
						getKey = -1;
					}
				}
			}
		}

		//gas/brake/steer axis position updater
		if (actGroup == axisCheckGroup)
		{
			acGasSlider.setValue( Input.getInput( Input.AXIS_THROTTLE ) / 128.0 );
			acBreakSlider.setValue( Input.getInput( Input.AXIS_BRAKE ) / 128.0 );
			acSteerSlider.setValue( Input.getInput( Input.AXIS_TURN_LEFTRIGHT ) / -256.0 + 0.5);
			acClutchSlider.setValue( Input.getInput( Input.AXIS_CLUTCH ) / 128.0);
		}
		super.animate();
	}

	GameRef activeCamera;

	public void refreshCameras()
	{
		System.getConfigOptions();

		//mega patchek:
		//( a fenti hivasnak kellene triggerelni minden aktiv 3d-engine kamerat, nem itt vacakolni veluk!!!)
		if( activeCamera )
			activeCamera.command( "render 0" );

		if (GameLogic.player && GameLogic.player.car )
			GameLogic.player.car.command( "render 0 "+ GameLogic.player.controller.id() );

	}

	public void setActiveCamera( GameRef cam )
	{
		activeCamera = cam;
	}

}


class ControlsFileReqDialog extends FileRequesterDialog
{
	public ControlsFileReqDialog( Controller ctrl, int myflags, String mytitle, String OKButtonText, String path, String mask )
	{
		super( ctrl, myflags, mytitle, OKButtonText, path, mask );
		if( myflags & FRF_SAVE )
			osd.defSelection = 5;
	}

	public int validator( String filename )
	{
		return ControlSet.fileCheck( filename );
	}
}

class UR_Dialog extends Dialog
{
	final static int	CMD_BACK = 15;
	final static int	CMD_OK	 = 16;

	final static int	CMD_X_UP = 20;
	final static int	CMD_X_DOWN = 21;

	final static int	CMD_Y_UP = 22;
	final static int	CMD_Y_DOWN = 23;

	Menu	m;
	Style	Menu_Center, Menu_Button;
	Text	ResText, AspectText;
	String	Res_Aspect;

	int[]	Res_list;
	int		SizeX, SizeY, numberX, numberY;
	float	aspect;

	public UR_Dialog()
	{
		super( GameLogic.player.controller, DF_MODAL|DF_DEFAULTBG|DF_HIGHPRI|DF_DARKEN, "Resolucao Incomum", "" );

		Res_list = new int[29];
		Res_list[0]		= 600;
		Res_list[1]		= 648;
		Res_list[2]		= 720;
		Res_list[3]		= 768;
		Res_list[4]		= 800;
		Res_list[5]		= 864;
		Res_list[6]		= 900;
		Res_list[7]		= 960;
		Res_list[8]		= 1000;
		Res_list[9]		= 1024;
		Res_list[10]	= 1050;
		Res_list[11]	= 1080;
		Res_list[12]	= 1152;
		Res_list[13]	= 1200;
		Res_list[14]	= 1280;
		Res_list[15]	= 1360;
		Res_list[16]	= 1366;
		Res_list[17]	= 1400;
		Res_list[18]	= 1440;
		Res_list[19]	= 1536;
		Res_list[20]	= 1600;
		Res_list[21]	= 1680;
		Res_list[21]	= 1776;
		Res_list[22]	= 1800;
		Res_list[23]	= 1920;
		Res_list[24]	= 2048;
		Res_list[25]	= 2160;
		Res_list[26]	= 2560;
		Res_list[27]	= 3200;
		Res_list[28]	= 3840;

		for (int i=0; i<=Res_list.length-1; i++ ) // Get X Res
		{
			if(OptionsDialog.aspectX == Res_list[i])
			{
				numberX = i;
				i += Res_list.length; //end 'for' loop
			}
		}

		for (int i=0; i<=Res_list.length-1; i++ ) // Get Y Res
		{
			if(OptionsDialog.aspectY == Res_list[i])
			{
				numberY = i;
				i += Res_list.length; //end 'for' loop
			}
		}
		
		Menu_Center = new Style( 0.50, 0.13, Frontend.mediumFont, Text.ALIGN_CENTER, Osd.RRT_TEST );
		Menu_Button = new Style( 0.12, 0.12, Frontend.mediumFont, Text.ALIGN_CENTER, null );

		ResText = osd.createText( "----   X   ----" , Frontend.largeFont, Text.ALIGN_CENTER, 0.0, -0.3 ); ResText.changeColor(0xFFC0C0C0);// "Unselected" gray

		m = osd.createMenu( Menu_Button, -0.5, -0.5, 0, Osd.MD_VERTICAL );
		m.addItem( new ResourceRef( frontend:0x004Cr ), CMD_X_UP, "Aumentar X tamanho" );

		m = osd.createMenu( Menu_Button, -0.5, 0.0, 0, Osd.MD_VERTICAL );
		m.addItem( new ResourceRef( frontend:0x0084r ), CMD_X_DOWN, "Diminuir X tamanho" );

		m = osd.createMenu( Menu_Button, 0.5, -0.5, 0, Osd.MD_VERTICAL );
		m.addItem( new ResourceRef( frontend:0x004Cr ), CMD_Y_UP, "Aumentar Y tamanho" );

		m = osd.createMenu( Menu_Button, 0.5, 0.0, 0, Osd.MD_VERTICAL );
		m.addItem( new ResourceRef( frontend:0x0084r ), CMD_Y_DOWN, "Diminuir Y tamanho" );

		AspectText = osd.createText( "Aspecto: N/A" , Frontend.largeFont, Text.ALIGN_CENTER, 0.0, 0.4 ); AspectText.changeColor(0xFFC0C0C0);// "Unselected" gray

		m = osd.createMenu( Menu_Center, -0.4, 0.9, 0, Osd.MD_HORIZONTAL );
		m.addItem( "Aplicar", CMD_OK );
		
		m = osd.createMenu( Menu_Center, 0.4, 0.95, 0, Osd.MD_HORIZONTAL );
		m.addItem( "Voltar", CMD_BACK );

		Refresh();

		super.show();
	}

	public void Refresh()
	{
		float x = Res_list[numberX];
		float y = Res_list[numberY];

		aspect = x/y;
		int TMPasp = 10*aspect;

		if(TMPasp == 10)	Res_Aspect = "1:1"; else
		if(TMPasp == 12)	Res_Aspect = "5:4"; else
		if(TMPasp == 13)	Res_Aspect = "4:3"; else
		if(TMPasp == 14)	Res_Aspect = "13:9"; else
		if(TMPasp == 15)	Res_Aspect = "14:9"; else
		if(TMPasp == 16)	Res_Aspect = "5:3"; else
		if(TMPasp == 17)	Res_Aspect = "16:9"; else
		if(TMPasp == 20)	Res_Aspect = "6:3"; else
		if(TMPasp == 23)	Res_Aspect = "12:5"; else
		if(TMPasp == 24)	Res_Aspect = "12:5"; else
		Res_Aspect = "Outros";

		ResText.changeText( Res_list[numberX] + "   X   " + Res_list[numberY] );
		AspectText.changeText( "Aspecto: " + aspect + " (" + Res_Aspect + ")" );
	}
		
	public void osdCommand( int cmd )
	{
		if( cmd == CMD_X_DOWN )
		{
			if( numberX > 0)
				numberX -= 1;
			else
				numberX = Res_list.length-1;

			Refresh();
		}
		else
		if( cmd == CMD_X_UP )
		{
			if( numberX < Res_list.length-1)
				numberX += 1;
			else
				numberX = 0;

			Refresh();
		}
		else
		if( cmd == CMD_Y_DOWN )
		{
			if( numberY > 0)
				numberY -= 1;
			else
				numberY = Res_list.length-1;

			Refresh();
		}
		else
		if( cmd == CMD_Y_UP )
		{
			if( numberY < Res_list.length-1)
				numberY += 1;
			else
				numberY = 0;

			Refresh();
		}
		else
		if( cmd == CMD_BACK )
		{
			osd.hide();
			super.hide();
		}
		else
		if( cmd == CMD_OK )
		{
			OptionsDialog.aspectX = Res_list[numberX];
			OptionsDialog.aspectY = Res_list[numberY];

			osd.hide();
			super.hide();
		}
	}
}
class VehicleSkinFileReqDialog extends FileRequesterDialog
{
	public VehicleSkinFileReqDialog( Controller ctrl, int myflags, String mytitle, String OKButtonText, String path, String mask )
	{
		super( ctrl, myflags, mytitle, OKButtonText, path, mask );
	}
	
	public int validator( String filename )
	{
		return Vehicle.fileCheck_Skin( filename );
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