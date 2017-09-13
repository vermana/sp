interface Interface1 {
	
	public void add();
	
	
}

interface Interface2 {
	
	public void add();
	
	
}






interface Interface3 extends Interface2
{
	
        //  public 
}

class ims implements Interface1,Interface2
{

	@Override
	public void add() {
		System.out.println(" Implemented method  of ims");
		
	}
	

}








public class Daimond implements Interface1,Interface2 {

	public static void main(String[] args) {
		
		
		ims im= new ims();
		
		im.add();
		
		
		
		
		
		

	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
		
		System.out.println( "Implemeted method");
		
		
	}

}
