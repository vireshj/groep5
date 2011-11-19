import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class liedPanel extends JPanel {
	private JLabel nummer = new JLabel("nummer");
	private JLabel artiest = new JLabel("artiest");
	private JLabel genre = new JLabel("genre");
	private JLabel album = new JLabel("album");
	
	public liedPanel(){
		setLayout(new GridLayout(1,4));
		add(nummer);
		add(artiest);
		add(genre);
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
