import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class evaluate {

	public static void main(String[] args) throws FileNotFoundException{
		File file = new File("dictionary.txt");
		Scanner userinput = new Scanner(System.in);
		Scanner sc = new Scanner(file);
		List<String> words = new ArrayList<String>();
		
		System.out.print("Enter password to be evaluated: ");
		String password = userinput.next().toLowerCase();
		
		while(sc.hasNextLine()){
			String word = sc.nextLine().toLowerCase();
			words.add(word);
		}
		
		System.out.println(strength(words, password));
	}
	
	public static String strength(List<String> words, String pass){
		if(words.contains(pass)){
			return "The password you input is WEAK";
		}
		for(int i=0; i<words.size(); i++){
			if(pass.matches("(.*)"+words.get(i)+"(.*)")){
				return "The password you input is MODERATE";
			}
		}
		return "The password you input is STRONG";
	}
}