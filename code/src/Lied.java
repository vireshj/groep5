import java.util.Collection;

public class Lied {
	String naam;
	String artiest;
	String album;
	Collection<String> tag;
	boolean tagNotNull = false;
	String mbid;
	
	public Lied(String track)
	{
		String[] gegevens = track.split(",");
		this.naam = gegevens[1];
		this.artiest = gegevens[0];
		this.album = "";
	}
	
	public Lied(String naam, String artiest){
		this.naam = naam;
		this.artiest = artiest;
		this.album = "";
		//this.tag = null;
	}
	public Lied(String naam, String artiest, String album, Collection<String> tag, String mbid){
		this.naam = naam;
		this.artiest = artiest;
		this.album = album;
		this.tag = tag;
		this.mbid = mbid;
		if(tag != null){
			this.tagNotNull = true;
		}
	}
	public void setNaam(String naam){
		this.naam = naam;
	}
	public String getNaam(){
		return naam;
		
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
	public Collection<String> getTag(){
		return this.tag;
	}
	public String getMBID(){
		return this.mbid;
	}
	
	public String toString()
	{
		return this.artiest + "," + this.naam;
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Lied)
		{
			Lied that = (Lied) obj;
			return that.getArtiest().equals(this.artiest) && that.getNaam().equals(this.naam);
		}
		return false;
		
	}
	
	
}
