import java.io.*;
import java.util.*;

public class Results{
	
	private int wins;
	private int losses;
	private int tries;
	public String fileOutput;
	
	
	
	
	PrintWriter fileOut;
	
	
	public Results(String w) throws IOException{
		
		fileOutput=new String(w);
		fileOut = new PrintWriter(new File(fileOutput));	//open file to write to
		
		wins=0;
		losses=0;			//initialize variables
		tries=0;
		
	}

	public void won() {
	wins++;	
	}
	public void tried() {
	tries++;	
	}
	public void lost() {
	losses++;	
	}
	public void save() {
		fileOut.println(tries);
		fileOut.println(wins);
		fileOut.println(losses);
		fileOut.close();
		
	}
	public String toString(){
		StringBuilder stats = new StringBuilder();
		stats.append("Rounds tried: "+tries);
		stats.append("\nRounds Won: "+wins);
		stats.append("\nRounds Lost: "+losses);
	
		return stats.toString();
	}
	
	
	
}