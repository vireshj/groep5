import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class liedPanel extends JTable {
	private JLabel nummer = new JLabel("nummer");
	private JLabel artiest = new JLabel("artiest");
	private JLabel album = new JLabel("album");
	private JLabel nummer1 = new JLabel("nummer:");
	private JLabel artiest1 = new JLabel("artiest:");
	private JLabel album1 = new JLabel("album:");
	/** 
	 * maakt een nieuwe liedPanel klasse
	 * 
	 */
	public liedPanel(){
		setLayout(new GridLayout(1,8));
		this.setSize(600,30);
		nummer.setSize(40, 20);
		artiest.setSize(40, 20);
		album.setSize(40, 20);
		nummer1.setSize(60, 20);
		artiest1.setSize(60, 20);
		album1.setSize(60, 20);
		add(nummer1);
		add(nummer);
		add(artiest1);
		add(artiest);
		add(album1);
		add(album);
	}
	/** 
	 * de nummer, artiest en album van deze liedPanel worden geset naar de waardes van Lied invoer
	 */
	public void setLiedPanel(Lied invoer){
		this.nummer.setText(invoer.getNaam());
		this.artiest.setText(invoer.getArtiest());
		this.album.setText(invoer.getAlbum());
	}
	/** 
	 *Retourneert een Lied op basis van nummer, artiest en album
	 *@return Lied op basis van nummer, artiest en album
	 */
	public Lied getLiedPanel(){
		return new Lied(nummer.getText(),artiest.getText(), album.getText(),null, "temp");
	}
}
