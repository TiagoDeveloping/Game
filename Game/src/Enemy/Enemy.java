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
	
	public Enemy(Player target, int id, PlayerLocation loc) {
		this.target = target;
		this.id = id;
		this.loc = loc;
	}

	public void paintEnemy(Graphics g) {
		if (showing == true) {
			Graphics2D graphics2d = (Graphics2D) g;
			
			graphics2d.setColor(Color.YELLOW);
			
			int x = loc.getX();
			int y = loc.getY();
			
			graphics2d.fillRoundRect(x, y, 20, 20, 20, 20);
			
			graphics2d.setColor(Color.RED);
			graphics2d.fillOval(getCenteredLocation().getX(), getCenteredLocation().getY(), 1, 1);
		}
	}
	
	public void hide() {
		showing = false;
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
