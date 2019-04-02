// CS 401 Fall 2017
// Simple example to show a label in a window
import java.awt.*; // This package is needed for the Component and
                   // Font classes
import javax.swing.*; // This package is needed for the JFrame and
                      // JLabel classes

public class ex22a
{
	public static void main(String [] args)
	{
		// Create a JFrame object for the window
		JFrame theWindow = new JFrame("Example 22a");
		// Set it to terminate the program when the window closes
		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theWindow.setVisible(true);

		// Create a JLabel object for the message.  Set the font and the
		// color of the JLabel to make it more interesting
		JLabel theMessage = new JLabel("Hello Graphical World");
		theMessage.setFont(new Font("TimesRoman", Font.ITALIC, 48));
		theMessage.setForeground(Color.RED);

		// Add the JLabel to the JFrame so it can be displayed
		theWindow.add(theMessage);
	
		// Size the window to be 600 pixels wide by 200 pixels high
		// Then show it so it is actually displayed
		theWindow.setSize(600, 200);
		// Alternatively, we can size the window to be big enough to contain
		// whatever is inside it -- this is what pack() does
		//theWindow.pack();
		//theMessage.setFont(new Font("TimesRoman", Font.ITALIC, 60));
		//theWindow.pack();
		System.out.println("Done with main!!");
	}
}
