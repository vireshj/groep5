import javax.swing.JCheckBox;

import de.umass.lastfm.Tag;


public class tagCheckBoxPanel {
	private JCheckBox tagBox;
	private Tag tag;
	
	public tagCheckBoxPanel(JCheckBox tagBox, Tag tag){
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
