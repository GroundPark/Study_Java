package com.javaStudy;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Stream12 {

	public static void main(String[] args) {
		// TODO Collector<T, A, R> 인터페이스 구현
		String [] strArr = {"Java", "Stream", "concat"};
		
		Stream<String> strStream = Stream.of(strArr);
		String result = strStream.collect(new ConcatCollector());
		
		System.out.println(Arrays.toString(strArr));
		System.out.println(result);
	}

}

@Deprecated
class common_concatEX {
	void commonConcat() {
		// 평범한 concatenate 예제코드에서 필요한 부분을 Collector 인터페이스로 바꾸는 연습용 코드
	String [] StringArr = {"ab", "cd", "123"};
	StringBuffer sb = new StringBuffer();
	
	for(String tmp : StringArr)
		sb.append(tmp);
	
	String result = sb.toString();
	}
}

class ConcatCollector implements Collector<String, StringBuilder, String>{
	// Collector 구현. 코딩 전에 unimplement 메서드 구현하라는거 누르면 IDE에서 아래 코딩 '대충' 만들어줌
	// Supplier() 	 : 작업 결과를 저장할 공간
	// accumulator() : 스트림의 요소를 collect할 방법
	// combiner() 	 : 두 저장공간을 병합할 방법 (병렬 스트림)
	// finisher() 	 : 결과를 최종적으로 변환할 방법 (필요없으면 항등함수)
	// characteristics() : 컬렉터가 수행하는 작업의 속성에 대한 정보. set 반환 (필요없으면 emptySet())
	@Override
	public Supplier<StringBuilder> supplier(){
		return () -> new StringBuilder();
      //return StringBuilder::new;
	}

	@Override
	public BiConsumer<StringBuilder, String> accumulator() {
	  //return (sb, s) -> sb.append(s);
		return StringBuilder::append;
	}

	@Override
	public BinaryOperator<StringBuilder> combiner() {
		return (sb, sb2) -> sb.append(sb2);
	}

	@Override
	public Function<StringBuilder, String> finisher() {
		return sb -> sb.toString();
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();		//지정안함
	}
}