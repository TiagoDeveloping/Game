package listeners;

import java.awt.geom.Point2D;

import Enemy.Enemy;
import player.Player;

public class Collision {

	private Player p;
	private Enemy e;
	
	public Collision(Player p, Enemy e) {
		this.p = p;
		this.e = e;
	}

	public boolean collisionOccured() {
		if (p.getCenterdLocation().toPoint().distance((Point2D) e.getCenteredLocation().toPoint()) < 36) {
			return true;
		}
		
		return false;
	}
	
}
