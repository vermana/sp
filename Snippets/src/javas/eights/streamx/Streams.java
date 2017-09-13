package javas.eights.streamx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Pen implements Comparable<Pen> {

	private String name;

	public String getName() {
		return name;
	}

	public Pen(String name, int price) {
		super();
		this.name = name;
		this.price = price;
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

	private int price;

	public String toString() {

		return this.getName() + "-" + this.getPrice();
	}

	public int compareTo(Pen p) {

		return this.getName().compareTo(p.getName()); // sorts ascending
		// return p.getName().compareTo(this.getName()); sorts descending

	}

}

class PenPriceComparator implements Comparator<Pen> {

	public int compare(Pen p1, Pen p2) {

		// return p1.getPrice()-p2.getPrice(); ascending

		return p2.getPrice() - p1.getPrice(); // descnding

	}

}

public class Streams {

	public static void main(String[] args) {

		Pen p1 = new Pen("Aen", 10);
		Pen p2 = new Pen("Ben", 11);
		Pen p3 = new Pen("Sen", 9);
		Pen p4 = new Pen("Ken", 3);
		Pen p5 = new Pen("Ken", 200);

		List<Pen> l = new ArrayList();

		l.add(p1);
		l.add(p2);
		l.add(p3);
		l.add(p4);
		l.add(p5);

		System.out.println("Final List" + l);

		System.out.println("Lenght of arraylist" + l.stream().count());

		List<Pen> pennames = l.stream().collect(Collectors.toList());

		System.out.println("List of Pen" + pennames);

		List<Pen> newlist = pennames.stream().limit(3)
				.collect(Collectors.toList());

		System.out.println("new List of Pen" + newlist);

		Collections.reverse(pennames);
		System.out.println("Reverse List of Pen" + pennames);

		List<Pen> last3 = pennames.stream().limit(3)
				.collect(Collectors.toList());

		System.out.println("List is ::" + last3);

		List<Pen> last5 = pennames.stream()
				.filter(o -> o.getName().startsWith("K"))
				.collect(Collectors.toList());

		System.out.println("List starting with A is ::" + last5);

		// price of all pens starting with K

		int pr = pennames.stream().filter(o -> o.getName().startsWith("K"))
				.mapToInt(p -> p.getPrice()).sum();

		System.out.println("Sum of pens starting with K is " + pr);

		// count of pens starting with K

		long count = pennames.stream().filter(o -> o.getName().startsWith("K"))
				.count();

		System.out.println("Count of pens starting with K is " + count);

		// pen starting with R

		List<Pen> prs = pennames.stream()
				.filter(o -> o.getName().startsWith("R"))
				.collect(Collectors.toList());

		System.out.println("pens R list" + prs);

		Long ps = pennames.stream().count();

		System.out.println("pennames size " + ps);

		// checks whether all the elements in a stream match the specific
		// predicate

		boolean pps = pennames.stream().allMatch(
				pl -> pl.getName().startsWith("K"));
		// boolean pps =
		// pennames.stream().filter(ll->ll.getName().startsWith("K")).allMatch(pl->pl.getName().startsWith("K"));

		System.out.println("Result is " + pps);

		List<Pen> sl = pennames.stream().sorted(new PenPriceComparator())
				.collect(Collectors.toList());

		System.out.println("Pens sorted with price" + sl);

		// using Com

		List<Pen> sortedname = pennames.stream().sorted()
				.collect(Collectors.toList());

		System.out.println("Pens sorted with price" + sortedname);

		List<String> names = pennames.stream().map(k -> k.getName()).limit(4)
				.collect(Collectors.toList());

		System.out.println("List of names" + names);

		Long ls = 1_7L;
		Long ld = 1_1L;

		System.out.println(ls + ld);

		// Lambda Expression for adding two numbers

		int g = 90;

		Supplier<Integer> sup = () -> {
			int x = 10;
			int y = 90;
			return x + y + g;
		};

		System.out.println("Sum of two numbers is " + sup.get());

		// Consumer : take a number and print its square

		// Long a= 10L;

		Consumer<Long> cons = (ph) -> {
			ph = ph * ph;
			System.out.println("Square is" + ph);
		};

		cons.accept(10L);

		// l=null;

		Pen op = l.stream().findFirst().get();

		System.out.println(op.getName());

		Pen pd = l.stream().parallel().findAny().get();

		System.out.println("findAny" + pd.getName());

		boolean pv = l.stream().isParallel();

		System.out.println("isParallel" + pv);

		Optional<Pen> p = l.stream().findFirst();

		// p=null;

		Pen nm = p.get();

		System.out.println("First element" + nm.getName());

		boolean prt = l.stream().allMatch(lp -> lp.getName().startsWith("A"));

		System.out.println("All start wi A" + prt);

		boolean jrt = l.stream().filter(k -> k.getName().startsWith("A"))
				.allMatch(lp -> lp.getName().startsWith("A"));

		System.out.println("All start wi A" + jrt);

		boolean none = l.stream().noneMatch(de -> de.getName().startsWith("Z"));

		System.out.println("none match result " + none);

		
		
		
		
		
		
		
		
		
		
		
	}

}
