import java.util.Arrays;
import java.util.Scanner;

public class Task2c_PrintClusterCount {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] number = new int[n];
		for (int i = 0; i < number.length; i++) {
			number[i] = input.nextInt();
		}
		Arrays.sort(number);
		int sum = 0;
		int temp = 1;
		for (int i = 0; i < number.length-1; i++) {
			if (number[i] == number[i+1]) {
				temp++;
				if (temp > sum){
					sum=0;
					sum = temp;
				} 
			}else {
				temp = 1;
				
			}
		}
		System.out.println(sum);
	}
}
