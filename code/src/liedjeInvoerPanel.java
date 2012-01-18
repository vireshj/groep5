import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


@SuppressWarnings("serial")
public class liedjeInvoerPanel extends JPanel implements MouseListener{
	private JTextField nummer = new JTextField("voer in",15);
	private JTextField artiest = new JTextField("voer in",15);
	private JLabel nummerInvoer = new JLabel("nummer");
	private JLabel artiestInvoer = new JLabel("artiest");
	/** 
	 * maakt een nieuwe LiedjeInvoerPanel klasse
	 * 
	 */
	public liedjeInvoerPanel(){
		setLayout(new GridLayout(4,2));
		add(nummerInvoer);
		add(nummer);
		add(artiestInvoer);
		add(artiest);
		nummer.setFont(new Font("italic",Font.ITALIC,10));
		nummer.setForeground(Color.GRAY);
		artiest.setFont(new Font("italic",Font.ITALIC,10));
		artiest.setForeground(Color.GRAY);
		nummer.addMouseListener(this);
		artiest.addMouseListener(this);
	}
	/** 
	 * Retourneert een Lied op basis van invoer van de nummer en artiest velden
	 * @return Lied op basis van invoer van de nummer en artiest velden
	 * 
	 */
	public Lied getLiedje(){
		return new Lied(nummer.getText(),artiest.getText());
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(nummer.getText().equals("voer in")&& e.getSource() == nummer){
			nummer.setText("");
			nummer.setFont(new Font("normal",Font.PLAIN,14));
			nummer.setForeground(Color.BLACK);
		}
		if(artiest.getText().equals("voer in") && e.getSource() == artiest){
			artiest.setText("");
			artiest.setFont(new Font("normal",Font.PLAIN,14));
			artiest.setForeground(Color.BLACK);
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
