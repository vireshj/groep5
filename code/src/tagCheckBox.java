import javax.swing.JCheckBox;

public class tagCheckBox{
	private JCheckBox tagBox;
	private String tag;
	
	public tagCheckBox(JCheckBox tagBox, String tag){
		this.tag = tag;
		this.tagBox = tagBox;
	}
	public String getTag(){
		return this.tag;
	}
	public JCheckBox getJCheckBox(){
		return this.tagBox;
	}
}
