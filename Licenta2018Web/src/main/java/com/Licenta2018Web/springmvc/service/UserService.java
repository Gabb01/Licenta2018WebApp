package com.Licenta2018Web.springmvc.service;

import com.Licenta2018Web.springmvc.model.User;

public interface UserService {
	 public void save(User user);
	 public User findByUsername(String username);
}
