
public class Thread9 {
	static long startTime = 0;
	public static void main(String[] args) {
		// TODO join() : 쓰레드 자신이 하던 작업을 잠깐 멈추고.. 다른 쓰레드가 지정된 시간동안 작업을 수행함
		// 
		ThreadEx11_1 th1 = new ThreadEx11_1();
		ThreadEx11_2 th2 = new ThreadEx11_2();
		
		th1.start();
		th2.start();
		
		startTime = System.currentTimeMillis();
		
		try {
			th1.join();
			th2.join();
			//main 쓰레드가 th1,th2의 작업이 끝날때까지 기다림
		}catch(InterruptedException e) {}
		
		System.out.print("Elapsed Time : " +(System.currentTimeMillis() - Thread9.startTime));
	}

}

class ThreadEx11_1 extends Thread{
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print(new String ("-"));
		}
	}
}

class ThreadEx11_2 extends Thread{
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print(new String ("|"));
		}
	}
}