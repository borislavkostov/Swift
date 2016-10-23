
public class Task4c_PrintEverySentence {
	public static void main(String args[]){
		String text = "Peter loves dogs. He doesn’t like cats. Maria likes cats";
		String textS[] = text.split("(?<=[.!?])");//which will split on every zero-length string that is preceded by a dot
		for (int i = 0; i < textS.length; i++) {
			System.out.println(textS[i].trim());
		}
	}
}
