package L32_Aug4.StaticStory;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Aug-2019
 *
 */

public class Student {

	String name;
	final int rollNo = 100;
	static int nos;

	public Student(String name) {
		nos++;
		// this.rollNo = 200;
		this.name = name;
	}

	// this ? yes
	// non static ? yes
	// static ? yes
	public final String getName() {

		System.out.println(nos);
		return name;
	}

	// this ? Not allowed
	// non static data members ? No
	// static fxn -> static
	public static int getNumberOfStudents() {
		return nos;
	}

}
