package L15_July15.OOPS_Story1;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Jul-2019
 *
 */

public class StudentClient {

	public static void main(String[] args) {

		Student s = new Student();
		System.out.println(s.name);
		System.out.println(s.age);

		s.name = "Rohit";
		s.age = 10;

		System.out.println(s.name);
		System.out.println(s.age);

		Student s1 = s;
		s1.age = 100;
		System.out.println(s.age);

		Student s2 = new Student();
		System.out.println(s2.age);
		s2 = s1;

		Student s3 = new Student();
		s3.age = 10;
		s3.name = "A";

		Student s4 = new Student();
		s4.age = 20;
		s4.name = "B";

		Test1(s3, s4);
		System.out.println(s3.age + " " + s3.name);
		System.out.println(s4.age + " " + s4.name);

		// Test2(s3, s4);
		System.out.println(s3.age + " " + s3.name);
		System.out.println(s4.age + " " + s4.name);

		int myAge = 30;
		String myName = "C";

		// Test3(s3, s4.age, s4.name, myAge, myName);
		System.out.println(s3.age + " " + s3.name);
		System.out.println(s4.age + " " + s4.name);
		System.out.println(myAge + " " + myName);

		s.name = "Rohit";
		s.age = 100;

		s.introduceYourself();
		s.sayHi("Aman");

		Student s10 = new Student("ABC", 80);
		s10.introduceYourself();

	}

	public static void Test3(Student s, int age, String name, int myAge, String myName) {
		s.age = 0;
		s.name = "_";
		age = 0;
		name = "_";
		myAge = 0;
		myName = "_";
	}

	public static void Test2(Student s1, Student s2) {

		s2 = new Student();

		int tempa = s1.age;
		s1.age = s2.age;
		s2.age = tempa;

		s1 = new Student();

		String tempn = s1.name;
		s1.name = s2.name;
		s2.name = tempn;
	}

	public static void Test1(Student s1, Student s2) {
		Student temp = s1;
		s1 = s2;
		s2 = temp;
	}
}
