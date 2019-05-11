package com.powertech.nelson.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powertech.nelson.dao.EmployeeLabourDao;
import com.powertech.nelson.entity.EmployeeLabour;
import com.powertech.nelson.entity.EmployeeRegistration;
import com.powertech.nelson.service.EmployeeLabourService;
@Service
public class EmployeeLabourServiceImple implements EmployeeLabourService {
	
	@Autowired
	private EmployeeLabourDao employeeLabourDao;

	@Override
	public String save(EmployeeLabour employeeLabour) {
		employeeLabourDao.save(employeeLabour);
		return "Registration Successfully";
	}

	@Override
	public List<EmployeeLabour> findAll() {	
		return (List<EmployeeLabour>) employeeLabourDao.findAll();
	}

	@Override
	public Optional<EmployeeLabour> findById(Long id) {		
		return employeeLabourDao.findById(id);
	}

	@Override
	public List<EmployeeLabour> findName(String emp_name) {
		
		return employeeLabourDao.empFind(emp_name);
	}

}
