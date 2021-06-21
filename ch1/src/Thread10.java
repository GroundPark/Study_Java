
public class Thread10 {

	public static void main(String[] args) {
		// TODO 간단한 gc 예제 
		ThreadEx12 gcTh = new ThreadEx12();
		gcTh.setDaemon(true);
		gcTh.start();
		
		int requireMem = 0;
		
		for(int i=0;i<20;i++) {
			requireMem = (int)(Math.random() * 10) * 20;  //20번의 0~180의 메모리가 필요하다 가정함
			if(gcTh.freeMem() < requireMem || gcTh.freeMem() < gcTh.totalMem() * 0.4) {
				gcTh.interrupt();
				try {
					gcTh.join(100);   
					//이 코드가 없으면 gc가 실행되더라도 main은 계속 진행되기때문에  때때로 MAX_MEMORY를 초과함... join()을 통해 gc를 위해 잠깐 기다리게해야함
				}catch(InterruptedException e) {}
			}
			// 메모리 부족(사용가능 메모리 < 필요한 메모리) or 남은 메모리가 전체 메모리의 40% 미만(사용가능 메모리 > 총 메모리 * 0.4) 
			gcTh.usedMem += requireMem;
			System.out.println("usedMemory:"+gcTh.usedMem +"//Free Memory : " +gcTh.freeMem());
		}
	}

}

class ThreadEx12 extends Thread{
	final static int MAX_MEMORY = 1000;
	int usedMem = 0;
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(10 * 1000);
			}catch(InterruptedException e) {
				System.out.println("메모리 부족 or 남은 메모리가 전체 메모리의 40%미만입니다. interrupt()로 gc를 깨웁니다");
			}
		
			gc();
			System.out.println("[gc 작업으로인해 메모리 300을 확보 완료] usedMemory:"+usedMem +" ///Free Memory : " +freeMem());
		}
	}
	
	public void gc() {
		usedMem -= 300;
		if(usedMem < 0) 
			usedMem = 0;
	}
	public int totalMem() { return MAX_MEMORY; }
	public int freeMem() { return MAX_MEMORY - usedMem; }
}
