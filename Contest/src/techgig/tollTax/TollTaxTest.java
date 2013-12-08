/**
 * 
 */
package techgig.tollTax;

import java.util.HashMap;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to
 * 
 * @author Sumit 18-Jul-2012
 * 
 */
public class TollTaxTest extends TestCase {

	@Before
	public void init() {
	}

	@Test
	public void testRegex1() {
		String roadPrice = "(A,B,4)";
		RoadDetails roadDetailsObjected = new RoadDetails();
		roadDetailsObjected.setCity1("A");
		roadDetailsObjected.setCity2("B");
		roadDetailsObjected.setPrice(4);
		RoadDetails roadDetailsactual = TollTax.getRoadDetails(roadPrice);
		assertEquals(roadDetailsObjected.getCity1(),
				roadDetailsactual.getCity1());
		assertEquals(roadDetailsObjected.getCity2(),
				roadDetailsactual.getCity2());
		assertEquals(roadDetailsObjected.getPrice(),
				roadDetailsactual.getPrice());
	}

	@Test
	public void testMatrix() {
		TollTax tax = new TollTax();
		String[] nameOfCities = { "A", "B", "C", "D", "E", "F" };
		int noOfRoad = 7;
		String[] pricePerRoad = { "(A,B,4)", "(B,C,2)", "(C,D,3)", "(B,D,6)",
				"(B,E,9)", "(D,F,5)", "(E,F,4)" };
		String[] startNEndPt = { "A", "F" };
		tax.getPath(startNEndPt, noOfRoad, nameOfCities, pricePerRoad);
	}

	@Test
	public void testGetMinPrice() {
		HashMap<String, Integer> priceDetails = new HashMap<String, Integer>();
		priceDetails.put("1", 14);
		priceDetails.put("2", 8);
		priceDetails.put("3", 7);
		priceDetails.put("4", 9);
		assertEquals(7, TollTax.getMinPrice(priceDetails));

	}

	@Test
	public void testGetMinPrice1() {
		HashMap<String, Integer> priceDetails = new HashMap<String, Integer>();
		priceDetails.put("1", 7);
		priceDetails.put("2", 8);
		priceDetails.put("3", 7);
		priceDetails.put("4", 9);
		assertEquals(8, TollTax.getMinPrice(priceDetails));

	}

	@Test
	public void testSwapCities() {
		RoadDetails road = new RoadDetails();
		road.setCity1("A");
		road.setCity2("D");
		road.setPrice(10);
		road = new RoadDetails(road);
		RoadDetails road1 = road.swapCities();
		assertEquals(road, road1);
	}
}
