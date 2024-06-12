package tetrisgame;

import java.util.Scanner;

public class TetrisGame {

	final char BLOCK='#';
	final char EMPTY='.';
	int score=0;
	
	final char[][][] SHAPES= {
			{{'#', '#', '#', '#'}}, // -	
			{{'#', '#'}, {'#', '#'}}, // O
			{{'#', '#', '#'}, {' ', '#', ' '}}, // T
			{{'#', '#', ' '}, {' ', '#', '#'}}, // Z
			{{' ', '#', '#'}, {'#', '#', ' '}}  // S
	};
 	
	public void startGame() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a box n and m : ");
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		char[][] box=new char[n][m];
		initBox(box);
		
		while(true) {
			displayBox(box);
			System.out.println("Enter shape number (0-4)");
			int shapeIndex=scanner.nextInt();
			
			System.out.println("Enter number of rotations (0-3)");
			int shapeRotate=scanner.nextInt();
			
			System.out.println("Enter box index");
			int startIndex=scanner.nextInt();
			
			char[][] shape=getRotatedShap(SHAPES[shapeIndex], shapeRotate);
			
			if(!dropShape(box, shape, startIndex)) {
				System.out.println("Game Over!");
				break;
			}
			
			clearFullRow(box);
			System.out.println("Score: "+score);
		}
		
		scanner.close();
	}
		
	public void initBox(char[][] box) {
		for(int row=0;row<box.length;row++) {
			for(int col=0;col<box[row].length;col++) {
				box[row][col]=EMPTY;
			}
		}
	}
	
	public void displayBox(char[][] box) {
		for(int row=0;row<box.length;row++) {
			for(int col=0;col<box[row].length;col++) {
				System.out.print(box[row][col]+" ");;
			}
			System.out.println();
		}
	}
	
	public char[][] getRotatedShap(char[][] shape, int shapeRotate){
		char[][] result=shape;
		for(int count=0;count<shapeRotate;count++) {
			result=rotate90Degree(result);
		}
		return result;
	}
	
	public char[][] rotate90Degree(char[][] shape) {
		int row=shape.length;
		int col=shape[0].length;
		char[][] rotated=new char[col][row];
		for(int r=0;r<row;r++) {
			for(int c=0;c<col;c++) {
				rotated[c][row-1-r]=shape[r][c];
			}
		}
		return rotated; 
	}
	
	public boolean dropShape(char[][] box, char[][] shape, int startCol) {
		int n=box.length;
		int m=box[0].length;
		int shapeHeight=shape.length;
		int shapeWidth=shape[0].length;
		
		if(startCol<0) startCol=0;
		if(startCol+shapeWidth>m)startCol=m-shapeWidth;
		
		for(int row=n-shapeHeight;row>=0;row--) {
			if(canPlace(box, shape, row, startCol)) {
				placeShape(box, shape, row, startCol);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean canPlace(char[][] box, char[][] shape, int startRow, int startCol) {
		int n=box.length;
		int m=box[0].length;
		int shapeHeight=shape.length;
		int shapeWidth=shape[0].length;
		
		for(int r=0;r<shapeHeight;r++) {
			for(int c=0;c<shapeWidth;c++) {
				if(shape[r][c]==BLOCK) {
					int newRow=startRow+r;
					int newCol=startCol+c;
					if(newRow>=n || newCol<0 || newCol>=m || box[newRow][newCol]==BLOCK) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void placeShape(char[][] box, char[][] shape, int startRow, int startCol) {
		int shapeHeight=shape.length;
		int shapeWidth=shape[0].length;
		
		for(int r=0;r<shapeHeight;r++) {
			for(int c=0;c<shapeWidth;c++) {
				if(shape[r][c]==BLOCK) {
					box[startRow+r][startCol+c]=BLOCK;
				}
			}
		}
	}
	
	public void clearFullRow(char[][] box) {
		int n=box.length;
		int m=box[0].length;
		int fullRow=0;
		for(int r=0;r<n;r++) {
			boolean isFull=true;
			for(int c=0;c<m;c++) {
				if(box[r][c]==EMPTY) {
					isFull=false;
					break;
				}
			}
			if(isFull) {
				removeRow(box, r);
				fullRow++;
			}
		}
		if(fullRow>0) {
			score+=10*Math.pow(2, fullRow-1);
		}
	}
	
	public void removeRow(char[][] box, int index) {
		int n=box.length;
		int m=box[0].length;
		for(int r=index;r>0;r--) {
			for(int c=0;c<m;c++) {
				box[r][c]=box[r-1][c];
			}
		}
		
		for(int c=0;c<m;c++) {
			box[0][c]=EMPTY;
		}
	}
	
	public static void main(String[] args) {
		TetrisGame tetrisGame=new TetrisGame();
		tetrisGame.startGame();
	}
}
