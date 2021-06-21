import java.io.*;
import java.util.*;

public class ioStream2_1 {

	public static void main(String[] args) {
		// TODO 소스 배열보다 작은 임시 배열을 사용해 read/write를 반복해야할때 
		byte [] inputS = {1,2,3,4,5,6,7,8,9,10};
		byte [] outputS = null;
		byte [] tmp = new byte[4];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inputS);
		output = new ByteArrayOutputStream();
		
		try {
			while(input.available() > 0) {		// available()에서 블락킹(데이터 읽을때 데이터를 기다리기 위해 멈춤)없이 읽어올수있는 바이트의 수를 반환
				int len = input.read(tmp);		// 그냥 read(tmp) 쓰면 배열을 재사용하기때문에... 이전 tmp의 값이 남아있는데 내용전체 출력해서 이상해짐
				output.write(tmp, 0, len);		// tmp에서 읽은 만큼만 write해야함
			}
		}catch(IOException e) {}
		
		outputS = output.toByteArray();
		
		System.out.println("intputS : " +Arrays.toString(inputS));
		System.out.println("tmp : " +Arrays.toString(tmp));
		System.out.println("outputS : " +Arrays.toString(outputS));
	}

}
