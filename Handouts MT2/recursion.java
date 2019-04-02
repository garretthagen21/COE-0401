/* CS 0401 Fall 2017
   Java Recursion Example
   This example demonstrates some simple recursive methods in Java
*/  
import java.util.Scanner; 
public class recursion
{
	// Method to generate a string of 2N blanks
	public static String get_indent(int N)
	{
		String S = new String("");
		for (int i = 0; i < N; i++)
			S = S + "  ";
		return S;
	}

	// Recursive calculation of N!.  Note that I reject negative numbers by
	// outputting a message and returning -1.  The calling program can test
	// to see if the result is valid if desired.
	public static int fact(int N)
	{
	    if (N < 0)		// Base case -- error (but still a base case)
		{
			System.out.println("Invalid argument");
			return -1;
		}
		else if (N == 0 || N == 1)	// Base case (N = 1 or N = 0).  Note that we are
							// stopping at N = 1 rather than N = 0 to "save"
			return 1;		// an extra recursive call.  More on the efficiency
							// of recursion will be discussed in CS 0445 and
							// CS 1501.
		else
			return (N * fact(N-1));
	}

	// This method does the same calculations as fact above, but with some
	// extra output to trace its behavior.
	public static int fact_trace(int N)
	{
		String indent = get_indent(N);  // Get a string of spaces to show
						// level of the recursive call through indenting

		System.out.println(indent + "Fact: " + N);
		if (N < 0)
		{
			System.out.println(indent + "Invalid argument");
			return -1;
		}
		else if (N <= 1)
		{
			System.out.println(indent + "Base case: N = " + N);
			System.out.println(indent + "Returning " + N + "! = " + 1);
			return 1;
		}
		else
		{
			System.out.println(indent + "Calling " + (N-1) + "!");
			int rec_ans = fact_trace(N-1);
			System.out.println(indent + "Recursive " + (N-1) + "! = " + rec_ans);
			int ans = N * rec_ans;
			System.out.println(indent + "Returning " + N + "! = " + ans);
			return ans;
		}
	}

	// Another simple example of a recursive method.  This one calculates
	// an integer power of some number.  Note the base case and the
	// recursive case below.
	public static int power(int base, int exp)
	{
		if (exp < 0)
		{
			System.out.println("Invalid exponent");
			return 0;
		}
		else if (exp == 0)
			return 1;
		else
			return (base * power(base, exp-1));
	}

	// Iterative method to calculate an integer power.  Compare this
	// code to the recursive version above.  Note that the "base case"
	// here (exp == 0) occurs when the loop does not iterate at all,
	// compared to the recursive code in which no recursive calls are
	// made.  Each iteration of the loop corresponds to a recursive
	// call in our recursive version.
	public static int pow_loop(int base, int exp)
	{
		if (exp < 0)
		{
			System.out.println("Invalid exponent");
			return 0;
		}
		else
		{
			int ans = 1;
			for (int i = 1; i <= exp; i++)
				ans *= base;
			return ans;
		}
	}
	
	// One more recursive method.  This one demonstrates a common practice
	// for programming recursively -- adding an extra method to actually
	// call the recursive method.  Consider functional abstraction as we
	// discussed earlier in the term -- the user of the method does not have
	// to know the implementation details.  In this case, these details
	// include the extra parameters needed for the recursive method.  Thus, 
	// the user call is to a method that then calls the recursive version,
	// where the extra parameters are added.
	public static void reverse(String [] data)
	{
		rec_reverse(data, 0, data.length-1);
	}
	
	// This method reverses a string by storing the first value, then
	// recursively reversing the rest of the array, then putting the
	// stored value into its correct spot (location last-first).  Note
	// that in this instance the base case is just doing nothing -- think
	// of it as reversing an empty array -- to do this you don't need to
	// do anything.
	public static void rec_reverse(String [] data, int first, int last)
	{
		if (first <= last)
		{
			String temp = data[first];
			rec_reverse(data, first+1, last);
			data[last-first] = temp;
		}
	}	

	public static void main (String [] args)
	{
		Scanner inScan = new Scanner(System.in);
		System.out.print("Enter a non-negative number: ");
		int num = inScan.nextInt();
		int ans = fact(num);
		System.out.println(num + "! = " + ans);
		ans = fact_trace(num);
		System.out.println(num + "! = " + ans);

		System.out.print("Enter an int base: ");
		int base = inScan.nextInt();
		System.out.print("Enter an int exponent: ");
		int exp = inScan.nextInt();
		ans = power(base, exp);
		System.out.println(base + " to the " + exp + " = " + ans);
		ans = pow_loop(base, exp);
		System.out.println(base + " to the " + exp + " = " + ans);
		System.out.println();
		
		//String [] values = {"Here", "is", "some", "String", "data", "to", "reverse"};
		String [] values = {"Here", "is", "some", "data"};
		for (String s: values)
			System.out.print(s + " ");
		System.out.println();
		
		reverse(values);
		//rec_reverse(values, 0, values.length-1);
		
		for (String s: values)
			System.out.print(s + " ");
		System.out.println();
	}
}