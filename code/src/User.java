//test
import java.io.*;
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
			output.write("yes \nno");
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

	public void writeData(String username, String selectedTag, String unselectedTag){
            // Create file
			Writer output = null;
			File file = new File(username+".txt");
			output = new BufferedWriter(new FileWriter(file));
			if(fileIsEmpty(username)){
    			output.write("yes\n"+selectedTag+"\nno"+unselectedTag);
    			output.close();
			}
			else{
			Scanner sc = null;
			sc = new Scanner(new FileReader(username+".txt"));
			String yes = "";
			String no = "";
			yes = sc.next();
			while (sc.hasNext())
				yes = yes + "\n" + sc.next();
				if(sc.next.equals("no"))
				    while(sc.hasNext())
                        no = no + "\n" + sc.next();
			FileWriter usernew = new FileWriter("Users.txt");
			BufferedWriter outuser = new BufferedWriter(usernew);
			outuser.write(usernames + "\n" + username);
			//Close the output stream
			outuser.close();
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}


}
