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


public class Ontology{
	private RepositoryConnection dbCon; 
	private String endpointURL = "http://api.kasabi.com/dataset/musicbrainz/apis/sparql?apikey=413cf0addc8edc2c5d3e92ba7134461a91de252e";
	
	public Ontology(){
		try{
			Repository dbtune = new HTTPRepository(endpointURL);
			dbtune.initialize();
			dbCon = dbtune.getConnection();
		}catch(Exception e1){
			System.out.print(e1.toString());
		}
	}
	
	public Lied findSong(Lied invoer){
		return querieOntology(querie(invoer));
	}
	
	public String querie(Lied invoer){
		String nummer = invoer.getNaam();
		String artiest = invoer.getArtiest();
		String querie = "";
		return null;
	}
	
	public Lied querieOntology(String invoer){
		String resultaat = db(invoer);
		//process the string to extract useful information.
		return null;
	}
	
	public String db(String query){
       	try{
       		ArrayList<String> antwoorden = new ArrayList<String>();
   			int k = 1;
			TupleQuery tupleQuery = dbCon.prepareTupleQuery(QueryLanguage.SPARQL, query);
   			TupleQueryResult result = tupleQuery.evaluate();
   			List<String> bindingNames = result.getBindingNames();

   			while (result.hasNext()){
				BindingSet bindingSet = result.next();
    			for(int l = 0; l < bindingNames.size(); l++){
		   			String val = bindingSet.getValue(bindingNames.get(l)).stringValue();
		   			antwoorden.add(bindingNames.get(l)+ k + "-->"+val+"\n");
		   		}
		   		k++;
			}
			return antwoorden.toString();
    		}catch(Exception e1){
    			System.out.print(e1.toString());
    			return "error";
    		}
        }
}