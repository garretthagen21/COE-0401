// CS 401 Fall 2017
// Additional ArrayList demo showing sharing of references.
// Be careful!

import java.util.*;  // ArrayList is in the java.util package
public class ArrayLb
{
	public static void main(String [] args)
	{
		ArrayList<StringBuilder> A = new ArrayList<StringBuilder>();
		
		StringBuilder entry = new StringBuilder("This is fun!");
		for (int i = 0; i < 5; i++)
		{
			A.add(entry);  // Adding the same StringBuilder 5 times
						   // This means that 5 locations in the
						   // ArrayList refer to the same StringBuilder
		}
	
		System.out.println("ArrayList A contains: ");
		for (StringBuilder X: A)
			System.out.println(X.toString());
		System.out.println();
		
		// Now let's mutate!
		for (int i = 0; i < A.size(); i++)
		{
			A.get(i).append(" index " + i);
		}
		
		for (StringBuilder X: A)
			System.out.println(X);
		System.out.println();
		
	}
}