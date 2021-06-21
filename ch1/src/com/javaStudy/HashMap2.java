package com.javaStudy;
import java.util.*;

public class HashMap2 {

	public static void main(String[] args) {
		// TODO HashMap 이용한 데이터 저장/읽기 예제
		HashMap HM = new HashMap();
		HM.put("안철수", new Integer(100));
		HM.put("박형식", new Integer(50));
		HM.put("김정수", new Integer(30));
		
		Set mySet = HM.entrySet();
		// entrySet 메서드 이용해서 key/value(엔트리 형태)를 set의 형태로 반환
		Iterator it = mySet.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println("이름 : " +e.getKey() +"  점수 : " +e.getValue());
		}
		
		mySet = HM.keySet();
		System.out.println("참가자 명단 : " +mySet);
		// key 처리
		
		Collection val = HM.values();
		it = val.iterator();
		// value 처리
		
		int total = 0;
		
		while(it.hasNext()) {
			Integer i = (Integer)it.next();
			total += i.intValue();
		}
		System.out.println("총점 : " +total);
		System.out.println("평균 : " +(float)total/mySet.size());
		System.out.println("최고점수 : " +Collections.max(val));
		System.out.println("최소점수 : " +Collections.min(val));
	}

}
