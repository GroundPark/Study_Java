package com.javaStudy;

class equals2 {

	public static void main(String[] args) {
		// TODO equals가 주소값이 같음에 대한 메서드이므로 '값'을 비교하기 위한 예제
		// String 같은 클래스들의 경우... 이미 자바에서 equals가 '값'을 비교하도록 만들어져 있다

		Value1 v1 = new Value1(10);
		Value1 v2 = new Value1(10);
		
		if(v1 == v2) 
			System.out.println("v1.equals(v2)는  T");
		else
			System.out.println("v1.equals(v2)는  F");
		
		if(v1.equals(v2)) 
			System.out.println("v1.equals(v2)는  T");
		else
			System.out.println("v1.equals(v2)는  F");
	}
}

class Value1{
	int value;
	
	public boolean equals(Object obj) {
		if(obj instanceof Value1)
			return value == ((Value1)obj).value;
			// obj를 Value1 타입으로 형변환 하고... value를 비교하게하여... 다른 인스턴스끼리의 '값 같음'을 비교할수있다
		else
			return false;
	}
	
	
	Value1(int value){
		this.value = value;
	}
}