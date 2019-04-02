import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class LoginPanel extends JPanel{
	
	
	public LoginInterface theInterface;
	public String voteFile;
	public JPanel nestPanel;
	public JLabel header;
	public JButton submit;
	public JTextField voterID;
	

	
	
	 public LoginPanel (String voterFile, LoginInterface L){
		 theInterface=L;
		 voteFile=voterFile;
		 nestPanel=new JPanel();
		 nestPanel.setLayout(new BoxLayout(nestPanel,BoxLayout.Y_AXIS));
		 //nestPanel.setBackground(Color.black);
		 
		 
		 header = new JLabel("Please Enter Voter ID");
		 header.setFont(new Font("Times",Font.BOLD, 30));
		 //header.setForeground(Color.white);
		 //header.setVerticalAlignment(SwingConstants.NORTH);
		 //header.setPreferredSize(new Dimension(20,50));
		 
		 
		 voterID = new JTextField();
		 voterID.setPreferredSize(new Dimension(10,30));
		 //voterID.setHorizontalAlignment(SwingConstants.CENTER);
		 
		 submit = new JButton("Submit");
		 //submit.setHorizontalAlignment(SwingConstants.CENTER);
		 
		 
		 SubmitListener theListener = new SubmitListener();
		 submit.addActionListener(theListener);
		 
		 nestPanel.add(header);					//add components to the nested JPanel
		 nestPanel.add(voterID);
		 nestPanel.add(submit);
		
		 add(nestPanel);   //Add nested panel to the LoginPanel
		
		 
	}
	 

	 

	private class SubmitListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JFrame tempFrame=new JFrame();
				
				Voter V=Voter.getVoter(voteFile,voterID.getText());     //Send voter ID to voter class
				
				if(V==null) {
					JOptionPane.showMessageDialog(tempFrame,"Sorry, but you are not Registered!");
				}
				else if(V.hasVoted()) {
					JOptionPane.showMessageDialog(tempFrame,V.getName()+", you have already voted!");
				}
				else {
					theInterface.setVoter(V);							 //If voter exists send that voter to set voter
				}
				
				
				
				
		}
		
	}
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	