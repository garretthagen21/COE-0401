import java.io.*;
import java.util.*;


public class Assig3{
	public static void main(String [] args)throws IOException {
	
	//Variable declarations
	Scanner inScan= new Scanner(System.in);
	String userName,doAgain,userGuess;
	boolean keepGoing=true,done=false;
	int numGuesses=3;
	
	System.out.println("Welcome to the Scrambler!");
	System.out.println("Print Your Name: ");
	
		
	userName=inScan.nextLine();
	System.out.print(userName+", ");
	System.out.println("You have " +numGuesses+ " tries to guess the word");
	System.out.println("Good luck!");
	
	
	Scramble theScramble = new Scramble("words.txt");			//create new scrambler object
	Results theResults = new Results("results.txt");			//create new results object
	String word = theScramble.getRealWord();				//get First word
	
while(keepGoing==true) {
	//main loop
	
	
	
	
	
	if (numGuesses<3) {
		 System.out.println("You have " + numGuesses + " tries remaining.");
		}
	
	 System.out.println("Scrambled word is: " + theScramble.getScrambledWord());
	 System.out.println("Your guess is: ");
	 userGuess=inScan.next();
	 userGuess=userGuess.toUpperCase();
	 
	 if (userGuess.equals(word)) {
		 done=true;
		 theResults.won();
		 System.out.println("Congratulations " +userName+ " that is correct!");
		}
	 if(!userGuess.equals(word)) {
		 numGuesses-=1;	//decrease the amount of remaining guesses by 1
		 System.out.println("Sorry " +userName+ ", that is not correct");
	 
		if (numGuesses==0) {
			done=true;
			System.out.println("You have 0 guesses remaining");
			System.out.println("Better luck next time "+userName);
			System.out.println("The actual word was " +word);
			theResults.lost();
		}
		else if (numGuesses>0) {
			 System.out.println("Here are the letters you got correct:");
			 letterCheck(word, userGuess);		//call lettercheck function
		}
	
	 } 
		 
	 
	//continue or show results
	 if(done) {
		System.out.println("Would you like to play another round? (Y/N)");
		doAgain=inScan.next();
		theResults.tried();
			if(doAgain.equals("y") || doAgain.equals("Y")) {
				keepGoing=true;
				done=false;
				numGuesses=3;
				word=theScramble.getRealWord();
				if(word==null) {
					keepGoing=false;
					System.out.println("Congratulations! You Win!");
					System.out.println("Here are your results:\n ");				//If user makes it to the end of the word list
					System.out.println(theResults.toString());
					theResults.save();									//save results to file
					
				}
			}
			else if(doAgain.equals("n") || doAgain.equals("N")) {
				System.out.println("Thanks for playing!");
				keepGoing=false;
				System.out.println("Here are your results:\n ");				//end game and show results
				System.out.println(theResults.toString());
				theResults.save();									//save results to file
				
				
			}
			else {
				System.out.println("Command Not Recognized. Program Terminated.");
				keepGoing=false;
			}
		}
}

	}
	//end of main
	
public static void letterCheck(String word,String guess)	{
	int i;
	StringBuilder check = new StringBuilder();
	
	for(i=0;i<word.length();i++) {
		
		if (word.length()>guess.length()) {
			
			check.append("_"); 				//default for words that are too short
		}
		else if (word.charAt(i)==guess.charAt(i)) {
			check.append(word.charAt(i));
		}
		else {
			check.append("_");
		}
	}
	System.out.println(check.toString());
		
		
	}
	
	
	
}
	
	
	
	
