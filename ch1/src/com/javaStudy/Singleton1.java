package com.javaStudy;

class Singleton1{
	public static void main(String [] args) {
	  // TODO 싱글톤 연습
      //Singleton mysingle = new Singleton(); > 안됨 
		Singleton mysingle = Singleton.getInstance();
	}
}

final class Singleton{
	private static Singleton mysingle = new Singleton(); 
	//getInstance()에서 사용하게 인스턴스를 static으로 미리 생성해놓음
	
	private Singleton() { //생성자에 접근 제어자 private로 외부에서 생성자 접근 못하니 인스턴스 생성 못함
		System.out.print("싱글톤 private 생성자");
	}
	
	public static Singleton getInstance() { //인스턴스는 생성못하지만 호출할순있어야하니 public static
		if(mysingle == null) {
			mysingle = new Singleton();
		}
		return mysingle;
	}
}
