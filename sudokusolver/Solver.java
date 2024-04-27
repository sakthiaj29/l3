package sudokusolver;

public class Solver {

	private int GRID_SIZE;
	
	public void solver(int[][] board) {
		
		GRID_SIZE=board.length;
		
		Display displayObj=new Display();
		
		displayObj.message("Your Board is: ");
		displayObj.display(board);
		
		if(solveBoard(board)) {
			displayObj.message("Solve Sucessfully :)");
		}
		else {
			displayObj.message("Unsolvable board :(");
		}
		displayObj.display(board);
		
	}
	private boolean solveBoard(int[][] board) {
		for(int row=0;row<GRID_SIZE;row++) {
			for(int column=0;column<GRID_SIZE;column++) {
				if(board[row][column]==0) {
					for(int numberFill=1;numberFill<=GRID_SIZE;numberFill++) {
						if(isNumberValid(board, numberFill, row, column)) {
							board[row][column]=numberFill;
							if(solveBoard(board)) {
								return true;
							}
							else {
								board[row][column]=0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	private boolean isNumberValid(int[][] board, int number, int row, int column) {
		return !isNumberInRow(board, number, row) && 
				!isNumberInColumn(board, number, column) && 
				!isNumberInBox(board, number, row, column);
	}
	
	private boolean isNumberInRow(int[][] board, int number, int row) {
		for(int i=0;i<GRID_SIZE;i++) {
			if(board[row][i]==number) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isNumberInColumn(int[][] board, int number, int column) {
		for(int i=0;i<GRID_SIZE;i++) {
			if(board[i][column]==number) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isNumberInBox(int[][] board, int number, int row, int column) {
		int num=(int)Math.sqrt(board.length);
		int boxRow=row-row%num;
		int boxColumn=column-column%num;
		for(int r=boxRow;r<boxRow+3;r++) {
			for(int c=boxColumn;c<boxColumn+3;c++) {
				if(board[r][c]==number) {
					return true;
				}
			}
		}
		return false;
	}
}
