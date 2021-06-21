package com.javaStudy;
import java.util.*;

public class HashMap3 {

	public static void main(String[] args) {
		// TODO HashMap의 특성을 이용해 어떤 분류를 기준으로 그룹을 만들고... 그룹안에 이름과 전번을 저장한다
		addInfo("친구", "김성철", "010-1412-5532");
		addInfo("친구", "김나얼", "010-2212-5142");
		addInfo("친구", "서성환", "010-1152-6156");
		addInfo("회사", "김성철", "010-2741-2442");
		addInfo("회사", "박성길", "010-9112-1138");
		addInfo("세탁", "010-3112-9998");
		
		printList();
	}
	
	static HashMap phoneBook = new HashMap();
	
	static void addInfo(String groupName, String name, String phone){
		addGroup(groupName);
		HashMap group = (HashMap)phoneBook.get(groupName);
		group.put(phone, name); //유일한 전화번호가 key
		// 그룹에 정보 추가
	}
	
	static void addInfo(String name, String phone) {
		addInfo("기타", name, phone);
		//(보여주기용)오버로딩하여 유연한 저장가능
	}
	
	static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName))
			phoneBook.put(groupName, new HashMap());
		// 그룹 추가, key/value 둘다 Object 타입으로 저장되기에...  HashMap의 value에 또한번 HashMap이 가능함
	}
	
	static void printList() {
		Set set = phoneBook.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			Set subSet = ((HashMap)e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			
			System.out.println(e.getKey() +"  [" +subSet.size()+"개의 자료]");
			// 그룹 분류 / 컬렉션을 이용해 처리하여 개수 반환
			
			while(subIt.hasNext()) {
				Map.Entry subE = (Map.Entry)subIt.next();
				String phone = (String)subE.getKey();
				String name = (String)subE.getValue();
				System.out.println(name +"  " +phone);
			}
			// 각각 분류에서 phone(key), name(value)를 얻음
			System.out.println();
		}
	}
}
