package com.javaStudy;

public class Extends1 {

	public static void main(String[] args) {
		// 상속 방법으로 extends를 씀
		// 포함 방법으로 멤버변수로 다른 클래스 타입의 참조변수 선언 
		// 상속 : is // 포함 : has
		// 예를들어 [원 is 점/ 원 has 점]을 비교했을때 후자가 더 어울림
		
		Circle c = new Circle(new Point(150,100),50);
		
		c.draw();
	}
}

class Shape{
	String color = "black";
	
	void draw() {
		System.out.printf("Shape 메서드의 출력문 color = %s",color);
	}
}
	
class Point{
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	Point(){
		this(0,0);
	}
	
	String getXY(){
		return "("+x+", "+y+")";
	}
}

class Circle extends Shape{		//Circle과 Shape는 상속관계 : circle is shape
	Point center;				//Circle과 Point는 포함관계 : circle has point
	int r;
	
	Circle(Point center, int r){
		this.center = center;
		this.r = r;
	}
	
	Circle(){
		this(new Point(0,0), 100); //기본값
	}
	
	void draw() {	//오버라이딩해서 Shape의 draw()가 아닌 밑의 메서드가 출력됨
		System.out.printf("원의 속성 = 원점(%d,%d), 반지름 r = %d, 색상 = %s", center.x, center.y,r,color);
	}
}


