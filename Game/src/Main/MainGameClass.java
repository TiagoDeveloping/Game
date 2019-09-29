package Main;

import java.awt.Color;
import java.util.ArrayList;

import Enemy.Enemy;
import arenaCreator.ArenaManager;
import arenaCreator.Frame;
import fileWriting.FileManager;
import listeners.KeyListeners;
import player.Player;
import player.PlayerLocation;

public class MainGameClass {

	public static MainGameClass main;
	
	private PlayerLocation pLoc = new PlayerLocation(50, 50);
	public Player p = new Player(0, pLoc);
	
	public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	private Enemy e0 = new Enemy(p, 0, new PlayerLocation(50, 50), Color.RED);
	private Enemy e1 = new Enemy(p, 0, new PlayerLocation(70, 120), Color.YELLOW);
	private Enemy e2 = new Enemy(p, 0, new PlayerLocation(632, 63), Color.ORANGE);
	private Enemy e3 = new Enemy(p, 0, new PlayerLocation(689, 285), Color.CYAN);
	
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
		
		if (null == config.read("width")) {
			config.write("width", "900");
		}
		
		if (null == config.read("height")) {
			config.write("height", "700");
		}
		
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
		
		p.saveToConfig();
		
		frame.addKeyLister(new KeyListeners());
	}
	
	private void checkAndSetPlayerLocationVariables(FileManager playerData) {
		if (null == playerData.read("x")) {
			playerData.write("x", "50");
		}
		
		if (null == playerData.read("y")) {
			playerData.write("y", "50");
		}
	}
	
	@SuppressWarnings("static-access")
	private void initializeVariables() {
		this.main = this;
		enemies.add(e0);
		enemies.add(e1);
		enemies.add(e2);
		enemies.add(e3);
	}
	
}
