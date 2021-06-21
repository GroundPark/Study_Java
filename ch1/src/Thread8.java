
public class Thread8 {

	public static void main(String[] args) {
		// TODO yield : 주어진 실행시간을 다음차례 쓰레드에게 양보함
		// 실행시간 10초를 할당받은 쓰레드가 5초동안 작업을 한 상태에서 yield()가 호출되면... 남은 5초는 포기하고 실행대기 상태가 됨
		ThreadEx10 th1 = new ThreadEx10("*");
		ThreadEx10 th2 = new ThreadEx10("**");
		ThreadEx10 th3 = new ThreadEx10("***");
				
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(5000);
			th1.suspend();
			Thread.sleep(5000);
			th2.suspend();
			Thread.sleep(6000);
			th1.resume();
			Thread.sleep(7000);
			th1.stop();
			th2.stop();
			Thread.sleep(5000);
			th3.stop();
		}catch(InterruptedException e) {}
	}

}

class ThreadEx10 implements Runnable {
	volatile boolean suspended = false;  
	volatile boolean stopped = false;
	
	public void suspend() {
		suspended = true;
		th.interrupt();
		System.out.println(th.getName() +" << interrupt() by suspend()");
	}
	public void resume() {suspended = false;}
	public void stop() {
		stopped = true;
		th.interrupt();
		System.out.println(th.getName() +" << interrupt() by stop()");
		}
	public void start() {th.start();}
	
	Thread th;
	
	ThreadEx10(String name){
		th = new Thread(this, name);
	}
	
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);		
					// 만약 stop()이 호출됐을때 sleep(1000)에 의해 쓰레드가 일시정지 상태에 머물러 있는 상황이라면... 
					// stopped값이 true로 바껴도 쓰레드가 정지될때까지 ~1초 지연시간 생김
					// suspend-stop에 interrupt를 넣은 이유 : interrupt() 호출시 예외발생하므로 바로 일시정지 상태에서 벗어나게됨 + catch로 받으므로 응답성 높아짐
				}catch(InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " << interrupted");
				}
			}else {
				Thread.yield();
			}
			// suspended 값이 true면... 주어진 실행 시간을 while문을 돌면서 낭비하게됨(busy-waiting;바쁜 대기상태)
			// if문의 else에 yield()를 호출해 이 경우를 방지하면 효율적이게 됨
		}
		System.out.println(Thread.currentThread().getName() + " << stopped");
	}
}