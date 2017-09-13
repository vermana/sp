package latch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Race implements Callable<Boolean> {

	private CountDownLatch clatch;

	private String carName;

	public Boolean call() {

		System.out.println(" Calling car" + carName + " one .... ");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Car " + carName + " has arrived ");
		clatch.countDown();
		return true;

	}

	public Race(CountDownLatch clatch, String carName) {
		super();
		this.clatch = clatch;
		this.carName = carName;
	}

}

public class LatchExample {

	public static void main(String[] args) {

		CountDownLatch clatch = new CountDownLatch(4);

		System.out.println("Printing  initial latch count  *** "
				+ clatch.getCount());

		Race red = new Race(clatch, "Red");
		Race green = new Race(clatch, "Green");
		Race yellow = new Race(clatch, "Yellow");
		Race blue = new Race(clatch, "Blue");

		ExecutorService service = Executors.newFixedThreadPool(4);

		service.submit(red);
		service.submit(green);
		service.submit(yellow);
		service.submit(blue);

		try {
			clatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("All the cabs have arrived now ...");

		System.out.println("Printing  latch count" + clatch.getCount());
		service.shutdown();

	}

}
