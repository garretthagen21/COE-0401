// CS 0401 Fall 2017
// Serializable version of the Song class

import java.io.*; // for Serializable
public class SongSerial implements Comparable<SongSerial>, Serializable
{
	// Strings are already Serializable
	private String title;
	private String length;
	private String artist;
	private String genre;

	public SongSerial(String t, String l, String a, String g)
	{
		title = new String(t);
		artist = new String(a);
		length = new String(l);
		genre = new String(g);
	}

	public String toString()
	{
		StringBuffer S = new StringBuffer();
		S.append("Title: " + title + "   ");
		S.append("Length: " + length + "   ");
		S.append("Artist: " + artist + "   ");
		S.append("Genre: " + genre + "\n");
		return S.toString();
	}

	// Convert length to an int and return it.  It is assumed that the String that
	// is the length is formatted: M:S where M and S are both integers.  For more
	// info on the split() method, see the Java API.
	public int getLength()
	{
		String [] MinSec = length.split(":");
		int sec = Integer.parseInt(MinSec[1]);
		sec += (60 * Integer.parseInt(MinSec[0]));
		return sec;
	}

	// Compare 2 songs using their titles
	public int compareTo(SongSerial rhs)
	{
		return (this.title.compareTo(rhs.title));
	}
}
