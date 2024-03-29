package com.powertech.nelson.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powertech.nelson.dao.PlantActivityDao;
import com.powertech.nelson.entity.Activity;
import com.powertech.nelson.entity.PlantActivity;
import com.powertech.nelson.service.PlantActivityService;
@Service
public class PlantActivityServiceImple implements PlantActivityService {
	
	@Autowired
	private PlantActivityDao plantActivityDao;
	
	@Override
	public String save(PlantActivity plantActivity) {
		plantActivityDao.save(plantActivity);
		return "Plant Activity Saved Successfully";
	}

	@Override
	public List<PlantActivity> findAll() {		
		return (List<PlantActivity>) plantActivityDao.findAll();
	}

	@Override
	public Optional<PlantActivity> findById(Long id) {
		
		return plantActivityDao.findById(id);
	}

}
