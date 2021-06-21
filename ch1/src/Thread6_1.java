import javax.swing.JOptionPane;
public class Thread6_1 {

	public static void main(String[] args) {
		// 쓰레드가 sleep,wait,join에 의해 일시정지 상태 (Waiting)일때 interrupt() 호출 
		// > 해당 메서드에서 InterruptedException 발생하고... interrupted상태는 false로 자동초기화 됨
		// >>> 쓰레드는 실행대기 상태(Runnable)가 됨... 즉 멈춰있는 쓰레드를 깨워 실행가능한 상태로 만듬
		ThreadEx4 th1 = new ThreadEx4();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무값 입력");
		System.out.println("입력값 : " +input);
		th1.interrupt();
		System.out.println("th1.isInterrupted() 상태 : " +th1.isInterrupted());

	}

}

class ThreadEx4 extends Thread{
	public void run() {
		int i=10;
		while(i != 0 && !isInterrupted()) {
			System.out.println(i--);
			try {
				Thread.sleep(1000);		//단순히 Thread.sleep(1000)만 넣어선 InterruptedException이 발생됨
			}catch(InterruptedException e) {
				interrupt();    //InterruptedException에 의해 바뀐 상태를 다시 true로 바꿔줌 
			}
		}
		System.out.println("카운트 종료");
	}
}