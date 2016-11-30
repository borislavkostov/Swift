
public class engine {
	public static void main(String[] args) {
		printWall();
	}

	public static void printWall() {
		for (int i = 0; i < 60; i++) {
			System.out.print("#");
		}
		System.out.println();
		for (int i = 0; i < 19; i++) {
			System.out.print("#");
			for (int j = 0; j < 58; j++) {
				System.out.print(" ");
			}
			System.out.println("#");
		}
		for (int i = 0; i < 60; i++) {
			System.out.print("#");
		}
	}
}
