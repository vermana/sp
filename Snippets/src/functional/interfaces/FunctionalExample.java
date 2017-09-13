package functional.interfaces;

@FunctionalInterface
interface Function<A, B, Q, X, R> {
	// R is like Return, but doesn't have to be last in the list nor named R.
	public R apply(A a, B b, Q c, X x);
}

public class FunctionalExample {

	public static void main(String[] args) {

		Function<String, Integer, Double, Double, Double> multiAdder = (a, b,
				c, x) -> {
			return Double.parseDouble(a) + b + c + x;
		};

		System.out.println(multiAdder.apply("40", 6, 40.0, 90.0));

	}

}
