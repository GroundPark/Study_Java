package com.javaStudy;
import java.util.*;
import java.util.stream.*;
public class Stream4 {

	public static void main(String[] args) {
		// TODO 학생의 성적 정보를 요소로하는 Stream 생성하고... 반별로 정렬한다음... 총점별 내림차순 정렬하는 예제
		Stream<Student> studentStream = Stream.of(
												  new Student("Kim", 3, 300),
												  new Student("Jun", 1, 200),
												  new Student("Hoe", 2, 100),
												  new Student("Yun", 2, 150),
												  new Student("Tae", 1, 200),
												  new Student("Hue", 3, 290),
												  new Student("Zin", 3, 180)
												  );
		
		studentStream.sorted(Comparator.comparing(Student::getGrade)     // comparing()의 (기본값)정렬을 사용한 반별 오름차 정렬
						  //.thenComparing(Student::getName)             // thenComparing()을 사용한 정렬 조건 추가
							.thenComparing(Comparator.naturalOrder()))	 // Comparator 기본 정렬. 예제에선 Comparable에 내림차 정렬을 기본정렬로 해놨음
							.forEach(System.out::println);
		
	}
}

class Student implements Comparable<Student>{
	String name;
	int grade;
	int totalScore;
	
	Student(String name, int grade, int totalScore){
		this.name = name;
		this.grade = grade;
		this.totalScore = totalScore;
	}
	
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;		// 내림차 정렬 (반대로하면 오름차)
		// 비교할 s - 있던 this = 내림차 (후>>전)
		// 있던 this - 비교할 s = 오름차 (전>>후)
	}
	
	//String getName() { return name; }
	int getGrade() { return grade; }
	//int getTotalScore() { return totalScore; }
	
	public String toString() {
		return String.format("[ %s %d %d ]", name, grade, totalScore);
	}
}