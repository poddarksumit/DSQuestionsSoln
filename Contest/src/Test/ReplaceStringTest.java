/**
 * 
 */
package Test;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * This class is used to
 * 
 * @author Sumit 21-Jan-2013
 * 
 */
public class ReplaceStringTest extends TestCase {

	@Test
	public void test1() {
		ReplaceString rep = new ReplaceString("suimitpoditpdaritp");
		assertEquals("suimtipodtipdartip", rep.replace("itp", "tip"));
	}

	@Test
	public void test2() {
		ReplaceString rep = new ReplaceString(null);
		assertEquals("NA", rep.replace("itp", "tip"));
	}

	@Test
	public void test3() {
		ReplaceString rep = new ReplaceString("");
		assertEquals("NA", rep.replace("itp", "tip"));
	}

	@Test
	public void test4() {
		ReplaceString rep = new ReplaceString("suimitpoditpdaritp");
		assertEquals("suimitpoditpdaritp", rep.replace("ppp", "tip"));
	}

	@Test
	public void test5() {
		ReplaceString rep = new ReplaceString("I am Sumit Kumar Poddar");
		assertEquals("This is Aumit Kumar Poddar",
				rep.replace("I am S", "This is A"));
	}

	@Test
	public void test6() {
		ReplaceString rep = new ReplaceString("I am Sumit Kumar Poddar");
		assertEquals("Cumit Kumar Poddar", rep.replace("I am S", 'C'));
	}

	@Test
	public void test7() {
		ReplaceString rep = new ReplaceString("suimitpoditpdaritp");
		assertEquals("suimtipodtipdartip", rep.replace("itp", "tip"));
	}
}
