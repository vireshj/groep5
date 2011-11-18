import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

public class feedbackSysteemPanel extends JPanel {
	ArrayList<liedPanel> songsPanel = new ArrayList<liedPanel>();
	
	public feedbackSysteemPanel(){
		setLayout(new GridLayout(1,20));
		for(liedPanel h : songsPanel){
			add(h);
		}
	}
}
