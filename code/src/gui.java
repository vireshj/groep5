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
	private JButton reset = new JButton("Reset");
	private JButton quickRecommend = new JButton("Quick Recommend");
	private JLabel success = new JLabel("");
	private JLabel successie = new JLabel("");
	private JButton ja;
	private inlogPanel inlog = new inlogPanel();
	private liedjeInvoerPanel invoer = new liedjeInvoerPanel();
	private static tagsAanvinkPanel tags = new tagsAanvinkPanel();
	private static feedbackSysteemPanel recommendation = new feedbackSysteemPanel() ;
	private Lied gezocht;
	private String username;
	private Container container;
	private userInfo gebruiker;
	private boolean fail = false;

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
		container.add(success);
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
		quickRecommend = new JButton("Quick Recommend");
		reset = new JButton("reset");
		container.removeAll();
		container.add(quickRecommend);
		container.add(invoer);
		container.add(zoek);
		container.add(klaar);
		container.add(reset);
		container.add(success);
		quickRecommend.addMouseListener(new mouseHandler());
		klaar.addMouseListener(new mouseHandler());
		zoek.addMouseListener(new mouseHandler());
		reset.addMouseListener(new mouseHandler());
		reset.setVisible(true);
		klaar.setVisible(true);
		success.setVisible(true);
		invoer.setVisible(true);
		zoek.setVisible(true);
	}
	public void verificatieScreen(){
		fail = false;
		ja = new JButton("klaar");
		success.setVisible(false);
		reset.setVisible(false);
		container.removeAll();
		container.add(ja);
		container.add(tags);
		container.add(success);
		ja.addMouseListener(new mouseHandler());
		ja.setVisible(true);
		tags.setVisible(true);
	}
	public void reccomendatieScreen(){
		successie = new JLabel("");
		
		home  = new JButton("home");
		container.removeAll();
		container.setLayout(null);
		recommendation.addPanelSong();
		container.add(recommendation);
		container.add(home);
		container.add(successie);
		successie.setVisible(true);
		if(fail){
			container.remove(recommendation);
			successie.setText("Niet mogelijk om te recommenderen: er zijn geen tags bekend van u");
		}
		successie.setBounds(300, 120, 700, 30 );
		recommendation.setBounds(30, 30, 1200,180);
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
			//wordt uitgevoerd als er op de login button wordt gedrukt
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
			//wordt uitgevoerd als er op de zoek button wordt gedrukt
			if(e.getSource()==zoek){
				invoer.setVisible(false);
				zoek.setVisible(false);
				container.remove(invoer);
				container.remove(zoek);
				container.remove(reset);
				container.remove(klaar);
				container.remove(quickRecommend);
				gezocht = getInvoer();
				Lied lied = controller.findSong(gezocht);
				if(lied != null)
				{
					playlist.add(lied);
					liedjeInvoerScreen();
					//er wordt feedback gegeven over het liedje dat toegevoegd is.
					success.setText(lied.getNaam() + " is succesvol toegevoegd");
				} else {
					liedjeInvoerScreen();
					success.setText(gezocht.getNaam() + " bestaat niet");
				}


			}
			//wordt uitgevoerd als er op de klaar button wordt gedrukt
			if(e.getSource()==klaar){
				success.setText("");
				invoer.setVisible(false);
				zoek.setVisible(false);
				container.remove(invoer);
				container.remove(reset);
				container.remove(quickRecommend);
				container.remove(zoek);
				container.remove(klaar);
				tags = new tagsAanvinkPanel();
				for(Lied l : playlist){
					tags.add(l.getTag());

				}
				verificatieScreen();				
			}
			if(e.getSource()==quickRecommend){
				success.setText(" ");
				invoer.setVisible(false);
				zoek.setVisible(false);
				klaar.setVisible(false);
				success.setVisible(false);
				quickRecommend.setVisible(false);
				container.remove(quickRecommend);
				container.remove(success);
				container.remove(invoer);
				container.remove(reset);
				container.remove(zoek);
				container.remove(klaar);

				gebruiker = User.readfile(username);
				ArrayList<String> selectedTag = gebruiker.getSelected();
				ArrayList<String> lied = gebruiker.getTracks();
				for(String s : lied)
				{
					playlist.add(new Lied(s));
				}
				if(selectedTag.size() > 0)
				{
					fail = false;
					success.setText("");
					controller.findSimilarSongsCluster(selectedTag, playlist);
				}else
				{
					fail = true;
				}
				reccomendatieScreen();			
			}
			//wordt uitgevoerd als er op de ja button wordt gedrukt
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
					if(!unselectedTag.contains(l.toString()))
						lied.add(l.toString());
				}
				gebruiker = User.readfile(username);
				for(String s : gebruiker.getSelected())
				{
					if(!selectedTag.contains(s.toString()))
						selectedTag.add(s.toString());
				}
				for(String u : gebruiker.getUnselected())
				{
					if(!unselectedTag.contains(u.toString()))
						unselectedTag.add(u.toString());
				}
				for(String t : gebruiker.getTracks())
				{
					if(!lied.contains(t.toString()))
						lied.add(t.toString());
				}
				User.writeData(username, selectedTag, unselectedTag, lied);
				controller.findSimilarSongsCluster(selectedTag, playlist);
				reccomendatieScreen();
			}
			//wordt uitgevoerd als er op de home button wordt gedrukt
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
			//wordt uitgevoerd als er op de reset button wordt gedrukt
			if(e.getSource()==reset){
				success.setText("uw geschiedenis is succesvol verwijderd");
				User.reset(username);
			}
		}
	}
}
