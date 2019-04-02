import java.io.*;
import java.util.*;

public class Voter{
	
	
	
	private String voterName;
	private String voterID;
	private boolean hasVoted;
	
	
	
	
	
public Voter(String ID, String name,String voteStat){	//Constructor
				
	voterID=new String(ID);
	voterName=name;
    hasVoted=Boolean.parseBoolean(voteStat);
	
	
}

public static Voter getVoter(String voteFile, String ID)//throws FileNotFoundException
{
	
	Scanner voterScan=null;
	try {
		voterScan = new Scanner(new File(voteFile));
	} catch (FileNotFoundException e) {
		//e.printStackTrace();
	}
	
	
	while(voterScan.hasNextLine()) {
		
		String voteLine=voterScan.nextLine();		//Read in the line
		String[]voterLine=voteLine.split(":");	//Split it up by the colons
		
		if(voterLine[0].equals(ID)) {
			Voter theVoter=new Voter(voterLine[0],voterLine[1],voterLine[2]);	 
			return theVoter;                                                     //create new voter object and return it
		}
		
		
	}
	voterScan.close();
	return null;
	
}

	
	
public String toString() {
	StringBuilder stats = new StringBuilder();
	stats.append("ID: " +voterID);
	stats.append(" \tName: "+voterName);
	stats.append(" \tHas Voted?: "+String.valueOf(hasVoted));
	

	return stats.toString();
	
}

public String getName() {
	return voterName;
}

public String getId() {
	return voterID;
}

public boolean hasVoted() {
	return hasVoted;
}

public void vote() {
	hasVoted=true;
}

public static String toStringFile(Voter Vot) {
	StringBuilder toFile = new StringBuilder();
	toFile.append(Vot.getId()+":"+Vot.getName()+":"+String.valueOf(Vot.hasVoted())+"\n");
	return toFile.toString();
}


public static void saveVoter(String voteFile, Voter Vo) {
	ArrayList<Voter> allVoters = new ArrayList<Voter>();
	String[] singleVoterStats = null;
	Scanner voterScan=null;
	PrintWriter voterPrint=null;
	File mainFile = new File(voteFile);
	File copyFile = new File("temptext.txt");
	
	try {
		voterScan = new Scanner(mainFile);
		voterPrint=new PrintWriter(copyFile);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	allVoters.add(Vo);											//add the voter to new file
	
	while(voterScan.hasNextLine()) {
		String voteLine=voterScan.nextLine(); //Read in the line
		singleVoterStats=voteLine.split(":");
		
		if(!(singleVoterStats[0].equals(Vo.getId()))){
			allVoters.add(new Voter(singleVoterStats[0],singleVoterStats[1],singleVoterStats[2]));
		}
		
	}
	
	for(int i=0;i<allVoters.size();i++) {
		voterPrint.print(toStringFile(allVoters.get(i)));				//print voters to new file
	}
	
	
	if (copyFile.exists()) {								//delete OG File and rename the temporary file
		mainFile.delete();
		copyFile.renameTo(mainFile);
	}
	
	voterScan.close();
	voterPrint.close();
		

  }


	
	
}