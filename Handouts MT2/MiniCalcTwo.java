// CS 401 Fall 2017
// Modifying example from Pohl McDowell text to allow multiplication
// and division.  See also DoMathInt.java, DoMathIntCheck.java and
// DoMathIntCheck2.java and some more comments below.

import java.awt.*;
import javax.swing.*;

class MiniCalcTwo {
  public static void main(String[] args) {
    JFrame frame = new JFrame("MiniCalcTwo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = frame.getContentPane();
    // create the major components
    JTextField firstNumber = new JTextField(20);
    JTextField secondNumber = new JTextField(20);
    JTextField result = new JTextField(20);
    JButton addButton = new JButton("Add");
    JButton subButton = new JButton("Subtract");
    JButton multButton = new JButton("Multiply");
    JButton divButton = new JButton("Divide");
    // there will be 5 rows of 2 components each
    pane.setLayout(new GridLayout(5, 2));
    // add all of the components to the content pane
    pane.add(new JLabel("Enter a number"));
    pane.add(firstNumber);
    pane.add(new JLabel("Enter a number"));
    pane.add(secondNumber);
    pane.add(new JLabel("Result"));
    pane.add(result);
    pane.add(addButton);
    pane.add(subButton);
    pane.add(multButton);
    pane.add(divButton);
    // Setup the listener, listening to the buttons
    // For command argument "1", use the listener with no exception
	// handling.  For argument "2" use the listener with exception
	// handling / overflow detection.  For any other argument, use
	// the "updated" exception handling version, which uses some
	// methods in Java 1.8
	  if (args[0].equals("1"))
	  {
		  DoMathInt listener = 
			  new DoMathInt(firstNumber, secondNumber, result);
		  subButton.addActionListener(listener);
		  addButton.addActionListener(listener);
		  multButton.addActionListener(listener);
		  divButton.addActionListener(listener);
	  }
	  else if (args[0].equals("2"))
	  {
		  DoMathIntCheck listener = 
			  new DoMathIntCheck(firstNumber, secondNumber, result);
		  subButton.addActionListener(listener);
		  addButton.addActionListener(listener);
		  multButton.addActionListener(listener);
		  divButton.addActionListener(listener);
	  }
	  else
	  {
		  DoMathIntCheck2 listener = 
			  new DoMathIntCheck2(firstNumber, secondNumber, result);
		  subButton.addActionListener(listener);
		  addButton.addActionListener(listener);
		  multButton.addActionListener(listener);
		  divButton.addActionListener(listener);
	  }
    frame.pack();
    frame.setVisible(true);
  }
}