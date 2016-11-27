import java.util.Scanner;

public class Task6_WordReplacement {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		StringBuilder result = new StringBuilder(input.nextLine());
		int n = input.nextInt();
		input.nextLine();
		String replacer = "";
		for (int i = 0; i < n; i++) {
			replacer = input.nextLine();
			String text = replacer(result.toString(), replacer);
			result.delete(0, result.length());
			result.append(text);
		}
		System.out.println(result.toString());
	}

	public static String replacer(String text, String replacer) {
		String[] st = replacer.trim().split(" ");
		text = text.replaceAll("(?i)" + st[0], st[1]);
		return text;
	}
}
