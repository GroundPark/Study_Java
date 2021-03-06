import java.io.*;
import java.net.*;
public class Network3_Client {

	public static void main(String[] args) {
		// TODO TCP/IP 서버와 통신하기 위한 클라이언트 예제
		
		try {
			String serverIP = "127.0.0.1";
			
			System.out.println(" connecting server : " +serverIP);
			Socket skt = new Socket(serverIP, 7777);
			// 소켓 생성 + 연결 요청(자동)
			
			InputStream InputS = skt.getInputStream();
			DataInputStream DinputS = new DataInputStream(InputS);
			// 소켓의 입력 스트림을 얻음
			
			System.out.println(" received data from server : " +DinputS.readUTF());
			System.out.println(" disconnecting ... ");
			
			DinputS.close();
			skt.close();
			System.out.println(" disconnected ");
			
		}catch(Exception e) { e.printStackTrace(); }

	}

}
