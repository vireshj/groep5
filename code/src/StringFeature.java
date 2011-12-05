//klasse voor String representaties van Features
public class StringFeature extends Feature {
	private String feature;
	
	public StringFeature(String feature)
	{
		this.feature = feature;
	}
	
	public Object getFeature()
	{
		return this.feature;
	}
	
	//vergelijkt deze feature met een andere
	public boolean validate(Feature that)
	{		
		return this.feature.equals(that.getFeature());		
	}
}