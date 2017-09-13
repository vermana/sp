package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedList {

	
	private static List <String> g;
	
	
	
	public static void main(String[] args) {
	
	
	
	
	
	List <String> g= new ArrayList();
	
	g.add("aa");
	g.add("bb");
	g.add("cc");
	g.add("dd");
	
//	g.l
	
	// Collections.synchronizedList(g);
	

	
	Thread t1=new Thread(new Runnable(){
		public void run(){
			System.out.println( "Thread 1 removing "); 
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.remove(1);
			
			System.out.println( "Thread 1 has removed "); 
			
			} 
		});
	
	
	Thread t2=new Thread(new Runnable(){
		public void run(){
			System.out.println( "Thread 2 removing"); 
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.remove(1);
			System.out.println( "Thread 2 has removed "); 
		} 
		});
	

	
	
	t1.start();
	
	/*try {
		t1.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	t2.start();
	
/*	try {
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	System.out.println( " Final list : " + g );
	
	System.out.println( "t1 Thread state " + t1.isAlive() );
	System.out.println( "t2 Thread state " + t2.isAlive() );
	
	
	System.out.println( "t2 Thread state " + t1.getStackTrace());
	
	
	
	}

}







