// CS 0401 Fall 2017
// Subclass of MyAList that keeps the data sorted.  See MyAList.java and additional
// comments below.
public class SortAList extends MyAList
{
	// no new data.  Data inherited from MyAList is
	// protected Object [] data;
	// protected int size;
	// All methods are also inherited from MyAList.  However, some of them are
	// overridden as shown below.  This means that the new definition in this class
	// will replace the one from the superclass.  In order for this to work the method
	// specification in the superclass and the subclass must be IDENTICAL.
	
	// Call superclass constructors.  Since there is no new data in SortAList, we
	// don't need any new assignments within the subclass.
	public SortAList(int init)
	{
		super(init);
	}
	
	public SortAList()
	{
		super();
	}
	
	// Override the add() method to now add the item into the correct
	// location by sorted order.  Note that this requires the data to implement
	// the Comparable interface, since otherwise the cast would throw an exception.
	// Note also that compiling this class will give a warning since we are using
	// "old style" generics here.  A safer way to implement both this class and the
	// superclass (MyAList) is via parameterized types.  However, these are not trivial
	// to understand fully so we will leave these until later (and CS 0445 also).
	public boolean add(Object val)
	{
		if (size == data.length)	// resize if necessary
			resize(2 * size);
		// Start in the back of the array.  Push the new item down into the array as
		// long as it is less than the current item.
		int loc = size;
		for (int i = size-1; i >= 0; i--)
		{
			// Cast the argument to the Comparable interface.  Note that if the argument
			// type does NOT in fact implement the Comparable interface, this code will
			// throw an exception when the program is executed.
			Comparable test = (Comparable) val;
			int result = test.compareTo(data[i]);
			if (result >= 0)	// New item is >= current item, so the new item should
			{					// go in the next index to the right.  Break out of loop
				loc = i+1;
				break;
			}
			else	// New item is < current item so move that item down one and keep going
				data[i+1] = data[i];
		}
		data[loc] = val;	// Place new item and increment size
		size++;
		return true;
	}
	
	// This version of add() must also be overridden, but in this case we override it
	// to throw an exception, since we can no longer add an item into an arbitrary location
	public boolean add(int loc, Object val)
	{
		throw new UnsupportedOperationException("Cannot add to arbitrary index in SortedList");
	}
	
	// We must override this method to move the item that has been set into its correct
	// location by sorted order.  This can be done in various ways.  Note that here I am
	// doing it by simply removing and then adding the item -- not a very efficient way
	// (think about why this is the case) but definitely the easiest to code.  Alternatively,
	// the programmer may prefer to not allow this operation at all, similar to what is done
	// with the add(loc, val) method above.
	public Object set(int loc, Object val)
	{
		if (loc >= 0 && loc < size)
		{
			Object old = remove(loc);
			add(val);
			return old;
		}
		return null;
	}
}		