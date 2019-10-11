package listeners;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Main.MainGameClass;

public class WindowCloseEvent implements WindowListener {

	MainGameClass main = MainGameClass.main;
	
	@Override
	public void windowOpened(WindowEvent e) {		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		main.StopGame();
	}

	@Override
	public void windowClosed(WindowEvent e) {		
	}

	@Override
	public void windowIconified(WindowEvent e) {		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {		
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {		
	}

	

}
