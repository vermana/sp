
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyCallable implements Callable<String> {

	private long waitTime;

	public MyCallable(int timeInMillis) {
		this.waitTime = timeInMillis;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(waitTime);

		System.out.println("Thread ...." + Thread.currentThread().getName());
		// return the thread name executing this callable task
		return Thread.currentThread().getName();
	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println(" RUN method is called");

	}

}

public class FutureTaskExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// converting a Callable into a Runnable by wrapping it into a
		// FutureTask
		Thread t = new Thread(new FutureTask(new MyCallable(1000)));

		FutureTask<String> f = new FutureTask<>(new MyCallable(0));

		Thread dt = new Thread(f);

		t.start();
		dt.start();

		// Callable c =

	}

}
