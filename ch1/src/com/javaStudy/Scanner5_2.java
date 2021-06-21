package com.javaStudy;
import java.util.*;

public class Scanner5_2 {

	public static void main(String[] args) {
		// TODO Scanner와 switch 기본 예제
		
		int score = 0;
		char grade = ' ';
		
		System.out.println("1~100의 점수를 입력");
		
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();
		
		switch(score/10) {
			case 10: case 9:
				grade = 'A';
				break;
			case 8: case 7:
				grade = 'B';
				break;
			default:
				grade = 'F';
		}
		// score/10 하면 int형이므로 나머지가 버림되고 10~0까지의 정수가 남음
		System.out.println("당신의 학점 : " +grade);
	}

}
