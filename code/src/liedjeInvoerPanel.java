import java.awt.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class liedjeInvoerPanel extends JPanel {
	private JTextField nummer = new JTextField("voer in",15);
	private JTextField artiest = new JTextField("voer in",15);
	private JLabel nummerInvoer = new JLabel("nummer");
	private JLabel artiestInvoer = new JLabel("artiest");
	
	public liedjeInvoerPanel(){
		setLayout(new GridLayout(4,2));
		add(nummerInvoer);
		add(nummer);
		add(artiestInvoer);
		add(artiest);
		
	}
	public Lied getLiedje(){
		return new Lied(nummer.getText(),artiest.getText());
	}
	
}
