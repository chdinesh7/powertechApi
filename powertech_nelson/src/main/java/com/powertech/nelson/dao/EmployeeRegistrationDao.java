package com.powertech.nelson.dao;

import org.springframework.data.repository.CrudRepository;

import com.powertech.nelson.entity.EmployeeRegistration;

public interface EmployeeRegistrationDao extends CrudRepository<EmployeeRegistration, Long> {
	EmployeeRegistration findByUsername(String username);
}
