package threadpool.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Callable<Object> {

	public Object call() {

		System.out.println("MyTask is running .........  "
				+ Thread.currentThread().getName());

		// System.out.println( "current thread ..." +
		// Thread.currentThread().getName() );

		return null;
	}

}

class InterThread implements Runnable {

	public InterThread(boolean flag) {
		super();
		this.flag = flag;
	}

	private volatile  boolean flag = true;

	public void exit(boolean bExit) {
		this.flag = bExit;
	}

	public void run() {

		while (flag) {

			System.out.println(Thread.currentThread().getName()
					+ "Thread is running ....."
					+ Thread.currentThread().getState().toString());

			try {
				Thread.sleep(1000);
				System.out.println("state in run"
						+ Thread.currentThread().getState().toString());

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

public class CallableThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyTask a = new MyTask();
		MyTask b = new MyTask();
		MyTask c = new MyTask();
		MyTask d = new MyTask();

		ExecutorService service = Executors.newFixedThreadPool(3);

		service.submit(a);
		service.submit(b);
		service.submit(c);
		service.submit(d);

		InterThread tm = new InterThread(true);

		Thread tw = new Thread(tm, "GRAPES");

		Thread te = new Thread(new InterThread(true), "APPLE");

		tw.start(); 

		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 te.start();
		 tm.exit(false);
		 

	}

}
