package method.refrences;

import java.util.function.Consumer;

@FunctionalInterface
interface MyInterface {

	public void checkmethod();

}

public class RefrenceChecks {

	public static void myCommonMethod() {

		System.out.println(" Common method is being called ");

	}

	public static void main(String[] args) {

		// calling via lambda expression // calling static method

		MyInterface mi = () -> RefrenceChecks.myCommonMethod();

		mi.checkmethod();

		// Calling via Mehtod Refrence

		MyInterface mi2 = RefrenceChecks::myCommonMethod;

		mi2.checkmethod();

		MyInterface mi3 = new MyInterface() {

			public void checkmethod() {

				System.out.println("This is anonymous inner class");

				RefrenceChecks.myCommonMethod();

			}

		};

		mi3.checkmethod();
		
		
		

	}

}
