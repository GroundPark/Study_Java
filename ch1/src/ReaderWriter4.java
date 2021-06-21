import java.io.*;
public class ReaderWriter4 {

	public static void main(String[] args) {
		// TODO StringReader/Writer : 입출력 대상이 메모리인 스트림
		// StringWriter에 출력되는 데이터는 내부의 StringBuffer에 저장되며  getBuffer()나 toString을 이용해 저장된 데이터를 얻음
		
		String inputData = "AAAAAA";
		StringReader input = new StringReader(inputData);
		StringWriter output = new StringWriter();
		
		int data = 0;
		
		try {
			while( (data=input.read()) != -1 ){
				output.write(data);
			}
		}catch(IOException e) {}
		System.out.println("input data : "+inputData);
		System.out.println("Output data : "+output.toString());
	  //System.out.println("Output data : "+output.getBuffer().toString());
	}

}
