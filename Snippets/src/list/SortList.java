package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Colors implements Comparable<Colors> {

	public Colors(String name, int price) {
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


public boolean equals(Object o)

{

	if(o instanceof Colors && ((Colors) o).name.equals(this.name))
		return true; 
	else 
		return false;
	
}


public int hashCode(){
	
	return this.getName().hashCode()+ 17 ;
	
}


public String  toString(){
	return this.name+"-"+this.price;
	
	
}

@Override
public int compareTo(Colors arg0) {
	
//	return arg0.name.compareTo(this.name);
	return this.name.compareTo(arg0.name);
		
	
}


}




class PriceSorter implements Comparator<Colors>
{
    public int compare( Colors c1,Colors c2){
		
		return c1.getPrice()-c2.getPrice();
		
		
	}



}

public class SortList {

	public static void main(String[] args) {

		Colors a=new Colors("Blue",900);
		Colors b=new Colors("Green",300);
		Colors c=new Colors("Red",400);
		Colors d=new Colors("Orange",500);
		
		
		List<Colors> list = new ArrayList<Colors>();
		
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		
		
System.out.println( "unsorted list " + list);	



if (a.equals(b)){
	System.out.println( "Colours are Same");
	
}else {
	System.out.println( "Colours are not Same");
	
}

Collections.sort(list);

System.out.println( "Sorted list " + list);	


Collections.sort(list, new PriceSorter());

System.out.println( "Sorted list on the basis of price " + list);

	}


}
