// CS 0401 Fall 2017
// Demonstration of Method Overriding.  See also the following classes:
// MyAList (in MyAList.java) -- class to implement basic functionality of an ArrayList
// SortAList (in SortAList.java) -- subclass of MyAList that now requires the data in
//		the list to stay in sorted order

public class OverrideDemo
{
	public static void main(String [] args)
	{
		MyAList regList = new MyAList();
		MyAList sortList = new SortAList();
		
		System.out.println("Adding data...");
		for (int i = 0; i < 13; i++)
		{
			Integer newA = new Integer(i * 11 % 13);
			Integer newB = new Integer(i * 11 % 13);
			regList.add(newA);
			sortList.add(newB);
		}
		showData(regList);
		showData(sortList);
		System.out.println();
	
		System.out.println("Changing a value...");
		regList.set(4,new Integer(888));
		sortList.set(4, new Integer(888));
		showData(regList);
		showData(sortList);
		System.out.println();
		
		// remove() was not overridden in SortAList so this method will have
		// the identical effect in both classes
		System.out.println("Removing a value...");
		regList.remove(2);
		sortList.remove(2);
		showData(regList);
		showData(sortList);
		System.out.println();
		
		// Test the add(ind, val) method within a try catch block to see that an
		// exception is thrown in the SortAList version.  We will discuss try catch
		// blocks in a few more lectures.
		System.out.println("Adding at an index...");
		try
		{
			regList.add(6, new Integer(88));
			sortList.add(6, new Integer(88));
		}
		catch (UnsupportedOperationException e)
		{
			System.out.println(e.toString());
		}
		showData(regList);
		showData(sortList);
	}
	
	// Note that the parameter to this method is type MyAList.  However, the SortAList
	// object also works fine here due to the "is a" relationship of a subclass with its
	// superclass.
	public static void showData(MyAList list)
	{
		System.out.print("Contents: ");
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
		System.out.println();
	}
}