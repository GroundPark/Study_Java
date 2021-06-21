package com.javaStudy;

public class Overloading1 {

	public static void main(String[] args) {
		// TODO 오버로딩 : 다양한 타입과 개수의 매개변수를 가진 메소드를 여러 개 생성하여	여러가지 유형의 호출에 응답하게 함
		MyAdd1 tmp = new MyAdd1();
		System.out.println("tmp.add(3,3) = " +tmp.add(3,3));
		System.out.println("tmp.add(3L,3) = " +tmp.add(3L,3));
		System.out.println("tmp.add(3,3L) = " +tmp.add(3,3L));
		System.out.println("tmp.add(3L,3L) = " +tmp.add(3L,3L));		
	}
}

class MyAdd1{
	int add(int a, int b) {return a+b;}
	long add(long a, int b) {return a+b;}
	long add(int a, long b) {return a+b;}
	long add(long a, long b) {return a+b;}
	//add 메서드의 매개변수와 자료타입을 다양하게 바꿈으로 오버로딩 함
}
