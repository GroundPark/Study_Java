import javax.swing.JOptionPane;
class Thread6 {

	public static void main(String[] args) {
		// TODO interrupt, interrupted : 쓰레드 작업을 취소 요청 (강제x)
		// 진행중인 쓰레드의 작업이 끝나기 전에 취소해야할때... 예를들면 큰 파일 다운중 취소할때
		ThreadEx th1 = new ThreadEx();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무값 입력");
		System.out.println("입력값 : " +input);
		th1.interrupt();
		System.out.println("th1.isInterrupted() 상태 : " +th1.isInterrupted());
		// interrupt()에 의해 interrupted상태가 true가 됨
		// isInterrupted()는 상태 반환만... interrupted()는 상태 반환 후 false가 됨
	}

}

class ThreadEx extends Thread{
	public void run() {
		int i=10;
		while(i != 0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x=0;x<2500000000L;x++);  //시간지연
		}
		System.out.println("카운트 종료");
	}
}