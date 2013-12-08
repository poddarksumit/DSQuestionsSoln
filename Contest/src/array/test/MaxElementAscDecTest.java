/**
 * 
 */
package array.test;

import junit.framework.TestCase;

import org.junit.Before;

import array.MaxElementAscDec;

/**
 * This class is used to
 * 
 * @author Sumit 01-May-2013
 * 
 */
public class MaxElementAscDecTest extends TestCase {

	MaxElementAscDec maxElement;

	@Override
	@Before
	public void setUp() {
		maxElement = new MaxElementAscDec();
	}

	public void testMaxAscDesc_1() {
		int[] array = { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1 };
		assertEquals(500, maxElement.maxAscDesc(array, 0, array.length - 1, 0));
	}

	public void testMaxAscDesc_2() {
		int[] array = { 1, 3, 50, 10, 9, 7, 6 };
		assertEquals(50, maxElement.maxAscDesc(array, 0, array.length - 1, 0));
	}

	public void testMaxAscDesc_3() {
		int[] array = { 10, 20, 30, 40, 50 };
		assertEquals(50, maxElement.maxAscDesc(array, 0, array.length - 1, 0));
	}

	public void testMaxAscDesc_4() {
		int[] array = { 120, 100, 80, 20, 0 };
		assertEquals(120, maxElement.maxAscDesc(array, 0, array.length - 1, 0));
	}
}
