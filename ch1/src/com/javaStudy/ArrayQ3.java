package com.javaStudy;

public class ArrayQ3 {

	public static void main(String[] args) {
		// TODO 배열을 이용해 10개의 숫자인 요소를 생성하고 N(100)번 섞는 예제
		int [] Arr = new int [10];
		
		for(int i=0;i<10;i++) {
			Arr[i] = i;
		}
		
		for(int i=0;i<100;i++) {
			int n = (int)(Math.random() * 10);
			int tmp = Arr[0];
			Arr[0] = Arr[n];
			Arr[n] = tmp;
			// a, b, tmp 값 바꾸기
			// tmp = a
			// a = b
			// b = tmp
		}
		
		for(int i=0;i<Arr.length;i++) {
			System.out.print(Arr[i]);
		}
	}

}
