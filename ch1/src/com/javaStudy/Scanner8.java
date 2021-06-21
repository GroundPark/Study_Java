package com.javaStudy;
import java.util.Scanner;
import java.io.File;
public class Scanner8 {

	public static void main(String[] args) throws Exception {
		// TODO 데이터 파일을 읽고... 읽은것 처리한뒤 line으로 읽고... 연산하는 예제
		Scanner sc = new Scanner(new File("D:/Study_Java/ch1/src/com/javaStudy/TestData2.txt"));
		// File에서 Exception. 파일엔 100,100,100 ~ 500,500,500의 예제 데이터
		
		int cnt = 0;
		int totalSum = 0;
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			//100,100,100... 돌면서 500까지
			 Scanner sc2 = new Scanner(line).useDelimiter(",");
             int sum = 0;
         
             while(sc2.hasNextInt()) {
            	 //100100100... hasNextInt 3번 확인
                 sum += sc2.nextInt();
                 //while문 3번 돌면서 100을 3번 +=
             	}
             System.out.println(line +"   sum = " +sum);
             totalSum += sum;
             cnt++;
		}
		System.out.println("라인수 : " +cnt +"  총합 : " +totalSum);	
	}

}
