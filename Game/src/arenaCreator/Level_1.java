package arenaCreator;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Level_1 {
	
	/**
	 * 
	 */
	
	private JFrame frame;
	private Dimension size;
	
	public Level_1(int height, int width, String name) {
		frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		size = new Dimension(width, height);
		
		frame.setPreferredSize(size);
		frame.setMaximumSize(size);
		frame.setMinimumSize(size);
		
	}
	
	public void update(Graphics g) {
		frame.update(g);
	}
	
	public void addComponent(Component comp) {
		frame.add(comp);
	}
	
	public void removeComponent(Component comp) {
		frame.remove(comp);
	}
	
	public void addKeyLister(KeyListener listener) {
		frame.addKeyListener(listener);
	}
	
	public void addMouseListener(MouseMotionListener listener) {
		frame.addMouseMotionListener(listener);
	}
	public void show() {
		frame.setVisible(true);
	}
	
	public void hide() {
		frame.setVisible(false);
	}
	
	public Graphics getGraphics() {
		return frame.getGraphics();
	}
	
}
