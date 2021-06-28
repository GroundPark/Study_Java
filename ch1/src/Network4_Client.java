import java.net.*;
import java.io.*;

public class Network4_Client {

	public static void main(String[] args) {
		// TODO TCP/IP 1:1 채팅 client
		try {
			String serverIp = "127.0.0.1";
			Socket skt = new Socket(serverIp, 7777);
			System.out.println(" connected server ");
			
			Sender sender = new Sender(skt);
			Receiver receiver = new Receiver(skt);
			
			sender.start();
			receiver.start();
			
		}catch(Exception e) { e.printStackTrace(); }
	}

}
