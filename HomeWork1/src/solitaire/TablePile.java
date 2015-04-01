package solitaire;

import java.awt.Color;
import java.awt.Graphics;

class TablePile extends TDPile {

	TablePile(final int x, final int y, final int c) {
		// initialize the parent class
		super(x, y);
		// then initialize our pile of cards
		for (int i = 0; i < c; i++) {
			addCard(Solitaire.deckPile.pop());
		}
		// flip topmost card face up
		top().flip();
	}

	public boolean canTake(final Card aCard) {
		if (empty()) {
			return aCard.isKing();
		}
		Card topCard = top();
		return (aCard.color() != topCard.color())
				&& (aCard.getRank() == topCard.getRank() - 1);
	}

	public void display(final Graphics g) {
		g.setColor(Color.black);
		if (firstCard == null) {
			g.drawRect(x, y, Card.width, Card.height);
		} else {
			stackDisplay(g, top());
		}
	}

	public boolean includes(final int tx, final int ty) {
		Card temp = top();
		int count = 0;
		while (temp != null) {
			++count;
			temp = temp.link;
		}
		return x <= tx && tx <= x + Card.width && y + (count - 1) * 35 <= ty && ty <= y + (count + 1) * 35;
	}

	public void select(final int tx, final int ty) {
		if (empty()) {
			return;
		}

		// if face down, then flip
		Card topCard = top();
		if (!topCard.isFaceUp()) {
			topCard.flip();
			return;
		}
		
		super.select(tx, ty);
	}

	private int stackDisplay(final Graphics g, final Card aCard) {
		int localy;
		if (aCard == null) {
			return y;
		}
		localy = stackDisplay(g, aCard.link);
		aCard.draw(g, x, localy);
		return localy + 35;
	}

}