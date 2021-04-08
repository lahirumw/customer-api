/*******************************************************************************
 * PEARSON PROPRIETARY AND CONFIDENTIAL INFORMATION SUBJECT TO NDA
 * * Copyright © 2017 Pearson Education, Inc.
 * * All Rights Reserved.
 * *
 * * NOTICE: All information contained herein is, and remains
 * * the property of Pearson Education, Inc. The intellectual and technical
 * concepts contained
 * * herein are proprietary to Pearson Education, Inc. and may be covered by
 * U.S. and Foreign Patents,
 * * patent applications, and are protected by trade secret or copyright law.
 * * Dissemination of this information, reproduction of this material, and
 * copying or distribution of this software
 * * is strictly forbidden unless prior written permission is obtained from
 * Pearson Education, Inc.
 ******************************************************************************/
package com.assessment.customer.util;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for validations and type conversions.
 * 
 * @author lahirua
 */
public final class ConversionUtils {

    
    private static final Logger LOGGER = LoggerFactory.getLogger(ConversionUtils.class);
    
    private ConversionUtils() {
	
    }

    /**
     * Method to verify the validity of a ID.
     * 
     * @param id
     *               : The Id.
     * @return boolean value
     */
    public static boolean isUUID(String id) {
	try {
	    UUID.fromString(id);
	    return true;
	} catch (Exception ex) {
	    LOGGER.debug(ex.getMessage(), ex);
	    return false;

	}
    }

}
