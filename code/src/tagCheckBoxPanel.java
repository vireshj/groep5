import javax.swing.JCheckBox;

import de.umass.lastfm.Tag;


public class tagCheckBox{
	private JCheckBox tagBox;
	private Tag tag;
	
	public tagCheckBox(JCheckBox tagBox, Tag tag){
		this.tag = tag;
		this.tagBox = tagBox;
	}
	public Tag getTag(){
		return this.tag;
	}
	public JCheckBox getJCheckBox(){
		return this.tagBox;
	}
}
