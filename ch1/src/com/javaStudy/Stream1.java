package com.javaStudy;
import java.util.*;
import java.util.stream.Stream;

public class Stream1 {

	public static void main(String[] args) {
		// 컬렉션, 배열에 데이터를 담고 결과도출까지 for, Iterator이용했는데 복잡하고 재사용성 떨어짐
		// 각 컬렉션 클래스에는 같은 기능의 메서드들이 중복 정의되어 있음 (예를들어 List 정렬에 Collections.sort()...Array 정렬에 Arrays.sort())
		
		// TODO 스트림(Stream) API : 두 문제를 해결하기 위해 데이터 소스를 추상화하고 데이터를 다루는데 자주 사용되는 메서드들을 정의해 놓았다. 
		// 데이터 소스를 추상화하여 어떤 데이터 소스든 같은 방식으로 다룰수 있어 재사용성이 높아짐
		// ! input-output에서 쓰이는 Stream과 전혀 다른 개념.  
		// 데이터 소스는 변경안함. Iterator처럼 일회용이라 사용후 다시 생성해야함. 내부반복(메서드 내에 반복문을 숨겨놈)으로 간결화함
		
		String [] strArr = {"010","kr","Jun"};
		List<String> strList = Arrays.asList(strArr);
		
		Stream<String> strStream1 = strList.stream();
		Stream<String> strStream2 = Arrays.stream(strArr);
		
		strStream1.sorted().forEach(System.out::println);  // (str) -> System.out.println(str) 
		strStream2.sorted().forEach(System.out::println);
		
		Stream<String> strStream3 = Stream.of("a","a","e","d","c");
		strStream3.distinct().limit(3).sorted().forEach(System.out::println);
		// 중간연산 : 중복 제거.스트림 3까지 자르기.정렬 >>> 최종연산 : 출력
		// 중간연산은 각각이 스트림으로 반환되므로 연결되지만... 최종연산은 소모하면서 수행하므로 단 한번만 연산함
		// ! 지연된 연산 : 최종 연산이 수행되기 전에는 중간 연산이 수행되지않음... 
		
		
		// Stream<Integer>    IntStream 
		// 요소 타입이 <T>인 스트림은 Stream<T>지만 오토박싱&언박싱의 비효율을 줄이기 위해 IntStream, LongStream, DoubleStream이 제공됨
		// 일반적으로 Stream<Integer>보다 IntStream이 효율적이고, 그 자료형에 맞는 메서드도 제공해줌
		
		// 스트림으로 데이터 다룰땐 병렬처리가 쉽다는 장점이 있음. parallel()로 병렬화 할수 있고 sequential()로 기본값으로 바꿀수있음
 	}

}
