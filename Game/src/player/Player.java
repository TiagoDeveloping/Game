package player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import fileWriting.ConfigurationFileManager;

public class Player /*extends JComponent*/ {

	//Main main = Main.main;
	
	//private ImageIcon icon;
	private int id;
	private Location loc;
	
	private Vector vec;
	
	public Player(int id, Location location) {
		//icon = new ImageIcon(pathToImage);
		this.id = id;
		this.loc = location;
		
		this.vec = new Vector(0, 0);
		
		//graphics = (Graphics2D) g;
		
	}
	
	private Graphics2D graphics2d;
	
	private int x;
	private int y;
	
	private int leftEyeX;
	private int rightEyeX;
	
	private int rightEyeY;
	private int leftEyeY;
	
	public void paintPlayer(Graphics g) {
		this.graphics2d = (Graphics2D) g;
		
		this.vec.doNextTickLocation(loc);
		
		graphics2d.setColor(Color.DARK_GRAY);
			
		x = loc.getX();
		y = loc.getY();
		
		leftEyeX = x + 8;
		rightEyeX = x + 28;
			
		rightEyeY = y + 10;
		leftEyeY = y + 10;
			
		graphics2d.fillRoundRect(x, y ,50, 50, 50, 50);
			
		graphics2d.setColor(Color.white);
		graphics2d.fillOval(leftEyeX, leftEyeY, 15, 15);
		graphics2d.fillOval(rightEyeX, rightEyeY, 15, 15);
	}
	
	public Vector getVector() {
		return this.vec;
	}
	
	public void setVector(int veloX, int veloY) {
		this.vec.setVelocity(veloX, veloY);
	}
	
	public Location getCenterdLocation() {
		int x = this.loc.getX() + 25;
		int y = this.loc.getY() + 25;
		Location cPLoc = new Location(x, y);
		return cPLoc;
	}
	
	public void setLocation(Location loc) {
		this.loc = loc;
	}
	public void setLocationByCoordinate(int x, int y) {
		this.loc.setX(x);
		this.loc.setY(y);
	}
	
	
	public Location getPlayerLocation() {
		return this.loc;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void saveToConfig() {
		ConfigurationFileManager file = new ConfigurationFileManager("playerData.properties");
		file.write("id", this.id + "");
		file.write("x", this.loc.getX() + "");
		file.write("y", this.loc.getY() + "");
	}
	
	public boolean isWithinBoundaries() {
		if (this.loc.getX() <= 0 || this.loc.getX() >= 870) {
			 return false;
		} else if (this.loc.getY() <= 0 || this.getCenterdLocation().getY() >= 663) {
			return false;
		}
		return true;
	}
	
}
