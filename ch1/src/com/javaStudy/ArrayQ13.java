package com.javaStudy;

public class ArrayQ13 {

	public static void main(String[] args) {
		// TODO 행렬의 곱셈을 배열로 구현
			int[][] m1 = {
				{1, 2, 3},
				{4, 5, 6}
			};

			int[][] m2 = {
				{1, 2},
				{3, 4},
				{5, 6}
			};

			final int ROW    = m1.length;      // m1의 행 길이 : 2
			
			final int COL    = m2[0].length;  // m2의 열 길이 : 2
			final int M2_ROW = m2.length;	  // m2의 행 길이 : 3

			int[][] m3 = new int[ROW][COL];

			for(int i=0;i<ROW;i++)
				for(int j=0;j<COL;j++)
					for(int k=0;k<M2_ROW;k++)
						m3[i][j] += m1[i][k] * m2[k][j]; 
			// m1 * m2 행렬 곱을 m3에 저장
			// 예 : (2,2) += (2,3) * (3,2)

			for(int i=0;i<ROW;i++) {
				for(int j=0;j<COL;j++) {
					System.out.printf("%3d ", m3[i][j]);
				}
				// 행렬 m3을 출력
				System.out.println();
			}
		} 
	}