
public class Thread5 {

	public static void main(String[] args) {
		// TODO sleep()는 쓰레드를 일정시간동안 멈추게함
		// 동일한 쓰레드를 생성하면 작업순서, 결과가 다른데... OS,JVM 스케줄링 정책에 따라 상이하므로 어쩔수없음
		ThreadEx1 th1 = new ThreadEx1();
		ThreadEx2 th2 = new ThreadEx2();
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(2000);
			//sleep()는 현재 실행중인 쓰레드에 대해 작동함... 여기선 main쓰레드에서 작동
			//th1.sleep(2000); 처럼 쓰면 안됨! (static 메서드임)
		}catch(InterruptedException e) {}
		
		System.out.println("!!main종료");
	}
}

class ThreadEx1 extends Thread{
	public void run() {
		for(int i=0;i<300;i++) 
			System.out.print("-");
		System.out.print("!쓰레드1종료");
	}
}

class ThreadEx2 extends Thread{
	public void run() {
		for(int i=0;i<300;i++)
			System.out.print("|");
		System.out.print("!쓰레드2종료");
	}
}