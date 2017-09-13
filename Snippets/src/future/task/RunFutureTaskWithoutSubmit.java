package future.task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class RunFutureTaskWithoutSubmit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Wrapping Callable in a FutureTask

		FutureTask<Integer> i = new FutureTask<>(new Callable<Integer>() {
			public Integer call() {
				System.out.println("Inside the call...");
				return 12;
			}
		});

		i.run();

		try {
			System.out.println("The result of Futuretask  from callable : "
					+ i.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		// Wrapping Runnable in a FutureTask ******** HOW TO GET RETURN /RESULT
		// from Runnable in A FutureTask

		Integer u = 0; // unused

		FutureTask<Integer> i2 = new FutureTask<Integer>(new Runnable() {

			Integer ii = 0;

			public void run() {

				System.out.println(" inside Run method ...");
				ii++;

			}

			public void done() {

				ii = 10;

				// u=ii; ****** DOSENT WORKS

			}

		}, u);

		i2.run(); // running task via run method in Future

		try {
			System.out.println("The result of Futertask  from Runnable : "
					+ i2.get());

		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
