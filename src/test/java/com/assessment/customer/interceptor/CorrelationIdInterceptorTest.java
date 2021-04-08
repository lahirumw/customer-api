package com.assessment.customer.interceptor;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.assessment.customer.constant.HeaderParameters;


/**
 * Test class for {@link CorrelationIdInterceptor}
 * 
 * @author lahirua
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CorrelationIdInterceptorTest {

    @InjectMocks
    private CorrelationIdInterceptor correlationIdInterceptor = new CorrelationIdInterceptor();

    /**
     * Valid Correlation ID
     * 
     * @throws Exception
     */
    @Test
    public void testPreHandle() throws Exception {

	String id = UUID.randomUUID().toString();

	MockHttpServletResponse response = new MockHttpServletResponse();

	MockHttpServletRequest request = new MockHttpServletRequest();
	request.addHeader(HeaderParameters.CORRELATIONID, id);

	Assert.assertTrue(correlationIdInterceptor.preHandle(request, response, new Object()));

    }

    /**
     * Invalid Correlation ID
     * 
     * @throws Exception
     */
    @Test
    public void testPreHandleInvalidID() throws Exception {

	String id = "hjeee";

	MockHttpServletResponse response = new MockHttpServletResponse();

	MockHttpServletRequest request = new MockHttpServletRequest();
	request.addHeader(HeaderParameters.CORRELATIONID, id);

	Assert.assertTrue(correlationIdInterceptor.preHandle(request, response, new Object()));

    }

    /**
     * No Correlation ID
     * 
     * @throws Exception
     */
    @Test
    public void testPreHandleNoID() throws Exception {

	MockHttpServletResponse response = new MockHttpServletResponse();

	MockHttpServletRequest request = new MockHttpServletRequest();

	Assert.assertTrue(correlationIdInterceptor.preHandle(request, response, new Object()));
    }

    /**
     * After Request Completion.
     * 
     * @throws Exception
     */
    @Test
    public void testAfterCompletion() throws Exception {

	String id = UUID.randomUUID().toString();

	MockHttpServletRequest request = new MockHttpServletRequest();
	request.addHeader(HeaderParameters.CORRELATIONID, id);

	correlationIdInterceptor.afterCompletion(request, new MockHttpServletResponse(), new Object(), new Exception());

	Assert.assertNull(request.getAttribute(HeaderParameters.CORRELATIONID));

    }
}
