package threadpool.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class MessagePrinter implements Callable<Boolean> {

	private String name;

	public MessagePrinter(String name) {
		super();
		this.name = name;
	}

	public Boolean call() {
		System.out.println("Hello... " + name);
		return true;
	}

}


class MusicPlayer  implements Runnable{ public void run(){ System.out.println(" Task playing music");  } }


public class ScheduledThreadPool {

	public static void main(String[] args) {

		MessagePrinter cyrax = new MessagePrinter("Cyrax");
		MessagePrinter jhon = new MessagePrinter("Jhon");
		MessagePrinter cage = new MessagePrinter("Cage");

		ScheduledExecutorService service = Executors.newScheduledThreadPool(3);

		service.schedule(cyrax, 5, TimeUnit.SECONDS);

		service.schedule(jhon, 10, TimeUnit.SECONDS);

		service.schedule(cage, 15, TimeUnit.SECONDS);

		// Each Task is scheduled at the various delays of intervals

		service.shutdown();

		ScheduledExecutorService ser = Executors.newScheduledThreadPool(2);
		
		// ser.scheduleAtFixedRate(new FutureTask(cyrax), 5, 2, TimeUnit.SECONDS);   // This will not work is its not actual runnable but a coverted runnable 
		// So it gets shcheduled for runnning once only.
		
		ser.scheduleAtFixedRate(new MusicPlayer(), 5, 2, TimeUnit.SECONDS); // works well
		
		
		
		
		
		
	}
}
