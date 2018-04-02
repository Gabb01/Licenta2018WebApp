package com.Licenta2018Web.springmvc.service;

public interface SecurityService {
	
	public String findLoggedInUsername();
	public void autologin(String username, String password);
}
