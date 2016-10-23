import java.util.Arrays;
import java.util.Scanner;

public class Task2a_PrintLargestNumber {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] number = new int[n];
		for (int i = 0; i < number.length; i++) {
			number[i] = input.nextInt();
		}
		Arrays.sort(number);
		System.out.println(number[number.length - 1]);
	}
}
