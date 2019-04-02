// CS 0401 Fall 2017
// Simple class to demonstrate inheritance and access 
// restrictions.  See also SuperClass.java an Subby.java

public class SubClass extends SuperClass
{
	private int subData; // add extra instance variable
		// Note that the variables pri, pub and pro are also
		// part of this class via inheritance

	public SubClass(int a, int b, int c, int d)
	{
		// This is calling the superclass constructor.  It is not required,
		// but, if used, it must be the FIRST thing done in the subclass
		// constructor.
		super(a, b, c);
		// Since the superclass does not have instance variable subData, we
		// must initialize it directly here
		subData = d;
		// Note that the initialization below will not work because we cannot
		// directly access the private variable pri (it would work for the other
		// variables
		//pri = a; pub = b; pro = c; subData = d;
	}
	
	// The method below cannot be done in the subclass, since access to the
	// private instance variable pri is not allowed.
	/*
	  public void mutatePri2(int a)
	  {
	 		pri = a;
	  }
	*/

	// However, we can rewrite the method to call the mutatePri method from
	// the superclass, and it will work.  BUT, we clearly DON'T NEED to
	// write this method at all, since we can use the mutatePri method directly
	// from the subclass.  One advantage of object-oriented programming is that
	// you don't have to rewrite methods that are already available through
	// inheritance.
	public void mutatePri2(int a)
	{
		//pri = a;
		mutatePri(a);
	}

	// The method below is also unnecessary, for the same reason explained above.
	// However, it is legal since the instance variable is protected rather than
	// private.
	public void mutatePro2(int b)
	{
		pro = b;
	}

	// Method to mutate the new data added in this subclass.  This method does
	// not exist in the superclass.
	public void mutateData(int d)
	{
		subData = d;
	}

	// This method is overriding the toString method of SuperClass.  This means
	// it has the identical method signature of the one in the SuperClass.  We
	// will discuss other implications of overriding methods soon
	public String toString()
	{
		// Since instance variable pri is private, we cannot even print it out
		// from the subclass point of view.  Thus, we get the superclass version
		// of toString to do it -- we then append out additional data at the end
		return (super.toString() + " subData: " + subData);
	}
}	