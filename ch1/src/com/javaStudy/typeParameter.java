package com.javaStudy;

public class typeParameter {

	public static void main(String[] args) {
		// TODO 기본형, 참조형 매개변수의 차이 예제
		Data myData = new Data();
		myData.x = 10;
		
		System.out.println("맨처음 main에서 x는 " +myData.x);
		
		Pchange(myData.x);
		System.out.println("Pchange() 호출 후 main에서 x는 " +myData.x);
		System.out.println("-------------");
		//myData.x는 10인 상태에서.. change 메소드의 매개변수에 복사되었으므로 복사본의 x가 10에서 100으로 변경된다
		//복사본에 x=100이 있지만 '복사본을 다루는 코드'들이 없으므로 메서드가 종료되면서 사라짐

		
		Rchange(myData);
		System.out.println("Rchange() 호출 후 main에서 x는 " +myData.x);
		//x값이 저장된 주소를 참조형으로 넘겼고.. 주소는 그대로에서 값만 444로 변경했다.

		}
	
		static void Pchange(int x) {
			x = 100;
			System.out.println(">>Pchange() 메서드의 x : " +x);
		}
		
		static void Rchange(Data myData) {
			myData.x = 444;
			System.out.println(">>Rchange() 메서드의 x : " +myData.x);
		}
		
}

class Data { int x; }