//klasse voor String representaties van Features
public class StringFeature extends Feature {
	private String feature;
	/** 
	 * maakt een StringFeature klasse, met de meegegeven parameter : String feature
	 */
	public StringFeature(String feature)
	{
		this.feature = feature;
	}
	/** 
	 * Retourneert de feature
	 * @return Object feature
	 */
	public Object getFeature()
	{
		return this.feature;
	}
	/** 
	 * vergelijkt deze feature met een andere
	 * @return boolean asl deze feature overeenkomt met de andere feature anders false
	 */
	//vergelijkt deze feature met een andere
	public boolean validate(Feature that)
	{		
		return this.feature.equals(that.getFeature());		
	}
}
