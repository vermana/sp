package lambdas;

class Bag implements Cloneable {

	private String Color;

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public Bag(String color, int price) {
		super();
		Color = color;
		Price = price;
	}

	private int Price;

	@Override
	public Object clone() {
		Bag b = null;
		try {
			b = (Bag) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;

	}

}

public class ShallowCloning {

	public static void main(String[] args) {

		Bag b = new Bag("Black", 12);
		Bag g = new Bag("Green", 12);
		Bag y = new Bag("Yellow", 12);

		Bag r = (Bag) g.clone();

		System.out.println("copied object : " + r.getColor());
		
		g.setColor("Orange");
		
		System.out.println("orignal object : " + g.getColor());
		System.out.println("copied object : " + r.getColor());
		
		
		

	}

}
