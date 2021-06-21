package com.javaStudy;
import java.util.*;

public class Array1 {

	public static void main(String[] args) {
		// TODO 배열의 기본 예제
		int [] score = new int[5];
		
		score[0]=0;
		score[1]=30;
		score[2]=50;
		score[3]=60;
		score[4]=100;
		
		// int [] score = {0, 30, 50, 60, 100}; 
		
		for(int i=0;i<5;i++) {
			System.out.println(score[i]);
		}
		
		// for(int i=0;i<score.length;i++){
		//		System.out.println(score[i]);
		// }
		
		System.out.println("----------");
		
		int tmp = score[0] + score[4];
		System.out.println(tmp);
		System.out.println("----------");
		
		int [] score2 = new int [10];
		System.arraycopy(score,0,score2,0,score.length);
		//간단 복사
		System.out.println(Arrays.toString(score2));
		//간단 출력
	}

}
