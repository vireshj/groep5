public class Lied {
//zoiets?
	String naam;
	String artiest;
	String album;
	String genre;
	
	public Lied(String naam, String artiest){
		this.naam = naam;
		this.artiest = artiest;
		this.album = "";
		this.genre = "";
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
	public void setGenre(String genre){
		this.genre = genre;
	}
	public String getGenre(){
		return this.genre;
	}
	
	
}
