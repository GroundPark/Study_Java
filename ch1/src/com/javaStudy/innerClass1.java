package com.javaStudy;

public class innerClass1 {

	public static void main(String[] args) {
		// TODO 내부 클래스 : 클래스 내에 선언된 클래스
		// 코드 복잡성 줄임(캡슐화), 내부>외부쪽으로 멤버들을 쉽게 접근
		// static 멤버, instance 멤버간 관계같은 기본적인 처리는 동일
	}

}

class innerClassTest{
	class innerClass1{
		int iv = 10;
		final static int CONST = 100;
	}
	
	static class StaticInnerClass1{
		int iv = 20;
		static int cv = 200;
		// 내부 클래스도 static이 붙은것만 static멤버 가능 
	}
	
	void Testmethod() {
		class localInner {
			int iv = 30;
			final static int CONST = 200;
		}
	}
}