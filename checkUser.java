import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class checkUser {
	
	public static void main(String[] args) throws IOException {
		
		File inFile = new File("password.txt");
		Scanner userinput = new Scanner(System.in);
		Scanner sc = new Scanner(inFile);
		List<String> login = new ArrayList<>();
		
		System.out.print("Enter username: ");
		String username = userinput.next();		
		System.out.print("Enter password: ");
		String password = userinput.next();
		
		while(sc.hasNextLine()){
			login.add(sc.nextLine());
		}
		if (login.contains(username + "\t" + md5(password))){
			System.out.println("Registered user and password found.");
		}else{
			System.out.println("User and/or password not found.");
		}
	}
	
	public static String md5(String input) {
		
		String md5 = null;
		
		if(null == input) return null;
		
		try {
			//Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");
			
			//Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());
			
			//Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e){
			
			e.printStackTrace();
			
		}
		return md5;
	}
	
}