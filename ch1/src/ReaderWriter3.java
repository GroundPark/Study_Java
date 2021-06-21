import java.io.*;
public class ReaderWriter3 {

	public static void main(String[] args) {
		// PipedReader/Writer는 쓰레드간 데이터를 [하나의 스트림으로 연결해] 주고받을 때 사용함
		// 스트림 생성 -> 한쪽에서 connect() 호출하여 연결 -> 한쪽에서 close() 호출하여 종료
		// TODO 두 쓰레드가 PipedReader/Writer를 이용해 메세지를 주고받는 예제
		
		InputThread inThread = new InputThread("InputThread");
		OutputThread outThread = new OutputThread("OutPutThread");
		
		inThread.connect(outThread.getOutput());
		
		inThread.start();
		outThread.start();
	}

}

class InputThread extends Thread{
	PipedReader input = new PipedReader();
	StringWriter sw = new StringWriter();
	// 메모리 사용하는 StringWriter에서 String buffer를 이용해 출력내용을 여기에 저장함 
	
	InputThread(String name){
		super(name);
	}
	
	public void run() {
		try {
			int data = 0;
			while( (data=input.read()) != -1) {
				sw.write(data);
			}
			System.out.println(getName() + "에서 받음 : " +sw.toString());
		}catch(IOException e) {}
	}
	
	// public PipedReader getInput() {	return input; }
	
	public void connect(PipedWriter output) {
		try {
			input.connect(output);
		}catch(IOException e) {}
	}
}

class OutputThread extends Thread{
	PipedWriter output = new PipedWriter();
	
	OutputThread(String name){
		super(name);
	}
	
	public void run() {
		try {
			String msg = " hello ";
			System.out.println(getName() +"에서 보냄 : "+msg);
			output.write(msg);
			output.close();
		}catch(IOException e) {}
	}
	
	public PipedWriter getOutput() {
		return output;
	}
	
	public void connect(PipedReader input) {
		try {
			output.connect(input);
		}catch(IOException e) {}
	}
}