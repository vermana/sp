
public class ThreadLocalBestDemo {

	public static class Mylocal {

		double i;

		public double getI() {
			return i;
		}

		public void setI(double d) {
			this.i = d;
		}

	}

	public static class MyRunnable implements Runnable {

		private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

		private Mylocal m = new Mylocal();

		@Override
		public void run() {
			threadLocal.set((int) (Math.random() * 100D));
			m.setI(Math.random() * 100D);
			

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}

			System.out.println("threadlocal  "+threadLocal.get());
			System.out.println("non - threadlocal "+ m.getI());
		}
	}

	
	
	public static void main(String[] args) {
		MyRunnable sharedRunnableInstance = new MyRunnable();

		Thread thread1 = new Thread(sharedRunnableInstance);
		Thread thread2 = new Thread(sharedRunnableInstance);

		thread1.start();
		thread2.start();

		try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // wait for thread 1 to terminate
		try {
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // wait for thread 2 to terminate
	}

}