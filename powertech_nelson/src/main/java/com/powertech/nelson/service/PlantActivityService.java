package com.powertech.nelson.service;

import java.util.List;
import java.util.Optional;


import com.powertech.nelson.entity.PlantActivity;

public interface PlantActivityService {
	public String save(PlantActivity plantActivity);
	public List<PlantActivity> findAll();
	public Optional<PlantActivity> findById(Long id);
}
