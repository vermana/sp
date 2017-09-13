import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListTester {

	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String args[])
	{
		
		
		
		List<String> l=new ArrayList<>();
		
		
		l.add("aa");
		l.add("bb");
		l.add("cc");
		l.add("dd");
		l.add("ee");
		
		
		
		Iterator<String> it=l.iterator();
		
		while(it.hasNext())
			
		{
			
			
			
			if(it.next().equalsIgnoreCase("bb")){
				
				
				
				it.remove();
				l.add("zz");
				
			}
			
			
		}
		
		System.out.println( "Final list" + l);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
