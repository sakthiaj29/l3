package snakegame;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {

	final char SANKE='S';
	final char FOOD='F';
	final char EMPTY='.';
	int score=0;
	
	final int[] DX= {0,1,0,-1};
	final int[] DY= {1,0,-1,0};
	final String DIRACTION="RDLU"; 
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){ this.x=x; this.y=y;}
	}
	
	public void gameStart() {
		Scanner scanner=new Scanner(System.in);
		Random random=new Random();
		System.out.println("Enter game box size n, m");
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		char[][] box=new char[n][m];
		initBox(box);
		
		LinkedList<Point> snake=new LinkedList<>();
		snake.add(new Point(n/2, m/2));
		box[n/2][m/2]=SANKE;
		
		placedFood(box, random);
		
		boolean gameOver=false;
		while(!gameOver) {
			displayBox(box);
			
			System.out.println("Enter diraction R D L U");
			char diraction=scanner.next().charAt(0);
			int dirIndex=DIRACTION.indexOf(diraction);
			if(dirIndex==-1) {
				System.out.println("Invalid Diraction,");
				continue;
			}
			Point head=snake.getFirst();
			Point newHead=new Point(head.x+DX[dirIndex], head.y+DY[dirIndex]);
			if(newHead.x<0 || newHead.x>=n || newHead.y<0 || newHead.y>=m || box[newHead.x][newHead.y]==SANKE) {
				System.out.println("Game Over !");
				gameOver=true;
			}
			else {
				if(box[newHead.x][newHead.y]==FOOD) {
					score+=10;
					placedFood(box, random);
				}
				else {
					Point tail=snake.removeLast();
					box[tail.x][tail.y]=EMPTY;
				}
				snake.addFirst(newHead);
				box[newHead.x][newHead.y]=SANKE;
			}
			System.out.println("Score="+score);	
		}
		scanner.close();
		
	}
	
	private void placedFood(char[][] box, Random random) {
		int foodX, foodY;
		do {
			foodX=random.nextInt(box.length);
			foodY=random.nextInt(box[0].length);
		}while(box[foodX][foodY]!=EMPTY);
		box[foodX][foodY]=FOOD;
	}

	private void displayBox(char[][] box) {
		for(int i=0;i<box.length;i++) {
			for(int j=0;j<box[i].length;j++) {
				System.out.print(box[i][j]+" ");
			}
			System.out.println();
		}
	}

	private void initBox(char[][] box) {
		for(int i=0;i<box.length;i++) {
			for(int j=0;j<box[i].length;j++) {
				box[i][j]=EMPTY;
			}
		}
		
	}
	
	public static void main(String[] args) {
		SnakeGame snakeGame=new SnakeGame();
		snakeGame.gameStart();
	}
}
