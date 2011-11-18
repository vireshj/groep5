import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class liedjeInvoerPanel extends JPanel {
	private JTextField nummer = new JTextField("voer in");
	private JTextField artiest = new JTextField("voer in");
	private JLabel nummerInvoer = new JLabel("nummer");
	private JLabel artiestInvoer = new JLabel("artiest");
	
	public liedjeInvoerPanel(){
		setLayout(new GridLayout(4,2));
		add(nummer);
		add(nummerInvoer);
		add(artiest);
		add(artiestInvoer);
		
	}
	public Lied getLiedje(){
		return new Lied(nummer.getText(),artiest.getText());
	}
	
}
