package com.javaStudy;

public class ArrayQ4 {

	public static void main(String[] args) {
		// TODO Array에서 랜덤 로또 번호 예제
		
		int [] balls = new int [45];
		
		for(int i=0;i<balls.length;i++)
			balls[i] = i + 1;
		// 배열 45개를 만들고 1~45 정수 넣음
		
		int temp = 0;
		int j = 0;
		
		for(int i=0;i<6;i++) {
			j = (int)(Math.random() * 45);
			temp = balls[i];
			balls[i] = balls[j];
			balls[j] = temp;
		}
		// 6개의 공이므로 6번동안 반복하는데.. 0~44의 임의 값을 j에 넣고.. balls[i] 와 balls[j]를 temp를 이용해 섞는다
		
		for(int i=0;i<6;i++)
			System.out.printf("balls[%d] = %d%n", i, balls[i]);
	}

}
