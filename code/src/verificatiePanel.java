import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class verificatiePanel extends JPanel {
	liedPanel verificatie = new liedPanel();
	
	public verificatiePanel(){
		add(verificatie);
	}
	public void setVerificatie(String nummer, String artiest, String genre, String album){
		verificatie.setLiedPanel(nummer, artiest, genre, album);
	}
}


