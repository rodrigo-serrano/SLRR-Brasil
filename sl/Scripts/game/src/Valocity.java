package java.game;

import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.dialog.*;
import java.sound.*;


public class Valocity extends City
{

	//Bot		raceBot1;
	//Vector3	raceBot1_posStart;
	//Ypr		raceBot1_oriStart;

	//Bot		raceBot2;
	//Vector3	raceBot2_posStart;
	//Ypr		raceBot2_oriStart;

	//Bot		raceBot3;
	//Vector3	raceBot3_posStart;
	//Ypr		raceBot3_oriStart;

	//Bot		raceBot4;
	//Vector3	raceBot4_posStart;
	//Ypr		raceBot4_oriStart;


	GameType TRAFFIC0;
	GameType TRAFFIC1;
	GameType TRAFFIC2;
	GameType TRAFFIC3;
	GameType TRAFFIC4;
        GameType TRAFFIC5;
	GameType TRAFFIC6;
	GameType TRAFFIC7;
	GameType TRAFFIC8;
	GameType TRAFFIC9;
	GameType TRAFFIC10;
	GameType TRAFFIC11;
	GameType TRAFFIC12;
	GameType TRAFFIC13;

 GameType gt;

 RenderRef Water; // Definition water render name


	//RenderRef man;
	//Animation manAnim;
        //ResourceRef testBones2 = new ResourceRef(humans:0x001br);

	//Vector3 posMan = new Vector3( 1337.770, 9.168, 102.705 );
	//Ypr oriMan = new Ypr( 0.215, 0.024, -0.010 );

	//Vector3 posWater = new Vector3( 1337.770, 9.168, 102.705 );
	//Ypr oriWater = new Ypr( 0.215, 0.024, -0.010 );

    //keep track of it so it can be renewed when entering a higher club
    public Valocity()
    {
		posGarage[0] = new Vector3( -278.518, 9.8, 1033.002 );
        oriGarage[0] = new Ypr( 1.580, 0.000, 0.000 );

        posGarage[1] = new Vector3( 355.381, 1.600, 418.244 );
        oriGarage[1] = new Ypr( -1.763, 0.000, 0.000 );

        posGarage[2] = new Vector3( -531.138, 5.050, -149.357 );
        oriGarage[2] = new Ypr( 2.077, 0.000, 0.000 );
  
		map = new GroundRef( maps.city:0x00000001r );
		nav = new Navigator( -23.482, -24.45, 5.828, maps.city.smallmap:0x00000001r, maps.city.smallmap:0x00000002r, maps.city.smallmap:0x00000005r, 8, 8, 8 );

		//for nr testing only:
		//posGarage[0] = new Vector3( -144.518, 10.214, 404.002 );

			//raceBot1_posStart = new Vector3( 1340.300, 9.181, 106.662 ); // First opponent start position
			//raceBot1_oriStart = new Ypr( -0.181, -0.001, 0.029 ); // First opponent start rotation

			//raceBot2_posStart = new Vector3( 1339.819, 9.204, 98.975 ); // First opponent start position
			//raceBot2_oriStart = new Ypr( -0.243, -0.005, 0.029 ); // First opponent start rotation

			//raceBot3_posStart = new Vector3( -843.807, 7.674, -102.606 ); // First opponent start position
			//raceBot3_oriStart = new Ypr( -3.030, -0.037, -0.033 ); // First opponent start rotation

			//raceBot4_posStart = new Vector3( -533.026, -0.299, -1700.516 ); // First opponent start position
			//raceBot4_oriStart = new Ypr( -0.068, -0.027, -0.020 ); // First opponent start rotation

    }

    public void enter( GameState prev_state )
    {

gt = new GameType();

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1311.712, 14.000, 380.000), new Ypr(1.500, -0.007, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1311.712, 14.000, 405.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1311.712, 14.000, 440.000), new Ypr(1.500, -0.007, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1311.712, 14.000, 465.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1311.712, 14.000, 490.000), new Ypr(1.500, -0.007, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1311.712, 14.000, 515.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1311.712, 14.000, 540.000), new Ypr(1.500, -0.007, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.712, 14.000, 565.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.212, 14.000, 590.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.712, 14.000, 380.000), new Ypr(-1.500, -0.007, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.712, 14.000, 405.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.712, 14.000, 440.000), new Ypr(-1.500, -0.007, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.712, 14.000, 465.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.712, 14.000, 490.000), new Ypr(-1.500, -0.007, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.712, 14.000, 515.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.712, 14.000, 540.000), new Ypr(-1.500, -0.007, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.712, 14.000, 565.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.212, 14.000, 590.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.212, 14.000, 250.000), new Ypr(1.500, -0.007, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.212, 14.000, 275.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.212, 14.000, 300.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.212, 14.000, 325.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.212, 14.000, 350.000), new Ypr(1.500, -0.008, 0.001) );
//
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.712, 14.000, 250.000), new Ypr(-1.500, -0.007, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.712, 14.000, 275.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.212, 14.000, 300.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.212, 14.000, 325.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.212, 14.000, 350.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.712, 13.900, 192.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.212, 13.300, 170.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.212, 13.300, 150.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1337.212, 13.300, 130.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1340.212, 14.000, 207.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1343.212, 13.700, 227.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1355.712, 14.000, 253.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1202.360, 18.172, 298.622), new Ypr(1.500, 0.028, -0.033) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1216.549, 18.227, 305.599), new Ypr(-1.817, -0.005, 0.056) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1235.671, 17.009, 311.467), new Ypr(-1.972, -0.048, 0.114) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.000, 13.000, 374.000), new Ypr(1.500, -0.007, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.000, 13.000, 396.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.000, 13.000, 418.000), new Ypr(1.500, -0.007, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.000, 13.000, 440.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.000, 13.000, 462.000), new Ypr(1.500, -0.007, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.000, 13.000, 484.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.000, 13.000, 506.000), new Ypr(1.500, -0.007, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.000, 13.000, 528.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.000, 13.000, 550.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1310.000, 13.000, 572.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1121.000, 10.000, 1211.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1268.504, 15.100, 284.180), new Ypr(-1.370, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1248.000, 16.000, 289.632), new Ypr(1.723, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1292.750, 14.350, 273.000), new Ypr(-0.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1307.100, 14.000, 254.000), new Ypr(-0.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1307.100, 14.000, 278.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1307.100, 14.000, 294.000), new Ypr(0.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1307.100, 14.000, 320.000), new Ypr(0.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1307.100, 14.000, 338.000), new Ypr(0.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1304.050, 14.000, 260.424), new Ypr(0.900, -0.008, 0.001) );
//
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1340.100, 14.000, 254.000), new Ypr(-0.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1340.100, 14.000, 278.000), new Ypr(-1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1340.100, 14.000, 294.000), new Ypr(0.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1340.100, 14.000, 320.000), new Ypr(0.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1340.100, 14.000, 338.000), new Ypr(0.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1340.100, 13.000, 190.000), new Ypr(0.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1340.100, 13.000, 165.000), new Ypr(0.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1340.100, 13.000, 145.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1340.100, 13.000, 125.000), new Ypr(0.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1343.100, 14.000, 210.000), new Ypr(-0.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1349.100, 14.000, 235.000), new Ypr(0.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1363.100, 14.000, 260.000), new Ypr(1.500, -0.008, 0.001) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1298.234, 14.200, 260.694), new Ypr(3.000, 0.023, -0.028) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1282.098, 14.800, 270.840), new Ypr(3.000, 0.024, -0.037) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1239.025, 16.300, 285.958), new Ypr(3.000, 0.022, -0.035) );
//
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1150.963, 16.100, 314.000), new Ypr(0.331, -0.001, 0.002) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1132.022, 16.100, 318.110), new Ypr(0.331, -0.001, 0.002) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1113.685, 16.100, 322.072), new Ypr(0.331, -0.001, 0.002) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1090.667, 16.100, 326.982), new Ypr(0.331, -0.001, 0.002) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1065.221, 16.100, 332.754), new Ypr(0.331, -0.001, 0.002) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1368.857, 15.471, 282.127), new Ypr(-1.131, -0.001, 0.002) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1339.638, 13.093, 111.817), new Ypr(-1.700, -0.001, 0.002) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1342.344, 13.093, 99.568), new Ypr(-1.700, -0.001, 0.002) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1346.637, 13.102, 83.853), new Ypr(-1.700, -0.001, 0.002) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1188.730, 16.354, 299.902), new Ypr(1.500, -0.014, 0.006) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1045.031, 17.117, 342.622), new Ypr(-1.366, -0.003, -0.009) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1069.908, 17.167, 335.163), new Ypr(-1.366, -0.003, -0.009) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1100.779, 17.200, 328.346), new Ypr(-1.366, -0.003, -0.009) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1120.118, 17.200, 322.976), new Ypr(-1.366, -0.003, -0.009) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1139.822, 17.400, 320.118), new Ypr(-1.366, -0.003, -0.009) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1161.531, 17.450, 313.661), new Ypr(-1.022, -0.003, -0.009) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1178.102, 17.000, 312.332), new Ypr(-1.295, 0.048, -0.223) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1354.374, 13.488, 224.346), new Ypr(-3.124, 0.048, 0.082) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1365.959, 14.630, 271.634), new Ypr(1.157, 0.038, -0.149) ); 

gt.create_native( map, new GameRef(objects:0x00000189r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.853, 13.342, 248.635), new Ypr(1.031, 0.031, -0.091) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1342.907, 13.008, 109.135), new Ypr(-0.179, 0.001, -0.033) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1344.137, 13.021, 100.120), new Ypr(-0.156, 0.004, -0.034) ); 

gt.create_native( map, new GameRef(objects:0x00000189r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1347.387, 13.061, 87.917), new Ypr(-0.382, 0.004, -0.034) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1352.182, 13.027, 76.359), new Ypr(-0.354, 0.013, -0.097) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1337.800, 12.019, 71.288), new Ypr(-1.363, -0.003, 0.297) );  

gt.create_native( map, new GameRef(objects:0x00000189r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1053.871, 18.181, 341.926), new Ypr(-2.012, -0.010, -0.008) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1068.011, 18.134, 345.089), new Ypr(-1.974, -0.009, -0.009) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1082.160, 18.194, 339.944), new Ypr(-1.072, -0.002, -0.007) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1095.293, 18.280, 338.446), new Ypr(-1.532, 0.000, -0.010) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1109.040, 18.337, 332.477), new Ypr(-0.941, -0.002, -0.001) ); 

gt.create_native( map, new GameRef(objects:0x00000189r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1126.341, 18.374, 329.300), new Ypr(-1.407, -0.003, -0.004) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1141.577, 18.370, 330.518), new Ypr(-1.673, -0.005, -0.005) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1152.216, 18.423, 321.812), new Ypr(-0.452, -0.000, -0.003) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1164.921, 18.413, 320.000), new Ypr(-1.787, -0.008, -0.006) ); 

gt.create_native( map, new GameRef(objects:0x00000189r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1180.586, 17.003, 317.054), new Ypr(-1.018, 0.038, -0.150) ); 

gt.create_native( map, new GameRef(objects:0x00000189r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1189.455, 17.693, 315.411), new Ypr(-1.965, -0.042, -0.264) ); 

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1195.343, 17.457, 301.539), new Ypr(-1.769, -0.001, 0.023) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1206.603, 17.420, 304.389), new Ypr(-1.365, -0.022, 0.043) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1220.633, 16.377, 291.196), new Ypr(-1.375, -0.083, 0.038) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1239.169, 15.534, 299.024), new Ypr(-1.918, -0.049, 0.062) );  

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1248.897, 16.297, 313.528), new Ypr(-3.120, 0.109, 0.067) );  

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1287.113, 13.616, 285.597), new Ypr(2.924, 0.000, 0.046) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1269.064, 14.344, 297.525), new Ypr(2.037, 0.032, 0.026) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1286.486, 13.399, 320.660), new Ypr(-2.248, -0.039, 0.013) );  

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1306.818, 13.118, 327.229), new Ypr(-1.567, -0.017, 0.001) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1311.102, 13.047, 286.386), new Ypr(-1.390, -0.024, 0.002) );  

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1310.557, 13.047, 286.221), new Ypr(-0.889, -0.020, 0.012) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1278.294, 15.061, 274.044), new Ypr(1.220, 0.039, -0.009) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1280.462, 14.869, 291.727), new Ypr(2.225, 0.026, 0.032) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1270.279, 15.185, 309.377), new Ypr(-2.816, 0.032, 0.032) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1308.738, 14.111, 308.662), new Ypr(-0.905, -0.014, -0.015) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1353.088, 13.678, 276.120), new Ypr(0.471, -0.079, 0.128) );  

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1338.467, 12.816, 265.417), new Ypr(-0.046, -0.006, -0.075) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1344.669, 13.073, 262.290), new Ypr(-1.309, 0.055, 0.020) );  

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1337.771, 12.895, 286.938), new Ypr(3.119, 0.001, 0.074) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1339.464, 12.792, 305.846), new Ypr(3.121, -0.001, 0.076) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1341.319, 12.674, 327.425), new Ypr(2.925, 0.012, 0.077) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1358.949, 17.827, 310.929), new Ypr(3.117, 0.106, -0.370) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1351.503, 14.364, 295.033), new Ypr(-0.543, 0.073, 0.241) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1309.934, 13.231, 71.655), new Ypr(-1.589, -0.002, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000189r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1311.109, 13.319, 44.784), new Ypr(-1.634, 0.000, -0.006) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1305.350, 13.234, 59.977), new Ypr(1.932, -0.009, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1288.439, 12.040, 55.667), new Ypr(0.788, -0.019, -0.069) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1311.584, 12.272, 54.999), new Ypr(-3.071, -0.006, -0.004) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1307.345, 12.794, -2.964), new Ypr(0.111, -0.085, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1309.001, 13.214, -14.982), new Ypr(-0.651, 0.166, 0.030) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1310.599, 12.200, 30.367), new Ypr(3.111, -0.016, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1301.907, 12.221, 68.231), new Ypr(-2.286, 0.017, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1311.458, 12.252, 62.640), new Ypr(-0.669, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1308.280, 12.012, 24.478), new Ypr(-0.077, 0.013, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1309.495, 13.282, 12.429), new Ypr(-0.179, 0.027, 0.030) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1310.010, 13.726, -30.929), new Ypr(-0.040, -0.010, 0.080) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1307.512, 12.970, 39.440), new Ypr(-1.155, 0.036, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1337.000, 11.020, 74.365), new Ypr(1.500, -0.002, 0.007) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1310.000, 11.020, 76.500), new Ypr(1.500, -0.002, 0.007) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1312.266, 13.241, 67.742), new Ypr(1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1312.266, 13.285, 51.804), new Ypr(1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1312.266, 13.252, 37.301), new Ypr(1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1312.266, 13.252, 22.301), new Ypr(1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1311.950, 13.252, 7.301), new Ypr(1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1311.580, 13.252, -8.301), new Ypr(1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1311.200, 13.252, -23.301), new Ypr(1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1291.184, 4.191, 42.813), new Ypr(0.000, 0.000, 0.000) );  

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1289.847, 3.772, 34.704), new Ypr(0.000, 0.000, 0.000) );  

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1287.708, 3.422, 27.903), new Ypr(0.000, 0.000, 0.000) );  

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1285.520, 2.766, 15.102), new Ypr(0.000, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1336.700, 13.242, 66.293), new Ypr(-1.500, -0.000, 0.000) );  

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1336.450, 13.242, 50.293), new Ypr(-1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1336.200, 13.242, 36.293), new Ypr(-1.500, -0.000, 0.000) );  

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1335.924, 13.242, 21.293), new Ypr(-1.500, -0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1335.724, 13.242, 6.293), new Ypr(-1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1335.424, 13.242, -8.293), new Ypr(-1.500, -0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1334.924, 13.242, -22.821), new Ypr(-1.500, -0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1338.366, 13.241, 46.005), new Ypr(0.620, 0.020, -0.025) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1341.918, 12.059, 33.777), new Ypr(-0.028, -0.039, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1341.356, 12.038, 23.056), new Ypr(0.176, -0.052, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1339.515, 11.990, 12.596), new Ypr(0.396, 0.162, -0.100) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1337.227, 12.973, -13.322), new Ypr(0.177, 0.068, -0.020) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1337.609, 12.044, 27.794), new Ypr(1.197, 0.013, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1337.462, 11.852, 4.117), new Ypr(0.726, 0.093, -0.040) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1338.129, 13.255, 59.847), new Ypr(1.135, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1343.772, 12.216, 64.078), new Ypr(0.726, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1351.418, 13.008, 53.868), new Ypr(-0.612, -0.039, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1345.952, 12.988, 47.543), new Ypr(1.600, 0.000, 0.006) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1352.601, 12.823, 245.365), new Ypr(0.726, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1344.940, 12.714, 221.752), new Ypr(-0.326, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1348.744, 12.901, 202.855), new Ypr(1.600, 0.000, 0.006) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1339.972, 13.476, 182.224), new Ypr(-0.326, 0.000, -0.085) );  

gt.create_native( map, new GameRef(objects:0x00000060r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1432.380, 24.000, 87.462), new Ypr(1.600, 0.043, -0.016) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1405.009, 8.795, 131.702), new Ypr(1.500, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1402.581, 9.151, 118.924), new Ypr(1.500, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1400.870, 9.089, 96.606), new Ypr(1.500, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1403.132, 8.346, 68.341), new Ypr(1.500, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1402.398, 7.203, 31.331), new Ypr(1.500, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1448.635, 5.289, 28.368), new Ypr(1.500, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1481.891, 9.976, 62.400), new Ypr(1.500, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1483.681, 9.136, 71.272), new Ypr(1.500, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1450., 7.068, 121.956), new Ypr(1.500, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000692r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1494.007, 4.000, 60.600), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000589r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1501.141, 3.800, 117.173), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1402.326, 10.434, 143.089), new Ypr(1.600, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1399.947, 10.149, 127.105), new Ypr(0.326, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1395.270, 11.414, 113.759), new Ypr(1.600, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1398.864, 10.131, 88.478), new Ypr(0.326, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1398.304, 9.893, 75.347), new Ypr(0.326, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1398.796, 10.218, 54.024), new Ypr(1.600, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1332.810, 14.733, -78.407), new Ypr(-1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1332.853, 15.032, -98.072), new Ypr(-1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1331.740, 15.420, -118.195), new Ypr(-1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1330.598, 15.752, -138.106), new Ypr(-1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1329.453, 15.897, -158.105), new Ypr(-1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1328.169, 16.022, -178.326), new Ypr(-1.500, -0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1327.230, 16.740, -198.130), new Ypr(-1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1325.451, 16.598, -218.244), new Ypr(-1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1324.125, 16.699, -238.144), new Ypr(-1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1322.654, 16.697, -258.313), new Ypr(-1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1321.368, 16.432, -278.186), new Ypr(-1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1319.612, 16.484, -298.279), new Ypr(-1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1318.376, 16.563, -318.300), new Ypr(-1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1316.509, 16.503, -338.277), new Ypr(-1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1314.675, 16.558, -358.304), new Ypr(-1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1312.759, 16.618, -378.263), new Ypr(-1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1310.828, 16.702, -398.147), new Ypr(-1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1308.660, 16.788, -418.222), new Ypr(-1.480, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1306.456, 16.895, -438.195), new Ypr(-1.450, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1303.858, 17.002, -458.133), new Ypr(-1.420, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1301.235, 17.140, -478.434), new Ypr(-1.390, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1298.235, 17.275, -498.233), new Ypr(-1.360, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1294.984, 17.389, -518.646), new Ypr(-1.330, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1291.474, 17.523, -538.257), new Ypr(-1.300, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1287.504, 17.757, -558.168), new Ypr(-1.270, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1282.828, 17.909, -578.655), new Ypr(-1.250, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1277.915, 17.930, -598.049), new Ypr(-1.230, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1272.222, 18.079, -618.616), new Ypr(-1.215, -0.000, 0.000) ); 
//
//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
//gt.setMatrix( new Vector3(1250.428, 17.790, -602.297), new Ypr(1.785, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1255.913, 17.678, -581.877), new Ypr(1.760, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1260.619, 17.450, -562.888), new Ypr(1.740, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1264.898, 17.321, -542.536), new Ypr(1.720, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1268.724, 17.257, -522.242), new Ypr(1.700, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1271.930, 17.084, -502.645), new Ypr(1.680, -0.000, 0.000) );

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1275.038, 16.903, -482.688), new Ypr(1.660, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1277.691, 16.700, -462.353), new Ypr(1.640, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1280.308, 16.399, -442.528), new Ypr(1.620, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1282.273, 16.260, -422.734), new Ypr(1.600, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1284.721, 16.232, -402.540), new Ypr(1.580, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1286.910, 16.304, -382.796), new Ypr(1.560, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1288.916, 16.242, -362.396), new Ypr(1.540, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1290.731, 16.160, -342.452), new Ypr(1.520, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
//gt.setMatrix( new Vector3(1292.306, 16.009, -322.435), new Ypr(1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1294.186, 16.066, -301.716), new Ypr(1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1295.608, 16.031, -282.413), new Ypr(1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1297.129, 15.998, -262.708), new Ypr(1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1298.200, 15.897, -242.877), new Ypr(1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1299.785, 15.859, -222.855), new Ypr(1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1301.300, 15.748, -202.647), new Ypr(1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1302.509, 15.612, -182.323), new Ypr(1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1303.882, 15.465, -162.491), new Ypr(1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1305.017, 15.209, -141.161), new Ypr(1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1306.232, 15.003, -122.374), new Ypr(1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1307.276, 14.790, -102.517), new Ypr(1.500, -0.000, 0.000) ); 

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1308.052, 14.365, -82.421), new Ypr(1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1309.055, 14.159, -62.988), new Ypr(1.500, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1338.001, 14.477, -99.130), new Ypr(0.326, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1336.296, 13.129, -70.768), new Ypr(1.600, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1334.061, 14.847, -86.433), new Ypr(0.600, 0.015, 0.013) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1332.239, 15.484, -113.367), new Ypr(0.420, -0.067, 0.164) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1338.696, 16.770, -118.807), new Ypr(0.420, 0.173, 0.064) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1338.540, 16.171, -134.334), new Ypr(0.326, 0.069, 0.176) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1330.544, 15.920, -146.463), new Ypr(0.589, -0.103, 0.184) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1336.180, 17.040, -157.005), new Ypr(0.589, 0.089, 0.050) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1331.080, 16.293, -168.328), new Ypr(0.589, 0.089, 0.150) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1335.107, 15.998, -176.729), new Ypr(0.326, 0.069, 0.079) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1334.445, 19.338, -196.501), new Ypr(0.079, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1343.978, 13.506, -80.814), new Ypr(0.326, 0.069, 0.079) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1355.264, 13.475, -82.270), new Ypr(1.326, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1365.608, 14.124, -80.250), new Ypr(0.079, 0.000, 0.040) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1378.171, 14.236, -78.528), new Ypr(0.479, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1398.858, 12.958, -76.865), new Ypr(-1.326, 0.000, -0.020) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1407.287, 13.643, -75.113), new Ypr(0.479, 0.000, -0.243) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1348.193, 14.578, -92.208), new Ypr(0.310, 0.091, 0.110) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1303.251, 11.865, -67.479), new Ypr(0.010, 0.091, -0.010) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1304.033, 12.339, -93.117), new Ypr(0.010, 0.000, -0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1301.815, 12.006, -83.505), new Ypr(0.010, 0.000, -0.010) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1299.703, 12.482, -121.658), new Ypr(0.010, 0.000, 0.190) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1302.356, 10.026, -36.186), new Ypr(0.010, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1303.166, 10.521, -61.148), new Ypr(0.010, 0.000, 0.050) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1297.454, 10.868, -91.651), new Ypr(0.010, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1301.936, 11.867, -101.468), new Ypr(0.010, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1306.355, 13.662, -109.830), new Ypr(0.010, 0.000, 0.100) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1302.633, 12.893, -130.615), new Ypr(0.010, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1300.378, 12.492, -139.946), new Ypr(0.010, 0.000, 0.010) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1303.653, 12.022, -22.812), new Ypr(0.010, 0.000, 0.190) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1298.863, 11.882, -107.348), new Ypr(0.010, 0.000, 0.030) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1295.718, 11.435, -134.234), new Ypr(0.010, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1298.414, 13.352, -148.075), new Ypr(0.010, 0.000, 0.020) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1296.357, 13.854, -181.632), new Ypr(0.010, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1300.495, 15.303, -190.635), new Ypr(0.010, 0.000, 0.010) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1294.296, 7.284, -37.675), new Ypr(0.010, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1304.524, 11.482, -75.346), new Ypr(0.010, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1302.175, 14.137, -170.085), new Ypr(-3.009, 0.000, -0.100) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1295.969, 13.465, -202.687), new Ypr(0.010, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1297.979, 9.919, -29.797), new Ypr(0.010, 0.000, 0.010) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1296.522, 13.210, -162.046), new Ypr(0.010, 0.000, 0.010) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1291.373, 12.002, -172.978), new Ypr(0.010, 0.000, 0.010) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1290.019, 10.716, -153.633), new Ypr(0.010, 0.000, 0.010) );  

gt.create_native( map, new GameRef(objects:0x000001A4r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1370.311, 25.800, -147.893), new Ypr(-1.629, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x000001A5r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1358.703, 27.100, -237.683), new Ypr(-1.705, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x000001A7r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1360.787, 27.004, -189.985), new Ypr(-1.528, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1385.829, 37.009, -249.686), new Ypr(0.000, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1381.341, 34.595, -227.541), new Ypr(0.000, 0.000, -0.020) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1376.788, 32.380, -207.443), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1373.485, 30.642, -191.518), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1369.932, 27.465, -171.519), new Ypr(0.000, 0.000, -0.042) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1369.241, 29.554, -216.815), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1368.007, 29.919, -246.752), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1365.643, 19.464, -108.458), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1418.968, 27.592, -132.593), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1410.159, 27.114, -131.291), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1400.653, 26.694, -131.302), new Ypr(1.536, 0.000, 0.100) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1389.395, 26.005, -130.140), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1377.162, 24.596, -123.803), new Ypr(2.284, 0.000, 0.066) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1377.138, 26.167, -163.444), new Ypr(-1.303, 0.000, -0.080) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1365.364, 22.910, -138.287), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1366.980, 24.890, -157.708), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1357.084, 24.214, -174.688), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1354.357, 24.996, -204.052), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1353.857, 25.764, -226.756), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1356.431, 26.654, -247.779), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1398.488, 41.058, -258.956), new Ypr(0.000, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1401.673, 41.645, -250.852), new Ypr(0.000, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1403.604, 40.069, -243.794), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1405.569, 39.186, -234.619), new Ypr(0.000, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1407.838, 38.254, -224.606), new Ypr(0.000, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1410.378, 37.317, -214.113), new Ypr(0.000, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1413.526, 36.253, -201.829), new Ypr(0.000, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1417.290, 34.989, -187.679), new Ypr(0.000, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1421.478, 33.436, -171.048), new Ypr(0.000, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1425.371, 32.000, -155.644), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1430.035, 30.339, -137.582), new Ypr(0.000, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1434.467, 29.451, -118.436), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1437.267, 28.539, -104.507), new Ypr(0.000, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1300.084, 18.302, 350.119), new Ypr(-1.967, -0.105, 0.200) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1271.739, 18.859, 340.173), new Ypr(1.042, -0.049, -0.030) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1255.017, 18.733, 329.589), new Ypr(1.033, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1284.596, 14.391, 330.945), new Ypr(1.033, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000022r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1292.028, 7.578, -79.215), new Ypr(-1.629, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x0000002Er), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1286.828, 7.335, -104.011), new Ypr(-1.705, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x0000002Ar), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1283.149, 8.026, -131.616), new Ypr(-1.528, 0.000, 0.000) ); 
 
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1283.985, 6.908, -62.154), new Ypr(1.033, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1295.670, 6.745, -61.668), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1283.930, 5.658, -70.537), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1286.892, 6.780, -88.021), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1283.744, 9.110, -150.344), new Ypr(1.033, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1272.992, 7.358, -147.445), new Ypr(1.033, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1291.233, 9.494, -120.490), new Ypr(1.033, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1286.119, 7.936, -92.544), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1277.873, 5.683, -97.742), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1283.175, 6.308, -111.475), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1275.304, 5.061, -127.397), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1275.351, 5.251, -138.300), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1123.963, 9.365, 15.473), new Ypr(0.000, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1129.314, 10.461, 14.172), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1286.762, 7.197, -41.442), new Ypr(1.033, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1273.530, 6.683, -43.628), new Ypr(1.033, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1264.168, 6.877, -43.494), new Ypr(1.033, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1246.857, 7.467, -41.579), new Ypr(1.033, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1229.538, 8.081, -38.056), new Ypr(1.033, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1206.169, 8.901, -31.147), new Ypr(1.033, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1184.894, 9.737, -21.464), new Ypr(1.033, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1161.442, 10.217, -7.854), new Ypr(1.033, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1144.022, 10.640, 3.318), new Ypr(1.033, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1289.836, 6.796, -43.307), new Ypr(3.000, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1280.961, 6.824, -43.763), new Ypr(3.117, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1267.558, 6.7969, -43.636), new Ypr(3.100, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1253.655, 7.213, -42.568), new Ypr(3.117, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1237.922, 7.766, -40.168), new Ypr(3.215, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1222.906, 8.357, -36.516), new Ypr(3.333, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1201.789, 9.000, -29.373), new Ypr(3.332, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1176.692, 10.033, -17.464), new Ypr(-2.354, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1154.995, 10.740, -4.124), new Ypr(-2.165, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1133.961, 11.108, 10.077), new Ypr(-2.413, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1152.178, 9.738, 3.387), new Ypr(1.033, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1168.553, 9.301, -4.862), new Ypr(1.033, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1181.906, 8.931, -11.294), new Ypr(1.033, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1192.200, 8.595, -16.851), new Ypr(1.033, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1206.149, 8.138, -23.696), new Ypr(1.033, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1214.953, 7.861, -27.759), new Ypr(1.033, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1225.191, 7.663, -30.499), new Ypr(1.033, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1235.991, 7.223, -34.080), new Ypr(1.033, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1247.578, 6.856, -35.962), new Ypr(1.033, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1259.859, 6.401, -37.975), new Ypr(1.033, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1269.522, 6.138, -38.836), new Ypr(1.033, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1278.413, 6.163, -39.323), new Ypr(1.033, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1286.903, 6.521, -37.667), new Ypr(1.033, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1158.548, 11.585, 13.705), new Ypr(-0.154, -0.000, 0.000) );

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1172.968, 11.718, 14.581), new Ypr(-0.186, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1187.590, 11.856, 16.324), new Ypr(-0.253, -0.000, 0.000) );

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1204.888, 12.058, 19.164), new Ypr(-0.344, -0.000, 0.000) );

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1236.713, 12.481, 28.038), new Ypr(-0.362, -0.000, 0.000) );

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1252.542, 12.684, 34.777), new Ypr(-0.462, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1266.884, 12.858, 42.536), new Ypr(-0.612, -0.000, 0.000) );

//gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3(1281.115, 13.014, 51.859), new Ypr(-0.762, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1138.620, 10.199, 11.307), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1144.713, 10.292, 11.606), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1154.294, 10.341, 10.784), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1163.611, 10.466, 11.424), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1172.873, 11.490, 10.864), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1182.121, 10.615, 12.153), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1191.895, 10.767, 13.946), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1199.979, 10.838, 14.886), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1209.666, 10.968, 17.026), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1221.979, 12.117, 20.054), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1230.707, 11.275, 23.542), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1240.720, 11.346, 26.288), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1249.121, 11.490, 30.083), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1260.078, 11.706, 36.519), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1269.256, 11.764, 40.910), new Ypr(0.000, 0.000, -0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1277.528, 11.892, 46.769), new Ypr(0.000, 0.000, -0.000) ); 

gt.create_native( map, new GameRef(objects:0x000004ACr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1250.085, 8.186, -3.140), new Ypr(0.000, 0.000, -0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1254.288, 7.976, -4.468), new Ypr(0.762, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1248.274, 7.818, -6.500), new Ypr(0.762, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1245.521, 8.153, -2.381), new Ypr(0.762, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1250.575, 8.441, 1.463), new Ypr(0.762, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x0000001Ar), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1280.087, 7.200, -167.367), new Ypr(-1.528, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1274.423, 6.266, -173.569), new Ypr(0.762, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1275.163, 6.066, -160.974), new Ypr(0.762, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A9r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1257.898, 6.100, -190.645), new Ypr(-0.160, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1264.313, 4.834, -183.423), new Ypr(0.762, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1251.090, 4.567, -186.909), new Ypr(0.762, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1246.720, 5.529, -197.459), new Ypr(-1.528, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1258.176, 6.034, -200.888), new Ypr(-1.528, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1269.053, 8.656, -197.837), new Ypr(-1.528, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1271.903, 8.790, -188.272), new Ypr(-1.528, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1271.903, 8.790, -188.272), new Ypr(-1.528, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1282.300, 9.728, -183.779), new Ypr(-1.528, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1269.267, 6.586, -176.551), new Ypr(-1.528, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1236.227, 4.986, -185.616), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1228.939, 3.973, -191.158), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1222.177, 3.195, -201.105), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1220.715, 2.249, -209.835), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1254.762, 5.064, -210.622), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1246.535, 4.645, -207.560), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1238.137, 4.007, -202.958), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1241.420, 4.086, -195.026), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1232.741, 3.584, -190.923), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1229.182, 3.173, -197.098), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1229.314, 2.032, -207.151), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1235.290, 3.191, -209.523), new Ypr(-1.528, 0.000, 0.000) );
 
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1227.612, 0.886, -89.291), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1219.127, -6.884, -105.286), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1216.478, -7.109, -124.797), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1224.149, -1.739, -131.821), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1219.703, -2.576, -145.248), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1210.783, -5.105, -166.555), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1227.495, -0.369, -100.475), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1224.116, -3.579, -117.623), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1217.198, -6.660, -135.728), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1208.931, -8.058, -150.296), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1200.923, -4.756, -177.587), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1209.944, -3.854, -182.425), new Ypr(-1.528, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1337.938, 21.296, -208.214), new Ypr(-2.424, 0.000, -0.010) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1331.547, 18.211, -208.436), new Ypr(-2.453, 0.000, -0.150) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1333.818, 20.800, -259.965), new Ypr(-2.424, 0.000, -0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1326.458, 18.687, -260.602), new Ypr(-0.350, 0.000, 0.200) );

gt.create_native( map, new GameRef(objects:0x0000002Er), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1399.202, 34.850, -230.538), new Ypr(-1.553, 0.000, 0.000) );
  
gt.create_native( map, new GameRef(objects:0x0000002Ar), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1412.331, 32.500, -181.956), new Ypr(-1.801, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1393.809, 34.784, -238.656), new Ypr(0.762, -0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1390.892, 32.784, -224.081), new Ypr(0.762, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1406.786, 30.833, -190.725), new Ypr(0.762, -0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1403.890, 29.258, -179.437), new Ypr(0.762, -0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1352.407, 11.760, 213.302), new Ypr(-0.350, 0.000, 0.000) );   

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1349.706, 12.501, 179.734), new Ypr(-0.350, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1346.439, 11.566, 158.648), new Ypr(-0.350, 0.000, 0.000) );   

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1346.588, 11.670, 141.095), new Ypr(-0.350, 0.000, 0.000) );   

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1345.674, 12.932, 122.908), new Ypr(-0.350, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1348.579, 11.994, 97.654), new Ypr(-0.350, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1357.183, 11.620, 75.409), new Ypr(-0.350, 0.000, 0.000) );     

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1340.819, 12.156, 134.726), new Ypr(-0.350, 0.000, 0.000) );   
//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1341.281, 4.724, -46.195), new Ypr(-0.350, 0.000, 0.000) );   

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1384.337, 7.368, -4.148), new Ypr(-0.350, 0.000, 0.000) );       

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1360.053, 12.424, 67.288), new Ypr(-0.350, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1365.322, 11.194, 58.525), new Ypr(-0.350, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1374.687, 11.335, 46.663), new Ypr(-0.350, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1382.633, 10.327, 29.003), new Ypr(-0.350, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1385.577, 7.975, 13.739), new Ypr(-0.350, 0.000, 0.000) );   

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1379.507, 5.151, -16.625), new Ypr(-0.350, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1366.506, 4.121, -30.451), new Ypr(-0.350, 0.000, 0.000) );   

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1356.121, 5.887, -40.657), new Ypr(-0.350, 0.000, 0.000) );     

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1348.303, 7.207, -51.130), new Ypr(-0.350, 0.000, 0.000) );     

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1376.749, 4.871, -35.390), new Ypr(-0.350, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1366.265, 4.738, -42.360), new Ypr(-0.350, 0.000, 0.000) );   

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1351.932, 6.099, -21.134), new Ypr(-0.350, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1351.593, 5.737, -13.473), new Ypr(-0.350, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1349.059, 8.446, 4.004), new Ypr(0.454, 0.000, -0.090) );

// after long break
// lights always backwards| 
//0x00000000r - big tree  | 4.000 above car level
//0x00000000r- regular bent city lamp | 4.000 above car level
//0x00000000r - small tree |  3.000 above car level
//0x00000000 - straight city lamp | 1.900 above car level

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1174.726, 17.558, 321.595), new Ypr(1.069, 0.148, -0.050) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1308.251, 14.111, 381.423), new Ypr(-2.399, -0.014, 0.050) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1308.025, 13.124, 389.916), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1307.727, 14.131, 401.405), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1310.828, 14.137, 411.937), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1310.862, 13.152, 425.284), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1306.942, 13.164, 434.187), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1307.769, 14.177, 443.415), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1309.402, 14.187, 454.347), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1305.346, 14.200, 464.174), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1309.532, 14.211, 472.975), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1306.067, 14.234, 482.566), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1306.783, 13.242, 489.909), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1310.403, 13.245, 496.939), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1305.549, 14.261, 505.508), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1307.543, 13.259, 514.782), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1305.324, 14.268, 523.860), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1308.744, 13.282, 535.819), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1305.539, 14.290, 545.982), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1307.171, 14.298, 554.092), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1307.840, 14.306, 562.640), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1304.867, 14.311, 573.000), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1340.121, 13.896, 374.177), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1339.132, 12.965, 387.202), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1341.847, 14.119, 406.556), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1340.723, 14.141, 420.340), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1339.166, 13.179, 447.936), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1338.432, 14.212, 472.764), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1340.000, 13.234, 490.438), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1337.797, 14.247, 500.728), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1337.439, 14.273, 522.504), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1341.305, 14.287, 536.614), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1336.923, 13.303, 553.437), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1336.883, 14.319, 573.354), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1348.021, 20.779, 360.565), new Ypr(1.652, 0.100, 0.220) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1355.550, 13.085, 379.584), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1350.389, 19.583, 358.294), new Ypr(0.000, 0.000, 0.000) );
   
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1132.706, 10.257, 1198.442), new Ypr(0.843, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1113.618, 8.131, 1219.651), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1118.292, 9.215, 1203.307), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1126.860, 9.246, 1198.957), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(791.059, 7.210, 1417.443), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(783.423, 9.224, 1419.143), new Ypr(0.000, 0.000, 0.000) );
//



gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 360.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 367.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 374.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 381.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 388.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 395.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 402.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 409.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 416.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 423.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 430.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 437.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 444.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 451.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 458.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 465.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 472.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 479.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 486.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 493.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 500.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 507.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 514.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 521.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 528.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 535.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 542.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 549.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 556.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 563.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.911, 6.306, 563.554), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1356.481, 6.306, 576.507), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1351.850, 6.306, 580.352), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1347.572, 6.306, 585.622), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1344.786, 6.306, 589.706), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1357.893, 6.306, 570.191), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x0000006fr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1413.003, 1.306, 480.998), new Ypr(1.450, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1359.347, 14.329, 591.276), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1368.860, 14.315, 571.845), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1368.951, 14.289, 542.529), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1372.078, 14.246, 501.312), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1366.476, 14.195, 461.310), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1368.693, 14.165, 439.320), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1358.676, 18.660, 357.570), new Ypr(1.136, 0.200, 0.070) );


gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(61.151, 9.759, 1507.684), new Ypr(-3.071, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(111.948, 9.729, 1505.814), new Ypr(3.091, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(154.384, 9.676, 1504.178), new Ypr(3.111, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(198.965, 9.605, 1502.510), new Ypr(-3.058, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(242.690, 9.528, 1500.811), new Ypr(-3.044, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(286.504, 9.429, 1499.761), new Ypr(-3.080, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(331.024, 9.296, 1499.731), new Ypr(-3.105, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(375.660, 9.145, 1500.287), new Ypr(3.140, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(419.702, 8.995, 1500.906), new Ypr(-3.082, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(464.025, 8.959, 1501.008), new Ypr(-3.013, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(508.621, 8.753, 1500.127), new Ypr(-3.129, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(555.564, 8.692, 1497.577), new Ypr(-3.069, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(599.702, 8.712, 1493.178), new Ypr(-3.053, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(644.557, 8.833, 1486.872), new Ypr(-2.908, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(688.812, 9.009, 1478.437), new Ypr(-2.905, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(733.656, 9.191, 1467.343), new Ypr(-2.852, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(775.737, 9.313, 1454.185), new Ypr(-2.803, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(818.393, 9.345, 1437.823), new Ypr(-2.709, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(859.563, 9.346, 1420.552), new Ypr(-2.608, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(899.743, 9.413, 1401.769), new Ypr(-2.640, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(938.906, 9.561, 1381.009), new Ypr(-2.520, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(978.487, 9.760, 1357.530), new Ypr(-2.490, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1015.413, 9.956, 1333.369), new Ypr(-2.523, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1051.895, 10.124, 1307.327), new Ypr(-2.491, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1086.981, 10.220, 1280.382), new Ypr(-2.408, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1121.564, 10.231, 1251.338), new Ypr(-2.346, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1156.292, 10.276, 1217.664), new Ypr(-2.247, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1186.124, 10.462, 1184.216), new Ypr(-2.193, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1213.729, 10.771, 1148.661), new Ypr(-2.105, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1238.445, 11.162, 1111.798), new Ypr(-2.046, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1259.817, 11.596, 1074.768), new Ypr(-2.023, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1279.508, 12.085, 1034.593), new Ypr(-1.911, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1295.398, 12.553, 995.451), new Ypr(-1.810, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1308.893, 13.010, 954.125), new Ypr(-1.805, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1319.277, 13.421, 912.110), new Ypr(-1.720, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1326.615, 13.756, 869.170), new Ypr(-1.581, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1330.356, 13.990, 826.361), new Ypr(-1.536, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1332.439, 14.141, 783.135), new Ypr(-1.502, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1334.189, 14.245, 739.038), new Ypr(-1.519, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1335.946, 14.315, 689.844), new Ypr(-1.492, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1337.310, 14.339, 645.986), new Ypr(-1.479, 0.000, 0.000) );

//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1147.953, 10.320, 1179.325), new Ypr(0.835, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1173.477, 10.534, 1148.811), new Ypr(0.965, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1198.372, 10.917, 1114.650), new Ypr(0.968, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1220.110, 11.337, 1080.160), new Ypr(1.093, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1239.971, 11.802, 1043.366), new Ypr(1.162, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1256.721, 12.279, 1006.511), new Ypr(1.248, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1271.165, 12.745, 967.739), new Ypr(1.350, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1282.144, 13.172, 930.399), new Ypr(1.445, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1291.280, 13.569, 887.977), new Ypr(1.486, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1296.636, 13.865, 848.121), new Ypr(1.503, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1299.237, 14.051, 806.343), new Ypr(1.530, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1301.316, 14.198, 758.747), new Ypr(1.544, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1302.899, 14.267, 718.198), new Ypr(1.591, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1304.580, 14.318, 668.141), new Ypr(1.569, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1305.876, 14.332, 622.862), new Ypr(1.537, 0.000, 0.000) );

//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1136.548, 10.264, 1187.654), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1143.345, 10.283, 1176.963), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1154.907, 10.364, 1167.896), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1162.731, 9.437, 1156.730), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1171.082, 10.503, 1144.235), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1182.461, 10.669, 1133.396), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1189.201, 10.773, 1123.497), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1192.894, 10.873, 1113.567), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1201.771, 10.998, 1104.939), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1209.547, 11.154, 1093.534), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1209.547, 11.154, 1093.534), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1215.101, 11.312, 1078.030), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1222.643, 11.436, 1068.939), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1232.519, 11.655, 1053.452), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1237.418, 11.831, 1037.734), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1246.705, 12.008, 1025.873), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1250.460, 12.177, 1012.588), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1256.263, 12.332, 1000.783), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1264.324, 12.565, 981.891), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1266.568, 11.688, 969.902), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1273.126, 12.876, 956.769), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1277.076, 12.047, 941.183), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1278.861, 13.189, 926.418), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1286.447, 12.400, 906.232), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1287.327, 12.522, 891.209), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1291.118, 13.661, 874.631), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1291.458, 13.767, 859.570), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1292.832, 13.871, 845.281), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1296.828, 13.977, 824.616), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1295.690, 13.024, 810.996), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1296.934, 14.078, 795.896), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1299.397, 14.156, 772.278), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1297.260, 14.197, 757.089), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1300.062, 14.236, 740.198), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1299.410, 13.254, 720.246), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1300.946, 13.273, 709.516), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1302.135, 14.299, 685.640), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1300.485, 14.304, 669.992), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1303.763, 14.323, 652.493), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1303.508, 14.326, 632.783), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1301.682, 14.323, 622.619), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1303.649, 13.327, 611.636), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1305.123, 14.323, 590.787), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1341.790, 14.333, 603.423), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1343.042, 14.337, 615.416), new Ypr(2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1343.846, 14.338, 631.179), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1343.292, 14.336, 646.467), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1341.112, 14.331, 660.172), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1341.620, 14.325, 672.065), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1341.351, 14.315, 689.480), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1338.685, 14.295, 705.571), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1341.125, 14.273, 721.704), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1339.557, 14.242, 738.643), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1339.033, 14.216, 752.166), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1336.476, 14.180, 767.196), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1336.863, 14.136, 783.479), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1334.676, 14.094, 797.095), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1336.416, 14.046, 810.987), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1334.532, 13.987, 826.351), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1334.870, 13.910, 842.825), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1332.296, 13.813, 860.161), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1329.506, 13.717, 875.130), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1326.348, 13.574, 894.035), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1324.036, 13.439, 910.744), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1132.880, 10.228, 1242.831), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1142.578, 10.233, 1235.768), new Ypr(1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1151.775, 10.250, 1228.692), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1160.530, 10.277, 1220.266), new Ypr(1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1166.680, 10.310, 1211.527), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1175.335, 10.350, 1204.175), new Ypr(0.300, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1182.976, 10.403, 1196.142), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1189.871, 10.461, 1186.830), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1197.272, 10.532, 1178.189), new Ypr(0.600, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1204.620, 10.619, 1166.174), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1212.532, 10.709, 1157.270), new Ypr(2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1221.654, 10.824, 1145.615), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1229.625, 10.960, 1131.845), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1237.586, 11.077, 1121.409), new Ypr(0.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1245.715, 11.228, 1107.713), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1254.967, 11.394, 1093.689), new Ypr(0.600, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1262.796, 11.560, 1079.801), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1267.882, 11.710, 1066.455), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1275.275, 11.870, 1053.542), new Ypr(0.300, 0.200, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1282.933, 12.055, 1038.653), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1286.032, 12.191, 1026.664), new Ypr(0.600, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1293.786, 12.361, 1013.129), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1298.601, 12.499, 1001.620), new Ypr(2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1302.408, 12.645, 988.408), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1305.349, 12.811, 972.866), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1310.739, 12.921, 963.280), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1315.856, 13.063, 950.220), new Ypr(1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1317.545, 13.178, 938.422), new Ypr(0.000, 0.090, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1319.882, 13.277, 972.923), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1128.081, 10.228, 1250.697), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1112.703, 10.225, 1263.277), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1100.603, 10.222, 1271.765), new Ypr(1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1089.326, 10.214, 1282.786), new Ypr(0.300, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1077.963, 10.194, 1291.430), new Ypr(0.100, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1064.595, 10.157, 1300.284), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1053.857, 10.118, 1310.192), new Ypr(0.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1041.182, 10.070, 1318.081), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1030.963, 10.019, 1326.767), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1017.327, 9.950, 1336.387), new Ypr(2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1004.912, 9.889, 1342.898), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(991.974, 9.820, 1351.597), new Ypr(0.000, 0.000, 0.100) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(980.125, 9.755, 1360.198), new Ypr(0.500, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(965.974, 9.685, 1366.405), new Ypr(0.500, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(951.058, 9.608, 1376.774), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(941.098, 9.558, 1383.764), new Ypr(0.500, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(929.119, 9.510, 1388.679), new Ypr(0.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(915.721, 9.457, 1397.714), new Ypr(-0.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(900.854, 9.411, 1404.806), new Ypr(0.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(887.222, 9.376, 1409.988), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(874.530, 9.355, 1417.751), new Ypr(-0.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(861.459, 9.342, 1423.270), new Ypr(1.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(845.942, 9.340, 1427.998), new Ypr(0.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(832.165, 9.339, 1434.908), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(819.993, 9.339, 1441.080), new Ypr(0.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(805.789, 9.337, 1445.159), new Ypr(-0.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(790.542, 9.329, 1450.992), new Ypr(0.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(776.921, 9.309, 1457.722), new Ypr(0.100, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(763.119, 9.280, 1460.107), new Ypr(2.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(748.366, 9.234, 1465.526), new Ypr(0.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(734.064, 9.510, 1470.898), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(718.766, 9.127, 1473.069), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(703.048, 9.063, 1476.100), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(689.115, 9.001, 1482.619), new Ypr(0.300, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(675.710, 8.947, 1483.469), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(658.950, 8.883, 1485.867), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(644.859, 8.828, 1490.336), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(631.771, 8.783, 1490.945), new Ypr(1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(615.375, 8.738, 1493.553), new Ypr(2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(601.205, 8.710, 1496.903), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(586.265, 8.689, 1496.134), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(569.991, 8.687, 1498.559), new Ypr(0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(555.811, 8.688, 1500.975), new Ypr(2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(543.905, 8.700, 1499.898), new Ypr(2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(525.115, 8.720, 1500.661), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(508.960, 8.747, 1503.352), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(493.573, 8.780, 1501.778), new Ypr(1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(479.637, 8.814, 1501.097), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(465.529, 8.850, 1504.329), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(448.635, 8.900, 1502.235), new Ypr(0.400, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(435.774, 8.939, 1502.296), new Ypr(2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(420.891, 8.986, 1504.150), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(405.665, 9.038, 1501.435), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(390.870, 9.088, 1502.567), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(377.019, 9.135, 1503.805), new Ypr(0.300, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(362.857, 9.184, 1500.884), new Ypr(2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(346.550, 9.240, 1499.704), new Ypr(0.600, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(330.883, 9.291, 1503.670), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(317.688, 9.335, 1500.290), new Ypr(1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(302.063, 9.383, 1500.882), new Ypr(1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(286.590, 9.427, 1503.503), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(273.569, 9.458, 1501.123), new Ypr(1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(256.901, 9.496, 1500.911), new Ypr(2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(243.016, 9.526, 1504.817), new Ypr(1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(231.016, 9.546, 1501.643), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(215.928, 9.571, 1502.048), new Ypr(-1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(201.988, 9.601, 1505.086), new Ypr(1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(191.679, 9.614, 1505.238), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(181.959, 9.629, 1503.995), new Ypr(0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(169.700, 9.650, 1504.091), new Ypr(0.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(157.422, 9.666, 1507.435), new Ypr(0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(142.112, 9.688, 1505.710), new Ypr(1.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(126.883, 9.707, 1505.936), new Ypr(0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(115.895, 9.719, 1508.986), new Ypr(2.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(102.241, 9.731, 1508.389), new Ypr(0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(90.781, 9.740, 1508.738), new Ypr(1.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(81.228, 9.747, 1507.473), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(70.382, 9.751, 1508.344), new Ypr(0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(54.860, 9.756, 1508.406), new Ypr(2.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1100.574, 8.125, 1221.066), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1080.963, 10.214, 1243.948), new Ypr(0.798, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1050.963, 10.167, 1268.221), new Ypr(0.631, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1012.774, 10.048, 1294.001), new Ypr(0.597, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(980.843, 9.844, 13178.944), new Ypr(0.520, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(945.547, 9.655, 1340.126), new Ypr(0.429, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(907.004, 9.463, 1361.945), new Ypr(0.435, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(868.111, 9.324, 1381.462), new Ypr(0.447, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(830.654, 9.324, 1397.245), new Ypr(0.288, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(797.212, 7.115, 1405.527), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000060r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(978.060, 24.758, 1286.052), new Ypr(0.550, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(778.593, 9.149, 1419.061), new Ypr(0.427, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(745.671, 9.068, 1430.360), new Ypr(0.303, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(703.661, 8.906, 1442.029), new Ypr(0.263, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(660.261, 8.877, 1451.549), new Ypr(0.236, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(622.430, 8.741, 1457.867), new Ypr(0.027, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(577.338, 8.607, 1463.440), new Ypr(0.048, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(532.531, 8.613, 1466.996), new Ypr(0.055, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(490.072, 8.718, 1468.630), new Ypr(-0.012, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(445.285, 8.849, 1469.044), new Ypr(-0.064, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(402.156, 9.000, 1468.678), new Ypr(-0.116, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(358.474, 9.165, 1468.039), new Ypr(-0.080, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(312.474, 9.330, 1467.608), new Ypr(0.021, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(265.200, 9.465, 1468.044), new Ypr(-0.007, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(222.045, 9.552, 1469.530), new Ypr(0.101, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(177.452, 9.617, 1471.250), new Ypr(-0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(132.597, 9.693, 1472.963), new Ypr(-0.014, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(87.796, 9.734, 1474.631), new Ypr(-0.003, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(42.989, 9.660, 1476.755), new Ypr(-0.069, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(780.177, 8.119, 1416.608), new Ypr(-0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(31.708, 8.668, 1475.020), new Ypr(-0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(45.202, 9.625, 1472.009), new Ypr(-0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(57.501, 9.741, 1475.137), new Ypr(-0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(67.366, 9.728, 1471.218), new Ypr(-2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(78.331, 9.734, 1474.501), new Ypr(-0.500, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1135.317, -0.362, 1191.564), new Ypr(-0.500, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1131.799, -0.356, 1191.562), new Ypr(-0.500, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1128.117, -0.343, 1190.030), new Ypr(-0.500, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1126.024, -0.309, 1186.810), new Ypr(-0.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1124.135, -0.471, 1184.081), new Ypr(-1.500, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1136.399, -0.458, 1194.289), new Ypr(-0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1119.083, 10.164, 1191.733), new Ypr(-0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1121.781, 10.081, 1175.011), new Ypr(-0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1122.871, 9.027, 1164.888), new Ypr(-0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1124.643, 9.982, 1151.391), new Ypr(-2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1125.278, 9.944, 1138.460), new Ypr(-0.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1124.953, 8.915, 1126.207), new Ypr(-0.000, 0.000, 0.000) );

// 29.09

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(770.490, 8.895, 1415.741), new Ypr(-0.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(773.435, 9.118, 1420.600), new Ypr(-1.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(763.571, 9.162, 1425.702), new Ypr(-0.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(755.544, 9.058, 1426.336), new Ypr(-0.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(743.449, 8.892, 1427.019), new Ypr(-0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(735.273, 9.020, 1433.305), new Ypr(-0.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(720.363, 8.985, 1438.118), new Ypr(-0.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(706.544, 8.767, 1437.856), new Ypr(-2.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(695.287, 8.862, 1443.202), new Ypr(2.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(675.689, 8.866, 1448.632), new Ypr(1.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(660.638, 8.842, 1446.947), new Ypr(0.100, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(647.835, 8.814, 1452.517), new Ypr(1.400, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(630.298, 8.758, 1456.070), new Ypr(-2.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(618.522, 8.643, 1453.657), new Ypr(0.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(607.810, 8.659, 1459.666), new Ypr(0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(589.719, 8.626, 1462.491), new Ypr(0.300, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(577.256, 8.531, 1459.557), new Ypr(1.100, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(566.424, 8.563, 1462.557), new Ypr(1.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(542.542, 8.612, 1466.595), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(531.286, 8.535, 1462.748), new Ypr(2.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(522.262, 8.618, 1466.738), new Ypr(0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(508.827, 8.660, 1468.259), new Ypr(0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(495.264, 8.676, 1466.458), new Ypr(2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(482.199, 8.714, 1467.103), new Ypr(1.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(470.098, 8.762, 1468.467), new Ypr(3.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(456.512, 8.809, 1468.952), new Ypr(1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(447.180, 8.790, 1465.437), new Ypr(0.300, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(436.487, 8.863, 1468.065), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(416.038, 8.930, 1467.395), new Ypr(0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(397.990, 8.983, 1466.113), new Ypr(0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(375.361, 9.094, 1467.764), new Ypr(1.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(360.815, 9.121, 1464.640), new Ypr(0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(348.891, 9.196, 1467.916), new Ypr(0.100, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(327.239, 9.274, 1467.842), new Ypr(1.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(312.294, 9.304, 1463.150), new Ypr(0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(300.936, 9.353, 1466.314), new Ypr(0.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(282.051, 9.413, 1467.997), new Ypr(0.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(267.223, 9.435, 1464.235), new Ypr(-0.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(254.385, 9.496, 1466.673), new Ypr(-0.500, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(233.284, 9.536, 1469.334), new Ypr(-2.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(222.129, 9.538, 1465.575), new Ypr(-0.600, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(210.925, 9.542, 1467.958), new Ypr(-1.600, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(190.783, 9.585, 1470.702), new Ypr(-0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(178.275, 9.584, 1467.560), new Ypr(-0.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(168.742, 9.632, 1470.225), new Ypr(-1.600, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(148.534, 9.665, 1471.655), new Ypr(-0.100, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(132.588, 9.674, 1468.095), new Ypr(-1.100, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(116.136, 9.704, 1472.932), new Ypr(0.600, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(99.489, 9.718, 1473.440), new Ypr(0.100, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(46.356, -0.681, 1476.599), new Ypr(0.444, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(47.342, -0.681, 1474.307), new Ypr(-0.343, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(48.639, -0.681, 1472.133), new Ypr(-0.473, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(50.022, -0.681, 1469.028), new Ypr(-0.403, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(764.599, 8.625, 1414.305), new Ypr(-0.343, 0.000, 0.000) );
//


gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(48.968, -0.695, 1507.728), new Ypr(0.328, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(49.684, -0.695, 1509.536), new Ypr(0.328, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(50.726, -0.725, 1512.547), new Ypr(0.458, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(29.630, 9.759, 1511.826), new Ypr(-2.845, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(49.900, 9.759, 1519.123), new Ypr(-0.343, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(58.910, 8.655, 1514.721), new Ypr(-0.343, 0.000, 0.000) );

//30.09

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(776.603, 1.600, 1420.498), new Ypr(-2.362, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(774.497, -0.780, 1418.433), new Ypr(0.362, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x0000053Dr), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(837.049, 5.288,-1400.117), new Ypr(0.000,-0.003,0.000) );

gt.create_native( map, new GameRef(objects:0x0000053Dr), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(831.529, 5.288,-1402.139), new Ypr(0.000,-0.003,0.000) );

gt.create_native( map, new GameRef(objects:0x0000053Dr), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(825.442, 5.281,-1404.040), new Ypr(0.000,-0.003,0.000) );

gt.create_native( map, new GameRef(objects:0x0000053Dr), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(818.862, 5.279,-1405.765), new Ypr(0.000,-0.003,0.000) );

gt.create_native( map, new GameRef(objects:0x0000053Dr), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(811.736, 5.283,-1406.903), new Ypr(0.000,-0.003,0.000) );

gt.create_native( map, new GameRef(objects:0x0000053Dr), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(837.860, 5.287,-1407.633), new Ypr(0.000,-0.003,0.000) );
//

gt.create_native( map, new GameRef(objects:0x0000058Br), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1237.946, 26.366, 1257.537), new Ypr(-2.364,-0.003,0.000) );

gt.create_native( map, new GameRef(objects:0x0000058Ar), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1179.143, 0.232, 1316.686), new Ypr(-2.418,-0.003,0.000) );

gt.create_native( map, new GameRef(objects:0x0000058Cr), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1278.242, 26.711, 1207.173), new Ypr(-2.196,-0.003,0.000) );

gt.create_native( map, new GameRef(objects:0x00000589r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1123.526, 26.040, 1392.532), new Ypr(-2.418,-0.003,0.000) );

gt.create_native( map, new GameRef(objects:0x00000692r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1011.135, 5.483, 1468.620), new Ypr(-2.669,-0.003,0.000) );

gt.create_native( map, new GameRef(objects:0x00000586r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(880.166, 52.341, 1520.436), new Ypr(-2.718,-0.003,0.000) );

gt.create_native( map, new GameRef(objects:0x00000505r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(810.086, 52.341, 1600.470), new Ypr(-1.718,-0.003,0.000) );

gt.create_native( map, new GameRef(objects:0x0000058Cr), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(750.086, 45.341, 1680.470), new Ypr(-1.418,-0.003,0.000) );

gt.create_native( map, new GameRef(objects:0x0000058Br), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1342.813, 20.232, 1135.686), new Ypr(-2.110,-0.003,0.000) );

gt.create_native( map, new GameRef(objects:0x00000586r), "0,0,0,0,0,0", "test_object" );
gt.setMatrix( new Vector3(1373.950, 35.232, 1034.686), new Ypr(-1.864,-0.003,0.000) );

//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1083.853, -0.695, 1243.249), new Ypr(-2.697, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1087.086, 9.121, 1238.277), new Ypr(-1.697, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1092.218, 9.119, 1231.697), new Ypr(0.697, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1094.115, 10.210, 1225.017), new Ypr(-1.697, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1100.853, 9.106, 1214.445), new Ypr(0.697, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1075.501, 10.190, 1241.423), new Ypr(-1.697, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(827.732, 0.321, 1398.004), new Ypr(-2.356, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(816.751, 8.826, 1400.911), new Ypr(-1.0770, -0.048, 0.141) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(803.450, 7.802, 1402.697), new Ypr(-1.835, 0.000, 0.050) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(788.812, 8.159, 1402.552), new Ypr(-0.968, 0.000, 0.010) );

gt.create_native( map, new GameRef(objects:0x00000060r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(890.728, 23.059, 1336.734), new Ypr(-2.723, 0.000, 0.010) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(811.587, 7.202, 1397.250), new Ypr(-3.022, 0.137, -0.006) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(803.163, 7.859, 1395.678), new Ypr(-1.919, 0.042, -0.112) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(795.242, 8.480, 1394.188), new Ypr(-1.194, 0.093, -0.122) );
//
gt.create_native( map, new GameRef(objects:0x00000546r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 838.246, 5.480, 1399.869), new Ypr(1.947, -0.000, 0.061) );

gt.create_native( map, new GameRef(objects:0x00000546r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 831.720, 5.473, 1402.323), new Ypr(1.903, -0.004, 0.065) );

gt.create_native( map, new GameRef(objects:0x00000546r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 823.116, 5.470, 1404.879), new Ypr(1.812, -0.002, 0.053) );

gt.create_native( map, new GameRef(objects:0x00000546r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 814.982, 5.464, 1406.761), new Ypr(1.768, -0.005, 0.048) );

gt.create_native( map, new GameRef(objects:0x00000546r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 806.575, 5.468, 1407.733), new Ypr(1.618, -0.003, 0.056) );

gt.create_native( map, new GameRef(objects:0x00000546r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 799.933, 5.501, 1408.008), new Ypr(1.598, 0.005, 0.101) );

gt.create_native( map, new GameRef(objects:0x00000546r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1101.653, 6.346, 1225.430), new Ypr(2.863, -0.012, 0.045) );

gt.create_native( map, new GameRef(objects:0x00000546r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1099.440, 6.335, 1230.574), new Ypr(2.676, -0.006, 0.038) );

gt.create_native( map, new GameRef(objects:0x00000546r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1095.894, 6.327, 1236.110), new Ypr(2.550, -0.005, 0.028) );

gt.create_native( map, new GameRef(objects:0x00000546r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1090.692, 6.335, 1241.785), new Ypr(2.341, -0.004, 0.035) );

gt.create_native( map, new GameRef(objects:0x00000546r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1086.728, 6.355, 1245.557), new Ypr(2.227, 0.002, 0.060) );
//
gt.create_native( map, new GameRef(cars.traffic.civilvan:0x0006r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1308.057, 10.237, 189.496), new Ypr(1.581, 0.058, -0.004) );

gt.create_native( map, new GameRef(cars.traffic.Wagon:0x0006r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1308.057, 10.237, 181.496), new Ypr(1.581, 0.058, -0.004) );

gt.create_native( map, new GameRef(cars.traffic.civilvan:0x0006r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1308.057, 10.180, 173.496), new Ypr(1.581, 0.058, -0.004) );

gt.create_native( map, new GameRef(cars.traffic.Erbilac:0x0006r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1308.057, 10.110, 165.496), new Ypr(1.581, 0.058, -0.004) );

gt.create_native( map, new GameRef(cars.traffic.Wagon:0x0006r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1308.057, 10.080, 157.496), new Ypr(1.581, 0.058, -0.004) );

gt.create_native( map, new GameRef(objects:0x00000587r), "0,0,0,0,0,0", "test_object" ); // factory on east behind the fence
gt.setMatrix( new Vector3( 1255.369, 18.170, 190.710), new Ypr(1.502, -0.003, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000518r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1465.420, 24.406, 870.159), new Ypr(-0.684, 0.000, -0.000) );

// house side
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1295.439, 13.434, -632.799), new Ypr(2.637, 0.182, -0.278) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1285.725, 14.256, -628.835), new Ypr(2.197, 0.054, -0.339) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1326.038, 17.036, -275.626), new Ypr(-2.934, 0.006, -0.151) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1339.205, 20.093, -274.769), new Ypr(-2.598, 0.302, -0.197) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1322.861, 15.746, -286.457), new Ypr(0.465, -0.059, 0.139) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1320.792, 15.680, -302.669), new Ypr(-0.070, 0.015, 0.140) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1322.506, 16.074, -314.409), new Ypr(-0.149, 0.026, 0.139) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1319.749, 15.817, -324.509), new Ypr(0.526, -0.067, 0.102) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1318.180, 15.602, -337.506), new Ypr(-0.044, 0.002, 0.062) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1316.377, 15.611, -352.463), new Ypr(0.194, -0.012, 0.063) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1317.870, 15.791, -362.506), new Ypr(-0.217, 0.013, 0.059) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1314.595, 15.693, -374.192), new Ypr(0.327, -0.019, 0.058) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1313.106, 15.767, -391.300), new Ypr(-0.141, 0.009, 0.073) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1313.518, 15.937, -402.741), new Ypr(0.156, -0.008, 0.070) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1309.864, 15.832, -415.197), new Ypr(0.331, -0.019, 0.076) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1309.535, 15.958, -427.312), new Ypr(-0.122, 0.012, 0.073) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1311.944, 16.239, -436.515), new Ypr(-0.317, 0.025, 0.056) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1307.794, 16.079, -445.042), new Ypr(0.500, -0.027, 0.066) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1305.686, 16.106, -456.993), new Ypr(0.030, 0.004, 0.069) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1303.591, 16.102, -465.984), new Ypr(0.365, -0.017, 0.067) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1304.864, 16.383, -479.083), new Ypr(-0.149, 0.017, 0.061) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1301.462, 16.294, -487.087), new Ypr(0.526, -0.026, 0.066) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1298.612, 16.354, -501.443), new Ypr(0.135, 0.000, 0.066) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1299.405, 16.633, -514.243), new Ypr(-0.162, 0.020, 0.059) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1296.274, 16.434, -524.047), new Ypr(0.482, -0.006, 0.010) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1292.396, 16.545, -539.746), new Ypr( 2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1291.336, 16.936, -553.979), new Ypr( 0.008, 0.013, 0.070) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1287.072, 16.916, -566.341), new Ypr( 0.440, -0.017, 0.077) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1283.936, 16.973, -577.969), new Ypr( 0.114, 0.008, 0.075) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1281.659, 16.798, -590.140), new Ypr( 0.306, 0.002, -0.049) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1281.598, 16.767, -600.497), new Ypr( 0.003, -0.010, -0.059) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1277.120, 16.949, -607.726), new Ypr( 0.611, 0.009, -0.028) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1297.055, 5.448, -56.322), new Ypr( -1.473, 0.070, -0.260) );

//other side
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1299.464, 14.567, -213.306), new Ypr( -0.042, 0.042, 0.221) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1299.280, 14.569, -214.364), new Ypr( 0.054, 0.022, 0.224) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1296.544, 14.331, -225.589), new Ypr( 0.137, -0.015, 0.193) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1298.125, 14.824, -238.518), new Ypr( -0.111, 0.029, 0.186) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1296.192, 14.667, -255.308), new Ypr( 0.169, -0.024, 0.221) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1294.721, 14.566, -266.671), new Ypr( -0.013, 0.014, 0.221) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1294.895, 14.844, -279.819), new Ypr( -0.025, 0.016, 0.224) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1293.348, 14.711, -293.274), new Ypr( 0.183, -0.029, 0.237) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1291.570, 14.288, -304.882), new Ypr( -0.018, -0.019, 0.300) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1291.509, 14.747, -322.262), new Ypr( -0.052, 0.049, 0.321) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1289.458, 14.642, -335.407), new Ypr( 0.182, -0.030, 0.275) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1288.522, 14.744, -348.592), new Ypr( -0.150, 0.059, 0.267) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1287.953, 15.095, -365.992), new Ypr( 0.073, 0.001, 0.262) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1287.666, 15.095, -368.654), new Ypr( 0.073, 0.002, 0.261) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1284.818, 14.696, -379.863), new Ypr( 0.198, -0.028, 0.263) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1284.603, 14.786, -391.882), new Ypr( -0.140, 0.071, 0.317) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1283.787, 15.151, -408.031), new Ypr( 0.080, 0.006, 0.348) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1280.656, 14.529, -418.446), new Ypr( 0.327, -0.076, 0.344) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1279.460, 14.283, -427.968), new Ypr( -0.138, 0.054, 0.406) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1279.358, 15.046, -443.520), new Ypr( 0.080, 0.018, 0.444) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1276.516, 15.069, -455.094), new Ypr( 0.286, 0.030, 0.282) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1275.120, 15.245, -467.174), new Ypr( -0.057, 0.048, 0.263) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1274.751, 15.577, -477.739), new Ypr( 0.048, 0.021, 0.266) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1272.905, 15.956, -491.733), new Ypr( 0.136, 0.002, 0.127) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1269.280, 15.695, -503.157), new Ypr( 0.308, -0.033, 0.163) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1268.570, 15.957, -514.464), new Ypr( -0.015, 0.029, 0.162) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1265.591, 15.867, -537.126), new Ypr( 0.186, -0.003, 0.257) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1261.632, 15.589, -543.472), new Ypr( 0.204, 0.000, 0.266) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1259.865, 15.824, -558.169), new Ypr( 0.097, 0.040, 0.333) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1255.460, 16.167, -573.524), new Ypr( 0.420, -0.031, 0.212) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1252.709, 16.367, -588.254), new Ypr( -0.045, 0.033, 0.209) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1299.841, 10.812, -644.741), new Ypr( -3.062, 0.314, 0.004) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1274.316, 17.012, -619.515), new Ypr( 1.416, 0.040, -0.009) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1327.474, 17.658, -246.869), new Ypr( 2.509, -0.301, -0.361) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1328.288, 17.166, -223.051), new Ypr( 2.966, -0.110, -0.469) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1329.133, 15.257, -183.921), new Ypr( -0.786, 0.123, 0.094) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1337.017, 13.012, 369.078), new Ypr( -0.069, 0.008, -0.054) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1336.241, 12.187, -64.099), new Ypr( 2.829, 0.161, 0.451) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1371.228, 3.616, -33.470), new Ypr( 0.224, 0.007, 0.041) );

// bushes and light next to factory

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1145.674, 0.000, 7.478), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1152.440, 0.000, 6.920), new Ypr( 2.400, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1159.700, 0.000, 5.579), new Ypr( -0.300, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1166.599, 0.000, 4.525), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1173.162, 0.000, 4.574), new Ypr( 2.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1178.974, 0.000, 5.405), new Ypr( 0.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1184.673, 0.000, 6.509), new Ypr( -1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1191.052, 0.100, 8.022), new Ypr( 1.600, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1198.074, 0.200, 10.046), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1205.313, 0.300, 11.838), new Ypr( 0.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1211.989, 0.400, 13.291), new Ypr( -0.300, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1217.475, 0.500, 14.721), new Ypr( 0.800, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1224.481, 0.600, 16.760), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1232.401, 0.700, 18.648), new Ypr( 1.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1238.616, 0.800, 20.692), new Ypr( 0.500, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1245.191, 0.900, 23.734), new Ypr( -1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1251.628, 1.000, 27.056), new Ypr( 1.900, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1259.385, 1.100, 29.933), new Ypr( 0.800, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1265.872, 1.200, 32.329), new Ypr( -0.300, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1273.392, 1.300, 35.417), new Ypr( 0.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1280.868, 1.400, 38.723), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1288.854, 1.500, 42.415), new Ypr( 1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1178.454, 9.535, -2.745), new Ypr( -2.532, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1191.997, 9.616, -2.301), new Ypr( -1.600, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1209.916, 9.802, 0.097), new Ypr( -1.932, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1229.679, 9.935, 4.823), new Ypr( -2.932, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1246.079, 10.603, 16.033), new Ypr( -2.132, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1263.433, 10.466, 17.327), new Ypr( -1.232, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1279.403, 10.265, 20.147), new Ypr( -2.032, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1291.835, 10.440, 29.895), new Ypr( -2.432, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1162.965, 8.562, 0.643), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1176.300, 8.638, 0.242), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1189.380, 8.805, 1.905), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1201.270, 9.005, 4.392), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1212.933, 9.164, 6.936), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1226.625, 9.292, 10.627), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1239.213, 9.536, 15.841), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1248.879, 9.705, 19.734), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1265.550, 9.551, 21.380), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1278.489, 9.527, 25.782), new Ypr( 0.000, 0.000, 0.000) );

// pillars 
//gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3( 1325.128, 7.000, 362.622), new Ypr( -0.012, 0.000, 0.000) );

//gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
//gt.setMatrix( new Vector3( 1325.188, 7.000, 357.292), new Ypr( -0.012, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1248.210, 17.412, -603.794), new Ypr( -0.768, 0.220, 0.108) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1248.804, 16.768, -592.249), new Ypr( 2.972, -0.079, -0.205) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1249.900, 16.622, -581.966), new Ypr( -2.796, 0.026, 0.194) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1255.932, 16.598, -567.807), new Ypr( -2.140, 0.147, -0.232) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1256.818, 15.675, -555.825), new Ypr( 3.119, -0.065, -0.333) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1264.438, 16.649, -532.360), new Ypr( -2.373, 0.152, -0.219) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1261.638, 15.962, -518.701), new Ypr( 2.825, -0.026, -0.216) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1262.032, 15.568, -501.438), new Ypr( 3.046, 0.006, -0.158) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1268.733, 16.320, -486.274), new Ypr( -2.547, 0.066, -0.119) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1268.481, 15.173, -473.478), new Ypr( 3.053, -0.124, -0.039) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1270.198, 14.729, -460.659), new Ypr( -2.794, 0.070, -0.263) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1272.470, 13.565, -446.340), new Ypr( -2.919, -0.109, -0.283) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1274.061, 13.229, -435.122), new Ypr( -3.014, 0.018, -0.458) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1276.130, 13.872, -416.774), new Ypr( -3.046, 0.0152, -0.392) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1276.189, 13.887, -395.310), new Ypr( -2.694, 0.149, -0.262) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1279.729, 14.386, -379.152), new Ypr( -2.873, 0.090, -0.279) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1283.611, 14.839, -360.750), new Ypr( -2.769, 0.084, -0.259) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1284.869, 14.629, -342.959), new Ypr( 3.101, -0.015, -0.272) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1288.514, 14.614, -317.195), new Ypr( -2.454, 0.206, -0.273) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1285.950, 13.652, -306.974), new Ypr( 2.736, -0.071, -0.290) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1287.931, 14.372, -290.150), new Ypr( -2.651, 0.115, -0.227) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1289.606, 14.541, -269.546), new Ypr( 3.029, -0.021, -0.217) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1292.623, 14.874, -249.075), new Ypr( -2.767, 0.089, -0.185) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1292.208, 14.638, -231.073), new Ypr( 3.061, -0.009, -0.187) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1293.931, 14.473, -215.675), new Ypr( -2.737, 0.069, -0.222) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1294.197, 13.847, -195.410), new Ypr( 2.335, -0.188, -0.166) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1241.675, 15.661, -598.676), new Ypr( 0.894, -0.102, 0.193) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1233.209, 12.418, -593.955), new Ypr( 2.297, -0.219, -0.181) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1219.865, 8.381, -591.224), new Ypr( 1.557, -0.252, -0.072) );

//gt.create_native( map, new GameRef(objects:0x0000006Fr), "0,0,0,0,0,0", "test_object" ); CONSTRUCTION NORTH
//gt.setMatrix( new Vector3( 1404.073, 7.503, -508.815), new Ypr( 1.614, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1244.566, 14.807, -588.024), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1251.423, 14.023, -562.860), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1255.680, 13.865, -538.311), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1259.998, 14.388, -526.966), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1258.008, 14.267, -513.494), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1260.837, 14.377, -496.140), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1263.135, 14.607, -483.847), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1265.539, 13.491, -469.598), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1267.673, 12.925, -456.561), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1270.274, 11.349, -442.611), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1272.461, 11.471, -428.644), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1274.952, 12.269, -410.754), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1277.961, 12.854, -389.364), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1279.471, 13.179, -373.407), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1280.106, 12.649, -351.336), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1284.198, 13.228, -334.046), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1283.582, 11.961, -315.126), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1284.864, 12.569, -282.568), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1287.555, 12.991, -262.954), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1287.616, 12.912, -243.826), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1287.863, 12.568, -226.927), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1289.716, 12.272, -210.218), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1290.008, 11.547, -191.625), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1246.067, 2.965, -629.515), new Ypr( 0.339, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1237.927, 2.990, -650.879), new Ypr( 0.388, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1261.246, 3.009, -643.029), new Ypr( 0.339, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1252.499, 3.059, -663.336), new Ypr( 0.388, 0.000, 0.000) );
//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1279.479, 17.863, -613.718), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1285.459, 17.617, -596.534), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1288.151, 18.086, -583.227), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1293.256, 18.305, -564.267), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1294.380, 17.794, -549.194), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1292.932, 17.484, -532.889), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1300.342, 17.508, -520.968), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1301.888, 17.650, -506.551), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1301.818, 17.504, -498.381), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1306.301, 17.583, -486.088), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1306.536, 17.428, -474.881), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1309.153, 17.417, -462.734), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1307.599, 17.173, -452.900), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1313.206, 17.242, -430.390), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1312.061, 17.035, -419.825), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1311.148, 16.850, -409.345), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1315.908, 17.012, -396.340), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1315.268, 16.853, -386.508), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1315.161, 16.680, -368.887), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1320.300, 16.814, -347.555), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1319.032, 16.619, -332.630), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1323.963, 17.208, -309.918), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1322.686, 16.884, -298.846), new Ypr( 0.000, 0.000, 0.000) );

//houses

gt.create_native( map, new GameRef(objects:0x000001A0r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1357.765, 19.455, -403.065), new Ypr( -1.746, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A1r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1356.159, 19.558, -426.417), new Ypr( -1.746, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A2r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1353.437, 19.508, -448.768), new Ypr( -1.746, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1350.982, 19.281, -479.196), new Ypr( -1.746, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1359.574, 19.662, -387.642), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1363.770, 21.453, -415.082), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1356.830, 19.896, -438.762), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1353.359, 19.602, -463.745), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1349.015, 19.260, -487.572), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1348.890, 19.419, -499.927), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1346.398, 18.042, -484.232), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1343.992, 17.778, -474.807), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1348.399, 17.973, -456.144), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1348.754, 17.876, -445.218), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1353.816, 18.386, -435.908), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1352.769, 18.086, -422.173), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1356.387, 18.421, -413.769), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1353.780, 17.966, -394.009), new Ypr( 0.000, 0.000, 0.000) );
//gt.setMatrix( new Vector3( 1343.403, 17.794, -393.993), new Ypr( 0.000, 0.000, 0.000) );
//16/10
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 43.614, 9.760, 1512.378), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 36.950, 8.760, 1509.069), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 33.041, 8.758, 1516.395), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 17.977, 8.759, 1515.591), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 2.235, 9.758, 1520.068), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 27.558, 9.760, 1519.060), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 14.064, 8.759, 1519.652), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -38.253, 11.454, 1546.476), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -53.371, 12.030, 1553.852), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -70.961, 12.402, 1557.898), new Ypr( 0.000, 0.000, 0.050) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -92.706, 12.937, 1556.833), new Ypr( 0.000, 0.000, 0.050) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -117.902, 13.698, 1548.500), new Ypr( 0.000, 0.000, 0.050) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -140.750, 14.403, 1533.438), new Ypr( 0.000, 0.000, 0.050) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -151.221, 14.972, 1521.269), new Ypr( 0.000, 0.000, 0.050) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -154.885, 15.303, 1515.601), new Ypr( 0.000, 0.000, 0.050) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 8.308, 8.758, 1525.526), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -5.610, 8.788, 1524.929), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -17.971, 10.389, 1532.337), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -30.207, 10.294, 1539.748), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -45.273, 10.839, 1550.103), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -59.481, 10.770, 1557.336), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -79.812, 11.800, 1557.726), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -101.732, 13.496, 1553.980), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -125.750, 13.562, 1545.335), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -144.304, 14.466, 1530.345), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -154.408, 13.266, 1520.212), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -161.213, 10.508, 1507.813), new Ypr( 0.785, -0.250, -0.250) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -106.066, 12.573, 1552.778), new Ypr( 0.800, 0.197, 0.311) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -169.729, 10.441, 1508.378), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -134.924, 12.857, 1539.217), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -121.757, 10.901, 1554.686), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -103.169, 11.168, 1560.142), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -86.763, 10.803, 1563.362), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -65.899, 10.590, 1563.366), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -46.031, 10.400, 1557.336), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -27.053, 10.106, 1546.410), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -13.374, 9.789, 1535.917), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -188.598, 10.530, 1480.088), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -174.134, 16.514, 1468.807), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 24.146, 9.672, 1473.787), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 34.988, 9.417, 1468.692), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 4.785, 9.621, 1469.656), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -14.652, 9.865, 1464.741), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -33.177, 11.071, 1456.534), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -53.101, 13.135, 1445.078), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -69.260, 14.993, 1434.364), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -79.324, 15.690, 1425.562), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -85.729, 15.918, 1418.675), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -96.293, 15.751, 1402.945), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 16.455, 9.576, 1470.692), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1.575, 8.612, 1468.250), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -20.293, 9.116, 1461.020), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -37.828, 11.194, 1450.465), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -56.978, 13.103, 1441.617), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -70.873, 13.085, 1430.606), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -80.815, 13.629, 1421.442), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -89.814, 14.929, 1408.846), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -62.751, 12.462, 1437.287), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -47.923, 11.305, 1446.566), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -9.168, 8.624, 1462.600), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -24.563, 9.080, 1456.244), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -132.772, 10.134, 1509.234), new Ypr( 3.136, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -93.110, 9.938, 1509.561), new Ypr( 3.086, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -52.157, 9.805, 1509.127), new Ypr( 3.131, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -14.099, 9.757, 1507.995), new Ypr( 3.095, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -17.696, 8.748, 1509.819), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -32.239, 8.768, 1508.339), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -46.342, 8.789, 1509.711), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -62.028, 8.826, 1509.494), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -78.715, 8.878, 1507.819), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -90.252, 8.923, 1512.015), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -99.639, 8.963, 1510.069), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -111.995, 9.021, 1508.843), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -125.997, 9.093, 1508.492), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -131.565, 10.125, 1513.222), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -25.912, 10.255, 1522.498), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -25.782, 9.758, 1509.400), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -37.567, 9.775, 1512.552), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -51.967, 9.806, 1513.089), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -67.193, 9.841, 1513.113), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -124.043, 10.089, 1515.550), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -75.091, 9.867, 1512.017), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -95.184, 9.944, 1514.060), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -111.344, 10.019, 1513.016), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -12.430, 9.781, 1512.059), new Ypr( 0.000, 0.000, 0.000) );
//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -12.145, 7.770, 1516.388), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -6.973, 7.750, 1522.667), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -21.238, 8.953, 1518.029), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -40.436, 8.786, 1510.236), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -60.003, 8.824, 1515.282), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -84.035, 9.900, 1509.427), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -141.867, 12.882, 1514.046), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -35.413, 10.347, 1532.325), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -51.287, 11.059, 1541.880), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -72.544, 11.829, 1547.880), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -93.891, 12.491, 1546.531), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -113.493, 12.899, 1538.990), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -129.190, 13.432, 1529.803), new Ypr( 0.000, 0.000, 0.000) );
//
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -128.222, 1.000, 1517.431), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -122.934, 1.000, 1521.159), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -115.126, 1.000, 1525.270), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -107.636, 1.000, 1527.852), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -98.771, 1.000, 1529.787), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -90.718, 1.000, 1530.769), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -82.294, 1.000, 1531.669), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -71.833, 1.000, 1531.973), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -63.350, 1.000, 1531.301), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -56.523, 1.000, 1529.846), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -48.091, 1.000, 1527.275), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -41.518, 1.000, 1524.735), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -34.916, 1.000, 1521.727), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -28.229, 1.000, 1518.138), new Ypr( 0.000, 0.000, 0.000) );
//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -114.431, 10.053, 1482.325), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -75.128, 9.838, 1482.397), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -37.052, 9.955, 1481.726), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -17.964, 7.723, 1481.264), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -12.037, 7.716, 1467.264), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -143.362, 10.196, 1482.303), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -129.883, 10.115, 1482.642), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -115.920, 10.034, 1477.995), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -105.747, 8.988, 1481.733), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -95.110, 9.941, 1482.282), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -84.406, 8.898, 1482.672), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -76.527, 9.788, 1478.282), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -67.091, 9.757, 1481.072), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -57.802, 8.751, 1481.863), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -43.260, 9.098, 1481.636), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -30.915, 9.965, 1480.647), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -25.234, 9.061, 1478.558), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -33.944, 10.605, 1474.440), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -45.865, 11.747, 1468.530), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -56.635, 11.806, 1462.480), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -69.720, 14.143, 1454.119), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -81.053, 14.234, 1445.312), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -91.800, 14.657, 1436.089), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -102.998, 15.684, 1424.502), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -111.585, 15.722, 1415.074), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -118.777, 15.857, 1407.026), new Ypr( 0.000, 0.000, 0.000) );
//
gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -154.978, 1.800, 1507.465), new Ypr(-1.653, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -162.858, 2.181, 1482.570), new Ypr( -1.653, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -163.452, 16.223, 1466.335), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -168.105, 16.651, 1454.445), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -173.039, 17.133, 1442.299), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -177.481, 17.472, 1430.832), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -182.695, 17.713, 1415.734), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -188.948, 18.238, 1398.994), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -129.070, 9.160, 1478.620), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -123.773, 9.080, 1481.343), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -109.140, 8.998, 1476.915), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -97.562, 8.947, 1477.066), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -43.545, 9.898, 1475.286), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -50.538, 11.175, 1465.596), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -74.150, 12.912, 1455.699), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -87.192, 14.217, 1444.366), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -96.136, 14.854, 1434.324), new Ypr( 0.000, 0.000, 0.000) );

//

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 45.238, 6.085, 1481.239), new Ypr( 1.800, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 40.089, 6.066, 1481.130), new Ypr( 1.800, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 33.058, 6.051, 1480.637), new Ypr( 1.800, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 25.514, 6.055, 1479.795), new Ypr( 1.800, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 18.443, 6.056, 1478.604), new Ypr( 1.800, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 10.840, 6.053, 1476.927), new Ypr( 1.800, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 3.092, 6.060, 1474.720), new Ypr( 1.800, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -6.212, 6.103, 1471.278), new Ypr( 1.800, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -3.312, 6.104, 1517.704), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 0.955, 6.071, 1514.380), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 7.061, 6.045, 1510.699), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 14.203, 6.049, 1507.899), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 22.813, 6.015, 1505.710), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 30.098, 6.049, 1504.501), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 39.321, 6.049, 1503.711), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1337.447, 7.000, 357.905), new Ypr( -0.012, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 1312.770, 6.800, 360.943), new Ypr( -0.012, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 6.768, 9.719, 1513.419), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 19.022, 9.694, 1508.784), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 33.891, 9.695, 1506.191), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 12.589, 9.714, 1475.247), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 26.159, 9.699, 1478.288), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( 37.276, 8.707, 1479.709), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -154.540, 11.607, 1477.333), new Ypr( 0.000, 0.000, 0.000) );
//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -173.436, 10.388, 1507.939), new Ypr( 3.090, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -213.753, 10.670, 1505.938), new Ypr( 3.086, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -253.554, 10.964, 1503.082), new Ypr( 3.068, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -293.554, 11.164, 1500.082), new Ypr( 3.068, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -334.364, 11.533, 1494.546), new Ypr( 3.013, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -372.819, 11.758, 1489.341), new Ypr( 2.996, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -412.764, 11.937, 1483.068), new Ypr( 2.975, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -453.209, 12.042, 1475.809), new Ypr( 2.951, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -492.353, 12.061, 1467.966), new Ypr( 2.983, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -532.309, 12.077, 1459.609), new Ypr( 2.926, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -574.120, 12.226, 1449.972), new Ypr( 2.903, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -612.507, 12.450, 1440.162), new Ypr( 2.881, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -653.386, 12.716, 1428.790), new Ypr( 2.858, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -693.393, 12.938, 1416.821), new Ypr( 2.854, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -733.665, 13.057, 1404.054), new Ypr( 2.856, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -771.976, 13.048, 1391.071), new Ypr( 2.807, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -812.273, 12.970, 1376.477), new Ypr( 2.816, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -851.021, 12.911, 1361.022), new Ypr( 2.744, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -891.950, 12.846, 1342.902), new Ypr( 2.700, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -932.657, 12.611, 1322.897), new Ypr( 2.737, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -971.013, 12.611, 1306.500), new Ypr( 2.737, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -993.246, 10.493, 1296.573), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000504r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -197.271, 15.716, 1670.821), new Ypr( 3.090, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000582r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -297.067, 15.716, 1670.821), new Ypr( 3.090, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -193.363, 10.539, 1479.915), new Ypr( -0.051, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -234.995, 10.838, 1477.285), new Ypr( -0.023, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -274.910, 11.140, 1473.969), new Ypr( -0.094, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -312.999, 11.392, 1470.066), new Ypr( -0.051, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -352.259, 11.656, 1465.131), new Ypr( -0.134, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -393.362, 11.867, 1459.041), new Ypr( -0.072, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -431.389, 11.987, 1452.516), new Ypr( -0.146, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -468.927, 12.055, 1445.507), new Ypr( -0.200, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -471.393, 9.958, 1445.318), new Ypr( -0.051, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -479.477, 9.958, 1435.914), new Ypr( -0.051, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -509.276, 12.058, 1436.911), new Ypr( -0.186, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -548.348, 12.135, 1428.671), new Ypr( -0.226, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -589.420, 12.343, 1418.611), new Ypr( -0.227, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -629.114, 12.605, 1407.945), new Ypr( -0.273, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -668.241, 12.848, 1396.595), new Ypr( -0.291, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -707.114, 13.017, 1384.544), new Ypr( -0.308, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -746.094, 13.055, 1371.758), new Ypr( -0.323, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -784.814, 12.983, 1358.187), new Ypr( -0.352, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -821.443, 12.852, 1344.271), new Ypr( -0.379, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -862.345, 12.693, 1327.089), new Ypr( -0.421, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -900.405, 12.598, 1309.132), new Ypr( -0.464, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -938.090, 12.531, 1286.179), new Ypr( -0.563, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -974.695, 10.464, 1261.989), new Ypr( 0.000, 0.000, 0.000) );
//
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -464.260, 12.032, 1441.979), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -466.165, 11.050, 1445.749), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -460.639, 11.048, 1447.456), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -195.739, 10.561, 1476.300), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -205.798, 10.619, 1479.720), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -221.427, 9.734, 1478.512), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -231.792, 10.807, 1474.013), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -241.867, 10.886, 1474.716), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -254.867, 10.982, 1473.479), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -267.672, 10.083, 1475.315), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -277.900, 11.159, 1470.415), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -287.231, 11.225, 1471.500), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -297.386, 10.266, 1469.015), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -309.791, 11.339, 1467.443), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -318.281, 10.417, 1468.683), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -328.406, 11.504, 1468.334), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -342.522, 11.594, 1466.578), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -350.931, 10.632, 1462.376), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -361.028, 11.699, 1463.009), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -372.948, 11.768, 1462.121), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -385.569, 10.826, 1459.526), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -398.807, 11.880, 1456.611), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -411.557, 11.934, 1456.015), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -423.738, 10.952, 1453.049), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -434.804, 11.977, 1450.100), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -449.394, 12.030, 1449.554), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -199.091, 9.570, 1477.642), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -208.540, 9.634, 1475.920), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -216.180, 10.686, 1471.869), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -224.127, 9.753, 1475.166), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -235.728, 9.839, 1475.187), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -246.852, 9.925, 1474.365), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -258.524, 11.010, 1470.160), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -281.605, 10.177, 1466.968), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -300.974, 10.241, 1463.650), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -316.234, 11.349, 1463.526), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -332.947, 10.526, 1465.999), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -350.786, 10.613, 1457.965), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -363.326, 10.695, 1458.458), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -377.563, 11.776, 1457.421), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -387.535, 10.810, 1453.880), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -407.425, 10.891, 1451.723), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -423.197, 10.903, 1448.638), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -438.322, 10.989, 1449.803), new Ypr( 0.000, 0.000, 0.000) );

//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -190.364, 3.000, 1470.908), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -195.887, 3.000, 1469.775), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -204.863, 3.000, 1467.940), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -211.168, 3.000, 1466.750), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -218.596, 3.000, 1465.478), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -226.553, 3.000, 1464.364), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -235.889, 3.000, 1463.683), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -243.129, 3.000, 1463.335), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -252.480, 3.000, 1462.604), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -261.081, 3.000, 1462.275), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -268.733, 3.000, 1462.596), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -277.502, 3.000, 1459.432), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -287.440, 3.000, 1456.466), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -299.519, 3.000, 1454.550), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -309.460, 3.000, 1453.573), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -319.157, 3.000, 1452.661), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -329.156, 3.000, 1451.490), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -338.992, 3.000, 1450.272), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -349.484, 3.000, 1448.896), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -359.911, 3.000, 1447.303), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -370.839, 1.000, 1445.808), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -382.073, 1.000, 1444.159), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -392.811, 1.000, 1442.865), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -402.523, 1.000, 1442.260), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -415.036, 1.000, 1441.959), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -423.790, 1.000, 1442.126), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -433.766, 1.000, 1442.396), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -442.563, 1.000, 1442.729), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -450.396, 1.000, 1443.210), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -456.696, 1.000, 1443.800), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -453.886, 1.000, 1441.187), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -446.583, 1.000, 1441.175), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -438.217, 1.000, 1440.791), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -428.164, 1.000, 1441.489), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -419.168, 1.000, 1440.445), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -408.653, 1.000, 1440.993), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -397.733, 1.000, 1440.704), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -387.442, 1.000, 1441.979), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -376.001, 1.000, 1443.734), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -402.198, 11.161, 1400.922), new Ypr( -2.568, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A4r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -407.491, 9.785, 1348.011), new Ypr( 2.943, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -387.414, 9.108, 1354.786), new Ypr( 2.928, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A1r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -371.658, 9.560, 1356.298), new Ypr( 2.906, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A2r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -435.467, 10.000, 1341.789), new Ypr( 2.906, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A7r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -454.674, 11.585, 1339.000), new Ypr( 2.906, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -360.618, 8.904, 1358.163), new Ypr( 2.906, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -379.829, 9.030, 1354.667), new Ypr( 2.906, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -394.361, 9.196, 1350.822), new Ypr( 2.906, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -420.262, 9.662, 1350.673), new Ypr( 2.906, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -425.706, 10.733, 1346.074), new Ypr( 2.906, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -474.305, 10.139, 1331.887), new Ypr( 2.906, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -473.802, 11.355, 1342.605), new Ypr( 2.906, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A8r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -483.642, 10.000, 1327.884), new Ypr( 2.860, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000001A9r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -506.006, 10.700, 1322.276), new Ypr( 2.841, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -495.037, 11.165, 1326.121), new Ypr( 2.841, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -514.940, 10.298, 1319.275), new Ypr( 2.841, 0.000, 0.000) );
//
gt.create_native( map, new GameRef(objects:0x0000001Ar), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -541.897, 10.400, 1312.434), new Ypr( 2.848, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x0000001Cr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -563.774, 10.900, 1305.103), new Ypr( 2.832, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x0000001Fr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -592.569, 11.500, 1295.100), new Ypr( 2.811, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000022r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -616.959, 11.000, 1286.247), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -602.738, 12.232, 1289.982), new Ypr( 2.813, 0.000, 0.000) ); 
// trees on the other side of the houses
gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -573.891, 11.162, 1268.544), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -562.367, 11.111, 1271.851), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -550.018, 10.995, 1276.220), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -537.095, 10.806, 1280.865), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -523.147, 10.564, 1285.521), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -511.118, 10.365, 1289.090), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -497.076, 10.172, 1293.560), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -484.694, 10.087, 1297.158), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -477.564, 10.065, 1299.613), new Ypr( 2.813, 0.000, 0.000) ); 

//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -173.933, 10.387, 1514.651), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -185.591, 10.467, 1508.669), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -199.304, 10.563, 1506.664), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -212.838, 10.659, 1511.095), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -229.736, 10.784, 1505.512), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -243.221, 10.883, 1504.915), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -257.783, 10.990, 1506.510), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -272.604, 11.101, 1502.471), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -285.698, 11.196, 1502.426), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -302.995, 11.318, 1501.088), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -317.923, 11.422, 1497.475), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -332.484, 11.515, 1499.663), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -347.134, 11.606, 1493.498), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -363.356, 11.703, 1493.322), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -379.124, 11.787, 1489.733), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -392.467, 11.851, 1487.268), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -407.502, 11.911, 1489.231), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -421.981, 11.965, 1481.574), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -436.580, 12.006, 1478.742), new Ypr( 2.813, 0.000, 0.000) ); 
 
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -453.981, 12.039, 1479.349), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -465.142, 12.053, 1475.249), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -496.969, 12.058, 1470.473), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -512.603, 12.058, 1463.900), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -527.682, 12.069, 1463.676), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -542.458, 12.098, 1458.645), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -556.774, 12.145, 1454.618), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -572.094, 12.209, 1455.285), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -585.405, 12.283, 1447.539), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -600.355, 12.369, 1444.008), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -614.543, 12.455, 1443.129), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -627.955, 12.548, 1435.697), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -640.237, 12.628, 1433.455), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -657.041, 12.734, 1428.340), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -669.941, 12.814, 1423.945), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -685.657, 12.896, 1420.895), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -702.893, 12.975, 1414.403), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -719.712, 13.031, 1408.789), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -733.935, 13.058, 1408.732), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -748.423, 13.062, 1399.210), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -759.231, 13.071, 1396.022), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -778.240, 13.069, 1393.744), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -789.391, 13.034, 1385.705), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -802.741, 13.011, 1381.999), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -819.783, 12.977, 1375.094), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -833.173, 12.885, 1368.199), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -843.866, 13.002, 1366.321), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -858.276, 12.884, 1358.047), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -879.447, 12.858, 1348.465), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -893.965, 13.330, 1346.874), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -904.695, 12.785, 1336.834), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -923.263, 12.742, 1327.637), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -935.656, 12.687, 1327.613), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -946.313, 12.609, 1317.085), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -962.226, 12.606, 1310.128), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -976.236, 12.668, 1310.506), new Ypr( 2.813, 0.000, 0.000) );  

// skyscrapers south green
gt.create_native( map, new GameRef(objects:0x00000589r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -472.144, 15.615, 1597.872), new Ypr( 3.000, 0.000, 0.000) );  
gt.create_native( map, new GameRef(objects:0x00000588r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -572.144, 15.615, 1560.872), new Ypr( 3.000, 0.000, 0.000) );  
gt.create_native( map, new GameRef(objects:0x0000058Ar), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -672.144, 7.615, 1560.872), new Ypr( 2.600, 0.000, 0.000) );  
gt.create_native( map, new GameRef(objects:0x0000058Dr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -772.144, 15.615, 1507.872), new Ypr( 3.000, 0.000, 0.000) );  
gt.create_native( map, new GameRef(objects:0x00000586r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -872.144, 15.615, 1507.872), new Ypr( 3.000, 0.000, 0.000) );
gt.create_native( map, new GameRef(objects:0x00000692r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -972.144, 15.615, 1507.872), new Ypr( 3.000, 0.000, 0.000) ); 
gt.create_native( map, new GameRef(objects:0x00000692r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -672.144, 15.615, 1630.872), new Ypr( 2.600, 0.000, 0.000) );     
gt.create_native( map, new GameRef(objects:0x00000589r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -810.144, 25.615, 1567.872), new Ypr( 3.000, 0.000, 0.000) );  
gt.create_native( map, new GameRef(objects:0x00000588r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -672.144, 35.615, 1700.872), new Ypr( 2.600, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -503.974, 11.058, 1436.908), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -516.747, 11.046, 1435.754), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -530.924, 11.078, 1432.685), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -543.117, 11.113, 1429.564), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -557.053, 11.168, 1426.731), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -572.486, 11.244, 1423.774), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -584.154, 11.306, 1420.001), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -598.033, 11.294, 1416.963), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -610.642, 11.447, 1413.884), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -622.746, 11.559, 1410.282), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -635.453, 11.645, 1405.689), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -649.591, 11.735, 1402.269), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -662.159, 11.813, 1398.795), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -674.803, 11.877, 1395.233), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -688.422, 11.945, 1390.738), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -700.966, 11.994, 1387.025), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -712.607, 12.029, 1382.492), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -729.606, 12.055, 1377.003), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -741.003, 12.056, 1373.669), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -751.164, 12.054, 1369.364), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -765.975, 12.029, 1364.911), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -779.677, 11.899, 1360.097), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -789.945, 11.969, 1355.267), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -805.902, 11.909, 1350.349), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -818.797, 11.860, 1343.027), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -829.512, 11.816, 1341.030), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -845.514, 11.752, 1335.280), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -858.114, 11.703, 1327.041), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -867.827, 11.672, 1324.662), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -879.191, 11.643, 1320.116), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -894.221, 11.607, 1312.967), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -904.185, 11.592, 1306.247), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -919.228, 11.551, 1299.471), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -932.664, 11.554, 1290.958), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -942.968, 11.526, 1282.760), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -957.329, 11.546, 1274.092), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -967.682, 11.544, 1267.016), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -973.262, 11.546, 1259.512), new Ypr( 2.813, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -524.312, 11.427, 1315.934), new Ypr( 2.813, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000518r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -732.503, 35.936, 1450.840), new Ypr( -0.458, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x00000060r), "0,0,0,0,0,0", "test_object" ); // construction south
gt.setMatrix( new Vector3( -824.751, 30.947, 1271.984), new Ypr( -0.400, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -923.483, 8.803, 1299.877), new Ypr( 1.073, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -933.638, 8.787, 1294.419), new Ypr( 1.078, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -943.621, 8.779, 1289.081), new Ypr( 1.066, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -954.403, 8.774, 1282.638), new Ypr( 0.980, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -964.837, 8.775, 1275.227), new Ypr( 0.899, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -972.591, 8.805, 1267.331), new Ypr( 0.722, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -990.093, 8.791, 1294.844), new Ypr( -1.774, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -985.009, 8.784, 1295.908), new Ypr( -1.782, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -977.628, 8.779, 1298.081), new Ypr( -1.879, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -968.932, 8.771, 1301.168), new Ypr( -1.943, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -960.259, 8.773, 1305.276), new Ypr( -1.998, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -947.778, 8.772, 1311.373), new Ypr( -2.061, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -935.997, 8.794, 1317.961), new Ypr( -2.090, 0.000, 0.000) ); 
//
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -484.003, 11.056, 1436.370), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -494.882, 12.056, 1436.207), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -507.553, 12.049, 1432.733), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -521.051, 12.050, 1431.036), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -534.593, 12.082, 1429.145), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -547.025, 12.118, 1424.710), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -560.782, 12.179, 1422.486), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -574.402, 12.248, 1418.126), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -587.023, 12.322, 1415.447), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -607.099, 12.461, 1408.153), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -622.835, 12.563, 1405.876), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -640.269, 12.678, 1400.033), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -654.998, 12.771, 1400.542), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -674.666, 12.866, 1389.561), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -690.195, 12.950, 1386.036), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -703.457, 12.995, 1380.350), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -718.362, 13.039, 1378.314), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -726.446, 13.047, 1370.307), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -745.855, 13.054, 1365.182), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -759.161, 13.075, 1366.580), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -769.232, 13.022, 1361.861), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -779.516, 12.994, 1353.879), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -795.364, 12.949, 1350.603), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -810.542, 12.889, 1345.621), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -820.789, 12.841, 1337.333), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -835.008, 12.821, 1335.747), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -847.532, 12.740, 1330.747), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -858.951, 12.698, 1321.506), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -878.092, 12.665, 1309.813), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -891.203, 12.615, 1308.555), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -908.789, 12.588, 1302.533), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -923.341, 12.462, 1293.219), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -937.947, 12.424, 1281.663), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -960.903, 12.516, 1270.472), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -967.340, 12.422, 1260.557), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -977.633, 12.577, 1254.876), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -986.175, 11.649, 1307.545), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -967.036, 11.689, 1314.491), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -953.219, 11.697, 1320.927), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -928.890, 12.032, 1332.741), new Ypr( -1.938, 0.049, 0.103) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -917.223, 12.541, 1339.812), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -893.460, 12.921, 1352.942), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -876.661, 12.702, 1360.794), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -865.913, 12.619, 1366.073), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -846.015, 12.412, 1374.440), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -830.052, 12.163, 1380.431), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -808.284, 12.132, 1388.652), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -782.208, 12.121, 1398.953), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -762.422, 12.120, 1405.742), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -738.052, 12.065, 1415.163), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -722.179, 12.030, 13418.149), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -709.071, 11.986, 1422.248), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -685.817, 11.882, 1428.540), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -672.403, 11.811, 1432.581), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -651.723, 11.686, 1438.656), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -625.219, 11.512, 1446.038), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -607.631, 11.398, 1451.483), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -587.009, 11.275, 1457.801), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -558.525, 11.142, 1464.876), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -529.944, 11.070, 1469.879), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -501.139, 11.056, 1476.379), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -474.925, 11.054, 1482.128), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -449.878, 11.028, 1485.530), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -429.700, 10.981, 1488.928), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -412.462, 10.925, 1492.703), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -393.277, 10.844, 1495.123), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -371.423, 10.737, 1498.760), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -356.118, 10.653, 1501.247), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -336.219, 10.531, 1504.393), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -316.232, 10.399, 1506.859), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -286.883, 10.196, 1508.771), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -265.206, 10.038, 1511.508), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -241.310, 9.862, 1514.032), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -218.102, 9.692, 1516.950), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -194.659, 9.525, 1517.324), new Ypr( 2.813, 0.000, 0.000) );
//
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1320.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1330.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1340.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1350.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1360.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1370.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1380.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1390.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1400.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1410.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1420.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1430.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1440.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1450.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1460.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1470.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1480.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1490.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1500.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1510.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1520.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1530.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1540.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1550.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1560.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1570.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1580.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1590.000), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -730.550, 26.525, 1600.000), new Ypr( 2.813, 0.000, 0.000) );
//
gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -723.000, 14.525, 1410.000), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -740.000, 14.525, 1410.000), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -726.000, 14.525, 1370.000), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -739.000, 14.525, 1370.000), new Ypr( 0.000, 0.000, 0.000) );
//

gt.create_native( map, new GameRef(objects:0x0000058Dr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -768.617, 27.615, 1287.973), new Ypr( 2.700, 0.000, 0.000) );  

gt.create_native( map, new GameRef(objects:0x00000589r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -682.184, 15.615, 1325.105), new Ypr( 2.700, 0.000, 0.000) );  
//
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -983.623, 36.980, 1475.883), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -972.540, 36.713, 1474.906), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -960.783, 35.118, 1473.758), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -951.476, 32.347, 1475.733), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -939.371, 30.089, 1476.486), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -994.032, 35.046, 1475.974), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1002.250, 34.648, 1483.992), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1010.974, 33.952, 1491.597), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1021.846, 32.844, 1500.153), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -999.220, 33.169, 1471.999), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -972.694, 32.550, 1459.676), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -958.997, 31.251, 1454.043), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -932.389, 27.500, 1468.914), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -972.463, 26.962, 1445.846), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -955.480, 27.629, 1442.198), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -940.376, 29.435, 1447.916), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -481.509, 8.306, 1438.799), new Ypr( 1.615, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -487.539, 8.260, 1441.076), new Ypr( 1.937, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -493.482, 8.258, 1441.369), new Ypr( 1.448, 0.000, 0.000) ); 

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -500.518, 8.271, 1440.948), new Ypr( 1.615, 0.000, 0.000) ); 
//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -991.317, 12.621, 1301.424), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1002.304, 11.554, 1296.117), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1019.922, 11.280, 1294.623), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1039.543, 11.990, 1293.095), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1057.314, 11.037, 1291.853), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1079.509, 11.840, 1287.762), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1100.738, 13.218, 1274.839), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1116.889, 15.617, 1254.142), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1121.037, 16.789, 1225.185), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1118.629, 18.522, 1214.338), new Ypr( 2.813, 0.000, 0.000) );
//
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -997.343, 12.619, 1300.855), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1008.689, 12.503, 1295.958), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1027.429, 12.403, 1298.058), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1045.824, 12.168, 1295.837), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1063.979, 12.207, 1291.073), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1086.664, 13.239, 1285.269), new Ypr( 2.813, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1106.791, 14.700, 1268.631), new Ypr( 0.431, 0.128, 0.104) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1119.593, 16.205, 1246.163), new Ypr( -0.124, 0.220, 0.236) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1121.401, 17.205, 1233.697), new Ypr( 0.092, 0.078, 0.049) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1117.886, 17.806, 1209.923), new Ypr( -0.665, -0.098, 0.425) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1124.291, 11.946, 1197.221), new Ypr( 2.451, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1157.597, 11.804, 1168.267), new Ypr( 2.451, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1189.356, 11.430, 1138.863), new Ypr( 2.402, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1220.257, 10.843, 1108.147), new Ypr( 2.329, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1250.512, 10.252, 1075.148), new Ypr( 2.282, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1282.136, 9.909, 1036.606), new Ypr( 2.197, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1124.533, 11.775, 1161.254), new Ypr( -0.717, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1156.373, 11.519, 1132.684), new Ypr( -0.754, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1185.813, 11.118, 1104.505), new Ypr( -0.785, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1216.712, 10.519, 1072.319), new Ypr( -0.831, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1245.679, 9.963, 1038.890), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -986.997, 11.620, 1247.823), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -997.128, 11.601, 1234.827), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1008.684, 11.319, 1219.199), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1022.468, 11.077, 1199.974), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1034.006, 9.237, 1183.201), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1040.294, 10.297, 1168.301), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1044.798, 9.768, 1150.673), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1046.325, 10.192, 1132.850), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1001.773, 12.521, 1227.141), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1012.989, 11.019, 1213.482), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1026.232, 10.613, 1191.578), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1034.412, 9.216, 1174.903), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1039.934, 9.426, 1161.968), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1044.078, 9.929, 1144.632), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1121.232, 16.750, 1220.670), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1112.213, 14.076, 1261.673), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1109.280, 13.151, 1271.799), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1097.079, 12.829, 1278.623), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1075.736, 11.622, 1292.201), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1059.799, 11.261, 1296.390), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1040.341, 11.270, 1297.397), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1015.631, 11.510, 1299.161), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1065.762, 11.572, 1128.081), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1073.330, 12.229, 1141.913), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1081.211, 15.272, 1152.396), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1089.335, 15.473, 1163.192), new Ypr( -0.880, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1095.950, 18.043, 1173.473), new Ypr( 2.728, 0.218, -0.220) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1078.357, 12.309, 1143.978), new Ypr( 2.728, 0.000, -0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1085.905, 13.767, 1154.456), new Ypr( 2.728, 0.000, -0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1094.220, 15.325, 1166.958), new Ypr( 2.728, 0.000, -0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1100.459, 14.519, 1173.671), new Ypr( 2.837, -0.009, -0.300) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1127.740, 12.062, 1200.875), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1135.667, 11.960, 1191.423), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1146.537, 11.913, 1178.786), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1159.218, 12.172, 1174.788), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1168.039, 11.785, 1161.331), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1177.364, 11.706, 1153.840), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1189.020, 11.749, 1148.378), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1196.296, 11.308, 1133.272), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1204.330, 11.144, 1123.406), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1216.458, 11.004, 1116.456), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1225.581, 10.728, 1101.570), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1235.809, 10.521, 1090.462), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1246.838, 10.386, 1083.708), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1258.103, 10.236, 1072.754), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1264.790, 10.036, 1058.283), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1276.281, 9.992, 1046.568), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1358.768, 8.025, 927.017), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1358.748, 9.031, 933.862), new Ypr( -3.105, 0.021, -0.124) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1358.460, 9.028, 942.562), new Ypr( -3.109, -0.005, -0.019) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1357.641, 8.890, 955.897), new Ypr( -3.054, 0.001, -0.021) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1356.430, 10.103, 969.781), new Ypr( -3.-49, 0.033, -0.028) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1354.817, 9.644, 983.046), new Ypr( -2.873, 0.076, -0.071) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1348.534, 10.973, 999.498), new Ypr( -2.664, 0.102, -0.094) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1337.637, 13.541, 1013.017), new Ypr( -2.340, 0.128, -0.187) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1325.055, 14.038, 1021.896), new Ypr( -2.097, 0.114, -0.224) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1314.024, 14.884, 1026.427), new Ypr( -1.815, 0.065, -0.333) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1302.962, 15.329, 1028.134), new Ypr( -1.698, 0.033, -0.456) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1293.528, 14.999, 1029.548), new Ypr( -1.445, -0.145, -0.400) );
//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -998.394, 10.467, 1287.049), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1008.204, 11.444, 1285.696), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1019.100, 11.167, 1283.883), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1031.915, 10.851, 1284.249), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1043.227, 10.820, 1283.431), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1057.284, 10.053, 1282.673), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1072.457, 11.655, 1280.678), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1085.700, 12.495, 1273.874), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1094.233, 13.200, 1266.981), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1105.204, 14.292, 1253.062), new Ypr( 0.722, 0.171, -0.100) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1110.639, 15.203, 1241.390), new Ypr( 0.434, 0.194, -0.150) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1112.174, 16.041, 1229.613), new Ypr( 0.084, 0.149, -0.180) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1110.334, 16.987, 1218.416), new Ypr( -0.107, 0.168, -0.100) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1096.602, 11.070, 1219.821), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1090.978, 11.104, 1222.981), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1080.012, 11.182, 1231.603), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1069.291, 11.258, 1240.021), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1055.060, 11.342, 1251.512), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1039.713, 11.429, 1261.483), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1023.134, 11.407, 1272.411), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1009.372, 11.515, 1281.829), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1097.399, 12.068, 1219.164), new Ypr( 2.457, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1055.895, 12.334, 1250.953), new Ypr( 2.552, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1010.908, 12.500, 1280.582), new Ypr( 2.571, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1001.355, 11.552, 1285.994), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1020.084, 12.170, 1278.052), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1030.537, 12.191, 1272.952), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1046.041, 12.338, 1263.020), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1063.265, 12.245, 1253.682), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1076.778, 12.238, 1244.234), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1090.060, 12.142, 1232.763), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1101.730, 12.094, 1233.380), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1096.080, 12.167, 1247.617), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1081.387, 12.282, 1260.841), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1068.574, 12.387, 1274.732), new Ypr( 0.000, 0.000, 0.000) );
//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1017.767, 0.387, 1281.699), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1025.981, 0.387, 1281.054), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1033.680, 0.387, 1279.312), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1040.870, 0.387, 1276.477), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1048.344, 0.387, 1272.572), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1056.077, 0.387, 1268.224), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1064.252, 0.387, 1263.389), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1072.078, 0.487, 1258.457), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1078.570, 0.587, 1253.822), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1085.759, 0.687, 1247.873), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1092.321, 0.787, 1241.048), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1097.535, 0.887, 1232.838), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -984.291, 10.483, 1265.202), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1063.021, 12.070, 1211.737), new Ypr( -0.662, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1019.986, 12.500, 1242.846), new Ypr( -0.580, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1055.345, 11.338, 1130.383), new Ypr( -0.580, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1058.892, 10.776, 1135.623), new Ypr( 2.534, 0.149, 0.100) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1066.466, 12.557, 1149.799), new Ypr( 2.011, 0.291, 0.150) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1072.086, 15.000, 1162.903), new Ypr( 2.178, 0.359, 0.350) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1086.590, 17.067, 1177.283), new Ypr( 2.322, 0.188, 0.350) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1085.172, 11.172, 1195.215), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1079.681, 11.014, 1199.746), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1068.384, 11.991, 1206.426), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1057.541, 11.082, 1214.840), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1047.770, 11.158, 1222.104), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1031.571, 11.383, 1235.679), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1015.802, 11.502, 1242.064), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1010.355, 11.531, 1248.348), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -998.197, 11.566, 1257.459), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -989.219, 11.580, 1262.556), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -994.980, 11.609, 1252.514), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1000.910, 12.620, 1244.255), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1012.810, 11.438, 1229.111), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1026.331, 10.620, 1212.613), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1037.146, 10.786, 1199.658), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1045.026, 9.202, 1180.311), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1052.250, 9.527, 1163.312), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1055.743, 10.218, 1148.608), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1071.425, 10.415, 1190.763), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1062.644, 10.572, 1200.891), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1053.921, 10.807, 1210.972), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1041.879, 11.095, 1222.016), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1030.172, 11.312, 1231.129), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1018.534, 11.457, 1235.522), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1020.243, 11.271, 1226.098), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1031.479, 10.730, 1215.037), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1042.441, 9.861, 1199.338), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1050.951, 9.403, 1181.601), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1056.990, 9.618, 1168.841), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1064.540, 12.372, 1163.255), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1073.500, 13.258, 1172.021), new Ypr( 0.000, 0.000, 0.000) );
//
gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1067.534, 0.500, 1181.167), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1065.095, 0.100, 1184.930), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1060.537, 0.100, 1191.985), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1056.150, 0.100, 1198.528), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1051.385, 0.100, 1204.700), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1045.752, 0.100, 1210.563), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1040.164, 0.200, 1216.033), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1033.547, 0.350, 1221.841), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1025.023, 0.600, 1228.042), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1017.758, 0.800, 1233.074), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1012.721, 1.000, 1238.940), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1007.547, 1.000, 1245.566), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1000.427, 1.000, 1251.128), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -994.977, 1.000, 1256.321), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1043.114, 10.512, 1192.133), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1050.842, 9.365, 1172.477), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1022.433, 11.022, 1219.275), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1098.013, 4.400, 1184.170), new Ypr( 0.856, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001DAr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1110.571, 4.400, 1208.392), new Ypr( 0.856, 0.000, 0.000) );
//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1371.038, 51.844, 1318.369), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1360.963, 51.663, 1327.397), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1346.779, 52.380, 1338.862), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1330.010, 52.544, 1353.170), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1276.526, 52.985, 1400.193), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1266.425, 53.631, 1407.959), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1246.678, 52.061, 1395.767), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1226.638, 49.847, 1376.337), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1215.731, 49.150, 1386.469), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1203.654, 49.619, 1393.671), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1192.002, 47.601, 1400.173), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1458.809, 52.300, 1224.172), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1473.052, 61.463, 1207.589), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1479.813, 67.304, 1191.257), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1488.622, 70.362, 1182.015), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1499.183, 69.809, 1167.302), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1511.439, 67.280, 1152.037), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1531.312, 57.180, 1121.640), new Ypr( 0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1542.722, 54.890, 1110.616), new Ypr( 0.000, 0.000, 0.000) );
//
gt.create_native( map, new GameRef(objects:0x00000582r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1371.376, 60.032, 1426.374), new Ypr( -1.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000505r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1430.542, 80.555, 1343.651), new Ypr( 2.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000586r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3( -1496.628, 65.837, 1260.718), new Ypr( -1.000, 0.000, 0.000) );
//

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1384.078, 10.252, 868.454), new Ypr(2.110, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1404.129, 10.272, 826.713), new Ypr(2.023, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1416.709, 10.098, 789.393), new Ypr(1.847, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1426.091, 9.723, 746.475), new Ypr(1.746, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1430.807, 9.294, 703.485), new Ypr(1.640, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1431.390, 8.915, 661.883), new Ypr(1.588, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1428.469, 8.674, 618.450), new Ypr(1.526, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1424.811, 8.366, 576.406), new Ypr(1.497, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1420.647, 7.928, 531.780), new Ypr(1.452, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1416.280, 7.446, 488.095), new Ypr(1.454, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1411.808, 7.086, 445.990), new Ypr(1.500, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1406.820, 6.761, 402.181), new Ypr(1.439, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1401.656, 6.512, 359.255), new Ypr(1.441, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1395.564, 6.312, 311.681), new Ypr(1.434, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1389.452, 6.236, 266.608), new Ypr(1.387, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1382.763, 6.288, 223.964), new Ypr(1.364, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1374.817, 6.433, 185.043), new Ypr(1.330, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1364.704, 6.679, 143.876), new Ypr(1.339, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1351.797, 7.015, 101.377), new Ypr(1.274, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1337.324, 7.399, 60.737), new Ypr(1.205, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1321.003, 7.820, 20.798), new Ypr(1.203, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1301.861, 8.285, -20.052), new Ypr(1.134, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1279.469, 8.766, -62.450), new Ypr(1.044, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1256.647, 9.196, -101.206), new Ypr(1.027, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1229.212, 9.618, -143.061), new Ypr(0.986, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1202.212, 9.927, -179.960), new Ypr(0.973, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1173.159, 10.143, -216.064), new Ypr(0.871, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1138.019, 10.237, -255.428), new Ypr(0.814, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1370.150, 10.194, 835.026), new Ypr(-1.099, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1385.416, 9.991, 798.100), new Ypr(-1.240, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1395.213, 9.702, 762.966), new Ypr(-1.385, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1401.863, 9.324, 723.373), new Ypr(-1.498, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1404.469, 8.930, 682.523), new Ypr(-1.565, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1403.138, 8.596, 641.421), new Ypr(-1.667, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1399.560, 8.310, 598.704), new Ypr(-1.658, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1395.709, 7.976, 555.976), new Ypr(-1.708, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1391.452, 7.611, 512.077), new Ypr(-1.681, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1387.105, 7.260, 469.898), new Ypr(-1.708, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1382.449, 6.931, 427.619), new Ypr(-1.694, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1377.097, 6.623, 382.035), new Ypr(-1.691, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1371.496, 6.391, 337.061), new Ypr(-1.758, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1365.773, 5.944, 293.477), new Ypr(-1.728, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1359.375, 5.879, 249.188), new Ypr(-1.772, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1351.635, 5.962, 207.066), new Ypr(-1.840, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1342.729, 6.224, 167.703), new Ypr(-1.870, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1331.020, 6.499, 126.451), new Ypr(-1.920, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1318.094, 6.865, 87.744), new Ypr(-1.921, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1302.909, 7.152, 48.874), new Ypr(-1.979, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1244.883, 8.596, -67.375), new Ypr(-2.040, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1221.260, 9.070, -105.773), new Ypr(-2.146, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1193.067, 9.557, -146.844), new Ypr(-2.225, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1166.446, 10.042, -181.539), new Ypr(-2.250, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1133.999, 10.212, -219.728), new Ypr(-2.303, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1395.346, 10.308, 856.469), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1405.161, 10.470, 841.509), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1410.301, 10.662, 829.311), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1416.930, 10.846, 813.778), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1423.167, 10.966, 793.797), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1423.327, 10.368, 776.039), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1430.948, 10.738, 761.188), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1434.304, 10.632, 747.280), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1436.853, 10.521, 732.572), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1431.478, 9.662, 719.417), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1438.582, 10.000, 703.391), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1437.166, 9.462, 677.433), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1438.091, 9.437, 663.991), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1433.067, 8.987, 649.620), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1435.005, 9.242, 634.063), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1435.221, 9.350, 621.944), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1429.429, 8.792, 605.641), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1432.960, 9.168, 591.878), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1425.001, 8.394, 566.459), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1428.792, 8.501, 551.042), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1427.995, 8.418, 537.485), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1422.201, 7.864, 523.591), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1424.270, 7.807, 509.110), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1422.000, 7.579, 490.711), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1417.612, 7.369, 478.818), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1420.639, 7.262, 463.571), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1418.620, 7.118, 449.774), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1416.642, 6.980, 433.001), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1412.782, 6.777, 406.950), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1406.244, 6.691, 391.992), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1408.919, 6.619, 376.541), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1407.795, 6.531, 360.905), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1402.488, 6.402, 333.818), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1402.841, 6.334, 315.917), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1397.244, 6.289, 302.324), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1397.129, 6.255, 284.555), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1393.048, 6.238, 272.064), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1394.336, 6.241, 255.930), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1391.664, 6.249, 242.202), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1388.516, 6.278, 227.360), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1389.286, 6.318, 212.361), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1383.386, 6.359, 200.544), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1381.501, 6.422, 186.294), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1374.893, 6.492, 172.911), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1371.244, 5.559, 161.666), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1370.000, 5.664, 145.078), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1363.385, 5.753, 133.097), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1356.017, 5.907, 113.943), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1356.483, 6.000, 101.782), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1351.288, 6.089, 92.414), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1343.830, 6.233, 77.473), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1342.657, 6.367, 62.360), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1336.590, 6.462, 54.009), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1327.329, 6.670, 34.430), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1326.229, 6.776, 23.465), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1319.251, 6.906, 12.242), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1309.772, 7.110, -5.384), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1306.248, 7.256, -19.610), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1298.601, 7.371, -28.377), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1287.804, 7.593, -47.469), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1284.389, 7.736, -61.895), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1274.398, 7.868, -71.560), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1264.144, 8.064, -89.332), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1260.303, 8.192, -103.040), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1249.892, 8.316, -113.067), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1235.999, 8.519, -132.782), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1232.198, 8.633, -147.707), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1222.282, 8.723, -155.806), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1211.437, 8.834, -168.235), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1206.086, 8.919, -181.263), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1196.315, 8.990, -190.213), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1184.447, 9.072, -202.836), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1177.732, 9.131, -216.497), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1169.714, 9.162, -222.052), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1155.830, 9.210, -236.139), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1145.644, 9.230, -247.134), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1135.960, 9.236, -261.118), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1375.488, 6.579, 156.996), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1364.143, 6.808, 125.168), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1357.967, 7.039, 96.147), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1342.914, 7.295, 70.659), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1337.022, 7.542, 44.841), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1327.232, 7.832, 16.675), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1316.981, 7.994, 3.767), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1312.239, 8.158, -11.908), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1297.463, 8.452, -36.657), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1290.748, 8.632, -53.227), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1275.996, 8.913, -77.887), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1260.189, 9.222, -106.917), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1243.923, 9.404, -120.949), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1239.975, 9.547, -139.769), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1219.666, 9.767, -161.651), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1213.042, 9.851, -173.103), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1194.629, 10.020, -196.290), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1184.525, 10.096, -209.871), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1167.724, 10.178, -227.047), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1152.892, 10.222, -245.006), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1131.212, 10.235, -267.817), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1365.516, 8.892, 928.361), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1370.837, 9.247, 909.246), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1376.468, 10.242, 888.670), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1388.614, 9.291, 877.103), new Ypr(0.000, 0.000, 0.000) );
//


gt.create_native( map, new GameRef(objects:0x000001A2r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1122.743, 9.500, -281.142), new Ypr(1.017, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1111.370, 9.300, -298.051), new Ypr(0.870, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A4r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1097.497, 9.850, -310.971), new Ypr(0.870, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A5r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1081.567, 9.700, -328.393), new Ypr(0.801, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A8r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1018.534, 10.299, -381.055), new Ypr(0.762, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A7r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1049.024, 11.300, -358.153), new Ypr(0.730, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1118.367, 10.237, -290.220), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1125.745, 9.236, -274.208), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1104.678, 9.281, -301.0097), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1088.098, 9.407, -318.571), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1071.890, 9.628, -335.681), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1063.766, 10.723, -343.035), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1034.478, 11.064, -370.855), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1027.498, 10.035, -374.232), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1010.663, 10.058, -388.349), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A0r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1000.311, 10.400, -397.555), new Ypr(0.664, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A1r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-970.316, 10.400, -418.813), new Ypr(0.623, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x000001A2r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-938.098, 10.600, -440.600), new Ypr(0.513, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x0000001Cr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-904.919, 10.400, -458.262), new Ypr(0.493, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x0000001Fr), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-876.403, 11.300, -472.150), new Ypr(0.439, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-988.615, 11.057, -405.262), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-979.672, 10.068, -410.940), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-962.200, 10.151, -422.977), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-949.744, 11.253, -431.960), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-930.112, 10.453, -444.392), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-920.452, 10.548, -449.749), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-890.700, 11.800, -465.122), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-866.247, 10.879, -476.082), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-925.135, 11.539, -455.288), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-954.712, 11.248, -438.516), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-980.873, 11.080, -420.848), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1029.809, 11.046, -382.786), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1070.990, 10.707, -347.528), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1146.389, 10.233, -257.908), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1081.572, 9.594, -340.017), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1047.061, 9.965, -373.678), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1002.289, 10.058, -406.871), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-974.361, 10.109, -426.639), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-941.368, 10.383, -448.256), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1129.013, 9.223, -225.386), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1131.474, 9.203, -216.415), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1139.797, 9.189, -211.470), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1151.023, 9.146, -201.003), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1159.572, 9.096, -190.910), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1162.640, 9.043, -181.798), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1170.334, 8.995, -174.004), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1179.520, 8.642, -164.293), new Ypr(2.590, -0.029, 0.124) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1185.964, 8.464, -154.352), new Ypr(2.391, -0.005, 0.124) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1192.096, 8.160, -143.037), new Ypr(2.566, -0.023, 0.126) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1201.394, 8.326, -133.769), new Ypr(2.273, 0.013, 0.122) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1211.362, 8.115, -119.683), new Ypr(2.663, -0.049, 0.151) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1216.493, 7.568, -107.357), new Ypr(2.792, -0.057, 0.160) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1224.008, 7.650, -97.943), new Ypr(2.108, 0.053, 0.153) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1233.983, 7.801, -85.536), new Ypr(2.735, -0.043, 0.163) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1238.274, 7.484, -75.902), new Ypr(2.739, -0.042, 0.161) );
// riverbed trees

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1239.313, 6.898, -67.860), new Ypr(-1.425, -0.127, -0.109) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1232.808, 6.257, -70.370), new Ypr(-1.078, -0.084, -0.145) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1220.110, 4.623, -70.952), new Ypr(-1.884, -0.164, -0.043) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1209.297, 3.016, -69.072), new Ypr(-1.579, -0.145, -0.090) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1192.212, 1.227, -69.389), new Ypr(-1.495, -0.135, -0.102) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1180.892, -0.623, -67.934), new Ypr(-1.886, 0.010, -0.079) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1368.629, 5.062, 317.014), new Ypr(-0.744, -0.081, -0.001) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1363.139, 4.534, 311.519), new Ypr(-0.791, -0.076, 0.010) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1354.160, 3.444, 298.124), new Ypr(-0.414, -0.075, -0.017) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1346.778, 1.799, 280.562), new Ypr(-0.448, -0.075, -0.024) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1334.698, 0.208, 263.709), new Ypr(-0.788, -0.077, 0.011) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1321.482, -0.401, 249.958), new Ypr(-0.736, -0.077, 0.006) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1312.188, -1.513, 237.733), new Ypr(-0.529, -0.071, 0.019) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1306.096, -2.604, 221.446), new Ypr(-0.232, -0.075, 0.018) );
//

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1365.141, 9.224, 846.741), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1366.302, 9.186, 832.996), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1375.143, 9.149, 823.671), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1381.372, 9.068, 809.210), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1381.243, 8.979, 795.754), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1387.009, 8.872, 784.785), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1391.037, 8.762, 772.534), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1391.470, 8.692, 760.380), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1398.251, 8.536, 745.504), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1398.940, 8.412, 730.791), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1398.620, 8.302, 717.690), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1403.154, 8.126, 702.204), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1401.573, 7.977, 686.689), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1403.545, 7.816, 669.988), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1404.005, 7.695, 655.096), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1400.270, 7.599, 643.306), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1400.821, 7.540, 631.945), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1400.817, 7.429, 615.302), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1396.726, 7.333, 601.930), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1396.369, 7.224, 587.440), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1396.862, 7.098, 571.309), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1392.625, 6.998, 558.495), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1392.367, 6.882, 544.342), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1392.647, 6.719, 525.043), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1387.815, 6.621, 513.149), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1388.280, 6.512, 500.362), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1388.444, 6.378, 484.393), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1383.212, 6.266, 470.689), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1383.347, 6.174, 459.294), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1383.993, 6.059, 444.636), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1379.102, 5.961, 431.319), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1379.337, 5.878, 420.238), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1379.633, 5.778, 406.287), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1374.707, 5.675, 390.376), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1373.571, 5.603, 378.969), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1374.482, 5.521, 364.290), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1372.457, 5.443, 348.569), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1367.138, 5.402, 338.799), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1368.585, 5.360, 328.528), new Ypr(0.000, 0.000, 0.000) );
//

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1178.306, -1.065, -61.005), new Ypr(-2.570, -0.052, -0.082) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1176.314, -1.713, -51.873), new Ypr(-2.946, -0.078, -0.059) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1172.835, -2.626, -38.610), new Ypr(-2.781, -0.069, -0.071) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1170.688, -4.334, -33.170), new Ypr(-2.732, -0.397, 0.004) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1167.964, -7.689, -25.294), new Ypr(-3.051, -0.373, 0.104) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1167.580, -9.496, -17.310), new Ypr(-3.045, -0.102, -0.100) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1166.518, -12.527, -9.714), new Ypr(-2.972, -0.209, -0.071) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1161.834, -14.382, 0.197), new Ypr(-2.525, -0.106, -0.164) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1303.147, -3.485, 206.805), new Ypr(-0.271, -0.020, -0.017) );

// bushes


gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1340.408, -4.046, 237.469), new Ypr(-0.180, -0.017, -0.172) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1342.003, -2.556, 199.921), new Ypr(-0.180, -0.017, -0.172) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1335.241, -2.929, 167.549), new Ypr(-0.180, -0.017, -0.172) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1319.353, -4.573, 162.617), new Ypr(-0.180, -0.017, -0.172) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1299.925, -6.236, 130.546), new Ypr(-0.180, -0.017, -0.172) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1307.552, -3.406, 96.777), new Ypr(-0.180, -0.017, -0.172) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1294.786, -3.147, 64.758), new Ypr(-0.180, -0.017, -0.172) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1295.188, -5.704, 36.357), new Ypr(-0.180, -0.017, -0.172) );
//
gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1373.650, 3.248, 896.549), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1387.105, 3.265, 865.917), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1403.883, 3.517, 848.571), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1406.757, 3.434, 826.059), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1416.123, 3.519, 801.437), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1428.082, 3.825, 773.295), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1433.017, 3.345, 741.672), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1434.501, 3.672, 704.924), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1433.103, 2.151, 676.712), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1438.065, 2.386, 644.730), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1436.160, 2.459, 614.540), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1431.237, 2.017, 578.917), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1423.626, 1.166, 551.626), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1426.355, 1.201, 529.466), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1417.549, 0.557, 494.922), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1415.555, 0.255, 464.760), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1415.572, 0.090, 446.501), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1409.398, -0.212, 419.574), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1411.827, -0.284, 397.355), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1404.398, -0.462, 362.843), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1404.708, -0.546, 344.595), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1399.562, -0.761, 318.019), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1397.942, -0.756, 275.616), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1386.209, -0.756, 241.332), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1386.560, -0.596, 222.162), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1380.413, -0.600, 192.992), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1371.090, -0.529, 167.539), new Ypr(0.000, 0.000, 0.000) );
//
gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1367.726, -0.302, 139.955), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1361.031, -0.115, 114.538), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1346.587, 0.153, 86.460), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1333.779, 0.527, 47.977), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1323.004, 0.876, 14.090), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1308.263, 1.172, -11.273), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1302.591, 1.405, -34.074), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1287.205, 1.658, -54.097), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1270.363, 1.982, -82.647), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1254.645, 2.323, -116.655), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1235.979, 2.557, -138.315), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1222.328, 2.781, -166.002), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1188.993, 3.055, -200.773), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1163.681, 3.197, -232.845), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1142.329, 3.236, -254.275), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1131.066, 3.236, -274.170), new Ypr(0.000, 0.000, 0.000) );
//

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1359.965, 9.224, 843.362), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1364.885, 9.155, 820.800), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1376.111, 8.906, 789.046), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1382.616, 8.732, 770.645), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1388.377, 8.632, 749.429), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1391.646, 8.469, 730.813), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1394.648, 8.250, 706.645), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1395.858, 7.949, 680.707), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1397.529, 7.708, 657.123), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1393.499, 7.554, 638.384), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1392.996, 7.494, 624.033), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1390.604, 7.309, 598.350), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1390.242, 7.125, 574.447), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1385.670, 6.939, 550.506), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1386.543, 6.773, 530.634), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1381.346, 6.557, 505.178), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1381.166, 6.394, 485.881), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1377.629, 6.232, 466.182), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1375.632, 6.137, 453.638), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1374.058, 5.955, 429.665), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1372.465, 5.766, 403.802), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1368.319, 5.634, 383.466), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1366.511, 5.497, 357.877), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1361.637, 5.386, 332.574), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1217.584, 5.004, -78.770), new Ypr(2.028, 0.063, 0.146) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1225.152, 6.606, -85.233), new Ypr(-0.167, 0.057, -0.154) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1213.046, 6.422, -100.091), new Ypr(-0.421, 0.022, -0.171) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1206.600, 6.976, -113.887), new Ypr(-0.423, 0.058, -0.137) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1196.447, 7.325, -126.662), new Ypr(-0.723, -0.021, -0.125) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1182.724, 7.470, -145.395), new Ypr(-0.463, 0.016, -0.128) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1175.632, 7.858, -158.356), new Ypr(-0.658, 0.006, -0.096) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1165.288, 8.977, -170.821), new Ypr(-0.736, -0.009, -0.004) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1154.569, 9.060, -183.815), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1142.972, 9.145, -199.996), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1124.232, 9.220, -221.960), new Ypr(0.000, 0.000, 0.000) );
//
gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1367.643, 3.204, 837.729), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1373.121, 3.135, 817.270), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1385.295, 2.936, 792.297), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1387.774, 2.733, 769.744), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1396.533, 2.627, 754.674), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1395.377, 2.474, 735.710), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1399.906, 2.097, 696.571), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1402.000, 1.756, 662.856), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1396.629, 1.545, 634.600), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1397.935, 1.408, 611.878), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1392.529, 1.210, 585.477), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1389.243, 1.033, 562.593), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1393.091, 0.820, 536.627), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1384.770, 0.567, 506.559), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1384.921, 0.359, 481.771), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1381.467, 0.139, 454.572), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1382.859, -0.010, 433.884), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1376.961, -0.160, 413.468), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1378.058, -0.310, 393.649), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1371.588, -0.450, 368.510), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1368.989, -0.560, 343.659), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1368.956, -0.670, 323.828), new Ypr(0.000, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1234.052, 1.230, -79.217), new Ypr(0.538, 0.134, -0.069) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1226.681, 1.330, -90.808), new Ypr(-0.613, -0.012, -0.163) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1206.341, 2.113, -124.686), new Ypr(-0.422, 0.014, -0.118) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1190.695, 1.689, -138.691), new Ypr(-0.927, -0.043, -0.121) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1174.976, 2.967, -168.730), new Ypr(-0.244, -0.010, -0.001) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1162.686, 3.024, -178.064), new Ypr(-1.345, -0.012, -0.011) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1148.848, 3.129, -196.755), new Ypr(-0.821, -0.009, -0.003) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1136.723, 3.205, -215.674), new Ypr(-0.349, -0.011, 0.011) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1124.644, 3.230, -228.824), new Ypr(-0.466, -0.010, 0.000) );
//
gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1226.516, 5.904, -75.682), new Ypr(-0.531, 0.000, -0.166) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1206.787, 3.074, -73.321), new Ypr(-1.904, -0.175, -0.043) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1196.931, 1.306, -68.491), new Ypr(-2.105, -0.199, -0.045) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1188.560, -0.526, -64.912), new Ypr(-1.728, -0.160, -0.148) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1177.220, -0.641, -65.647), new Ypr(-1.398, 0.041, -0.061) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1177.641, -2.111, -47.562), new Ypr(-2.521, -0.052, -0.078) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1168.510, -2.934, -37.851), new Ypr(-2.473, -0.406, -0.093) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1164.081, -8.360, -24.008), new Ypr(-3.105, -0.266, -0.020) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1167.907, -13.903, -3.353), new Ypr(1.826, -0.100, 0.208) );
//

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1377.666, 6.463, 873.304), new Ypr(-2.614, -0.013, 0.052) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1374.707, 6.446, 878.537), new Ypr(-2.639, -0.014, 0.035) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1368.700, 6.431, 889.028), new Ypr(-2.622, -0.010, 0.018) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1363.568, 6.432, 899.367), new Ypr(-2.745, -0.010, 0.019) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1359.749, 6.429, 909.587), new Ypr(-2.839, -0.011, 0.014) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1357.889, 6.454, 919.071), new Ypr(-3.053, -0.004, 0.048) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1328.673, 6.461, 906.859), new Ypr(0.862, -0.015, 0.049) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1333.080, 6.438, 902.644), new Ypr(0.763, -0.013, 0.026) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1339.681, 6.432, 894.641), new Ypr(0.643, -0.010, 0.020) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1345.159, 6.435, 886.539), new Ypr(0.555, -0.010, 0.023) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1349.780, 6.434, 878.780), new Ypr(0.525, -0.011, 0.022) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1354.843, 6.444, 869.819), new Ypr(0.507, -0.008, 0.039) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(-1359.445, 6.467, 861.855), new Ypr(0.517, -0.007, 0.065) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1312.886, 10.218, 199.095), new Ypr(3.052, -0.015, 0.045) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1312.564, 10.199, 205.153), new Ypr(3.089, -0.012, 0.021) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1311.865, 10.201, 214.117), new Ypr(3.044, -0.012, 0.024) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1310.591, 10.199, 222.349), new Ypr(2.933, -0.012, 0.021) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1307.522, 10.209, 231.461), new Ypr(2.734, -0.011, 0.035) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1344.320, 10.236, 237.122), new Ypr(0.497, -0.015, 0.059) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1341.483, 10.219, 232.171), new Ypr(0.502, -0.018, 0.047) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1338.545, 10.201, 224.660), new Ypr(0.303, -0.011, 0.025) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1336.439, 10.203, 216.407), new Ypr(0.204, -0.012, 0.026) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1335.100, 10.197, 208.033), new Ypr(0.106, -0.012, 0.019) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1334.814, 10.220, 199.289), new Ypr(0.012, -0.004, 0.054) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1335.604, 9.468, 118.915), new Ypr(-0.047, -0.017, 0.053) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1335.788, 9.440, 112.134), new Ypr(-0.035, -0.012, 0.020) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1337.005, 9.432, 101.201), new Ypr(-0.181, -0.011, 0.024) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1339.931, 9.443, 90.861), new Ypr(-0.377, -0.009, 0.025) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1344.423, 9.484, 82.210), new Ypr(-0.533, -0.016, 0.066) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1306.046, 9.461, 88.072), new Ypr(-2.499, -0.018, 0.041) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1308.854, 9.436, 92.991), new Ypr(-2.676, -0.011, 0.016) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1311.878, 9.440, 102.404), new Ypr(-2.903, -0.010, 0.022) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1313.454, 9.435, 111.247), new Ypr(-3.024, -0.011, 0.017) );

gt.create_native( map, new GameRef(objects:0x000000D3r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1313.890, 9.457, 118.330), new Ypr(-3.120, -0.000, 0.066) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1005.525, 20.106, -912.263), new Ypr(2.640, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1059.768, 17.990, -875.132), new Ypr(2.496, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1111.870, 17.090, -834.106), new Ypr(2.425, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1151.444, 17.327, -791.021), new Ypr(2.286, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1179.225, 17.589, -753.765), new Ypr(2.171, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1205.783, 17.764, -710.919), new Ypr(2.038, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1046.030, 19.391, -918.462), new Ypr(-0.551, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1100.919, 17.732, -877.891), new Ypr(-0.662, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1153.996, 17.817, -828.002), new Ypr(-0.855, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1187.246, 17.447, -786.700), new Ypr(-0.890, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1215.620, 17.440, -745.461), new Ypr(-1.030, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1241.570, 17.913, -697.931), new Ypr(-1.138, 0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1021.971, 19.092, -932.440), new Ypr(-2.092, -0.019, -0.015) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1034.892, 18.827, -924.904), new Ypr(-2.092, -0.019, -0.015) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1046.209, 18.534, -923.570), new Ypr(-2.092, -0.019, -0.015) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1053.276, 18.037, -913.836), new Ypr(-2.092, -0.019, -0.015) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1066.752, 17.641, -905.583), new Ypr(-2.092, -0.019, -0.015) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1081.033, 16.942, -893.276), new Ypr(-2.092, -0.019, -0.015) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1096.616, 17.015, -883.721), new Ypr(-1.920, 0.016, -0.126) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1105.882, 16.786, -874.200), new Ypr(-2.812, -0.088, -0.157) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1116.825, 16.725, -864.065), new Ypr(-2.250, 0.008, -0.192) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1132.420, 16.728, -849.527), new Ypr(-2.356, -0.016, -0.180) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1150.129, 16.876, -833.890), new Ypr(-1.921, 0.034, -0.086) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1156.652, 16.934, -822.667), new Ypr(-2.754, -0.063, -0.027) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1169.358, 16.699, -809.825), new Ypr(-2.412, -0.007, 0.083) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1178.449, 16.239, -799.056), new Ypr(-2.538, 0.021, 0.437) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1190.030, 15.928, -784.185), new Ypr(-2.782, 0.169, 0.573) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1197.946, 16.198, -772.732), new Ypr(-2.560, 0.002, 0.619) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(209.805, 16.427, -754.577), new Ypr(-2.619, 0.023, 0.486) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1219.367, 16.407, -739.890), new Ypr(-2.956, 0.222, 0.474) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1228.378, 16.440, -727.161), new Ypr(-2.697, 0.027, 0.407) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1234.386, 16.584, -713.117), new Ypr(-2.721, 0.023, 0.414) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1243.341, 15.497, -699.910), new Ypr(-2.532, 0.008, 0.380) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1245.052, 15.544, -692.390), new Ypr(3.072, -0.290, 0.299) );

gt.create_native( map, new GameRef(objects:0x00000186r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1207.216, 16.205, -758.437), new Ypr(-2.668, 0.066, 0.299) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1010.636, 19.037, -908.949), new Ypr(3.072, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1034.002, 18.257, -894.072), new Ypr(3.072, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1047.677, 17.576, -884.580), new Ypr(3.072, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1062.430, 16.865, -869.459), new Ypr(3.072, -0.000, 0.000) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1084.916, 16.374, -856.633), new Ypr(-2.236, -0.018, -0.050) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1104.031, 16.053, -839.362), new Ypr(-2.304, -0.011, -0.166) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1118.592, 15.707, -824.916), new Ypr(-2.281, -0.004, -0.290) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1135.168, 16.000, -808.373), new Ypr(-2.317, -0.016, -0.359) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1158.561, 15.884, -780.851), new Ypr(-2.378, 0.051, -0.374) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1170.409, 16.223, -765.628), new Ypr(-2.454, 0.027, -0.391) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1183.240, 15.955, -745.729), new Ypr(-2.452, 0.064, -0.390) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1196.877, 16.140, -724.439), new Ypr(-2.494, 0.052, -0.400) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1209.135, 16.140, -703.001), new Ypr(-2.458, 0.106, -0.400) );

gt.create_native( map, new GameRef(objects:0x00000000r), "0,0,0,0,0,0", "test_object" ); 
gt.setMatrix( new Vector3(1220.643, 16.505, -681.601), new Ypr(-2.584, 0.057, -0.416) );























			//raceBot1 = new Bot( Math.random()*59, 4, 1, 2.0, 2.0, 20.0);
			//raceBot1.createCar( map, new Vehicle( map, cars.fake_racers.teg:0x0006r, 0.0, 0.0, 0.0, 0.0, 0.0 ) );
			//raceBot1.brain.queueEvent( null, EVENT_COMMAND, "AI_params 8.0 100.0" );
			//raceBot1.car.queueEvent( null, EVENT_COMMAND, "reset" );
			//raceBot1.car.queueEvent( null, EVENT_COMMAND, "reload" );
			//raceBot1.car.setMatrix( raceBot2_posStart, raceBot2_oriStart );
			//raceBot1.car.setParent( map );
			//raceBot1.car.wakeUp();
			//raceBot1.car.queueEvent( null, EVENT_COMMAND, "idle" );
;

			//raceBot2 = new Bot( Math.random()*59, 4, 1, 2.0, 2.0, 20.0);
			//raceBot2.createCar( map, new Vehicle( map, cars.misc.Police_V3:0x0006r, 0.0, 0.0, 0.0, 0.0, 0.0 ) );
			//raceBot2.brain.queueEvent( null, EVENT_COMMAND, "AI_params 8.0 100.0" );
			//raceBot2.car.queueEvent( null, EVENT_COMMAND, "reset" );
			//raceBot2.car.queueEvent( null, EVENT_COMMAND, "reload" );
			//raceBot2.car.setMatrix( raceBot1_posStart, raceBot1_oriStart );
			//raceBot2.car.setParent( map );
			//raceBot2.car.wakeUp();
			//raceBot2.car.queueEvent( null, EVENT_COMMAND, "idle" );
                        //raceBot2.car.queueEvent( null, EVENT_COMMAND, "sethorn 1" );

			//raceBot3 = new Bot( Math.random()*59, 4, 1, 2.0, 2.0, 20.0);
			//raceBot3.createCar( map, new Vehicle( map, cars.misc.Police_V3:0x0006r, 0.0, 0.0, 0.0, 0.0, 0.0 ) );
			//raceBot3.brain.queueEvent( null, EVENT_COMMAND, "AI_params 8.0 100.0" );
			//raceBot3.car.queueEvent( null, EVENT_COMMAND, "reset" );
			//raceBot3.car.queueEvent( null, EVENT_COMMAND, "reload" );
			//raceBot3.car.setMatrix( raceBot3_posStart, raceBot3_oriStart );
			//raceBot3.car.setParent( map );
			//raceBot3.car.wakeUp();
			//raceBot3.car.queueEvent( null, EVENT_COMMAND, "idle" );
                       // raceBot3.car.queueEvent( null, EVENT_COMMAND, "sethorn 1" );
                        //raceBot3.car.queueEvent( null, EVENT_COMMAND, "stop" );

			//raceBot4 = new Bot( Math.random()*59, 4, 1, 2.0, 2.0, 20.0);
                       // raceBot4.createCar( map, GameLogic.carSaveDir + "RaceCar1" );
			//raceBot4.brain.queueEvent( null, EVENT_COMMAND, "AI_params 1.0 10.0" );
			//raceBot4.car.queueEvent( null, EVENT_COMMAND, "reset" );
			//raceBot4.car.queueEvent( null, EVENT_COMMAND, "reload" );
			//raceBot4.car.setMatrix( raceBot4_posStart, raceBot4_oriStart );
			//raceBot4.car.setParent( map );
			//raceBot4.car.wakeUp();
			//raceBot4.car.queueEvent( null, EVENT_COMMAND, "idle" );
    

		TRAFFIC0 = new GameType();
		TRAFFIC0.create_native(map, new GameRef(cars.traffic.Schoolbus:0x0006r), "1,1,1,1,1,1", "test_car1"); //neighbor mc
		TRAFFIC0.setMatrix(new Vector3(-331.205, 10.774, 1016.761), new Ypr(1.671,0.092,0.002));

		TRAFFIC1 = new GameType();
		TRAFFIC1.create_native(map, new GameRef(cars.fake_racers.Badge:0x0006r), "1,1,1,1,1,1", "test_car2");
		TRAFFIC1.setMatrix(new Vector3(-794.802, 9.080, -242.792), new Ypr(-1.679,-0.006,0.000));

		TRAFFIC2 = new GameType();
		TRAFFIC2.create_native(map, new GameRef(cars.traffic.Wagon:0x0006r), "1,1,1,1,1,1", "test_car"); //neighbor wagon
		TRAFFIC2.setMatrix(new Vector3(-313.180, 11.083, 1124.049), new Ypr(-1.554,-0.131,0.022));

		TRAFFIC3 = new GameType();
		TRAFFIC3.create_native(map, new GameRef(cars.fake_racers.Stallion:0x0006r), "1,1,1,1,1,1", "test_car3");
		TRAFFIC3.setMatrix(new Vector3(-795.895, 9.080, -232.936), new Ypr(-1.668,-0.007,0.000));

		TRAFFIC4 = new GameType();
		TRAFFIC4.create_native(map, new GameRef(cars.traffic.Erbilac:0x0006r), "1,1,1,1,1,1", "test_car4"); //our recovery truck
		TRAFFIC4.setMatrix(new Vector3(-285.205, 9.801, 1014.184), new Ypr(-0.742, -0.003, -0.010));

		TRAFFIC5 = new GameType();
		TRAFFIC5.create_native(map, new GameRef(cars.traffic.Wagon:0x0006r), "1,1,1,1,1,1", "test_car5"); //our parked car
		TRAFFIC5.setMatrix(new Vector3(-275.717, 9.805, 1023.631), new Ypr(1.607, -0.005, 0.000));

		TRAFFIC6 = new GameType();
		TRAFFIC6.create_native(map, new GameRef(cars.fake_racers.Badge:0x0006r), "1,1,1,1,1,1", "test_car6"); //neighbors visitor
		TRAFFIC6.setMatrix(new Vector3(-314.938, 9.706, 1028.591), new Ypr(-2.979, -0.014, 0.046));

		TRAFFIC7 = new GameType();
		TRAFFIC7.create_native(map, new GameRef(cars.traffic.Erbilac:0x0006r), "1,1,1,1,1,1", "test_car7"); //neighbors visitor 2
		TRAFFIC7.setMatrix(new Vector3(-315.647, 9.753, 1023.466), new Ypr(-2.988, -0.012, 0.044));

		TRAFFIC8 = new GameType();
		TRAFFIC8.create_native(map, new GameRef(cars.fake_racers.Badge:0x0006r), "1,1,1,1,1,1", "test_car8");
		TRAFFIC8.setMatrix(new Vector3(-99.346, 8.882, -101.425), new Ypr(0.005, -0.002, -0.000));

                TRAFFIC9 = new GameType();
		TRAFFIC9.create_native(map, new GameRef(cars.traffic.FireEngine:0x0006r), "1,1,1,1,1,1", "test_car9");
		TRAFFIC9.setMatrix(new Vector3(-20.272, 12.271, -679.493), new Ypr(-0.029, 0.002, 0.000));

                TRAFFIC10 = new GameType();
		TRAFFIC10.create_native(map, new GameRef(cars.traffic.Erbilac:0x0006r), "1,1,1,1,1,1", "test_car10");
		TRAFFIC10.setMatrix(new Vector3(-67.713, 12.708, -576.175), new Ypr(-0.025, -0.033, 0.003));

                TRAFFIC11 = new GameType();
		TRAFFIC11.create_native(map, new GameRef(cars.traffic.Wagon:0x0006r), "1,1,1,1,1,1", "test_car11");
		TRAFFIC11.setMatrix(new Vector3(-391.462, 3.580, -174.364), new Ypr(0.084, -0.002, 0.000));

                TRAFFIC12 = new GameType();
		TRAFFIC12.create_native(map, new GameRef(cars.traffic.FireEngine:0x0006r), "1,1,1,1,1,1", "test_car12");
		TRAFFIC12.setMatrix(new Vector3(-300.765, 9.783, 906.926), new Ypr(1.756, -0.002, 0.000));

                TRAFFIC13 = new GameType();
		TRAFFIC13.create_native(map, new GameRef(cars.traffic.Wagon:0x0006r), "1,1,1,1,1,1", "test_car13");
		TRAFFIC13.setMatrix(new Vector3(-133.477, 8.882, -71.022), new Ypr(-3.138, -0.002, 0.000));

		//man = new RenderRef( map, humans:0x0030r, "test_man" ); //spectator
		//manAnim = new Animation(man, testBones2);
		//manAnim.setSpeed(1.1);
		//manAnim.loopPlay();
	        //man.setMatrix(posMan,oriMan);


        if( prev_state instanceof RaceSetup)
        {
			if(( GameLogic.gameMode == GameLogic.GM_QUICKRACE )
			|| ( GameLogic.gameMode == GameLogic.GM_DEMO ))
			{
				if (!raceState)	//abandoned
				{
					GameLogic.changeActiveSection( parentState );
					return;
				}
			}
			//unpause world 
        }
        else
        {
			Frontend.loadingScreen.show();
			GfxEngine.flush();

Water = new RenderRef( map, Maps.Addon_Maps.yokohama_docks:0x00000032r, "test_object" ); // Water mesh
		map.setWater(new Vector3(0.0,0.0, 0.0), new Vector3(0.0,0.0,0.0), 300.0, 50.0); // Water object and behavior
                Water.setMatrix(new Vector3(0.000, -13.559, 0.000), new Ypr(0.000, 0.000, 0.000));



            if( prev_state instanceof Garage || prev_state instanceof TrackSelect )
            {
				posStart = posGarage[GameLogic.player.club];
				oriStart = oriGarage[GameLogic.player.club];
            }

			if( GameLogic.gameMode == GameLogic.GM_SINGLECAR || GameLogic.gameMode == GameLogic.GM_FREERIDE )
			{
				
                               posStart = new Vector3(-83.8, 12.9, -558.7);
				oriStart = new Ypr( -2.0, 0, 0);


            }

			if(( GameLogic.gameMode == GameLogic.GM_QUICKRACE )
			|| ( GameLogic.gameMode == GameLogic.GM_DEMO ))
			{	//segitjuk az engine-t, ne kelljen a garazs kornyeket betolteni eloszor
//				posStart = map.getNearestCross( posStart );
				posStart = map.getNearestCross( new Vector3(0.0, 0.0, 500.0), Math.random()*1000 );
			}

			//mar itt fel kell ra tenni, a regisztralodo kocsik miatt
			addNotification( map, EVENT_COMMAND, EVENT_SAME, null );

			float hour = GameLogic.getTime() / 3600;
			if( hour > 4 && hour < 22 )
			{	//day time settings
				map.addTraffic( new GameRef(cars.traffic.Taxi:0x00000006r), 25, 2, 5, 2); // 80 = quantidade de taxis no mapa
				map.addTraffic( new GameRef(cars.traffic.Ambulance:0x00000006r), 35, 2, 5, 2); // 20 ambulancias
				map.addTraffic( new GameRef(cars.traffic.FireEngine:0x00000006r), 15, 2, 5, 2); //12 carro bombeiro                         
				map.addTraffic( new GameRef(cars.traffic.Coach:0x00000006r), 15, 2, 10,2); 
				map.addTraffic( new GameRef(cars.traffic.Schoolbus:0x00000006r), 20, 2, 10, 2);
                                map.addTraffic( new GameRef(cars.fake_racers.Badge:0x00000006r), 30, 2, 5, 2);
                                map.addTraffic( new GameRef(cars.fake_racers.Ninja:0x00000006r), 30, 2, 5, 2);
                                map.addTraffic( new GameRef(cars.fake_racers.Stallion:0x00000006r), 30, 2, 5, 2);
                                map.addTraffic( new GameRef(cars.fake_racers.Sunset:0x00000006r), 30, 2, 5, 2);
                                map.addTraffic( new GameRef(cars.fake_racers.Teg:0x00000006r), 30, 2, 5, 2);

				map.addTraffic( new GameRef(cars.traffic.ArmoredVan:0x00000006r), 20, 2, 5, 2);
				map.addTraffic( new GameRef(cars.traffic.Wagon:0x00000006r), 30, 2, 5, 2);
				map.addTraffic( new GameRef(cars.traffic.Erbilac:0x00000006r), 30, 2, 5, 2);
				map.addTraffic( new GameRef(cars.traffic.CivilVan:0x00000006r), 30, 2, 5, 2);

		                //map.addTraffic( GRT_POLICECAR, 20, 2, 5, 2);


				//insert police & some randomly chosen opponents into traffic
				if( GameLogic.gameMode == GameLogic.GM_CARREER )
				{
					map.addTraffic( GRT_POLICECAR, 10, 2, 5, 2);

					for (int i = 0; i < 6; i++) {
					    int randomIndex = (int) (Math.random() * GameLogic.speedymen.length);

					    Racer opp = GameLogic.speedymen[randomIndex];
					    
					    if (opp instanceof Bot) {
					        Bot botopp = (Bot) opp;

					        if (!botopp.dummycar) {
					            botopp.dummycar = new GameRef();
					            botopp.dummycar.create_native(map, new GameRef(botopp.botVd.id), "0,-10000,0,0,0,0", "dummycar");
					            botopp.dummycar.command("texture " + GameLogic.CARCOLORS[botopp.botVd.colorIndex] + " 1");
					            botopp.traffic_id = map.addTrafficCar(botopp.dummycar, null);
					            map.notifyTrafficCar(botopp.traffic_id, 1);
					        }
					    }
					}
				} else
				if( GameLogic.gameMode == GameLogic.GM_DEMO )
				{
					map.addTraffic( GRT_POLICECAR, 50, 2, 5, 2);
				}

				map.setPedestrianDensity( 0.003 );
			}
			else
			{	//night time settings

				map.addTraffic( new GameRef(cars.traffic.Taxi:0x00000006r), 25, 2, 5, 2); // 80 = quantidade de taxis no mapa
				map.addTraffic( new GameRef(cars.traffic.Ambulance:0x00000006r), 35, 2, 5, 2); // 20 ambulancias
				map.addTraffic( new GameRef(cars.traffic.FireEngine:0x00000006r), 15, 2, 5, 2); //12 carro bombeiro                         
				map.addTraffic( new GameRef(cars.traffic.Coach:0x00000006r), 15, 2, 10,2); 
				map.addTraffic( new GameRef(cars.traffic.Schoolbus:0x00000006r), 20, 2, 10, 2);
                                map.addTraffic( new GameRef(cars.fake_racers.Badge:0x00000006r), 30, 2, 5, 2);
                                map.addTraffic( new GameRef(cars.fake_racers.Ninja:0x00000006r), 30, 2, 5, 2);
                                map.addTraffic( new GameRef(cars.fake_racers.Stallion:0x00000006r), 30, 2, 5, 2);
                                map.addTraffic( new GameRef(cars.fake_racers.Sunset:0x00000006r), 30, 2, 5, 2);
                                map.addTraffic( new GameRef(cars.fake_racers.Teg:0x00000006r), 30, 2, 5, 2);

				map.addTraffic( new GameRef(cars.traffic.ArmoredVan:0x00000006r), 20, 2, 5, 2);
				map.addTraffic( new GameRef(cars.traffic.Wagon:0x00000006r), 30, 2, 5, 2);
				map.addTraffic( new GameRef(cars.traffic.Erbilac:0x00000006r), 30, 2, 5, 2);
				map.addTraffic( new GameRef(cars.traffic.CivilVan:0x00000006r), 20, 2, 5, 2);


			        //map.addTraffic( GRT_POLICECAR, 12, 2, 5, 2);
				if( GameLogic.gameMode == GameLogic.GM_CARREER )
				{
					map.addTraffic( GRT_POLICECAR, 3, 2, 5, 2);
					prepareNightRace();
				} else
				if( GameLogic.gameMode == GameLogic.GM_DEMO )
				{
					map.addTraffic( GRT_POLICECAR, 20, 2, 5, 2);
				}
				map.setPedestrianDensity( 0.0005 );
			}

			map.addPedestrianType( new GameRef(humans:0x0057r) );
			map.addPedestrianType( new GameRef(humans:0x0058r) );
			map.addPedestrianType( new GameRef(humans:0x0059r) );
			map.addPedestrianType( new GameRef(humans:0x005Ar) );
			map.addPedestrianType( new GameRef(humans:0x005Br) );
			map.addPedestrianType( new GameRef(humans:0x0022r) );

			//map.setWater(new Vector3(0.0,-8.0,-1500.0), new Vector3(0.0,1.0,0.0), 300.0, 50.0);
			//map.addWaterLimit(new Vector3(0.0,0.0,-500.0), new Vector3(0.0,0.0,1.0));

            if( GameLogic.gameMode == GameLogic.GM_CARREER || GameLogic.gameMode == GameLogic.GM_SINGLECAR )
			{
				addTrigger( posGarage[0], null, Marker.RR_GARAGE1, "event_handlerGarage1", 6.0, "garage1_trigger" );
				addTrigger( posGarage[1], null, Marker.RR_GARAGE2, "event_handlerGarage2", 6.0, "garage2_trigger" );
				addTrigger( posGarage[2], null, Marker.RR_GARAGE3, "event_handlerGarage3", 6.0, "garage3_trigger" );
			}
        }


        super.enter( prev_state );

		//quickrace handling:
        if( !(prev_state instanceof RaceSetup) )
		{
			if( GameLogic.gameMode == GameLogic.GM_QUICKRACE )
			{
				challenger = player;
				challenged = raceBot;

				raceState = 1;

				//racesetup start
				if( !GameLogic.racesetup )
					GameLogic.racesetup = new RaceSetup();
				GameLogic.changeActiveSection( GameLogic.racesetup );
			} else
			if( GameLogic.gameMode == GameLogic.GM_DEMO )
			{//quick start
				osdEnabled = 0;
				enableOsd(osdEnabled);

				challenger = demoBot;
				challenged = raceBot;

				raceState = 1;

				Vector3	pFinish;
				do{
					pFinish = map.getNearestCross( posStart, 500+Math.random()*1000 );
				}while( !map.getStartDirection( posStart, pFinish ) );

				changeCamChase();
				startRace( posStart, pFinish, 0 );
			}
		}

    }


    public void exit( GameState next_state )
    {

		//citybe kene!
        if( !(next_state instanceof RaceSetup) )
		{
Water.destroy(); // Delete water mesh when exit from track
			removeAllTimers();

			for( int i=0; i<GameLogic.speedymen.length; i++ )
			{
				Racer opp = GameLogic.speedymen[i];
				if( opp instanceof Bot )
				{
					Bot botopp = opp;
					if( botopp.dummycar )
					{
						map.remTrafficCar(botopp.traffic_id);
						botopp.traffic_id = 0;
						botopp.dummycar.destroy();
						botopp.dummycar.release();
						botopp.dummycar = null;
					}
				}
			}
		}

        super.exit( next_state );
    }

    public void event_handlerGarage1( GameRef obj_ref, int event, String param )
    {
		handleGarageTrigger( 1, event, param );
	}

    public void event_handlerGarage2( GameRef obj_ref, int event, String param )
    {
		handleGarageTrigger( 2, event, param );
	}

    public void event_handlerGarage3( GameRef obj_ref, int event, String param )
    {
		handleGarageTrigger( 3, event, param );
	}

	public void handleGarageTrigger( int clubGarage, int event, String param )
	{
		if( param.token(0).intValue() == player.car.id() )
		{
			if( event == EVENT_TRIGGER_ON )
			{
				if( !activeTrigger )
					activeTrigger=clubGarage;
			}
			else
				activeTrigger=0;
		}
    }


    public void handleEvent( GameRef obj_ref, int event, int param )
    {
        super.handleEvent( obj_ref, event, param );

        if( event == EVENT_TIME )
        {
            if( param == 2 )        //one sec tick
            {
                if( activeTrigger > 0 )
                {
					//csak akkor mehetunk haza, ha nem uldoz a rendor, vagy nem versenyzunk
					if( !policeState && !raceState )
					{
						if( player.car.getSpeedSquare() < 0.25 )        //slow speed?
						{       
							if( activeTrigger-1 <= player.club )
							{
								activeTrigger = 0;
								if( 0 == new YesNoDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.DF_FREEZE, "Estacionar", "Deseja Entrar na Garagem" ).display() )
									GameLogic.changeActiveSection( GameLogic.garage );
							}
							else
							{	//meg nem lehet bemenned
								activeTrigger = 0;
								new WarningDialog( player.controller, Dialog.DF_MODAL|Dialog.DF_DEFAULTBG|Dialog.DF_FREEZE, "Informacao", "Esta e uma Garagem de um clube Superior, Voce nao pode Entrar!" ).display();
							}
						}
					}
                }
            }
        }
    }
}
