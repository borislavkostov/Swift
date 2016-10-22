import java.util.Scanner;

public class Task3a_PrintSquare {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		for(int i = 0; i<a;i++){
			System.out.print("*");
		}
		System.out.println();
		for(int j = 0; j<a-1;j++){
			System.out.print("*");
				for(int i = 0; i<a-2;i++){
					System.out.print(" ");
				}
		System.out.print("*");
		System.out.println();
		}
		for(int i = 0; i<a;i++){
			System.out.print("*");
		}
	}
}
