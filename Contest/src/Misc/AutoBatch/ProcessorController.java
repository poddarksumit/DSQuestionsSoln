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
import java.util.Set;

/**
 * This class is used to
 * 
 * @author 394154 Version 1.0
 */
public class ProcessorController {

	private static Set<String> keySet = null;
	private static HashMap<String, AutoBatchBatchProcessor> processorDetails = new HashMap<String, AutoBatchBatchProcessor>();

	static {
		processorDetails.put("SRP", new SecurityReleaseProcessor());
		processorDetails.put("PP", new PaymentProcessBatch());
		processorDetails.put("OEP", new OrderExportProcessor());
		keySet = processorDetails.keySet();
	}

	public static Set<String> getKeySet() {
		return keySet;
	}

	public static HashMap<String, AutoBatchBatchProcessor> getProcessorDetails() {
		return processorDetails;
	}

	public static void setKeySet(Set<String> keySet) {
		ProcessorController.keySet = keySet;
	}

	public static void setProcessorDetails(
			HashMap<String, AutoBatchBatchProcessor> processorDetails) {
		ProcessorController.processorDetails = processorDetails;
	}

}
