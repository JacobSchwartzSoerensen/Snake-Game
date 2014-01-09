package me.jacobschwartz.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JPanel{

	private static final long serialVersionUID = 1749892077316577628L;
	private JButton quitButton;
	private JButton playButton;
	private JLabel text;
	private JLabel highscore;
	private JLabel hint;
	public boolean startGame = false;
	private GameLoop parent;
	FileHandler file;
	String highscoreFile;
	String[] highscoreStringArray, highscoreNameArray, highscoreNameScoreSplit;
	Integer[][] highscoreIntArray;
	String highscoreFormatted;
	
	Menu(GameLoop initParent){
		
		parent = initParent;
		
		setLayout(null);
		setPreferredSize(new Dimension(500,500));
		
		file = new FileHandler();
		
		text = new JLabel("<html><center>Menu</center><html>");
		text.setFont(new Font("Verdana", Font.BOLD, 20));
		text.setForeground(Color.black);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setBounds(10, 0, 500, 50);
		add(text);
		
		hint = new JLabel("<html><center>Press p to pause</center><html>");
		hint.setFont(new Font("Verdana", Font.BOLD, 12));
		hint.setForeground(Color.black);
		hint.setHorizontalAlignment(SwingConstants.CENTER);
		hint.setBounds(10, 30, 500, 50);
		add(hint);
		
		highscore = new JLabel("<html><center><span style='font-size:20px;font-weight:bold;'>Highscores</span></center><html>");
		highscore.setFont(new Font("Verdana", Font.PLAIN, 16));
		highscore.setForeground(Color.black);
		highscore.setHorizontalAlignment(SwingConstants.CENTER);
		highscore.setBounds(0, 100, 500, 400);
		add(highscore);
		readHighscores();
		
		quitButton = new JButton("Quit Game");
		quitButton.setBounds(260, 100, 100, 30);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		add(quitButton);
		
		playButton = new JButton("Play Again");
		playButton.setBounds(140, 100, 100, 30);
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				parent.startGame();
			}
		});
		add(playButton);
		
		setBackground(new Color(255, 214, 115));
		
		System.out.println("menu");
		
	}
	
	public void formatGameOver(){
		
		text.setText("<html><center>Game over!<br>You got "+parent.points+" points</center></html>");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		
		playButton.setText("Play Again");
		
		readHighscores();
		
	}
	
	public void formatNewGame(){
		
		text.setText("<html><center>Snake</center</html>");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		
		playButton.setText("Start Game");
		
		readHighscores();
		
	}
	
	public void readHighscores(){
		
		highscoreFile = file.readFile("highscores.txt");
		highscoreStringArray = highscoreFile.split(";");
		highscoreNameArray = highscoreStringArray;
		
		for(int x = 0; x < highscoreStringArray.length-1; x++){
			
			//System.out.println(highscoreStringArray[x]);
			
			highscoreNameScoreSplit = highscoreStringArray[x].split(":");
			
			//System.out.println(highscoreNameScoreSplit[0]);
			highscoreNameArray[x] = highscoreNameScoreSplit[0];
			//System.out.println(highscoreNameScoreSplit[1]);
			highscoreStringArray[x] = highscoreNameScoreSplit[1];
			
		}
		
		highscoreFormatted = "";
		highscoreIntArray = new Integer[2][highscoreStringArray.length-1];
		
		for(int x = 0; x < highscoreStringArray.length-1; x++){
			try{
				highscoreIntArray[0][x] = Integer.parseInt(highscoreStringArray[x].trim());
				highscoreIntArray[1][x] = x;
			}catch(NumberFormatException e){System.out.println(e.getMessage());}
		}
		
		Arrays.sort(highscoreIntArray[0], Collections.reverseOrder());
		
		for(int x=0;x<highscoreIntArray.length && x < 10;x++){
			
			highscoreFormatted += (x+1)+". "+highscoreNameArray[highscoreIntArray[1][x]]+" : "+highscoreIntArray[0][x]+"<br>";
			
		}
		
		highscore.setText("<html><center><span style='font-size:20px;font-weight:bold;'>Highscores</span><br>"+highscoreFormatted+"</center><html>");
		
	}
	
}
