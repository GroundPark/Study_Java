import java.net.*;
import java.io.*;
import java.util.*;

public class Network5_multichat_client {

	public static void main(String[] args) {
		// TODO 멀티채팅-클라이언트 예제
		if(args.length != 1) {
			System.out.println(" usage : args에 닉네임 ");
			System.exit(0);
		}
		
		try {
			String serverIp = "127.0.0.1";
			Socket skt = new Socket(serverIp, 7777);
			System.out.println(" you entered channel ");
			
			Thread sender = new Thread(new ClientSender(skt, args[0]));
			Thread receiver = new Thread(new ClientReceiver(skt));
			
			sender.start();
			receiver.start();
			
		}catch(ConnectException e) { e.printStackTrace(); }
		 catch(Exception e) {}
	}
	
	static class ClientSender extends Thread{
		Socket skt;
		DataOutputStream DoutputS;
		String name;
		
		ClientSender(Socket skt, String name){
			this.skt = skt;
			try {
				DoutputS = new DataOutputStream(skt.getOutputStream());
				this.name = name;
			}catch(Exception e) {}
		}
		
		public void run() {
			Scanner scanner = new Scanner(System.in);
			try {
				if(DoutputS != null) {
					DoutputS.writeUTF(name);
				}
				while(DoutputS != null) {
					DoutputS.writeUTF(name +" : " +scanner.nextLine());
				}
			}catch(IOException e) {}
		}
	}
	
	static class ClientReceiver extends Thread{
		Socket skt;
		DataInputStream DinputS;
		
		ClientReceiver(Socket skt){
			this.skt = skt;
			try {
				DinputS = new DataInputStream(skt.getInputStream());
			}catch(IOException e) {}
		}
		
		public void run() {
			while( DinputS != null) {
				try {
					System.out.println(DinputS.readUTF());
				}catch(IOException e) {}
			}
		}
	}
}
