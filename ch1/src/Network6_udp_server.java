import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Network6_udp_server {
	// TODO 서버에서 서버시간을 전송받아 클라에서 출력하는 간단 UDP 예제  
	public void start() throws IOException {		//datagramSocket 에서 예외
		DatagramSocket dSkt = new DatagramSocket(7777);
		DatagramPacket inPacket, outPacket;
		
		byte [] inMsg = new byte[10];
		byte [] outMsg;
		
		while(true) {
			inPacket = new DatagramPacket(inMsg, inMsg.length);
			dSkt.receive(inPacket);
			// 데이터 수신하기 위한 패킷 생성을 하고... 패킷을 통해 데이터 receive 함
			
			InetAddress address = inPacket.getAddress();
			int port = inPacket.getPort();
			// 패킷에서 클라의 IP주소+포트 얻음
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String serverTime = sdf.format(new Date());
			outMsg = serverTime.getBytes();
			// 서버의 현재 시간을 지정 sdf 형태로 반환하고... 그다음 byte배열로 반환함
			
			outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
			dSkt.send(outPacket);
			// 패킷 생성... 클라에게 send
		}
	}
	
	public static void main(String[] args) {
		// TODO TCP/IP에서 Socket, ServerSocket 사용했다면... UDP는 DatagramSocket(소켓), DatagramPacket(데이터)을 사용함
		// DatagramPacket은 헤더(받는 호스트의 주소/포트)+데이터로 구성되어있음
		// DatagramPacket에 적힌 주소(포트)로 가면 DatagramSocket에 도착한다 생각
		// 연결지향적인 프로토콜이 아님... 데이터가 완벽하지 않더라도 반응성, 속도가 우선시되는 스트리밍(영상), 게임 데이터에 사용됨
		try {
			new Network6_udp_server().start();
		}catch(Exception e) { e.printStackTrace(); }
		
	}

}
