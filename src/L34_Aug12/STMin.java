package L34_Aug12;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Aug-2019
 *
 */

public class STMin implements SegmentTreeI {

	@Override
	public int operation(int a, int b) {
		return Math.min(a, b);
	}

	@Override
	public int defaultValue() {
		return Integer.MAX_VALUE;
	}

}
