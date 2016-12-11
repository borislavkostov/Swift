import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task0a_FindIntegers {
	public static void main(String args[]) {
		String text = "fsdfq312d1-321edv -31 dasd";
		Pattern pattern = Pattern.compile("-?[0-9]+");
		Matcher m = pattern.matcher(text);
		while (m.find()) {
			System.out.printf("Number is [%s] and it is starts from index [%d]%n", 
					m.group(), m.start());
		}
	}
}
