import java.io.*;
import java.util.*;
public class ioStream9 {

	public static void main(String[] args) {
		// TODO SequenceInputStream(Enumneration) : 여러 입력스트림을 연속적으로 연결해 하나의 스트림화하여 연산-처리함
		// 열거형에 vector쓰고, 2개인경우 (a, b)로 간단히 쓸수 있음
		
		byte [] arr1 = {0,1,2};
		byte [] arr2 = {3,4,5};
		byte [] arr3 = {6,7,8};
		byte [] OutSrc = null;
		
		Vector v = new Vector();
		v.add(new ByteArrayInputStream(arr1));
		v.add(new ByteArrayInputStream(arr2));
		v.add(new ByteArrayInputStream(arr3));
		
		SequenceInputStream input = new SequenceInputStream(v.elements());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		int data = 0;
		
		try {
			while( (data = input.read()) != -1) {
				output.write(data);
			}
		}catch(IOException e) {}
		
		OutSrc = output.toByteArray();
		
		System.out.println("input 1 : " +Arrays.toString(arr1));
		System.out.println("input 2 : " +Arrays.toString(arr2));
		System.out.println("input 3 : " +Arrays.toString(arr3));
		System.out.println("output  : " +Arrays.toString(OutSrc));	
		
		// TODO PrintStream : 데이터를 기반 스트림에 다양한 형태로 출력할수있는 메서드(print, println, printf)를 오버로딩하여 제공함. (추가된 printWriter가 더 좋음)
	}
}

class SequenceInputStreamEX1 {
	void SinputSTest1() throws FileNotFoundException {
		FileInputStream File1 = new FileInputStream("t1.dat");
		FileInputStream File2 = new FileInputStream("t2.dat");
		
		SequenceInputStream SinputS = new SequenceInputStream(File1,File2);
	}
}

class SequenceInputStreamEX2 {
	void SinputSTest2() throws IOException {
		Vector Files = new Vector();
		Files.add(new FileInputStream("a1.dat"));
		Files.add(new FileInputStream("a2.dat"));
		Files.add(new FileInputStream("a3.dat"));
		
		SequenceInputStream SinputS = new SequenceInputStream(Files.elements());
	}
}