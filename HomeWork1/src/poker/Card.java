package poker;

class Card {

	final static int club = 3;
	final static int diamond = 2;
	final static int heart = 0;
	final static int spade = 1;

	// data fields for colors and suits
	// private static String names[] = {"A", "2", "3", "4", "5", "6",
	// "7", "8", "9", "10", "J", "Q", "K"};

	// data fields
	private int rank;
	private int suit;

	public Card link;

	// constructor
	Card(final int suitValue, final int rankValue) {
		suit = suitValue;
		rank = rankValue;
	}

	// access attributes of card
	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

	final boolean isAce() {
		return getRank() == 0;
	}

	final boolean isKing() {
		return getRank() == 12;
	}
}