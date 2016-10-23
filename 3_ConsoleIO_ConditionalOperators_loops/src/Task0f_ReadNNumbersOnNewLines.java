import java.util.Scanner;

public class Task0f_ReadNNumbersOnNewLines {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfNumbers = input.nextInt();
		String a="";
		String draft = "";
		for (int i = 0; i <=numberOfNumbers; i++) {
			a = input.nextLine();
			draft+=a+ " ";

		}
		System.out.print(draft);
	}
}
