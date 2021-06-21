package com.javaStudy;
import java.util.*;
import java.util.function.*;
// util.*에서 function이 하위 패키지에 있을거같은데 따로 놔야함

public class Lambda3 {

	public static void main(String[] args) {
		// TODO java.util.function 패키지 : 일반적으로 자주쓰이는 형식의 메서드를 함수형 인터페이스로 정의해놓음
		// 매개변수 2개는 BiConsumer 처럼 앞에 Bi만 붙이면 됨... 3개 이상은 만들어서 써야함
		Supplier<Integer> s = () -> (int)(Math.random() * 100) + 1;  // 1~100까지 랜덤수  
		Consumer<Integer> c = i -> System.out.print(i+" , ");		 // 공백과 쉼표 
		Predicate<Integer> p = i -> i%2 == 0;						 // 짝수인지 아닌지
		Function<Integer, Integer> f = i -> i/10*10;  				 // 일의 자리 없앰
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list);
		System.out.println("랜덤값 list : " +list);
		
		System.out.print("list에서 짝수 값 출력 : ");
		printEvenNum(p,c,list);
		System.out.println();
		
		List<Integer> newList = onesFloor(f,list);
		System.out.println("list의 각각의 값에서 일의 자리를 0으로 만듬 : "+newList);
	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for(int i=0;i<10;i++) {
			list.add(s.get());
		}
	} // Supplier<T>의 get() 사용 (반환값만 있음)
	
	static <T> void printEvenNum(Predicate <T> p, Consumer<T> c, List<T> list) {
		for(T i : list) {
			if(p.test(i))
				c.accept(i);
		}
	} // Predicate<T>의 test() 사용 (조건식 함수, 매개변수에서 bool 반환)
	  // Consumer<T>의 accept() 사용 (매개변수만 있음)
	
	static <T> List<T> onesFloor(Function <T, T> f, List<T> list){
		List<T> newList = new ArrayList<T>(list.size());
		
		for(T i : list) {
			newList.add(f.apply(i));
		} return newList;
	} // Function<T,R>의 apply() 사용 (매개변수-반환값)
}

