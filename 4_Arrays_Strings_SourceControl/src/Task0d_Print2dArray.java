
public class Task0d_Print2dArray {
	public static void main(String args[]) {
		int[][] numbers = new int[4][4];
		int k = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				k++;
				numbers[i][j] = k;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				System.out.print(numbers[i][j] + " ");
			}
			System.out.println();
		}
	}
}
