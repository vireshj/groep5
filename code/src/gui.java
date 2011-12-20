import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.*;


@SuppressWarnings("serial")
public class gui extends JFrame{
	private JButton login = new JButton("login");
	private JButton zoek = new JButton("zoek");
	private JButton home = new JButton("home");
	private JButton nee;
	private JButton ja;
	private inlogPanel inlog = new inlogPanel();
	private liedjeInvoerPanel invoer = new liedjeInvoerPanel();
	private static tagsAanvinkPanel tags = new tagsAanvinkPanel();
	private static verificatiePanel verificatieUser = new verificatiePanel();
	private static feedbackSysteemPanel recommendation = new feedbackSysteemPanel() ;
	private Lied gezocht;
	private String username;
	private Container container;
	private Lied gezochtLied = null;
	private int aantal = 0;
	
	public gui (){
		setTitle("groep5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,350);
		setLocation(0,0);
		container  = getContentPane();
		container.setLayout(new FlowLayout());
		container.setBackground(Color.white);
		startScreen();
		setVisible(true);
	}
	public void startScreen(){
		container.add(inlog);
		container.add(login);
		login.addMouseListener(new mouseHandler());
		inlog.setVisible(true);
		login.setVisible(true);
	}
	public void liedjeInvoerScreen(){
		container.removeAll();
		container.add(invoer);
		container.add(zoek);
		zoek.addMouseListener(new mouseHandler());
		invoer.setVisible(true);
		zoek.setVisible(true);
	}
	public void verificatieScreen(){
		nee = new JButton("nee");
		ja = new JButton("ja");
		container.removeAll();
		container.add(verificatieUser);
		container.add(ja);
		container.add(nee);
		container.add(tags);
		ja.addMouseListener(new mouseHandler());
		nee.addMouseListener(new mouseHandler());
		verificatieUser.setVisible(true);
		nee.setVisible(true);
		ja.setVisible(true);
		tags.setVisible(true);
	}
	public void reccomendatieScreen(){
		container.removeAll();
		container.setLayout(null);
		recommendation.addPanelSong();
		container.add(recommendation);
		container.add(home);
		recommendation.setBounds(30, 30, 1130,180);
		home.setBounds(550, 220, 80, 30); 
		recommendation.setVisible(true);
		home.setVisible(true);
		home.addMouseListener(new mouseHandler());
	}
	public Lied getInvoer(){
		return invoer.getLiedje();
	}
	
	public String getNaamInvoer(){
		return inlog.getUserName();
	}
	
	public static void setVerificatie(Lied invoer){
		verificatieUser.setVerificatie(invoer);
	}
	public static void setFeedbackPanel(ArrayList<Lied> invoer){
		
		recommendation.makeTable(invoer.size());
		for(int i = 0; i < invoer.size(); i++)
		{
			recommendation.addSong(invoer.get(i), i);
		}
		recommendation.adjustColumns();
	}
	//hier worden de mouse inputs verwerkt
	class mouseHandler extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(e.getSource()==login){
				inlog.setVisible(false);
				login.setVisible(false);
				container.remove(inlog);
				container.remove(login);
				username = getNaamInvoer();
				if(!User.userExists(username))
					User.makeUserFile(username);					
				liedjeInvoerScreen();
			}
			if(e.getSource()==zoek){
				invoer.setVisible(false);
				zoek.setVisible(false);
				container.remove(invoer);
				container.remove(zoek);
				gezocht = getInvoer();
				gezochtLied = controller.findSong(gezocht);
				if(gezochtLied == null){
					liedjeInvoerScreen();
					container.add(new JLabel("kan liedje niet vinden"));
				}
				else{
					tags = new tagsAanvinkPanel();
					tags.add(gezochtLied.getTag());
					verificatieScreen();
				}
			}
			if(e.getSource()==ja){
				System.out.println(aantal);
				aantal++;
				ja.setVisible(false);
				nee.setVisible(false);
				verificatieUser.setVisible(false);
				tags.setVisible(false);
				container.remove(ja);
				container.remove(nee);
				container.remove(verificatieUser);
				container.remove(tags);
				
				//hier wordt er van de verificatie weer een Lied object gemaakt
				//Als we weten wat voor object er wordt gemaakt in de controller zouden we deze ook in de gui opslaan
				//zo hoeven we niet twee keer te zoeken
				recommendation.clearList();          
				gezochtLied.setTag(tags.getCheckedPanels());
				controller.findSimilarSongsCluster(gezochtLied.getTag(), gezochtLied);

				reccomendatieScreen();
			}
			if(e.getSource()==nee){
				ja.setVisible(false);
				nee.setVisible(false);
				verificatieUser.setVisible(false);
				tags.setVisible(false);
				container.remove(ja);
				container.remove(nee);
				container.remove(verificatieUser);
				container.remove(tags);
				liedjeInvoerScreen();
			}
			if(e.getSource()==home){
				home.setVisible(false);
				recommendation.setVisible(false);
				container.remove(recommendation);
				container.remove(home);
				container.setLayout(new FlowLayout());
				recommendation = new feedbackSysteemPanel(); 
				liedjeInvoerScreen();
			}
		}
	}
}
