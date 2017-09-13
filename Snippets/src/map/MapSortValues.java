package map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class Cell

{

	public Cell(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	private String name;
	private int price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean equals(Object o) {

		if (o instanceof Cell && ((Cell) o).name.equals(this.name))

			return true;
		else
			return false;

	}

	public int hashCode() {
		return 17 + this.getName().hashCode();

	}

	public String toString() {
		return this.name + "-" + this.price;

	}

}

public class MapSortValues {
	public static void main(String... args) {

		Cell a = new Cell("Dura", 12);
		Cell b = new Cell("Fed", 10);
		Cell c = new Cell("Bet", 14);
		Cell d = new Cell("Con", 150);
		Cell e = new Cell("Mod", 104);

		Map<Long, Cell> p = new HashMap();

		p.put(1L, a);
		p.put(2L, b);
		p.put(3L, c);
		p.put(4L, d);
		p.put(5L, e);

		System.out.println("MAP is" + p);
		
		
	Set <Entry<Long, Cell>> me=p.entrySet();  //1
		
	List<Entry<Long,Cell>> al= new ArrayList(me); //2 	
	
	
	
	
	// sor the entryset list
	
	Collections.sort( al, new Comparator<Entry<Long, Cell>>()
	        {
	            public int compare( Entry<Long, Cell> o1, Entry<Long, Cell> o2 )
	            {
	              
	            	return o1.getValue().getName().compareTo(o2.getValue().getName());     // asc
	            	//return o2.getValue().getName().compareTo(o1.getValue().getName());  //desc
	            	
	            }
	        } );
	
	
	System.out.println("---------------" );		
	System.out.println("MAP is" + p);	
		
  Map <Long,Cell> m2 = new LinkedHashMap();
  
  
  for( Entry<Long,Cell> en : al   ){
	  
	  
m2.put(en.getKey(), en.getValue());
	  
	  
  }
  
  
  
  Map <Integer,String> mpe= new HashMap(32);
  
  
  System.out.println("Size is" +mpe.size());
  
  
  
  System.out.println("--------FINAL----MAP-------" );		
	System.out.println("MAP is" + m2);	
  
		
	System.out.println("--------FINAL----MAP SORTED ON KEYS -------" );
	
	Map <Long,Cell> k= new TreeMap(m2);
	
	System.out.println("MAP is" + k);	
	
		
 ThreadGroup fir =new ThreadGroup("First");
 
		
		Thread uu= new Thread(fir,"Grey");
		
		
		uu.start();
		
		System.out.println("status" + uu.isAlive());
		
		uu.interrupt();
		
	
		System.out.println("status" + uu.isAlive());
		
		System.out.println("status" + uu.isInterrupted());
		
		
		

	}

}
