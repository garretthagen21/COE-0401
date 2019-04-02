// CS 0401 Fall 2017
// Demonstration of object output streams in Java

import java.io.*;
import java.util.*;
public class ex25a
{
	public static void writeData(Object [] Ar, ObjectOutputStream outStream)
												throws IOException
	{
		for (Object data: Ar)
			outStream.writeObject(data);
	}

	public static void main(String [] args) throws IOException
	{
		String [] S = {	"Talking Heads", "Midnight Oil", 
						"Metallica", "Tori Amos", "Sarah McLachlan"};
		Integer [] A = new Integer[7];
		for (int i = 0; i < A.length; i++)
			A[i] = new Integer((i * 5)%(A.length));
		
		
		Scanner fScan = new Scanner(new File("songs.txt"));
		int numAlbums = Integer.parseInt(fScan.nextLine()); 
		PlayListSerial [] myPlayLists = new PlayListSerial[numAlbums];
		for (int i = 0; i < myPlayLists.length; i++)
		{
			String aTitle = fScan.nextLine();
			String rDate = fScan.nextLine();
			int numSongs = Integer.parseInt(fScan.nextLine());
			SongSerial [] theSongs = new SongSerial[numSongs];
			for (int j = 0; j < theSongs.length; j++)
			{
				String songString = fScan.nextLine();
				String [] songInfo = songString.split(",");
				SongSerial currSong = new SongSerial(songInfo[0], songInfo[1], songInfo[2],
					songInfo[3]);
				theSongs[j] = currSong;
			}
			PlayListSerial thePlayList = new PlayListSerial(aTitle, rDate, theSongs);
			myPlayLists[i] = thePlayList;
		}

		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("objectData.out"));
		writeData(S, os);  // Write objects from arrays to the file
		writeData(A, os);
		writeData(myPlayLists, os);
		
		os.writeObject(S);  // Write entire arrays to the file with one statement
		os.writeObject(A);
		os.writeObject(myPlayLists);
		os.close();
	}
}