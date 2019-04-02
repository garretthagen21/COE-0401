// CS 401 Fall 2017
// Subclass of SubClass.  We can extend classes down through as many
// subclasses as we'd like.  Each level "adds" to the previous via new
// variables and methods or overrides a previous method with the same
// header (more on overriding soon).

public class Subby extends SubClass
{
	private int subbyData;

	public Subby(int a, int b, int c, int d, int e)
	{
		super(a,b,c,d);
		subbyData = e;
	}

	public String toString()
	{
		return (super.toString() + " subbyData: " + subbyData);
	}
}