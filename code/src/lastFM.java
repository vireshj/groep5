import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import de.umass.lastfm.Tag;
import de.umass.lastfm.Track;


public class lastFM {
	private static final String apiKey = "9b24762f4ec58fed178083b4d9f255c2";
	//Zoekt een lied in de lastFM database op lied-nummer en artiest
	public static Lied searchSong(String song, String artists){
		Track gevonden = Track.getInfo(artists, song, apiKey);
		return new Lied(gevonden.getName(), gevonden.getArtist(), gevonden.getAlbum(), gevonden.getTags());
		//return new Lied(gevonden.getName(), gevonden.getArtist(), gevonden.getAlbum(), null);
	}
	//retourneerd op basis van een Lied instantie similar liedjes.
	public static ArrayList<Lied> similarSongs(Lied invoer){
		Collection<Track> liedjes = Track.getSimilar(invoer.getArtiest(), invoer.getNaam(), apiKey);
		ArrayList<Lied> similar = trackToLied(liedjes);
		return similar;	
	}

	public static ArrayList<Lied> getTopTracks(Tag tag)
	{
		Collection<Track> liedjes = Tag.getTopTracks(tag.getName(), apiKey);
		ArrayList<Lied> topTracks = trackToLied(liedjes);
		return topTracks;
	}

	public static ArrayList<Lied> trackToLied(Collection<Track> tracks)
	{
		ArrayList<Lied> liedjes = new ArrayList<Lied>();
		Iterator<Track> x = tracks.iterator();
		int i = 0;
		while(x.hasNext() && i < 10){
			Track lastInput = x.next();
			i++;
			Track gevonden = Track.getInfo(lastInput.getArtist(), lastInput.getName(), apiKey);
			Lied input = new Lied(gevonden.getName(), gevonden.getArtist(), gevonden.getAlbum(), gevonden.getTags());
			liedjes.add(input);
		}

		return liedjes;
	}
	
}
