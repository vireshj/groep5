import java.io.FileNotFoundException;
import java.io.FileReader;
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
	
	public boolean userExist(String filename)
	{
		Scanner sc = null;
		try 
		{
			sc = new Scanner(new FileReader("Users.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		int k; //totaal aantal amplifiers
		k = sc.nextInt();
		while (sc.hasNext())
		{
			
		}
	}


}
