package com.javaStudy;
import java.util.*;

public class TreeSet1 {

	public static void main(String[] args) {
		// TODO TreeSet : 이진 검색 트리 자료구조형태로 데이터를 저장하는 컬렉션 클래스
		// 검색~범위검색, 정렬에 좋음 / 노드의 추가 및 삭제에 오래걸림
		Set mySet = new TreeSet();
		
		for(int i=0;mySet.size()<6;i++) {
			int num = (int)(Math.random() * 45 ) + 1;
			mySet.add(num);
		}
		System.out.println(mySet);
	}

}
