import java.util.Scanner;

public class Task2b_PrintReversedSequence {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int a = 0;
		while (number > 0) {
			for (int j = 1; j <= number; j++) {
				a = input.nextInt();
				if (j == number) {
					System.out.println(a);
					number--;
				}
			}
		}

	}
}
