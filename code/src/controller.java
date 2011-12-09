import java.util.ArrayList;

import de.umass.lastfm.Tag;


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
		gui.setFeedbackPanel(songs);
		
	}
	public static void findSongOntology(Lied invoer){
		Ontology.connection();
		Ontology.findSong(invoer);
		//gui.setVerificatie(Ontology.findSong(invoer));
	}
	public static void findSimilarSongsDecisionTree(ArrayList<Tag> tags){
		ArrayList<Lied> liedjes = new ArrayList<Lied>();
		ArrayList<Lied> tagLiedjes;	
		
		for(Tag tag : tags)
		{
			tagLiedjes = lastFM.getTopTracks(tag);
			for(Lied liedje : tagLiedjes)
			{
				liedjes.add(liedje);
			}
		}
				
		//opbouw v/d decision tree
		DTreeNode prev = new DTreeNode(tags.get(0));
		DTreeNode next;
		for(int i = 1; i < tags.size() - 1; i++)
		{
			next = new DTreeNode(tags.get(i), prev);
			prev = next;
		}
		DTreeNode root = new DTreeNode(tags.get(tags.size() - 1), prev);
		
		//vind 10 meest vergelijkbare liedjes
		ArrayList<Lied> result = root.classify(liedjes, 10);
		gui.setFeedbackPanel(result);		
	}
}
