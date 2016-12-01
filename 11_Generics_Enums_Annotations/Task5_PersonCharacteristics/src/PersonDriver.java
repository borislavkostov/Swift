import java.time.LocalDate;
import java.util.Scanner;

import education.Education;
import education.HigherEducation;
import education.Primary;
import education.Secondary;

public class PersonDriver {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		String line = "";
		Person pr[] = new Person[n];
		for (int i = 0; i < pr.length; i++) {
			line = input.nextLine();
			// pr[i] = new Person();
			// pr[i] = lineReader(line);
		}
		for (int i = 0; i < pr.length; i++) {
			System.out.println(pr[i]);
		}
	}

}
