package future.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// How to get result from a runnable task

class SumOfNaturals implements Runnable {

	int finalLimit;

	int result;

	public SumOfNaturals(int finalLimit) {
		super();
		this.finalLimit = finalLimit;
	}

	public void run() {

		for (int i = 1; i <= finalLimit; i++) {

			result = result + i;

		}

	}

}

public class FutureTaskRunnable {



	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		SumOfNaturals ten = new SumOfNaturals(10);
		
	//	SumOfNaturals five = new SumOfNaturals(5);
		
		Integer ir=0; // result is null
		
		FutureTask<Integer> ften =new FutureTask<Integer>(ten,ir);
		
		Future<Integer> ff=	(Future<Integer>) service.submit(ften);
		
		try {
			
			System.out.println("Get the sum of first 10 natural numbers "+ff.get(9000,TimeUnit.SECONDS));
		
		
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		service.shutdown();
		

		
		
		
		
		
		// seperate snippet for FutureTask below
		

		// behaves like a cyclic barrier
		
		   FutureTask<Integer> task = new FutureTask<Integer>(()-> {
		        System.out.println("Pretend that something complicated is computed");
		        Thread.sleep(1000);
		        return 42;
		    });

		    Thread t1 = new Thread(()->{
		        try {
		            int r = task.get();
		            System.out.println("Result is " + r);
		        } catch (InterruptedException | ExecutionException e) {}
		    });
		    Thread t2 = new Thread(()->{
		        try {
		            int r = task.get();
		            System.out.println("Result is " + r);
		        } catch (InterruptedException | ExecutionException e) {}
		    });
		    Thread t3 = new Thread(()->{
		        try {
		            int r = task.get();
		            System.out.println("Result is " + r);
		        } catch (InterruptedException | ExecutionException e) {}
		    });

		    System.out.println("Several threads are going to wait until computations is ready");
		    t1.start();
		    t2.start();
		    t3.start();
		    task.run(); // let the main thread to compute the value
		
		
		
		
		
		
		
		
	}

}
