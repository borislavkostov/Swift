import java.util.Scanner;

public class Task2c_PrintOnlyEvenNumbers {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int a = 0;
		for (int i = 1; i <= number; i++) {
			a = input.nextInt();
			if (a % 2 == 0) {
				System.out.println(a);
			}
		}
	}
}
