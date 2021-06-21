package com.javaStudy;

public class Loop1 {

	public static void main(String[] args) {
		// TODO for문 이용한 1부터 10까지 합
		int sum = 0;
		
		for(int i=1;i<=10;i++) {
			sum += i;
			System.out.printf("1부터 %d까지 합 = %d%n",i,sum);
		}
		System.out.println();
		
		for(int i=1;i<10;i++) {
			System.out.printf("i=%d, 순환되어 반복(i%%3)=%d, 같은 값이 반복 i/3=%d%n",i,i%3,i/3);
		}
	}
}
