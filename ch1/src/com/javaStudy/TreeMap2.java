package com.javaStudy;
import java.util.*;

public class TreeMap2 {

	public static void main(String[] args) {
		// TODO TreeMap을 이용해 데이터의 단어의 빈도수가 큰 순서로 정렬함(내림차)
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
		
		Set set = map.entrySet();
		List list = new ArrayList(set);
		Collections.sort(list, new valComparator());
		// 내림차를 구현한 클래스를 이용해 sort 함
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + "의 개수는 " +value +"개  : " +printBar('#', value));
		}
	}
	
	static class valComparator implements Comparator{
		public int compare(Object o1, Object o2) {
			if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
				Map.Entry e1 = (Map.Entry)o1;
				Map.Entry e2 = (Map.Entry)o2;
				
				int val1 = ((Integer)e1.getValue()).intValue();
				int val2 = ((Integer)e2.getValue()).intValue();
				
				return val2 - val1;
				// val1 - val2 = 오름차  : val2 - val1 = 내림차
			}
			return -1;
		}
	}
	//Comparator를 구현할때 내림차를 사용하도록한 클래스
	
	public static String printBar(char ch, int value) {
		char [] bar = new char[value];
		
		for(int i=0;i<bar.length;i++)
			bar[i] = ch;
		
		return new String(bar);
	}
}
