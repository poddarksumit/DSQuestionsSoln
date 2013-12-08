/**
 * 
 */
package array.test;

import junit.framework.TestCase;

import org.junit.Test;

import array.MinDistance;

/**
 * This class is used to
 * 
 * @author Sumit 20-Apr-2013
 * 
 */
public class MinDistanceTest extends TestCase {

	@Test
	public void test1() {
		MinDistance missingNo = new MinDistance();
		int[] arr = { 1, 2 };
		assertEquals(1, missingNo.getMinDistance(arr, 1, 2));
	}

	@Test
	public void test2() {
		MinDistance missingNo = new MinDistance();
		int[] arr = { 3, 4, 5 };
		assertEquals(2, missingNo.getMinDistance(arr, 3, 5));
	}

	@Test
	public void test3() {
		MinDistance missingNo = new MinDistance();
		int[] arr = { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 };
		assertEquals(4, missingNo.getMinDistance(arr, 3, 6));
	}

	@Test
	public void test4() {
		MinDistance missingNo = new MinDistance();
		int[] arr = { 2, 5, 3, 5, 4, 4, 2, 3 };
		assertEquals(1, missingNo.getMinDistance(arr, 3, 2));
	}
}
