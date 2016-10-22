import java.util.Scanner;

public class Task3c_PrintChristmasTree {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int min_stars=1;
		for(int i = 0;i<a;i++){
			for(int j =a-1;j>i;j--){
				System.out.print(" ");
			}
			for(int k=0;k<min_stars;k++){
				System.out.print("*");
			}
			min_stars+=2;
			System.out.println();
		}
		min_stars=1;
		for(int i = 0;i<2;i++){
			for(int j =a-1;j>i;j--){
				System.out.print(" ");
			}
			for(int k=0;k<min_stars;k++){
				System.out.print("*");
			}
			min_stars+=2;
			System.out.println();
		}
	}
}
