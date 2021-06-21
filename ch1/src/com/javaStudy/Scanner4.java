package com.javaStudy;
import java.util.*;

public class Scanner4 {

	public static void main(String[] args) {
		// TODO Scanner 숫자 입력 및 조건 판별
		int score = 0;
		char grade = ' ';
		
		System.out.println("점수 입력");
		
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();
		
		if(score>=90) {
			grade = 'A';
		}
		else if(score>=80) {
			grade = 'B';
		}
		else {
			grade = 'C';
		}
		// 첫번째 if에서 90이상을 확인했으므로 두번째 if에서 90이상을 확인하는 중복구문은 넣지않아도 됨
		System.out.println("당신은 " +grade +" 학점을 받았습니다");
	}

}
