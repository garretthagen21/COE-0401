import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class BallotPanel extends JPanel{
	CandDB theCands = new CandDB();
	VoteInterface vote;
	Scanner ballotScan;
	String ballotID,ballotCategory;
	String [] ballotCandidates;
	String [] ballotLine;
	String [] ballotChoice;
	int [] ballotVotes;
	String [] ballotSplit;
	int numVotes,j,numBallots;
	
	//GUI
	JPanel theFinalPanel;
	JPanel theSubmitPanel;
	JPanel theBallotPanels;
	JLabel theCategory;
	CandidateButton theCandidateButtons;
	JButton theSubmitButton;
	
	
	
	public BallotPanel(String bFile,VoteInterface v) {
		vote=v;
		try {
			ballotScan = new Scanner(new File(bFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
			theFinalPanel= new JPanel();
			
			
			
			numBallots=Integer.parseInt(ballotScan.nextLine());
			theBallotPanels= new JPanel();
			ballotLine= new String[numBallots];
			ballotChoice = new String[3];
			SelectListener theListener= new SelectListener();			//action listener for clicking
			
			
			
			
			
			for(int i=0;i<numBallots;i++) {
			
			
		    ballotLine[i]=ballotScan.nextLine();		   //Read in the current ballot
			ballotChoice=ballotLine[i].split(":");	   //Split it up current by the colons
			ballotID=ballotChoice[0];		//Assign ballot ID to 0th index and create object associated with that ID
			ballotCategory=ballotChoice[1];				//Assign ballot category to 1st index
			ballotCandidates=ballotChoice[2].split(",");	 //Assign ballotCandidates to an array of the the candidates in the second index of the current ballot                                      
			
			
			
			
			
			
			//GUI
			
			
			theBallotPanels= new JPanel();	//make a new JPanel for the Current ballot
			theBallotPanels.setLayout(new BoxLayout(theBallotPanels,BoxLayout.Y_AXIS));	//Set layout to boxlayout
			
			theCategory = new JLabel(ballotCategory);
			theCategory.setHorizontalAlignment(SwingConstants.LEFT);
			theCategory.setFont(new Font("Serif", Font.BOLD, 30));//create JLabel for category and add it to the panel
			theCategory.setForeground(Color.BLUE);
			theBallotPanels.add(theCategory);
		
			
			
			
			for(j=0;j<ballotCandidates.length;j++) {
				theCandidateButtons=new CandidateButton(ballotCandidates[j],ballotID,theCands); //create the buttons
				theCands.addCand(theCandidateButtons);
				theBallotPanels.add(theCandidateButtons);   //add the buttons to the current panel
				
			}
			
			add(theBallotPanels);					//add the current ballot panel to the panel that shows all of the ballots
			
			
			
			StringBuilder fileBuild = new StringBuilder();					//Make new files for each ballot
			fileBuild.append(ballotID+".txt");
			String fileBuildString=fileBuild.toString();
			File ballotFile= new File(fileBuildString);
			try {														//Initialize vote counts at 0
				ballotFile.createNewFile();
				PrintWriter votePrint = new PrintWriter(ballotFile);
				for(j=0;j<ballotCandidates.length;j++) {
					votePrint.print(ballotCandidates[j]+":"+0+"\n");
			   }
				votePrint.close();
			} catch (IOException e) {
				System.out.println("Problem Creating File");
			}
			
			//System.out.println(ballotID);
			
			
			
		
		}
			theSubmitPanel=new JPanel();
			theSubmitButton = new JButton("Cast Your Vote");
			theSubmitButton.setVerticalAlignment(SwingConstants.CENTER);		
			theSubmitButton.setFont(new Font("Seriff", Font.BOLD, 20));//Create the submit panel and button and add it
			theSubmitPanel.add(theSubmitButton);
			theSubmitButton.addActionListener(theListener);			//add action listener for submit
		    theFinalPanel.add(theSubmitPanel);		
			add(theFinalPanel);							//add the final Panel to be returned to the window
	}
		
	private class SelectListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame tempFrame=new JFrame();
			if(e.getSource()==theSubmitButton) {																//On submit
				int submitAns=JOptionPane.showConfirmDialog(tempFrame, "Are you sure you want to submit?");
				if(submitAns==JOptionPane.YES_OPTION) {
					vote.voted();
					saveBallots();
					
				}
			 }
		}
				
	}
		

			
	

		



	public void resetBallots() {
		theCands.reset();  
	}
	public void saveBallots() {
		theCands.finalTally();
		for(int i=0;i<numBallots;i++) {
			ballotChoice=ballotLine[i].split(":");	
			File OGFile = new File(ballotChoice[0]+".txt");
			File tempFile = new File("tempballotfile.txt");
			StringBuilder fileBuild = new StringBuilder();					//Make new files for each ballot
          	try {														//Initialize vote counts at 0
				tempFile.createNewFile();
				PrintWriter tempPrint = new PrintWriter(tempFile);
				tempPrint.print(theCands.toString(ballotChoice[0]));		
				tempPrint.close();
			} catch (IOException e) {
				System.out.println("Problem Creating File");
			}
		    
		
			
			if (tempFile.exists()) {								//delete OG File and rename the temporary file
				OGFile.delete();
				tempFile.renameTo(OGFile);
			}
			
		
		
		}
		
		
		
	}


}	
