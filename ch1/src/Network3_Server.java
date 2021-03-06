import java.io.*;
import java.net.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Network3_Server {

	public static void main(String[] args) {
		// TODO 소켓 : 프로세스간의 통신에 사용되는 양쪽 끝단(endpoint)
		//       Socket : 프로세스간 통신 담당. InputStream, OutputStream 가짐. 두 스트림을 이용해 프로세스간 통신(I/O)함
		// ServerSocket : 포트와 연결돼 외부의 연결요청을 기다림 > 요청이 오면 Socket 생성해 두 소켓간 통신이 이루어지도록 함
		//				     한 포트에 하나의 ServerSocket 연결가능 (프로토콜이 달라야 같은 포트 사용가능)
		
		// TODO TCP/IP server 예제 구현
		ServerSocket serverSkt = null;
		
		try {
			serverSkt = new ServerSocket(7777);		// 7777번 포트에서 요청 기다림
			System.out.println(getTime() +" server is ready ");
		}catch(IOException e) { e.printStackTrace(); }
		
		
		while(true) {
			try {
				System.out.println(getTime() +" wait for connection request ");
				serverSkt.setSoTimeout(5*1000);
				// 요청대기시간 5초. 접속 요청이 5초동안 없으면 SocketTimeoutException 발생  (! 0이면 무제한 대기)
				
				Socket skt = serverSkt.accept();	// 지속적 처리를 위해 while 무한반복 사용
				System.out.println(getTime() + " connection request from : " +skt.getInetAddress());
				
				OutputStream outputS = skt.getOutputStream();
				DataOutputStream DoutputS = new DataOutputStream(outputS);
				// socket의 출력 스트림 얻음
				
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

	private static String getTime() {
		// TODO 현재시간을 문자열로 반환
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date());
	}

}
