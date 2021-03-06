	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.Iterator;
	
	import de.umass.lastfm.Tag;
	
	
	public class controller {
		private static final String apiKey = "9b24762f4ec58fed178083b4d9f255c2";
		/**
		 * maakt de gui aan  
	     */
		//hier wordt de gui aangemaakt
		public static void main(String [] args){
			new gui();
		}
		/** 
	     * Retourneert een Lied die overeenkomt met de parameter Lied invoer
	     * @return de gevonden Lied in de lastFM database
	     */
		// vind in de database een matching liedje.
		public static Lied findSong(Lied invoer)
		{
			Lied gevonden;
			try {
				gevonden = lastFM.searchSong(invoer.getNaam(), invoer.getArtiest());
			}
			catch(Exception e){return null;}
			return gevonden;
		}
		/** 
	     * recommendeer methode die gebruik maakt van de methode van lastFM
	     * @deprecated
	     */
		//recommendeer methode die gebruik maakt van de methode van lastFM
		//gebruikt in eerste iteratie
		public static void findSimilarSongs(Lied invoer){
			//methodes anroepen die gelijksoortige liedjes kan vinden op basis van de invoer
			//arraylist vullen van de gui setFeedbackPanel(Lied invoer)
			ArrayList<Lied> songs = lastFM.similarSongs(invoer);
			gui.setFeedbackPanel(songs);
	
		}
		/** 
	     * recommendeer methode die gebruik maakt van klasse Cluster om de best overeenkomende liedjes te geven  i.v.m. de gegeven lijst
	     * @return een ArrayList van liedjes om de best overeenkomende liedjes te geven  i.v.m. de gegeven lijst
	     */
		//recommendeer methode die gebruik maakt van klasse Cluster om de best overeenkomende liedjes te geven  i.v.m. de gegeven lijst
		//huidige recommendeer methode
		public static ArrayList<Lied> findSimilarSongsCluster(Collection<String> tags, ArrayList<Lied> song)
		{
			ArrayList<Lied> liedjes = new ArrayList<Lied>();
			ArrayList<Lied> tagLiedjes;	
	
			for(String tagName : tags)
			{
				
				Iterator<Tag> i = Tag.search(tagName, apiKey).iterator();
				Tag tag = i.next();
				while(!tag.getName().equals(tagName) && i.hasNext())
				{
					Tag dummy = i.next();
					if(dummy.getName().equals(tagName))
						tag = dummy;
				}
				try{
					tagLiedjes = lastFM.getTopTracks(tag);
				} catch(Exception e){
					//System.out.println(tag.getName());
					tagLiedjes = new ArrayList<Lied>();
				}
				for(Lied liedje : tagLiedjes)
				{				
					liedjes.add(liedje);
				}
			}
			Cluster c = new Cluster(tags, song);
			ArrayList<Lied> result = c.cluster(liedjes, 10);
			gui.setFeedbackPanel(result);
			return result;
		}
		/** 
	     * methode om te klassificeren m.b.v. een decision tree wordt niet meer gebruikt Paramters(Collection<String> tags, Lied song)
	     * @deprecated
	     */
		//methode om te klassificeren m.b.v. een decision tree.
		//wordt niet meer gebruikt
		public static void findSimilairSongsDecisionTree(Collection<String> tags, Lied song){
			ArrayList<Lied> liedjes = new ArrayList<Lied>();
			ArrayList<Lied> tagLiedjes;	
	
			for(String tagName : tags)
			{
				Iterator<Tag> i = Tag.search(tagName, apiKey).iterator();
				Tag tag = i.next();
				while(!tag.getName().equals(tagName) && i.hasNext())
				{
					Tag dummy = i.next();
					if(dummy.getName().equals(tagName))
						tag = dummy;
				}
				try{
					tagLiedjes = lastFM.getTopTracks(tag);
				} catch(Exception e){
					//System.out.println(tag.getName());
					tagLiedjes = new ArrayList<Lied>();
				}
				for(Lied liedje : tagLiedjes)
				{				
					liedjes.add(liedje);
				}
			}
	
			//opbouw v/d decision tree
			Iterator<String> i = tags.iterator();
			DTreeNode prev = new DTreeNode(i.next(), song);
			DTreeNode next;
			DTreeNode root = new DTreeNode(i.next(), prev, song);;
			while(i.hasNext())
			{
				next = root;
				root = new DTreeNode(i.next(), prev,  song);
				prev = next;
			}
	
			//vind 10 meest vergelijkbare liedjes
			ArrayList<Lied> result = root.classify(liedjes, 10);
			gui.setFeedbackPanel(result);		
		}
	}
