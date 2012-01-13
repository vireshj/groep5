import java.util.*;


public class Cluster {
	Collection<String> tags;
	 ArrayList<Lied> songs;
	
	public Cluster(Collection<String> tags, ArrayList<Lied> songs)
	{
		this.tags = tags;
		this.songs = songs;
	}
	
	//methode die een lijst van liedjes omzet naar een lijst van n liedjes met de meeste overlap van tags
	public ArrayList<Lied> cluster(ArrayList<Lied> liedjes , int n)
	{
		//een arraylist voor elk mogelijk aantal van overlap: 0 of 1 of ... of tags.size()
		ArrayList<ArrayList<Lied>> clusters = new ArrayList<ArrayList<Lied>>();
		for(int k = 0; k <= tags.size(); k++)
		{
			clusters.add(new ArrayList<Lied>());
		}
		
		Iterator<String> tagI;
		int count;
		ArrayList<Lied> cluster;
		Collection<String> tagNames;
		Lied liedje;
		//elk liedje afgaan
		for(int i = 0; i < liedjes.size(); i++)
		{
			tagI = tags.iterator();
			count = 0;
			liedje = liedjes.get(i);
			tagNames = liedje.getTag();
			String ss;
			//voor elke tag van het liedje controleren hoeveel er gelijk zijn
			while(tagI.hasNext())
			{
				ss = tagI.next();
				if(tagNames.contains(ss))
				{
					count++;
				}
			}
			//toevoegen aan de bij de count horende lijst
			clusters.get(count).add(liedje);
		}
		ArrayList<Lied> result = new ArrayList<Lied>();
		
		int l = clusters.size() - 1;
		int m;
		ArrayList<String> artiesten = new ArrayList<String>();
		ArrayList<Integer> amount = new ArrayList<Integer>();
		int artiestIndex;
		Lied currentSong;
		//resultaat verkrijgen door liedjes uit de countlijsten toe te voegen totdat er genoeg liedjes in het resultaat staan
		//of tot er geen liedjes meer zijn. Liedjes uit de lijsten met meeste counts worden als eerste gekozen.
		while(result.size() < n && l >= 0)
		{
			cluster = clusters.get(l);
			m = 0;
			while(m < cluster.size() && result.size() < n)
			{				
				currentSong = cluster.get(m);
				//liedjes mogen niet gekozen worden als de gebruiker ze al heeft (songs) 
				//en mogen niet dubbel in het resultaat voorkomen (result)
				if(!songs.contains(currentSong) && !result.contains(currentSong))
				{
					artiestIndex = artiesten.indexOf(currentSong.getArtiest());
					//een artiest mag maximaal 2x voorkomen in een recommendatie
					//en de count van een artiest wordt bijgehouden
					if(artiestIndex >= 0 && amount.get(artiestIndex) < 2)
					{
						result.add(currentSong);
						amount.set(artiestIndex, amount.get(artiestIndex) + 1);
					}else if(artiestIndex < 0)
					{
						result.add(currentSong);
						artiesten.add(currentSong.getArtiest());
						amount.add(1);
					}
				}
				m++;
			}
			l--;
		}
		
		return result;
	}
}
