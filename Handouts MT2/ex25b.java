// CS 0401 Fall 2017
// Demonstration of object input streams in Java

import java.io.*;
import java.util.*;
public class ex25b
{
	public static void showData(Object [] Ar)
	{
		for (Object data: Ar)
			System.out.println(data);
		System.out.println();
	}

	public static void main(String [] args) throws IOException
	{
		ObjectInputStream is = new ObjectInputStream(new FileInputStream("objectData.out"));
		while (true)
		{
			try
			{
				Object nextObject = is.readObject();
				System.out.println("Object is a " + nextObject.getClass());
				if (nextObject.getClass().isArray())
				{
					System.out.println("Object is an array");
					showData((Object []) nextObject);
				}
				else
				{
					System.out.println(nextObject);
				}
			}
			catch (ClassNotFoundException e1)	// This is a checked exception so
			{									// it must be dealt with here
				System.out.println("Uh oh -- no class found");
				break;
			}
			catch (EOFException e2)		// Check for end of file to end program.
			{							// We are catching this as an exception but
						// it is not really an error here -- we are expecting it.
				System.out.println("End of File");
				break;
			}
			catch (IOException e3)
			{
				System.out.println("Some other error");
				break;
			}
		}
		is.close();
	}
}