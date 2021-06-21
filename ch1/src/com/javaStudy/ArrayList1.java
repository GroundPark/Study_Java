package com.javaStudy;
import java.util.*;

class ArrayList1 {
	// TODO : ArrayList 기본 메서드 이용 연습
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		ArrayList myAL1 = new ArrayList(10);
		myAL1.add(new Integer(5));
		myAL1.add(new Integer(4));
		myAL1.add(new Integer(2));
		myAL1.add(new Integer(0));
		myAL1.add(new Integer(1));
		myAL1.add(new Integer(3));
		
		ArrayList myAL2 = new ArrayList(myAL1.subList(1,4));
		//subList(idx1,idx2) : idx1에서 idx2까지 저장된 객체 반환
		print(myAL1, myAL2);
		
		Collections.sort(myAL1);
		Collections.sort(myAL2);
		//Collections.sort(..) 이용해 오름차 정렬함
		print(myAL1, myAL2);
		
		System.out.println("myAL1.containsAll(myAL2):"+myAL1.containsAll(myAL2));
		System.out.println();
		//myAL1이 myAL2의 모든 요소를 포함하는가? 
		
		myAL2.add("B");
		myAL2.add("C");		
		myAL2.add(3, "A");
		// 024BC 의 idx 3에 A를 add하므로 원래 있던 B,C는 한칸씩 뒤로 밀림
		myAL2.set(4,"BB");
		// 024ABC 의 idx 4에 있는값을 set(수정)함
		print(myAL1,myAL2);
		
		System.out.println("myAL1.retainALL(myAL2):"+myAL1.retainAll(myAL2));
		//myAL1에서 myAL2와의 공통요소 이외에 모두 삭제. 변화가 있었는지 bool로 반환 
		// !retain = 간직하다
		print(myAL1,myAL2);
		
		for(int i=myAL2.size()-1; i>=0;i--) {
			if(myAL1.contains(myAL2.get(i))) {
				myAL2.remove(i);
			}
		}
		//myAL2에서 myAL1와의 공통요소 모두 삭제. i는 idx로 거꾸로 반복 함
		//i가 증가하면서 삭제되면 한 요소 삭제될때마다 빈 공간 채우기 위해 나머지 요소들이 자리이동하니까 안됨
		print(myAL1,myAL2);
	}
	
	static void print(ArrayList myAL1, ArrayList myAL2) {
		System.out.println("list1:"+myAL1);
		System.out.println("list2:"+myAL2);
		System.out.println();
	}
	
}