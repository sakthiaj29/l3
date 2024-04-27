package sudokusolver;

public class Display {

	public void display(int[][] board) {
		
		int length=board.length;
		for(int row=0;row<length;row++) {
			System.out.print("\t\t");
			if(row%3==0 && row!=0) {
				System.out.print("----------------------\n\t\t");
			}
			for(int column=0;column<length;column++) {
				if(column%3==0 && column!=0) {
					System.out.print("| ");
				}
				System.out.print(board[row][column]+" ");
			
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void message(String text) {
		System.out.println(text);
	}
	
}
