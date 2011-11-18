import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class gui extends JFrame{
	private JButton zoek = new JButton("zoek");
	private JButton nee = new JButton("nee");
	private JButton ja = new JButton("ja");
	private liedjeInvoerPanel invoer = new liedjeInvoerPanel();
	private verificatie verficatieUser;
	
	//hier wordt de gui aangemaakt
	public static void main(String [] args){
		new gui();
	}
	public gui (){
		setTitle("groepje5");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		setLocation(0,0);
		getContentPane().setBackground(Color.white);
		startScreen();
		setVisible(true);
	}
	public void startScreen(){
		add(invoer);
		add(zoek);
		invoer.setVisible(true);
		zoek.setVisible(true);
	}
	public void verificatieScreen(){
		
	}
}
