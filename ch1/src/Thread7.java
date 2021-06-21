
public class Thread7 {

	public static void main(String[] args) {
		// suspend() : 쓰레드 멈춤
		// resume()  : suspend된 쓰레드를 실행대기 상태로 만듬 
		// stop()    : 쓰레드 강제종료
		// 위 메서드들은 교착상태(deadlock)을 자주 발생시켜 deprecated 되었음
		ThreadEx9 th1 = new ThreadEx9("*");
		ThreadEx9 th2 = new ThreadEx9("**");
		ThreadEx9 th3 = new ThreadEx9("***");
				
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			th1.suspend();
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		}catch(InterruptedException e) {}
	}

}

class ThreadEx9 implements Runnable {
	volatile boolean suspended = false;  // volatile(버으-ㅎ맇틇)을 이용해 cpu의 캐시가 아닌 메모리에서 저장된 값을 가져옴
	volatile boolean stopped = false;    // 4Byte 원자화를 시켜서 변수를 원자화 함... synchronized같은 동기화 필요 쓰레드에서 자주 사용
	
	public void suspend() {suspended = true;}
	public void resume() {suspended = false;}
	public void stop() {stopped = true;}
	public void start() {th.start();}
	
	Thread th;
	
	ThreadEx9(String name){
		th = new Thread(this, name);
	}
	
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {}
			}
		}
		System.out.println(Thread.currentThread().getName() + "는 중지되었음");
	}
}