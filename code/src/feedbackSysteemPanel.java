import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class feedbackSysteemPanel extends JPanel {
	private JTable table = new JTable();
	
	public feedbackSysteemPanel(){
		super();
		this.setLayout(new BorderLayout());
	}
	
	public void makeTable(int i){
		table = new JTable(i, 6);
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
		table.setValueAt("album:", i, 4);
		table.setValueAt(invoer.getAlbum(), i, 5);
	}
	
	public void addPanelSong(){
		add("Center", table);
	}
	public void clearList(){
		table = new JTable();
	}
}
