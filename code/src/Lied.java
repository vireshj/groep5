import java.util.Collection;

import de.umass.lastfm.Tag;

public class Lied {
//zoiets?
	String track;
	String artiest;
	String album;
	Collection<String> tag;
	
	public Lied(String naam, String artiest){
		this.track = naam;
		this.artiest = artiest;
		this.album = "";
	}
	public Lied(String naam, String artiest, String album, Collection<String> tag){
		this.track = naam;
		this.artiest = artiest;
		this.album = album;
		this.tag = tag;
	}
	public void setNaam(String naam){
		this.track = naam;
	}
	public String getNaam(){
		return track;
		
	}
	public void setArtiest(String artiest){
		this.artiest = artiest;
	}
	public String getArtiest(){
		return artiest;
	}
	public void setAlbum(String album){
		this.album = album;
	}
	public String getAlbum(){
		return this.album;
	}
	public void setTag(Collection<String> tag){
		this.tag = tag;
	}
	public Collection<Tag> getTag(){
		return this.tag;
	}
	
	
}
