//from http://codeidol.com/java/swing/Tables-and-Trees/Size-Your-Columns-to-Suit-Your-JTables-Contents/

import java.awt.Component;

import javax.swing.*;
import javax.swing.table.*;

public class ColumnResizer {
	public static void adjustColumnPreferredWidths(JTable table) {
		// strategy - get max width for cells in column and
		// make that the preferred width
		TableColumnModel columnModel = table.getColumnModel();
		for (int col=0; col<table.getColumnCount(); col++) {

			int maxwidth = 0;            
			for (int row=0; row<table.getRowCount(); row++) {
				TableCellRenderer rend = table.getCellRenderer(row, col); 
				Object value = table.getValueAt (row, col); 
				Component comp = rend.getTableCellRendererComponent (table, value, false, false, row, col);
				maxwidth = Math.max (comp.getPreferredSize().width, maxwidth); 
			} // for row
			TableColumn column = columnModel.getColumn (col); 
			column.setPreferredWidth (maxwidth);
		} // for col 
	}

}
