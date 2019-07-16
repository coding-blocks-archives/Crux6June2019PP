package L15_July15.OOPS_Story1;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Jul-2019
 *
 */

public class Person {

	private String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {

		if (age < 0) {
			throw new RuntimeException("Invalid Age.");
		}

		this.age = age;
	}

	public void fun(int age) {

		System.out.println("hi fun");
		setAge(age);
		System.out.println("bye fun");
	}

	public String toString() {
		return name + " " + age ;
	}
}
