package com.javaStudy;
import java.util.*;

public class recursiveCall1 {

	public static void main(String[] args) {
		// TODO 재귀호출을 이용한 팩토리얼 구현 예제
		
		System.out.println("n!에 들어갈 n을 입력하시오");
		
		Scanner scanner = new Scanner(System.in);
		
		String tmp = scanner.nextLine();
		int input = Integer.parseInt(tmp);
		
		if(input<=0 || input>12) {
			System.out.println("입력값이 int표현 값을 넘는 12이상 이거나, 0이하입니다");
			System.exit(0);
		}
		//매개변수의 유효성 검사로 무한반복, 오버플로우 에러와 같은 상황을 대비함
		
		int result = factorial(input);
		//static 메서드는 인스턴스 생성안해도 쓸수있다
		System.out.println(input +"! : " +result);
	}
	
	static int factorial(int n) {
		int result = 0;
		
		if(n == 1)
			result = 1;
		else
			result = n * factorial(n-1);
		// 1!=1이고.. 예를들어 4!=4*3! > 3!=3*2! > 2!=2*1!
		
		return result;
	}
}
