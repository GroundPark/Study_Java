package com.javaStudy;
import java.util.*;

public class Iterator1{
	static public void main(String [] args) {
		// TODO 컬렉션에 저장된 요소를 접근하는데 사용되는 인터페이스들... Enumeration > Iterator > ListIterator 순서로 좋아짐
		// List,Set 인터페이스들은 잘맞춰 있음
		
		// Map 인터페이스는 키/값으로 구성돼있어서... keySet() 이나 entrySet() 을 이용해 Set형태로 가져와야함 
		// Iterator it = map.entrySet().iterator();와 같이 호출해야 사용가능
		ArrayList myAL = new ArrayList();
		
		myAL.add("1");
		myAL.add("2");
		myAL.add("3");
		myAL.add("4");
		myAL.add("5");
		
		Iterator myIt = myAL.iterator();
		
		while(myIt.hasNext()) {
			Object obj = myIt.next();
			//next() : 읽어옴 (hasNext 선행필요)
			System.out.println(obj);	
		}		
	}
}