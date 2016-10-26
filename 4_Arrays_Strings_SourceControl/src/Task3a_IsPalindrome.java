
public class Task3a_IsPalindrome {
	public static void main(String args[]) {
		String text = "abbaabba";
		String reversed = new StringBuilder(text).reverse().toString();
		boolean isEqual = false;
		if (text.equals(reversed)) {
			isEqual = true;
		} else {
			isEqual = false;
		}
		System.out.println(isEqual);
	}
}
