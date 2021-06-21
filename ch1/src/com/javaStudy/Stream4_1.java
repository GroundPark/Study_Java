package com.javaStudy;

import java.util.Comparator;
import java.util.*;
import java.util.stream.*;

public class Stream4_1 {
	public static void main(String[] args) {
		Stu [] studentArr = { 
								  new Stu("Kim", 3, 300),
								  new Stu("Jun", 1, 200),
								  new Stu("Hoe", 2, 100),
								  new Stu("Yun", 2, 150),
								  new Stu("Tae", 1, 200),
								  new Stu("Hue", 3, 290),
								  new Stu("Zin", 3, 180)
							   };
		Stream<Stu> stuStream = Stream.of(studentArr);
		
		stuStream.sorted(Comparator.comparing(Stu::getGrade)     
							.thenComparing(Comparator.naturalOrder()))	 
							.forEach(System.out::println);
		System.out.println("====== △ 학생 스트림 정렬======");
		
		stuStream = Stream.of(studentArr);
		IntStream stuScoreStream = stuStream.mapToInt(Stu::getTotalScore);
		// mapToInt를 사용해 IntStream 타입 스트림을 바로 생성. 
		// map 사용하면 Stream<T> 타입의 스트림이 반환됨... Stream<Integer>에서 Integer를 int로 불필요하게 변환할 필요없음
		
		IntSummaryStatistics stat = stuScoreStream.summaryStatistics();     // import java.util.*
		// 기본형 스트림을 다루는 메서드를 사용할때 최종연산(sum, average 등)을하면 매번 스트림을 생성해야하므로 불편함... 이걸 해결하기 위한 summaryStatistics() 제공		
		System.out.println("데이터 전체 요약 : " +stat);
		System.out.println("데이터 갯수 : " +stat.getCount());
		System.out.println("데이터 총합 : " +stat.getSum());
		System.out.printf("데이터 평균 : %.2f %n", stat.getAverage());
		System.out.println("데이터 최소 : " +stat.getMin());
		System.out.println("데이터 최대 : " +stat.getMax());
		System.out.println("====== △ 학생 스트림 계산======");
		
		IntStream charStream = "12345".chars();   	       // chars()에서 String 관련 문자를 IntStream으로 다룰수있게함
		int charSum = charStream.map( ch -> ch-'0').sum(); // 예를들어 49('1'의 아스키코드 정수)- 48('0'의 아스키코드 정수) = 정수 1 
		System.out.println("String인 12345의 각각의 수의 합 : " +charSum);
		System.out.println("====== △  Char 스트림 계산======");
		
		IntStream ballStream = new Random().ints(1,46);
		Stream<String> lottoStream = ballStream.distinct().limit(6).sorted().mapToObj(i -> i +", "); 
		//maptoObj에서 IntStream을 Stream<String> 변환함
		lottoStream.forEach(System.out::print);
		System.out.println(" << 로또 스트림 계산");
		
		
	}
}

class Stu implements Comparable<Stu>{
	String name;
	int grade;
	int totalScore;
	
	Stu(String name, int grade, int totalScore){
		this.name = name;
		this.grade = grade;
		this.totalScore = totalScore;
	}
	
	public int compareTo(Stu s) {
		return s.totalScore - this.totalScore;		// 내림차 정렬 (반대로하면 오름차)
		// 비교할 s - 있던 this = 내림차 (후>>전)
		// 있던 this - 비교할 s = 오름차 (전>>후)
	}
	
	String getName() { return name; }
	int getGrade() { return grade; }
	int getTotalScore() { return totalScore; }
	
	public String toString() {
		return String.format("[ %s %d %d ]", name, grade, totalScore);
	}
}