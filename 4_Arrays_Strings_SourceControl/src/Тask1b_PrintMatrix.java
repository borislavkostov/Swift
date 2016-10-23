import java.util.Scanner;

public class Тask1b_PrintMatrix {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		 int [][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

	        dummyPrint(array);

	        System.out.println();

	        prettyPrint(array);
	    }

	    private static void dummyPrint(int[][] array) {
	        System.out.print("Dummy Print: ");

	        for(int j = 0; j < array[0].length; j++) {
	            if(j%2 == 0) {
	                for(int i = 0; i < array.length; i++)
	                    System.out.printf("%2d ", array[i][j]);
	            } else {
	                for(int i = array.length-1; i >= 0; i--)
	                    System.out.printf("%2d ", array[i][j]);
	            }
	        }

	        System.out.println();
	    }

	    private static void prettyPrint(int[][] array) {
	        System.out.println("Pretty Print;");
	        System.out.println("*************");
	        for(int j = 0; j < array[0].length; j++) {
	            if(j%2 == 0) {
	                for(int i = 0; i < array.length; i++)
	                    System.out.printf("%2d ", array[i][j]);
	            } else {
	                for(int i = array.length-1; i >= 0; i--)
	                    System.out.printf("%2d ", array[i][j]);
	            }


	            System.out.println();
	        }
    }
}
