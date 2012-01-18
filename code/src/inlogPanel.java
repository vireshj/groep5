import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class inlogPanel extends JPanel implements MouseListener{

	private JTextField inlogNaam = new JTextField("voer in",30);
	private JLabel inlogInvoer = new JLabel("Naam");
	/** 
	 * maakt een nieuwe inlogPanel klasse
	 */
	public inlogPanel(){
		setLayout(new GridLayout(4,2));
		add(inlogInvoer);
		add(inlogNaam);
		inlogNaam.setFont(new Font("italic",Font.ITALIC,10));
		inlogNaam.setForeground(Color.GRAY);
		inlogNaam.addMouseListener(this);
	}
	/** 
	 * Retourneert de user name
	 * @return String userName
	 */
	public String getUserName(){
		User user = new User(inlogNaam.getText());
		return user.getNaam();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(inlogNaam.getText().equals("voer in")&& e.getSource() == inlogNaam){
			inlogNaam.setText("");
			inlogNaam.setFont(new Font("normal",Font.PLAIN,14));
			inlogNaam.setForeground(Color.BLACK);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

