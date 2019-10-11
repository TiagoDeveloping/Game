package Enemy;

import java.awt.Point;
import java.awt.geom.Point2D;

public class EnemyTrajectory {

	private int x = 0;
	private int y = 0;
	private int rc = 0;
	
	public EnemyTrajectory(int x, int y, int rc) {
		this.x = x;
		this.y = y;
		this.rc = rc;
	}
	
	public Point2D getNextPoint(int direction) {
		if(direction == -1) { //left
			y = y + rc;
			x = x - 1;
		} else if (direction == 1) { //right
			y = y - rc;
			x = x + 1;
		}
		
		Point2D p = (Point2D) new Point(x, y);
		return p;
	}
	
	public void flipRc() {
		rc = rc * -1;
	}
	
	public void setRc(int newRc) {
		this.rc = newRc;
	}
	
}
