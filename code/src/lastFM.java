import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import de.umass.lastfm.Track;


public class lastFM {
	private static final String apiKey = "9b24762f4ec58fed178083b4d9f255c2";
	//Zoekt een lied in de lastFM database op lied-nummer en artiest
	public static Lied searchSong(String song, String artists){
		Track gevonden = Track.getInfo(artists, song, apiKey);
		return new Lied(gevonden.getName(), gevonden.getArtist(), gevonden.getAlbum(), "");
	}
	//retourneerd op basis van een Lied instantie similar liedjes.
	public static ArrayList<Lied> similarSongs(Lied invoer){
		System.out.println(invoer.getNaam());
		ArrayList<Lied> similar = new ArrayList<Lied>();
		Collection<Track> liedjes = Track.getSimilar(invoer.getArtiest(), invoer.getNaam(), apiKey);
		Iterator<Track> x = liedjes.iterator();
		int i = 0;
		while(x.hasNext() && i < 10){
			Track lastInput = x.next();
			i++;
			Lied input = new Lied(lastInput.getName(), lastInput.getArtist(), lastInput.getAlbum(), "");
			similar.add(input);
		}
	return similar;	
	}
}
