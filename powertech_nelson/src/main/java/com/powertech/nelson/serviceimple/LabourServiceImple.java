package com.powertech.nelson.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powertech.nelson.dao.LabourDao;
import com.powertech.nelson.entity.Activity;
import com.powertech.nelson.entity.Labour;
import com.powertech.nelson.service.LabourService;
@Service
public class LabourServiceImple implements LabourService {
	
	@Autowired
	private LabourDao labourDao;

	@Override
	public String save(Labour labour) {
		labourDao.save(labour);
		return "Labour Type Saved Successfully";
	}

	@Override
	public List<Labour> findAll() {
		
		return (List<Labour>) labourDao.findAll();
	}

	@Override
	public Optional<Labour> findById(Long id) {
		
		return labourDao.findById(id);
	}

	@Override
	public String delete(Long id) {
		labourDao.deleteById(id);
		return "Labour Type deleted Successfully ";
	}

}
