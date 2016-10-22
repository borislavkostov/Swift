import java.util.Scanner;

public class Task0c_ReadAge {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int age = input.nextInt();
		if (age >= 18) {
			System.out.println("Here is your dring");
		} else {
			System.out.println("Orange juice ?");
		}
	}
}
