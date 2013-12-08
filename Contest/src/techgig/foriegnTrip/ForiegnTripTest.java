/**
 * 
 */
package techgig.foriegnTrip;

import java.util.ArrayList;
import java.util.HashMap;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * This class is used to
 * 
 * @author Sumit 31-Aug-2012
 * 
 */
public class ForiegnTripTest extends TestCase {

	@Test
	public void testApplyRegexToBreak() {
		String testData = "{(1,2),(2,3),(3,4)}";
		HashMap<Integer, ArrayList<String>> hashMap = new HashMap<Integer, ArrayList<String>>();
		ForiegnTrip.applyRegexToBreak(testData, hashMap);
	}
}
