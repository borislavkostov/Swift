import java.util.List;
import java.util.ArrayList;

public class Driver {
	public static void main(String args[]) {
		Card card = new Card(CardRank.Two, CardSuit.Clubs);
		Card cardC = new Card(CardRank.Two, CardSuit.Clubs);
		List<CardSuit> suit = new ArrayList<>();
		List<CardRank> rank = new ArrayList<>();
		for (CardSuit cardSuit : CardSuit.values()) {
			suit.add(cardSuit);
		}
		System.out.println();
		for (CardRank value : CardRank.values()) {
			rank.add(value);
		}
		for (int i = 0; i < rank.size(); i++) {
			for (int j = 0; j < suit.size(); j++) {
				card = new Card(rank.get(i), suit.get(j));
				if (card.compareTo() >= cardC.compareTo()) {
					cardC = new Card(rank.get(i), suit.get(j));
					System.out.println(cardC.toString());
				}
			}
		}

	}
}
