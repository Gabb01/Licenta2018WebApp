package com.Licenta2018Web.springmvc.service;

import java.util.List;

import com.Licenta2018Web.springmvc.model.Request;

public interface RequestService {
	
	Request findById(Long id);

	
	void saveRequest(Request request);
	void updateRequest(Request request);
	void deleteRequestById(Long id);
	void deleteAllRequests();
	List<Request> listAllRequests();
	
	public boolean isRequestApproved(String approvalStatus);
}
