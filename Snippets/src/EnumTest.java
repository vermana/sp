
enum Domain {
	
	
ABC,
DEF,
GHI,
JKL

	
	
	
	
	
}







public class EnumTest {

	
	
	public static void main(String ...args)
	{
		
		
		System.out.println( " HIII..." + Domain.ABC.toString() + Domain.valueOf("ABC"));
		
		showValue(Domain.DEF);
		
		
		for (Domain d : Domain.values()){
			
			System.out.println( ":: " +d);
			
			
		}	
		
	}
	
	
	
	
	
	
	static void showValue(Domain d){
		
		if(d==Domain.DEF){
			
			System.out.println( " Value is def------" + Domain.valueOf("DEF"));
			
		}
		
	}
	
	
	
}
