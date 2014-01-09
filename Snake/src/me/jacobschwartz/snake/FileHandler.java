package me.jacobschwartz.snake;

//De n�dvendige classer importeres, til senere brug i programmet
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Denne classe benyttes til at h�ndtere alle interaktioner mellem programmet og filsystemet
public class FileHandler {
	
	public FileHandler(){
		
		
		
	}
	
	//Denne metode bruges til at skrive til en ny fil
	public boolean writeFile(String fileName, String content){
		
		//Da dele af den f�lgende kode ikke med sikkerhed kan udf�res korrekt, bruger vi en try blok, s� fejl kan fanges
		try{
			
			//Vi �rklerer et diverse objekter, som skal h�ndtere datastr�mmen til filen
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter outFile = new PrintWriter(bw);
			
			//Data sendes til filen
			outFile.print(content);
			
			//Datastr�mmen lukkes efter brug, og metoden returnere true, som indikere at alt gik godt. Metoden er slut
			outFile.close();
			return true;
			
		}catch(IOException error){
			
			//Der er blevet fanget en fejl i forbindelse med filh�ndterringen, og en fejlbeksed udskrives
			System.out.println("Der skete en fejl under skrivningen til filen!");
			
		}
		
		//Metoden blev ikke udf�rt korrekt, og den returnere derfor false
		return false;
	}
	
	//Denne metode bruges til at tilf�je indhold, til slutningen af en allerede eksisterende fil
	public boolean writeAddFile(String fileName, String content){
		
		File f = new File(fileName);
		if(!f.exists()){
			
			writeFile(fileName, "");
			
		}
		
		//Da dele af den f�lgende kode ikke med sikkerhed kan udf�res korrekt, bruger vi en try blok, s� fejl kan fanges
		try{
			
			//Der �rkleres en variabel, og indholdet af den ellerede eksisterende fil indl�ses
			String oldContent = readFile(fileName);
			
			//Hvis der blev indl�st data fra filen, tilf�jes den nye data til slutningen af den indl�ste data, ellers indeholder content blot den nye data
			if(oldContent != null){
				content = oldContent+content;
			}
			
			//Vi �rklerer et diverse objekter, som skal h�ndtere datastr�mmen til filen
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter outFile = new PrintWriter(bw);
			
			//Data sendes til filen
			outFile.print(content);
			
			//Datastr�mmen lukkes efter brug, og metoden returnere true, som indikere at alt gik godt. Metoden er slut
			outFile.close();
			return true;
			
		}catch(IOException error){
			
			//Der er blevet fanget en fejl i forbindelse med filh�ndterringen, og en fejlbeksed udskrives
			System.out.println("Der skete en fejl under h�ndteringen af filen");
			
		}
		
		//Metoden blev ikke udf�rt korrekt, og den returnere derfor false
		return false;
	}
	
	//Denne metode bruges til at l�se fra en fil
	public String readFile(String fileName){
		
		File f = new File(fileName);
		if(!f.exists()){
			
			writeFile(fileName, "");
			
		}
		
		//Der �rkleres en variabel til at indeholde data fra filen
		//Variablen starter med at v�re tom
		String fileContent = "";
		
		//Da dele af den f�lgende kode ikke med sikkerhed kan udf�res korrekt, bruger vi en try blok, s� fejl kan fanges
		try{
			
			//Vi �rklerer et diverse objekter, som skal h�ndtere datastr�mmen fra filen
			FileReader fr = new FileReader(fileName);
			BufferedReader inFile = new BufferedReader(fr);
			
			//Den f�rste linje i filen indl�ses
			String line = inFile.readLine();
			
			//S� l�nge der er nye linjer i filen forts�tter metoden med at indl�se dem
			while(line != null){
				
				//Den indl�ste linje tilf�jes til variablen som indeholder filens data
				fileContent += line+"\n";
				
				//Den n�ste linje i filen indl�ses, hvis der ikke er flere linjer bliver variablen = null
				line = inFile.readLine();
				
			}
			
			//Datastr�mmen lukkes efter brug, og metoden returnere filens data. Metoden er slut
			inFile.close();
			return fileContent;
			
		}catch(FileNotFoundException error){
			
			//Filen blev ikke fundet, og der udskrives en fejlbesked til brugeren
			System.out.println("Filen blev ikke fundet");
			
		}catch(IOException error){
			
			//Der er blevet fanget en fejl i forbindelse med filh�ndterringen, og en fejlbeksed udskrives
			System.out.println("Der opstod en fejl, mens filen skulle indl�ses");
			
		}
		
		//Metoden blev ikke udf�rt korrekt, og den returnere derfor null
		return 	null;
		
	}
	
}
