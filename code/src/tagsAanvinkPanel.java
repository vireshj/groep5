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
		while(x.hasNext()){
			String tijdelijk = x.next();
			tagCheckBox tagcheck = new tagCheckBox(new JCheckBox(tijdelijk),tijdelijk);
			tags.add(tagcheck);
			this.add(tagcheck.getJCheckBox());
			System.out.println(tagcheck.getTag());
		}
	}
	public ArrayList<String> getCheckedPanels(){
		ArrayList<String> tagreturn = new ArrayList<String>();
		for(tagCheckBox tagcheck : tags){
			if(tagcheck.getJCheckBox().isSelected()){
				tagreturn.add(tagcheck.getTag());
			}
		}
		System.out.println(tagreturn.toString());
		return tagreturn;
	}
	
}
