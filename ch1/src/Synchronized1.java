
class Synchronized1 {
	public static void main(String[] args) {
		// TODO 쓰레드의 동기화(synchronized) : 한 쓰레드가 작업하고 있는것에 간섭하지 못하도록 막는것
		// 공유 데이터를 사용하는 코드 영역을 임계 영역[critical section]으로 지정하고...
		// 공유 데이터가 가지고 있는 lock을 가지고있는 단 하나의 쓰레드만 그 코드를 수행할수 있게함... 끝나면 lock반납하고 이런식으로 활용
		// 메서드에 걸거나, 블럭{} 을 이용하는데... 임계 영역은 최소화해야 효율적 프밍이 되므로 블럭을 자주 씀
		Runnable r = new ThreadRun13();
		new Thread(r).start();
		new Thread(r).start();
	}
}

class Account{
	private int balance = 1000;  //동기화할것이므로 private로 해야 외부접근을 완전히 차단할수 있다. 동기화 선언했더라도 쓰레드가 작업중에만 접근 불가임
	
	public int getBal() {
		return balance;
	}
	
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			balance -= money;
		}
	}
}

class ThreadRun13 implements Runnable{
	Account myAcc = new Account();
	
	public void run(){
		while(myAcc.getBal() > 0) {
			int money = (int)(Math.random() * 3 +1) * 100;  // 100,200,300 랜덤하게 돈이 나간다 가정
			myAcc.withdraw(money);
			
			System.out.println("계좌 잔고 : "+myAcc.getBal());
		}
	}
}