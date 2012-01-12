//test
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class User {
	private	String naam;

	public User(String naam){
		this.naam = naam;
	}

	public void setNaam(String naam){
		this.naam = naam;
	}

	public String getNaam(){
		return naam;
	}

	public static void makeUserFile(String username){
		try{
			// Create file 
			Writer output = null;
			File file = new File(username+".txt");
			output = new BufferedWriter(new FileWriter(file));
			output.write("");
			//Close the output stream
			output.close();
			Scanner sc = null;
			sc = new Scanner(new FileReader("Users.txt"));
			String usernames = ""; 
			while (sc.hasNext())
				usernames = usernames + "\n" + sc.next();
			FileWriter usernew = new FileWriter("Users.txt");
			BufferedWriter outuser = new BufferedWriter(usernew);
			outuser.write(usernames + "\n" + username);
			//Close the output stream
			outuser.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	//retourneerd true als de user al bestaat anders retourneerd het false
	public static boolean userExists(String username){
		try{
			Scanner sc = new Scanner(new FileReader("Users.txt"));
			String user; 
			while (sc.hasNext()){
				user = sc.next();
				if(user.equals(username))
					return true;
			}
		} 
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		return false;

	}

	public static boolean fileIsEmpty(String username){
		try{
			Scanner sc = new Scanner(new FileReader(username + ".txt"));
			String data;
			while (sc.hasNext()){
				sc.next();
				data = sc.next();
				if(data.equals("no"))
					return true;
			}
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		return false;

	}

	public static userInfo readfile(String username)
	{
		userInfo user;
		ArrayList<String> selected = new ArrayList<String>();
		ArrayList<String> unselected = new ArrayList<String>();
		ArrayList<String> tracks = new ArrayList<String>();
		Scanner sc = null;
		try{
			sc = new Scanner(new FileReader(username+".txt"));

			if(sc.next().equals("Selectedtags")){
				while(sc.hasNext() && !sc.next().equals("unselectedTag"))
					selected.add(sc.next());
			}
			if(sc.next().equals("unselectedTag")){
				while(sc.hasNext() && !sc.next().equals("Tracks"))
					unselected.add(sc.next());
			}
			if(sc.next().equals("Tracks")){
				while(sc.hasNext())
					tracks.add(sc.next());

			}
			user = new userInfo(selected, unselected, tracks);
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
			return null;
		}
		return user;
	}

	public static void writeData(String username, ArrayList<String> selectedTag, ArrayList<String> unselectedTag, ArrayList<String> lied){
		try{
			// Create file
			Writer output = null;
			File file = new File(username+".txt");
			output = new BufferedWriter(new FileWriter(file));
			String selected = "";
			String unselected = "";
			String tracks = "";
			String []sT = new String[selectedTag.size()];
			selectedTag.toArray(sT);
			for(int i =0; i < sT.length ; i++)
				selected = selected + sT[i] + "\n";
			String []uT = new String[unselectedTag.size()];
			unselectedTag.toArray(uT);
			for(int i =0; i < uT.length ; i++)
				selected = selected + uT[i] + "\n";
			String []T = new String[lied.size()];
			lied.toArray(T);
			for(int i =0; i < T.length ; i++)
				selected = selected + T[i] + "\n";

			Scanner sc = new Scanner(new FileReader(username+".txt"));
			if(!sc.hasNext()){
				output.write("Selectedtags" + "\n" + selected + "\n" + "unselectedTag" + "\n" + unselected + "\n" + "Tracks" + "\n" + tracks);
				output.close();
			}
			else{
				

				if(sc.next().equals("Selectedtags")){
					while(sc.hasNext() && !sc.next().equals("unselectedTag"))
						selected = selected + sc.next() + "\n";
				}
				if(sc.next().equals("unselectedTag")){
					while(sc.hasNext() && !sc.next().equals("Tracks"))
						unselected = unselected + sc.next() + "\n";
				}
				if(sc.next().equals("Tracks")){
					while(sc.hasNext())
						tracks = tracks + sc.next() + "\n";
				}
				output.write("Selectedtags" + "\n" + selected + "\n" + "unselectedTag" + "\n" + unselected + "\n" + "Tracks" + "\n" + tracks);
				output.close();
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (Exception e){//Catch exception if any
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}


}
