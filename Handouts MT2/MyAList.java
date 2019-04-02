// CS 0401 Fall 2017
// Simple primitive ArrayList-ish class.  See also SortAList.java
public class MyAList
{
	// Data is protected so it can be directly accessed by a subclass
	protected Object [] data;
	protected int size;
	
	public MyAList(int init)
	{
		size = 0;
		data = new Object[init];
	}
	
	public MyAList()
	{
		this(10);
	}
	
	// Add new item at the end of the array
	public boolean add(Object val)
	{
		if (size == data.length)
			resize(2 * size);
		data[size] = val;
		size++;
		return true;
	}
	
	// Add item into arbitrary index, shifting to make room
	public boolean add(int loc, Object val)
	{
		if (loc >= 0 && loc <= size)
		{
			if (size == data.length)
				resize(2 * size);
			for (int i = size; i > loc; i--)
				data[i] = data[i-1];
			data[loc] = val;
			size++;
			return true;
		}
		return false;
	}
	
	// Removed item at stated index, shifting to fill in the gap
	public Object remove(int loc)
	{
		if (loc >= 0 && loc < size)
		{
			Object old = data[loc];
			for (int i = loc; i < size-1; i++)
				data[i] = data[i+1];
			data[size-1] = null;
			size--;
			return old;
		}
		return null;
	}
	
	// Return object at stated index
	public Object get(int loc)
	{
		if (loc >= 0 && loc < size)
			return data[loc];
		else
			return null;
	}
	
	// Assign new value to stated location in list, returning old value
	public Object set(int loc, Object val)
	{
		if (loc >= 0 && loc < size)
		{
			Object old = data[loc];
			data[loc] = val;
			return old;
		}
		return null;
	}		

	// Return logical size of list
	public int size()
	{
		return size;
	}
	
	// Resize list.  Note that this is protected and not public.  We do not want the
	// user to explicitly resize the this -- resizing is an implicit activity that is done
	// as necessary when adding to the list.
	protected void resize(int newSize)
	{
		if (newSize > size)
		{
			Object [] newA = new Object[newSize];
			for (int i = 0; i < size; i++)
				newA[i] = data[i];
			data = newA;
		}
	}
}
