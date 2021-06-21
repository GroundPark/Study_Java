package com.javaStudy;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.*;

public class annotation2 {
	public static void main(String[] args) {
		// TODO 메타 애너테이션 : 애너테이션을 위한 애너테이션, 애너테이션의 속성비슷하게 씀
	}
}

@Target({TYPE, FIELD, TYPE_USE})
@interface MyAnno1 {}
// 애너테이션의 적용가능 대상 지정, 예제 외에도 많음
// import static java.lang.annotation.ElementType.* 불러와야 적절히 사용가능

@MyAnno1 //TYPE, 클래스-인터페이스 등..
class Myclass{
	@MyAnno1  //FIELD, 기본형
	int i;
	
	@MyAnno1
	Myclass mc;  //TYPE_USE, 참조형
}
//////////////////////////////////////////////

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno2 {}
// 에너테이션의 유지되는 기간 지정
// SOURCE(잘안씀), CLASS(기본값, 실행중 사용불가라 덜씀), RUNTIME(실행중 리플렉션을 통해 정보를 읽을수 있어서 잘씀) 이 있음

@Documented
@interface MyAnno3 {}
// 에너테이션에 대한 정보가 javadoc으로 작성한 문서에 포함하게 함. Override, sup-warn빼고 다씀

//////////////////////////////////////////////
@Inherited
@interface SuperAnno {}
// 애너테이션이 자손 클래스에 상속되게 함

@SuperAnno
class PAPA {}

class Son extends PAPA {}
// 상속받은 Son 클래스는 SuperAnno 애너테이션이 적용됨

//////////////////////////////////////////////
@interface ToDos{
	ToDo [] value();
}
// 다수의 ToDo를 담기위한 컨테이너 애너테이션. (이름은 필수적으로 value여야함) 

@Repeatable(ToDos.class) // ( ) 안에 컨테이너 애너테이션 지정
@interface ToDo{
	String value();
}

@ToDo("more than")
@ToDo("1 ToDo Anno")
class ASDFGH{}
// 보통 애너테이션은 한 종류당 하나지만, Repeatable을 이용해 반복적으로 붙일수 있음

//////////////////////////////////////////////

class MyNative{
@Native public static final int deprecated_MyVal = 0;
}
// 네이티브 메서드에 의해 참조되는 '상수 필드'에 붙인다

