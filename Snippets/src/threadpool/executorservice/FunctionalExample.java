package threadpool.executorservice;

@FunctionalInterface
interface Function<A, B, Q, R> {
	// R is like Return, but doesn't have to be last in the list nor named R.
	public R apply(A a, B b, Q c);
}

public class FunctionalExample {

	public static void main(String[] args) {

		Function<String, Integer, Double, Double> multiAdder = (a, b, c) -> {
			return Double.parseDouble(a) + b + c;
		};

		System.out.println(multiAdder.apply("40", 6, 40.0));

	}

}
