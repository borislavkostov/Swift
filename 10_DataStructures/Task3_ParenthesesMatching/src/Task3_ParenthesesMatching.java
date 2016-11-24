
import java.util.Scanner;

public class Task3_ParenthesesMatching {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		System.out.println(isItCorrect(line));
		
	}
	public static boolean isItCorrect(String line){
		if(counter('{',line)!=counter('}',line)){
			return false;
		}else if(counter('[',line)!=counter(']',line)){
			return false;
		}else if(counter('(',line)!=counter(')',line)){
			return false;
		}else{
			return true;
		}
	}
	public static int counter(char symbol,String line){
		int counter =0;
		for (int i = 0; i <line.length(); i++) {
			if(line.charAt(i)==symbol){
				counter++;
			}
		}
		return counter;
	}
}
