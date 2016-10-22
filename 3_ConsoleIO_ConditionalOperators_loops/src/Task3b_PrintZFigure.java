import java.util.Scanner;

public class Task3b_PrintZFigure {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		for(int i = 1; i<=a;i++){
			System.out.print("*");
		}
		System.out.println();
		for(int j = 0; j<a-2;j++){
			for(int i =a-4;i>=j-1;i--){
				System.out.print(" ");
			}
			System.out.println("*");
		}
		for(int i = 1; i<=a;i++){
			System.out.print("*");
		}
	}
}
