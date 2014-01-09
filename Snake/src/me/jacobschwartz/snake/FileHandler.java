package me.jacobschwartz.snake;

//De nødvendige classer importeres, til senere brug i programmet
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Denne classe benyttes til at håndtere alle interaktioner mellem programmet og filsystemet
public class FileHandler {
	
	public FileHandler(){
		
		
		
	}
	
	//Denne metode bruges til at skrive til en ny fil
	public boolean writeFile(String fileName, String content){
		
		//Da dele af den følgende kode ikke med sikkerhed kan udføres korrekt, bruger vi en try blok, så fejl kan fanges
		try{
			
			//Vi ærklerer et diverse objekter, som skal håndtere datastrømmen til filen
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter outFile = new PrintWriter(bw);
			
			//Data sendes til filen
			outFile.print(content);
			
			//Datastrømmen lukkes efter brug, og metoden returnere true, som indikere at alt gik godt. Metoden er slut
			outFile.close();
			return true;
			
		}catch(IOException error){
			
			//Der er blevet fanget en fejl i forbindelse med filhåndterringen, og en fejlbeksed udskrives
			System.out.println("Der skete en fejl under skrivningen til filen!");
			
		}
		
		//Metoden blev ikke udført korrekt, og den returnere derfor false
		return false;
	}
	
	//Denne metode bruges til at tilføje indhold, til slutningen af en allerede eksisterende fil
	public boolean writeAddFile(String fileName, String content){
		
		File f = new File(fileName);
		if(!f.exists()){
			
			writeFile(fileName, "");
			
		}
		
		//Da dele af den følgende kode ikke med sikkerhed kan udføres korrekt, bruger vi en try blok, så fejl kan fanges
		try{
			
			//Der ærkleres en variabel, og indholdet af den ellerede eksisterende fil indlæses
			String oldContent = readFile(fileName);
			
			//Hvis der blev indlæst data fra filen, tilføjes den nye data til slutningen af den indlæste data, ellers indeholder content blot den nye data
			if(oldContent != null){
				content = oldContent+content;
			}
			
			//Vi ærklerer et diverse objekter, som skal håndtere datastrømmen til filen
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter outFile = new PrintWriter(bw);
			
			//Data sendes til filen
			outFile.print(content);
			
			//Datastrømmen lukkes efter brug, og metoden returnere true, som indikere at alt gik godt. Metoden er slut
			outFile.close();
			return true;
			
		}catch(IOException error){
			
			//Der er blevet fanget en fejl i forbindelse med filhåndterringen, og en fejlbeksed udskrives
			System.out.println("Der skete en fejl under håndteringen af filen");
			
		}
		
		//Metoden blev ikke udført korrekt, og den returnere derfor false
		return false;
	}
	
	//Denne metode bruges til at læse fra en fil
	public String readFile(String fileName){
		
		File f = new File(fileName);
		if(!f.exists()){
			
			writeFile(fileName, "");
			
		}
		
		//Der ærkleres en variabel til at indeholde data fra filen
		//Variablen starter med at være tom
		String fileContent = "";
		
		//Da dele af den følgende kode ikke med sikkerhed kan udføres korrekt, bruger vi en try blok, så fejl kan fanges
		try{
			
			//Vi ærklerer et diverse objekter, som skal håndtere datastrømmen fra filen
			FileReader fr = new FileReader(fileName);
			BufferedReader inFile = new BufferedReader(fr);
			
			//Den første linje i filen indlæses
			String line = inFile.readLine();
			
			//Så længe der er nye linjer i filen fortsætter metoden med at indlæse dem
			while(line != null){
				
				//Den indlæste linje tilføjes til variablen som indeholder filens data
				fileContent += line+"\n";
				
				//Den næste linje i filen indlæses, hvis der ikke er flere linjer bliver variablen = null
				line = inFile.readLine();
				
			}
			
			//Datastrømmen lukkes efter brug, og metoden returnere filens data. Metoden er slut
			inFile.close();
			return fileContent;
			
		}catch(FileNotFoundException error){
			
			//Filen blev ikke fundet, og der udskrives en fejlbesked til brugeren
			System.out.println("Filen blev ikke fundet");
			
		}catch(IOException error){
			
			//Der er blevet fanget en fejl i forbindelse med filhåndterringen, og en fejlbeksed udskrives
			System.out.println("Der opstod en fejl, mens filen skulle indlæses");
			
		}
		
		//Metoden blev ikke udført korrekt, og den returnere derfor null
		return 	null;
		
	}
	
}
