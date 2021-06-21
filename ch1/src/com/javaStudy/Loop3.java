package com.javaStudy;

public class Loop3 {

	public static void main(String[] args) {
		// TODO for 이용한 구구단
		for(int i=2;i<=4;i++) {
			for(int j=1;j<=9;j++) {
				System.out.printf("%d * %d = %d%n",i,j,i*j);
			}
			System.out.println();
		}

	}

}
