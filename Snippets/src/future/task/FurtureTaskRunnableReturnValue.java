package future.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FurtureTaskRunnableReturnValue {

	public static void main(String[] args) {

		// Task to add two numbers

		Integer i = 9;

		FutureTask<Integer> futureTask = new FutureTask<>(() -> {
			System.out.println("Inside the 1st Run method : Thread Name : "
					+ Thread.currentThread().getName());
		}, i);

		futureTask.run();

		try {
			System.out.println("Getting the value of Runnable  : "
					+ futureTask.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FutureTask<String> futureString = new FutureTask<>(() -> {
			System.out.println("Inside the 2 nd Run method : Thread Name : "
					+ Thread.currentThread().getName());

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}, "Task Successfully Completed");

		futureString.run();

		if (futureString.isDone())

		{

			try {
				System.out.println("Getting the value of next Runnable  : "
						+ futureString.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
