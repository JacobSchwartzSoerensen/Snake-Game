package me.jacobschwartz.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Board extends JPanel{
	
	private static final long serialVersionUID = 5168996171402680925L;
	private Graphics2D g2d;
	private Color snakeColor;//Slangens farve
	private Color foodColor;
	private int snakeDimensions = 10;//Bredte og højden på de firkanter som udgør slangen
	public int[] snakeY = new int[2500];//Slangens Y positioner, 2500 er max mulige slange dele
	public int[] snakeX = new int[2500];//Slangens X positioner, 2500 er max mulige slange dele
	public int foodX;
	public int foodY;
	public int snakeLength = 0;//Slangens længde
	public boolean gamePaused = false;
	
	Board(){
		
		snakeColor = new Color(59,48,28);
		foodColor = new Color(232,90,34);
		setPreferredSize(new Dimension(500,500));
		setBackground(new Color(255, 214, 115));
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//Rektangel som viser banen
		/*g2d.setColor(Color.black);
		g2d.drawRect(0, 0, 500, 500);*/
		
		//Mad
		g2d.setColor(foodColor);
		g2d.fillRect((10*foodX), (10*foodY), 10, 10);
		
		//Slangens dele tegnes i form af firkanter
		g2d.setColor(snakeColor);
		for(int x=0;x<snakeLength;x++){
			g2d.fillRect((10*snakeX[x]), (10*snakeY[x]), snakeDimensions, snakeDimensions);
		}
		
		if(gamePaused){
			
			g2d.setFont(new Font("Verdana", 1, 30));
			g2d.drawString("Game Paused", 140, 200);
			
		}
		
		Toolkit.getDefaultToolkit().sync();
		
	}
	
}
