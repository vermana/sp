import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;

class Manager implements Serializable {

	public Manager() {
	}

	public Manager(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	private String name;

	private static int perksCount;

	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static int getPerksCount() {
		return perksCount;
	}

	public static void setPerksCount(int perksCount) {
		Manager.perksCount = perksCount;
	}

}

public class Serializer {

	// dbMap method // virtual DB
	private static Map<Integer, Manager> dbMap()

	{
		Map<Integer, Manager> mp = new HashMap<>();

		mp.put(1, new Manager("Anubhav", 120));
		mp.put(2, new Manager("jax", 100));
		mp.put(3, new Manager("jhony", 115));
		mp.put(4, new Manager("Cyrax", 112));
		mp.put(5, new Manager("Striker", 113));

		mp.forEach((k, v) -> {
			System.out.println("inside..." + k + v.getName());
		});

		return mp;

	}

	public static void main(String[] args) {

		try {

			Manager m = new Manager();
			m.setName("Anubhav");
			m.setAge(120);

			Manager.setPerksCount(12);

			FileOutputStream fs = new FileOutputStream("Object.ser");

			ObjectOutputStream ob = new ObjectOutputStream(fs);

			Map pp = dbMap();

			Set<Map.Entry<Integer, Manager>> p = (Set<Entry<Integer, Manager>>) pp
					.entrySet();

			p.forEach((entry) -> {
				System.out.println("Manager key " + entry.getKey());

				System.out.println("Manager key " + entry.getValue().getName());
			});

			// p.forEach((k,v->{System.out.println("Item : " + k + " Count : " +
			// v)});

			p.forEach(e -> System.out.println("Item : " + e.getKey()
					+ " Count : " + e.getValue().getName()));

			ob.writeObject(m);

			ob.close();
			fs.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Deserialization

		try {
			FileInputStream fi = new FileInputStream("Object.ser");

			ObjectInputStream obe = new ObjectInputStream(fi);

			try {
				Manager mn = (Manager) obe.readObject();

				System.out.println("Manager Object Deserialized "
						+ mn.getName());

				System.out
						.println("Manager Object Deserialized " + mn.getAge());

				System.out.println("Manager Object Deserialized static "
						+ mn.getPerksCount());

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
