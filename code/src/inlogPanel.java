import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class inlogPanel extends JPanel{

	private JTextField inlogNaam = new JTextField("voer in",30);
	private JLabel inlogInvoer = new JLabel("Naam");

	public inlogPanel(){
		setLayout(new GridLayout(4,2));
		add(inlogInvoer);
		add(inlogNaam);


	}

	public String getUserName(){
		User user = new User(inlogNaam.getText());
		return user.getNaam();
	}

}

