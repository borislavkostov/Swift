import java.util.Scanner;

public class Task0d_ReadNNumbers {
	public static void main(String arg[]) {
		Scanner input = new Scanner(System.in);
		int a = 0;
		int b = input.nextInt();
		for (int i = 1; i <= b; i++) {
			a = input.nextInt();
			System.out.println(a);
		}

	}
}
