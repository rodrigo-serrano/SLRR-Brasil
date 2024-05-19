package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.render.osd.dialog.*;	//Text
import java.sound.*;

public class RaceDialog extends CsDialog
{
	public RaceDialog( Controller ctrl, int myflags, ResourceRef background, ResourceRef pict1, ResourceRef pict2, String name1, String name2, float time1, float time2, int param, int mode )
	{
		this( ctrl, myflags, background, pict1, pict2, name1, name2, time1, time2, param, mode, null, null );
	}

	public RaceDialog( Controller ctrl, int myflags, ResourceRef background, ResourceRef pict1, ResourceRef pict2, String name1, String name2, float time1, float time2, int param, int mode, Racer pl1, Racer pl2 )
	{
		// param is bet in night race, roc infocode in roc
		// mode==0: night race start
		// mode==1: night race end
		// mode==2: roc start
		// mode==3: roc end
		// [mode==4: dayrace start]
		// mode==5: dayrace end

		super( ctrl, myflags|DF_FREEZE, background );

		osd.createRectangle( -0.75, -0.60, 0.4, 0.7, 1, pict1 );
		osd.createRectangle( 0.75, -0.60, 0.4, 0.7, 1, pict2 );

		String str1 = name1;
		String str2 = name2;
		float dy = 0.27;

		if( mode == 1 || mode == 3 )
		{
			String timeString;

			if( time1 == 1000.0 )
				timeString = "--:--:--";
			else
				timeString=String.timeToString( time1, String.TCF_NOHOURS );

			str1 = name1 + " \n Tempo: " + timeString;


			if( time2 == 1000.0 )
				timeString = "--:--:--";
			else
				timeString=String.timeToString( time2, String.TCF_NOHOURS );

			str2 = name2 + " \n Tempo: " + timeString;

			dy = 0.26;
		}

		osd.createTextBox( str1, Frontend.smallFont, Text.ALIGN_CENTER, -0.75 - 0.2, -0.60 + dy, 0.4 );
		osd.createTextBox( str2, Frontend.smallFont, Text.ALIGN_CENTER, 0.75 - 0.2, -0.60 + dy, 0.4 );

		String str;

		if( mode == 0 )
			str = name1 + " Correndo Contra " + name2 + " \n A Aposta: ";
		else if( mode == 1 ||  mode == 5 )
			str = name1 + " Ganhou Contra " + name2 + " \n O Premio: ";
		else if( mode == 2 )
			str = name1 + " Correndo Contra " + name2;
		else if( mode == 3 )
			str = name1 + " Ganhou Contra " + name2;

		if( mode == 0 || mode == 1  || mode == 5 )
		{
			if( param == 0 )
			{
				if( mode == 5 )
					str = str + "Apenas Prestigio";
				else
					str = str + "Chave na Chave";
			}
			else
				str = str + "$" + param;
		}
		else
		if( mode == 2 )
		{
			str = str + " \n \n Corrida " + param + " de 3";
		}

		osd.createTextBox( " \n " + str + " \n \n ", Frontend.mediumFont, Text.ALIGN_CENTER, -0.4, -0.9, 0.8, City.RRT_FRAME );

		if( Config.majomParade && (mode != 4 && pl1 && pl2) )
		{
      Racer[] pl = new Racer[2];
			String[] pr = new String[2];
			String[] vn = new String[2];

      pl[0] = pl1;
      pl[1] = pl2;

      for (int i=0; i<2; i++)
      {
        if (pl[i].car && pl[i].car.chassis)
        {
          pr[i] = pl[i].getPrestigeString();
          vn[i] = pl[i].car.chassis.vehicleName;
        }
        else
        if ((mode == 0 || mode == 1) && pl[i] instanceof Bot && ((Bot)pl[i]).nightVd)
        {
          pr[i] = ((Bot)pl[i]).getPrestigeString(mode);
          vn[i] = ((Bot)pl[i]).nightVd.vehicleName;
        }
        else
        if ((mode == 4 || mode == 5) && pl[i] instanceof Bot && ((Bot)pl[i]).botVd)
        {
          pr[i] = ((Bot)pl[i]).getPrestigeString(mode);
          vn[i] = ((Bot)pl[i]).botVd.vehicleName;
        }
        else
        {
          pr[i] = "0/0";
          vn[i] = "unknown";
        }
      }

      float xp =  0.95;
      float yp = -0.20;
      int l = 0;

			osd.createText( "Prestigio", Frontend.mediumFont, Text.ALIGN_CENTER, 0.0, yp, l );
			osd.createText( pr[0], Frontend.mediumFont, Text.ALIGN_LEFT, -xp, yp, l );
			osd.createText( pr[1], Frontend.mediumFont, Text.ALIGN_RIGHT, xp, yp, l ); l++;

			osd.createText( "Veiculo", Frontend.mediumFont, Text.ALIGN_CENTER, 0.0, yp, l );
			osd.createText( vn[0], Frontend.mediumFont, Text.ALIGN_LEFT, -xp, yp, l );
			osd.createText( vn[1], Frontend.mediumFont, Text.ALIGN_RIGHT, xp, yp, l ); l++;
		}

		if( mode == 1 || mode == 5 )
		{
			if( param == 0 )
			{
				if( mode == 1 )
					osd.createRectangle( 0.55, 0.65, 0.75, 0.5, 1, new ResourceRef( frontend:0x0117r ) );
			}
			else
				osd.createRectangle( 0.55, 0.65, 0.75, 0.5, 1, new ResourceRef( frontend:0x0118r ) );
		}

		if( mode == 3 )
		{
			int curLost;
			if( param < 0 )
			{
				curLost = 1;
				param = -param;
			}

			int round = param % 10; param = param / 10;
			int lrun = param % 10; param = param / 10;
			int wrun = param;
			int	roundover = (lrun == 2 || wrun == 2);
			int	champion = ( round == 1 && wrun == 2 );
			int shortcut = roundover && (lrun+wrun == 2);

			if( champion )
			{
				//itt nem szamit, utoljara vesztett vagy nyert-e.
				str = "Parabens, Voce ganhou a ROC!";
				if( curLost )
					str = str + " \n (Apesar de perdido a ultima Corrida.)";

			}
			else
			if( roundover )
			{
				if( curLost )
					str = "Voce perdeu essa ROC. O Proximo evento sera em 6 Meses.";
				else
					str = "Parabens, Voce se qualificou para " + Roc.roundNames[round-1] + " da ROC!";

				if( shortcut )
					str = str + " \n (Etapa 3 foi pulada)";
			}
			else
			{
				if( curLost )
					str = "Voce perdeu essa corrida, Mas nao o campeonato. Va para proxima Corrida!";
				else
					str = "Parabens, Voce ganhou essa corrida, Va para proxima Corrida!";
			}

			osd.createTextBox( " \n " + str + " \n \n ", Frontend.mediumFont, Text.ALIGN_CENTER, 0.175, 0.55, 0.75, City.RRT_FRAME );
		}
	}
}
