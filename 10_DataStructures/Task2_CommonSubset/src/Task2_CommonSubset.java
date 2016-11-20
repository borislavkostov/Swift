import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Task2_CommonSubset {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int a;
		TreeSet<Integer> firstSet = new TreeSet<>();
		TreeSet<Integer> secondSet = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			a = input.nextInt();
			firstSet.add(a);
		}
		for (int i = 0; i < m; i++) {
			a = input.nextInt();
			secondSet.add(a);
		}
		List<Integer> compare = new ArrayList<>();
		for (Integer integer : secondSet) {
			for (Integer fint : firstSet) {
				if (integer == fint) {
					compare.add(fint);
				}
			}
		}
		if (compare.size()!=0){
			for (Integer integer : compare) {
				System.out.print(integer+" ");
			}
		}else{
			System.out.println("NO");
		}
	}
}
