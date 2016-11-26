import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task5_ChildPlay {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		List<Integer> numbers = new ArrayList<>();
		int round = 0;
		int number = 0;
		for (int i = 0; i < n; i++) {
			number = input.nextInt();
			numbers.add(number);
		}
		for (int i = 0; i < numbers.size()-1; i++) {
			if(numbers.get(i)<numbers.get(i+1)){
				numbers.remove(i);
				round++;
			}
		}
		System.out.println(round);
	}
}
