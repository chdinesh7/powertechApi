package com.powertech.nelson.service;

import java.util.List;
import java.util.Optional;

import com.powertech.nelson.entity.Plant;

public interface PlantService {
	public String save(Plant plant);
	public List<Plant> findAll();
	public Optional<Plant> findById(Long id);
}
