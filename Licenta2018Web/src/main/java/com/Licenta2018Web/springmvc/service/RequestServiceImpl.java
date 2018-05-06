package com.Licenta2018Web.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Licenta2018Web.springmvc.model.Request;
import com.Licenta2018Web.springmvc.repository.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	RequestRepository requestRepository;
	
	@Override
	public Request findById(Long id) {
		return requestRepository.findOne(id);
	}

	@Override
	public void saveRequest(Request request) {
		requestRepository.save(request);
	}

	@Override
	public void updateRequest(Request request) {
		saveRequest(request);
	}

	@Override
	public void deleteRequestById(Long id) {
		requestRepository.delete(id);
	}

	@Override
	public void deleteAllRequests() {
		requestRepository.deleteAll();
	}

	@Override
	public List<Request> listAllRequests() {
		return requestRepository.findAll();
	}

	@Override
	public boolean isRequestApproved(String approvalStatus) {
		return requestRepository.findByStatus(approvalStatus);
	}

}
