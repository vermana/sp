class B {

	public void method1() {

		synchronized (String.class) {

			System.out.println("Aquired lock on String.class object" + Thread.currentThread().getName());

			synchronized (Integer.class) {
				System.out.println("Aquired lock on Integer.class object" + Thread.currentThread().getName());

			}

		}

	} /*
	 *  * This method also requests same two lock but in exactly * Opposite order
	 * i.e. first Integer and then String. * This creates potential deadlock, if
	 * one thread holds String lock * and other holds Integer lock and they wait
	 * for each other, forever.
	 */

	public void method2() {

		synchronized (String.class) {
			System.out.println("Aquired lock on Integer.class object" + Thread.currentThread().getName());
			synchronized (Integer.class) {
				System.out.println("Aquired lock on String.class object" + Thread.currentThread().getName());
			}
		}
	}

}

public class FixedDeadLockDemo implements Runnable {

	B a;

	public FixedDeadLockDemo(B a) {
		this.a = a;
	}

	public static void main(String[] args) {

		B a = new B();

		Thread t1 = new Thread(new FixedDeadLockDemo(a));
		Thread t2 = new Thread(new FixedDeadLockDemo(a));

		t1.start();
		t2.start();

	}

	@Override
	public void run() {

		a.method1();
		a.method2();

	}

}
