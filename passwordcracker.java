import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class passwordcracker {
	
	public static void main(String[] args) throws IOException {
		
		File file1 = new File("dictionary.txt");
		File file2 = new File("password.txt");
		Scanner userinput = new Scanner(System.in);
		Scanner sc1 = new Scanner(file1);
		Scanner sc2 = new Scanner(file2);
		Map<String, String> dictionary = new HashMap<String, String>();
		Map<String, String> registered = new HashMap<String, String>();
		//ArrayList<String> words = new ArrayList<String>();
		
		//String[] type2stuffonly;
		
		while(sc1.hasNextLine()){
			String type1 = sc1.nextLine();
			String type1hash = md5(type1);
			dictionary.put(type1, type1hash);
			//words.add(type1);
		}
		
		System.out.print("Which username to hack? ");
		String username = userinput.next();
		
		while(sc2.hasNextLine()){
			String[] tokens = sc2.nextLine().split("\t");
			registered.put(tokens[0], tokens[1]);			
		}		
		if (registered.containsKey(username)){
			System.out.println("Registered user found.");
			if(dictionary.containsValue(registered.get(username))){
				System.out.println("The user used the dictionary word, '" + getKeyFromValue(dictionary, registered.get(username)) + "'");
			}else{
				System.out.println("The user did not use a dictionary word.");
			}
		}else{
			System.out.println("User was not found.");
		}
		
/*		while(sc1.hasNextLine()){
			String type1 = sc1.nextLine();
			String type2stuff[] = {"0","1","2","3","4","5","6","7","8","9","@","#","$","%","&"};
			String type2[] = new String[3];
			
			type2[0] = type1;
			for(int i=0; i<type2stuff.length; i++){
				
			}
		}*/
		
		/*String type2stuff = "1234567890@#$&";
		
		File outFile = new File("type2withoutword.txt");
		FileWriter fw = new FileWriter(outFile);
		PrintWriter pw = new PrintWriter(fw);
		
		ArrayList<String> without = new ArrayList<String>();
		without = permutation(type2stuff);
		for(int i=0; i<without.size(); i++){
			pw.println(without.get(i));
		}
		pw.close();*/
		
		
		
		long startTime = System.nanoTime();
		long endTime = System.nanoTime();
		System.out.println();
		System.out.println("It took " + (endTime - startTime) + " ns to crack the given password."); 
	}
	
/*	public static ArrayList<String> permutation(String s){
		ArrayList<String> res = new ArrayList<String>();
		if(s.length()==1){
			res.add(s);
		}else if(s.length()>1){
			int lastIndex = s.length()-1;
			String last = s.substring(lastIndex);
			String rest = s.substring(0, lastIndex);
			
			res = merge(permutation(rest), last);
		}
		return res;
	}
	public static ArrayList<String> merge(ArrayList<String> list, String c) {
	    ArrayList<String> res = new ArrayList<String>();
	    for (String s : list) {
	        for (int i = 0; i <= s.length(); ++i) {
	            String ps = new StringBuffer(s).insert(i, c).toString();
	            res.add(ps);
	        }
	    }
	    return res;
	}
*/	
	public static Object getKeyFromValue(Map<String, String> a, Object b){
		for(Object o : a.keySet()){
			if(a.get(o).equals(b)){
				return o;
			}
		}
		return null;
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