package completeable.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureBasicExample {

	public static void main(String[] args) {

		// Task to print concatinated result of String objects with a | as a
		// delimeter

		CompletableFuture<String> completeableFuture = new CompletableFuture<>();

		List<String> l = new ArrayList<>();

		l.add("AA");
		l.add("BB");
		l.add("CC");
		l.add("DD");

		completeableFuture = calculateAsync(l);

		try {

			System.out.println("Final output of CompletableFuture "
					+ completeableFuture.get());
		} catch (InterruptedException | ExecutionException e) {

			e.printStackTrace();
		}

	}

	private static CompletableFuture<String> calculateAsync(
			List<String> listOfString) {

		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		ExecutorService service = Executors.newFixedThreadPool(2);

		service.submit(() -> {
			String finalResult = String.join("|", listOfString);
			completableFuture.complete(finalResult);
		});

		service.shutdown();

		return completableFuture;

	}

}
