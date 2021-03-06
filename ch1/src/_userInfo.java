
public class _userInfo implements java.io.Serializable {
		// TODO Serial1 에서 사용하기 위해 만든 클래스 (컴파일 선행 필요!)
		String name;
		String password;
		int age;
		// Object obj = new Object();   >> Object 객체는 직렬화 할수 없음(클래스 내에 직렬화 관련 구현이 되어있어야 가능)
		
		transient String adminPW;
		// transient를 사용하여 직렬화 대상에서 제외되게 함 (보안상 직렬화되면 안 되는 값, 중요도 높은 값 등에 쓰임!!)
		// 이것을 역직렬화하면 null을 반환함

		public _userInfo() {
			this("Unknown","1234",0);
		}
		
		public _userInfo(String name, String password, int age) {
			this.name = name;
			this.password = password;
			this.age = age;
		}
		
		public String toString() {
			return "(" +name +"," +password +"," +age +")";
		}
		
		//static final long serialVersionUID = 3518731767529258119L;
		// 직렬화 > 역질렬화를 할때 같은 클래스(버전)을 사용해야 함. 이때 수동으로 관리하려면 serialVersionUID를 사용함
		// UID를 얻는 방법은 커맨드 창에 serialver _userInfo로 얻음
}
