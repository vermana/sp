package supplier.java.eight;

import java.util.function.Predicate;

public class Predicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Predicate<Double> p= (g)-> g >4  ;
		
		System.out.println(  "value is " + p.test( 10.6d));
		

	}

}
