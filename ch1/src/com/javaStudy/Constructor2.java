package com.javaStudy;

class Constructor2 {

	public static void main(String[] args) {
		// TODO this 사용해서 생성자에서 다른 생성자 사용하기
		
		Car1 c1 = new Car1();
		Car1 c2 = new Car1("red");

		System.out.printf("c1 속성 : 색상은 %s %s %dcc %n",c1.color,c1.gearType,c1.power );
		System.out.printf("c2 속성 : 색상은 %s %s %dcc %n",c2.color,c2.gearType,c2.power );
		}
	}

	class Car1{
		String color;
		String gearType;
		int power;
		
		Car1(){
			this("white", "auto", 2500);
		}
		
		Car1(String color){
			this(color, "stick", 2000);
		}
		
		Car1(String c, String g, int p){
			color = c;
			gearType = g;
			power = p;
		}
	}

