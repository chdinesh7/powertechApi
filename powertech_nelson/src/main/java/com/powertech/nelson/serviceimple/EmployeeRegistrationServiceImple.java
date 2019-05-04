package com.powertech.nelson.serviceimple;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.powertech.nelson.dao.EmployeeRegistrationDao;
import com.powertech.nelson.entity.EmployeeRegistration;

import com.powertech.nelson.service.EmpolyeeRegistrationService;




import java.util.List;
import java.util.Optional;
@Service
public class EmployeeRegistrationServiceImple implements EmpolyeeRegistrationService {

	@Autowired
	private EmployeeRegistrationDao employeeRegistrationDao;
	
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	    public EmployeeRegistrationServiceImple(EmployeeRegistrationDao employeeRegistrationDao,
	                          BCryptPasswordEncoder bCryptPasswordEncoder) {
	        this.employeeRegistrationDao = employeeRegistrationDao;
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	    }

	@Override
	public String save(EmployeeRegistration employeeRegistration) {
		employeeRegistration.setPassword(bCryptPasswordEncoder.encode(employeeRegistration.getPassword()));
		employeeRegistrationDao.save(employeeRegistration);
		return "Registration Successfully";
	}

	public List<EmployeeRegistration> findAll() {		
		return (List<EmployeeRegistration>) employeeRegistrationDao.findAll();
	}

	public Optional<EmployeeRegistration> findById(Long id) {		
		return employeeRegistrationDao.findById(id);
	}

	
	 
}
