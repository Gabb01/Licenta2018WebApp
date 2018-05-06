package com.Licenta2018Web.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.http.HeadersBeanDefinitionParser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.Licenta2018Web.springmvc.model.Request;
import com.Licenta2018Web.springmvc.service.RequestService;

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
		requestService.saveRequest(request);		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ucBuilder.path("/request/{id}").buildAndExpand(request.getRequestId()).toUri());
		return new ResponseEntity<String>(httpHeaders, HttpStatus.CREATED);
	}
}
