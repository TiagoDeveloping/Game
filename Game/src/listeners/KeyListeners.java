package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.MainGameClass;

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
		getLogAndUpdatePlayerLocation(code, e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		code = -1;
	}
	
	private void getLogAndUpdatePlayerLocation(int code, KeyEvent e) {
		if (upKeyPressed(code)) {
			System.out.println("up");
			main.p.getPlayerLocation().addRelativeLocation(0, -2);
			main.p.saveToConfig();
			main.aMng.update();
		} else if (rightKeyPressed(code)) {
			System.out.println("right");
			main.p.getPlayerLocation().addRelativeLocation(2, 0);
			main.p.saveToConfig();
			main.aMng.update();
		} else if (leftKeyPressed(code)) {
			System.out.println("left");
			main.p.getPlayerLocation().addRelativeLocation(-2, 0);
			main.p.saveToConfig();
			main.aMng.update();
		} else if (downKeyPressed(code)) {
			System.out.println("down");
			main.p.getPlayerLocation().addRelativeLocation(0, 2);
			main.p.saveToConfig();
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
