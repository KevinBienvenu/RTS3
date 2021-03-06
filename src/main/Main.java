package main;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import game.Game;

public class Main {
	// A REGLER \\
	public static float ratioSpace = 0.7f;
	public static int framerate = 60;
	public static int nDelay=5;
	///////\\\\\\\\\
	
	public static float increment = 0.1f*30/Main.framerate;
	public static boolean pleinEcran = false;
	
	public static void main(String[] args) {
//		Log.setLogSystem(new NullLogSystem()); 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.setProperty("org.lwjgl.librarypath", new File(new File(System.getProperty("user.dir"), "native"), LWJGLUtil.getPlatformName()).getAbsolutePath());
//		System.out.println(LWJGLUtil.getPlatformName());
		int resolutionX;
		int resolutionY;
		if(pleinEcran){
			resolutionX = (int)screenSize.getWidth();		
			resolutionY = (int)screenSize.getHeight();
		} else {
			resolutionX = 800;		
			resolutionY = 600;
		}
		try {
			System.out.println("Gilles is back");
			Game game = new Game("RTS3");
			AppGameContainer app = new AppGameContainer( game );
//			app.setDisplayMode(resolutionX, resolutionY,true);
			app.setShowFPS(true);
			app.setDisplayMode(resolutionX, resolutionY,pleinEcran);
			app.setAlwaysRender(false);
			app.setUpdateOnlyWhenVisible(false);
			app.setClearEachFrame(true);
			app.setVSync(true);
			//app.setSmoothDeltas(true);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	

}
