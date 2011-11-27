import javax.swing.*;

@SuppressWarnings("serial")
public class verificatiePanel extends JPanel {
	JTable verificatie = new JTable(1, 8);
	
	public verificatiePanel(){
		add(verificatie);
	}
	public void setVerificatie(Lied invoer){
		verificatie.setValueAt("nummer:", 0, 0);
		verificatie.setValueAt(invoer.getNaam(), 0, 1);
		verificatie.setValueAt("artiest:", 0, 2);
		verificatie.setValueAt(invoer.getArtiest(), 0, 3);
		verificatie.setValueAt("genre:", 0, 4);
		verificatie.setValueAt(invoer.getGenre(), 0, 5);
		verificatie.setValueAt("album:", 0, 6);
		verificatie.setValueAt(invoer.getAlbum(), 0, 7);
		
		
	}
	
	
}


