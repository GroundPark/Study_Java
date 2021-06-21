package com.javaStudy;
import java.util.Scanner;
import java.io.File;
public class Scanner7 {

	public static void main(String[] args) throws Exception {
		// TODO 데이터 파일을 읽어 연산하는 예제
		Scanner s = new Scanner(new File("D:/Study_Java/ch1/src/com/javaStudy/TestData.txt"));
		// File에서 Exception. 파일엔 100~500의 예제 데이터
		
		int sum = 0;
		int cnt = 0;
		
		while(s.hasNextInt()) {
			sum += s.nextInt();
			cnt++;
		}
		
		System.out.println("합계 : " +sum);
		System.out.println("평균 : " +sum/cnt);
		
	}

}
