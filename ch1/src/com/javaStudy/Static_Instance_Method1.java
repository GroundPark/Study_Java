package com.javaStudy;

public class Static_Instance_Method1 {

	public static void main(String[] args) {
		// TODO Static 메서드, Instance 메서드 사용시 주의 사항 정리
		
		System.out.println("MyAdd.add(2+5) = " +MyAdd.add(2L, 5L));
		//클래스 메서드는 객체생성없이 호출가능, 매개변수 바로 넣을수 있음
		
		MyAdd tmp = new MyAdd();
		tmp.a = 3L;
		tmp.b = 4L;
		//인스턴스 메서드는 객체생성해야 호출가능
		System.out.println(tmp.add());
	}
}

class MyAdd{
	long a,b; 
	
	long add() { return a + b; }
	//인스턴스 변수를 사용해야하므로 매개변수 필요없음
	
	static long add(long a, long b) { return a + b; }
	//클래스 멤버는 인스턴스 멤버를 호출할수없음. 인스턴스는 생성되어야 사용가능한데 없으면 어쩔?
}
