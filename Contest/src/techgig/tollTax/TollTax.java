/**
 * 
 */
package techgig.tollTax;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used to
 * 
 * @author Sumit 13-Jul-2012
 * 
 */
public class TollTax {

	public final static String DOT = ".";
	public final static String CITY_1 = "CITY1";
	public final static String CITY_2 = "CITY2";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] nameOfCities = { "A", "B", "C", "D", "E", "F" };
		int noOfRoad = 7;
		String[] pricePerRoad = { "(A,B,4)", "(B,C,2)", "(C,D,3)", "(B,D,6)",
				"(B,E,9)", "(D,F,5)", "(E,F,4)" };
		String[] startNEndPt = { "A", "F" };
		int finalPrice = init(nameOfCities, noOfRoad, pricePerRoad, startNEndPt);
		System.out.println("Final Price is :" + finalPrice);
	}

	private static int init(String[] nameOfCities, int noOfRoad,
			String[] pricePerRoad, String[] startNEndPt) {
		// PricePerRoad roadPriceObject = tax.new PricePerRoad(pricePerRoad);
		return getPath(startNEndPt, noOfRoad, nameOfCities, pricePerRoad);
	}

	public static int getPath(String[] startNEndPt, int noOfRoad,
			String[] nameOfCities, String[] pricePerRoad) {
		HashMap<Integer, RoadDetails> roadDetailMap = new HashMap<Integer, RoadDetails>();
		HashMap<String, Integer> priceDetails = new HashMap<String, Integer>();
		String startPt = startNEndPt[0];
		String endPt = startNEndPt[1];
		String[][] stringArray = getMatrix(noOfRoad, nameOfCities,
				pricePerRoad, roadDetailMap);
		process(roadDetailMap, stringArray, startPt, endPt, priceDetails);
		return getMinPrice(priceDetails);
	}

	public static void process(HashMap<Integer, RoadDetails> roadDetailMap,
			String[][] stringArray, String startPt, String endPt,
			HashMap<String, Integer> priceDetails) {
		for (int row = 1; row <= roadDetailMap.size(); row++) {
			RoadDetails details = roadDetailMap.get(row);
			if ((details.getCity1().equals(startPt))) {
				String track1 = Integer.toString(row) + ",";
				goAhead(details, roadDetailMap, endPt, row, track1,
						priceDetails);
			}

		}

	}

	public static void goAhead(RoadDetails details,
			HashMap<Integer, RoadDetails> roadDetailMap, String endPt,
			int currentRow, String track1, HashMap<String, Integer> priceDetails) {
		RoadDetails roadDetailsCurrent = details;
		HashMap<String, List<Integer>> allPathForCity = checkForAllPath(
				roadDetailsCurrent, roadDetailMap);
		List<Integer> pathList = allPathForCity.get(CITY_1);
		processWithPathList(pathList, track1, roadDetailMap, priceDetails,
				endPt, roadDetailsCurrent, CITY_1);
		pathList = allPathForCity.get(CITY_2);
		processWithPathList(pathList, track1, roadDetailMap, priceDetails,
				endPt, roadDetailsCurrent, CITY_2);
	}

	public static void processWithPathList(List<Integer> pathList,
			String track1, HashMap<Integer, RoadDetails> roadDetailMap,
			HashMap<String, Integer> priceDetails, String endPt,
			RoadDetails details, String cityType) {
		RoadDetails roadDetailsCurrent = details;

		for (Integer i : pathList) {
			String track2 = track1 + Integer.toString(i) + ",";
			RoadDetails newRoadDetail = roadDetailMap.get(i);
			if (cityType.equals(CITY_2)) {
				newRoadDetail = swapCity(newRoadDetail);
			}
			if (newRoadDetail.getCity2().equals(endPt)) {
				int calculatePrice = calculatePrice(track2, roadDetailMap);
				priceDetails.put(track2, calculatePrice);

			} else {
				roadDetailsCurrent = newRoadDetail;
				goAhead(roadDetailsCurrent, roadDetailMap, endPt, i, track2,
						priceDetails);
			}
		}
	}

	private static RoadDetails swapCity(RoadDetails newRoadDetail) {
		newRoadDetail = new RoadDetails(newRoadDetail);
		return newRoadDetail.swapCities();
	}

	public static String[][] getMatrix(int noOfRoad, String[] nameOfCities,
			String[] pricePerRoad, HashMap<Integer, RoadDetails> roadDetailMap) {
		int rowLength = noOfRoad + 1;
		String roadPrice = "";
		int row = 0;
		String[][] stringArray = new String[rowLength][nameOfCities.length];
		for (int col = 0; col < nameOfCities.length; col++) {
			stringArray[row][col] = nameOfCities[col];
		}
		++row;
		while (row < rowLength) {
			roadPrice = pricePerRoad[row - 1];
			RoadDetails roadDetails = getRoadDetails(roadPrice);
			roadDetailMap.put(row, roadDetails);
			for (int col = 0; col < nameOfCities.length; col++) {
				String cityAtCol = stringArray[0][col];
				if (roadDetails.getCity1().equals(cityAtCol)) {
					stringArray[row][col] = roadDetails.getCity1();
				} else if (roadDetails.getCity2().equals(cityAtCol)) {
					stringArray[row][col] = roadDetails.getCity2();
				} else {
					stringArray[row][col] = DOT;
				}
			}
			row++;
		}
		return stringArray;
	}

	public static RoadDetails getRoadDetails(String roadPrice) {
		RoadDetails roadDetails = new RoadDetails();
		Pattern pat = Pattern.compile("([a-zA-Z]|[0-9])");
		Matcher mat = pat.matcher(roadPrice);
		int i = 0;
		while (mat.find()) {

			String value = mat.group();
			switch (i) {
			case 0:
				roadDetails.setCity1(value);
				break;
			case 1:
				roadDetails.setCity2(value);
				break;
			case 2:
				roadDetails.setPrice(Integer.valueOf(value));
				break;
			default:
				break;
			}
			i++;
		}

		return roadDetails;
	}

	public static int calculatePrice(String trackpath,
			HashMap<Integer, RoadDetails> roadDetailMap) {
		int price = 0;
		String[] path = trackpath.split(",");
		for (int i = 0; i < path.length; i++) {
			int pathName = Integer.parseInt(path[i]);
			price = price + roadDetailMap.get(pathName).getPrice();
		}
		return price;

	}

	public static int getMinPrice(HashMap<String, Integer> priceDetails) {
		Collection<Integer> keySet = priceDetails.values();
		TreeSet<Integer> valSet = new TreeSet<Integer>(keySet);
		return valSet.first();

	}

	public static HashMap<String, List<Integer>> checkForAllPath(
			RoadDetails roadDetailsCurrent,
			HashMap<Integer, RoadDetails> roadDetailMap) {
		HashMap<String, List<Integer>> cityPath = new HashMap<String, List<Integer>>();
		List<Integer> cityPathForCity1 = new ArrayList<Integer>();
		List<Integer> cityPathForCity2 = new ArrayList<Integer>();
		for (int i = 1; i <= roadDetailMap.size(); i++) {
			RoadDetails newRoadDetail = roadDetailMap.get(i);
			if (newRoadDetail != roadDetailsCurrent) {
				if (roadDetailsCurrent.getCity2().equals(
						newRoadDetail.getCity1())) {
					cityPathForCity1.add(i);
				} else if (roadDetailsCurrent.getCity2().equals(
						newRoadDetail.getCity2())) {
					cityPathForCity2.add(i);
				}
			}
		}
		cityPath.put(CITY_1, cityPathForCity1);
		cityPath.put(CITY_2, cityPathForCity2);
		return cityPath;

	}
	/*
	 * class PricePerRoad {
	 * 
	 * public PricePerRoad(String[] pricePerRoad) {
	 * 
	 * } }
	 */
}
