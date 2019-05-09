package com.powertech.nelson.service;

import java.util.List;
import java.util.Optional;

import com.powertech.nelson.entity.Labour;

public interface LabourService {
	public String save(Labour labour);
	public List<Labour> findAll();
	public Optional<Labour> findById(Long id);
	public String delete(Long id);
	
	
}
