package com.javaStudy;
import java.util.*;
public class Collections1 {

	public static void main(String[] args) {
		// TODO Collections는 컬렉션에 관련된 메서드를 제공하는데 List,Map,Set 기타 등 등 조금씩 적용범위가 다르므로 API나 기술글을 봐야함
		// 아래에있는것들은 적용범위중 하나를 선택해 보여준 예제임
		
		List syncedList = Collections.synchronizedList(new ArrayList());
		// 컬렉션의 동기화 : 멀티 쓰레드 환경에서는 하나의 객체를 여러 쓰레드가 동시에 접근하기에... 데이터의 일관성을 유지하기 위해 공유되는 객체에 동기화가 필요함
		
		Map unmodiMap = Collections.unmodifiableMap(new HashMap());
		// 변경불가 컬렉션 : 컬렉션 내 데이터를 보호하기 위해 읽기전용으로 만들어야할때 씀... 멀티쓰레드에서 데이터 손상 방지 필요할때 씀
		
		Set singleSet = Collections.singleton(new HashSet());
		// 싱글톤 컬렉션 : 하나의 객체만을 저장하는 컬렉션 만들어야할때... (! singletonList, singletonMap인데 set만 뒤에set안씀)
		
		List list = new ArrayList();
		List checkedList = Collections.checkedList(list, String.class);
		// 단일 객체 컬렉션 : 컬렉션에 지정된 종류의 객체만 저장해야할때... 위 예는 String만 저장가능하다
	}

}
