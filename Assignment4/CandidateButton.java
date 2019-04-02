import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;





public class CandidateButton extends JPanel{
	
	CandDB theCands;
	JButton candButton;
	String candName;
	String ballotID;
	int votes;
	boolean clicked;
	
	public CandidateButton(String s,String id,CandDB c) {
		theCands=c;
		candButton = new JButton(s);
		candName=s;
		ballotID=id;
		candButton.setHorizontalAlignment(SwingConstants.CENTER);
		candButton.setFont(new Font("Seriff", Font.BOLD, 20));
		ActionListener clickListen = new ButtonListener();
		candButton.addActionListener(clickListen);
		add(candButton);
		votes=0;
		clicked=false;
	}
	
	
	
	
	public void addVotes(){
		votes++;
	}
	
	public void resetVotes() {
		votes=0;
	}
	public String getName() {
		return candName;
	}
	public JButton getButton() {
		return candButton;
	}
	public String getID() {
		return ballotID;
	}
	public void turnRed() {
		candButton.setForeground(Color.red);
		clicked=true;
	}
	public void setBlack() {
		candButton.setForeground(Color.black);
		clicked=false;
	}
	public boolean getStatus() {
		return clicked;
	}
	public String getVotes() {
		String voteString = Integer.toString(votes);
		return voteString;
	}
	
	class ButtonListener implements ActionListener{
		
		
		public void actionPerformed(ActionEvent e) {
				
		theCands.changeSelection(ballotID,candName);
			        
		}
		
		
		
		
		
		
	}	
		
		
		
}
