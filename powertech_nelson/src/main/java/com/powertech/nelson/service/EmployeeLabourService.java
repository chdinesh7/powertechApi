package com.powertech.nelson.service;

import java.util.List;
import java.util.Optional;

import com.powertech.nelson.entity.EmployeeLabour;


public interface EmployeeLabourService {
	public String save(EmployeeLabour employeeLabour);
	public List<EmployeeLabour> findAll();
	public Optional<EmployeeLabour> findById(Long id);
	
	public List<EmployeeLabour>  findName(String emp_name);
}
