package latch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class CabService implements Callable<Boolean> {

	private CyclicBarrier b;
	private String cabName;

	public CabService(CyclicBarrier b, String cabName) {
		this.b = b;
		this.cabName = cabName;
	}

	public Boolean call() {

		System.out.println("Booking passenger one by CAB... " + cabName + "barrier waiting for parties" + b.getNumberWaiting());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			try {
				b.await(1000, TimeUnit.SECONDS);
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Booking passenger one by CAB... completed "
				+ cabName  +" barrier waiting for paties" + b.getNumberWaiting());

		return true;

	}

}

public class CyclicBarrierTest {

	public static void main(String... args) {

		CyclicBarrier bb = new CyclicBarrier(1);

		CabService i = new CabService(bb, "Innova");
		CabService h = new CabService(bb, "Honda");
		CabService s = new CabService(bb, "Suzuki");
		CabService b = new CabService(bb, "BMW");

		ExecutorService service = Executors.newFixedThreadPool(4);

		service.submit(i);
		service.submit(h);
		service.submit(s);
		service.submit(b);

		service.shutdown();

	}

}
