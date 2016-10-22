import java.util.Scanner;

public class Task0f_ReadNNumbersOnNewLines {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfNumbers = input.nextInt();
		String a;
		for (int i = 1; i <= numberOfNumbers; i++) {
			a = input.nextLine();
			System.out.print(a + " ");
		}
	}
}
