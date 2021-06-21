package com.javaStudy;
import java.util.*;

public class HashMap4 {

	public static void main(String[] args) {
		// TODO 문자열 데이터에서 HashMap을 이용해 빈도수를 구하고... 그래프를 그리는 예제 
		String [] data = {"A","T","K","S","A","T","S","S","A","S","S"};
		
		HashMap map = new HashMap();
		
		for(int i=0;i<data.length;i++) {
			if(map.containsKey(data[i])) {
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i], new Integer(value.intValue() + 1));
			}else {
				map.put(data[i], new Integer(1));
			}
			// 처음엔 바로 else로 넘어가서 put(A, 1)... 이후 또 A가 나오면
			// if 만족하고... get(data[i])에서 value도 얻은 후... 
			// map에 put(A, value+1)에서 value는 2가 됨... 이렇게하면 빈도를 세듯이 구현가능
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


//! RandomClass2에 비슷한 구현 예제있음