// CS 0401 Fall 2017
// Lab 11
// You must modify this file so that it works as described in the lab handout.
import java.util.*;
import java.io.*;
public class Lab11
{
	public static void main(String [] args)
	{
		Scanner inScan, fScan = null;
		int [] A = new int[5];
		
		inScan = new Scanner(System.in);
		System.out.println("Please enter the file to read from: ");
		
		while(true) {
		
		String fName = inScan.nextLine();
		
		try {
			fScan = new Scanner(new File(fName));
			break;
		} catch (FileNotFoundException e) {
			System.out.println("Your file is invalid please re-enter");
			
		}
		
	}
		
		String nextItem;
		int nextInt = 0;
		int i = 0;
		
		while (fScan.hasNextLine())
		{
			nextItem = fScan.nextLine();
			
		    try {
			nextInt = Integer.parseInt(nextItem);
			A[i] = nextInt;
			//i++;
			}
		    catch(ArrayIndexOutOfBoundsException e) {
				
				int [] B = new int[2*A.length];
				System.out.println("Resizing array from " +A.length+ " to " +B.length);
				for(int q=0;q<A.length;q++) {
					B[q]=A[q];
				}
				A=B;
				A[i]=nextInt;
			}
			catch(NumberFormatException e) {
				System.out.println(nextItem+" is not an integer. Ignored");
				i--;
			}
			
		   finally {
		   i++; 
		   }
		}
			
			
	

		System.out.println("Here are your " + i + " items:");
		for (int j = 0; j < i; j++)
		{
			System.out.println(A[j] + " ");
		}
	}
}
