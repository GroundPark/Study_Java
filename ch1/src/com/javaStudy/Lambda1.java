package com.javaStudy;

public class Lambda1 {
	public static void main(String[] args) {
		// TODO 람다식 : 메서드를 하나의 '식'으로 표현한 것(익명 함수)
		// 규칙1 : return 문 대신 '식'으로 대신하는 경우 끝에  ; 를 붙이지 않음
		// 규칙2 : 추론 가능한 매개변수 타입은 생략이 가능
		// 규칙3 : 매개변수가 1개면 괄호()를 생략할수 있다. 단, 매개변수 타입이 있다면 생략 불가
		// 규칙4 : 문장이 1개면 괄호 {}를 생략할 수있다. (문장끝에 ;를 붙이지 않음)
		// 규칙5 : 괄호 {} 안의 문장이 return문이면 생략 불가	
	}
	
	int a, b, x, i;
	String name = "";
	
	int max(int a, int b) {
		return a > b ? a : b;
	}
	// 규칙 1 : (int a, int b) -> a > b ? a : b
	// 규칙 2 : (a, b) -> a > b ? a : b
	// 규칙 5 : (int a, int b) -> {return a > b ? a : b;}
	
	int square(int x) {
		return x * x;
	}
	// 규칙 3 : x -> x * x
	
	void printBar(String name, int i) {
		System.out.println(name+"="+i);
	}
	// 규칙 4 : (name, i) -> System.out.println(name+"="+i);
	
	int roll() {
		return (int)(Math.random() * 6 );
	}
	// () ->(int)(Math.random() * 6)
}
