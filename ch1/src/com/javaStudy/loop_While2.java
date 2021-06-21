package com.javaStudy;

public class loop_While2 {

	public static void main(String[] args) {
		// TODO while에 break, countinue 사용한 예제
		// TODO 1~i까지 더할때 누적 합계가 100을 넘지 않는 제일 큰 i값은? 
		int sum1 = 0, i1 = 0;
		
		while((sum1 += ++i1) <= 100) {
			System.out.printf("i = %2d, 누적값=%2d%n", i1,sum1);
		}
		System.out.println("1부터 13까지 누적합계가 100을 넘지않음");
		System.out.println("---------------");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
