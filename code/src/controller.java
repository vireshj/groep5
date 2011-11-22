import java.util.ArrayList;


public class controller {
	//hier wordt de gui aangemaakt
	public static void main(String [] args){
		new gui();
	}
	// vind in de database een matching liedje.
	public static void findSong(Lied invoer){
		//hier worden methodes aangeroepen om de ingevoerde liedje te vinden in de db
		Lied gevonden = lastFM.searchSong(invoer.getNaam(), invoer.getArtiest());
		gui.setVerificatie(gevonden);
	}
	//hier worden liedjes gevonden die de gebruiker mogelijk ook leuk zal vinden 
	public static void findSimilarSongs(Lied invoer){
		//methodes anroepen die gelijksoortige liedjes kan vinden op basis van de invoer
		//arraylist vullen van de gui setFeedbackPanel(Lied invoer)
		ArrayList<Lied> songs = lastFM.similarSongs(invoer);
		for(Lied h : songs){
			gui.setFeedbackPanel(h);
		}
	}
}
