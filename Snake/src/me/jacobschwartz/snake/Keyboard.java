package me.jacobschwartz.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter{
	
	public int direction = 3;//1:venstre, 2:ned, 3:højre, 4:op
	public boolean pause = false;
	public boolean gamePaused = false;

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println("Keyboard pressed");
		switch(key){
		
			case 'a':
				direction = gamePaused ? direction : 1;
				break;
			case 'A':
				direction = gamePaused ? direction : 1;
				break;
			case KeyEvent.VK_LEFT:
				direction = gamePaused ? direction : 1;
				break;
			case 's':
				direction = gamePaused ? direction : 2;
				break;
			case 'S':
				direction = gamePaused ? direction : 2;
				break;
			case KeyEvent.VK_DOWN:
				direction = gamePaused ? direction : 2;
				break;
			case 'd':
				direction = gamePaused ? direction : 3;
				break;
			case 'D':
				direction = gamePaused ? direction : 3;
				break;
			case KeyEvent.VK_RIGHT:
				direction = gamePaused ? direction : 3;
				break;
			case 'w':
				direction = gamePaused ? direction : 4;
				break;
			case 'W':
				direction = gamePaused ? direction : 4;
				break;
			case KeyEvent.VK_UP:
				direction = gamePaused ? direction : 4;
				break;
			case 'p':
			case 'P':
				System.out.println("Pause");
				pause = true;
				break;
		}
		
	}

}
