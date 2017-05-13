package com.subcription.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.subcription.dao.SubcriptionDao;

@Service
public class SubscriptionService implements SubcriptionDao{
 
	
	private SubcriptionDao subcriptionDao;
	
	protected static Logger logger = Logger.getLogger("GreetingService");
 
	
	
	public String getOrderDetails(HttpServletRequest request) {
		
		if(null != request){
			return (String) request.getAttribute("orderDetails");
		}
		else{
			return "";
		}
	}

	
	public String truncate(String orderDetails, Integer length) {
		String replace =" ... (truncated) ... ";
		String returnStr = "";
		if(null != orderDetails && orderDetails.length() <= length){
			return orderDetails;
		}else if(null != orderDetails && orderDetails.length() > length){
		
			if(orderDetails.length() > replace.length()){
			Integer len = length - replace.length();	
			
			Integer f = len/2;
			
			Integer last = orderDetails.length() - ((len%2) + f);			
			returnStr = orderDetails.substring(0, f) + replace + orderDetails.substring(last);
			
			return returnStr;
			}else{
				return orderDetails;
			}
		}
		
		return orderDetails;
	}

	public void log(String truncatedOrderDetails) {
			System.out.println(truncatedOrderDetails);	
	}
 
}