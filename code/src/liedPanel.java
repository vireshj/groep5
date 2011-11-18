import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
	public void setLiedPanel(String nummer, String artiest, String genre, String album){
		this.nummer.setText(nummer);
		this.artiest.setText(artiest);
		this.genre.setText(genre);
		this.album.setText(album);
	}
}
