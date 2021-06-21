import java.io.*;
public class ioStream8 {

	public static void main(String[] args) {
		// TODO int []의 값을 scoreData에 출력하는 예제
		int [] score = { 100, 50, 80, 35, 60 };
		// int는 4byte고 16진수 2자리는 1byte니까 모두 20byte의 데이터가 저장됨 
		// 각각의 수는 [00 00 00 64] [00 00 00 32] [00 00 00 50] [00 00 00 23] [00 00 00 3c]
		try {
			FileOutputStream FoutputS = new FileOutputStream("D:/Study_Java/ch1/src/scoreData.dat");
			DataOutputStream DoutputS = new DataOutputStream(FoutputS);
			
			for(int i=0;i<score.length;i++)
				DoutputS.writeInt(score[i]);
			
			DoutputS.close();
		}catch(IOException e) { e.printStackTrace(); }
	}

}
