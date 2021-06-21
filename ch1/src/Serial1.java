import java.io.*;
import java.util.*;
public class Serial1 {

	public static void main(String[] args) {
		// TODO Serialization(직렬화) : 객체의 저장된 데이터를 스트림에 write 하기위해 serial 데이터로 변환하는것
		//   직렬화 (스트림에 개체를 출력)    : ObjectOutputStream
		//  역직렬화(스트림으로부터 객체를 입력): ObjectInputStream
		// 둘다 보조스트림
		
		try {
			String fileName = "UserInfo.ser";
			FileOutputStream FOutputS = new FileOutputStream(fileName);
			BufferedOutputStream BoutputS = new BufferedOutputStream(FOutputS);
			
			ObjectOutputStream OoutputS = new ObjectOutputStream(BoutputS);
			
			_userInfo uid1 = new _userInfo("dude","qlqjs1",25);
			_userInfo uid2 = new _userInfo("girls","0228",21);
			
			ArrayList<_userInfo> list = new ArrayList <>();
			list.add(uid1);
			list.add(uid2);
			
			OoutputS.writeObject(uid1);
			OoutputS.writeObject(uid2);
			OoutputS.writeObject(list);
			OoutputS.close();
			System.out.println(" 직렬화 작업 완료 ");
			
		}catch(IOException e) { e.printStackTrace(); }
	}

}
