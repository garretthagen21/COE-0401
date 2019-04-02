// CS 0401 Fall 2017
// Simple class to represent a music playlist.

// The class here is very simple -- containing only a single constructor and
// a toString() method [and compareTo method, which will be discussed later].
// As an exercise you may want to add some additional constructors, accessors
// and mutators.

// See PlayListTest.java for a simple test program.  If you add to this class you
// can also add to PlayListTest.java to demonstrate the new features.

import java.util.*;  // needed for Date
import java.text.*;  // needed for DateFormat
public class PlayList implements Comparable<PlayList> // See more info below
{
	// Note that the primary instance variable within the PlayList class
	// is an array of Song, which is a different class (see Song.java).  
	// The process of using a variable of one class as instance data in
	// another class is COMPOSITION.  The idea is that we are using pre-existing
	// classes to compose a new class.  The functionality of the new class is
	// at least partially based on the functionality of the classes used to build
	// it.
	private String title;
	private Song [] songList;
	private Date releaseDate;  // We are storing the release date as a
	             // Date object.  This will allow us to manipulate it
	             // as a Date if we so choose.  Note that this could be
	             // stored in various ways.  This also demonstrates the idea
	             // of composition.
	private int tracks;  // how many tracks in the PlayList?
	private int length;  // in seconds
	
	public PlayList(String t, String d, Song [] songs)
	{
		title = new String(t);

		// Code below is used to convert a String representation of a
		// date (ex: 10/21/2004) into a Date object.  Don't worry too
		// much about the details at this point (i.e. the
		// DateFormat class and the try - catch block).  We may cover
		// these later.
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
		// Note that the number of tracks is equal to the length of the songs
		// array.  Using this rationale, if we wanted to add or remove a song
		// we would have to make a new array for the songs (since Java array
		// lengths cannot be changed once they are created).  Shortly, we will
		// see how to make the length dynamic, which would allow easy adds and
		// removes of songs.
		
		length = 0;
		// Make a new array for the songs, the copy the songs from the parameter
		// into it.  Use getLength() method to get track lengths in seconds.
		songList = new Song[songs.length];
		for (int i = 0; i < songList.length; i++)
		{
			songList[i] = songs[i];
			length += songList[i].getLength();
		}
	}

	public String toString()
	{
		// Note how the resulting String is created here:  We append many
		// values to a StringBuilder and then output the StringBuilder as a
		// String.  If the object were simpler we could probably avoid
		// using the StringBuilder.
		StringBuilder S = new StringBuilder();
		S.append("PlayList: " + title + "\n");

		// As we discussed in lecture last week, it is good to set reference
		// variables to null if they are not referring to a valid object.
		// That way we can still test the reference.
		if (releaseDate != null)
		{
			S.append("Release Date: " + releaseDate.toString() + "\n");
		}
		else
		{
			S.append("No release date \n");
		}

		// Even though the length is stored as a single integer, users don't
		// typically want to see it represented that way.  Thus, we instead
		// show it as minutes and seconds.
		int min = length / 60;
		int sec = length % 60;
		S.append("Number of tracks: " + tracks + "\n");
		S.append("Length: " + min + " min. " + sec + " sec. \n");
		S.append("Songs: \n");
		// Note here that the toString() for a PlayList includes a call to toString()
		// for each Song in the PlayList.  Even though the method name is the same,
		// the methods are different, since they are called from different
		// objects.
		for (int i = 0; i < songList.length; i++)
			S.append(songList[i].toString());
			
		return S.toString();  // return the String to use as we wish.  Note that
			// toString() is NOT printing out the String.  Rather it is just returning
			// it to the coller.
	}

	public Song [] getSongs()
	{
		// return the Song array
		return songList;  // returns reference to existing Song array
	}
	
	// This method allows us to compare PlayLists in a regular way.  See how it is
	// used in this example.  We will discuss it more formally later.
	public int compareTo(PlayList rhs)
	{
		return (length - rhs.length);
		//return (this.title.compareTo(rhs.title));
	}
}