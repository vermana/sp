package threadpool.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class Calcus implements Callable <Integer>
{
	
	
	public Calcus(int i) {
		//super();
		this.i = i;
	}




	int i;
	
	
	
	
public Integer call(){
	
	//
	int i=this.i;
	return ++i;
	
	
}

}




public class ThPool {

	
	
	
	public static void main(String[] args) {

	
		Calcus c=new Calcus(3);
		Calcus d=new Calcus(4);
		Calcus e=new Calcus(5);
		
		
	ExecutorService service = Executors.newFixedThreadPool(10);
	
	Future <Integer> cc = service.submit(c);
	Future <Integer> dd = service.submit(d);
	Future <Integer> ee = service.submit(e);
	
	
	
	try {
		System.out.println( "C thread" + cc.get().intValue());
	
		System.out.println( "d thread" + dd.get().intValue());	
		
		System.out.println( "e thread" + ee.get().intValue());
	
	
	
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (ExecutionException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
