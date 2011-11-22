import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class liedPanel extends JPanel {
	private JLabel nummer = new JLabel("nummer");
	private JLabel artiest = new JLabel("artiest");
	private JLabel genre = new JLabel("genre");
	private JLabel album = new JLabel("album");
	private JLabel nummer1 = new JLabel("nummer:");
	private JLabel artiest1 = new JLabel("	artiest:");
	private JLabel genre1 = new JLabel("genre:");
	private JLabel album1 = new JLabel("album:");
	
	public liedPanel(){
		setLayout(new GridLayout(1,8));
		add(nummer1);
		add(nummer);
		add(artiest1);
		add(artiest);
		add(genre1);
		add(genre);
		add(album1);
		add(album);
	}
	public void setLiedPanel(Lied invoer){
		this.nummer.setText(invoer.getNaam());
		this.artiest.setText(invoer.getArtiest());
		this.genre.setText(invoer.getGenre());
		this.album.setText(invoer.getAlbum());
	}
	public Lied getLiedPanel(){
		return new Lied(nummer.getText(),artiest.getText(), album.getText(), genre.getText());
	}
}
