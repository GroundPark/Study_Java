import java.io.*;
import java.net.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Network3_Thread_Server implements Runnable {
	ServerSocket serverSkt;
	Thread [] threadArr;
	
	public static void main(String[] args){
		// TODO 여러 쓰레드를 생성해 클라의 요청을 동시에 (병렬)처리하는 TCP/IP server
		
		Network3_Thread_Server server = new Network3_Thread_Server(5);
		server.start();
		// 예제에서 5개의 쓰레드를 가진 서버를 만듬
		
	}

	public Network3_Thread_Server(int num) {
		try {
			serverSkt = new ServerSocket(7777);		// 7777번 포트에서 요청 기다림
			System.out.println(getTime() +" server is ready ");
			
			threadArr = new Thread[num];
			
		}catch(IOException e) { e.printStackTrace(); }
	}
	
	public void start() {
		for(int i=0; i < threadArr.length; i++) {
			threadArr[i] = new Thread(this);
			threadArr[i].start();
		}
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println(getTime() +" wait for connection request ");
				//serverSkt.setSoTimeout(5*1000);
				
				Socket skt = serverSkt.accept();	
				System.out.println(getTime() + " connection request from : " +skt.getInetAddress());
				
				OutputStream outputS = skt.getOutputStream();
				DataOutputStream DoutputS = new DataOutputStream(outputS);
	
				DoutputS.writeUTF(" [NOTICE] Test 문자 from server ");
				System.out.println(getTime() +" data send success ");
				
				DoutputS.close();
				skt.close();
			}catch(SocketTimeoutException timeoutE) {
				System.out.println(" Connection time out ");
				System.exit(0);
			}catch(IOException e) { e.printStackTrace(); }
		}
	}

	static String getTime() {
		// TODO 현재시간을 문자열로 반환 (name도 추가함)
		String name = Thread.currentThread().getName();
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date()) + name;
	}

}
