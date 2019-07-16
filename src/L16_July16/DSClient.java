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
		actualReverse(ds);
		ds.display();
		
	}
	
	public static void displayReverse(DynamicStack stack) {
		
	}
	
	public static void actualReverse(DynamicStack stack) {
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}




