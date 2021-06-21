package com.javaStudy;

public class AnonymousClass1 {

	public static void main(String[] args) {
		// TODO 익명 클래스 : 선언, 생성을 동시에 하고.. 한번만 사용되고.. 하나의 객체만을 생성하는 일회용 클래스
		// 생성자도 없으며.. 하나의 클래스 or 인터페이스만을 구현
	}

}

class AnonymouseTest{
	Object iv = new Object() {
		void method() { 
			//구현 
			}
		};
		
	void myMethod() {
		Object lv = new Object() {
			void method() {
				//구현
			}
		};
	}
}
//컴파일시  이름.class - 이름$1.class - 이름$2.class .... 형식으로 나옴