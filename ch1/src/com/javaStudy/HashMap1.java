package com.javaStudy;
import java.util.*;

public class HashMap1 {
	public static void main(String[] args) {
		// TODO Hashtable -> HashMap : Map의 특징(key/value 묶어서 entry로 저장, 해싱을 사용하므로 데이터 검색에 좋음)을 가지고 있다
		HashMap HM = new HashMap();
		HM.put("admin", "admin");
		HM.put("user", "1234");
		HM.put("user", "qkrwltkd");
		//중복된 key는 덮어쓰기로 처리됨
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("id/pw 입력");
			
			System.out.print("id : ");
			String id = s.nextLine().trim();
			
			System.out.print("pw : ");
			String pw = s.nextLine().trim();
			
			System.out.println();
			
			if(!HM.containsKey(id)) {
				System.out.println("id not found. try again");
				continue;
			}else {
				if(!(HM.get(id)).equals(pw)) {	//get()으로 해당 key의 value를 얻음 
					System.out.println("pw not matched. try again");
				}else {
					System.out.println("login successful");
					break;
				}
			}
		}
	}
}