package method.refrences;

import java.util.function.Consumer;
import java.util.function.Function;

public class ArbitraryObjectMethodRefrence {

	public static void main(String[] args) {
	
	Consumer<String> stringPrinter=System.out::println;

	Consumer<String> stringPrinterLambda=(String s) -> System.out.println(s);
	
	
	stringPrinter.accept("Print from method reference based instance");
		
	
	stringPrinterLambda.accept("Print from instance created from Lambda");

	
	Function<String,String> stc = String::valueOf;
		 
	
	System.out.println(stc.apply("Anubhav"));
	
	

		
	}

}
