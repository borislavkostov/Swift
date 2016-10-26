
public class Task3c_CaesarCipher {
	public static void main(String args[]) {
		String text = "J mpwf qsphsbnnjoh.";
		String code = "encode";
		for (int i = 0; i < text.length(); i++) {
			if (code.equals("decode")) {
				if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z'
						|| text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
					System.out.printf("%c", text.charAt(i) + 1);
				} else {
					System.out.print(text.charAt(i));
				}
			} else {
				if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z'
						|| text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
					System.out.printf("%c", text.charAt(i) - 1);
				} else {
					System.out.print(text.charAt(i));
				}
			}
		}
	}
}
