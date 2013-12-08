/**
 * 
 */
package techgig.rollingDice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * This class is used to
 * 
 * @author Sumit 29-Jul-2012
 * 
 */
public class RollingDiceTest extends TestCase {

	@Test
	public void testGetCount() {
		RollingDice rolDice = new RollingDice();
		List<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> listMap = new HashMap<Integer, Integer>();
		list.add(5);
		list.add(12);
		list.add(5);
		list.add(7);
		list.add(11);
		list.add(2);
		list.add(11);
		System.out.println(rolDice.getCount(list));

	}

	@Test
	public void testConvertStringToList() {
		RollingDice rolDice = new RollingDice();
		String listOneString = "{ 12, 11, 5, 2, 7, 5, 11}";
		rolDice.convertStringToList(listOneString);
	}
}
