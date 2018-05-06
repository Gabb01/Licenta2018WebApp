package com.Licenta2018Web.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Licenta2018Web.springmvc.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
	@Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM requests r WHERE r.status = :approvalStatus")
	boolean findByStatus(@Param("status") String approvalStatus);
}
