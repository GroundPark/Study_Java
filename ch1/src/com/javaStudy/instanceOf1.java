package com.javaStudy;

public class instanceOf1 {

	public static void main(String[] args) {
		// TODO [참조변수 instanceof 클래스명]을 사용해 참조변수가 검사한 타입으로 형변환이 가능한지 T/F를 얻음
		
		father f = new father();
		
		if(f instanceof father) {
			System.out.println("f instanceof father : T");
		}
		
		if(f instanceof grandFather) {
			System.out.println("f instanceof grandFather : T");
		}
		
		if(f instanceof Object) {
			System.out.println("f instanceof Object : T");
		}
	}

}

class grandFather{}
class father extends grandFather{}