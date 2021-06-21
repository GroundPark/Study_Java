package com.javaStudy;
import java.util.*;

public class ArrayQ11 {

	public static void main(String[] args) {
		// TODO 9x9의 배열에 0=X ,1=O로 위치를 잡아놓고 .. 위치값을 입력하여 그 위치에 뭐가 있는지 계속하여 알아내는 게임  
		final int SIZE = 10;
		int x = 0, y = 0;

		// shipboard는 만들어놓은 판, board는 내가 O,X 넣을 판
		char[][] board = new char[SIZE][SIZE];
		byte[][] shipBoard = {
		  //  1  2  3  4  5  6  7  8  9
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 1
			{ 1, 1, 1, 1, 0, 0, 1, 0, 0 }, // 2
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 3
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 4
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 5
			{ 1, 1, 0, 1, 0, 0, 0, 0, 0 }, // 6
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 7
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 8
			{ 0, 0, 0, 0, 0, 1, 1, 1, 0 }, // 9
		};

	    
		for(int i=1;i<SIZE;i++) {
			board[0][i] = (char)(i+'0');
			board[i][0] = (char)(i+'0');
			}
		// 1행에 행번호, 1열에 열번호 저장
		
		
		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.printf("좌표 입력 > 00 입력시 종료");
			String input = scanner.nextLine(); 

			if(input.length()==2) {   
				x = input.charAt(0) - '0';  
				y = input.charAt(1) - '0';
				// char끼리 연산을 시켜서 int화
				
				if(x==0 && y==0) 
					break;
				// 00 입력시 종료
			} 
			
			if(input.length()!=2 || x <= 0 || x >= SIZE || y <= 0 || y >= SIZE){
				System.out.println("다시 입력하시오");
				continue;
			}

			board[x][y] = shipBoard[x-1][y-1]==1 ? 'O' : 'X';  
			// 만들어 놓은 9x9 배열의 1,0을 판별하고 그자리에 O, X를 넣는다
			// 두 배열간의 차이를 생각해야하므로 -1을 함
			
			for(int i=0;i<SIZE;i++) 
				System.out.println(board[i]); 
			// board를 출력
			System.out.println();
		}
	} 
}