package com.Licenta2018Web.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.Licenta2018Web.springmvc.model.Request;
import com.Licenta2018Web.springmvc.service.RequestService;
import com.Licenta2018Web.springmvc.utility.CustomError;

@RestController
public class RequestController {
	
	@Autowired
	RequestService requestService;
	
	/*
	 * Add a request ( for user )
	 */
	@RequestMapping(value = "/request", method = RequestMethod.POST)
	public ResponseEntity<?> createRequest(@RequestBody Request request, UriComponentsBuilder ucBuilder)
	{		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ucBuilder.path("/request/{id}").buildAndExpand(request.getRequestId()).toUri());
		return new ResponseEntity<String>(httpHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/request/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateRequest(@PathVariable("id") long id, @RequestBody Request request)
	{
		Request currentRequest = requestService.findById(id);
		
		if(currentRequest == null)
		{
			return new ResponseEntity<>(new CustomError("Unable to update request id " + id + "."), HttpStatus.NOT_FOUND);
		}
		currentRequest.setApproved(request.isApproved());
		currentRequest.setRequestType(request.getRequestType());
		currentRequest.setIssueDate(request.getIssueDate());
		currentRequest.setUser(request.getUser());
		
		requestService.updateRequest(currentRequest);
		return new ResponseEntity<Request>(currentRequest, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/request/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRequest(@PathVariable("id") long id)
	{
		Request currentRequest = requestService.findById(id);
		
		if(currentRequest == null)
		{
			return new ResponseEntity<>(new CustomError("Unable to delete request with id " + id + "."), HttpStatus.NOT_FOUND);
		}
		requestService.deleteRequestById(id);
		return new ResponseEntity<Request>(HttpStatus.NO_CONTENT);		
	}
	
	@RequestMapping(value = "/request", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAllRequests()
	{
		requestService.deleteAllRequests();
		return new ResponseEntity<Request>(HttpStatus.NO_CONTENT);
	}
}
