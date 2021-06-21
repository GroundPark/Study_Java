package com.javaStudy;

import java.util.*;
import java.util.stream.*;
public class Stream9 {

	public static void main(String[] args) {
		// collect(collector) : 스트림의 요소를 수집하는 최종 연산
		// collector  : 스트림의 요소를 어떻게 수집할건지 방법. Collector 인터페이스를 구현함 (Collector Type)
		// Collectors : 클래스, static 메서드로 미리 작성된 collector 제공 
		Stu [] studentArr = { 
				  new Stu("Kim", 3, 300),
				  new Stu("Jun", 1, 200),
				  new Stu("Hoe", 2, 100),
				  new Stu("Yun", 2, 150),
				  new Stu("Tae", 1, 200),
				  new Stu("Hue", 3, 290),
				  new Stu("Zin", 3, 180)
			   };
		
		List<String> names = Stream.of(studentArr).map(Stu::getName).collect(Collectors.toList());
		// 스트림의 모든 요소를 컬렉션에 수집하기위해 Collectors의 toList() 사용 (이외 다른 컬렉션은 toCollection(생성자::참조) 사용)
		System.out.println(names);
		
		Map<String, Stu> stuMap = Stream.of(studentArr)
									 .collect(Collectors.toMap( s -> s.getName(), p -> p));
		// 스트림을 Map<String, Stu>로 변환함. String은 key값(이름), Stu는 Stu 객체자신
		for(String name : stuMap.keySet())
			System.out.println("키값 "+name +": "+stuMap.get(name)); 
		
		// TODO collect()에서도 통계 정보를 얻을수 있는데 groupBy에서 필요함
		long count 				  = Stream.of(studentArr).collect(Collectors.counting());	//7
		long totalScore 		  = Stream.of(studentArr).collect(Collectors.summingInt(Stu::getTotalScore));
		Optional<Stu> TopStu 	  = Stream.of(studentArr).collect(Collectors.maxBy(Comparator.comparingInt(Stu::getTotalScore)));
		IntSummaryStatistics stat = Stream.of(studentArr).collect(Collectors.summarizingInt(Stu::getTotalScore));
		
		System.out.println("summingInt로 총합 : "+totalScore);
		System.out.println("maxBy로 최대점수 학생 : " +TopStu.get());
		System.out.println("summarizingInt로 요약 : "+stat);
		
		String stuNames = Stream.of(studentArr).map(Stu::getName).collect(Collectors.joining(",", "{", "}"));
		System.out.println("joining으로 학생이름 : "+stuNames);
		// joining()으로 모든 요소를 하나의 문자열로 연결해 반환. (구분자,접두사,접미사)를 파라미터로 가짐
		// 스트림의 요소가 String, StringBuffer같은 경우에만 결합이 가능한데... map()을 사용해 요소를 문자열로 변환하면 됨
		
		totalScore = Stream.of(studentArr).collect(Collectors.reducing(0, Stu::getTotalScore, Integer::sum));
		// reducing(초기값, map, BinaryOp)
		System.out.println("reducing하여 sum한 값 : "+totalScore);
		
	}
}
