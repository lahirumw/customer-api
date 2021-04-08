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
package com.assessment.customer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



/**
 * Intercepter to initializes the MDC utils for Logging purposes and calculates
 * the time taken for a request to be completed.
 * 
 * @author lahirua
 */
@Component
public class AccessLogInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessLogInterceptor.class);


    /**
     * PreHandle: Records the time the request was sent and initializers the MDC
     * util for logging.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

	long startTime = System.currentTimeMillis();
	request.setAttribute("startTime", startTime);

	return true;
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) {
	// Nothing to do here

    }

    /**
     * AfterCompletion: Records the time take for the response to be returned
     * and calculates the total time taken. The MDC util is cleared for the next
     * request.
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
	    Exception exception) {

	long startTime = (Long) request.getAttribute("startTime");
	long endTime = System.currentTimeMillis();
	long executeTime = endTime - startTime;

	LOGGER.info("[ {} ] execute time : {} ms", handler, executeTime);
    }

}
