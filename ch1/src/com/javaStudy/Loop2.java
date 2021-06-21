package com.javaStudy;

public class Loop2 {

	public static void main(String[] args) {
		// TODO for 이용한 * 모양 예제
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("---------");
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
