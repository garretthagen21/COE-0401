// CS 401 Fall 2017
// Example of encapsulating data using a subclass of JPanel.  Note that
// within this JPanel we have buttons and listeners, handling the events
// internally.  There is also a mutator method (setLabel) and an accessor
// method (getStatus) that can be accessed from outside of the class.

// Note that unlike Counters2.java, in this handout the LabelButton class
// is a public class and completely distinct from the JPanelDemo class.
// Thus, the JPanelDemo class can only communicate with a LabelButton via
// public instance methods.

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LabelButton extends JPanel
{
	private JLabel theLabel;
	private JButton theButton;
	private boolean clicked;

	public LabelButton(String labelS)
	{
		theLabel = new JLabel(labelS);
		theLabel.setHorizontalAlignment(SwingConstants.CENTER);
		theLabel.setFont(new Font("Serif", Font.BOLD, 30));
		theButton = new JButton("Click Me");
		theButton.setFont(new Font("Serif", Font.BOLD, 30));
		clicked = false;
		ActionListener listen = new BListener();
		theButton.addActionListener(listen);
		setLayout(new GridLayout(2,1));
		
		add(theLabel);
		add(theButton);
	}
	
	public void setLabel(String s)
	{
		theLabel.setText(s);
	}
	
	public boolean getStatus()
	{
		return clicked;
	}
		
	// Listener to toggle the status of the panel each time
	// the button is clicked.
	private class BListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			clicked = !clicked;
			if (clicked)
				theButton.setText("Clicked");
			else
				theButton.setText("Click Me");
		}
	}

}