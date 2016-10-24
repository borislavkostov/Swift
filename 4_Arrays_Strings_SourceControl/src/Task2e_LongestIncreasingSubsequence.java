import java.util.Arrays;
import java.util.Scanner;

public class Task2e_LongestIncreasingSubsequence {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] number = new int[n];
		int start = 0;
		int end = 0;
		int startT = 0;
		int endT = 0;
		for (int i = 0; i < number.length; i++) {
			number[i] = input.nextInt();
		}
		int sum = 0;
		int temp = 1;
		for (int i = 0; i < number.length - 1; i++) {
			if (number[i] < number[i + 1]) {
				start = i;
				temp++;
				if (temp >= sum) {
					end = i;
					sum = 0;
					sum = temp;
				}
			} else {
				start = i;
				temp = 1;
			}
		}
		for (int i = start; i <= end; i++) {
			System.out.print(number[i] + " ");
		}
	}
}
