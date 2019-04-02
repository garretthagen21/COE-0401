// CS 0401 Fall 2017
// Compare to DoMathIntCheck.java
//
// In this version we are using some features of Java 1.8 to
// test for overflow.  This will not work in Java 1.7 or earlier

import javax.swing.*;
import java.awt.event.*;

class DoMathIntCheck2 implements ActionListener {

  DoMathIntCheck2(JTextField first, JTextField second,
         JTextField result)
  {
    inputOne = first;
    inputTwo = second;
    output = result;
  }
  public void actionPerformed(ActionEvent e) {
	  int first, second;

	  try
	  {
		  first = Integer.parseInt(inputOne.getText().trim());
		  second = Integer.parseInt(inputTwo.getText().trim());
		  
		  // The Math class in Java 1.8 has some arithmetic methods that
		  // test for overflow.  These will throw an exception if the result
		  // of the operation will overflow an int (there are also versions
		  // that take long arguments)
		  if (e.getActionCommand().equals("Add"))
		  {
			  int ans = Math.addExact(first, second);
			  output.setText(String.valueOf(ans));
		  }
		  else if (e.getActionCommand().equals("Subtract"))
		  {
		  	  int ans = Math.subtractExact(first, second);
			  output.setText(String.valueOf(ans));
		  }
		  else if (e.getActionCommand().equals("Multiply"))
		  {
			  int ans = Math.multiplyExact(first, second);
			  output.setText(String.valueOf(first * second));
		  }
		  else
			  output.setText(String.valueOf(first / second));
	  }
	  // This exception can occur when the strings are being
	  // parsed.  Pass the error into the output textfield.
	  catch (NumberFormatException e2)
	  {
		  output.setText(e2.toString() + ":operand is not a legal integer");
	  }
	  
	  // Now this exception will be caught if either overflow occurs or if
	  // division by zero occurs.  The toString() method will show the specific
	  // exception to the user
  	  catch (ArithmeticException e4)
	  {
		  output.setText(e4.toString());
	  }

  }
  private JTextField inputOne, inputTwo, output;
}