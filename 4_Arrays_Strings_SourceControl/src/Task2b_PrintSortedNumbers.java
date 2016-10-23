import java.util.Arrays;
import java.util.Scanner;

public class Task2b_PrintSortedNumbers {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] number = new int[n];
		for (int i = 0; i < number.length; i++) {
			number[i] = input.nextInt();
		}
		Arrays.sort(number);
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i]+" ");
		}
	}
}
