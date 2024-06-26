package java.game;

import java.io.*;
import java.util.*;
import java.util.resource.*;
import java.render.*;	//Text
import java.render.osd.*;	//Text
import java.sound.*;


abstract public class Scene extends GameType
{
	GroundRef	map;
	RenderRef	skydome;
	RenderRef	sun, suntype;

	float		lastSelectionTime;
	float		lastSelectionSeed;
	
	int			lastConfig=-1;

	int			internalScene;

	GameRef		renderer;
	ResourceRef	SkydomeTexture;
	int			MotionB = 0;
	RenderRef	Temp_Skydome;
	MotionBlur	MB_Animator;

	public void CreateMBskydome()
	{
		if( skydome ) skydome.destroy();
	
		Temp_Skydome = new RenderRef();
		Temp_Skydome.duplicate( new ResourceRef(MW_Mod:0x0079r) ); // Create
		//Temp_Skydome.scaleMesh( 1, 2, 5 ); // Scale, no works ;f
		Temp_Skydome.changeResource( new ResourceRef(MW_Mod:0x0035r), SkydomeTexture ); // Change texture

		skydome = new RenderRef( map, Temp_Skydome, "MB Skydome Render" );

		if(!MB_Animator)
		{
			MB_Animator = new MotionBlur( renderer, skydome );
		}
		else
		{
			MB_Animator.changeSky(skydome);
		}
	}

	public void addSceneElements( float time )
	{
		addSceneElements( time2Config( time ) );
	}

	public void addSceneElements( int config )
	{
		if( config != lastConfig )
		{
			if( !internalScene )
			{
				suntype = new RenderRef();
				suntype.duplicate( new RenderRef(maps.skydome:0x0124r) );
			}


			if( config == 0 )	//ejjel 22-3
			{
				if( !internalScene )
				{
					map.setFog( 0x0007121e, 20.0, 150.0 );
					suntype.setLight( 0x00466285, 0x0007121e, 0x00466285);
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x0035r ));
				}
				
				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x0023r, "egbolt-night_02" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x0022r);
					CreateMBskydome();
				}
			}
			else
			if ( config == 1 )	//reggel 3-4 v1
			{
				if( !internalScene )
				{
					map.setFog( 0x00171516, 50.0, 200.0 );
					suntype.setLight( 0x006889A6, 0x001F212D, 0x006889A6);
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x0030r ));
				}

				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x001dr, "egbolt-dusk_03" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x001Ar);
					CreateMBskydome();
				}
			}
			if ( config == 2 )	//reggel 3-4 v2
			{
				if( !internalScene )
				{
					map.setFog( 0x00111113, 10.0, 160.0 );
					suntype.setLight( 0x005D5D77, 0x0017142F, 0x005D5D77);
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x0031r ));
				}
				
				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x001er, "egbolt-dusk_04" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x001Br);
					CreateMBskydome();
				}
			}
			else
			if ( config == 3 )		//reggel 4-8 v1
			{
				if( !internalScene )
				{
					map.setFog( 0x0031364B, 50.0, 200.0 );
					suntype.setLight( 0x00CBB9AA, 0x002A3047, 0x00CBB9AA);
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x002Er ));
				}
				
				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x0015r, "egbolt-dusk_01" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x000Er);
					CreateMBskydome();
				}
			}
			else
			if ( config == 4 )		//reggel 4-8 v2
			{
				if( !internalScene )
				{
					map.setFog( 0x00696063, 30.0, 200.0 );
					suntype.setLight( 0x00C1BC95, 0x00515F5D, 0x00C1BC95);
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x002Fr ));
				}
				
				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x0016r, "egbolt-dusk_02" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x000Dr);
					CreateMBskydome();
				}
			}
			else
			if ( config == 5 )		//reggel 4-8 v3
			{
				if( !internalScene )
				{
					map.setFog( 0x00080808, 50.0, 200.0 );
					suntype.setLight( 0x00534FB2, 0x00140E2D, 0x00534FB2);
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x0032r ));
				}
				
				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x001Fr, "egbolt-dusk_05" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x001Cr);
					CreateMBskydome();
				}
			}
			else
			if ( config == 6 )		//napkozben 8-10
			{
				if( !internalScene )
				{
					map.setFog( 0x00B0BCBC, 70.0, 400.0 );
					suntype.setLight( 0x00C4DFE3, 0x002E3F56, 0x00C4DFE3);
					suntype.setFlare( new ResourceRef(maps.skydome:0x0100r), 0xe4e4e4FF, 1.0, 10.0, 15, 8 ); //nappali szin, glowminsize, glowmaxsize, flarecount, raycount
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x0033r ));
				}
				
				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x0021r, "egbolt-morning_01" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x0020r);
					CreateMBskydome();
				}
			}
			else
			if ( config == 7 )		//napkozben 10-19 v1
			{
				if( !internalScene )
				{
					map.setFog( 0x005E7992, 70.0, 400.0 );
					suntype.setLight( 0x00DDD8AD, 0x004B5E6F, 0x00DDD8AD);
					suntype.setFlare( new ResourceRef(maps.skydome:0x0100r), 0xe4e4e4FF, 1.0, 10.0, 15, 8 ); //nappali szin, glowminsize, glowmaxsize, flarecount, raycount
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x0026r ));
				}
				
				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x0002r, "egbolt-am_01" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x0005r);
					CreateMBskydome();
				}
			}
			else
			if ( config == 8 )		//napkozben 10-19 v2
			{
				if( !internalScene )
				{
					map.setFog( 0x00A1B5C3, 70.0, 400.0 );
					suntype.setLight( 0x00DEDABC, 0x00303C58, 0x00DEDABC);
					suntype.setFlare( new ResourceRef(maps.skydome:0x0100r), 0xe4e4e4FF, 1.0, 10.0, 15, 8 ); //nappali szin, glowminsize, glowmaxsize, flarecount, raycount
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x0027r ));
				}
				
				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x000Fr, "egbolt-am_02" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x0006r);
					CreateMBskydome();
				}
			}
			if ( config == 9 )		//napkozben 10-19 v3
			{
				if( !internalScene )
				{
					map.setFog( 0x00869BAD, 70.0, 400.0 );
					suntype.setLight( 0x00D8D4B0, 0x00375070, 0x00D8D4B0);
					suntype.setFlare( new ResourceRef(maps.skydome:0x0100r), 0xe4e4e4FF, 1.0, 10.0, 15, 8 ); //nappali szin, glowminsize, glowmaxsize, flarecount, raycount
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x0028r ));
				}
				
				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x0010r, "egbolt-am_03" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x0007r);
					CreateMBskydome();
				}
			}
			if ( config == 10 )		//napkozben 10-19 v4
			{
				if( !internalScene )
				{
					map.setFog( 0x00A4A1A0, 70.0, 400.0 );
					suntype.setLight( 0x00A1A7B3, 0x0058606B, 0x00A1A7B3);
					suntype.setFlare( new ResourceRef(maps.skydome:0x0100r), 0xd4d4d4FF, 1.0, 3.0, 15, 8 ); //nappali szin, glowminsize, glowmaxsize, flarecount, raycount
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x0029r ));
				}
				
				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x0019r, "egbolt-cloudyday_01" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x0018r);
					CreateMBskydome();
				}
			}
			else
			if ( config == 11 )		//delutan 19-20:30
			{
				if( !internalScene )
				{
					map.setFog( 0x003B4858, 60.0, 300.0 );
					suntype.setLight( 0x00BCBBB3, 0x001A1E2F, 0x00BCBBB3);
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x002Br ));
				}
				
				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x0013r, "egbolt-dawn_02" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x0009r);
					CreateMBskydome();
				}
			}
			else
			if ( config == 12 )		//este 20:30-22 v1
			{
				if( !internalScene )
				{
					map.setFog( 0x00160702, 60.0, 300.0 );
					suntype.setLight( 0x00D0A26D, 0x000F080F, 0x00D0A26D);
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x002Ar ));
				}
				
				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x0012r, "egbolt-dawn_01" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x0008r);
					CreateMBskydome();
				}
			}
			else
			if ( config == 13 )		//este 20:30-22 v2
			{
				if( !internalScene )
				{
					map.setFog( 0x00000000, 60.0, 300.0 );
					suntype.setLight( 0x00938A7C, 0x00171D2A, 0x00938A7C);
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x002Cr ));
				}
				
				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x0011r, "egbolt-dawn_03" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x000Ar);
					CreateMBskydome();
				}
			}
			else
			if ( config == 14 )		//este 20:30-22 v3
			{
				if( !internalScene )
				{
					map.setFog( 0x00030305, 60.0, 300.0 );
					suntype.setLight( 0x005F4045, 0x000D0C13, 0x005F4045);
					GfxEngine.setGlobalEnvmap( new ResourceRef( maps.skydome:0x002Dr ));
				}
				
				if( !MotionB )
					skydome = new RenderRef( map, maps.skydome:0x0014r, "egbolt-dawn_04" );
				else
				{
					SkydomeTexture = new ResourceRef(maps.skydome:0x000Br);
					CreateMBskydome();
				}
			}

			if( !internalScene )
			{
				sun = new RenderRef( map, suntype, "sunny" );
			}

			lastConfig = config;
		}
	}

	public int time2Config( float time )
	{
		//fel oranal hamarabb nem valtunk variaciot!
		float hourdiff = (time - lastSelectionTime) / 3600;
		if( hourdiff >= 1.0 || hourdiff <= -1.0 )
		{
			lastSelectionTime = time;
			lastSelectionSeed = Math.random();
		}

		float	hour = time / 3600;
		float	rnd = lastSelectionSeed;

		int config;

		if ( hour < 3 || hour >= 22 )
		{//ejjel 22-3
			config = 0;
		}
		else
		if ( hour < 4 )
		{//reggel 3-4
			if( rnd < 0.5 )
				config = 1;
			else
				config = 2;
		}
		else
		if ( hour < 8 )
		{//reggel 4-8
			if( rnd < 0.33 )
				config = 3;
			else
			if( rnd < 0.66 )
				config = 4;
			else
				config = 5;
		}
		else
		if ( hour < 10 )
		{//napkozben 8-10
			config = 6;
		}
		else
		if ( hour < 19 )
		{//napkozben 10-19
			if( rnd < 0.25 )
				config = 7;
			else
			if( rnd < 0.5 )
				config = 8;
			else
			if( rnd < 0.75 )
				config = 9;
			else
				config = 10;
		}
		else
		if ( hour < 20.5 )
		{//delutan 19-20:30
			config = 11;
		}
		else
		if ( hour < 22 )
		{//este 20:30-22
			if( rnd < 0.33 )
				config = 12;
			else
			if( rnd < 0.66 )
				config = 13;
			else
				config = 14;
		}

		return config;
	}

	public void remSceneElements()
	{
		if(skydome)
			skydome.destroy();

		if( !internalScene )
		{
			sun.destroy();
			suntype.destroy();
		}

		lastConfig = -1;
	}

	public void refresh( float time )
	{
		int config = time2Config( time );

		if( config != lastConfig )
		{
			remSceneElements();
			addSceneElements( config );
		}
	}
}