package com.subcription.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.subcription.service.SubscriptionService;


@Controller
@RequestMapping("/")
public class SubscriptionController {


	protected static Logger logger = Logger.getLogger("SubscriptionController");
	
	
	private SubscriptionService subcriptionService;
	
	@Autowired
	public SubscriptionController(SubscriptionService subcriptionService) {
		this.subcriptionService = subcriptionService;
	}
	
	@RequestMapping (value = "/subscribe" , method = RequestMethod. GET )
	public String subscribe(HttpServletRequest request) {
	
	String attr = (String) request.getAttribute("length");
	String orderDetails = subcriptionService.getOrderDetails( request );
	String truncatedOrderDetails = subcriptionService.truncate( orderDetails, Integer.parseInt(attr));
	subcriptionService.log( truncatedOrderDetails );
	return "subscribed";
	 
	}
	
}
