import java.io.*;
import java.util.*;

public class ioStream2 {

	public static void main(String[] args) {
		// 바이트 배열을 빈 배열로 byte배열을 사용해 한번에 배열의 크기만큼 복사하는 예제... 임시 배열을 사용함
		byte [] inputS  = {0,1,2,3,4,5,6,7,8,9};
		byte [] outputS = null;
		byte [] temp = new byte[10];
		
		ByteArrayInputStream  input  = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inputS);
		output = new ByteArrayOutputStream();
		
		input.read(temp, 0, temp.length);
		output.write(temp, 2, 6);
		// read/write(임시 byte배열, 오프셋, 길이)를 사용해서 입출력함
		
		outputS = output.toByteArray();
		
		System.out.println(" input  데이터 : " +Arrays.toString(inputS));
		System.out.println(" temp   데이터 : " +Arrays.toString(temp));
		System.out.println(" output 데이터 : " +Arrays.toString(outputS));
	}
}
