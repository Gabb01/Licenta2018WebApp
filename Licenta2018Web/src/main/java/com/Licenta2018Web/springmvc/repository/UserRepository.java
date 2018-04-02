package com.Licenta2018Web.springmvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.Licenta2018Web.springmvc.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
