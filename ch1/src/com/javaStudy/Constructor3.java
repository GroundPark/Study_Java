package com.javaStudy;

public class Constructor3 {

	public static void main(String[] args) {
		// TODO 생성자를 이용해 인스턴스를 복사하는 예제
		
				Car2 c1 = new Car2();
				Car2 c2 = new Car2(c1);
				//c2는 c1의 복사본

				System.out.printf("c1 속성 : 색상은 %s %s %dcc %n",c1.color,c1.gearType,c1.power );
				System.out.printf("c2 속성 : 색상은 %s %s %dcc %n",c2.color,c2.gearType,c2.power );
				
				System.out.println("c1.power = 3000 넣으면..");
				c1.power = 3000;
				System.out.printf("c1 속성 : 색상은 %s %s %dcc %n",c1.color,c1.gearType,c1.power );
				System.out.printf("c2 속성 : 색상은 %s %s %dcc %n",c2.color,c2.gearType,c2.power );
				//c1값이 변해도 별도의 인스턴스라 c2값은 변화없음
				}
			}

			class Car2{ 
				String color;
				String gearType;
				int power;
				
				Car2(){
					this("white", "auto", 2500);
				}
				
				Car2(Car2 c){
					this(c.color, c.gearType, c.power);
				}
				
				Car2(String c, String g, int p){
					color = c;
					gearType = g;
					power = p;
				}
			}
