package poker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PokerTest {

	private PokerTable table;
	String combo;
	List<Card> cardlist = new ArrayList<Card>();
	
	@Before
	public void setup () {
		table = new PokerTable();
	}
	
	@Test
	public void pairTest() {
		cardlist.add(new Card(1, 1));
		cardlist.add(new Card(2, 2));
		cardlist.add(new Card(1, 2));
		cardlist.add(new Card(1, 3));
		cardlist.add(new Card(1, 4));		
		combo = table.combination(cardlist);
		assertEquals("pair", combo);
	}
	
	@Test
	public void twoPairTest() {
		cardlist.add(new Card(1, 3));
		cardlist.add(new Card(2, 2));
		cardlist.add(new Card(1, 2));
		cardlist.add(new Card(1, 5));
		cardlist.add(new Card(2, 3));		
		combo = table.combination(cardlist);
		assertEquals("two pairs", combo);
	}

	@Test
	public void flushTest() {
		cardlist.add(new Card(1, 1));
		cardlist.add(new Card(1, 2));
		cardlist.add(new Card(1, 6));
		cardlist.add(new Card(1, 3));
		cardlist.add(new Card(1, 4));		
		combo = table.combination(cardlist);
		assertEquals("flush", combo);
	}
	
	@Test
	public void straightTest() {
		cardlist.add(new Card(1, 10));
		cardlist.add(new Card(2, 8));
		cardlist.add(new Card(1, 11));
		cardlist.add(new Card(1, 9));
		cardlist.add(new Card(1, 12));		
		combo = table.combination(cardlist);
		assertEquals("straight", combo);
	}
	
	@Test
	public void royalFlushTest() {
		cardlist.add(new Card(1, 10));
		cardlist.add(new Card(1, 0));
		cardlist.add(new Card(1, 11));
		cardlist.add(new Card(1, 9));
		cardlist.add(new Card(1, 12));		
		combo = table.combination(cardlist);
		assertEquals("royal flush", combo);
	}
	
	@Test
	public void straightFlushTest() {
		cardlist.add(new Card(2, 10));
		cardlist.add(new Card(2, 8));
		cardlist.add(new Card(2, 11));
		cardlist.add(new Card(2, 9));
		cardlist.add(new Card(2, 7));		
		combo = table.combination(cardlist);
		assertEquals("straight flush", combo);
	}
	
	@Test
	public void threeTest() {
		cardlist.add(new Card(2, 10));
		cardlist.add(new Card(1, 8));
		cardlist.add(new Card(2, 11));
		cardlist.add(new Card(2, 8));
		cardlist.add(new Card(3, 8));		
		combo = table.combination(cardlist);
		assertEquals("three of a kind", combo);		
	}
	
	@Test
	public void fourTest() {
		cardlist.add(new Card(2, 10));
		cardlist.add(new Card(1, 8));
		cardlist.add(new Card(4, 8));
		cardlist.add(new Card(2, 8));
		cardlist.add(new Card(3, 8));		
		combo = table.combination(cardlist);
		assertEquals("four of a kind", combo);		
	}
	
	@Test
	public void fullHouseTest() {
		cardlist.add(new Card(2, 10));
		cardlist.add(new Card(1, 8));
		cardlist.add(new Card(4, 8));
		cardlist.add(new Card(2, 8));
		cardlist.add(new Card(3, 10));		
		combo = table.combination(cardlist);
		assertEquals("full house", combo);
	}
}
