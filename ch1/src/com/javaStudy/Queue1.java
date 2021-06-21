package com.javaStudy;
import java.util.*;

public class Queue1 {
	//TODO : 유닉스 history 명령어를 Queue를 이용해 구현
	
	static Queue Que = new LinkedList();
	static final int MAX_SIZE = 5;     // 원하는 만큼의 최대 저장수
	
	public static void main(String[] args) {
		System.out.println("명령어(대문자 가능) : h(history), q(quit),");
		
		while(true) {
			System.out.println(">>");
			
			try {
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();
				
						if("".equals(input)) continue;
				
				
				
				if(input.equalsIgnoreCase("Q")) {
					System.exit(0);
					}
				//Q누르면 종료
				
				else if(input.equalsIgnoreCase("H")) {
					save(input);
				//H누르면 input을 save메서드로 저장	
					LinkedList LLtmp = (LinkedList) Que;
					ListIterator LIt = LLtmp.listIterator();
				//양방향으로 큐를 읽어오기 위해 ListIterator 사용
					int i=0;
					
					while(LIt.hasNext())
						System.out.println(++i +"번째 명령어" +LIt.next());
				}else {
					save(input);
					System.out.println(input);
				}
				
				}catch(Exception e) {
				System.out.println("입력 오류");
			}
		}
	}
	
	public static void save(String input) {
		if(!"".equals(input))
			Que.offer(input);
			// (비어있는거 제외하고) input을 큐에 저장
		if(Que.size() > MAX_SIZE)
			Que.remove();
			// 큐가 MAX_SIZE이상 꽉차면 맨 처음 입력된거 제거 
	}

}
