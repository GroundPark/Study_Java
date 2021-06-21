package com.javaStudy;
import java.lang.annotation.*;

@TestAnno(testedBy="Lee", CoWrittenBy= {"Kim","Jun"})
public class Annotation3 {
	public static void main(String[] args) {
		// TODO 사용자 정의 Annotation
		Class<Annotation3> cls = Annotation3.class;
		// 클래스로더에 의해 메모리에 올라갈때 '클래스에 대한 정보가 있는 객체'를 생성함, 이는 .class로 호출하며... 클래스 객체에 에너테이션 정보도 있음
		
		TestAnno anno = (TestAnno)cls.getAnnotation(TestAnno.class);
		System.out.println("anno.testedBy() = " +anno.testedBy());
		
		Annotation [] annoArr = cls.getAnnotations(); 
		// 클래스 객체의 메서드를 이용한다... 배열로 받고싶으면 뒤에 s
		
		for(Annotation a : annoArr)
			System.out.println(a);
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface TestAnno{
	int    count() default 0;
	String WrittenBy="Park";
	String testedBy();
	String [] CoWrittenBy();
	String [] uesdTool() default "IDE";
	//요소의 이름이 value면 생략 가능하다. 예를들면 SuppressWarning
	//매개변수 선언x, 예외(throw)x, 요소타입에 타입 매개변수 사용x
}


