class Thread1 {
	public static void main(String args[]) {
		// 쓰레드 구현 예제. thread 상속 - Runnable 인터페이스 구현 두 방법이 있으며, 일반적으로 Runnable을 구현하여 객체지향적으로 사용한다 
		// start() : 호출스택 생성하고 run()을 호출하게함 , run() : 메서드
		// main에서 start() >> start()로 인해 새 쓰레드(호출스택) 생성됨 >> 새 쓰레드에 run()이 호출되고 독립적으로 작업수행 >> 멀티 쓰레드 환경이 됨 
		// '스케줄러'에 의해 우선순위, 실행 시간 등을 결정함 
		// 설정한 시간안에 작업을 못마치면 다시 차례가 올때까지 대기상태
		// 작업끝난 쓰레드는 호출스택 사라짐... 실행중인 사용자 쓰레드가 하나도 없다면 프로그램은 종료됨
		Thread_thr t1 = new Thread_thr();

		Runnable r  = new Thread_run();
		Thread   t2 = new Thread(r);	  // 생성자 Thread(Runnable target)

		t1.start();
		t2.start();
		// 쓰레드는 '한번만 실행'되는것에 주의... 동일 쓰레드 반복실행하려면 그만큼 쓰레드를 만들어줘야함
	}
}

class Thread_thr extends Thread {  //Thread를 상속받으므로 다른 클래스 상속이 안돼서 덜유연함
	public void run() {
		for(int i=0; i < 5; i++) {
			System.out.println(getName()); // 조상인 Thread의 getName()을 호출 (쓰레드의 이름)
		}
	}
}

class Thread_run implements Runnable {
	public void run() {
		for(int i=0; i < 3; i++) {
			// Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
		    System.out.println(Thread.currentThread().getName());
		}
	}
}
