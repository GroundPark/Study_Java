package com.javaStudy;
import java.util.stream.*;
public class Stream3 {

	public static void main(String[] args) {
		// TODO 스트림의 중간연산
		IntStream intStream1 = IntStream.rangeClosed(1,10);      //1~10의 요소
		intStream1.skip(3).limit(5).forEach(System.out::print);  
		// skip(n)에서 처음 n개의 요소를 건너뛰고... limit(m)에서 요소를 m개로 제한함 = 45678
		
		IntStream intStream2 = IntStream.of(1,2,3,3,4,5,6,6);
		intStream2.distinct().forEach(System.out::print);
		// distinct()에서 중복요소만 제거함 = 123456
		
		IntStream intStream3 = IntStream.rangeClosed(1, 10);
		intStream3.filter( i -> i%2 ==0 ).forEach(System.out::print);
		// filter( [Predicate 조건 람다식] )에서 조건에 맞지않는 요소를 제거함(.filter().filter()처럼 중복사용가능) = 246810
		
		Stream<String> strStream1 = Stream.of("ddd","aaa","C","cc","d");
		strStream1.sorted().forEach(System.out::print);
		// sorted()에서 스트림 요소의 기본 Comparable 기준으로 정렬함
		// sorted(Comparator)로 기준 지정 가능 (824p)... 람다식도 가능함
		// 예를들어 sorted(Comparator.reverseOrder())   /   sorted(String::compareTo);
	}

}
