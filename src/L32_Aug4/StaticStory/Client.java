package L32_Aug4.StaticStory;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Aug-2019
 *
 */

public class Client {

	public static void main(String[] args) {

		Student s1 = new Student("A");
		Student s2 = new Student("B");

		System.out.println(s1.getName());
		System.out.println(s2.getName());

		System.out.println(Student.nos);

		System.out.println(Student.getNumberOfStudents());

	}
}
