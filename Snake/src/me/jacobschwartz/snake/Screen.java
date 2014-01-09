package me.jacobschwartz.snake;

import javax.swing.JFrame;

public class Screen extends JFrame{
	
	private static final long serialVersionUID = 8677895360924454228L;
	Board board;
	
	Screen(){
		
		
		
		initUI();
		
	}
	
	public void initUI(){
		
		setTitle("Snake");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		System.out.println("Screen object created, and window made");
		
	}

}
