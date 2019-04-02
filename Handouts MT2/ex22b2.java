// CS 401 Fall 2017
// Compare to ex22b.  Now I am adding a second JButton with a shared ActionListener.
// Note the behavior when the JButtons are clicked in alternating fashion.
//
// I have removed the previous comments

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  

public class ex22b2
{
	public static void main(String [] args)
	{
		JFrame theWindow = new JFrame("Example 22b2");
		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton theButton1 = new JButton("Change Color");
		theButton1.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 60));
		JButton theButton2 = new JButton("Change Color");
		theButton2.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 60));
		
		// Attach the same listener to both buttons. Since we have only one event
		// listener for two buttons note how the colors change for either button so
		// if you alternate presses the colors for one button will "skip"
		ActionListener listen = new MyListener();
		theButton1.addActionListener(listen);
		theButton2.addActionListener(listen);
	
		theWindow.setLayout(new FlowLayout());
		theWindow.add(theButton1);
		theWindow.add(theButton2);

		theWindow.pack();
		theWindow.setVisible(true);
	}
}

// This class is unchanged from ex22b
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