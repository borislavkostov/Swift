import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String line = "";
		ArrayList<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack(list);
		for (;;) {
			line = input.nextLine();
			if (!line.equals("END")) {
				lineReader(line, stack);
			} else {
				stack.getValues();
				break;
			}
		}
	}

	public static void lineReader(String line, Stack<Integer> stack) {
		String[] st = line.trim().split(" ");
		if (st[0].equals("PUSH")) {
			stack.push(Integer.parseInt(st[1]));
		} else if (st[0].equals("MAX")) {
			stack.max();
		} else if (st[0].equals("POP")) {
			stack.pop();
		}
	}
}
