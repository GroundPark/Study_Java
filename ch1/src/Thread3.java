
public class Thread3 {

	public static void main(String[] args) throws Exception{
		// TODO 모든 쓰레드는 반드시 '쓰레드 그룹'에 포함되어 있어야 함. 없으면 자기를 생성한 쓰레드에 포함됨
		// 자바 어플리케이션 실행 >> JVM은 main, system 쓰레드 그룹 만듬 
		// >> 생성하는 쓰레드들은 거의 main 쓰레드 그룹의 하위 그룹이 됨... 또는 gc수행하는 Finalizer쓰레드는 system 쓰레드 그룹이 됨 
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup TG1 = new ThreadGroup("쓰레드그룹1");
		ThreadGroup TG2 = new ThreadGroup("쓰레드그룹2");
		ThreadGroup subTG1 = new ThreadGroup(TG1, "자식쓰레드그룹");
		
		TG1.setMaxPriority(3);
		
		Runnable r = new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				}catch(Exception e) {}
			}
		};
		
		new Thread(TG1, r, "th1").start();
		new Thread(TG1, r, "th2").start();
		new Thread(subTG1, r, "th3").start();
		// Thread(그룹, 구현한 쓰레드, "이름") 
		//Thread th1 = new Thread(TG1, r, "th1");
		//th1.start();  
		
		main.list();  //쓰레드 그룹의 정보 출력
		System.out.println();
		System.out.println("main의 쓰레드그룹 기본값 : " +main.getName() 
							+" //실행중인 그룹갯수 : " +main.activeGroupCount() 
							+" //실행중인 쓰레드 갯수 : " +main.activeCount());
	}
}
