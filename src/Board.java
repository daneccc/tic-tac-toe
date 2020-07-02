
public class Board {
	
	int[][] board = new int[3][3];
	
	public Board() {
		zeroBoard();
	}
	
	
	public void zeroBoard() {
		for (int i = 0; i < board.length; i++) 
			for (int j = 0; j < board.length; j++) 
				board[i][j] = 0;	
	}
	
	
	public void displayBoard() {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) { 
				
				if(board[i][j] == -1) {
					System.out.printf("| X |", board[i][j]);
				} else if (board[i][j] == 1) {
					System.out.printf("| O |", board[i][j]);
				} else {
					System.out.printf("|   |", board[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	
	public int checkWinner() {
		//-1 -1 -1 -> X won
		// 1  1  1 -> O won
		
		int somaVertical = 0;
		int somaHorizontal = 0;
		int somaDiagonalIndo = board[0][0] + board[1][1] + board[2][2];
		int somaDiagonalVoltando = board[0][2] + board[1][1] + board[2][0];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				somaHorizontal += board[i][j];
				somaVertical += board[j][i];
			}
			
			if (somaVertical == -3 || somaHorizontal == -3 || somaDiagonalIndo == -3 || somaDiagonalVoltando == -3) 
				return -1; //X won
			else if (somaVertical == 3 || somaHorizontal == 3 || somaDiagonalIndo == 3 || somaDiagonalVoltando == 3)
				return 1; //O won
			
			somaHorizontal = 0;
			somaVertical = 0;
		}
		return 0;
	}
	
	
	public boolean boardComplete() {
		for (int i = 0; i < board.length; ++i)
			for (int j = 0; j < board.length; j++)
				if (board[i][j] == 0)
					return false;
		return true;
	}
	
	
	public int getPosition(int[] attempt) {
		return board[attempt[0]][attempt[1]];
	}
	
	
	public void setPosition(int[] attempt, int player) {
		if(player == 1) 
			board[attempt[0]][attempt[1]] = -1;
		else 
			board[attempt[0]][attempt[1]] = 1;
		
		displayBoard();
	}
}
