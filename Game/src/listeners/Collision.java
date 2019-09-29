package listeners;

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
		if (p.getCenterdLocation().toPoint().distance(e.getCenteredLocation().toPoint()) < 36) {
			return true;
		}
		
		return false;
	}
	
	public void setEnemy(Enemy e) {
		this.e = e;
	}
	
	public void setPlayer(Player p) {
		this.p = p;
	}
	
}
