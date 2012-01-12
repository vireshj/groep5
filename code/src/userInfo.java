import java.util.*;

public class userInfo {
	private ArrayList<String> selected;
	private ArrayList<String> unselected;
	private ArrayList<String> tracks;
	
	public userInfo(ArrayList<String> selected,ArrayList<String> unselected, ArrayList<String> tracks){
		this.selected = selected;
		this.unselected = unselected;
		this.tracks = tracks;
	}
	
	public ArrayList<String>getSelected(){
		return selected;
	}
	
	public ArrayList<String> getUnselected(){
		return unselected;
	}
	
	public ArrayList<String> getTracks(){
		return tracks;
	}
}
