package com.javaStudy;

public class clone1 {

	public static void main(String[] args) {
		// TODO clone() 메서드는 자신을 복제하여 새로운 인스턴스를 생성한다
		// 1. 복사할 클래스에서 Cloneable 인터페이스를 구현한다
		// 2. public Object clone() 코드
		// 3. try-catch문
		
		Point2 original = new Point2(3, 5);
		Point2 Copied = (Point2)original.clone();
		
		System.out.println(original);
		System.out.println(Copied);
	}
}

class Point2 implements Cloneable{
	int x, y;

	Point2(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x="+x +"  y="+y;
	}
	
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		}catch(CloneNotSupportedException e) {}
		return obj;
	}
}