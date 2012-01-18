import javax.swing.*;

@SuppressWarnings("serial")
public class verificatiePanel extends JPanel {
	JTable verificatie = new JTable(1, 6);
	/** 
	 * maakt een nieuwe verificatiePanel klasse
	 * @deprecated
	 */
	public verificatiePanel(){
		add(verificatie);
	}
	/** 
	 * set de waardes van de verificatiepanel met de waardes van de parameter Lied invoer
	 * @deprecated
	 */
	public void setVerificatie(Lied invoer){
		verificatie.setValueAt("nummer:", 0, 0);
		verificatie.setValueAt(invoer.getNaam(), 0, 1);
		verificatie.setValueAt("artiest:", 0, 2);
		verificatie.setValueAt(invoer.getArtiest(), 0, 3);
		verificatie.setValueAt("album:", 0, 4);
		verificatie.setValueAt(invoer.getAlbum(), 0, 5);
	}
	
	
}


