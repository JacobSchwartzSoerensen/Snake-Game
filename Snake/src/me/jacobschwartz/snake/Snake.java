package me.jacobschwartz.snake;

public class Snake {
	
	public int[] snakeY = new int[2500];//Slangens Y positioner, 2500 er max mulige slange dele
	public int[] snakeX = new int[2500];//Slangens X positioner, 2500 er max mulige slange dele
	public int snakeLength = 0;//Slangens længde
	public int currentDirection = 3;//Slangens nuværende retning. 1:venstre, 2:ned, 3:højre, 4:op
	public boolean snakeGrow = false;
	
	public Snake(){
		
		snakeLength = 5;
		snakeX[4] = 24;
		snakeY[4] = 25;
		snakeX[3] = 25;
		snakeY[3] = 25;
		snakeX[2] = 26;
		snakeY[2] = 25;
		snakeX[1] = 27;
		snakeY[1] = 25;
		snakeX[0] = 28;
		snakeY[0] = 25;
		
		System.out.println("Snake initiated");
		
	}
	
	public void changeDirection(int direction){
		
		if((direction+2) != currentDirection && (direction-2) != currentDirection){
			
			snakeMove(direction);
			
		}else{
			
			snakeMove(currentDirection);
			
		}
		
	}
	
	private void snakeMove(int direction){
		
		for(int x=(snakeLength-1);x>=0;x--){
			
			snakeX[x+1] = snakeX[x];
			
		}
		
		for(int x=(snakeLength-1);x>=0;x--){
			
			snakeY[x+1] = snakeY[x];
			
		}
		
		switch(direction){
		
			case 1:
				snakeX[0] = snakeX[1]-1;
				snakeY[0] = snakeY[1];
				break;
			case 2:
				snakeX[0] = snakeX[1];
				snakeY[0] = snakeY[1]+1;
				break;
			case 3:
				snakeX[0] = snakeX[1]+1;
				snakeY[0] = snakeY[1];
				break;
			case 4:
				snakeX[0] = snakeX[1];
				snakeY[0] = snakeY[1]-1;
				break;
		}
		
		currentDirection = direction;
		
	}
	
	public boolean checkDeath(){
		
		if(snakeY[0]>=50 || snakeY[0]<0 || snakeX[0]>=50 || snakeX[0]<0){
			
			System.out.println("Snake hitted the wall");
			return true;
			
		}
		
		for(int x=1;x<snakeLength;x++){
			
			if(snakeX[0] == snakeX[x] && snakeY[0] == snakeY[x]){
				
				System.out.println("Snake ate itself");
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
}
