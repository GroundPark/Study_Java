package com.javaStudy;

public class init1 {

	public static void main(String[] args) {
		// 지역변수는 필수적으로 초기화해야함
		// 멤벼변수는 explicit(명시적), 생성자, init 블럭으로 초기화
		
		int no_use = 4; //기본형 변수 explicit 초기화
		tempClass tmp = new tempClass(); //참조형 변수 explicit 초기화	
		tempClass tmp2 = new tempClass();
	}
}

class tempClass {
	static {
		System.out.println("클래스 초기화 블럭");
		//클래스가 메모리에 로딩될때 한번 수행, 클래스 변수 초기화
	}
	
	{
		System.out.println("인스턴스 초기화 블럭");
		//생성자보다 먼저 수행되며 생성자에서 공통된(중복) 코드를 넣음, 인스턴스 변수 초기화
	}
	
	tempClass(){
		System.out.println("생성자");
	}
	
	void method1(){
		int i;
		//int j = i;    i는 지역변수라 자동으로 초기화되지않았고.. 그걸 j 초기화하는데 사용하면 에러남
	}
}