 package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import Enemy.Enemy;
import arenaCreator.ArenaManager;
import arenaCreator.Frame;
import arenaCreator.LoadingScreen;
import fileWriting.ConfigurationFileManager;
import fileWriting.ImageManager;
import listeners.Collision;
import listeners.KeyListeners;
import listeners.WindowCloseEvent;
import player.Location;
import player.Player;

public class MainGameClass {

	public static MainGameClass main;
	
	private Location pLoc = new Location(50, 50);
	public Player p = new Player(0, pLoc);
	
	public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	private Enemy e0 = new Enemy(0, new Location(50, 50), Color.RED);
	private Enemy e1 = new Enemy(1, new Location(70, 120), new Color(71, 255, 231));
	private Enemy e2 = new Enemy(2, new Location(632, 63), Color.ORANGE);
	private Enemy e3 = new Enemy(3, new Location(689, 285), new Color(0, 102, 204));
	private Enemy e4 = new Enemy(4, new Location(263, 524), new Color(102, 0, 204));
	
	public Frame frame;
	
	public ArenaManager aMng;
	
	private String urlToBackground = "https://lh3.googleusercontent.com/XepQls13L5ipbhG7PoN3PT2QP_dlYHnmwMfsr9gYh4A-3AJdWjubKz6vIX3aFwf-6_SCZjHgLy5d305aYpk9pQGFQkVnnSaprqu93iEmw9eL6NHnQcGzsFXP0kH7rLlj7NYhUOX9ESgHdLP6EQA4AIw7L9qMOlarRWNr7gyoWorDiXMAoHpVb4vO07LfaqpIVO5Gl4tIxI4i6M7aawgNSN4UrtoOgzvE5eopcXjBjSRslKNBCdtpXNBTQ81nzy0ITsZnXSIzQZRQrIt0Ofm4EcUHI8kt_pvDEamH4EdVQRtMmmDkDFuKMG0PNN3eZQAU2f_PBqQ_-AWTfOSe77sqAXkoQpwcs0-JNEJXPqEZlT9GXFkwusARRXzy_4leZ65HvMUojhvoGG8hj-csyZ5PdycURfT047wwQY0wwjuMEYM1WlTU-hahjWQwGFLTMR943Ky9Sgmy-v41IJ-KnE4zAr-KWofc6Txh3BXTlTUlr8OAi3RYIjsJMREnE8imKDF2OE0LdlQnHeykF8w8OiJI12RpTGFDuLxKEURdoYu857RD1cOzVXXZrmPf0yPB-e1SuFFp611mS30xTZCSOsAFTd3r_Kh93NOf6AQvxuLcCBrAGtPplh_ZcBtAzdA=w2880-h1678";
	
	public LoadingScreen lc;
	
	public static String dataFolderPath;
	
	public static void main(String[] args) {
		MainGameClass main = new MainGameClass();
		main.StartGame();
	}
	
	public void StartGame() {
		ConfigurationFileManager config = new ConfigurationFileManager("config.properties");
		ConfigurationFileManager playerData = new ConfigurationFileManager("playerData.properties");
		
		dataFolderPath = config.dataFolderPath();
		
		lc = new LoadingScreen();
		
		checkAndSetPlayerLocationVariables(playerData);
		checkAndSetMainVariables(config);
		
		int width = Integer.parseInt(config.read("width"));
		int height = Integer.parseInt(config.read("height"));
		
		frame = new Frame(height, width, "Game!");
		
		frame.addComponent(lc);
		frame.show();
		
		ImageManager backgroundFile = new ImageManager("background.png");
		backgroundFile.setFile("background.png");
		
		setuptBackground(backgroundFile);
		
		int pX = Integer.parseInt(playerData.read("x"));
		int pY = Integer.parseInt(playerData.read("y"));
		
		Location loc = new Location(pX, pY);
		p.setLocation(loc);
		
		aMng = new ArenaManager(p, enemies);
		
		p.saveToConfig();
		
		Random r = new Random();
		
		initializeEnemies();
		
		for (Enemy e : enemies) {
			e.setLocation(r.nextInt(850), r.nextInt(650));
		}
		
		frame.addKeyLister(new KeyListeners());
		frame.addWindowListener(new WindowCloseEvent());
		
		Collision c = new Collision(p, e0);
		
        try {
      	  TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException exception) {
      	  System.err.println("Could not delay the frame repainting!");
      	  exception.printStackTrace();
        }
		
        frame.removeComponent(lc);
        
		frame.addComponent(aMng);
		frame.show();
		
	    while(true) {
	        if (!frame.isPaused()) {
	          for (Enemy e : enemies) {
	        	  if (e.showing) {
	        		  e.move();
	  	            
	        		  c.setEnemy(e);

	        		  if (c.collisionOccured()) {
	        			  doPlayerEnemyCollision(e);
	        		  }
	        	  }
	          }
	          
	          try {
	        	  TimeUnit.MILLISECONDS.sleep(7);
	          } catch (InterruptedException exception) {
	        	  System.err.println("Could not delay the frame repainting!");
	        	  exception.printStackTrace();
	          }
	        }
	        aMng.update();
	    }
	}

	private void setuptBackground(ImageManager backgroundFile) {
		if (!(backgroundFile.exists())) {
			backgroundFile.downloadRemoteImage("background.png", urlToBackground);
		}
	}

	private void doPlayerEnemyCollision(Enemy e) {
		p.setLocationByCoordinate(10, 10);
		  e.hide();
		  e.setLocation(-10, -10);
	}
	
	public void StopGame() {
		p.saveToConfig();
		System.exit(0);
	}
	
	private void checkAndSetMainVariables(ConfigurationFileManager config) {
		if (null == config.read("width")) {
			config.write("width", "900");
		}
		
		if (null == config.read("height")) {
			config.write("height", "700");
		}
		
		if (null == config.read("level")) {
			config.write("level", "1");
		}
		
	}
	
	private void checkAndSetPlayerLocationVariables(ConfigurationFileManager playerData) {
		if (null == playerData.read("x")) {
			playerData.write("x", "425");
		}
		
		if (null == playerData.read("y")) {
			playerData.write("y", "325");
		}
	}
	
	@SuppressWarnings("static-access")
	private void initializeEnemies() {
		this.main = this;
		enemies.add(0, e0);
		e0.setDirection(-1);
		enemies.add(1, e1);
		e1.setDirection(1);
		enemies.add(2, e2);
		e2.setDirection(-1);
		enemies.add(3, e3);
		e3.setDirection(1);
		enemies.add(4, e4);
		e4.setDirection(-1);
	}
	
}