package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Main.MainGameClass;

public class KeyListeners implements KeyListener {
	
	MainGameClass main = MainGameClass.main;
	
	int code;
	
	private int speed = 2;
	
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
			main.p.setVector(main.p.getVector().getX(), -speed);
		} else if (downKeyPressed(code)) {
			main.p.setVector(main.p.getVector().getX(), speed);
		} else if (leftKeyPressed(code)) {
			main.p.setVector(-speed, main.p.getVector().getY());
		} else if (rightKeyPressed(code)) {
			main.p.setVector(speed, main.p.getVector().getY());
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
