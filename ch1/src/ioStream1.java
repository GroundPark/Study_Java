import java.io.*;
import java.util.*;

public class ioStream1 {

	public static void main(String[] args) {
		// 스트림        : 데이터를 운반하는데 사용되는 연결통로, 단방향 통신만 가능, 입력 스트림-출력 스트림 (I/O) 사용
		// 보조 스트림 : 스트림 기능 향상/추가 함. 기반이되는 스트림 생성하고 보조스트림을 생성함
		// (바이트기반 스트림) ByteArray(I/O)Stream 사용해 바이트 배열을 빈 배열로 1byte씩 복사하는 예제
		byte [] inputS  = {0,1,2,3,4,5,6,7,8,9};
		byte [] outputS = null;
		
		ByteArrayInputStream  input  = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inputS);
		output = new ByteArrayOutputStream();
		
		int data=0;
		
		while( (data = input.read()) != -1 ) {
			output.write(data);
		}
		// read/write()에서 하나(1byte)씩 읽고 씀. (1byte는 0~255의 정수값, 더이상 읽을값이 없음을 알리는 -1로 이루어짐)
		// write(byte배열)에서 배열의 모든 내용을 읽어 소스로 씀 
		
		outputS = output.toByteArray();
		// 스트림의 내용을 byte배열로 반환
		
		System.out.println(" input  데이터 : " +Arrays.toString(inputS));
		System.out.println(" output 데이터 : " +Arrays.toString(outputS));
		// 메모리 사용 스트림, System.in(out) 같은 표준 입출력 스트림은 gc에서 관리하므로 close() 사용해 스트림 닫지 않아도 됨
	}
}
