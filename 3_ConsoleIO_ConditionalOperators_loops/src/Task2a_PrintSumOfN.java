import java.util.Scanner;

public class Task2a_PrintSumOfN {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfNumbers = input.nextInt();
		int a = 0;
		int sum = 0;
		for (int i = 1; i <= numberOfNumbers; i++) {
			a = input.nextInt();
			sum += a;
		}
		System.out.println(sum);
	}
}
