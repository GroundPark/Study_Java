import java.io.*;
public class ioStream6_1 {

	public static void main(String[] args) {
		// TODO 만들어진 .dat를 읽어서 화면에 출력하는 예제
		try {
			FileInputStream FinputS = new FileInputStream("D:/Study_Java/ch1/src/testData.dat");
			DataInputStream DinputS = new DataInputStream(FinputS);
			
			System.out.println(DinputS.readInt());
			System.out.println(DinputS.readFloat());
			System.out.println(DinputS.readBoolean());
			
			DinputS.close();
			
		}catch(IOException e) { e.printStackTrace(); }
	}

}
