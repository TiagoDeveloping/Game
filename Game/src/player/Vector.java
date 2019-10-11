package player;

public class Vector {

	private int veloX;
	private int veloY;
	
	public Vector(int veloX, int veloY) {
		this.veloX = veloX;
		this.veloY = veloY;
	}

	public void doNextTickLocation(Location playerLoc) {
		playerLoc.addRelativeLocation(veloX, veloY);
	}
	
	public void setVelocity(int veloX, int veloY) {
		this.veloX = veloX;
		this.veloY = veloY;
	}
	
	public int getX() {
		return veloX;
	}
	
	public int getY() {
		return veloY;
	}
	
	public void dump() {
		System.out.println("Vector(x:" + veloX + ";y:" + veloY + ");");
	}
	
}
