import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class User {
	private	String naam;
	/** 
	 * maakt een nieuwe User klasse met de meegegeven parameter : String naam
	 */
	public User(String naam){
		this.naam = naam;
	}
	/** 
	 * set de naam van deze klasse naar de meegegeven parameter : String naam
	 */
	public void setNaam(String naam){
		this.naam = naam;
	}
	/** 
	 * Retourneert de naam deze klasse
	 * @return String naam 
	 */
	public String getNaam(){
		return naam;
	}
	/** 
	 * De gegevens van de user wordt gereset, de parameter String username bepaald welke user
	 */
	public static void reset(String username){
		try{
			// Create file 
			Writer output = null;
			File file = new File(username+".txt");
			output = new BufferedWriter(new FileWriter(file));
			output.write("*");
			//Close the output stream
			output.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	/** 
	 * Maakt een nieuwe file aan op basis van de meegevene parameter : String username
	 */
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
	/** 
	 * Retourneert true als de user bestaat anders false
	 * @return boolean true als de user bestaat anders false
	 */
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
	/** 
	 * Retourneert true als de file niet leeg is anders false
	 * @return boolean true als de file niet leeg is anders false
	 */
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
	/** 
	 * Retourneert een userInfo klasse op basis van de parameter String username
	 * @return userInfo 
	 */
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
			if(sc.hasNext())
			{
				if(sc.next().equals("Selectedtags")){
					while(sc.hasNext() && !temp.equals("UnselectedTag")){
						temp = sc.nextLine();					
						if(!temp.equals("UnselectedTag") && !temp.equals(""))
							selected.add(temp);
					}
				}
				if(temp.equals("UnselectedTag")){
					while(sc.hasNext() && !temp.equals("Tracks"))
					{
						temp = sc.nextLine();
						if(!temp.equals("Tracks") && !temp.equals(""))
							unselected.add(temp);
					}
				}
				if(temp.equals("Tracks")){
					while(sc.hasNext())
					{
						temp = sc.nextLine();
						if(!temp.equals(""))
							tracks.add(temp);					
					}

				}
			}
			user = new userInfo(selected, unselected, tracks);
		}catch (Exception e){//Catch exception if any
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
			return null;
		}
		return user;
	}
	/** 
	 * de gegevens van de user worden weg geschreven naar de textfile String username
	 */
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
