import org.openrdf.repository.*;
import org.openrdf.repository.http.HTTPRepository;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.sail.memory.*;
import org.openrdf.rio.*;
import org.openrdf.model.Statement;
import org.openrdf.model.Value;
import org.openrdf.query.*;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class OntologyG extends JFrame implements ActionListener{
	private JLabel vraagselect = new JLabel("SELECT:");
	private JTextArea select = new JTextArea();
	private JButton gaan = new JButton("Gaan!");
	private JTextArea antwoord = new JTextArea();
	private Panel paneel = new Panel(new GridLayout(2,2,0,5));
	private Panel paneelantwoord = new Panel(new GridLayout(1,1));
	private JScrollPane scrollselect;
	private JScrollPane scrollantwoord;
	private RepositoryConnection dbCon; 
	private String endpointURL = "http://dbtune.org/musicbrainz/sparql";
	
	public OntologyG()
	{
		setBounds(0,0,1020,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try{
			
			Repository dbtune = new HTTPRepository(endpointURL);
			dbtune.initialize();

			dbCon = dbtune.getConnection();

		} catch(Exception e1)
		{
			antwoord.setText(e1.toString());
			System.out.print(e1.toString());
		}
		
		
        
        select.setLineWrap(true);
        scrollselect = new JScrollPane(select);
        scrollselect.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        antwoord.setLineWrap(true);
        scrollantwoord = new JScrollPane(antwoord);
        scrollantwoord.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        Container container = getContentPane();
        container.setLayout(null);
        paneel.setBounds(0,0,1000,200);
        paneelantwoord.setBounds(0,200,1000,500);
        paneel.add(vraagselect);
        paneel.add(scrollselect);
        paneel.add(gaan);
        paneelantwoord.add(scrollantwoord);
        
        container.add(paneel);
        container.add(paneelantwoord);
        
        setVisible(true);
        
        gaan.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){

        Object source = e.getSource();
        
        if (source == gaan){
        	try{
       			ArrayList<String> antwoorden = new ArrayList<String>();
   				String query = select.getText();
   				int k = 1;


   				TupleQuery tupleQuery = dbCon.prepareTupleQuery(QueryLanguage.SPARQL, query);
       			TupleQueryResult result = tupleQuery.evaluate();
       			List<String> bindingNames = result.getBindingNames();

       			while (result.hasNext()) {
					BindingSet bindingSet = result.next();
    				for(int l = 0; l < bindingNames.size(); l++)
	       			{
		   				String val = bindingSet.getValue(bindingNames.get(l)).stringValue();
		   				antwoorden.add(bindingNames.get(l)+ k + "-->"+val+"\n");
		   			}
		   			k++;
				}
			    antwoord.setText(antwoorden.toString());
    		} catch(Exception e1)
    		{
    			antwoord.setText(e1.toString());
    			System.out.print(e1.toString());
    		}
        }
	}
	

	
	public static void main(String[] args)
	{
		OntologyG o = new OntologyG();			
	}
}