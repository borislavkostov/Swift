import java.util.Scanner;

public class Task1c_PrintSumOfDigits
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int result = 0;
		while(number != 0)
		{
			result = result + number % 10;
			number /= 10;
		}
		System.out.println(result);
	}
}
