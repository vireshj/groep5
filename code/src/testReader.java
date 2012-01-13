import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;


public class testReader {
	public static void main(String [] args) {
		ArrayList<Lied> anandport = readFile("/Users/viresh_2090/TUDelft/groep5/documenten/test_playlists/test2.txt");
		if(anandport != null)
		{
			ArrayList<Lied> removedAnandPort = new ArrayList<Lied>();
			Random r = new Random();
			while(removedAnandPort.size() < 10)
			{
				int random = r.nextInt(anandport.size() - 1);
				Lied l = anandport.get(random);
				if(!removedAnandPort.contains(l))
				{
					removedAnandPort.add(anandport.remove(random));
				}
			}
			ArrayList<String> tags = new ArrayList<String>();
			
			for(Lied k : anandport)
			{
				k = controller.findSong(k);
				for(String s : k.getTag())
				{
					if(!tags.contains(s))
					{
						tags.add(s);
						}
					}
				}
			
			ArrayList<Lied> result = controller.findSimilarSongsCluster(tags, anandport);
			int count = 0;
			for(Lied k : result)
			{
				if(removedAnandPort.contains(k))
				{
					count++;
				}
			}
			System.out.println(count);
		}


	}
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
