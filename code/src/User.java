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

	public void writeData(String username, ArrayList<String> selectedTag, ArrayList<String> unselectedTag, ArrayList<String> lied){
		try{
			FileWriter user = new FileWriter(username+".txt");
			BufferedWriter output = new BufferedWriter(user);
			if(fileIsEmpty(username)){
				output.write("SelectedTags\n" + selectedTag + "UnselectedTags\n" + unselectedTag + "Tracks\n"+ lied);
				output.close();
			}
			else{
				Scanner sc = null;
				sc = new Scanner(new FileReader(username+".txt"));
				String SelectedTags = "";
				String UnselectedTags = "";
				String liedjes = "";
				SelectedTags = sc.next();
				while (sc.hasNext())
				{					
					SelectedTags = SelectedTags + "\n" + sc.next();
					if(sc.next().equals("UnselectedTags"))
						while(sc.hasNext())
							UnselectedTags = UnselectedTags + "\n" + sc.next();
					FileWriter usernew = new FileWriter("Users.txt");
					BufferedWriter outuser = new BufferedWriter(usernew);
					outuser.write("\n" + username);
					//Close the output stream
					outuser.close();
				}
				}
			}
		
		catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}


}
