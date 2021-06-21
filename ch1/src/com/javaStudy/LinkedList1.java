package com.javaStudy;
import java.util.*;

public class LinkedList1 {

	public static void main(String[] args) {
		// LinkedList : 배열의 단점 보완. 불연속적 존재하는 데이터를 단방향으로 연결한 형태로 구성
		// 				각 Node들은 [다음 요소의 주소값+자기의 데이터]로 구성
		
		// doubly-linkedList (이중 연결 리스트) : 링크드 리스트의 단방향 이동 단점 보완, 접근/이동 좋아 많이 사용됨
		//									각 Node들은 [이전 요소 주소값 + 다음 요소 주소값 + 자기 데이터]로 구성
		//									! 자바의 LinkedList는 실제로는 이중연결리스트를 사용한다

		// (참고) 이중 원형 연결리스트 : 이중연결 리스트에서 첫번째-마지막 요소를 연결시킴
		
		ArrayList AL = new ArrayList();
		//처음 데이터 저장할때는 AL을 쓰고...
		LinkedList LL = new LinkedList(AL);
		//데이터 작업할때는 LL를 쓴다
		
	}

}
