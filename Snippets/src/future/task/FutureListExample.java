package future.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


class Adder implements Callable<Integer> {

	private int a;

	public Adder(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	private int b;

	public Integer call() {

		return a+b;
		
		
	}

}

public class FutureListExample {
	
public static void main(String [] args){
ExecutorService service= Executors.newFixedThreadPool(3);
	
List<Future<Integer>> futureList=new ArrayList<>();

  for (int i=1;i<=20;i++)
  {
	  
	  Future<Integer> fe=service.submit(new Adder(i,i));
	  
	  futureList.add(fe); 
	  
	  
  }
	
	
  for(  Future<Integer> futureObject : futureList ){
	  
	  
	  try {
		System.out.println(  " sum is " + futureObject.get()) ;
	} catch (InterruptedException | ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
  

  service.shutdown();
  
  try {
	service.awaitTermination(100000, TimeUnit.SECONDS);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
  
  service.shutdownNow();
  
  
}
	
	

}
