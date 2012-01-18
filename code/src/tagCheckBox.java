import javax.swing.JCheckBox;

public class tagCheckBox{
	private JCheckBox tagBox;
	private String tag;
	/** 
	 * maakt een nieuwe tagCheckBox klasse op basis van de parameters : JCheckBox tagBox, String tag
	 * @return ArrayList<String> van tags 
	 */
	public tagCheckBox(JCheckBox tagBox, String tag){
		this.tag = tag;
		this.tagBox = tagBox;
	}
	/** 
	 * Retourneert tag String
	 * @return String tag 
	 */
	public String getTag(){
		return this.tag;
	}
	/** 
	 * Retourneert de JCheckBox tagBox
	 * @return JCheckBox tagBox
	 */
	public JCheckBox getJCheckBox(){
		return this.tagBox;
	}
}
