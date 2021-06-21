package com.javaStudy;

public class Extends2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point3D p = new Point3D();
		System.out.printf("p3의 x=%d, y=%d, z=%d",p.x,p.y,p.z);
	}

}

class Point1{
	int x=10;
	int y=20;
	
	Point1(int x, int y){
					// super();가 생략돼있다. object 클래스는 필요한거아니면 굳이 표현안해도됨
		this.x = x;
		this.y = y;
	}
}

class Point3D extends Point1{
	int z=30;
	
	Point3D(){
		this(100,200,300);
	}
	
	Point3D(int x, int y, int z){
		super(x,y);
		this.z = z;
	}
}