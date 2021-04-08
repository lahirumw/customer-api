package com.assessment.customer.interceptor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * Test Class for {@link AccessLogInterceptor}
 * 
 * @author lahirua
 */
@RunWith(MockitoJUnitRunner.class)
public class AccessLogInterceptorTest {

    @InjectMocks
    private AccessLogInterceptor accessLogInterceptor = new AccessLogInterceptor();

    @Test
    public void testPreHandle() throws Exception {

	boolean result = accessLogInterceptor.preHandle(new MockHttpServletRequest(), new MockHttpServletResponse(),
		new Object());
	Assert.assertEquals(true, result);
    }

    @Test
    public void testAfterCompletion() throws Exception {

	MockHttpServletRequest request = new MockHttpServletRequest();
	request.setAttribute("startTime", new Long(2));

	Assert.assertNotNull(request);

	accessLogInterceptor.afterCompletion(request, new MockHttpServletResponse(), new Object(), new Exception());
    }

}
