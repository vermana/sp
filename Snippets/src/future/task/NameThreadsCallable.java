package future.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class AdderTwo implements Callable<Map<String, List<Integer>>> {

	public AdderTwo(String threadName, int x, int y) {
		this.threadName = threadName;
		this.x = x;
		this.y = y;
	}

	public AdderTwo(String string, List<Integer> even) {
	this.threadName=string;
	
	x=even.get(0);
	y=even.get(1);
	
	}

	private String threadName;
	private int x;

	private int y;

	public Map<String, List<Integer>> call() {

		Map<String, List<Integer>> mp = new HashMap<>();
		System.out.println("running Callable thread ...." + threadName);

		List<Integer> l = new ArrayList<>();
		l.add(x);
		l.add(y);

		mp.put(threadName, l);
		return mp;

	}

}

public class NameThreadsCallable {

	public static void main(String[] args) {

		List<Integer> even=new ArrayList<>();
		
		even.add(2);
		even.add(4);
		
		List<Integer> odd=new ArrayList<>();
		odd.add(3);
		odd.add(5);
		
		
		AdderTwo ad =new AdderTwo("Thread even",even);
		
		AdderTwo ed =new AdderTwo("Thread odd",odd);
		
		ExecutorService service =Executors.newFixedThreadPool(1);
		
        service.submit(ad);
		
		service.submit(ed);
		
		//service.shutdown();
		
		try {
			service.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
