// CS 401 Fall 2017
// MyDeque class to implement a simple deque
// Complete the methods indicated.  Be careful about the
// special cases indicated.  See lab for details on how
// to implement the methods.

public class MyDeque implements SimpleDeque
{
	Object [] theData;
	int numItems;
	

	public MyDeque(int maxItems)
	{
		theData = new Object[maxItems];
		numItems = 0;
	}
	
	public boolean isEmpty()
	{
		return (numItems == 0);
	}
	
	public void addFront(Object X)
	{
		// Add new item at front of list (shifting old items
		// to right first).  If the list is full, do not add
		// the item (just do nothing).
	if(numItems==theData.length) {
		return;
	}
		for(int i=numItems-1;i>=0;i--) {
			theData[i+1]=theData[i];		//shift everything into new array
			}
		theData[0]=X; //put new object in 1st spot
		numItems++;
	  
	}

	public void addRear(Object X)
	{
		// Add new item at rear of list.  If the list is full,
		// do not add the item (just do nothing).
		
		
		if(numItems==theData.length){
			return;
		}
		theData[numItems]=X;
		numItems++;
		
		
	}

	public Object removeFront()
	{
		// Remove and return front item from list, shifting remaining
		// items to the left to fill the spot.  If list is empty,
		// return null.
	if(this.isEmpty()) {
		return null;
	}
	Object old = theData[0];
	for(int i=1;i<numItems;i++) {
		theData[i-1]=theData[i];		
		}
	numItems--;
	return old; //put new object in 1st spot
	
	
	
	}

	public Object removeRear()
	{
		if(this.isEmpty()) {
			return null;
		}
		numItems--;
		return theData[numItems];
		// Remove and return rear item from list.  If list is empty,
		// return null.
		
	}
}