import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
/** 
 * maakt een nieuwe feedbackSysteemPanel klasse die JPanel extends
 */
public class feedbackSysteemPanel extends JPanel {
	private JTable table = new JTable();

	public feedbackSysteemPanel(){
		super();
		this.setLayout(new BorderLayout());
	}

	/** 
	 * maakt een nieuwe JTabel met grootte i
	 */
	public void makeTable(int i){
		table = new JTable(i, 6);
	}
	/** 
	 * zorgt dat alle tekst in de kolommen past
	 */
	public void adjustColumns()
	{
		ColumnResizer.adjustColumnPreferredWidths (table);
	}
	/** 
	 * Voegt Lied invoer toe op positie i
	 */
	public void addSong(Lied invoer, int i){
		table.setValueAt("nummer:", i, 0);
		table.setValueAt(invoer.getNaam(), i, 1);
		table.setValueAt("artiest:", i, 2);
		table.setValueAt(invoer.getArtiest(), i, 3);
		table.setValueAt("album:", i, 4);
		table.setValueAt(invoer.getAlbum(), i, 5);
	}
	/** 
	 * voegt een panel toe
	 */
	public void addPanelSong(){
		add("Center", table);
	}
	/** 
	 * maakt de table leeg
	 */
	public void clearList(){
		table = new JTable();
	}
}
