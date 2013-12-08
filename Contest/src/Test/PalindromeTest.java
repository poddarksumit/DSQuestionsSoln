/**
 * 
 */
package Test;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * This class is used to
 * 
 * @author Sumit 24-Jan-2013
 * 
 */
public class PalindromeTest extends TestCase {

	@Test
	public void test1() {
		Palindrome palin = new Palindrome();
		assertEquals("", palin.longestPalindrome("Go deliver a dare vile dog"));

	}
}
