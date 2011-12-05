import java.util.*;

//klasse DTreeNode, maakt onderdeel uit van een decision Tree. 
//Controleert of liedjes vergelijkbaar zijn met het gegeven liedje
public class DTreeNode {
	private int parameterIndex;
	private Feature[] features;
	private DTreeNode yesNode;
	private boolean isLeaf;
	
	public DTreeNode(int parameter, Feature[] features, boolean isLeaf, DTreeNode node)
	{
		this.parameterIndex = parameter;
		this.features = features;
		this.isLeaf = isLeaf;
		this.yesNode = node;
	}
	
	public void setYes(DTreeNode node)
	{
		this.yesNode = node;
	}
	
	
	//Vergelijkt de lijst van liedjes met het gegeven liedje op de parameter van deze node
	//stuurt deze lijst door naar de volgende node om te controleren
	//returnt n vergelijkbare liedjes
	public ArrayList<Feature[]> classify(ArrayList<Feature[]> liedjes, int n)
	{
		ArrayList<Feature[]> yes = new ArrayList<Feature[]>(); //lied
		ArrayList<Feature[]> no = new ArrayList<Feature[]>(); //lied
		ArrayList<Feature[]> result = new ArrayList<Feature[]>();
		
		//controle
		for(Feature[] h : liedjes)
		{
			if(features[parameterIndex].validate(h[parameterIndex]))
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
		if(result.size() < n)
		{
			Random r = new Random();
			result.add(no.get(r.nextInt(no.size())));
		}
		return result;
	}	
}
