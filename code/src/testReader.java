import java.io.FileReader;
import java.util.*;


public class testReader {
	public static void main(String [] args) {
		//hier wordt de gegevens van de txt file in een arraylist van liedjes gestopt
		ArrayList<Lied> anandport = readFile("/Users/viresh_2090/TUDelft/groep5/documenten/test playlists/test9.txt");
		// deze arraylist bevat uiteindelijk de gevonden liedjes van de user playlist met de lastFM database
		ArrayList<Lied> playlist = new ArrayList<Lied>();
		for(Lied l : anandport){
			Lied tijdelijk = controller.findSong(l);
			if(tijdelijk != null){
				//liedje is gevonden en wordt toegevoegd aan de database
				playlist.add(tijdelijk);
			}
		}
		//als de playlist niet leeg is dan wordt de helft van de playlist weg gehaald en opgeslagen in removedPlaylist
		if(playlist != null)
		{
			ArrayList<Lied> removedPlaylist = new ArrayList<Lied>();
			Random r = new Random();
			int n = playlist.size() / 2;
			while(removedPlaylist.size() < n)
			{
				int random = r.nextInt(playlist.size() - 1);
				Lied l = playlist.get(random);
				if(!removedPlaylist.contains(l))
				{
					removedPlaylist.add(playlist.remove(random));
				}
			}
			// we printen elk liedje uit
			System.out.println("weggelaten nummers:");
			for(Lied l : removedPlaylist){
				System.out.println(l.getArtiest() +" - "+l.getNaam());
			}
			ArrayList<String> tags = new ArrayList<String>();

			for(Lied k : playlist)
			{
				for(String s : k.getTag())
				{
					if(!tags.contains(s))
					{
						tags.add(s);
					}
				}
			}
			// we gaan nu op de playlist met weg gehaalde liedjes een recommandatie uitvoeren
			ArrayList<Lied> result = controller.findSimilarSongsCluster(tags, playlist);
			System.out.println("\nRecommandatie: ");
			for(Lied k : result){
				System.out.println(k.getArtiest()+ " - " + k.getNaam());
			}
			// we gaan nu kijken hoeveel er overeen komen
			int count = 0;
			for(Lied k : result)
			{
				for( Lied z : removedPlaylist)
				{
					//een liedje komt overeen als het dezelde id heeft
					if(z.getMBID().equals(k.getMBID()))
						count++;
				}
			}
			//Hier wordt uitgeprint hoeveel liedjes er terug gevonden zijn
			System.out.println("Matches :\n"+count +"/"+ n);
		}


	}
	//hier wordt de txt file ingelezen
	public static ArrayList<Lied> readFile(String file){
		try {
			ArrayList <Lied> playlist = new ArrayList<Lied>();
			FileReader asa = new FileReader(file);
			Scanner sc = new Scanner(asa);
			String artist;
			String titel = "";
			String buffer;
			while(sc.hasNext()){
				artist = "";
				titel = "";
				artist = sc.next();
				buffer = sc.next();
				while(!buffer.equals("/")){
					artist = artist +" "+ buffer;
					buffer = sc.next();
				}
				buffer = sc.next();
				while(!buffer.equals("/")){
					titel = titel +" "+ buffer;
					buffer = sc.next();
				}
				if(!titel.equals("") && !artist.equals("")){
					playlist.add(new Lied(titel, artist));
				}
			}
			return playlist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
