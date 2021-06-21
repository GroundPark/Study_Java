package com.javaStudy;

class Constructor1 {

	public static void main(String[] args) {
		// TODO 생성자 : 인스턴스 변수 초기화 작업에 씀
		
	Car c1 = new Car();
	Car c2 = new Car();
	c2.color="red";
	c2.gearType="stick";
	c2.power=2500;
		
	Car myCar = new Car("blue","auto",3000);
	System.out.printf("c1 속성 : 색상은 %s %s %dcc %n",c1.color,c1.gearType,c1.power );
	System.out.printf("c2 속성 : 색상은 %s %s %dcc %n",c2.color,c2.gearType,c2.power );
	System.out.printf("c3 속성 : 색상은 %s %s %dcc %n",myCar.color,myCar.gearType,myCar.power );
	}
}

class Car{
	String color;
	String gearType;
	int power;
	
	Car(){}
	
	Car(String c, String g, int p){
		color = c;
		gearType = g;
		power = p;
	}
}