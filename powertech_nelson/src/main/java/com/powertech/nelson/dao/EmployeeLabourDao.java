package com.powertech.nelson.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.powertech.nelson.entity.EmployeeLabour;
import com.powertech.nelson.entity.PlantTransaction;

public interface EmployeeLabourDao extends CrudRepository<EmployeeLabour, Long> {
	@Query(value="SELECT * FROM emp_labour   WHERE firest_name like ?1%",nativeQuery=true)
	public List<EmployeeLabour> empFind(String emp_name);
}
