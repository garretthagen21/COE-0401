// CS 401 Fall 2017
// Simple demonstration of parsing a String into an int.  If the
// String is not a valid representation of an int, an exception
// is thrown.  We will talk more about exceptions a bit later.

public class MyInteger
{
	// Simple integer parse function for non-negative numbers.  This is
	// a simplification of the standard Integer.parseInt() method used
	// in Java
	public static int parseInt(String s)
	{
		int temp = 0;
		for (int i = 0; i < s.length(); i++)
		{
			temp = temp * 10; // Multiply previous answer by 10.  This
			                  // "shifts" the digits to the left
			int newVal = s.charAt(i) - 48;  // Determine the next digit
			if (newVal < 0 || newVal > 9)   // Show an error if the digit
				throw (new NumberFormatException("For string " + s)); // is not valid
			temp = temp + newVal;  // Add the next digit
		}
		return temp;
	}
}