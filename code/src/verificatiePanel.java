import javax.swing.*;

@SuppressWarnings("serial")
public class verificatiePanel extends JPanel {
	JTable verificatie = new JTable(1, 6);
	
	public verificatiePanel(){
		add(verificatie);
	}
	public void setVerificatie(Lied invoer){
		verificatie.setValueAt("nummer:", 0, 0);
		verificatie.setValueAt(invoer.getNaam(), 0, 1);
		verificatie.setValueAt("artiest:", 0, 2);
		verificatie.setValueAt(invoer.getArtiest(), 0, 3);
		verificatie.setValueAt("album:", 0, 4);
		verificatie.setValueAt(invoer.getAlbum(), 0, 5);
	}
	
	
}


