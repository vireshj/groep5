import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class inlogPanel extends JPanel {

	private JTextField inlogNaam = new JTextField("voer in",30);
	private JLabel inlogInvoer = new JLabel("nummer");

	public inlogPanel(){
		setLayout(new GridLayout(4,2));
		add(inlogInvoer);
		add(inlogNaam);


	}

	public User getUser(){
		return new User(inlogNaam.getText());
	}

}

