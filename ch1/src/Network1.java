import java.net.*;
import java.util.*;
public class Network1 {

	public static void main(String[] args) {
		// TODO Networking : 두 대 이상의 컴퓨터를 케이블로 연결해 네트워크를 구성하는 것
		// 자바에선 java.net 패키지로 다룸
		
		/* server : 서비스를 제공하는 컴퓨터
		 * client : 서비스를 사용하는 컴퓨터
		 *  서비스    : 서버가 클라이언트로부터 요청받은 작업을 처리하여, 그 결과를 제공하는 것
		 * 
		 * 서버기반모델 : 전용서버를 두는 것
		 * > 안정적인 서비스 제공 / 공유 데이터의 관리, 보안 용이 || 서버구축비용+관리비용
		 * 
		 *  P2P 모델 : 각 클라이언트가 서버 역할을 동시에 수행(peer-to-peer)
		 * > 구축, 관리 비용 절감 / 자원 활용 극대화 || 보안 취약, 자원 관리 어려움
		 */
		
		
		
		
		// TODO InetAddress 메서드를 활용해 IP주소를 다루는 예제
		
		InetAddress ip = null;
		InetAddress [] ipArr = null;
		
		try {
			ip = InetAddress.getByName("www.google.com");
			System.out.println("getHostName() : " +ip.getHostName());
			System.out.println("getHostAddress() : " +ip.getHostAddress());
			
			byte [] ipAddr = ip.getAddress();
			System.out.println("getAddress() : " +Arrays.toString(ipAddr));
			System.out.println("///////////////////////");
		}catch(UnknownHostException e) { e.printStackTrace(); }
		
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName : " +ip.getHostName());
			System.out.println("getHostAddress : " +ip.getHostAddress());
			System.out.println("///////////////////////");
		}catch(UnknownHostException e) { e.printStackTrace(); }
		
		
		try {
			ipArr = InetAddress.getAllByName("www.naver.com");
			
			for(int i=0;i<ipArr.length;i++) {
				System.out.println("ipArr[" +i +"] : " +ipArr[i]);
			}
		}catch(UnknownHostException e) { e.printStackTrace(); }
		// 하나의 도메인명에 여러 IP주소가 맵핑될 수도 있기에 (반대도) getAllByName()으로 모든 IP 주소 얻음
	}

}
