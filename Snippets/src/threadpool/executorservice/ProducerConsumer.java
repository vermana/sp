package threadpool.executorservice;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable

{

	List<Character> c;
	int max;

	Producer(List<Character> c, int max) {
		this.c = c;
		this.max = max;
	}

	public void run() {
		while(true){
		System.out.println("Running ...." + Thread.currentThread().getName()
				+ "size of queue : " + c.size());

		this.adder();

		System.out.println("Exitting ...." + Thread.currentThread().getName()
				+ "size of queue : " + c.size());
		}
	}

	private void adder() {

		while (c.size() == 5){

			synchronized (c) {

				{
					try {
						c.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

		}
		synchronized (c) {
			c.add('c');
			System.out.println("added ...." + c
					+ Thread.currentThread().getName() + "Queue size :"
					+ c.size());

			c.notifyAll();

		}

	}

}

class Consumer implements Runnable {

	List<Character> c;
	int max;

	Consumer(List<Character> c, int max) {
		this.c = c;
		this.max = max;
	}

	public void run() {
		
		while(true){
		System.out.println("Running ...." + Thread.currentThread().getName()
				+ "size of queue : " + c.size());
		remover();
		System.out.println("Exitting ...." + Thread.currentThread().getName()
				+ "size of queue : " + c.size());
		
		}
	}

	private void remover()

	{

		while (c.isEmpty()) {
			synchronized (c) {

				try {
					c.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		synchronized (c) {

	
			c.remove(0);
			c.notifyAll();
			
		}

	}

}

public class ProducerConsumer {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		List<Character> cl = new ArrayList();

		int max = 5;

		Consumer c = new Consumer(cl, max);

		Producer p = new Producer(cl, max);

		Thread t1 = new Thread(c, "Consumer Thread");

		Thread t2 = new Thread(p, "Producer Thread");

		t1.start();
		t2.start();

	}

}
