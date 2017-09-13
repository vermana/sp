
public class TestThread implements Runnable{
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Thread t= new Thread ( new TestThread());
		
		Thread t2= new Thread ( new TestThread());
		
		System.out.println( "main thread id" + Thread.currentThread().getId());
		t.start();
		t2.start();
		
		
		
		
	}

	@Override
	public void run() {
		
		System.out.println( "called thread id" + Thread.currentThread().getId());
		System.out.println( "HI from run");
		
	}

}
