import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Network4_Server {

	public static void main(String[] args) {
		// TODO TCP/IP 1:1 채팅 server. socket으로 데이터 송수신하는 작업을 각각 Sender, Receiver가 처리하도록 하여 송수신이 동시에 이루어짐
		ServerSocket serverSkt = null;
		Socket skt = null;
		
		try {
			serverSkt = new ServerSocket(7777);
			System.out.println(" chatting server is ready ");
			
			skt = serverSkt.accept();
			
			Sender sender = new Sender(skt);
			Receiver receiver = new Receiver(skt);
			
			sender.start();
			receiver.start();
			
		}catch(Exception e) { e.printStackTrace(); }
		
	}

}

class Sender extends Thread{
	Socket skt;
	DataOutputStream DoutputS;
	String name;
	
	Sender(Socket skt){
		this.skt = skt;
		try {
			DoutputS = new DataOutputStream(skt.getOutputStream());
			name = "[" +skt.getInetAddress()+":"+skt.getPort()+"]";
		}catch(Exception e) {}
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while(DoutputS != null) {
			try {
				DoutputS.writeUTF(name+scanner.nextLine());
			}catch(IOException e) {}
		}
	}
}

class Receiver extends Thread{
	Socket skt;
	DataInputStream DinputS;
	
	Receiver(Socket skt){
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