import java.util.Scanner;

public class Task4_InchToCm
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.print("cm = ");
		double cm = input.nextDouble();
		double inch = cm * 2.54;
		System.out.printf("%.2fcm = %.2finches",cm,inch);
	}
}
