package com.javaStudy;

public class Exception3 {

	public static void main(String[] args) throws Exception{
		// TODO 메서드에서의 예외, 예외발생시 호출한곳으로 넘김
			try{
				firstMethod();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

	public static void firstMethod() throws Exception{
		secondMethod();
	}
	
	public static void secondMethod() throws Exception{
		thirdMethod();
	}
	
	public static void thirdMethod() throws ArithmeticException, InterruptedException{
		System.out.println(0/0);
	}
}
//순서대로 1>3메서드까지 가고..3메서드에서 Exception이 일어났으므로.. 3>1 각각의 순서로 처리해야할 예외를 '넘겨준다'
//맨처음(main)에 try-catch문이 있는 이유는 넘겨준 예외는 어딘가에선 '반드시' 처리되어야 하기때문