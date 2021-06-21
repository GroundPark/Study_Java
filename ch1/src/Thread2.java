
public class Thread2 {

	public static void main(String[] args) {
		// TODO 쓰레드는 우선순위라는 속성을 가지고 있음. 1~10 순으로 높을수록 우선순위 높음
		// 쓰레드를 생성한 쓰레드로 부터 상속받음... 우선순위가 5인 main 메서드 내에서 쓰레드를 생성하면 상속받아 5가됨 
		// 단순히 우선순위를 차등을 둔다해도 시간차이는 없음... OS, JVM 마다 스케쥴링 정책이 다르기에 환경에 따라 전부 다른 결과를 얻을 수도 있음
		// 쓰레드의 우선순위를 건들지, 작업의 우선순위(ex:PriorityQueue)를 건들지 검토해야함! 
		Thread_th th1 = new Thread_th();
		Thread_th2 th2 = new Thread_th2();
		
		th2.setPriority(7);
		
		System.out.println("th2(-)의 우선순위는 " +th2.getPriority());
		
		th1.start();
		th2.start();	
	}
}
     
class Thread_th extends Thread{
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("-");
			for(int j=0;j<10000000;j++);
			//지연용 반복문
		}
	}
}

class Thread_th2 extends Thread{
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("|");
			for(int j=0;j<10000000;j++);
		}
	}
}
