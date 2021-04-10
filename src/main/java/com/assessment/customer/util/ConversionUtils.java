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
