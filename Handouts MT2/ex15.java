// CS 0401 Fall 2017
// Demonstration of simple inheritance and access restrictions.  Look over
// the various example statements carefully, especially the comments!  I 
// STRONGLY recommend that you experiment with this to see how changing things
// affects the compilation and/or execution.  Here is how I recommend looking
// at this handout:
//      First, look at the code that is NOT commented out to see what can be done
//      Second, look at the commented code and the explanations to see what CANNOT
//           be done and why.
public class ex15
{
	public static void main(String [] args)
	{
		SuperClass sup = new SuperClass(10, 20, 30);
		SubClass sub = new SubClass(5, 15, 25, 35);
		
		System.out.println("sup = " + sup);
		System.out.println("sub = " + sub);

		// Let's use the SuperClass object
		// First we try the mutators
		sup.mutatePri(99);
		sup.mutatePro(88);
		sup.mutatePub(77);
		System.out.println("sup = " + sup);
		
		// The methods below are defined in SubClass and thus do not exist in the
		// SuperClass object
		//sup.mutatePro2(888); 
		//sup.mutateData(999);

		// Now let's try to access the instance variables directly
	 	//sup.pri = 66; // Not legal since pri is private
		sup.pro = 66;	// Wackily legal since pro is in the same directory and
						// in this case considered to be the same package
		sup.pub = 66;  // Since pub is public we can access it directly and this is
					   // legal
		System.out.println("sup = " + sup);

		// Now let's use a SubClass object
		// First we try the mutators
		sub.mutatePri(11);  // These work because they are inherited from SuperClass
		sub.mutatePro(22);
		sub.mutatePub(33);
		System.out.println("sub = " + sub);

		// The mutators below are defined in SubClass and can thus be called here.
		// However, they are redundant since they do the same thing that the inherited
		// methods do.  When using inheritance, make sure not to "reinvent the wheel".
		sub.mutatePri2(12);
		sub.mutatePro2(23);
							
		// This method mutates data that was added in SubClass and thus does not exist
		// in the SuperClass.  To mutate the subData variable we need this method.
		sub.mutateData(44);
		//sub.subData = 55; // Not legal since subData is private
		
		System.out.println("sub = " + sub);

		// Now let's use a SuperClass variable to access a SubClass object.  Due to the
		// isa relationship this is legal.
		sup = sub;  // Works fine since subclass "isa" superclass
		sup.mutatePri(100);  // These methods also are fine
		sup.mutatePro(200);
		
		// The method below, however is NOT accessible even though it exists in the 
		// SubClass object.  This is because the reference is SuperClass and it only
		// "sees" the SuperClass methods.  THIS IS VERY IMPORTANT!
		//sup.mutateData(999);
										
		sub = (SubClass) sup;	// Must cast since superclass is not
		sub.mutateData(999);	// necessarily subclass.  Now we can again
								// access subclass methods.  Note that the object
								// never changes here.  What is changing is the
								// type of the reference used to access it.
								
		sup = new SuperClass(10,20,30);
		//sub = (SubClass) sup;  // This time the cast is NOT legal, since the
				// object is not a SubClass object.  However,
				// the compiler does not know the cast is illegal during
				// compilation, so this is a run-time error.  Try it!
				
		// Now accessing a subclass of SubClass.
		Subby ssuub = new Subby(1,2,3,4,5);
		System.out.println("ssuub = " + ssuub);
		ssuub.mutatePri(11);  // inherited from SuperClass
		ssuub.mutateData(44); // inherited from SubClass
		System.out.println("ssuub = " + ssuub);
		
		sup = ssuub;  // ok since a Subby object isa SuperClass object
		//ssuub.subbyData = 10; // error because subbyData is private
		//sup.subbyData = 10; // error because subbyData does not exist from
								// SuperClass point of view.  Uncomment and
								// try these!
		//sup.mutateData(777);  // error because mutateData does not exist from
								// SuperClass point of view
								
		// Look at the output for the method below and you will see that all of the
		// data (including SubData and Subby) is output, even though the reference is
		// SuperClass. At first it may seem like this should be an error, but it is
		// actually fine due to method overriding, which we will discuss very soon.
		System.out.println("sup = " + sup);
		sub = ssuub;  // also ok because Subby isa SubClass
		sub.mutateData(777);  // This is ok since mutateData exists in SubClass
		System.out.println("sub = " + sub);
		Subby newref = (Subby) sub;  // reference now matches object
	}
}