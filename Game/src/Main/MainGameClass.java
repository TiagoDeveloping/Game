package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import Enemy.Enemy;
import Enemy.EnemyTrajectory;
import arenaCreator.ArenaManager;
import arenaCreator.Frame;
import fileWriting.FileManager;
import listeners.KeyListeners;
import listeners.WindowCloseEvent;
import player.Player;
import player.PlayerLocation;

public class MainGameClass {

	public static MainGameClass main;
	
	private PlayerLocation pLoc = new PlayerLocation(50, 50);
	public Player p = new Player(0, pLoc);
	
	public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	private Enemy e0 = new Enemy(0, new PlayerLocation(50, 50), Color.RED);
	private Enemy e1 = new Enemy(0, new PlayerLocation(70, 120), Color.YELLOW);
	private Enemy e2 = new Enemy(0, new PlayerLocation(632, 63), Color.ORANGE);
	private Enemy e3 = new Enemy(0, new PlayerLocation(689, 285), Color.CYAN);
	
	public Frame frame;
	
	public ArenaManager aMng;
	
	public static void main(String[] args) {
		MainGameClass main = new MainGameClass();
		main.StartGame();
	}
	
	public void StartGame() {
		initializeVariables();
		
		FileManager config = new FileManager("config.properties");
		FileManager playerData = new FileManager("playerData.properties");
		checkAndSetPlayerLocationVariables(playerData);
		
		checkAndSetMainVariables(config);
		
		int width = Integer.parseInt(config.read("width"));
		int height = Integer.parseInt(config.read("height"));
		
		frame = new Frame(height, width, "Game!");
		
		int pX = Integer.parseInt(playerData.read("x"));
		int pY = Integer.parseInt(playerData.read("y"));
		
		PlayerLocation loc = new PlayerLocation(pX, pY);
		p.setLocation(loc);
		
		aMng = new ArenaManager(p, enemies);
		
		frame.addComponent(aMng);
		frame.show();
		
		e0.setEnemyTrajectory(new EnemyTrajectory(100, 100, -5));
		
		p.saveToConfig();
		
		frame.addKeyLister(new KeyListeners());
		frame.addWindowListener(new WindowCloseEvent());
		
		while (true) {
			for (Enemy e : enemies) {
				
				e.move();
				
				if (p.getCenterdLocation().toPoint().distance(e.getCenteredLocation().toPoint()) < 36) {
					p.setLocationByCoordinate(10, 10);
				}
				
				try {
					TimeUnit.MILLISECONDS.sleep(5);
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
				
			}
			aMng.update();
		}
		
	}
	
	private void checkAndSetMainVariables(FileManager config) {
		if (null == config.read("width")) {
			config.write("width", "900");
		}
		
		if (null == config.read("height")) {
			config.write("height", "700");
		}
	}
	
	private void checkAndSetPlayerLocationVariables(FileManager playerData) {
		if (null == playerData.read("x")) {
			playerData.write("x", "425");
		}
		
		if (null == playerData.read("y")) {
			playerData.write("y", "325");
		}
	}
	
	@SuppressWarnings("static-access")
	private void initializeVariables() {
		this.main = this;
		enemies.add(e0);
		e0.setDirection(-1);
		enemies.add(e1);
		e1.setDirection(1);
		enemies.add(e2);
		e2.setDirection(-1);
		enemies.add(e3);
		e3.setDirection(1);
	}
	
}
