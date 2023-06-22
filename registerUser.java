import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.io.*;

public class registerUser {
	
	public static void main(String[] args) throws IOException {
		
		File outFile = new File("password.txt");
		FileWriter fw = new FileWriter(outFile, true);
		PrintWriter pw = new PrintWriter(fw);
		Scanner userinput = new Scanner(System.in);
		
		System.out.print("Enter new username: ");
		String username = userinput.next();		
		System.out.print("Enter new password: ");
		String password = userinput.next();
			
		pw.println(username + "\t" + md5(password));
		pw.close();
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