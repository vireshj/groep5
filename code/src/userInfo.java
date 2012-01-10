import java.util.*;

public class userInfo {
	private String selected;
	private String unselected;
	private String tracks;
	
	public userInfo(String selected,String unselected, String tracks){
		this.selected = selected;
		this.unselected = unselected;
		this.tracks = tracks;
	}
	
	public String getSelected(){
		return selected;
	}
	
	public String getUnselected(){
		return unselected;
	}
	
	public String getTracks(){
		return tracks;
	}
}
