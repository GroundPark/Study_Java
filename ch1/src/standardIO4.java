import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class standardIO4 {

	public static void main(String[] args) {
		// TODO .dat 읽고... readInt()로 국어점수만 읽어서 출력하는 예제
		int han_sum = 0;

		try {
			RandomAccessFile raf = new RandomAccessFile("D:/Study_Java/ch1/src/rafscore.dat","r");
			
			int i = 4;
			while(true) {
				raf.seek(i);
				han_sum += raf.readInt();
				i += 16;
				// [숫자,국,영,수]에서 각 자리마다 4byte이므로 포인터 4에서 국어1, 포인트 4+16에서 국어2... 반복 seek 함
			}
		}catch(EOFException eof) {
			System.out.println(" 국어 점수 총합 : "+han_sum);
		}
		 catch(IOException e) {e.printStackTrace();}

	}

}
