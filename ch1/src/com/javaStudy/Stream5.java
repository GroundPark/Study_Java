package com.javaStudy;
import java.io.File;
import java.util.stream.*;
public class Stream5 {

	public static void main(String[] args) {
		// TODO Stream 중간연산
		File [] fileArr = {new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"), new File("DATA")};
		
		Stream<File> fileStream = Stream.of(fileArr);
		
		Stream<String> filenameS = fileStream.map(File::getName);  // map()으로 Stream<File>을 Stream<String>으로 변환함
		filenameS.forEach(System.out::println);
		
		fileStream = Stream.of(fileArr);
		
		fileStream.map(File::getName)
				  .filter(s -> s.indexOf('.') != -1)        		// 확장자가 없는것은 제외(.없으면 -1)
				  .peek(s -> System.out.println("peek = " +s))      // peek()로 중간연산의 중간결과를 봄
				  .map(s -> s.substring(s.indexOf('.')+1))  		// .뒤의 문자만 가져오게 변환(map)함
				  .peek(s -> System.out.printf("peek2 = %s %n", s))
				  .map(String::toUpperCase)							// 대문자로 변환함
				  .distinct()
				  .forEach(System.out::println);	
	}
}
