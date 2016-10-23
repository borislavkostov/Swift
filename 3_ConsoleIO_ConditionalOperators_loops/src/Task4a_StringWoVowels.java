
public class Task4a_StringWoVowels {
	public static void main(String args[]){
		String text = "Peter loves dogs";
		String textf=text.replaceAll("[aeiou]","");
		System.out.println(textf);
	}
}
