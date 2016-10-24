import java.util.Arrays;
import java.util.Scanner;

public class Task2d_PrintSplitIndex {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] number = new int[n];
		for (int i = 0; i < number.length; i++) {
			number[i] = input.nextInt();
		}
		int sumLeft = 0;
		int sumRight = 0;
		for (int i = 0; i < number.length; i++) {
			for (int j = i + 1; j < number.length; j++) {
				sumRight++;
			}
			for (int j = i; j >= 0; j--) {
				sumLeft++;
			}
			if (sumLeft == sumRight) {
				System.out.println(number[i]);
			}else{
				sumLeft=0;
				sumRight=0;
			}
		}
	}
}
