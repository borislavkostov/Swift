@ClassInfo(type="class",category="CardGames",description = "Represents a card object used to play games with.")
public class Card {
	private CardRank rank;
	private CardSuit suit;

	public Card(CardRank rank, CardSuit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public String toString() {
		return new String(this.getRank() + " " + this.getSuit());
	}

	public CardRank getRank() {
		return rank;
	}

	public void setRank(CardRank rank) {
		this.rank = rank;
	}

	public CardSuit getSuit() {
		return suit;
	}

	public void setSuit(CardSuit suit) {
		this.suit = suit;
	}

}
