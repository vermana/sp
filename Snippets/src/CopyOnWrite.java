import java.security.CodeSource;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class CopyOnWrite {

	
	
	
	public static void main(String args[])
	{
		
		
		
		List<String> l=new CopyOnWriteArrayList<>();
		
		
		l.add("aa");
		l.add("bb");
		l.add("cc");
		l.add("dd");
		l.add("ee");
		
		
		
		Iterator<String> it=l.iterator();
		
		while(it.hasNext())
			
		{
			
			
			
			if(it.next().equalsIgnoreCase("bb")){
				
				
				
			//	it.remove();
			//	l.add("zz");
				
			}
			
			
		}
		
		System.out.println( "Final list" + l);
		
		
		
		@SuppressWarnings("rawtypes")
		Class klass=System.class;
		
	//	CodeSource c = klass.getProtectionDomain().getCodeSource();
		
	//	System.out.println( "Jar is : "  + c.getLocation());
		
		
		int a=5;
		int gc=0;
		
		
		gc=(a<51)?3:4;
		
		System.out.println( "Ternary output" + gc);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
