package arenaCreator;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Enemy.Enemy;
import fileWriting.ImageManager;
import player.Player;

@SuppressWarnings("serial")
public class ArenaManager extends JComponent {

	private Player p;
	private ArrayList<Enemy> enemies;
	
	private ImageManager iMng = new ImageManager();
	
	private Image img;
	
	public ArenaManager(Player p, ArrayList<Enemy> enemies) {
		this.p = p;
		this.enemies = enemies;
		
		iMng.setFile("bg.png");
		
		try {
			img = ImageIO.read(iMng.getFile());
		} catch (IOException e) {
			System.out.println("Could not load background image!");
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBackground(g);
		p.paintPlayer(g);
		
		for (Enemy e : enemies) {
			e.paintEnemy(g);
		}
	}
	
	public void update() {
		this.repaint();
	}
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
	private void drawBackground(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
	
}
