package com.javaStudy;

public class equals1 {

	public static void main(String[] args) {
		// TODO equals 메서드는 두 객체의 같고 다름을 '참조변수의 값'으로 판단함 
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		if(v1.equals(v2)) 
			System.out.println("v1.equals(v2)는  T");
		else
			System.out.println("v1.equals(v2)는  F");
		//v2와 v1은 값은 같아보여도 '주소값'이 다르기에 equals 비교시 다름
		
		v2 = v1;
		//v2에 v1의 주소가 들어갔으므로 '주소값'이 같기에 equals 비교시 같음 
		
		if(v1.equals(v2)) 
			System.out.println("v1.equals(v2)는  T");
		else
			System.out.println("v1.equals(v2)는  F");
	}
}

class Value{
	int value;
	
	Value(int value){
		this.value = value;
	}
}