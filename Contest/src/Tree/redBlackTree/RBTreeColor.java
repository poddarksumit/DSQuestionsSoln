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
package Tree.redBlackTree;

/**
 * This class is used to
 * 
 * @author 394154 Version 1.0
 */
public enum RBTreeColor {
    BLACK("black"), RED("red");

    String color = "";

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = color;
    }

    private RBTreeColor(String color) {
	this.color = color;
    }
}
