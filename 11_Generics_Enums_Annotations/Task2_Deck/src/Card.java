
public class Card implements Comparable {
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

	@Override
	public int compareTo() {
		int powerOfCard = 0;
		switch (this.getRank()) {
		case Two:
			powerOfCard = 2;
			break;
		case Four:
			powerOfCard = 4;
			break;
		case Five:
			powerOfCard = 5;
			break;
		case Six:
			powerOfCard = 6;
			break;
		case Seven:
			powerOfCard = 7;
			break;
		case Eight:
			powerOfCard = 8;
			break;
		case Nine:
			powerOfCard = 9;
			break;
		case Ten:
			powerOfCard = 10;
			break;
		case Jack:
			powerOfCard = 11;
			break;
		case Queen:
			powerOfCard = 12;
			break;
		case King:
			powerOfCard = 13;
			break;
		case Ace:
			powerOfCard = 14;
			break;
		default:
			break;
		}
		return powerOfCard;
	}
}
