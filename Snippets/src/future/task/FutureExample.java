package future.task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;




class Notifier extends FutureTask<Integer>

{

	public Notifier(Callable<Integer> callable) {
		super(callable);
	}
	
@Override
public void done(){
	
	System.out.println( "Hey ... the task is completed ");
	
}
	
	

}




class Calculates implements Callable<Integer>

{

	private int factorial;

	public Calculates(int i) {
		this.factorial = i;
	}

	public int getFactorial() {
		return factorial;
	}

	public void setFactorial(int factorial) {
		this.factorial = factorial;
	}

	public Integer call() {

		int fact = 1;
		System.out.println("Runing for int : " + this.factorial);
		for (int i = 1; i <= factorial; i++) {
			try {

				System.out.println("Runing for int : " + factorial);
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			fact = fact * i;

		}

		System.out.println("Fact completed for Callable " + this.factorial
				+ "result >>" + fact);
		return fact;

	}

}

public class FutureExample {

	public static void main(String[] args) {

		Calculates a = new Calculates(5);
		Calculates b = new Calculates(10);
		Calculates c = new Calculates(15);
		Calculates d = new Calculates(20);

		ExecutorService service = Executors.newFixedThreadPool(3);

		Future<Integer> fa = service.submit(a);
		Future<Integer> fb = service.submit(b);
		Future<Integer> fc = service.submit(c);
		Future<Integer> fd = service.submit(d);

		try {
/*			System.out.println("  Future result " + fa.get());

			System.out.println("  Future result " + fb.get());
			System.out.println("  Future result " + fc.get());
			System.out.println("  Future result " + fd.get());
*/
			try {
				System.out.println("  Future result " + fa.get(9000,TimeUnit.SECONDS));
			} catch (TimeoutException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				System.out.println("  Future result " + fb.get(9000,TimeUnit.SECONDS));
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println("  Future result " + fc.get(9000,TimeUnit.SECONDS));
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println("  Future result " + fd.get(9000,TimeUnit.SECONDS));
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		}

	//	service.shutdown();

		FutureTask<Integer> futask = new FutureTask<>(a);
		Notifier nf = new Notifier(a);
		service.submit(nf);
		service.shutdown();
		
		System.out.println(  "future task is done kkkk"  + futask.isDone());
		
		
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println(  "future task is done checked again "  + nf.isDone());
		System.out.println(  "future task is done checked again "  + nf.isDone());
		
	
	
	
		
		
		
	}
	

}
