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
package Misc.AutoBatch;

import java.util.HashMap;

/**
 * This class is used to
 * 
 * @author 394154 Version 1.0
 */
public class OrderProcessorSelectOption {

	private static String OPTION_OFF = "</option>";
	private static String OPTION_ON_1 = "<option value=\"";
	private static String OPTION_ON_2 = "\">";
	private static HashMap<Character, String> statusSelector = new HashMap<Character, String>();

	private static String getFirstSelectOption() {
		StringBuffer str = new StringBuffer();
		str.append(OPTION_ON_1).append(OPTION_ON_2).append("Select a process")
				.append(OPTION_OFF);
		return str.toString();
	}

	public static String getValidOrderProcessors(char orderStatus) {
		HashMap<String, AutoBatchBatchProcessor> processorDetails = ProcessorController
				.getProcessorDetails();
		String optionValid = "";
		StringBuffer str = new StringBuffer();
		str.append(getFirstSelectOption());
		AutoBatchBatchProcessor procPbject = null;
		if (statusSelector.containsKey(orderStatus)) {
			optionValid = statusSelector.get(orderStatus);
		} else {
			int optionValue = 0;
			for (String key : ProcessorController.getKeySet()) {
				procPbject = processorDetails.get(key);
				if ((procPbject != null)
						&& (procPbject.isOrderStatusAvbl(orderStatus))) {
					optionValue += 1;
					str.append(OPTION_ON_1);
					str.append(procPbject.getProcessorDisplayValue());
					str.append(OPTION_ON_2);
					str.append(procPbject.getProcessorDisplayName());
					str.append(OPTION_OFF);
				}

			}
			if (optionValue > 0) {
				optionValid = str.toString();
			} else {
				str.append(OPTION_ON_1);
				str.append("");
				str.append(OPTION_ON_2);
				str.append("No more processes.");
				str.append(OPTION_OFF);
				optionValid = str.toString();
			}
			statusSelector.put(orderStatus, optionValid);
		}
		return optionValid;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char a = 'P';
		System.out.println(getValidOrderProcessors(a));

	}

	/**
	 * 
	 */
	public OrderProcessorSelectOption() {
		statusSelector = new HashMap<Character, String>();
	}
}
