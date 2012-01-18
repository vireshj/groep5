import java.util.*;

public class userInfo {
	private ArrayList<String> selected;
	private ArrayList<String> unselected;
	private ArrayList<String> tracks;
	/** 
	 * maakt een nieuwe userInfo klasse op basis van de parameters : ArrayList<String> selected,ArrayList<String> unselected, ArrayList<String> tracks
	 */
	public userInfo(ArrayList<String> selected,ArrayList<String> unselected, ArrayList<String> tracks){
		this.selected = selected;
		this.unselected = unselected;
		this.tracks = tracks;
	}
	/** 
	 * Retourneert de selected ArrayList van deze klasse
	 * @return ArrayList<String> 
	 */
	public ArrayList<String>getSelected(){
		return selected;
	}
	/** 
	 * Retourneert de unselected ArrayList van deze klasse
	 * @return ArrayList<String> 
	 */
	public ArrayList<String> getUnselected(){
		return unselected;
	}
	/** 
	 * Retourneert de tracks ArrayList van deze klasse
	 * @return ArrayList<String> 
	 */
	public ArrayList<String> getTracks(){
		return tracks;
	}
}
