package com.javaStudy;

public class Extends3 {

	public static void main(String[] args) {
		// TODO 멤버변수가 조상/자식 클래스에 중복으로 정의된 경우
		Parent1 p = new Child1();
		Child1 c = new Child1();
		
		System.out.println("p.x = " +p.x);
		p.method();
		System.out.println();
		
		System.out.println("c.x = " +c.x);
		c.method();
	}

}

class Parent1{
	int x = 100;
	
	void method() {
		System.out.println("부모 메서드");
	}
	
}

class Child1 extends Parent1{
	int x = 10;
	
	void method() {
		System.out.println("x=" +x);	//x는 this.x와 같음
		System.out.println("super.x=" +super.x);		
	}
}