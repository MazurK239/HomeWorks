package solitaire;

public class TDPile extends CardPile {

	TDPile(final int xl, final int yl) {
		super(xl, yl);
	}

	public void select(final int tx, final int ty) {

		//search for selected cards
		Card selectedCard = null;
		int taken = -1;
		if (!Solitaire.discardPile.empty() && Solitaire.discardPile.top().selected) {
			selectedCard = Solitaire.discardPile.pop();
			taken = 7;
		} else {
			for (int i = 0; i < 7; i++) {
				if (!Solitaire.tableau[i].empty() && Solitaire.tableau[i].top().selected) {
					selectedCard = Solitaire.tableau[i].pop();
					taken = i;
					break;
				}
			}
		}

		if (selectedCard == null) {
			//checking if we can put our card to SuitPile
			for(int i = 0; i < 4; i++) {
				if (Solitaire.suitPile[i].canTake(firstCard)) {
					Solitaire.suitPile[i].addCard(pop());
					return;
				}
			}
				
			//checking for empty piles to put the King
			for (int j = 0; j < 7; j++) {
				if (Solitaire.tableau[j].empty() && firstCard.isKing()) {
					Solitaire.tableau[j].addCard(pop());
					return;
				}
			}
			firstCard.selected = true;
		} else {
			selectedCard.selected = false;
			if (canTake(selectedCard)) {
				addCard(selectedCard);
				return;
			}

			// else put it back on our pile
			switch (taken) {
			case 7:
				Solitaire.discardPile.addCard(selectedCard);
				break;
			default:
				Solitaire.tableau[taken].addCard(selectedCard);
				break;
			}
		}
	}

}
