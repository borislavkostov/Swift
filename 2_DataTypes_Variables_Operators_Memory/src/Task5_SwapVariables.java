
public class Task5_SwapVariables
{
	public static void main(String args[])
	{
		int a = 5;
		int b = 3;
		System.out.printf("a = %d b = %d\n",a,b);
		int temp = a;
		a = b;
		b = temp;
		System.out.printf("a = %d b = %d",a,b);
	}
}
