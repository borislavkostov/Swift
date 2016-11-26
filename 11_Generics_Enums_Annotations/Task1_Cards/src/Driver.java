
public class Driver {
	public static void main(String args[]) {

		for (CardSuit cardSuit : CardSuit.values()) {
			System.out.print(cardSuit + ", ");
		}
		System.out.println();
		for (CardRank value : CardRank.values()) {
			System.out.print(value + ", ");
		}

	}
}
