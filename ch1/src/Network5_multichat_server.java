import java.util.*;
import java.io.*;
import java.net.*;

public class Network5_multichat_server {
	HashMap clients;
	
	public static void main(String[] args) {
		// TODO 여러 클라가 서버에 접속해 채팅하는 멀티채팅-서버 예제
		// 클라에 대한것을 HashMap에 저장하고 처리함
			new Network5_multichat_server().start();
		}
	
		
		Network5_multichat_server(){
			clients = new HashMap();
			Collections.synchronizedMap(clients);
		}
		
		public void start() {
			ServerSocket serverSkt = null;
			Socket skt = null;
			
			try {
				serverSkt = new ServerSocket(7777);
				System.out.println(" Chatting Server is ready ");
				
				while(true) {
					skt = serverSkt.accept();
					System.out.println("["+skt.getInetAddress()+":"+skt.getPort()+"] connected ");
					ServerReceiver thread = new ServerReceiver(skt);
					thread.start();
				}
			}catch(Exception e) { e.printStackTrace(); }
		}

		class ServerReceiver extends Thread{
			// 클라가 추가될때마다 이 쓰레드를 생성하여 클라의 입력을 sendToAll 하게 함
			Socket skt;
			DataInputStream DinputS;
			DataOutputStream DoutputS;
			
			ServerReceiver(Socket skt){
				this.skt = skt;
				try {
					DinputS = new DataInputStream(skt.getInputStream());
					DoutputS = new DataOutputStream(skt.getOutputStream());
				}catch(IOException e) {}
			}
			
			public void run() {
				String name = "";
				
				try {
					name = DinputS.readUTF();
					sendToAll(name +" has joined channel ");
					
					clients.put(name, DoutputS);
					System.out.println(" online user : " +clients.size());
					
					while(DinputS != null) {
						sendToAll(DinputS.readUTF());
					}
				}catch(IOException e) {
				}finally {
					sendToAll(name +" left channel ");
					clients.remove(name);
					System.out.println("["+skt.getInetAddress()+":"+skt.getPort()+"]" +name + " disconnected ");
					System.out.println(" online user : " +clients.size()+" connected ");
				}
				
			
			}
			
		}
		void sendToAll(String msg) {
			Iterator it = clients.keySet().iterator();
			
			while(it.hasNext()) {
				try {
					DataOutputStream DoutputS = (DataOutputStream)clients.get(it.next());
					DoutputS.writeUTF(msg);
				}catch(IOException e) {}
			}
		}
}
