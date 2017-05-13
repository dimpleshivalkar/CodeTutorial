package com.subcription.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

@Repository("subDaoimpl")
public class SubcriptionDaoImpl implements SubcriptionDao{

	public String getOrderDetails(HttpServletRequest request) {
		String orderDetails = (String) request.getAttribute("orderDetails");
		return orderDetails;
	}

	public String truncate(String orderDetails, Integer length) {
		// TODO Auto-generated method stub
		return null;
	}

	public void log(String truncatedOrderDetails) {
		// TODO Auto-generated method stub
		
	}

}
