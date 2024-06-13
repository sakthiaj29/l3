package game2048;

import java.util.Random;
import java.util.Scanner;

public class Game2048 {
	final int SIZE=4;
	final int WIN_NUMBER=2048;
	int[][] board=new int[SIZE][SIZE];
	Random random=new Random();
	Scanner scanner=new Scanner(System.in);

	public static void main(String[] args) {
		Game2048 game=new Game2048();
		game.startGame();
	}
	
	public void startGame() {
		addRandomTite();
		addRandomTite();
		
		while(true) {
			printBoard();
			
			if(gameWin()) {
				System.out.println("Congrats You Win :)");
				break;
			}
			if(gameOver()) {
				System.err.println("Game Over :(");
				break;
			}
			
			char move=getUserMove();
			if(moveTiles(move)) {
				addRandomTite();
			}
			
		}
		
	}
	
	private char getUserMove() {
		System.out.print("Enter move (WASD) : ");
		char move=scanner.next().charAt(0);
		return Character.toUpperCase(move);
	}

	private void addRandomTite() {
		int value=random.nextInt(10)<9?2:4;
		int x,y;
		do {
			 x=random.nextInt(SIZE);
			 y=random.nextInt(SIZE);
		}while(board[x][y]!=0);
		board[x][y]=value;
	}
	
	private void printBoard() {
		for(int row=0;row<SIZE;row++) {
			for(int col=0;col<SIZE;col++) {
				System.out.printf("%4s",(board[row][col]==0?".":board[row][col]));
			}
			System.out.println();
		}
	}
	
	private boolean gameWin() {
		boolean isWin=false;
		for(int row=0;row<SIZE;row++) {
			for(int col=0;col<SIZE;col++) {
				if(board[row][col]==WIN_NUMBER) {
					isWin=true;
					break;
				}
			}
		}
		return isWin;
	}
	
	private boolean gameOver() {
		for(int i=0;i<SIZE;i++) {
			for(int j=0;j<SIZE;j++) {
				if(board[i][j]==0) {
					return false;
				}
				if(i<SIZE-1 && board[i][j]==board[i+1][j]) {
					return false;
				}
				if(j<SIZE-1 && board[i][j]==board[i][j+1]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean moveTiles(char move) {
		boolean moved=false;
		switch (move) {
		case 'W': moved=moveUp(); break;
		
		case 'S': moved=moveDown(); break;
		
		case 'A': moved=moveLeft(); break;
		
		case 'D': moved=moveRight(); break;
			
		default:
			System.out.println("Invalid move !");
		}
		return moved;
	}
	
	private boolean moveUp() {
		boolean isMoved=false;
		for(int j=0;j<SIZE;j++) {
			int[] temp=new int[SIZE];
			int k=0;
			
			for(int i=0;i<SIZE;i++) {
				if(board[i][j]!=0) {
					temp[k++]=board[i][j];
				}
			}
			for(int i=0;i<k-1;i++) {
				if(temp[i]==temp[i+1]) {
					temp[i]*=2;
					temp[i+1]=0;
				}
			}
			int[] newColm=new int[SIZE];
			k=0;
			for(int i=0;i<SIZE;i++) {
				if(temp[i]!=0) {
					newColm[k++]=temp[i];
				}
			}
			for(int i=0;i<SIZE;i++) {
				if(board[i][j]!=newColm[i]) {
					board[i][j]=newColm[i];
					isMoved=true;
				}
			}
			
		}
		return isMoved;
	}
	
	private boolean moveDown() {
		boolean isMoved=false;
		for(int j=0;j<SIZE;j++) {
			int[] temp=new int[SIZE];
			int k=0;
			for(int i=SIZE-1;i>=0;i--) {
				if(board[i][j]!=0) {
					temp[k++]=board[i][j];
				}
			}
			for(int i=0;i<k-1;i++) {
				if(temp[i]==temp[i+1]) {
					temp[i]*=2;
					temp[i+1]=0;
				}
			}
			int[] newColm=new int[SIZE];
			k=0;
			for(int i=0;i<SIZE;i++) {
				if(temp[i]!=0) {
					newColm[k++]=temp[i];
				}
			}
			for(int i=SIZE-1, m=0;i>=0;i--,m++) {
				if(board[i][j]!=newColm[m]) {
					board[i][j]=newColm[m];
					isMoved=true;
				}
			}
		}
		return isMoved;
	}
	
	private boolean moveLeft() {
		boolean isMove=false;
		for(int i=0;i<SIZE;i++) {
			int[] temp=new int[SIZE];
			int k=0;
			for(int j=0;j<SIZE;j++) {
				if(board[i][j]!=0) {
					temp[k++]=board[i][j];
				}
			}
			for(int j=0;j<k-1;j++) {
				if(temp[j]==temp[j+1]) {
					temp[j]*=2;
					temp[j+1]=0;
				}
			}
			int[] newRow=new int[SIZE];
			k=0;
			for(int j=0;j<SIZE;j++) {
				if(temp[j]!=0) {
					newRow[k++]=temp[j];
				}
			}
			for(int j=0;j<SIZE;j++) {
				if(board[i][j]!=newRow[j]) {
					board[i][j]=newRow[j];
					isMove=true;
				}
			}
		}
		return isMove;
	}
	
	private boolean moveRight() {
		boolean isMove=false;
		for(int i=0;i<SIZE;i++) {
			int[] temp=new int[SIZE];
			int k=0;
			for(int j=SIZE-1;j>=0;j--) {
				if(board[i][j]!=0) {
					temp[k++]=board[i][j];
				}
			}
			for(int j=0;j<k-1;j++) {
				if(temp[j]==temp[j+1]) {
					temp[j]*=2;
					temp[j+1]=0;
				}
			}
			int[] newRow=new int[SIZE];
			k=0;
			for(int j=0;j<SIZE;j++) {
				if(temp[j]!=0) {
					newRow[k++]=temp[j];
				}
			}
			for(int j=SIZE-1, m=0;j>=0;j--, m++) {
				if(board[i][j]!=newRow[m]) {
					board[i][j]=newRow[m];
					isMove=true;
				}
			}
		}
		return isMove;
	}

}
