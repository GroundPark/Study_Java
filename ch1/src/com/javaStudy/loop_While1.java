package com.javaStudy;

public class loop_While1 {

	public static void main(String[] args) {
		// TODO While문 이용한 각 자리 합 구하는 예제
		int num = 12345, sum = 0;
		
		System.out.println("12345의 각자리수 합을 구하라");
		
		while(num!=0) {
			sum += num%10; //num의 일의 자리를 떼어내 sum에 +=한다
			System.out.printf("num = %5d sum = %2d%n", num, sum);
			num /= 10;     //한자리수를 줄여 다음 반복에 쓰게함
		}
		
		System.out.println("각자리수 합 : " +sum);
	}

}
