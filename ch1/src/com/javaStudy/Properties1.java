package com.javaStudy;
import java.util.*;
public class Properties1 {

	public static void main(String[] args) {
		// TODO Properties : HashTable 상속받아 구현함(Map), (String, String)의 형태로 저장하는 단순화 컬렉션 클래스
		// 환경설정(옵션) 관련 속성에 자주 씀, Map 특성상 저장순서 유지 안함
		Properties p = new Properties();
		
		p.setProperty("timeout","30");
		p.setProperty("capacity","64");
		p.setProperty("language","EUC-KR");
		p.setProperty("size","65536");
		
		Enumeration e = p.propertyNames();
		//Properties는 컬렉션 이전의 구버전이라 Enumeration 사용
		
		while(e.hasMoreElements()) {
			String element = (String)e.nextElement();
			System.out.println(element + " = " +p.getProperty(element));
		}		
		System.out.println("-----------------------------------------");
		System.out.println(p);
		System.out.println(p.getProperty("range","can't find range key"));
		//없는 p를 get할때 둘째 파라미터로 기본값 설정가능
		System.out.println("-----------------------------------------");
		p.list(System.out);
	}

}
