// CS 401 Fall 2017
// Compare to ex22b2. I am still using two buttons but now instead of a shared
// ActionListener I have a separate listener for each JButton.  Compare alternating
// button clicks in this version vs. ex22b2.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  

public class ex22b3
{
	public static void main(String [] args)
	{
		JFrame theWindow = new JFrame("Example 22b3");
		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton theButton1 = new JButton("Change Color");
		theButton1.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 60));
		JButton theButton2 = new JButton("Change Color");
		theButton2.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 60));
		
		// Since we don't use the listeners for anything other than the JButtons,
		// we don't actually need an ActionListener variable here.  Rather, we can
		// just create the object "on the fly" in the addActionListener() method
		// call.  Now we are creating a separate MyListener object for each button
		// so the colors are separate for each button.
		theButton1.addActionListener(new MyListener());
		theButton2.addActionListener(new MyListener());
	
		theWindow.setLayout(new FlowLayout());
		theWindow.add(theButton1);
		theWindow.add(theButton2);

		theWindow.pack();
		theWindow.setVisible(true);
	}
}

// This class is unchanged from ex22b2
class MyListener implements ActionListener
{
	static Color [] theColors = {Color.RED, Color.BLUE, Color.CYAN, Color.YELLOW,
								 Color.ORANGE, Color.MAGENTA, Color.GREEN};
	private int index = 0;

	public void actionPerformed(ActionEvent e)
	{
		JButton theEventer = (JButton) e.getSource();
		theEventer.setForeground(theColors[index]);
		index = (index + 1) % theColors.length;
		theEventer.setBackground(theColors[index]);
	}
}