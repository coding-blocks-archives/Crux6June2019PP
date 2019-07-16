package L16_July16;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Jul-2019
 *
 */

public class DSClient {

	public static void main(String[] args) throws Exception {

		DynamicStack ds = new DynamicStack();
		ds.push(10);
		ds.push(20);
		ds.push(30);
		ds.push(40);
		ds.push(50);
		ds.push(60);
		ds.push(70);

		System.out.println("--- Display Reverse ---");
		ds.display();
		displayReverse(ds);
		ds.display();

		System.out.println("--- Actual Reverse ---");
		ds.display();
		actualReverse(ds, new DynamicStack());
		ds.display();

		System.out.println("--- NGE ---");
		int[] arr = { 30, 20, 10, 5, 25, 15, 45, 37, 28, 42 };
		nextGreaterElement(arr);

	}

	public static void displayReverse(DynamicStack stack) throws Exception {

		if (stack.isEmpty()) {
			return;
		}

		int temp = stack.pop();

		displayReverse(stack);

		System.out.println(temp);
		stack.push(temp);

	}

	public static void actualReverse(DynamicStack stack, DynamicStack helper) throws Exception {

		if (stack.isEmpty()) {
			actualReverse2(stack, helper);
			return;
		}

		int temp = stack.pop();
		helper.push(temp);
		actualReverse(stack, helper);

	}

	public static void actualReverse2(DynamicStack stack, DynamicStack helper) throws Exception {

		if (helper.isEmpty()) {
			return;
		}

		int temp = helper.pop();
		actualReverse2(stack, helper);
		stack.push(temp);

	}

	public static void nextGreaterElement(int[] arr) throws Exception {

		DynamicStack stack = new DynamicStack();

		for (int i = 0; i < arr.length; i++) {

			while (!stack.isEmpty() && stack.top() < arr[i]) {
				System.out.println(stack.pop() + " -> " + arr[i]);
			}

			stack.push(arr[i]);
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + " -> -1");
		}
	}

}
