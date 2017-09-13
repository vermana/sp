class A {

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

		synchronized (Integer.class) {
			System.out.println("Aquired lock on Integer.class object" + Thread.currentThread().getName());
			synchronized (String.class) {
				System.out.println("Aquired lock on String.class object" + Thread.currentThread().getName());
			}
		}
	}

}

public class DeadLockDemo implements Runnable {

	A a;

	public DeadLockDemo(A a) {
		this.a = a;
	}

	public static void main(String[] args) {

		A a = new A();

		Thread t1 = new Thread(new DeadLockDemo(a));
		Thread t2 = new Thread(new DeadLockDemo(a));

		t1.start();
		t2.start();

	}

	@Override
	public void run() {

		a.method1();
		a.method2();

	}

}
