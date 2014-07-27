package Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

import Misc.Corkscore.MapUtil.MapObject;

import com.sun.xml.internal.fastinfoset.util.StringArray;

public class Corkscore {

	/**
	 * @param args
	 */
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
		/*
		 * arlReco1.add("DM_916324"); arlReco1.add("DM_63994");
		 * arlReco1.add("DM_912141");
		 */
		arlReco1.add("DM_103853");
		arlReco1.add("DM_908018");
		arlReco1.add("DM_86516");
		arlReco1.add("DM_900874");
		arlReco1.add("DM_912141");
		arlReco1.add("DM_50045");
		arlReco1.add("DM_166302");

		ArrayList<String> arlReco3 = new ArrayList<String>();
		/*
		 * arlReco3.add("DM_11111"); arlReco3.add("DM_22222");
		 * arlReco3.add("DM_912141"); arlReco3.add("DM_33333");
		 */

		arlReco3.add("DM_103853");

		strategyRecommendationsFinalMap.put("rangeFinderResponse", arlReco2);
		strategyRecommendationsFinalMap.put("bestBangForTheBuckResponse",
				arlReco1);
		strategyRecommendationsFinalMap.put("random", arlReco3);
		process(strategyRecommendationsFinalMap);
	}

	public static class MapUtil {

		static class MapObject {
			String key = "";
			String value = "";

			public MapObject(String key, String value) {
				super();
				this.key = key;
				this.value = value;
			}

		}

		LinkedList<MapObject> mapObject = new LinkedList<Corkscore.MapUtil.MapObject>();
		StringArray array = new StringArray();

	}

	private static void process(HashMap<String, ArrayList<String>> map) {
		MapUtil mapUtil = process(map, 0);
		for (int i = 0; i < mapUtil.array.getSize(); i++) {
			System.out.println(mapUtil.array.get(i));
		}
		while (mapUtil.mapObject.size() > 0) {
			MapObject object = mapUtil.mapObject.removeLast();
			// if(mapUtil.array.{
			System.out.println(object.key + " : " + object.value);
			// }
		}
	}

	private static String[] getKeyAsArray(Set<String> keySet) {
		String[] array = new String[keySet.size()];
		Iterator<String> itr = keySet.iterator();
		int index = 0;
		while (itr.hasNext()) {
			array[index] = itr.next();
			index++;
		}
		return array;
	}

	private static MapUtil process(HashMap<String, ArrayList<String>> map,
			int index) {
		Set<String> keySey = map.keySet();
		Corkscore.MapUtil mapUtil = new Corkscore.MapUtil();
		String[] keyArray = getKeyAsArray(keySey);
		int[] indexArray = new int[keySey.size()];
		boolean stillProcess = true;
		int size = keySey.size() - 1;
		while (stillProcess) {
			ArrayList<String> list = map.get(keyArray[index]);
			if (list.size() > indexArray[index]) {
				System.out.println(keyArray[index]);
				System.out.println(list.get(indexArray[index]));
				System.out.println("-------------");
				mapUtil.array.add(list.get(indexArray[index]));
				mapUtil.mapObject.push(new MapObject(list
						.get(indexArray[index]), keyArray[index]));
				indexArray[index] = indexArray[index] + 1;
				if (indexArray[index] >= list.size()) {
					size--;
				}
			}

			if (index == keySey.size() - 1) {
				index = 0;
			} else {
				index++;
			}
			if (size < 0) {
				stillProcess = false;
			}
		}
		return mapUtil;
	}
}
