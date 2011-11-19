import javax.swing.*;

@SuppressWarnings("serial")
public class verificatiePanel extends JPanel {
	liedPanel verificatie = new liedPanel();
	
	public verificatiePanel(){
		add(verificatie);
	}
	public void setVerificatie(Lied invoer){
		verificatie.setLiedPanel(invoer);
	}
}


