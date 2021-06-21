package com.javaStudy;
import java.util.*;
import java.util.stream.*;
public class Stream6 {

	public static void main(String[] args) {
		// TODO flatMap으로 배열 문자열 스트림 합치기
		Stream<String []> strArrStream = Stream.of(
				new String [] {"abc", "def", "jkl"},
				new String [] {"ABC", "GHI", "JKL"}
				);
				
		Stream<String> strStream = strArrStream.flatMap(Arrays::stream);
		// 스트림이 배열 타입인 경우 flatMap()를 사용해 Stream<String []>를 Stream<T>로 변환하는게 좋음 
		// 그냥 map을 쓰면 스트림의 스트림 형태가 되어 나누어진 형태가 되므로 합쳐진 상태가 아님
		
		// strStream.map(String::toLowerCase).sorted().forEach(System.out::println);
		// 각배열의 '첫번째' + 각배열의 '두번쨰' + ... 순으로 처리
		
		strStream.map(String::toLowerCase).distinct().sorted().forEach(System.out::println);
		System.out.println("==================");
		
		// TODO flatMap으로 배열 문자열 스트림 나누기
		String [] lineArr = {
			"remove chat word",
			"for unique chat word"
		};
		
		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" +"))).distinct().sorted().forEach(System.out::println);
		System.out.println("==================");
		
		// TODO flatMap 사용해서 스트림의 스트림을 하나의 스트림으로 합치기
		Stream<String> strStream1 = Stream.of("AAA","ABC","Dd");
		Stream<String> strStream2 = Stream.of("AAA","ccc","dd");
		
		Stream<Stream<String>> strStreamX2 = Stream.of(strStream1, strStream2);
		Stream<String> strStream3 = strStreamX2.map( s -> s.toArray(String[]::new))  // Stream<Stream<String>> 에서 Stream<String[]>
											   .flatMap(Arrays::stream);			 // Stream<String[]> 에서 Stream<String>
																					 // .map.flatMap 두 과정 거침
		strStream3.map(String::toLowerCase).distinct().forEach(System.out::println);
	}

}
