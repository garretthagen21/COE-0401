// CS 0401 Fall 2017
// Demonstration of array resizing
import java.util.Scanner;
public class ResizeDemo
{
	// Make a new array that is double the size of the argument array, then
	// copy the data from the old array into the new one and return it.
	public static double [] resize(double [] oldA)
	{
		int oldL = oldA.length;
		int newL = 2 * oldL;
		double [] newA = new double[newL];
		for (int i = 0; i < oldA.length; i++)
			newA[i] = oldA[i];
		return newA;
	}
	
	public static void showData(double [] Ar, int n)
	{
		System.out.println("Here is the data: ");
		for (int i = 0; i < n; i++)		// Note that our loop bound is now n
		{						// rather than Ar.length, since the array may
								// not be completely full
			System.out.println("\t" + i + ": " + Ar[i]);
		}
	}
		
	public static void main(String [] args)
	{
		Scanner inScan = new Scanner(System.in);
		double [] A;  // array to store data
		double curr;
		int cap = 4; // capacity of array
		int num = 0; // number of items currently in the array
		
		A = new double[cap];  // Initial capacity of the array
		
		System.out.println("Please enter a non-negative number (negative to quit)");
		curr = inScan.nextDouble();
		while (curr >= 0)
		{
			if (num == A.length)
				A = resize(A);
			A[num] = curr;
			num++;
			System.out.println("Please enter a non-negative number (negative to quit)");
			curr = inScan.nextDouble();
		}
		showData(A, num);
		System.out.println("The current physical length of the array is " + A.length);
	}
}