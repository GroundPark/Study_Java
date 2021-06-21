package com.javaStudy;
import java.util.function.*;
public class Lambda6 {

	public static void main(String[] args) {
		// 메서드 참조 : 람다식이 하나의 메서드만 호출하는 경우 간략화 시킴

		// ▽  클래스이름::메서드이름
		Function<String, Integer> f1 = (String s) -> Integer.parseInt(s);   //람다식
		Function<String, Integer> f2 = Integer::parseInt;					//메서드 참조
		
		BiFunction<String, String, Boolean> f3 = (s1, s2) -> s1.equals(s2);
		BiFunction<String, String, Boolean> f4 = String::equals;
		
		Function<Integer, int[]> f5 = x -> new int[x];		//람다식 (배열)
		Function<Integer, int[]> f6 = int[]::new;			//메서드 참조
		
		Function<String, Boolean> q3 = (x) -> MyClass6.isK(x); //람다식
		Function<String, Boolean> q4 = MyClass6::isK;		   //메서드 참조 
		
		// ▽ 참조변수::메서드이름 
		MyClass5 obj = new MyClass5();
		Function<String, Boolean> q1 = (x) -> obj.equals(x); //람다식
		Function<String, Boolean> q2 = obj::equals;			 //메서드 참조
	}

}

class MyClass5 {}

class MyClass6 {
	static boolean isK(String x){
		return true;
	}
}