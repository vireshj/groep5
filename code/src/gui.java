import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class gui extends JFrame{
	private JButton zoek = new JButton("zoek");
	private JButton home = new JButton("home");
	private JButton nee = new JButton("nee");
	private JButton ja = new JButton("ja");
	private liedjeInvoerPanel invoer = new liedjeInvoerPanel();
	private static verificatiePanel verificatieUser = new verificatiePanel();
	private static feedbackSysteemPanel recommendation = new feedbackSysteemPanel() ;
	
	
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
		add(verificatieUser);
		add(ja);
		add(nee);
		ja.addMouseListener(new mouseHandler());
		nee.addMouseListener(new mouseHandler());
		verificatieUser.setVisible(true);
		nee.setVisible(true);
		ja.setVisible(true);
	}
	public void reccomendatieScreen(){
		recommendation.addPanelSong();
		add(recommendation);
		add(home);
		recommendation.setVisible(true);
		home.setVisible(true);
		home.addMouseListener(new mouseHandler());
	}
	public Lied getInvoer(){
		return invoer.getLiedje();
	}
	public static void setVerificatie(Lied invoer){
		verificatieUser.setVerificatie(invoer);
	}
	public static void setFeedbackPanel(Lied invoer){
		recommendation.addSong(invoer);
	}
	//hier worden de mouse inputs verwerkt
	class mouseHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(e.getSource()==zoek){
				invoer.setVisible(false);
				zoek.setVisible(false);
				remove(invoer);
				remove(zoek);
				controller.findSong(getInvoer());
				verificatieScreen();
			}
			if(e.getSource()==ja){
				ja.setVisible(false);
				nee.setVisible(false);
				verificatieUser.setVisible(false);
				remove(ja);
				remove(nee);
				remove(verificatieUser);
				//hier wordt er van de verificatie weer een Lied object gemaakt
				//Als we weten wat voor object er wordt gemaakt in de controller zouden we deze ook in de gui opslaan
				//zo hoeven we niet twee keer te zoeken
				recommendation.clearList();
				controller.findSimilarSongs(verificatieUser.verificatie.getLiedPanel());
				reccomendatieScreen();
			}
			if(e.getSource()==nee){
				ja.setVisible(false);
				nee.setVisible(false);
				verificatieUser.setVisible(false);
				remove(ja);
				remove(nee);
				remove(verificatieUser);
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
