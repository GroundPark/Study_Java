package com.javaStudy;
import java.util.*;
public class Stream7 {

	public static void main(String[] args) {
		// TODO Optional<T> 클래스 : Integer나 Double 클래스처럼 T타입의 객체를 포장해 주는 '래퍼 클래스'
		// Optional 객체에 모든 타입의 참조 변수를 저장 가능
		// Optional 객체를 사용하면 예상치 못한 NullPointerException 예외를 제공 메서드로 간단히 처리 가능
		// null 값으로 인해 발생하는 예외를 처리 가능하므로 복잡한 if 조건문 작성 안해도 됨
		
		// Optional 객체의 값이 null이 아닌 경우 (! null이면 예외발생함)
		Optional<String> optStr = Optional.of("abcde");
		System.out.println("optStr = "+optStr.get());
		
		int result1 = Optional.of("1234").filter( x -> x.length() > 0 )
						.map(Integer::parseInt).get();
		System.out.println(result1);
		
		// Optional 객체의 값이 null인 경우
		Optional<String> optNull = Optional.ofNullable(null);   			// ofNullable()에서 참조변수 값이 null 인경우 예외발생 막아줌 
		String nullStr1 = optNull.orElse("Null을 대체할 문자열 여기 적으셈");
		String nullStr2 = optNull.orElseGet( () -> new String());			// orElseGet()   대체할 값을 람다식으로 지정 할때 
	  //String nullStr3 = optNull.orElseThrow(NullPointerException::new);	// orElseThrow() 예외발생이 안생기므로 지정된 예외를 발생시키고 싶을때 
		System.out.println("optNull = "+optNull);
		System.out.println("opt널값 확인 : " +nullStr1);

		int result2 = Optional.of("").filter( x -> x.length() > 0 )
				.map(Integer::parseInt).orElse(0);
		System.out.println(result2);
		
		// etc..
		Optional<String> optDefault = Optional.empty();			// empty()사용해서 빈 객체로 초기화함 (null 상태)
		
		if(Optional.ofNullable(optStr).isPresent()) {  			// isPresent()사용해서 값이 존재하면 true, null이면 false 반환
			System.out.println(optStr);
		}
	  //Optional.ofNullable(optStr).ifPresent(System.out::println);	// ifPresent()사용해서 메서드안의 if문으로 더 간결화 가능  
		
		OptionalInt optInt1 = OptionalInt.of(0);
		OptionalInt optInt2 = OptionalInt.empty();
		// IntStream 처럼 Int, Long, double 기본형을 다룰수 있음. (뒤에 붙임)
		
		System.out.println(optInt1.getAsInt());
	}		

}
