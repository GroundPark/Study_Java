package com.javaStudy;
import java.util.*;

public class ArrayQ12 {

	public static void main(String[] args) {
		// TODO 5x5 빙고판에 1~25 숫자 차례로 저장하고.. 랜덤이용해 위치를 섞음. 그리고 숫자 입력받아서 일치하는 숫자 있으면 그숫자를 0으로 바꿈
				final int SIZE = 5;
				int x = 0 , y = 0;
				int num = 0;

				int[][] bingo = new int[SIZE][SIZE];
				Scanner scanner = new Scanner(System.in);

				for(int i=0;i<SIZE;i++) {
					for(int j=0;j<SIZE;j++) {
						bingo[i][j] = i*SIZE + j + 1;
					}
				}
				// i*5+j+1 수식으로  5x5의 (0,0)~(4,4)위치 에 1~25 숫자를 넣는다
				
				for(int i=0;i<SIZE;i++) {
					for(int j=0;j<SIZE;j++) {
						x = (int)(Math.random() * SIZE);
						y = (int)(Math.random() * SIZE);

						int tmp =  bingo[i][j];
						bingo[i][j] = bingo[x][y];
						bingo[x][y] = tmp;
						// i,j로 차례로 저장된 배열과 랜덤 x,y로 랜덤한 배열을 섞어서 랜덤하게 만듬
					}
				}

				do {
					for(int i=0;i<SIZE;i++) {
						for(int j=0;j<SIZE;j++)
							System.out.printf("%2d ", bingo[i][j]);	
						System.out.println();
					}
					// 배열 출력
					System.out.println();
				
					System.out.printf("1~%d의 숫자를 입력. (종료는 0 입력)", SIZE*SIZE);
					String tmp = scanner.nextLine(); 
					num = Integer.parseInt(tmp);    

					outer:
					for(int i=0;i<SIZE;i++) {
						for(int j=0;j<SIZE;j++) {
							if(bingo[i][j]==num) {
								bingo[i][j] = 0;
								break outer; 
							// 입력받은 num과 배열의 숫자가 같다면.. 그 배열의 위치에 0을 넣음
							// 2중 반복문을써서 outer만 빠져나감
							}
						}
					}
					
				} while(num!=0); //종료문
			} 
		}