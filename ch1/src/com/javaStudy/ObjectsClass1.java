package com.javaStudy;
import java.util.*;
import static java.util.Objects.*;

public class ObjectsClass1 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Objects 클래스는 Object의 보조 클래스 (둘다 static)
		// 객체간 비교, NULL 체크에 유용
		
		String [][] str2D_1 = new String [][] {{"가","나"},{"A", "B"}};
		String [][] str2D_2 = new String [][] {{"가","나"},{"A", "B"}};
		System.out.println(Objects.equals(str2D_1,str2D_2));
		System.out.println(Objects.deepEquals(str2D_1,str2D_2));
		//다차원 배열의 정확한 비교에서 재귀적 비교가 필요한데 이때 deepEquals를 씀
		
		System.out.println(Objects.isNull(str2D_1));
		
		Comparator c = String.CASE_INSENSITIVE_ORDER;
		System.out.println(compare("Aa","aa",c));
		//comparator 기준으로 같으면 0
	}

}
