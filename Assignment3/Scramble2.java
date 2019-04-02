import java.io.*;
import java.util.*;

public class Scramble2{
	
	private int wordSize,count=0;
	private String [] wordList;
	public String realWord,scrambledWord,fileInput;
	private boolean noRepeat=true;
	
	
	
	Scanner wordScan;
	
	
	public Scramble(String w) throws IOException{
		
		fileInput=new String(w);
		wordScan = new Scanner(new File(fileInput));	//open file and tell scanner to read from it
		realWord=null;
		scrambledWord=null;
		wordList=new String[];
		while (wordScan.hasNext()) {
			wordList[count]=wordScan.next();
					
		}
		
		
	}
	
	
	//Get regular word
	public String getRealWord() {
	

	if (wordScan.hasNext() && noRepeat) {	//Only enters if the scrambled method has been called since it's last call
	realWord=wordScan.nextLine();
	realWord=realWord.toUpperCase();
	}
	else if(wordScan.hasNext()==false) {
	realWord=null;
	wordScan.close();
	}
	
	noRepeat=false;
	return realWord;
}
	
	//Get scrambled word
	public String getScrambledWord() {
		
		 
	
		if (realWord!=null && noRepeat==false) {
		wordSize=realWord.length();
		char scrambleChar;
		int i;
		
		//Create String Builder
		
		StringBuilder scrambleBuild1 = new StringBuilder();	
		StringBuilder scrambleBuild2 = new StringBuilder();	 
		
		
		scrambleBuild1.append(realWord);	//build the scrambled word
		
			
		
		
		//test 
		while (scrambleBuild1.length()>0) {        
			
			i=(int)(Math.random()*scrambleBuild1.length());
			
			scrambleChar=scrambleBuild1.charAt(i);
			scrambleBuild2.append(scrambleChar);
			scrambleBuild1.deleteCharAt(i);
			
	           
	        }
	       	scrambledWord=scrambleBuild2.toString();
			
	    
		
		}	
		
		else if(realWord==null) {
			scrambledWord=null;
		}
		
		noRepeat=true;
		return scrambledWord;
	}
	

	
	
}