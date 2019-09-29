package arenaCreator;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import Enemy.Enemy;
import player.Player;

@SuppressWarnings("serial")
public class ArenaManager extends JComponent {

	private Player p;
	private ArrayList<Enemy> enemies;
	
	public ArenaManager(Player p, ArrayList<Enemy> enemies) {
		this.p = p;
		this.enemies = enemies;
	}

	public void paintComponent(Graphics g) {
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
	
}
