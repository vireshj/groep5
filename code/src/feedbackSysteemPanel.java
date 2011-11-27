import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class feedbackSysteemPanel extends JPanel {
	private JTable table = new JTable();
	
	public feedbackSysteemPanel(){
		super();
		this.setSize(1100, 600);
		this.setLayout(new BorderLayout());
	}
	
	public void makeTable(int i){
		table = new JTable(i, 8);
		table.setFillsViewportHeight(true);
	}
	
	public void adjustColumns()
	{
		ColumnResizer.adjustColumnPreferredWidths (table);
	}
	
	public void addSong(Lied invoer, int i){
		table.setValueAt("nummer:", i, 0);
		table.setValueAt(invoer.getNaam(), i, 1);
		table.setValueAt("artiest:", i, 2);
		table.setValueAt(invoer.getArtiest(), i, 3);
		table.setValueAt("genre:", i, 4);
		table.setValueAt(invoer.getGenre(), i, 5);
		table.setValueAt("album:", i, 6);
		table.setValueAt(invoer.getAlbum(), i, 7);
	}
	
	public void addPanelSong(){
		add("Center", table);
	}
	public void clearList(){
		table = new JTable();
	}
}
