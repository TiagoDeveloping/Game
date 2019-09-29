package player;

import java.awt.Point;
import java.awt.geom.Point2D;

public class PlayerLocation {

	private int x;
	private int y;
	
	public PlayerLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void addRelativeLocation(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}
	
	public Point2D toPoint() {
		Point2D point = new Point(x, y);
		return point;
	}
	
	public int getX() {
		return this.x;
		}
	
	public int getY() {
		return this.y;
	}
	
	public String toString() {
		String string = "PlayerLocation(x=" + this.x + ";y=" + this.y + ");";
		return string;
	}
	
	public void dump() {
		System.out.println(this);
	}
	
}
