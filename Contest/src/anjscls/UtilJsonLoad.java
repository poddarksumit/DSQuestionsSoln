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
package anjscls;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class is used to
 * 
 * @author 394154 Version 1.0
 */
public class UtilJsonLoad {

	private static final String FILE_PATH_HOME = "C:\\Users\\Sumit\\My Work\\EclipseWorkspace\\Contest\\src\\anjscls\\home-json.txt";
	private static final String FILE_PATH_LOGIN = "C:\\Users\\Sumit\\My Work\\EclipseWorkspace\\Contest\\src\\anjscls\\login-json.txt";
	private static final String FILE_PATH_SEARCH_NO = "C:\\Users\\Sumit\\My Work\\EclipseWorkspace\\Contest\\src\\anjscls\\search no-json.txt";
	private static final String FILE_PATH_SEARCH = "C:\\Users\\Sumit\\My Work\\EclipseWorkspace\\Contest\\src\\anjscls\\search shirt-json.txt";
	private static final String FILE_PATH_PROD = "C:\\Users\\Sumit\\My Work\\EclipseWorkspace\\Contest\\src\\anjscls\\product-json.txt";

	// private final String FILE_PATH_PRODUCT = "home-json.txt";

	public static String loadHomeContent(String serviceName, String searchType,
			String searchNameVal) throws JSONException {
		/*
		 * Functionality to make a request to the API and get the response as
		 * JSON. Temp getting it from the a file.
		 */

		String jsonAsString = readFile(FILE_PATH_HOME);
		JSONObject json = new JSONObject(jsonAsString);
		json = json.getJSONObject("Body").getJSONObject("searchResponse")
				.getJSONObject("return").getJSONObject("banner");
		JSONArray jsonArry = json.getJSONArray("content");
		return jsonArry.toString();

	}

	public static String loadProdDetails(String serviceName, String searchType,
			String searchNameVal) throws JSONException {
		/*
		 * Functionality to make a request to the API and get the response as
		 * JSON. Temp getting it from the a file.
		 */

		String jsonAsString = readFile(FILE_PATH_PROD);
		JSONObject json = new JSONObject(jsonAsString);
		return json.toString();

	}

	public static void main(String[] args) {
		try {
			System.out.println(loadHomeContent("", "", ""));
			System.out.println(loadProdDetails("", "", ""));
		} catch (JSONException exception) {
			exception.printStackTrace();
		}
	}

	private static String readFile(String path) {
		StringBuffer response = new StringBuffer();
		try {
			String str = "";
			File file = new File(path);
			if (file.exists()) {
				FileReader reader = new FileReader(file);
				BufferedReader buff = new BufferedReader(reader);
				while ((str = buff.readLine()) != null) {
					response.append(str);
				}

			}
		} catch (IOException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
		return response.toString();
	}
}
