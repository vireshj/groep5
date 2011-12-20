import java.util.*;

import de.umass.lastfm.Tag;


public class Cluster {
	Collection<String> tags;
	Lied song;
	
	public Cluster(Collection<String> tags, Lied song)
	{
		this.tags = tags;
		this.song = song;
	}
	
	public ArrayList<Lied> cluster(ArrayList<Lied> liedjes , int n)
	{
		ArrayList<ArrayList<Lied>> clusters = new ArrayList<ArrayList<Lied>>();
		for(int k = 0; k < tags.size(); k++)
		{
			clusters.add(new ArrayList<Lied>());
		}
		Iterator<String> tagI;
		int count;
		ArrayList<Lied> cluster;
		Collection<String> tagNames;
		Lied liedje;
		for(int i = 0; i < liedjes.size(); i++)
		{
			tagI = tags.iterator();
			count = 0;
			liedje = liedjes.get(i);
			tagNames = liedje.getTag();
			while(tagI.hasNext())
			{
				if(tagNames.contains(tagI.next()))
				{
					count++;
				}
			}
			clusters.get(count-1).add(liedje);
		}
		ArrayList<Lied> result = new ArrayList<Lied>();
		
		int l = clusters.size() - 1;
		int m;
		while(result.size() < n && l >= 0)
		{
			cluster = clusters.get(l);
			m = 0;
			while(m < cluster.size() && result.size() < n)
			{
				if(!result.contains(cluster.get(m)) && !cluster.get(m).equals(song))
					result.add(cluster.get(m));
				m++;
			}
			l--;
		}
		
		return result;
	}
}
