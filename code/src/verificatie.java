import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class verificatie extends JPanel {
	liedPanel verificatie = new liedPanel();
	
	public verificatie(){
		add(verificatie);
	}
	public void setVerificatie(String nummer, String artiest, String genre, String album){
		verificatie.setLiedPanel(nummer, artiest, genre, album);
	}
}


