import java.util.Scanner;

public class Task1f_ToBinaryAndHexa
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		System.out.println(Integer.toBinaryString(number));
		System.out.println(Integer.toHexString(number));
	}
}
