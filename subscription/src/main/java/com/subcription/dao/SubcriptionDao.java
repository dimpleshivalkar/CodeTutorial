package com.subcription.dao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

@Repository
public interface SubcriptionDao {
	
public	String getOrderDetails(HttpServletRequest request );
	public String truncate( String orderDetails, Integer length );
	public void log( String truncatedOrderDetails );

}
