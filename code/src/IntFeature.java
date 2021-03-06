//klasse voor int representaties van Features
class IntFeature extends Feature {
	private int feature;
	private int maxDiff;
	/** 
	 * maakt een nieuwe Intfeature klasse, met de gegeven paramters :int feature, int maxDiff
	 */
	public IntFeature(int feature, int maxDiff)
	{
		this.feature = feature;
		this.maxDiff = maxDiff;
	}
	/** 
	 * Retourneert int feature
	 * @return int feature
	 */
	public Object getFeature()
	{
		return this.feature;
	}
	/** 
	 * Retourneert int feature
	 * @return int feature
	 */
	//vergelijkt deze feature met een andere op basis van een interval (maxDiff)
	public boolean validate(Feature that)
	{
		if(that.getFeature() instanceof Integer)
		{
			int f = (Integer) that.getFeature();
			
			return this.feature - maxDiff <= f && this.feature + maxDiff >= f;
		}
		return false;
	}
}
