package method.refrences;

interface IsReferable {
	 public void referenceDemo();
}

public class RefrenceDemo  {

	public static void commonMethod() {
		System.out.println("This method is already defined.");
	}

	public void implement() {

		// Anonymous class.
		IsReferable demoOne = new IsReferable() {
			@Override
			public void referenceDemo() {
				RefrenceDemo.commonMethod();
			}
		};
		demoOne.referenceDemo();

		// Lambda implementaion.
		IsReferable demo = () -> RefrenceDemo.commonMethod();
		demo.referenceDemo();

		// Method reference.
		IsReferable demoTwo = RefrenceDemo::commonMethod;
		demoTwo.referenceDemo();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		RefrenceDemo bm = new RefrenceDemo();
		
		bm.implement();
		
		
		
	}

}
