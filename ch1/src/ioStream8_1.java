import java.io.*;
public class ioStream8_1 {

	public static void main(String[] args) {
		// TODO .dat 파일을 읽어서 데이터의 sum을 구하는 예제
		int sum = 0;
		int score = 0;
		
		try (FileInputStream FinputS = new FileInputStream("D:/Study_Java/ch1/src/scoreData.dat");
			 DataInputStream DinputS = new DataInputStream(FinputS)) {
		// try-with-resources문 : DataInputStream close()할때 try-catch-finally까지 쓰면서 예외처리해야하는데 그걸 간결화 해줌
			while(true) {
				score = DinputS.readInt();
				System.out.println(score);
				sum += score;
			}
		}catch(EOFException eofE) { System.out.println("score sum : "+sum); }
		 catch(IOException ioE)   { ioE.printStackTrace(); } 
	 }
}
