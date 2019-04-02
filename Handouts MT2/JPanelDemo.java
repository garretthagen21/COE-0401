// CS 0401 Fall 2017
// This handout demonstrates extending the JPanel class to encapsulate and
// access information in a graphical environment.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JPanelDemo
{
	private JFrame theWindow;
	private LabelButton [] thePanels; // See LabelButton.java
	private JButton countClicks;
	
	public JPanelDemo(String [] labels)
	{
		// Create the window and all of the LabelButton panels.  Note how
		// the number of LabelButton panels is variable, and the FlowLayout
		// will handle an arbitrary number.	
		theWindow = new JFrame("Subclassing JPanels");
		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theWindow.setLayout(new FlowLayout());
		thePanels = new LabelButton[labels.length];
		for (int i = 0; i < labels.length; i++)
		{
			thePanels[i] = new LabelButton(labels[i]);
			theWindow.add(thePanels[i]);
		}
		// A separate button is put after the panels to count
		// how many of the encapsulated buttons have been clicked.  See
		// details of the listener below.
		countClicks = new JButton("Count the Clicks");
		countClicks.setFont(new Font("Serif", Font.BOLD, 30));
		countClicks.addActionListener(new ClickListener());
		theWindow.add(countClicks);
		//theWindow.setSize(800,600);
		theWindow.pack();
		theWindow.setVisible(true);
	}
	
	class ClickListener implements ActionListener
	{
	 	// Listener to check how many of the buttons within the JPanels have
	 	// been clicked.  Note how we iterate through the panels, calling a
		// method in each panel to test for this, since we cannot access
		// the buttons directly (because they are encapsulated within the
		// JPanel subclasses)
		public void actionPerformed(ActionEvent e)
		{
			int count = 0;
			for (LabelButton b: thePanels)
			{
				boolean ans = b.getStatus();
				if (ans)
					count++;
			}
			JOptionPane.showMessageDialog(theWindow, count + " of the buttons are clicked");
		}
	}

	// Pass the command line arguments to the constructor.  This simply allows the user
	// to pass values in for the labels in the panels.  Note that the labels don't really
	// do anything in this handout -- they are just there to show you how to pass the
	// information into the objects.
	public static void main(String [] args)
	{
		new JPanelDemo(args);
	}
}