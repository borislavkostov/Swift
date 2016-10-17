import java.util.Scanner;

public class Task2_LeapYear
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter year : ");
		int year = input.nextInt();
		boolean isLeapYear = year%4==0||year%400==0;
		System.out.println(isLeapYear);
		//Second test with if 
		if(year%4==0||year%400==0)
		{
			System.out.printf("%d is leap year\n",year);
		}
		else
		{
			System.out.printf("%d isn't leap year\n",year);
		}
	}
}
