import java.util.ArrayList;

import javax.swing.*;

import de.umass.lastfm.Tag;

@SuppressWarnings("serial")
public class tagsAanvinkPanel extends JPanel{
	ArrayList<tagCheckBox> tags = new ArrayList<tagCheckBox>();
	//klasse aangemaakt
	public tagsAanvinkPanel(){
		super();
	}
	//hier wordt een tag toegevoegd aan de arraylist
	public void add(ArrayList<Tag> x){
		for(Tag tag: x){
			tagCheckBox tagcheck = new tagCheckBox(new JCheckBox(tag.getName()),tag);
			tags.add(tagcheck);
			this.add(tagcheck.getJCheckBox());
		}
	}
	public ArrayList<Tag> getCheckedPanels(){
		ArrayList<Tag> tagreturn = new ArrayList<Tag>();
		for(tagCheckBox tagcheck : tags){
			if(tagcheck.getJCheckBox().isSelected()){
				tagreturn.add(tagcheck.getTag());
			}
		}
		return tagreturn;
	}
	
}
