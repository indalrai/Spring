package com.hotelmanagement.service;

import java.util.List;

import com.hotelmanagement.model.Visitor;



public interface VisitorService {
	
	Visitor saveVisitor(Visitor visitor);
	List<Visitor> getAllVisitor();
	Visitor getVisitorById(long id) throws Exception;
	Visitor updateVisitor(Visitor visitor,long id) throws Exception;
	void deleteVisitor(long id) throws Exception;

}
