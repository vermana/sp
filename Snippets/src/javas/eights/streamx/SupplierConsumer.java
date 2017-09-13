package javas.eights.streamx;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierConsumer {

	public static void main(String[] args) {
		
		
		
     Supplier<String> supplier = ()->{System.out.println("Executing lambda expression"); return new String("Anubhav"); };
		
		
		
		String h=supplier.get();
		
		System.out.println("the name is" + h);

	
		
		
		
		
	Consumer<Integer> integerConsumer = (i)->{ System.out.println("value if integer is : "  + i);        };
	
	
	      integerConsumer.accept(900);
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
