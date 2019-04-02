import java.io.*;
import java.util.*;

public class Boggle{
	
	private Scanner keyboard;
	private int currentPoints;
	private int totalPoints;
	private int numDictWords;
	private int numMatchWords;
	private String [] dictionary = new String[64];
	private String [] matchedWords;
	static char [][] boggleBoard;
	
	
	public Boggle(){
		
		currentPoints = 0;
		totalPoints = 0;
		numDictWords = 0;
		numMatchWords = 0;
		keyboard = new Scanner(System.in);
		createDictionary();
		menu();
	}
	
  private void menu() {
	  
	 
	  
	 System.out.println("\nPlay Options:");
	 System.out.println("p - play the game");
	 System.out.println("c - check word");
	 System.out.println("g - get hint");
	 System.out.println("q - quit");
	 String choice = keyboard.nextLine();
	 ;
	 
	 System.out.println("Choice: "+choice+"\n");
		
	    if (choice.equals("q") || choice.equals("quit")) {
			System.exit(0); 
		}
		else if (choice.equals("p") || choice.equals("play the game")) {
			playGame();
		}
		else if (choice.equals("c") || choice.equals("check word")) {
			
			System.out.println("Enter the word you want to check: ");
			String wordCheck = keyboard.nextLine();
			wordCheck = wordCheck.toUpperCase();
			boolean valid = checkWord(wordCheck);
			
			if (valid)
				System.out.println(wordCheck+" was found in the dictionary");
			else
			 System.out.println(wordCheck+" was NOT found in the dictionary");
			
		}
		else if (choice.equals("g") || choice.equals("get hint")) {
			getHint();
		}
		
			menu();
	
	
	}
	
	private void playGame() {
		System.out.println("This is the play method\n");
		matchedWords = new String[4];								//Initialize arrays
		boggleBoard = new char[4][4];
		printBoggleBoard();
		boolean donePlaying = false;
		
		while (!donePlaying) {
			
			System.out.println("Enter a word you found or press q to quit: ");
			String word = keyboard.nextLine();
			word = word.toUpperCase();
			
			if(word.equals("Q") || word.equals("QUIT")) {				//They are done with the current game so end loop and calculate scores;
				donePlaying = true;
				calculateScores();
			}
			
				boolean validWord = canAddWord(word);
				
				if(validWord) {			//The word is valid so we can add it our list
					if(numMatchWords == matchedWords.length) {		//We have reached the end of the array and need to resize
						System.out.println("Increasing array size by 4: "+(4+matchedWords.length));
						String [] tempMatchedWords = Arrays.copyOf(matchedWords,4+matchedWords.length);		//Make a new array that is 4 larger
						matchedWords = tempMatchedWords;	//update the old time
					}
					
					matchedWords[numMatchWords] = word;				//The array is resized so add the word at the next availible index 
					numMatchWords++;	
					System.out.println(word+ " was added");
				}	
			
		}
	}
	
	private void calculateScores() {
		
		int letterNum;
		boolean letterFound;
		boolean iterateCurrentWord;
		char currentMatchChar;
		String currentMatchWord;
		
		for(int wordNum = 0; wordNum < numMatchWords; wordNum++) {		//Cycles through all of the words in matchedWords array
			char [][] tempBoggleBoard = new char[4][4];
			
			for(int r = 0; r < 4;r++) {
				for(int c = 0; c < 4; c++) {
					tempBoggleBoard[r][c] = boggleBoard[r][c]; 		//Make a new tempBoggle and copy the chars in
			                                     
				}
		 }			                           
		      
			  
			  
			  currentMatchWord = matchedWords[wordNum];			//Current word in matchedWords
		      iterateCurrentWord = true;
		      letterNum = 0;
		      
		        while(iterateCurrentWord) {	//Cycles through all of the letters in our current word from matchedWords array as long as the word has not been deemed invalid
		      		currentMatchChar = currentMatchWord.charAt(letterNum);	//Current char of currentWord
		      		letterFound = false;
		                    
		      		     for(int r = 0; r < 4;r++) {
		      		    	     //System.out.println();
								for(int c = 0; c < 4; c++) {
									
									 if(currentMatchChar == tempBoggleBoard[r][c] && !letterFound) {	//Add the alphabet letter at index of the random number{
											tempBoggleBoard[r][c] = '*';
											letterFound = true;
										 }                                             //Replace the character at this location on the temp board so it cant be used again
									 //System.out.print(tempBoggleBoard[r][c]+ "  ");
								}
								
					        }
		                    
		      		      	//System.out.println(letterFound);
		      		        
		      		      if(!letterFound) {				//If letterfound is never changed to true after searching the entire boggle grid this indicates the word is not valid
	                    	  iterateCurrentWord = false;
	                    	  System.out.println("Testing " +currentMatchWord+" and the score is -1");
	                    	  currentPoints--;
	                    	  }
		      		      else if(letterNum == currentMatchWord.length()-1) {			//We have cycled through all of the letters of the word without failure so move to next word
		                    	  iterateCurrentWord = false;
		                    	  System.out.println("Testing " +currentMatchWord+" and the score is +1" );
		                    	  currentPoints++;
		                   }
		                   
		                    
		                    
		               letterNum++;
	           
		       }	
      	} //End outer for-loop
		
		totalPoints = totalPoints + currentPoints;								//Print results
		System.out.println("\nYour score for this game is: "+currentPoints);
		System.out.println("Your overall score is: "+totalPoints+"\n");
		
		currentPoints = 0;						//Reset the current points
		menu();			//Return to menu
		
		
	}
	
	
	private void printBoggleBoard() {
		char [] alphabet = "ABCDDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();	//Make alphabet char array
			
		
		Random randNumGenerator = new Random();			//Make a new random int generator
		
		for(int r = 0; r < 4;r++) {
			System.out.println(); //Move down a line
			
			for(int c = 0; c < 4; c++) {
				int randInt = randNumGenerator.nextInt(alphabet.length-1);			//Generate a random number
				boggleBoard[r][c] = alphabet[randInt];		//Add the alphabet letter at index of the random number
				System.out.print(boggleBoard[r][c]+ "  ");
			}
		}
		
		System.out.println("\n");
	}
	
	private boolean canAddWord(String word) {
		boolean appropriateLength = checkLength(word);
		boolean noDuplicates = true;
		boolean wordExists = checkWord(word);	//Check to make sure it exists
		
		if(!wordExists) {
			System.out.println(word+" was NOT found in the dictionary. Ignoring");
			return false;
		}
			
		for(int i=0; i < numMatchWords; i++) {
			if(matchedWords[i].equals(word)) {				//Check for duplicates
				noDuplicates = false;
			}
		}
		
		if(!(appropriateLength || noDuplicates)) {				//If either of these conditions are false return false
			System.out.println("The word "+word+" is either a duplicate or not the required length. Ignoring");
			return false;
		}
		
		return true;						//If we reach this point, it means that all of the required conditions are true
		
	}
	
	private boolean checkLength(String word) {
		if(word.length() >=4 && word.length() <= 16)		//Check to make sure it meets length requirements
			return true;
		
		return false;			//else return false
	}
	
	private boolean checkWord(String word) {
		
		for(int i=0; i<numDictWords; i++) {						//Cycle through all of the words in the dictionary
			
			if(word.equals(dictionary[i])) {				//If there is a match tell the user and then return true
			     return true;
			}
		}
		return false;						//return false if the word is never found
	}
	
	private void getHint() {
		System.out.println("Enter the prefix: ");
		String prefixString = keyboard.nextLine();
		prefixString = prefixString.toUpperCase();
		
		for (int i=0; i< numDictWords; i++) {
			String matchSearch = "";
			String dictWord = dictionary[i];
			
			if(prefixString.length() <= dictWord.length())
			   matchSearch = dictWord.substring(0,prefixString.length());	//Find the substring of the dictionary word that is the same length as the prefix we are looking for
			
			 if(matchSearch.equals(prefixString)) {		//If the prefix matches the substring dictionary word then print the entire word
				System.out.println(dictWord);
			}
		}
	}
	
	private void createDictionary() {
		
		System.out.println("Enter the file name to load the dictionary: ");
		String fileName = keyboard.nextLine();
		Scanner dictionaryScan= null;
		
	
		
		try {
		   dictionaryScan = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File Does Not Exist");
		}
		
		while(dictionaryScan.hasNextLine()) {					//Keep reading until there are no words left
			
			String nextWord = dictionaryScan.nextLine().toUpperCase(); //Add the words to array and make all of the words uppercase
			
			if(numDictWords == dictionary.length) {		//We have reached the end of the array and need to resize
				System.out.println("Doubling array size to: "+(2*dictionary.length));
				
				String [] tempDictionary = Arrays.copyOf(dictionary, 2*dictionary.length);		//Make a new array that is double the size of the old one
				dictionary = tempDictionary;	//update the old time
			}
			
			if(checkLength(nextWord)) {			//If the word is the required length, add it and update the word count
				dictionary[numDictWords] = nextWord;
				numDictWords++;
			}
			
		}
		
		//Exit while loop and print statements
		System.out.println("Read file " +fileName+ ", number of words is " +numDictWords+ " dictionary length is " +dictionary.length);
		
	}
  
}

