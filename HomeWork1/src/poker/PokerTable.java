package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokerTable {

	DeckPile pile = new DeckPile();
	List<Card> hand = new ArrayList<Card>();
	int[] ranks = new int[5];

	private boolean isStraight(List<Card> cardlist) {
		for (int i = 0; i < cardlist.size(); i++) {
			ranks[i] = cardlist.get(i).getRank();
		}
		Arrays.sort(ranks);
		//check if we have 10 -> Ace
		if (Arrays.equals(ranks, new int[] {0,9,10,11,12})) {
			return true;
		}		
		for (int i = 1; i < ranks.length; i++) {
			if (ranks[i] != ranks[i-1] + 1) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isPair(List<Card> cardlist) {
		for (int i = 0; i < cardlist.size() - 1; i++) {
			for (int j = i+1; j < cardlist.size(); j++) {
				if (cardlist.get(i).getRank() == cardlist.get(j).getRank()) {
					return true;
				}
			}
		}		
		return false;
	}

	private boolean isTwoPair(List<Card> cardlist) {
		if (((ranks[0] == ranks[1]) && (ranks[2] == ranks[3])) || ((ranks[0] == ranks[1]) && (ranks[3] == ranks[4])) || ((ranks[1] == ranks[2]) && (ranks[3] == ranks[4]))) {
			return true;
		}
		return false;
	}
	
	private boolean isThree(List<Card> cardlist) {
		if (((ranks[0] == ranks[1]) && (ranks[1] == ranks[2])) || ((ranks[1] == ranks[2]) && (ranks[2] == ranks[3])) || ((ranks[2] == ranks[3]) && (ranks[3] == ranks[4]))) {
			return true;
		}
		return false;
	}

	private boolean isFour(List<Card> cardlist) {
		if (((ranks[0] == ranks[1]) && (ranks[1] == ranks[2]) && (ranks[2] == ranks[3])) || ((ranks[0] == ranks[1]) && (ranks[1] == ranks[2]) && (ranks[2] == ranks[3]))) {
			return true;
		}
		return false;
	}

	private boolean isFullHouse(List<Card> cardlist) {
		if (((ranks[0] == ranks[1]) && (ranks[3] == ranks[4]) && (ranks[2] == ranks[3])) || ((ranks[0] == ranks[1]) && (ranks[1] == ranks[2]) && (ranks[3] == ranks[4]))) {
			return true;
		}
		return false;
	}
	
	private boolean isFlush(List<Card> cardlist) {
		for (int i = 1; i < cardlist.size(); i++) {
			if (cardlist.get(i).getSuit() != cardlist.get(0).getSuit()) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isStraightFlush(List<Card> cardlist) {
		if (isStraight(cardlist) && isFlush(cardlist)) {
			return true;
		}
		return false;
	}
	
	private boolean isRoyalFlush(List<Card> cardlist) {
		if (isStraightFlush(cardlist) && (ranks[0] == 0) && (ranks[1] == 9)) {
			return true;
		}
		return false;
	}

	String combination(List<Card> cardlist) {
		if (isRoyalFlush(cardlist)) {
			return "royal flush";
		} else if (isStraightFlush(cardlist)) {
			return "straight flush";
		} else if (isFour(cardlist)) {
			return "four of a kind";
		} else if (isFullHouse(cardlist)) {
			return "full house";
		} else if (isFlush(cardlist)) {
			return "flush";
		} else if (isStraight(cardlist)) {
			return "straight";
		} else if (isThree(cardlist)) {
			return "three of a kind";
		} else if (isTwoPair(cardlist)) {
			return "two pairs";
		} else if (isPair(cardlist)) {
			return "pair";
		}
		return "You've got High Card.";
	}
	

	public static void main(String[] args) {
		
		PokerTable table = new PokerTable();
		
		for (int i = 0; i < 5; i++) {			
			table.hand.add(table.pile.pop());
		}
		
		System.out.println(table.combination(table.hand));
		
	}
}
