// CS 0401 Fall 2017
// Demonstration of autoboxing and parsing a String into an integer.  I am
// using both my own version of parseInt and the predefined version from
// the Integer wrapper class. Run this and note what happens when a String that
// does not represent an integer is parsed.  We will later see how to recover 
// from that situation.

// Also demonstrated is processing command line arguments

public class Wrapper
{
	public static void main(String [] args)
	{
		System.out.println("Starting execution");
		Double D1 = 50.0;	// using autoboxing = new Double(50.0)
		Double D2 = new Double(75);  // explicit object creation
		Integer J = 100;	// more autoboxing
		Integer K = 200;
		Integer L = J + K;	// lots of autoboxing here
		L++;				// and here
		System.out.println("L = " + L);
		
		// This line shows the limitations of autoboxing.  If we remove the cast to
		// double the line will give a compilation error.  This is because the system sees
		// two Integer objects on the right and a Double variable on the left.  It is not
		// smart enough to figure out the chain of autoboxing calls in order to get this to
		// work (cast Integer objects to ints, do the addition, then cast the Integer object
		// back to Double.  However, with the cast to double the addition becomes floating
		// point addition and it works. 
		Double W = (double) J + K;
		
		// This one works (again) because the mixed arithmetic yields a double result
		// which can be autoboxed back to Double.
		Double X = D1 + J;
		double y = X; // y = X.doubleValue();
		
		System.out.println("W = " + W);
		System.out.println("Autobox X = " + X + " Y = " + y);

		// Processing values from the command prompt.  Note that this is
		// just like any other array of String in Java.  By default, the
		// delimiter is a space.
		for (int i = 0; i < args.length; i++)
		{
			int curr1 = MyInteger.parseInt(args[i]);
			int curr2 = Integer.parseInt(args[i]);
			System.out.println("MyInteger.parseInt(): " + curr1);
			System.out.println("Integer.parseInt(): " + curr2);
		}
	}
}