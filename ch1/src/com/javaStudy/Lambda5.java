package com.javaStudy;
import java.util.function.*;

public class Lambda5 {

	public static void main(String[] args) {
		// Function 의 합성 : 두 함수를 합성해서 새로운 함수를 만들때 사용. (간단예 : T -> f<T,R> -> g<R,V> -> V)
		// f,g 함수에서... f.andThen(g)는 f적용후g <-> f.compose(g)는 g적용후f   	
		Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i);
		Function<String, String> h = f.andThen(g);
		System.out.println("f.andThen(g)          " +h.apply("F"));
		// 문자열을 숫자로 변환하는 함수f + 숫자를 2진문자열로 변환하는 함수g >> f.andThen(g)로 새 함수h를 만듬 => apply하여 결과값 도출  
		// F는 10진수로 15에서 F = 15... 15는 2진수로 1111에서 15 = 1111
		
		Function<Integer, Integer> h2 = f.compose(g);
		System.out.println("f.compose(g)          "+h2.apply(2));
		// 2는 2진수로 10에서 2 = 10... 10은 16진수로 16에서 10 = 16
		
		Function<String, String> iden = Function.identity();   // x -> x;와 같음
		System.out.println("Function.identity()   "+iden.apply("apple"));
		// 항등 함수로 함수 적용 전후가 같음. 잘 안쓰지만 map()의 변환작업할때 변환없는 처리에 사용됨
		
		
		// Predicate의 결합 : 조건식에 and,or,not을 연결해 사용하듯이 and(),or(),negate()를 사용해 조건식 Predicate를 결합한다
		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i > 200;
		Predicate<Integer> r = i -> i%2 == 0; 
		Predicate<Integer> notP = p.negate();
		
		Predicate<Integer> mixTest = notP.and(q.or(r));
		// i>=100 && (i>200 || i%2==0)... q,r은 위의 람다식 그대로 써도됨
		System.out.println("notP.and(q.or(r)      "+mixTest.test(150));
		
		String str1 = "abc";
		String str2 = "abc";
		
		Predicate<String> isE = Predicate.isEqual(str1); 	// 비교 조건문엔 isEqual을 씀
		boolean result = isE.test(str2);
		System.out.println("Predicate.isEqual     "+result);
	}
}
