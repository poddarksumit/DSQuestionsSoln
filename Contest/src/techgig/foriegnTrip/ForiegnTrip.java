/*
 * Copyright (C) 2009 Woolworths Limited
 *
 * 1 Woolworths Way Bella Vista NSW 2153 Australia
 * All rights reserved.
 * This software is the confidential and proprietary information of Woolworths Limited. You shall not disclose
 * such confidential information and shall use it only in accordance with the terms of the licence agreement
 * you entered into with Woolworths Limited.
 * No part of this document may be presented, reproduced or copied in any form or by any means (graphical,
 * electronic or mechanical including photocopying, recording tape or by any information storage and
 * retrieval system) without the express written permission of Woolworths Ltd.
 * Unpublished work.
 */
package techgig.foriegnTrip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * This class is used to
 * 
 * @author 394154 Version 1.0
 */
public class ForiegnTrip {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String testData = "{(1,2),(2,3),(3,4)}";
		int member = 4;
		String anser = getAnswer(testData, member);
	}

	public static String getAnswer(String testData, int member) {
		String answer = "";
		HashMap<Integer, ArrayList<String>> testDataAsSplit = breakTestData(testData);
		getMapOfEmp(testDataAsSplit);
		return answer;

	}

	public static HashMap<Integer, ArrayList<String>> breakTestData(
			String testData) {
		HashMap<Integer, ArrayList<String>> hashMap = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> arrayList;
		testData = testData.trim();
		testData = testData.replace("{", "");
		testData = testData.replace("}", "").trim();
		testData = testData.replace("),", ")/");
		String[] splitTestData = testData.split("/");
		for (int i = 1; i <= splitTestData.length; i++) {
			String testDataAsString = splitTestData[i - 1];
			arrayList = new ArrayList<String>();
			testDataAsString = testDataAsString.replace("(", " ")
					.replace(")", "").trim();
			String[] testDataForList = testDataAsString.split(",");
			for (String testDataForListAsString : testDataForList) {
				arrayList.add(testDataForListAsString);
			}
			hashMap.put(i, arrayList);
		}
		return hashMap;

	}

	public static void getMapOfEmp(HashMap<Integer, ArrayList<String>> hashMap) {
		Set<Integer> keySet = hashMap.keySet();
		HashMap<Integer, ArrayList<String>> hashMap1 = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> arrayList1;
		Iterator<Integer> itr = keySet.iterator();
		while (itr.hasNext()) {
			int key = itr.next();
			ArrayList<String> arrayList = hashMap.get(key);
			for (int z = 0; z < arrayList.size(); z++) {
				String val = arrayList.get(z);
				for (int y = 0; y < arrayList.size(); y++) {
					String val1 = arrayList.get(y);
					if (!val.equals(val1)) {
						arrayList1 = new ArrayList<String>();
						arrayList1.add(val1);
					}
				}
				searchOther(val, hashMap, key);
			}
		}
	}

	public static void getAllMap(int keyVal,
			HashMap<Integer, ArrayList<String>> hashMap) {

	}
}
