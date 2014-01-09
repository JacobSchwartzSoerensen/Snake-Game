package me.jacobschwartz.snake;

public class Food {
	
	public int locY;
	public int locX;
	public GameLoop parrent;
	public boolean foodOK = true;
	
	public Food(GameLoop initParrent){
		
		parrent = initParrent;
		placeFood();
		
	}
	
	public void placeFood(){
		
		do{
			
			foodOK = true;
			
			locX = (int)(Math.random()*50);
			locY = (int)(Math.random()*50);
			
			for(int x=0;x < parrent.snake.snakeLength && foodOK == true;x++){
				
				if(locX == parrent.snake.snakeX[x] && locY == parrent.snake.snakeY[x]){
					
					foodOK = false;
					
					System.out.println("Tried to place food at the same position as the snake");
					
				}
				
			}
			
		}while(!foodOK);
		
	}
	
}
