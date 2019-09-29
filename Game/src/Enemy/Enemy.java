package Enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import player.Location;

public class Enemy {

	private int id;
	private Location loc;
	public boolean showing = true;
	private Color c;
	private EnemyTrajectory eTj;
	private int direction;
	
	public Enemy(int id, Location loc, Color c) {
		this.id = id;
		this.loc = loc;
		this.c = c;
		
		this.eTj = new EnemyTrajectory(loc.getX(), loc.getY(), 10);
		
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
	
	public void setDirection(int dir) {
		this.direction = dir;
	}
	
	public void move() {
		Point2D point = this.eTj.getNextPoint(direction);
		int x = (int) point.getX();
		int y = (int) point.getY();
		
		this.setLocation(new Location(x, y));		
		
		checkBounceLeftRight();
		
		if (!(isWithinBoundaries())) {
			this.eTj.flipRc();
			this.setLocation(new Location(x, y));
		}
	}
	
	public void setEnemyTrajectory(EnemyTrajectory eTj) {
		this.eTj = eTj;
	}
	
	public EnemyTrajectory getEnemyTrajectory() {
		return this.eTj;
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
	
	public Location getCenteredLocation() {
		int x = this.loc.getX() + 10;
		int y = this.loc.getY() + 10;
		Location loc = new Location(x, y);
		return loc;
	}
	
	public void setLocation(int x, int y) {
		this.loc = new Location(x, y);
	}
	
	public int getId() {
		return this.id;
	}
	
	public Location getEnemyLocation() {
		return this.loc;
	}
	
	public void setLocation(Location loc) {
		this.loc = loc;
	}

	public void checkBounceLeftRight() {
		if (this.loc.getX() <= 0 || this.loc.getX() >= 880) {
			this.direction = this.direction * -1;
		}
	}
	
	public boolean isWithinBoundaries() {
		if (this.loc.getX() <= 0 || this.loc.getX() >= 880) {
			 return false;
		} else if (this.loc.getY() <= 0 || this.loc.getY() >= 680) {
			return false;
		}
		return true;
	}
	
	public boolean hasBounced() {
		return (!isWithinBoundaries());
	}
	
}
