import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CandDB{
	ArrayList<CandidateButton> theButtons;
	
	JButton candButton;
	String candName;
	String ballotID;
	int votes;
	
	public CandDB() {
		theButtons = new ArrayList<CandidateButton>();
	}
	public void addCand(CandidateButton c) {
		theButtons.add(c);
	}
	public void reset() {
		for(int i=0;i<theButtons.size();i++) {
			   theButtons.get(i).setBlack();
	}
   }
	public void changeSelection(String B,String N) {
			for(int i=0;i<theButtons.size();i++) {
				if(theButtons.get(i).getID()==B) {
					theButtons.get(i).setBlack();
				}
			}
			for(int i=0;i<theButtons.size();i++) {
				if(theButtons.get(i).getName()==N) {
					theButtons.get(i).turnRed();
				}
			}
			
	
	
	}
	
public void finalTally() {
	
	for(int i=0;i<theButtons.size();i++) {
		if(theButtons.get(i).getStatus()) {
			theButtons.get(i).addVotes();
		}
	}
	
	
}
 public String toString(String s){
	StringBuilder S = new StringBuilder();
	 for(int i=0;i<theButtons.size();i++) {
			
		 if((theButtons.get(i).getID()).equals(s)) {
				S.append(theButtons.get(i).getName()+":"+theButtons.get(i).getVotes()+"\n");
				
			}
			
	 
 }
	 return S.toString();
 }
}