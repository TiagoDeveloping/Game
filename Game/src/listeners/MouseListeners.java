package listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

import Enemy.Enemy;
import Main.MainGameClass;
import player.PlayerLocation;

public class MouseListeners implements MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		MainGameClass main = MainGameClass.main;
		for (Enemy enemy : main.enemies) {
			Point newEnemyLoc = new Point(e.getX(), e.getY());
			enemy.setLocation(new PlayerLocation(newEnemyLoc.x, newEnemyLoc.y));
			main.aMng.update();
			
			Point cEnemyLoc = enemy.getCenteredLocation().toPoint();
			
			Point p = new Point(main.p.getCenterdLocation().toPoint());
			if (p.distance((Point2D)cEnemyLoc) < 36) {
				System.out.println("hit!");
			}
			
		}
		
	}

}
