package player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import fileWriting.FileManager;

public class Player /*extends JComponent*/ {

	//Main main = Main.main;
	
	//private ImageIcon icon;
	private int id;
	private Location loc;
	
	public Player(int id, Location location) {
		//icon = new ImageIcon(pathToImage);
		this.id = id;
		this.loc = location;
		
		//graphics = (Graphics2D) g;
		
	}
	
	public void paintPlayer(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		
		graphics2d.setColor(Color.DARK_GRAY);
		
		int x = loc.getX();
		int y = loc.getY();
		
		int leftEyeX = x + 8;
		int rightEyeX = x + 28;
		
		int rightEyeY = y + 10;
		int leftEyeY = y + 10;
		
		graphics2d.fillRoundRect(x, y ,50, 50, 50, 50);
		
		graphics2d.setColor(Color.white);
		graphics2d.fillOval(leftEyeX, leftEyeY, 15, 15);
		graphics2d.fillOval(rightEyeX, rightEyeY, 15, 15);
		
		
		graphics2d.setColor(Color.red);
		graphics2d.fillOval(getCenterdLocation().getX(), getCenterdLocation().getY(), 1, 1);
		
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
		FileManager file = new FileManager("playerData.properties");
		file.write("id", this.id + "");
		file.write("x", this.loc.getX() + "");
		file.write("y", this.loc.getY() + "");
	}
	
}
