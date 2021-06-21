package com.javaStudy;
import java.util.*;

public class ArrayQ14 {

	public static void main(String[] args) {
		// TODO 영단어를 보여주고 단어의 뜻을 맞추는 예제
			String[][] words = {
				{"chair","의자"},			// words[0][0], words[0][1]
				{"computer","컴퓨터"},	// words[1][0], words[1][1]
				{"meme","밈"}		    // words[2][0], words[2][1]
			};

			Scanner scanner = new Scanner(System.in);

			for(int i=0;i<words.length;i++) {
				System.out.printf("%d번 문제, %s의 뜻은?", i+1, words[i][0]);

				String tmp = scanner.nextLine();

				if(tmp.equals(words[i][1])) {
					System.out.printf("정답. %n%n");
				} else {
				   System.out.printf("오답. 정답은 %s입니다 %n%n",words[i][1]);
				}
			} 
	}
}
