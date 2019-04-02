// CS 401 Fall 2017 Lab 7 Main Program
// Your job is to complete this program so that it runs correctly.
// The Movie class and MovieDB class have already been completed for you.
// Utilizing data abstraction, you can access/use these classes without
// having to know their implementation details.  However, since you have
// the code for them you certainly can look at the implementations.
// You just need to write the correct code in the 3 passages below.  Some
// comments indicate what you need to do in each case.
import java.util.*;
import java.io.*;
public class Lab7
{
	public static void main(String [] args) throws IOException
	{
		MovieDB movies = new MovieDB(10); // Create MovieDB object.  The
					// size is set at 10, meaning it can hold up to 10
					// movies.  If we wanted (as discussed in lecture) we
					// could allow for it to be resized so it could hold
					// an arbitrary number of movies.
		loadData(movies);		// input movie data from file
		getCommands(movies);	// interact with user 
		saveData(movies);		// save movie data back to file
	}

	public static void loadData(MovieDB movies) throws IOException
	{
		// Note the syntax below for creating a Scanner to a file
		Scanner S = new Scanner(new FileInputStream("moviesfile.txt"));
	
		// *** CODE SEGMENT 1 *** //
		// Complete this method in the following way:
		// Read in the number of movies from the file
		// For each movie read the data from the file and create a Movie
		// object
		// Add the Movie to the MoviesDB object (movies) using the appropriate
		// method (see MovieDB class)
		int numMovies,i,j=0;
		char exponent='E';
		String title,director,studio,gross;
		double newGross=0,newGrossExp=0,finalGross;
		
		
		numMovies=Integer.parseInt(S.nextLine());
		//System.out.println(numMovies);
		
		for(i=0;i<numMovies;i++) {
			title=S.nextLine();
			//System.out.println(title);
			director=S.nextLine();
			//System.out.println(director);
			studio=S.nextLine();
			gross=S.nextLine();
			StringBuilder grossNum = new StringBuilder();
			StringBuilder grossExp = new StringBuilder();
			
			if(!S.hasNextDouble()){
			
			for(j=0;j<gross.length()-1;j++) {
				if(gross.charAt(j)!=exponent){
				grossNum.append(gross.charAt(j));
				
				}
				else {
				grossExp.append(gross.charAt(j+1));	
				}
			}
			newGross=Double.parseDouble(grossNum.toString());
			newGrossExp=Double.parseDouble(grossExp.toString());
			finalGross=Math.pow(10,newGrossExp)*newGross;
			}
			else {
				finalGross=S.nextDouble();
			}
			//System.out.println(grossNum.toString());
			//System.out.println(grossExp.toString());
			
			//System.out.println(finalGross);
			Movie theMovie = new Movie(title,director,studio,finalGross);
			movies.addMovie(theMovie);
		}
		
		
	}

	public static void getCommands(MovieDB movies)
	{
		Scanner inScan = new Scanner(System.in);
		System.out.println("Enter your choice:");
		System.out.println("1. List movies");
		System.out.println("2. Add new movie");
		System.out.println("3. Find movie");
		System.out.println("4. Quit");
		String choice = inScan.nextLine();
		String movieName,director,studio;
		double gross;
	
		while (true)
		{
			Movie temp;
			if (choice.equals("1"))
			{
				System.out.println(movies.toString());
			}
			else if (choice.equals("2"))
			{
				// *** CODE SEGMENT 2 *** //
				// Complete this choice in the following way:
				// Prompt for and read in each of the values needed
				// for the new Movie object (3 strings, 1 double)
				// Create a new Movie object and then add it to the
				// MovieDB object (movies) using the correct method.
				
				System.out.println("Movie name?: ");
				movieName = inScan.nextLine();
				System.out.println("Director?: ");
				director = inScan.nextLine();
				System.out.println("Studio?: ");
				studio = inScan.nextLine();
				System.out.println("Gross?: ");
				gross=Double.parseDouble(inScan.nextLine());
				Movie theMovie = new Movie(movieName,director,studio,gross);
				movies.addMovie(theMovie);
				
				
				
			}
			else if (choice.equals("3"))
			{
				// *** CODE SEGMENT 3 *** //
				// Complete this choice in the following way:
				// Ask the user for the movie name and read it in
				// Call the appropriate method in the MovieDB object
				// (movies) to find the Movie and return it
				// Show the movie's info (or indicate it is not found)
				
				System.out.println("What is the name of the movie you want to find?: ");
				String movieTitle = inScan.nextLine();
				Movie movieFind=movies.findMovie(movieTitle);
				if (movieFind!=null) {
				System.out.println(movieFind.toString());
				}
				else {
					System.out.println("This movie does not exist!");	
				}
			}
			else
			{
				System.out.println("Good-bye");
				break;  // any other value -- quit
			}
			System.out.println("Enter your choice:");
			System.out.println("1. List movies");
			System.out.println("2. Add new movie");
			System.out.println("3. Find movie");
			System.out.println("4. Quit");
			choice = inScan.nextLine();
		}
	}

	public static void saveData(MovieDB movies) throws IOException
	{
		PrintWriter P = new PrintWriter("moviesfile.txt");
		// Note that we are printing the entire DB to the file with
		// one statement.  This is because the toStringFile() method
		// of the MovieDB class calls the toStringFile() method of
		// each Movie within the DB.
		P.print(movies.toStringFile());
		P.close();
	}
}



