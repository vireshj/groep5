import java.util.ArrayList;

import javax.swing.*;

import de.umass.lastfm.Tag;

@SuppressWarnings("serial")
public class tagsAanvinkPanel extends JPanel{
	ArrayList<tagCheckBoxPanel> tags = new ArrayList<tagCheckBoxPanel>();
	//klasse aangemaakt
	public tagsAanvinkPanel(){
		super();
	}
	//hier wordt een tag toegevoegd aan de arraylist
	public void add(ArrayList<Tag> x){
		for(Tag tag: x){
			tagCheckBoxPanel tagcheck = new tagCheckBoxPanel(new JCheckBox(tag.getName()),tag);
			tags.add(tagcheck);
			this.add(tagcheck.getJCheckBox());
		}
	}
	public ArrayList<Tag> getCheckedPanels(){
		ArrayList<Tag> tagreturn = new ArrayList<Tag>();
		for(tagCheckBoxPanel tagcheck : tags){
			if(tagcheck.getJCheckBox().isSelected()){
				tagreturn.add(tagcheck.getTag());
			}
		}
		return tagreturn;
	}
	
}
