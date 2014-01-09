package me.jacobschwartz.snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameLoop implements ActionListener {
	
	private Screen screen;
	private Board board;
	private Menu menu;
	public Snake snake;
	private Timer gameTimer;
	private Keyboard in;
	private Food food;
	public int points = 0;
	public int[] snakeY;//Slangens Y positioner, 2500 er max mulige slange dele
	public int[] snakeX;//Slangens X positioner, 2500 er max mulige slange dele
	public int snakeLength;
	public FileHandler file;
	public boolean gamePaused = false;
	
	public GameLoop(){

		screen = new Screen();
		
		in = new Keyboard();
		snake = new Snake();
		food = new Food(this);
		
		screen.addKeyListener(in);
		
		board = new Board();
		menu = new Menu(this);
		menu.formatNewGame();
		
		file = new FileHandler();
		
		board.snakeLength = snake.snakeLength;
		board.snakeX = snake.snakeX;
		board.snakeY = snake.snakeY;
		board.foodX = food.locX;
		board.foodY = food.locY;
		
		snakeLength = snake.snakeLength;
		snakeX = snake.snakeX;
		snakeY = snake.snakeY;
		
		screen.add(board);
		screen.add(menu);
		screen.setContentPane(menu);
		screen.pack();
		
		gameTimer = new Timer(100, this);
		
	}
	
	public void startGame(){
		
		snake.snakeLength = 5;
		snake.snakeX[4] = 24;
		snake.snakeY[4] = 25;
		snake.snakeX[3] = 25;
		snake.snakeY[3] = 25;
		snake.snakeX[2] = 26;
		snake.snakeY[2] = 25;
		snake.snakeX[1] = 27;
		snake.snakeY[1] = 25;
		snake.snakeX[0] = 28;
		snake.snakeY[0] = 25;
		
		snake.currentDirection = 3;
		in.direction = 3;
		
		board.snakeLength = snake.snakeLength;
		board.snakeX = snake.snakeX;
		board.snakeY = snake.snakeY;
		
		snakeLength = snake.snakeLength;
		snakeX = snake.snakeX;
		snakeY = snake.snakeY;
		
		screen.setContentPane(board);
		screen.requestFocus();
		screen.invalidate();
		screen.validate();
		screen.repaint();
		gameTimer.start();
		
	}
	
	public void stopGame(){
		
		file.writeAddFile("highscores.txt", points+";");
		
		gameTimer.stop();
		menu.formatGameOver();
		screen.setContentPane(menu);
		screen.invalidate();
		screen.validate();
		screen.repaint();
		System.out.println(points);
		System.out.println(snake.snakeLength);
		
	}
	
	public void pauseGame(){
		
		gamePaused = true;
		board.gamePaused = true;
		in.gamePaused = true;
		
	}
	
	public void resumeGame(){
		
		gamePaused = false;
		board.gamePaused = false;
		in.gamePaused = false;
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(in.pause){
			
			System.out.println("loop pause");
			
			if(gamePaused){
				
				resumeGame();
				in.pause = false;
				
			}else{
				
				pauseGame();
				in.pause = false;
				
			}
			
		}
			
		if(!gamePaused){
		
			if((food.locX == snake.snakeX[0]) && (food.locY == snake.snakeY[0])){
				
				food.placeFood();
				snake.snakeLength++;
				
				System.out.println("Snake ate food");
				
			}
			
			snake.changeDirection(in.direction);
			
			board.snakeLength = snake.snakeLength;
			board.snakeX = snake.snakeX;
			board.snakeY = snake.snakeY;
			board.foodX = food.locX;
			board.foodY = food.locY;
			
			snakeLength = snake.snakeLength;
			snakeX = snake.snakeX;
			snakeY = snake.snakeY;
		
		}
		
		points = (snake.snakeLength-5)*10;
		screen.setTitle("Snake - "+points+" points");
		
		board.repaint();
		
		if(snake.checkDeath()){
			
			stopGame();
			
		}
		
	}

}
