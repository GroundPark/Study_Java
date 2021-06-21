package com.javaStudy;

public class Exception6 {

	public static void main(String[] args) {
		// TODO 예외 re-throwing : 예외를 처리하고 강제로 다시 발생시킴
		try {
			method1();
		}catch(Exception e) {
			System.out.println("main에서 예외처리");
		}
	}
	
	static void method1() throws Exception{
		try {
			throw new Exception();
		}catch(Exception e){
			System.out.println("메서드1에서 예외처리");
			throw e;	//catch블럭에서 throw로 예외 발생시킴
		}
	}
}
