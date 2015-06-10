import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Hausaufgaben.Board;
import Hausaufgaben.Board.InvalidPositionException;


public class BoardTest {

	private Board board;
	
	@Before
	public void initialize() {
		board = new Board();
	}
	
	@Test
	public void emptyBoard() {
		assertEquals(false, board.hasWinner());
	}

	@Test
	public void setMarkNoWinner() throws InvalidPositionException {
		board.setMark("X", 1, 1);
		assertEquals(false, board.hasWinner());
	}
	
	@Test
	public void setMarkWinner() throws InvalidPositionException {
		board.setMark("X", 1, 0);
		board.setMark("X", 1, 1);
		board.setMark("X", 1, 2);
		assertEquals(true, board.hasWinner());
	}
	
	@Test (expected = InvalidPositionException.class)
	public void wrongMark() throws InvalidPositionException {
		board.setMark("X", 1, 3);
	}
}
