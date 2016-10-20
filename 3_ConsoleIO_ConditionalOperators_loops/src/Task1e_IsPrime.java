import java.util.Scanner;

public class Task1e_IsPrime
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int number  = input.nextInt();
		System.out.println(isPrime(number));
	}
	public static boolean isPrime(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}
