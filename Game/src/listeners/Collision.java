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
		if (e.getCenteredLocation().toPoint().distance(p.getCenterdLocation().toPoint()) < 36) {
			return true;
		}
		return false;
	}
	
	public void setEnemy(Enemy enemy) {
		this.e = enemy;
	}
	
	public void setPlayer(Player player) {
		this.p = player;
	}
	
}
