import java.util.ArrayList;
import java.util.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class tagsAanvinkPanel extends JPanel{
	ArrayList<tagCheckBox> tags = new ArrayList<tagCheckBox>();
	//klasse aangemaakt
	public tagsAanvinkPanel(){
		super();
	}
	//hier wordt een tag toegevoegd aan de arraylist
	public void add(Collection<String> tag){
		Iterator<String> x = tag.iterator();
		boolean used = false;
		while(x.hasNext()){
			used = false;
			String tijdelijk = x.next();
			for(tagCheckBox dubbel : tags){
				if(dubbel.getTag().equals(tijdelijk)){
					used = true;
				}
					
			}
			if(!used){
				tagCheckBox tagcheck = new tagCheckBox(new JCheckBox(tijdelijk,true),tijdelijk);
				tags.add(tagcheck);
				this.add(tagcheck.getJCheckBox());
			}
			
		}
	}
	public ArrayList<String> getCheckedPanels(){
		ArrayList<String> tagreturn = new ArrayList<String>();
		for(tagCheckBox tagcheck : tags){
			if(tagcheck.getJCheckBox().isSelected()){
				tagreturn.add(tagcheck.getTag());
			}
		}
		return tagreturn;
	}
	
	public ArrayList<String> getUncheckedPanels(){
		ArrayList<String> tagreturn = new ArrayList<String>();
		for(tagCheckBox tagcheck : tags){
			if(!tagcheck.getJCheckBox().isSelected()){
				tagreturn.add(tagcheck.getTag());
			}
		}
		return tagreturn;
	}
}
