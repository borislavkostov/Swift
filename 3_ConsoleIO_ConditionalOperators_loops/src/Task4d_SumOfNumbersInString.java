
public class Task4d_SumOfNumbersInString {
	public static void main(String args[]){
		String text = "Helen has 3 dogs and 11 cats";
		String number[] = text.split("\\D");
		int numbers[]=new int[number.length];
		int i=0;
		for (String st : number) {
			System.out.println(st);
			numbers[i]=Integer.parseInt(st);
			i++;
		}
		int sum = 0;
		for (int num : numbers) {
			System.out.println(num);
			sum +=num;
		}
		System.out.println(sum);
	}
}
