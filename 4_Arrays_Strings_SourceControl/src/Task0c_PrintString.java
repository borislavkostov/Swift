import java.util.Scanner;

public class Task0c_PrintString {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		char[] symbol = text.toCharArray();
		for (int i = 0; i < symbol.length; i++) {
			System.out.println(symbol[i]);
		}
	}
}
