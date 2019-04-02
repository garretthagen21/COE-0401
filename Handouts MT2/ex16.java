// CS 0401 Fall 2017
// Demonstration of two versions of the implementing a mixed number class:
// 1) MixedNumber, which uses composition to create the new class
// 2) MixedNumber2, which uses inheritance to create the new class
// See a LOT more comments both below and in the two other class files.
public class ex16
{
	public static void main(String [] args)
	{
		System.out.println("L & L RationalNumber class: ");
		RationalNumber f1 = new RationalNumber(3, 4);
		RationalNumber f2 = new RationalNumber(9, 16);
		RationalNumber f3 = f1.add(f2);

		System.out.println(f1 + " + " + f2 + " = " + f3);

		f1 = new RationalNumber(24, 96);
		f2 = new RationalNumber(16, 22);
		f3 = f1.add(f2);
		System.out.println(f1 + " + " + f2 + " = " + f3);

		f3 = f1.multiply(f2);
		System.out.println(f1 + " * " + f2 + " = " + f3);

		f3 = f1.divide(f2);
		System.out.println(f1 + " / " + f2 + " = " + f3);
		System.out.println();

		System.out.println("Using MixedNumber (composition):");
		MixedNumber m1 = new MixedNumber(4, 24, 7);
		MixedNumber m2 = new MixedNumber(3, 11, 4);
		MixedNumber m3 = m1.add(m2);
		System.out.println(m1 + " + " + m2 + " = " + m3);

		m3 = m1.multiply(m2);
		System.out.println(m1 + " * " + m2 + " = " + m3);

		m3 = m1.divide(m2);
		System.out.println(m1 + " / " + m2 + " = " + m3);
		System.out.println();

		System.out.println("Using MixedNumber2 (inheritance):");
		MixedNumber2 mm1 = new MixedNumber2(4, 24, 7);
		MixedNumber2 mm2 = new MixedNumber2(3, 11, 4);
		MixedNumber2 mm3 = mm1.add(mm2);
		System.out.println(mm1 + " + " + mm2 + " = " + mm3);

		mm3 = mm1.multiply(mm2);
		System.out.println(mm1 + " * " + mm2 + " = " + mm3);

		mm3 = mm1.divide(mm2);
		System.out.println(mm1 + " / " + mm2 + " = " + mm3);

		MixedNumber2 mm4 = mm1.divide(mm2);
		if (mm4.equals(mm3))
			System.out.println(mm3 + " == " + mm4);
		System.out.println();
		
		// Despite the inheritance there are still some limitations to
		// this class if we access it using MixedNumber2 variables. 
		// For example, we cannot pass RationalNumber arguments to any
		// of our MixedNumber2 methods, since MixedNumber2 (subclass)
		// "is a" RationalNumber (superclass) but not vice versa.  Un-
		// comment the statement below to see the error:
		//mm3 = mm1.divide(f1);

		// However, if we use only RationalNumber variables to store
		// our objects, everything works (mostly) as desired! This mix is 
		// not possible with the MixedNumber class, since the "is a" 
		// relationship does not exist.  You will see that one of the great
		// advantages of inheritance (with polymorphism) is how objects
		// in an inheritance chain can be accessed in a consistent way using
		// references of the superclass type.
		
		// However, note that despite the types of the original objects,
		// in these cases the result objects are always RationalNumber,
		// since the RationalNumber versions of the methods are being
		// used.  As an exercise, uncomment the additional version of
		// the add() method in lines 42-48 of MixedNumber2.java.  Then
		// run the program again and see if there is any difference in
		// the types of the result objects.  Think about why this is
		// the case.

		RationalNumber cool1 = new MixedNumber2(3, 4, 5);
		RationalNumber cool2 = new MixedNumber2(4, 5, 6);
		RationalNumber cool3;
		System.out.println("Mixing Types:");
		System.out.println("M2 + M2:");
		cool3 = cool1.add(cool2);
		System.out.println(cool1 + " + " + cool2 + " = " + cool3);
		System.out.println(cool3.getClass());
		System.out.println();
		System.out.println("M2 + R:");
		cool3 = cool1.add(f1);
		System.out.println(cool1 + " + " + f1 + " = " + cool3);
		System.out.println(cool3.getClass());
		System.out.println();
		System.out.println("R + M2:");
		f2 = f1.add(cool1);
		System.out.println(f1 + " + " + cool1 + " = " + f2);
		System.out.println(f2.getClass());
		System.out.println();
		
		cool1 = new MixedNumber2(3, 5, 8);
		f1 = new RationalNumber(29, 8);
		if (cool1.equals(f1))
			System.out.println(cool1 + " == " + f1);
		if (f1.equals(cool1))
			System.out.println(cool1 + " == " + f1);
	}
}