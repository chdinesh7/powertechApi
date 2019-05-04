package com.powertech.nelson.service;


import java.util.List;
import java.util.Optional;


import com.powertech.nelson.entity.EmployeeRegistration;

public interface EmpolyeeRegistrationService {
	public String save(EmployeeRegistration employeeRegistration);
	public List<EmployeeRegistration> findAll();
	public Optional<EmployeeRegistration> findById(Long id);
	
	
}
