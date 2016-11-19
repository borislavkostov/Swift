import java.util.Scanner;

public class Task1 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		while (true) {
			String text = input.nextLine();
			if (text.equals("END")) {
				break;
			}
			String[] st = text.trim().split(" ");
			try {
				int a = Integer.parseInt(st[0]);
				System.out.println("Number");
			} catch (NumberFormatException e) {
				System.out.println("Not a number");
			}
			try {
				int b = Integer.parseInt(st[1]);
				System.out.println("Number");
			} catch (NumberFormatException e) {
				System.out.println("Not a number");
			}
		}
	}
}
