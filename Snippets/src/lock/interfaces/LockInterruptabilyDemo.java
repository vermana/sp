package lock.interfaces;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Wisher

{

	public void wish(String msg)

	{

		try {
			for (int i = 1; 1 < 5; i++) {
				System.out.println("Hello :" + msg);

			

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class MyWisherThread implements Runnable {

	private String mywish;

	private final  static  ReentrantLock r = new ReentrantLock(true);

	Wisher w  ;

	public MyWisherThread(Wisher ww,String mywish) {

		this.mywish = mywish;
		this.w=ww;
	}

	public void run() {


       	r.lock();
				System.out.println("LOCK  available *** "
						+ Thread.currentThread().getName());
				w.wish(this.mywish);
				
				r.unlock();
			/*} else {

				System.out.println("LOCK not available"
						+ Thread.currentThread().getName());

			}*/
	

		if (r.isHeldByCurrentThread()) {
			r.unlock();
		}

	}

}

public class LockInterruptabilyDemo {

	public static void main(String[] args) {

		Wisher w= new Wisher();
		
		Thread t1 = new Thread(new MyWisherThread(w,"Anubhav"));
		Thread t2 = new Thread(new MyWisherThread(w,"Ravi"));

		t1.start();
		t2.start();

	}

}
