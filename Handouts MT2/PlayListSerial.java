// CS 0401 Fall 2017
// This handout is identical to PlayList.java, with the exception of PlayList now being
// Serializable.  To implement this, I only had to do the following:
//		1) State that PlayList implements Serializable
//		2) Make Song Serializable (new class SongSerial)
// Classes String and Date are already Serializable

// I have removed previous comments

import java.util.*;  // needed for Date
import java.text.*;  // needed for DateFormat
import java.io.*;	 // for Serializable

public class PlayListSerial implements Comparable<PlayListSerial>, Serializable
{
	private String title;
	private SongSerial [] songList; // Using a Serializable version of the
									// Song class -- see SongSerial.java
	private Date releaseDate;
	private int tracks;
	private int length;

	public PlayListSerial(String t, String d, SongSerial [] songs)
	{
		title = new String(t);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		try
		{
			releaseDate = df.parse(d);
		}
		catch (ParseException e)
		{
			releaseDate = null;
		}
		tracks = songs.length;
		length = 0;
		songList = new SongSerial[songs.length];
		for (int i = 0; i < songList.length; i++)
		{
			songList[i] = songs[i];
			length += songList[i].getLength();
		}
	}

	public String toString()
	{
		StringBuilder S = new StringBuilder();
		S.append("PlayList: " + title + "\n");
		if (releaseDate != null)
		{
			S.append("Release Date: " + releaseDate.toString() + "\n");
		}
		else
		{
			S.append("No release date \n");
		}
		int min = length / 60;
		int sec = length % 60;
		S.append("Number of tracks: " + tracks + "\n");
		S.append("Length: " + min + " min. " + sec + " sec. \n");
		S.append("Songs: \n");
		for (int i = 0; i < songList.length; i++)
			S.append(songList[i].toString());
		return S.toString();
	}

	public int compareTo(PlayListSerial rhs)
	{
		return (length - rhs.length);
		//return (this.title.compareTo(rhs.title));
	}
}
