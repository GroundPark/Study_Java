package com.javaStudy;

public class ArrayQ10 {

	public static void main(String[] args) {
		// TODO 2차원 배열을 Array를 사용하여  출력/향상된 for문 구현
		
		int [][] Arr = { 
							{100, 100, 100},
							{50, 150, 50},
							{3, 6, 9}
						};
		
		for(int i=0;i<Arr.length;i++)
			for(int j=0;j<Arr[i].length;j++)
				System.out.printf("Arr[%d][%d] = %d%n", i,j,Arr[i][j]);
		//2차원 배열 기본 출력
		
		int sum = 0;
		
		for(int [] tmp : Arr) {
			for(int i : tmp) {
				sum += i;
			}
		}
		// 출력만을 위한 향상된 for문
		System.out.println("sum : " +sum);
			
	}

}
