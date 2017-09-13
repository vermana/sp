import java.util.HashMap;
import java.util.Map;

class Box {

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Box(String color, int price) {
		super();
		this.color = color;
		this.price = price;
	}

	private String color;

	private int price;

	public boolean equals(Object o) {

		//System.out.println( "hashcode executed" + this.getColor().hashCode()*17+11 );
		//if (o instanceof Box && ((Box) o).getColor().equals(this.getColor()))
		
		if (o instanceof Box && ((Box) o).getPrice()== this.getPrice()   )

			return true;
		else
			return false;

	}

	public int hashcode() {

		System.out.println( "hashcode executed" + this.getColor().hashCode()*17+11 );
		
		return this.getColor().hashCode()*17+11;
		
		
	}

}

public class Boxes {

	public static void main(String[] args) {
		
		
		Box r= new Box("red" ,12);
		Box g= new Box("green" ,12);
		
		System.out.println( "map ...");
		Map<Box,Integer> m= new HashMap<>();
		
		m.put(r, 1);
		m.put(g, 2);
		
		System.out.println( "map ..." +  m.get(0));
		
		
		
		
		
		
		
		
		/*
		if(r.equals(g)				){
			System.out.println( "BOX are same");
			
			
			
		}	else {
			
			System.out.println( "BOX are different");
		}
		
		*/
		

	}

}
