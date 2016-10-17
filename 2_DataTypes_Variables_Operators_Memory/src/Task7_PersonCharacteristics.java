import java.time.Year;
import java.util.Scanner;

public class Task7_PersonCharacteristics
{
	public static void main(String args[])
	{
		System.out.println("Enter First name");
		Scanner input = new Scanner(System.in);
		String firstName = input.nextLine();
		System.out.println("Enter last name");
		String lastName = input.nextLine();
		System.out.println("Enter year of birth");
		int yearOfBirth = input.nextInt();
		System.out.println("Enter your weight");
		double weight = input.nextDouble();
		System.out.println("Enter your height");
		int height = input.nextInt();
		System.out.println("Enter your job");
		String job = input.next();
		int years =Year.now().getValue() - yearOfBirth;
		System.out.printf("%s %s is %d years old. His weight is %.2f and he is %d cm tall. He is a %s.",firstName,lastName,years,weight,height,job);
	}
}
