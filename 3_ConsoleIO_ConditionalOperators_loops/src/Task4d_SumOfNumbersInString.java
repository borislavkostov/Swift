
public class Task4d_SumOfNumbersInString {
	public static void main(String args[]) {
		String text = "Helen has 3 dogs, 11 cats and 3 pigs";
		String number[] = text.split("\\D+");
		int numbers[] = new int[number.length];
		int sum = 0;
		for (int i = 1; i < number.length; i++) {
			//System.out.println(number[i].trim());
			numbers[i] = Integer.parseInt(number[i]);
		}
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		System.out.println(sum);

	}
}
