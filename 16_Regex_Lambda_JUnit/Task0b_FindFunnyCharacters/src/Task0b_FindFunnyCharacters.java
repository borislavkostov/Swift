import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task0b_FindFunnyCharacters {
	public static void main(String args[]) {
		String text = "❅()&*^%$^%*(&)_❅❅☎☎☎$$$♚♚tieosf❅❅☭☭☎☎♚♚♚☎☎++++☮♚♚☮❅☠re=====wrwgv☠☠❅❅☎☎☎☮☮☠☠\\☭☭♚♚❅❅❅☮☮☮☭☭☭❅❅☮☠☠☠☮☮☮❅❅☮☭☭☮☮☭";
		Pattern pattern = Pattern.compile("[^a-zA-z0-9~!@#$%^&*()_+-=/\\)]");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			System.out.printf("The funny symbol is [%s]%n",matcher.group());
		}
	}
}
