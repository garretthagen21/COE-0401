import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class Assig4 implements LoginInterface,VoteInterface
{
	private JFrame theWindow;
	private String vFileName;
	private String voterID;
	private String voterName;
	private Voter P;
	private LoginPanel logPan;
	private JButton login;
	private JButton newVoter;
	private BallotPanel ballots;
	private JButton startButton;
	private JPanel loginPanel;
	private JPanel startPanel;
	private JLabel startLabel;
	private JLabel loginText;
	private String ballotFile;
	private EventListener theListener;
	
	public Assig4(String[]theFiles)
	{
		theWindow = new JFrame();
		theWindow.setLayout(new GridLayout(1,2));
		vFileName = theFiles[0];
		ballotFile =theFiles[1];
		//vFileName="voters.txt";
		//ballotFile="ballots2.txt";
		loginPanel=new JPanel();													//Create and initialize everything
		loginPanel.setLayout(new BoxLayout(loginPanel,BoxLayout.Y_AXIS));
		loginText=new JLabel("Welcome to the Vote Machine");
		loginText.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
		login = new JButton("Click to Login");
		newVoter = new JButton("Add new Voter");
		loginPanel.add(loginText);
		loginPanel.add(login);
		loginPanel.add(newVoter);
		login.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 30));
		newVoter.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 30));
		theListener= new EventListener();
		login.addActionListener(theListener);
		newVoter.addActionListener(theListener);
		theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theWindow.add(loginPanel);
		theWindow.pack();
		theWindow.setVisible(true);
		ballots = new BallotPanel(ballotFile, this);
	     startPanel = new JPanel();
	     startPanel.setLayout(new BoxLayout(startPanel,BoxLayout.Y_AXIS));
	      startButton = new JButton("Click to Vote");
	      
          startButton.setFont(new Font("Serif", Font.BOLD, 30));
          startButton.setEnabled(true);
	      startButton.addActionListener(theListener);
          theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      theWindow.setLayout(new FlowLayout());
	      theWindow.pack();
    
	}

	
	public void setVoter(Voter newVoter)
	{
		P = newVoter;
		theWindow.remove(logPan);
		startPanel=new JPanel();
		startPanel.setLayout(new BoxLayout(startPanel,BoxLayout.Y_AXIS));
		startLabel=new JLabel("Welcome, "+P.getName());
		startLabel.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 15));
		startPanel.add(startLabel);
		startPanel.add(startButton);
		theWindow.add(startPanel);
		theWindow.pack();
	}
	public void voted() {
		theWindow.setVisible(false);
		theWindow.remove(ballots);
		theWindow.add(loginPanel);
		theWindow.pack();
		theWindow.setVisible(true);
		JOptionPane.showMessageDialog(theWindow, "Saving back to file...");
		P.vote();
		Voter.saveVoter(vFileName, P);
		JOptionPane.showMessageDialog(theWindow, "Thanks for Voting, "+P.getName()+" !");
		
	}

	
	private class EventListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==login) {
			logPan = new LoginPanel(vFileName, Assig4.this);
			theWindow.remove(loginPanel);
			theWindow.add(logPan);
			theWindow.pack();
			}
			if(e.getSource()==newVoter) {
				JFrame tempFrame = new JFrame();
				voterID=JOptionPane.showInputDialog(theWindow, "Enter voter ID");
				
				
				if(Voter.getVoter(vFileName, voterID)==null) {
				voterName=JOptionPane.showInputDialog(theWindow, "Enter voter Name");
				Voter Vo=new Voter(voterID,voterName,"false");
				Voter.saveVoter(vFileName,Vo);
			     }
				else {
					JOptionPane.showMessageDialog(theWindow, "Voter already exists! Please Login");
				}
				theWindow.pack();
			}
			if(e.getSource()==startButton) {
				theWindow.remove(logPan);
				theWindow.remove(startPanel);
				theWindow.add(ballots);
				ballots.resetBallots();
				theWindow.pack();
			}
			
		}
	}
	
	public static void main(String [] args)
	{
		new Assig4(args);
	}


	
}