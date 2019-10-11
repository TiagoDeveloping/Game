package arenaCreator;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Frame {
	
	/**
	 * 
	 */
	
	private JFrame frame;
	private Dimension size;
	
	private boolean paused = false;
	
	public Frame(int height, int width, String name) {
		frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		size = new Dimension(width, height);
		
		frame.setPreferredSize(size);
		frame.setMaximumSize(size);
		frame.setMinimumSize(size);
	}
	
	public void pause() {
		this.paused = true;
	}
	
	public void unPause() {
		this.paused = false;
	}
	
	public void setBackgroundColor(Color c) {
		this.frame.setBackground(c);
	}
	
	public Color getBackgroundColor() {
		return this.frame.getBackground();
	}
	
	public boolean isPaused() {
		return paused;
	}
	
	public void addWindowListener(WindowListener listener) {
		frame.addWindowListener(listener);
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
