import java.util.Scanner;

public class Task2b_PrintReversedSequence {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int a = 0;
		String reversedNumbers ="";
		for (int j = 1; j <= number; j++) {
			a = input.nextInt();
			reversedNumbers+=a+" ";
		}
		System.out.println(new StringBuilder(reversedNumbers).reverse().toString().trim());//I'm using trim to remove white space before first number
	}
}
