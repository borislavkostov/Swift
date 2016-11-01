import java.time.Year;
import java.util.Scanner;

public class Task4_PersonCharacteristics {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		String firstName = "";
		String lastName = "";
		int yearOfBirth = 0;
		double weight = 0;
		int height = 0;
		String job = "";
		int years = 0;
		for (int i = 0; i < num; i++) {
			firstName = input.next();
			lastName = input.next();
			yearOfBirth = input.nextInt();
			weight = input.nextDouble();
			height = input.nextInt();
			job = input.next();
			years = Year.now().getValue() - yearOfBirth;
			if (years < 18) {
				System.out.printf(
						"%s %s is %d years old. His weight is %.2f and he is %d cm tall. He is a %s.%s %s is under-aged",
						firstName, lastName, years, weight, height, job,
						firstName, lastName);
			} else {
				System.out.printf(
						"%s %s is %d years old. His weight is %.2f and he is %d cm tall. He is a %s.",
						firstName, lastName, years, weight, height, job);
			}
		}
	}
}
