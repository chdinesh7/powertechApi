package com.powertech.nelson.serviceimple;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.powertech.nelson.dao.EmployeeRegistrationDao;
import com.powertech.nelson.entity.EmployeeRegistration;

import static java.util.Collections.emptyList;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private EmployeeRegistrationDao employeeRegistrationDao;
    public UserDetailsServiceImpl(EmployeeRegistrationDao employeeRegistrationDao) {
        this.employeeRegistrationDao = employeeRegistrationDao;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	EmployeeRegistration employeeRegistration = employeeRegistrationDao.findByUsername(username);
        if (employeeRegistration == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(employeeRegistration.getUsername(), employeeRegistration.getPassword(), emptyList());
    }
}