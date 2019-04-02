/* CS 0401 Fall 2017
   Demonstration of MouseAdapter and WindowAdapter in Java
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Adapt extends JFrame
{
     private JTextArea info;
     private JScrollPane scroller;
     private static int count = 0;  // static variable to keep track of number of
     								// instances of this class

     public Adapt()
     {
            super("Java Adapter Example");
            setLayout(new FlowLayout());
            info = new JTextArea("Beginning Mouse Demo\n",15,30);
                                 // integer arguments are rows and columns
            // Add the JTextArea to a JScrollPane so that we can see new
            // rows past the size of the JTextArea
            scroller = new JScrollPane(info);
            add(scroller);

			// Add a MouseListener and a MouseMotionListener
            addMouseListener(new MyMouseListener());
            addWindowListener(new MyWinListener());
            
            // See what happens if we uncomment this
            //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            
            setSize(640, 480);
            setVisible(true);
            count++;
     }

     public static void main(String [] args)
     {
            Adapt win1 = new Adapt();
            Adapt win2 = new Adapt();
     }

	 // Add new String to JTextArea, then move to the bottom of the text
	 // so you can see the new String without scrolling
     public void appendToText(String t)
     {
     		info.append(t);
     		info.setCaretPosition(info.getDocument().getLength());
     }	
     		
     // Note that only two of the 5 MouseListener methods are implemented here.
     // However, since this class is extending MouseAdapter, the other 3 methods
     // are implemented, but in a trivial way.  This saves the programmer from
     // having to implement all of the methods when all may not be needed.
     private class MyMouseListener extends MouseAdapter
     {
            public void mousePressed(MouseEvent e)
            {
            	double X = e.getX();
            	double Y = e.getY();
                if (e.getButton() == 1)
                    appendToText("Left Mouse Button Pressed at (" + 
                      				X + "," + Y + ") \n");
                else if (e.getButton() == 3)
                	appendToText("Right Mouse Button Pressed at (" + 
                      				X + "," + Y + ") \n");
            }
            public void mouseReleased(MouseEvent e)
            {
                if (e.getButton() == 1)
                      appendToText("Left Mouse Button Released at (" + 
                      				e.getX() + "," + e.getY() + ") \n");
                else if (e.getButton() == 3)
                 	  appendToText("Right Mouse Button Released at (" + 
                      				e.getX() + "," + e.getY() + ") \n");
			}
     }

	 // This class extends WindowAdapter, allowing some WindowEvents to be handled
	 private class MyWinListener extends WindowAdapter
	 {
	 		// This will execute when the window is about to close due to the user
	 		// clicking on the "X".  
	 		public void windowClosing(WindowEvent e)
	 		{
	 			System.out.println("Closing window");
	 			count--;
	 			System.out.println("Count is now " + count);
	 			if (count == 0)
	 			{
	 				System.out.println("No windows left -- quitting program!");
	 				System.exit(0);
	 			}
	 			//new Adapt();
	 		}
	 		
	 		public void windowActivated(WindowEvent e)
	 		{
	 			appendToText("Back in this window!\n");
	 		}
	 		
	 		public void windowDeactivated(WindowEvent e)
	 		{
	 			appendToText("Leaving this window!\n");
	 		}
	 }
}