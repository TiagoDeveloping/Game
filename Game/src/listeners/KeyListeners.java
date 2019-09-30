package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Enemy.Enemy;
import Main.MainGameClass;
import player.Location;

public class KeyListeners implements KeyListener {
	
	MainGameClass main = MainGameClass.main;
	
	int code;
	
	@Override
	public void keyTyped(KeyEvent e) {
		//getLogAndUpdatePlayerLocation(e);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		code = e.getKeyCode();
//		updatePlayerLocation(code, e);
		
		keyPressedVelocityUpdate();
		
		if (escapeKeyPressed(code)) {
			main.frame.pause();
			JOptionPane.showMessageDialog(null, "The game has been paused!");
			main.frame.unPause();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		code = e.getKeyCode();
		keyReleasedVelocityUpdate();
	}
	
	private boolean escapeKeyPressed(int code) {
		return code == 27;
	}
	
	private void keyPressedVelocityUpdate() {
		if (upKeyPressed(code)) {
			main.p.setVector(main.p.getVector().getX(), -2);
		} else if (downKeyPressed(code)) {
			main.p.setVector(main.p.getVector().getX(), 2);
		} else if (leftKeyPressed(code)) {
			main.p.setVector(-2, main.p.getVector().getY());
		} else if (rightKeyPressed(code)) {
			main.p.setVector(2, main.p.getVector().getY());
		}
	}
	
	private void keyReleasedVelocityUpdate() {
		if (upKeyPressed(code)) {
			main.p.setVector(main.p.getVector().getX(), 0);
		} else if (downKeyPressed(code)) {
			main.p.setVector(main.p.getVector().getX(), 0);
		} else if (leftKeyPressed(code)) {
			main.p.setVector(0, main.p.getVector().getY());
		} else if (rightKeyPressed(code)) {
			main.p.setVector(0, main.p.getVector().getY());
		}
	}
//	
//	private void updatePlayerLocation(int code, KeyEvent e) {
//		if (upKeyPressed(code)) {
//			main.p.getPlayerLocation().addRelativeLocation(0, -5);
//			main.aMng.update();
//		} else if (rightKeyPressed(code)) {
//			main.p.getPlayerLocation().addRelativeLocation(5, 0);
//			main.aMng.update();
//		} else if (leftKeyPressed(code)) {
//			main.p.getPlayerLocation().addRelativeLocation(-5, 0);
//			main.aMng.update();
//		} else if (downKeyPressed(code)) {
//			main.p.getPlayerLocation().addRelativeLocation(0, 5);
//			main.aMng.update();
//		}
//	}
	
	public void manageCollision() {
		for (Enemy enemy : main.enemies) {
			Collision c = new Collision(main.p, enemy);
			if (c.collisionOccured()) {
				enemy.hide();
				enemy.setLocation(new Location(-10, -10));
			}
			main.aMng.update();
		}
	}
	
	private boolean upKeyPressed(int code) {
		return code == 38;
	}
	
	private boolean downKeyPressed(int code) {
		return code == 40;
	}
	
	private boolean leftKeyPressed(int code) {
		return code == 37;
	}
	
	private boolean rightKeyPressed(int code) {
		return code == 39;
	}

}
