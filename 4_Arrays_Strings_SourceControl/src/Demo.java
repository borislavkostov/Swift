import java.util.Arrays;

public class Demo {
	public static void main(String args[]) {
		int heights[] ={1,2,3,5,3,3,2,2,1,1,3,3,2,3} ;
		int weights[] = {1,2,3,5,6,3,7,3124,9,1} ;
		Arrays.sort(heights);
		for (int i : heights) {
			System.out.print(i+" ");
		}
		System.out.println(heights.length);
		System.out.println(Arrays.equals(heights, weights));
		System.out.println(Arrays.binarySearch(heights,3));
	}
}
