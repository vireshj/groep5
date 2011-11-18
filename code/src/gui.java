import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;


public class gui extends JFrame{
	private JButton zoek = new JButton("zoek");
	private JButton home = new JButton("home");
	private JButton nee = new JButton("nee");
	private JButton ja = new JButton("ja");
	private liedjeInvoerPanel invoer = new liedjeInvoerPanel();
	private verificatie verficatieUser = new verificatie();
	private feedbackSysteemPanel recommendation;
	
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
		zoek.addMouseListener(new mouseHandler());
		invoer.setVisible(true);
		zoek.setVisible(true);
	}
	public void verificatieScreen(){
		add(verficatieUser);
		add(ja);
		add(nee);
		ja.addMouseListener(new mouseHandler());
		nee.addMouseListener(new mouseHandler());
		verficatieUser.setVisible(true);
		nee.setVisible(true);
		ja.setVisible(true);
	}
	public void reccomendatieScreen(){
		add(recommendation);
		add(home);
		recommendation.setVisible(true);
		home.setVisible(true);
		home.addMouseListener(new mouseHandler());
	}
	
	//hier worden de mouse inputs verwerkt
	class mouseHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(e.getSource()==zoek){
				invoer.setVisible(false);
				zoek.setVisible(false);
				remove(invoer);
				remove(zoek);
				verificatieScreen();
			}
			if(e.getSource()==ja){
				ja.setVisible(false);
				nee.setVisible(false);
				verficatieUser.setVisible(false);
				remove(ja);
				remove(nee);
				remove(verficatieUser);
				reccomendatieScreen();
				
			}
			if(e.getSource()==nee){
				ja.setVisible(false);
				nee.setVisible(false);
				verficatieUser.setVisible(false);
				remove(ja);
				remove(nee);
				remove(verficatieUser);
				startScreen();
			}
			if(e.getSource()==home){
				home.setVisible(false);
				recommendation.setVisible(false);
				remove(recommendation);
				remove(home);
				startScreen();
			}
			
			
		}
	}
}
