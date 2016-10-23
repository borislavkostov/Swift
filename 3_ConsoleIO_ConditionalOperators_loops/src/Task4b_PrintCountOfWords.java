public class Task4b_PrintCountOfWords {
	public static void main(String args[]){
		String text = "Peter loves dogs. He doesn’t like cats.";
		String words[]=text.split("[\\W\\s]+");

		System.out.println(words.length);
		for (String st : words) {
			if (st.length()<=1) {
			System.out.println(st);//Find it but can't delete the symbol with less then two symbols
			}
		}
	}
}