package poker;

class CardPile {

	protected Card firstCard;


	CardPile() {
		firstCard = null;
	}

	public void addCard(final Card aCard) {
		aCard.link = firstCard;
		firstCard = aCard;
	}

	public boolean empty() {
		return firstCard == null;
	}

	public Card pop() {
		Card result = null;
		if (firstCard != null) {
			result = firstCard;
			firstCard = firstCard.link;
		}
		return result;
	}

}