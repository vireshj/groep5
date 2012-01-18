import java.util.Collection;

public class Lied {
	String naam;
	String artiest;
	String album;
	Collection<String> tag;
	boolean tagNotNull = false;
	String mbid;
	/** 
	 * maakt een nieuwe Lied klasse met de meegeven parameter:String track
	 */
	public Lied(String track)
	{
		String[] gegevens = track.split(",");
		this.naam = gegevens[1];
		this.artiest = gegevens[0];
		this.album = "";
	}
	/** 
	 * maakt een nieuwe Lied klasse met de meegeven parameters:String naam, String artiest
	 */
	public Lied(String naam, String artiest){
		this.naam = naam;
		this.artiest = artiest;
		this.album = "";
		//this.tag = null;
	}
	/** 
	 * maakt een nieuwe Lied klasse met de meegeven parameter:String naam, String artiest, String album, Collection<String> tag, String mbid
	 */
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
	/** 
	 * de naam wordt geset naar : String naam
	 */
	public void setNaam(String naam){
		this.naam = naam;
	}
	/** 
	 * Retourneert de naam van het liedje
	 * @return String naam van het leidje
	 */
	public String getNaam(){
		return naam;
		
	}
	/** 
	 * de artiest wordt geset naar : String artiest
	 */
	public void setArtiest(String artiest){
		this.artiest = artiest;
	}
	/** 
	 * Retourneert de artiest van het liedje
	 * @return String Artiest van het liedje
	 */
	public String getArtiest(){
		return artiest;
	}
	/** 
	 * de album van het liedje wordt geset naar:String album
	 */
	public void setAlbum(String album){
		this.album = album;
	}
	/** 
	 * Retourneert de album van het liedje
	 * @return String album van het liedje
	 */
	public String getAlbum(){
		return this.album;
	}
	/** 
	 * de tag van het liedje wordt geset naar : Collection<String> tag
	 */
	public void setTag(Collection<String> tag){
		this.tag = tag;
	}
	/** 
	 * Retourneert de tags van het liedje
	 * @return Collection<String> naam van het leidje
	 */
	public Collection<String> getTag(){
		return this.tag;
	}
	/** 
	 * Retourneert de naam van het liedje
	 * @return String naam van het leidje
	 */
	public String getMBID(){
		return this.mbid;
	}
	/** 
	 * Retourneert de naam van het liedje
	 * @return String naam van het leidje
	 */
	public String toString()
	{
		return this.artiest + "," + this.naam;
	}
	/** 
	 * Retourneert de naam van het liedje
	 * @return String naam van het leidje
	 */
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
