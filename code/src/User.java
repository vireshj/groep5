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
			output.write("*");
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
				data = sc.next();
				if(data.equals("*"))
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
		String temp = "";
		ArrayList<String> selected = new ArrayList<String>();
		ArrayList<String> unselected = new ArrayList<String>();
		ArrayList<String> tracks = new ArrayList<String>();
		Scanner sc = null;
		try{
			sc = new Scanner(new FileReader(username+".txt"));
			if(sc.next().equals("Selectedtags")){
				while(sc.hasNext() && !temp.equals("UnselectedTag")){
					temp = sc.nextLine();
					if(temp.equals(""))
						temp = sc.nextLine();						
					if(!temp.equals("UnselectedTag"))
						selected.add(temp);
				}
			}
			if(temp.equals("UnselectedTag")){
				while(sc.hasNext() && !temp.equals("Tracks"))
				{
					temp = sc.nextLine();
					if(temp.equals(""))
						temp = sc.nextLine();
					if(!temp.equals("Tracks"))
						unselected.add(temp);
				}
			}
			if(temp.equals("Tracks")){
				while(sc.hasNext())
					temp = sc.nextLine();
					tracks.add(temp);

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
			File file = new File(username+".txt");
			Writer output = new BufferedWriter(new FileWriter(file));
			String selected = "";
			String unselected = "";
			String tracks = "";
			for(String s : selectedTag)
				selected += s + "\n";
			for(String s : unselectedTag)
				unselected += s + "\n";
			for(String s : lied)
				tracks += s + "\n";

			Scanner sc = new Scanner(new FileReader(username+".txt"));
			output.write("Selectedtags" + "\n" + selected + "UnselectedTag" + "\n" + unselected + "Tracks" + "\n" + tracks);
			output.close();
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (Exception e){//Catch exception if any
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}


}
