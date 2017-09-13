
class Ball {

	public Ball(String color) {
		super();
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	private String color;

}

public class ByValue {

	public void changeBallColor(Ball b) {

		b.setColor("Green");

	}

	public static void main(String[] args) {

		Ball red = new Ball("red");

		ByValue bv = new ByValue();

		bv.changeBallColor(red);

		System.out.println("Now the color is " + red.getColor());

	}

}
