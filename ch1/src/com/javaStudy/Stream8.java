package com.javaStudy;
import java.util.stream.*;
import java.util.*;
public class Stream8 {

	public static void main(String[] args) {
		// TODO 스트림의 최종 연산
		String [] strArr = { "Java", "String", "ints", "stream" };
		
		Stream.of(strArr).forEach(System.out::println);
		
		boolean isEmptyStr = Stream.of(strArr).noneMatch( s -> s.length() == 0);
		System.out.println("isEmptyStr = " +isEmptyStr);
		
		boolean hasWord_s = Stream.of(strArr).anyMatch( s -> s.charAt(0)=='s');
		System.out.println("hasWordS : "+hasWord_s);
		// allMatch, anyMatch, noneMatch 메서드를 사용해 지정 Predicate에 전부 일치, 일부 일치, 아무것도 일치안함을 판별하여 bool값 반환
		
		Optional<String> sWord = Stream.of(strArr).filter(s->s.charAt(0)=='s').findFirst();
		System.out.println("sWord = " +sWord.get());
		// findFirst()를 사용해 스트림의 요소 중 조건에 일치하는 첫번째 요소 반환
		// ! 병렬 스트림의 경우엔 findAny() 사용
		
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		
		int count = intStream1.reduce(0,  (a,b) -> a+1);
	  //int sum   = intStream1.reduce(0,  (a,b) -> a+b);
		// reduce()에서 스트림의 요소를 줄여가면서 연산을 수행하고 결과 반환 (초기값, BinaryOp)
		// 매개변수 타입이 BinaryOperator : 처음 두 요소를 가지고 연산 -> 그 결과를 가지고 다음 요소와 연산 -> ... 반복
		System.out.println(count);
		
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
	    OptionalInt max = intStream3.reduce((a,b) -> a > b ? a : b);	// BinaryOp
	    OptionalInt min = intStream4.reduce(Integer::min);				// BinaryOp를 하는 메서드를 메서드 참조로 바꿈
		// IntStream 타입이므로 OptionalInt를 사용함.
	    
		System.out.println("max : " +max.getAsInt());
		System.out.println("min : " +min.getAsInt());
	  
	}

}
