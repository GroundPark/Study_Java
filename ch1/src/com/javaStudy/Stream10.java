package com.javaStudy;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Students {
	String name;
	boolean isMale; // 성별
	int hak;		    // 학년
	int ban;		    // 반
	int score;

	Students(String name, boolean isMale, int hak, int ban, int score) { 
		this.name	= name;
		this.isMale	= isMale;
		this.hak	= hak;
		this.ban	= ban;
		this.score  = score;
	}
	String	getName()  { return name;}
	boolean isMale()   { return isMale;}
	int		getHak()   { return hak;}
	int		getBan()   { return ban;}
	int		getScore() { return score;}

	public String toString() { 
		return String.format("[%s, %s, %d학년 %d반, %3d점]",
			name, isMale ? "남":"여", hak, ban, score); 
	}
   // groupingBy()에서 사용
	enum Level { HIGH, MID, LOW }  // 성적을 상, 중, 하 세 단계로 분류
}

public class Stream10 {
	public static void main(String[] args) {
		// 분할화 : partitioningBy(Predicate) 사용해서 지정된 조건에 일치하는 그룹/일치하지않는 그룹으로 분할화 (map 반환)
		Students[] stuArr = {
			new Students("나자바", true,  1, 1, 300),	
			new Students("김지미", false, 1, 1, 250),	
			new Students("김자바", true,  1, 1, 200),	
			new Students("이지미", false, 1, 2, 150),	
			new Students("남자바", true,  1, 2, 100),	
			new Students("안지미", false, 1, 2,  50),	
			new Students("황지미", false, 1, 3, 100),	
			new Students("강지미", false, 1, 3, 150),	
			new Students("이자바", true,  1, 3, 200),	

			new Students("나자바", true,  2, 1, 300),	
			new Students("김지미", false, 2, 1, 250),	
			new Students("김자바", true,  2, 1, 200),	
			new Students("이지미", false, 2, 2, 150),	
			new Students("남자바", true,  2, 2, 100),	
			new Students("안지미", false, 2, 2,  50),	
			new Students("황지미", false, 2, 3, 100),	
			new Students("강지미", false, 2, 3, 150),	
			new Students("이자바", true,  2, 3, 200)	
		};

		System.out.printf("1. 단순분할(성별로 분할)%n");
		Map<Boolean, List<Students>> stuBySex =  Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Students::isMale));

		List<Students> maleStudents   = stuBySex.get(true);
		List<Students> femaleStudents = stuBySex.get(false);

		for(Students s : maleStudents)   System.out.println(s);
		for(Students s : femaleStudents) System.out.println(s);

		System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
		Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Students::isMale, Collectors.counting()));

		System.out.println("남학생 수 :"+ stuNumBySex.get(true));
		System.out.println("여학생 수 :"+ stuNumBySex.get(false));


		System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
		Map<Boolean, Optional<Students>> topScoreBySex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Students::isMale, 
						Collectors.maxBy(Comparator.comparingInt(Students::getScore))
				));
		// maxBy에서 반환타입이 Optional<Students>
		
		System.out.println("남학생 1등 :"+ topScoreBySex.get(true));
		System.out.println("여학생 1등 :"+ topScoreBySex.get(false));

		Map<Boolean, Students> topScoreBySex2 = Stream.of(stuArr)
			.collect(Collectors.partitioningBy(Students::isMale, 
					Collectors.collectingAndThen(
					Collectors.maxBy(Comparator.comparingInt(Students::getScore)), Optional::get)));
		// maxBy에서 나오는 Optional이 아닌 Students만 원한다면... CollectAndThen 추가하고... maxBy 파라미터2에 Optional::get 함께 사용해야함
		
		System.out.println("남학생 1등 :"+ topScoreBySex2.get(true));
		System.out.println("여학생 1등 :"+ topScoreBySex2.get(false));

		System.out.printf("%n4. 다중분할(성별 불합격자, 100점 이하)%n");
		Map<Boolean, Map<Boolean, List<Students>>> failedStuBySex = 
			Stream.of(stuArr).collect(Collectors.partitioningBy(Students::isMale, 
									 Collectors.partitioningBy(s -> s.getScore() <= 100))); 
		// partitioningBy를 두번(성별 조건, 점수 조건)써서 이중 분할을 구현함
 		List<Students> failedMaleStu   = failedStuBySex.get(true).get(true);
		List<Students> failedFemaleStu = failedStuBySex.get(false).get(true);

		for(Students s : failedMaleStu)   System.out.println(s);
		for(Students s : failedFemaleStu) System.out.println(s);
	}
}
