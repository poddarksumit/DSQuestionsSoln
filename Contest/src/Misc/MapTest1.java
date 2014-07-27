package Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.bluemartini.dna.DNAStringArray;
import com.bluemartini.dna.DNAAlphaComparator.Keys;

/**
 * This class is used to
 * 
 * @author xspro Version 1.0
 */
public class MapTest1 {

	static class MapTestInter {
		HashMap<String, Integer> prdStratMap = new HashMap<String, Integer>();
		DNAStringArray strArray = new DNAStringArray();

		/**
		 * @return the prdStratMap
		 */
		public HashMap<String, Integer> getPrdStratMap() {
			return prdStratMap;
		}

		/**
		 * @param prdStratMap
		 *            the prdStratMap to set
		 */
		public void setPrdStratMap(HashMap<String, Integer> prdStratMap) {
			this.prdStratMap = prdStratMap;
		}

		/**
		 * @return the strArray
		 */
		public DNAStringArray getStrArray() {
			return strArray;
		}

		/**
		 * @param strArray
		 *            the strArray to set
		 */
		public void setStrArray(DNAStringArray strArray) {
			this.strArray = strArray;
		}

	}

	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> strategyRecommendationsFinalMap = new HashMap<String, ArrayList<String>>();
		HashMap<String, String> recommendationsFinalMap = null;
		LinkedHashMap finalList = new LinkedHashMap<String, String>();

		ArrayList<String> arlReco2 = new ArrayList<String>();
		arlReco2.add("DM_103853");
		arlReco2.add("DM_908018");
		arlReco2.add("DM_86516");
		arlReco2.add("DM_900874");
		arlReco2.add("DM_912141");
		arlReco2.add("DM_50045");
		arlReco2.add("DM_166302");

		ArrayList<String> arlReco1 = new ArrayList<String>();
		arlReco1.add("DM_916324");
		arlReco1.add("DM_63994");

		ArrayList<String> arlReco3 = new ArrayList<String>();
		arlReco3.add("DM_11111");
		arlReco3.add("DM_22222");

		strategyRecommendationsFinalMap.put("rangeFinderResponse", arlReco2);
		strategyRecommendationsFinalMap.put("bestBangForTheBuckResponse",
				arlReco1);
		// strategyRecommendationsFinalMap.put("random", arlReco3);

		System.out.println("test1" + strategyRecommendationsFinalMap);

		HashMap<Integer, LinkedList<String>> list = buildFinalArray(strategyRecommendationsFinalMap);

		/*
		 * Set<Entry<String, ArrayList<String>>> pSet =
		 * strategyRecommendationsFinalMap .entrySet(); Iterator itr =
		 * pSet.iterator(); List al = null; String key = null; Iterator itr1 =
		 * null; int index = 0;
		 * 
		 * while (itr.hasNext()) { // System.out.println("inside iterator");
		 * Map.Entry me = (Map.Entry) itr.next(); key = (String) me.getKey(); //
		 * ArrayList<String> value = //
		 * strategyRecommendationsFinalMap.get(key); al = (ArrayList<String>)
		 * strategyRecommendationsFinalMap.get(key); //
		 * System.out.println("The arraylist is "+al); itr1 = al.iterator();
		 * while (itr1.hasNext()) { String test = (String) itr1.next(); //
		 * System.out.println("inside iterator2"); finalList.put(test, index); }
		 * index++; }
		 */

		readList(list);
	}

	private static void readList(HashMap<Integer, LinkedList<String>> list) {
		Set<Integer> keySet = list.keySet();
		Iterator<Integer> itr = keySet.iterator();
		while (itr.hasNext()) {
			int index = itr.next();
			LinkedList<String> strArray = list.get(index);
			System.out.println("---- From index : " + index);
			while (!strArray.isEmpty()) {
				System.out.println(strArray.remove(0));
			}
		}
	}

	private static HashMap<Integer, LinkedList<String>> buildFinalArray(
			HashMap<String, ArrayList<String>> strategyRecommendationsFinalMap) {
		MapTestInter mapInter = getInterObject(strategyRecommendationsFinalMap);
		HashMap<Integer, LinkedList<String>> list = getProductAsPerStaregy(mapInter);
		return list;
	}

	private static MapTestInter getInterObject(
			HashMap<String, ArrayList<String>> strategyRecommendationsFinalMap) {
		MapTestInter mapInter = new MapTest1.MapTestInter();
		Set<String> itr = strategyRecommendationsFinalMap.keySet();
		Iterator<String> iterator = itr.iterator();
		int index = 0;
		while (iterator.hasNext()) {
			String str = iterator.next();
			ArrayList<String> array = strategyRecommendationsFinalMap.get(str);
			for (int i = 0; i < array.size(); i++) {
				mapInter.getPrdStratMap().put(array.get(i), index);
				mapInter.getStrArray().add(array.get(i));
			}
			index++;
		}
		return mapInter;
	}

	private static HashMap<Integer, LinkedList<String>> getProductAsPerStaregy(
			MapTestInter mapInter) {
		HashMap<Integer, LinkedList<String>> finalList = new HashMap<Integer, LinkedList<String>>();
		DNAStringArray strArray = mapInter.getStrArray();
		LinkedList<String> prdArray = new LinkedList<String>();
		for (String str : strArray) {
			if (finalList.size() > mapInter.getPrdStratMap().get(str)) {
				prdArray = finalList.get(mapInter.getPrdStratMap().get(str));
				if (prdArray == null) {
					prdArray = new LinkedList<String>();
				}
			} else {
				prdArray = new LinkedList<String>();
			}
			prdArray.add(str);
			finalList.put(mapInter.getPrdStratMap().get(str), prdArray);
		}
		return finalList;
	}
}
