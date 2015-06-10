package Hausaufgaben;

public class Board {

	private String[][] board;
	
	public Board() {
		board = new String[3][3];
	}
	
	public void setMark(String mark, int x, int y) throws InvalidPositionException {
		
		if(!(mark == "X" || mark == "O"  || board[x][y] == ""))
			throw new InvalidPositionException();
			
		if(x > 2 || y > 2 || x < 0 || y < 0)
			throw new InvalidPositionException();
		
		board[x][y] = mark;
		
	}
	
	public boolean hasWinner(){
		
		for(int x = 0; x < 3; x++)
			if((board[x][0] == "X" | board[x][0] == "Y") && board[x][0] == board[x][1] && board[x][1] == board[x][2])
					return true;
		
		for(int y = 0; y < 3; y++)
			if((board[0][y] == "X" | board[0][y] == "Y") && board[0][y] == board[1][y] && board[1][y] == board[2][y])
					return true;
		
		if((board[0][0] == "X" | board[0][0] == "Y") && board[0][0] == board[1][1] && board[1][1] == board[2][2])
					return true;
		
		if((board[2][0] == "X" | board[2][0] == "Y") && board[2][0] == board[1][1] && board[1][1] == board[0][2])
			return true;
		
		return false;
	}
	
	public class InvalidPositionException extends Exception{
		
	}
}

