import java.util.*;

import de.umass.lastfm.Tag;

//klasse DTreeNode, maakt onderdeel uit van een decision Tree. 
//Controleert of liedjes vergelijkbaar zijn met het gegeven liedje
public class DTreeNode {
	private String tag;
	private DTreeNode yesNode;
	private boolean isLeaf;
	
	public DTreeNode(String tag)
	{
		this.tag = tag;
		this.isLeaf = true;
	}
	
	public DTreeNode(String tag, DTreeNode node)
	{
		this.tag = tag;
		this.isLeaf = false;
		this.yesNode = node;
	}
	
	public void setYes(DTreeNode node)
	{
		this.yesNode = node;
	}
	
	
	//Vergelijkt de lijst van liedjes met het gegeven liedje op de parameter van deze node
	//stuurt deze lijst door naar de volgende node om te controleren
	//returnt n vergelijkbare liedjes
	public ArrayList<Lied> classify(ArrayList<Lied> liedjes, int n)
	{
		ArrayList<Lied> yes = new ArrayList<Lied>(); //lied
		ArrayList<Lied> no = new ArrayList<Lied>(); //lied
		ArrayList<Lied> result = new ArrayList<Lied>();
		
		//controle
		for(Lied h : liedjes)
		{
			Collection<String> tags = h.getTag();
			boolean isEqual = false;
			for(String s : tags)
			{
				if(tag.equals(s))
					isEqual = true;
			}
			if(isEqual)
			{
				yes.add(h);
			}else {no.add(h);}
		}
		//doorsturen 
		if(!isLeaf && yes.size() >= n)
		{
			result = yesNode.classify(yes, n);
		//stuurt niet door als er te weinig liedjes zijn om door te sturen
		//of als dit de laatste node in de tree is
		}else {
			result = yes;
		}
		//Als er na het classificeren nog steeds te weinig liedjes zijn
		//voegt random liedjes toe die minder vergelijkbaar zijn.
		while(result.size() < n)
		{
			Random r = new Random();
			result.add(no.get(r.nextInt(no.size())));
		}
		return result;
	}	
}
