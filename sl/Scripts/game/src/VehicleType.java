package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.sound.*;

//describes a vehicle type's all models
public class VehicleType extends GameType
{
	//remove this asap!
	final static int VS_DEMO	= 0x0001;	//free ridehoz, quick racehez
	final static int VS_USED	= 0x0002;	//hasznaltautokereskedesbe
	final static int VS_STOCK	= 0x0004;	//ujautokereskedesbe
	final static int VS_DRACE	= 0x0008;	//day racehez
	final static int VS_NRACE	= 0x0010;	//night racehez
	final static int VS_RRACE	= 0x0020;	//roc racehez

	final static float	qm_stock_Baiern_CoupeSport_2_5 = 14.8294;
	final static float	qm_full_Baiern_CoupeSport_2_5 = 12.6816;
	final static float	qm_stock_Baiern_CoupeSport_GT_III = 9.9572;
	final static float	qm_full_Baiern_CoupeSport_GT_III = 8.6888;
	final static float	qm_stock_Baiern_DevilSport = 12.5978;
	final static float	qm_full_Baiern_DevilSport = 10.921;

	final static float	qm_stock_Duhen_Racing_SunStrip_2_0_CDVC = 11.448;
	final static float	qm_full_Duhen_Racing_SunStrip_2_0_CDVC = 10.139;
	final static float	qm_stock_Duhen_SunStrip_1_5_DVC = 13.9432;
	final static float	qm_full_Duhen_SunStrip_1_5_DVC = 11.1434;
	final static float	qm_stock_Duhen_SunStrip_1_8_DVC = 14.067;
	final static float	qm_full_Duhen_SunStrip_1_8_DVC = 11.3494;
	final static float	qm_stock_Duhen_SunStrip_2_2_DVC = 13.5854;
	final static float	qm_full_Duhen_SunStrip_2_2_DVC = 11.337;
		
	final static float	qm_stock_Einvagen_110_GT = 14.3126666666667;
	final static float	qm_full_Einvagen_110_GT = 11.6938333333333;
	final static float	qm_stock_Einvagen_110_GTK = 13.6701666666667;
	final static float	qm_full_Einvagen_110_GTK = 11.7413333333333;
	final static float	qm_stock_Einvagen_140_GTA = 12.5596666666667;
	final static float	qm_full_Einvagen_140_GTA = 10.5381666666667;
		
	final static float	qm_stock_Emer_MotorSport_Nonus_GT2 = 10.1594;
	final static float	qm_full_Emer_MotorSport_Nonus_GT2 = 8.7044;
	final static float	qm_stock_Emer_Nonus_Street_GT = 13.632;
	final static float	qm_full_Emer_Nonus_Street_GT = 11.1332;
		
	final static float	qm_stock_Hauler_s_SuperDuty_500 = 12.919;
	final static float	qm_full_Hauler_s_SuperDuty_500 = 8.17;
	final static float	qm_stock_Hauler_s_SuperDuty_Extra_750 = 12.231;
	final static float	qm_full_Hauler_s_SuperDuty_Extra_750 = 8.9984;

	final static float	qm_stock_Ishima_Enula_WR_SuperTurizmo = 12.3078571428571;
	final static float	qm_full_Ishima_Enula_WR_SuperTurizmo = 10.3145714285714;
	final static float	qm_stock_Ishima_Enula_WRY = 15.145;
	final static float	qm_full_Ishima_Enula_WRY = 11.8602857142857;
	final static float	qm_stock_Ishima_Enula_WRZ = 13.8452857142857;
	final static float	qm_full_Ishima_Enula_WRZ = 10.614;
		
	final static float	qm_stock_MC_GT = 13.0000;
	final static float	qm_full_MC_GT = 12.5000;
	final static float	qm_stock_MC_GT_B_series = 13.0000;
	final static float	qm_full_MC_GT_B_series = 12.2500;
	final static float	qm_stock_MC_GT_Limited_Edition = 12.000;
	final static float	qm_full_MC_GT_Limited_Edition = 11.5000;

	final static float	qm_stock_Prime_DLH_500 = 11.4848;
	final static float	qm_full_Prime_DLH_500 = 8.8484;

	final static float	qm_stock_Shimutshibu_Focer_RC_200 = 15.5492857142857;
	final static float	qm_full_Shimutshibu_Focer_RC_200 = 12.3081428571429;
	final static float	qm_stock_Shimutshibu_Focer_RC_300 = 14.0142857142857;
	final static float	qm_full_Shimutshibu_Focer_RC_300 = 11.5444285714286;
	final static float	qm_stock_Shimutshibu_Focer_WRC = 12.9868571428571;
	final static float	qm_full_Shimutshibu_Focer_WRC = 10.7257142857143;

        final static float	qm_stock_ar_1200 = 18.7500;
	final static float	qm_full_ar_1200 = 17.8000;
        final static float	qm_stock_ar_1300 = 18.2500;
	final static float	qm_full_ar_1300 = 17.2500;
        final static float	qm_stock_ar_1500 = 18.0000;
	final static float	qm_full_ar_1500 = 17.0000;
        final static float	qm_stock_ar_1600 = 17.9000;
	final static float	qm_full_ar_1600 = 16.9500;
        final static float	qm_stock_ar_1700 = 16.9000;
	final static float	qm_full_ar_1700 = 16.0000;
        final static float	qm_stock_ar_1900 = 14.9000;
	final static float	qm_full_ar_1900 = 13.0000;
        final static float	qm_stock_ar_2200 = 13.0000;
	final static float	qm_full_ar_2200 = 12.000;


        final static float	qm_stock_ap_1600 = 16.0000;
	final static float	qm_full_ap_1600 = 15.5000;
        final static float	qm_stock_ap_1800 = 14.9000;
	final static float	qm_full_ap_1800 = 11.9000;
        final static float	qm_stock_ap_2000 = 13.5000;
	final static float	qm_full_ap_2000 = 11.5000;


        final static float	qm_stock_ej20 = 10.0000;
	final static float	qm_full_ej20 = 9.8000;
        final static float	qm_stock_ej25 = 10.0000;
	final static float	qm_full_ej25 = 8.7000;



        final static float	qm_stock_at = 14.0000;
	final static float	qm_full_at = 13.0000;
        final static float	qm_stock_vht = 14.0000;
	final static float	qm_full_vht = 13.0000;
        final static float	qm_stock_endura1300 = 14.0000;
	final static float	qm_full_endura1300 = 13.0000;
        final static float	qm_stock_powertech = 14.0000;
	final static float	qm_full_powertech = 13.0000;
        final static float	qm_stock_fire = 14.000;
	final static float	qm_full_fire = 13.0000;
        final static float	qm_stock_endura = 14.0000;
	final static float	qm_full_endura = 13.0000;
        final static float	qm_stock_rocam = 14.0000;
	final static float	qm_full_rocam = 13.0000;



        final static float	qm_stock_c20 = 12.0000;
	final static float	qm_full_c20 = 10.8000;


        final static float	qm_stock_250_4100 = 13.0000;
	final static float	qm_full_250_4100 = 11.0000;
        final static float	qm_stock_250_5100 = 12.0000;
	final static float	qm_full_250_5100 = 8.0000;



        final static float	qm_stock_cht1000 = 16.9000;
	final static float	qm_full_cht1000 = 15.8000;
        final static float	qm_stock_cht1300 = 16.7000;
	final static float	qm_full_cht1300 = 15.7000;
        final static float	qm_stock_cht1400 = 16.5000;
	final static float	qm_full_cht1400 = 15.5000;
        final static float	qm_stock_cht1600 = 16.2000;
	final static float	qm_full_cht1600 = 15.5000;


        final static float	qm_stock_five20 = 13.8000;
	final static float	qm_full_five20 = 12.8000;
        final static float	qm_stock_five24 = 13.6000;
	final static float	qm_full_five24 = 12.6000;
        final static float	qm_stock_five20t = 12.5000;
	final static float	qm_full_five20t = 11.5000;



        final static float	qm_stock_fiasa_1050 = 16.8000;
	final static float	qm_full_fiasa_1050 = 15.8000;
        final static float	qm_stock_fiasa_1000 = 16.0000;
	final static float	qm_full_fiasa_1000 = 15.8000;
        final static float	qm_stock_fiasa_1300 = 16.3000;
	final static float	qm_full_fiasa_1300 = 15.7000;
        final static float	qm_stock_fiasa_1400 = 16.2000;
	final static float	qm_full_fiasa_1400 = 15.5000;
        final static float	qm_stock_fiasa_1500 = 16.0000;
	final static float	qm_full_fiasa_1500 = 15.0000;



        final static float	qm_stock_F2_1800 = 14.7000;
	final static float	qm_full_F2_1800 = 13.8000;
        final static float	qm_stock_F2_2000 = 13.5000;
	final static float	qm_full_F2_2000 = 12.2500;
        final static float	qm_stock_F2_2200 = 12.8000;
	final static float	qm_full_F2_2200 = 11.8000;
        final static float	qm_stock_F2_2400 = 10.9000;
	final static float	qm_full_F2_2400= 10.5000;


        final static float	qm_stock_duratec30 = 11.5000;
	final static float	qm_full_duratec30 = 10.2500;



        final static float	qm_stock_vr6_28 = 10.0000;
	final static float	qm_full_vr6_28 = 9.8000;
        final static float	qm_stock_vr6_29 = 9.8000;
	final static float	qm_full_vr6_29 = 9.5000;
        final static float	qm_stock_vr6_32 = 9.5000;
	final static float	qm_full_vr6_32 = 9.0000;
        final static float	qm_stock_vr6_36 = 8.5000;
	final static float	qm_full_vr6_36 = 8.0000;



        final static float	qm_stock_ea113_20 = 12.0000;
	final static float	qm_full_ea113_20 = 10.0000;
        final static float	qm_stock_ea111_16 = 13.1000;
	final static float	qm_full_ea111_16 = 12.7000;
        final static float	qm_stock_powertech20 = 12.0000;
	final static float	qm_full_powertech20 = 11.7000;
        final static float	qm_stock_torq16 = 13.1000;
	final static float	qm_full_torq16 = 12.7000;
        final static float	qm_stock_cht16 = 15.0000;
	final static float	qm_full_cht16 = 13.7500;
        final static float	qm_stock_duratec20 = 12.0000;
	final static float	qm_full_duratec20 = 10.0000;
        final static float	qm_stock_rocam16 = 13.0000;
	final static float	qm_full_rocam16 = 11.9000;



        final static float	qm_stock_ohc = 16.7000;
	final static float	qm_full_ohc = 15.5000;
 

        final static float	qm_stock_p1800 = 15.0000;
	final static float	qm_full_p1800 = 14.8000; 


        final static float	qm_stock_k20 = 12.0000;
	final static float	qm_full_k20 = 10.8000;
        final static float	qm_stock_k24 = 10.8000;
	final static float	qm_full_k24 = 10.0000; 
        final static float	qm_stock_kracer = 10.0000;
	final static float	qm_full_kracer = 9.0000;  



        final static float	qm_stock_sevel_1400 = 15.1000;
	final static float	qm_full_sevel_1400 = 13.1000;
        final static float	qm_stock_sevel_1600 = 14.9000;
	final static float	qm_full_sevel_1600 = 11.8000; 
        final static float	qm_stock_sevel_1900 = 13.0000;
	final static float	qm_full_sevel_1900 = 11.8000;
        final static float	qm_stock_sevel_1600_16v = 13.0000;
	final static float	qm_full_sevel_1600_16v = 12.0000;


        final static float	qm_stock_hi = 13.9000;
	final static float	qm_full_hi = 12.8000; 


        final static float	qm_stock_zetec_1600 = 15.0000;
	final static float	qm_full_zetec_1600 = 14.5000;
        final static float	qm_stock_zetec_1800 = 14.0000;
	final static float	qm_full_zetec_1800 = 13.5000;
        final static float	qm_stock_zetec_2000 = 12.5000;
	final static float	qm_full_zetec_2000 = 11.0000;
        final static float	qm_stock_zetec_2100 = 11.0000;
	final static float	qm_full_zetec_2100 = 9.8000;



	Vector	vtdarr = new Vector();

	float prevalence = 1.0;
	int		vehicleSetMask;		//megmondja, milyen seteket kepes ez a tipus generalni
								//generalt!! (a modellek alapjan)
	Vector	preferredColorIndexes = new Vector();

	public void addColorIndex( int index )
	{
		preferredColorIndexes.addElement( new Integer(index) );
	}

	public VehicleDescriptor getVehicleDescriptor( int set, float param )
	{
		VehicleModel vtd = getVehicleModel( set );

		VehicleDescriptor vd = new VehicleDescriptor();

		vd.id = vtd.id;
		vd.stockPrestige = vtd.stockPrestige;
		vd.fullPrestige = vtd.fullPrestige;
		vd.vehicleName = vtd.vehicleName;
		vd.stockQM = vtd.stockQM;
		vd.fullQM = vtd.fullQM;

		Vector colorIndexes;

		if( vtd.exclusiveColors && vtd.preferredColorIndexes.size() )
			colorIndexes = vtd.preferredColorIndexes;	//model exluziv szinvalasztekkal
		else
			if( vtd.preferredColorIndexes.size() || preferredColorIndexes.size() )
			{	//a modellnek van nehany speci szine is az alap tipusszineken tul, random valasztunk
				int m = vtd.preferredColorIndexes.size();
				int t = preferredColorIndexes.size();

				if( (m+t) * Math.random() < m )
					colorIndexes = vtd.preferredColorIndexes;
				else
					colorIndexes = preferredColorIndexes;
			}
			//else
			//	System.log( "VehicleType.getVehicleDescriptor(): color information missing - using default. id:" + id() );

		if( colorIndexes )		
			vd.colorIndex = colorIndexes.elementAt( (int)(Math.random()*colorIndexes.size()) ).intValue();

		if( param < 0 )
		{	//random selection
			vd.power = vtd.minPower + Math.random()*(vtd.maxPower - vtd.minPower);
			vd.optical = vtd.minOptical + Math.random()*(vtd.maxOptical - vtd.minOptical);
			vd.tear = vtd.minTear + Math.random()*(vtd.maxTear - vtd.minTear);
			vd.wear = vtd.minWear + Math.random()*(vtd.maxWear - vtd.minWear);
		}
		else
		{	//use param

			if (param>1.0)
				param=1.0;
			vd.power = vtd.minPower + param*(vtd.maxPower - vtd.minPower);
			vd.optical = vtd.minOptical + param*(vtd.maxOptical - vtd.minOptical);
			vd.tear = vtd.minTear + param*(vtd.maxTear - vtd.minTear);
			vd.wear = vtd.minWear + param*(vtd.maxWear - vtd.minWear);
		}

		return vd;
	}

	//adott set szerinti modellt ad vissza
	private VehicleModel getVehicleModel( int set )
	{
		VehicleModel vtd;
		float	grossPrevalence, grossPrevalence2;

		for( int i=vtdarr.size()-1; i>=0; i-- )
		{
			vtd = vtdarr.elementAt(i);
			if( set & vtd.vehicleSetMask )
				grossPrevalence += vtd.prevalence;
		}

		grossPrevalence*=Math.random();

		for( int i=vtdarr.size()-1; i>=0; i-- )
		{
			vtd = vtdarr.elementAt(i);
			if( set & vtd.vehicleSetMask )
			{
				grossPrevalence2 += vtd.prevalence;
				if( grossPrevalence2 > grossPrevalence )
				{
					//megvan a jo kis vtd!
					break;
				}
			}
		}

		return vtd;
	}

	public void init()
	{
		//calc vehicleSetMask:
		for( int i=vtdarr.size()-1; i>=0; i-- )
			vehicleSetMask |= vtdarr.elementAt(i).vehicleSetMask;
	}

}
