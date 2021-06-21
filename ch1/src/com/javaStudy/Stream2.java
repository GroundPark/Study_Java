package com.javaStudy;
import java.util.*;
import java.util.stream.*;
import java.io.IOException;
import java.nio.file.*;

public class Stream2 {
	public static void main(String[] args) {
		// Collection에 stream()이 정의돼있는데 자손인 List,Set을 구현한 컬렉션 클래스들은 이 메서드로 스트림을 생성할수 있음
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> intStream = list.stream();
		// 1. Collection.stream()에서 해당 컬렉션(여기선 list)을 소스로 하는 스트림을 반환함
		intStream.forEach(System.out::println);
		
		// 2. 배열을 소스로 하는 스트림 : Stream, Array에 static 메서드로 제공
		Stream<String> strStream1 = Stream.of("a","b","c","d"); 
		Stream<String> strStream2 = Arrays.stream(new String [] {"가","나","다","라"});
		
		IntStream intStream1 = IntStream.of(1,2,3,4,5); 
		IntStream intStream2 = Arrays.stream(new int [] {1,2,3,4,5});
		// LongStream, DoubleStream 경우도 유추가능
		
		IntStream intStream3 = IntStream.range(1, 5);	  	 // 보통범위 1~5
		IntStream intStream4 = IntStream.rangeClosed(1, 5);  // 끝값포함범위 1~5
		// 3. 지정범위의 연속된 정수를 스트림으로 생성
		
		IntStream randStream1 = new Random().ints(); 		//무한 스트림
		randStream1.limit(5).forEach(System.out::println);  //limit(n) 사용해서 유한 스트림으로 개수를 꼭 제한해야함 
		// 4. 난수 스트림 코드
		IntStream randStream2 = new Random().ints(5);
		randStream2.forEach(System.out::println);
		
		IntStream randStream3 = new Random().ints(1,46);	//1~45 범위의 int타입 난수를 발생시키는 스트림

		Stream<Integer> evenStream = Stream.iterate(0, n -> n+2);
		Stream<Integer> OnlyOne = Stream.generate( () -> 1 );
		// 5. iterate()는 [람다식을 이용해] 시드값부터 시작하여... 결과값을 다시 시드값으로 사용하며 무한 반복해 결과를 냄 (예제에서 0,2,4...)
		//    generate()는 [람다식을 이용해] supply<T>형식으로 무한반복해 결과를 냄 (예제에서 1,1,1...)
		
		Stream emptyStream = Stream.empty();	// 6. 빈 스트림을 만듬. null쓰지말고 empty()사용 권함
		long count = emptyStream.count();
		
		Stream<String> conStream = Stream.concat(strStream1, strStream2);
		// 7. 같은 타입의 스트림 두개를 연결함
		}
	static void fileStream1() throws IOException {
		Path path = Paths.get("D:/Study_Java/ch1/src/com/javaStudy/TestData.txt");
		Stream<Path> fileStream = Files.list(path);
		// 8. 파일, 파일의 한 라인 , 다른 입력대상 등으로 부터도 데이터를 읽어올수 있음 (예제에선 파일하나)
	}
}


