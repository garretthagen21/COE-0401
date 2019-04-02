// CS 401 Fall 2017
// Modification to Pohl McDowell textbook example to include 
// multiplication and division, and to use integers rather than 
// doubles as the data.  This listener does no error checking.
// Run the program with this and try some bad input to see what
// happens.

import javax.swing.*;
import java.awt.event.*;

class DoMathInt implements ActionListener {

  DoMathInt(JTextField first, JTextField second,
         JTextField result)
  {
    inputOne = first;
    inputTwo = second;
    output = result;
  }
  public void actionPerformed(ActionEvent e) {
    int first, second;
    first =
        Integer.parseInt(inputOne.getText().trim());
    second =
        Integer.parseInt(inputTwo.getText().trim());
    if (e.getActionCommand().equals("Add"))
      output.setText(String.valueOf(first + second));
    else if (e.getActionCommand().equals("Subtract"))
      output.setText(String.valueOf(first - second));
    else if (e.getActionCommand().equals("Multiply"))
	  output.setText(String.valueOf(first * second));
    else
	  output.setText(String.valueOf(first / second));
  }

  private JTextField inputOne, inputTwo, output;
}