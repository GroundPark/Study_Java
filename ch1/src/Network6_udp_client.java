import java.io.*;
import java.net.*;

public class Network6_udp_client {
	public void start() throws IOException, UnknownHostException{
		DatagramSocket dSkt = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
		
		byte [] msg = new byte[100];
		// 데이터 저장 공간. 크기 100 byte 배열 생성
		
		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
		
		dSkt.send(outPacket);
		dSkt.receive(inPacket);
		
		System.out.println(" current server time : " +new String(inPacket.getData()));
		
		dSkt.close();
	}
	
	public static void main(String[] args) {
		try {
			new Network6_udp_client().start();
		}catch(Exception e) { e.printStackTrace(); }
	}

}
