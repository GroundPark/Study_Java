import java.util.concurrent.*;

public class FW_fork_join {
	static final ForkJoinPool pool = new ForkJoinPool();  //프레임워크에서 제공하는 쓰레드 풀 생성
	// 쓰레드 풀 : 쓰레드가 수행해야하는 작업이 담긴 Queue 제공. 쓰레드는 각 Queue에 담긴 작업을 순서대로 진행
    // 지정된 수의 쓰레드를 생성... 미리 만들어 반복해서 재사용가능, (쓰레드를 반복해서 생성안해도 됨. 과다한 쓰레드 생성 방지) 
	public static void main(String[] args) {
		// fork&join 프레임워크 : 하나의 작업을 작은 단위로 나눠서 여러 쓰레드가 동시에 처리함
		// RecursiveAction(반환x), RecursiveTask(반환o) 두 클래스 중 하나를 상속,구현 해야함
		// compute()로 나누고... fork()로 작업을 쓰레드의 작업 큐에 넣고-join()으로 작업의 결과 얻음
		long from = 1L, to = 100000000L;
		
		SumTask task = new SumTask(from, to);
		
		long start = System.currentTimeMillis();
		Long result = pool.invoke(task);   //run-start처럼 compute-invoke로 시작함
		System.out.println("Elapsed Time : " +(System.currentTimeMillis() - start));
		System.out.printf("sumTask 결과 : %d~%d의 합은 %d  ",from,to,result);
	}

}

class SumTask extends RecursiveTask<Long>{  
	long from, to;
	
	SumTask(long from, long to){
		this.from = from;
		this.to = to;
	}
	
	public Long compute() {  // compute()를 구현하면서 쓰레드 관련 작업 코드를 넣음
		// 예제에선  size값이 5보다 작거나 같을때까지 반복해서... 범위를 반으로 나누는 작업을 함.
		long size = to - from + 1;
		
		if(size <= 5)
			return sum();
		
		long half = (from+to)/2;
		
		SumTask leftSum  = new SumTask(from, half);
		SumTask rightSum = new SumTask(half+1, to);
		
		leftSum.fork(); 	// fork : (수행만 지시하고 결과 안기다리는 비동기 메서드 ) leftSum 작업을 작업 Queue에 넣음 
		// 작업 훔쳐오기(work stealing) 을 하며 다른 쓰레드의 작업 큐에 있는 작업을 가져와 수행함(자동). 즉 쓰레드마다 빈곳없이 골고루 수행된다
		
		return leftSum.join() + rightSum.compute();
		// join : (수행 지시하고 끝날때까지 기다렸다가 결과를 반환하는 동기 메서드)
		// compute가 재귀를 끝내면 + join의 결과도 포함하여 값을 return함
	}
	
	long sum() {  // 실제 수행 코드 (from~to까지의 합)
		// 기본 수행 코드 vs 쓰레드 이용한 수행 코드 시간을 비교해서 이득이 있을때 채택해야함 (예제는 보여주기 위한것... 예제에선 기본 수행코드가 더 빠름)
		long tmp = 0L;
		
		for(long i=from;i<=to;i++)
			tmp += i;
		
		return tmp;
	}
}