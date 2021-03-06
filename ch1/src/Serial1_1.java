import java.io.*;
import java.util.*;
public class Serial1_1 {

	public static void main(String[] args) {
		// TODO 역직렬화하는 예제
		try {
			String fileName = "UserInfo.ser";
			
			FileInputStream FInputS = new FileInputStream("UserInfo.ser");
			BufferedInputStream BInputS = new BufferedInputStream(FInputS);
			
			ObjectInputStream OinputS = new ObjectInputStream(BInputS);
			
			_userInfo uid1 = (_userInfo)OinputS.readObject();
			_userInfo uid2 = (_userInfo)OinputS.readObject();
			ArrayList list = (ArrayList)OinputS.readObject();
			// !! 객체 읽을때는 출력한(직렬화한) 순서와 일치해야함
			
			System.out.println(uid1);
			System.out.println(uid2);
			System.out.println(list);
			// 만약 직렬화 관련 작업할 객체가 너무많은 경우 ArrayList같은 컬렉션을 이용할것을  권함!
			OinputS.close();
			
			
		}catch(Exception e) { e.printStackTrace(); }  	//readObject에서 Exception
	}

}
