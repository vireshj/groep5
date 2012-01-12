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
	private JButton zoek  = new JButton("voeg toe");
	private JButton home = new JButton("home");
	private JButton klaar = new JButton("klaar");
	private JLabel success;
	private JButton ja;
	private inlogPanel inlog = new inlogPanel();
	private liedjeInvoerPanel invoer = new liedjeInvoerPanel();
	private static tagsAanvinkPanel tags = new tagsAanvinkPanel();
	private static feedbackSysteemPanel recommendation = new feedbackSysteemPanel() ;
	private Lied gezocht;
	private String username;
	private Container container;
	private userInfo gebruiker;
	
	private ArrayList<Lied> playlist = new ArrayList<Lied>();
	
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
		zoek = new JButton("voeg toe");
		klaar  = new JButton("klaar");
		container.removeAll();
		container.add(invoer);
		container.add(zoek);
		container.add(klaar);
		klaar.addMouseListener(new mouseHandler());
		zoek.addMouseListener(new mouseHandler());
		klaar.setVisible(true);
		invoer.setVisible(true);
		zoek.setVisible(true);
	}
	public void verificatieScreen(){
		
		ja = new JButton("klaar");
		container.removeAll();
		container.add(ja);
		container.add(tags);
		ja.addMouseListener(new mouseHandler());
		ja.setVisible(true);
		tags.setVisible(true);
	}
	public void reccomendatieScreen(){
		home  = new JButton("home");
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
				container.remove(klaar);
				gezocht = getInvoer();
				playlist.add(gezocht);
				liedjeInvoerScreen();
				success = new JLabel(gezocht.getNaam() + " is succesvol toegevoegd");
				container.add(success);
				
			}
			if(e.getSource()==klaar){
				container.remove(success);
				invoer.setVisible(false);
				zoek.setVisible(false);
				container.remove(invoer);
				container.remove(zoek);
				container.remove(klaar);
				playlist = controller.findSongs(playlist);
				tags = new tagsAanvinkPanel();
				for(Lied l : playlist){
					tags.add(l.getTag());
					
				}
				verificatieScreen();				
			}
			if(e.getSource()==ja){
				ja.setVisible(false);
				tags.setVisible(false);
				container.remove(ja);
				container.remove(tags);
				
				//hier wordt er van de verificatie weer een Lied object gemaakt
				//Als we weten wat voor object er wordt gemaakt in de controller zouden we deze ook in de gui opslaan
				//zo hoeven we niet twee keer te zoeken
				recommendation.clearList();          
				ArrayList<String> selectedTag = tags.getCheckedPanels();
				ArrayList<String> unselectedTag = tags.getUncheckedPanels();
				ArrayList<String> lied = new ArrayList<String>();
				for(Lied l : playlist)
				{
					lied.add(l.toString());
				}
				if(User.fileIsEmpty(username)){
					User.writeData(username, selectedTag, unselectedTag, lied);
				}
				else{
					gebruiker = User.readfile(username);
					for(String s : gebruiker.getSelected())
					{
						selectedTag.add(s.toString());
					}
					for(String u : gebruiker.getUnselected())
					{
						unselectedTag.add(u.toString());
					}
					for(String t : gebruiker.getTracks())
					{
						lied.add(t.toString());
					}
					User.writeData(username, selectedTag, unselectedTag, lied);
				}
				User.writeData(username, selectedTag, unselectedTag, lied);
				controller.findSimilarSongsCluster(selectedTag, playlist);
				reccomendatieScreen();
			}
			if(e.getSource()==home){
				home.setVisible(false);
				recommendation.setVisible(false);
				container.remove(recommendation);
				container.remove(home);
				container.setLayout(new FlowLayout());
				recommendation = new feedbackSysteemPanel(); 
				liedjeInvoerScreen();
				playlist = new ArrayList<Lied>();
			}
		}
	}
}
