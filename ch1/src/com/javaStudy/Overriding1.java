package com.javaStudy;

public class Overriding1 {

	public static void main(String[] args) {
		// TODO 오버라이딩 : 상속받은 메서드의 내용을 변경하는 것
		// 자손에서 구현할때 이름, 매개변수, 리턴이 같아야 함
		
		Child c = new Child();
		c.method();
	}

}

class Parent{
	int x = 10;
}

class Child extends Parent{
	int x = 20;
	
	void method() {
		System.out.println("Child에서 ... x=" +x);
		System.out.println("this.x=" +this.x);
		System.out.println("super.x=" +super.x);
	}
}