import java.util.Scanner;

public class Task1a_PrintFirstDigit
{
 public static void main (String args[])
 {
	 
	 Scanner input = new Scanner(System.in);
	 /*
	  * THIS IS WORKING BUT IS WITH String and char Array
	 String number = input.nextLine();
	 char[] numbers = number.toCharArray();
	 System.out.println(numbers[0]);
	 */
	 int n, temp = 0;	 
     System.out.println("Enter the number");
     n = input.nextInt();
     while( n != 0 )
     {
         n = n/10;
         if(n==0)
         {
        	 break;
         }
         else
         {
        	 temp = n;
         }
     }
     	System.out.println(temp);
 }
}
