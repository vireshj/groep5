import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class feedbackSysteemPanel extends JPanel {
	ArrayList<liedPanel> songsPanel = new ArrayList<liedPanel>();
	
	public feedbackSysteemPanel(){
		setLayout(new GridLayout(10,1));
		//setLayout(new FlowLayout());
	}
	public void addSong(Lied invoer){
		liedPanel x = new liedPanel();
		x.setLiedPanel(invoer);
		songsPanel.add(x);
	}
	public void addPanelSong(){
		setLayout(new GridLayout(10,1,0,0));
		for(liedPanel h : songsPanel){
			add(h);
		}
	}
	public void clearList(){
		songsPanel.clear();
	}
}
