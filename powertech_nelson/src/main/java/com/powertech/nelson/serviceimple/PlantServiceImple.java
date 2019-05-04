package com.powertech.nelson.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powertech.nelson.dao.PlantDao;
import com.powertech.nelson.entity.Plant;
import com.powertech.nelson.service.PlantService;

@Service
public class PlantServiceImple implements PlantService {
	
	@Autowired
	private PlantDao plantDao;
	
	public String save(Plant plant) {
		plantDao.save(plant);
		return "Plant Saved Successfully";
	}

	
	public List<Plant> findAll() {		
		return (List<Plant>) plantDao.findAll();
	}

	public Optional<Plant> findById(Long id) {		
		return plantDao.findById(id);
	}

}
