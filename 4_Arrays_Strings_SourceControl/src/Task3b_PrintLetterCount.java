import java.util.Arrays;

public class Task3b_PrintLetterCount {
	public static void main(String args[]) {
		String text = "Programming";
		char[] chArray = text.toCharArray();
		Arrays.sort(chArray);
		int sum = 0;
		for (int i = 0; i <chArray.length-1; i++) {
			if (chArray[i]==chArray[i+1]) {
				sum++;
			}else{
			sum++;
			System.out.println(chArray[i]+"("+sum+")");
			}
			if(chArray[i]!=chArray[i+1]){
				sum=0;
			}
			if(i==chArray.length-2){
				for (int j = i+1; j < chArray.length; j++) {
					sum++;
					System.out.println(chArray[j]+"("+sum+")");
				}
			}
		}
	}
}
