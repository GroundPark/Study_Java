package com.javaStudy;
import java.util.*;

public class TreeMap1 {

	public static void main(String[] args) {
		// TreeMap : 이진검색트리 형태로 키/값 쌍의 형태로 데이터 저장 (검색, 정렬에 좋음)
		// 검색은 HashMap이 더 낫지만, 범위검색, 정렬이 필요한 경우 TreeMap 채택함
		
		// TODO HashMap4를 TreeMap을 이용해 구현함
		// HashMap을 이용한 예제에서 단순히 TreeMap만 바꿔서 구현했을때 key가 오름차 순임... String 인스턴스에 구현되어있는 정렬기준을 따른것
		
		String [] data = {"A","T","K","S","A","T","S","S","A","S","S"};
		
		TreeMap map = new TreeMap();
		
		for(int i=0;i<data.length;i++) {
			if(map.containsKey(data[i])) {
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i], new Integer(value.intValue() + 1));
			}else {
				map.put(data[i], new Integer(1));
			}
		}
		
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + "의 개수는 " +value +"개  : " +printBar('#', value));
		}
	}
	
	public static String printBar(char ch, int value) {
		char [] bar = new char[value];
		
		for(int i=0;i<bar.length;i++)
			bar[i] = ch;
		
		return new String(bar);
	}
}
