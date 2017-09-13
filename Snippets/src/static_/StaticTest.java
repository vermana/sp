package static_;

class App {

	private int a;

	public void checker2() {

		System.out.println("Hiii");

	}

	public static void checker(App a) {

		System.out.println("oopopop");

		a.checker2();

	}

}

public class StaticTest {

	public static void main(String... args)

	{

		App pl = new App();

		pl.checker(pl);

	}

}
