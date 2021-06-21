package com.javaStudy;
import java.util.*;

@SuppressWarnings({"rawtypes", "varargs"})
public class annotation1 {

	@SuppressWarnings("unchecked")
	// 컴파일러가 보여주는 경고 메세지를 안보여주게함(알지만 무시하겠다는것)
	// 억제범위는 최소화해야 바람직함
	public static void main(String[] args) {
		// TODO 애너테이션(annotation) : 코드화된 주석. 
		// -Xlint 옵션으로 컴파일해서 나오는 내용중 [..] 안에 있는게 경고타입임
		
		ArrayList myAL1 = new ArrayList(10);
		myAL1.add(new Integer(5));
		// 위 두줄은 경고가 Suppress 돼있는 상태임
	}

}

class Parent5{
	void ParentMethod() {}
}

class Child5 extends Parent5{
	@Override
	void ParentMethod() {}
	// 오버라이딩할때 [새로운 메서드]인지 [잘못된 메서드]인지 알수없음 (찾기 힘든 실수를 방지함)

	@Deprecated
	void OldMethod() {}
	// 기능 개선중 필요없는 메서드는 삭제/변경되기 마련인데 함부로 하긴 위험하므로... 강제성은 없지만 사용금지 권장
}

@FunctionalInterface
interface Runnable{
	abstract void run();
	//함수형 인터페이스를 선언할때 실수 방지를 위해 자주 사용됨.
}

class MyArrayList<T>{
	T [] arr;
	
	@SafeVarargs
	@SuppressWarnings("varargs")
	//SafeVarargs 로 unchecked 경고를 억제하지만... -Xlint 컴파일시 varargs 경고가 나므로... 보통 둘이 같이 쓰는 편
	MyArrayList(T ... arr){
		this.arr = arr;
	}
	
	public static <T> MyArrayList<T> asList(T ... a){
		return new MyArrayList<>(a);
	}
}
