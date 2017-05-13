package com.subcription.controller;
 
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import com.subcription.service.SubscriptionService;

import junit.framework.TestCase;
 
public class SubcriptionControllerTest extends TestCase {
 
	@Test
	public void testTheMethodShowAllGreetingsShouldReturnAResult() {
                //GIVEN		
		SubscriptionService fakeGreetingService = mock(SubscriptionService.class);
		SubscriptionController controller = new SubscriptionController(fakeGreetingService);
		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
		
		when(mockRequest.getAttribute("orderDetails")).thenReturn("123456789012345678901234567890");
		
		//mockRequest.setAttribute("orderDetails", "test");
		String result = controller.subscribe(mockRequest);
                //THEN
	        assertNotNull(result);
	        assertEquals("subscribed",result);
	}
 
}