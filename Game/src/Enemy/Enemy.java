package Enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import player.Player;
import player.PlayerLocation;

public class Enemy {

	private int id;
	private PlayerLocation loc;
	private Player target;
	private boolean showing = true;
	private Color c;
	
	public Enemy(Player target, int id, PlayerLocation loc, Color c) {
		this.target = target;
		this.id = id;
		this.loc = loc;
		this.c = c;
	}

	public void paintEnemy(Graphics g) {
		if (showing == true) {
			Graphics2D graphics2d = (Graphics2D) g;
			
			graphics2d.setColor(c);
			
			int x = loc.getX();
			int y = loc.getY();
			
			graphics2d.fillRoundRect(x, y, 20, 20, 20, 20);
			
			graphics2d.setColor(Color.BLACK);
			
		}
	}
	
	public Color getColor() {
		return this.c;
	}
	
	public void setColor(Color c) {
		this.c = c;
	}
	
	public void hide() {
		showing = false;
	}
	
	public void show() {
		showing = true;
	}
	
	public PlayerLocation getCenteredLocation() {
		int x = this.loc.getX() + 10;
		int y = this.loc.getY() + 10;
		PlayerLocation loc = new PlayerLocation(x, y);
		return loc;
	}
	
	public void setLocation(int x, int y) {
		this.loc = new PlayerLocation(x, y);
	}
	
	public Player getTarget() {
		return this.target;
	}
	
	public void setTarget(Player p) {
		this.target = p;
	}
	
	public int getId() {
		return this.id;
	}
	
	public PlayerLocation getEnemyLocation() {
		return this.loc;
	}
	
	public void setLocation(PlayerLocation loc) {
		this.loc = loc;
	}
	
}
