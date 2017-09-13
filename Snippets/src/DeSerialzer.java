import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class DeSerialzer {

	public static void main(String[] args) {

		
		
		
		// Deserialization
		
		
		try {
			FileInputStream fi = new FileInputStream("Object.ser");
			
			ObjectInputStream obe =new ObjectInputStream(fi);
			
			
			
			try {
				Manager mn = (Manager)obe.readObject();
		
				
				
				System.out.println( "Manager Object Deserialized "  + mn.getName() );
				
				System.out.println( "Manager Object Deserialized "  + mn.getAge() );
				
				System.out.println( "Manager Object Deserialized static "  + mn.getPerksCount() );
				
				obe.close();
				
				fi.close();
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
