package com.javaStudy;

public class Lambda2 {
	static void execute(MyFunction f) {
		f.run();
	}
	// 매개변수의 타입이 MyFunction인 메서드
	
	static MyFunction getMyFunction() {
		MyFunction f = () -> System.out.println("f3.run()");
		return f;
	}
	// 반환 타입이 MyFunction인 메서드
	
	public static void main(String[] args) {
		// TODO 함수형 인터페이스 : 람다식을 다루기 위한 인터페이스
		MyFunction f1 = () -> System.out.println("f1.run()");
		// f1에 람다식으로 run()을 구현함
		
		MyFunction f2 = new MyFunction() {
			public void run() {
				System.out.println("f2.run()");
			}
		};
		// 익명 클래스로 run()을 구현함. 구현 메서드에 public 필수
		
		MyFunction f3 = getMyFunction();
		
		f1.run();
		f2.run();
		f3.run();	
		execute(f1);
		execute(   () -> System.out.println("run()")    );
	}
}

@FunctionalInterface
interface MyFunction{
	void run();
}