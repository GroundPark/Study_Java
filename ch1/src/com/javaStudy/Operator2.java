package com.javaStudy;

public class Operator2 {

	public static void main(String[] args) {
		// TODO 연산자 기본 예제
		boolean T = true;
		boolean F = false;
		
		// 연산자 우선순위는 || 보다  &&가 높다. 
		// 예를들어 A 또는 B 그리고 C인 경우라 가정했을때 말 그대로 써버리면 뒷부분 and가 먼저 되므로 내가 원하지 않는 수식이 되버림 
		System.out.printf("%b%n", T || T && F);  
		// T or (F) 에서 T >> 틀림
		System.out.printf("%b%n", (T || T) && F); 
		// (T) and F 에서 F >> 맞음
		System.out.println();
		
		// 효율적 연산
		int a = 5;
		int b = 0;
		
		System.out.printf("a!=0 || ++b!=0 >> %b%n", a!=0 || ++b!=0); //어차피 참이라 뒤 연산 생략
		System.out.printf("a==0 && ++b!=0 >> %b%n", a==0 && ++b!=0); //어차피 거짓이라 뒤 연산 생략
		System.out.printf("전처리증가가 있어도 b는 여전히 %d", b);
	}

}
