import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	public static void main(String[] args) {
		BlockingQueue<String> bQueue = new ArrayBlockingQueue<String>(2);
		try {
	
			bQueue.put("Java");
			System.out.println("Item 1 inserted into BlockingQueue");
			bQueue.put("JDK");
			System.out.println("Item 2 is inserted on BlockingQueue");
	
			//bQueue.add("EDED");
			//bQueue.put("J2SE");
			System.out.println("Done");
	
		
		
			System.out.println("Try Complete...");
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println( " Inside the blocking Queue Catch Block");
			e.printStackTrace();
		}

		
		System.out.println("Main Complete...");
		
		
Iterator<String> ib =		bQueue.iterator();
		
while(ib.hasNext())
{
	
System.out.println( "value is  ::::: " + ib.next());

}
		

//BlockingQueue<String> abq = new ArrayBlockingQueue(Integer.MAX_VALUE);


//int leng =abq.size();

System.out.println( "Size is"+ Integer.MAX_VALUE);

System.out.println( "Size is"+ Integer.MIN_VALUE);


System.out.println( "Size is"+ Integer.compare(5, 1));







		
	}

}
