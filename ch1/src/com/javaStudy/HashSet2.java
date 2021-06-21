package com.javaStudy;
import java.util.*;

public class HashSet2 {

	public static void main(String[] args) {
		// TODO 1~50사이 숫자 중 25개 골라서 5x5 크기의 빙고판을 만드는 예제
		Set mySet = new LinkedHashSet();
		
		int [][] board = new int [5][5];
		
		for(int i=0;mySet.size()<25;i++)
			mySet.add((int)(Math.random() * 50) + 1+"");
		
		Iterator it = mySet.iterator();
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j] = Integer.parseInt((String)it.next());
				//next() 반환 값은 Object형이라 String으로 캐스팅... 그리고 String에서 Integer로 정수화
				System.out.print((board[i][j] < 10 ? "  " : " ") +board[i][j]);
				//삼항연산자로 10보다 작은 일의 자리에서의 공백을 2번, 그냥은 한번넣는다 = 보기좋게 줄맞춤 처리 
			}
			System.out.println();
		}
			
	}

}
