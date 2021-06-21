
class Thread4 implements Runnable{
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		// TODO 데몬쓰레드 : 일반 쓰레드의 작업을 돕기 위해서만 쓰는 보조 쓰레드
		// 무한루프, 조건문 이용해 실행후 대기타다가 조건을 만족하면 작업 수행하고... 다시 대기함
		// gc, auto-save 기능, 화면자동갱신 등에서 씀
		// 프로그램 실행하면 JVM에서 각종 데몬 쓰레드들을 자동적으로 생성함... system 또는 main 쓰레드 그룹에서
		Thread t = new Thread(new Thread4());
		
		t.setDaemon(true);
		t.start();
		//setDaemon()은 반드시 start() 전에 수행돼야함
		//쓰레드 t에 setDaemon(true)을 호출하지않으면 무한대기상태로 강제종료하기전까지 종료안됨
		
		for(int i=1;i<=14;i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			System.out.println(i);
			
			if(i==5) {
				autoSave = true;
				System.out.println("실행후 5초가 지나 자동저장 기능이 활성화 되었습니다(3초마다 저장)");
			}
		}
		System.out.println("어플리케이션 종료");
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(3 * 1000);
			}catch(InterruptedException e) {}
			if(autoSave) {
				autoSave();
			}
		}
	}
	public void autoSave() {
		System.out.println("자동저장 완료");
	}
}
