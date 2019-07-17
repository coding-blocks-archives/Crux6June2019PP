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
		int[] ans = nextGreaterElement2(arr);

		for (int i = 0; i < ans.length; i++) {
			System.out.println(arr[i] + " -> " + ans[i]);
		}

		System.out.println("-- Stock Span --");
		int[] stock = { 50, 35, 5, 70, 7, 3, 40, 37, 45, 7 };
		int[] span = stockSpan(stock);

		for (int i = 0; i < span.length; i++) {
			System.out.println(span[i]);
		}

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

	public static int[] nextGreaterElement2(int[] arr) throws Exception {

		int[] ans = new int[arr.length];

		DynamicStack stack = new DynamicStack();

		for (int i = 0; i < arr.length; i++) {

			while (!stack.isEmpty() && arr[stack.top()] < arr[i]) {
				ans[stack.pop()] = arr[i];
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}

		return ans;
	}

	public static int[] stockSpan(int[] arr) throws Exception {

		int[] ans = new int[arr.length];

		DynamicStack stack = new DynamicStack();

		for (int i = 0; i < arr.length; i++) {

			while (!stack.isEmpty() && arr[i] > arr[stack.top()]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				ans[i] = i + 1;
			} else {
				ans[i] = i - stack.top();
			}

			stack.push(i);

		}

		return ans;

	}

}
