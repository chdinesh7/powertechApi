package com.powertech.nelson.service;

import java.util.List;
import java.util.Optional;

import com.powertech.nelson.entity.PlantTransaction;

public interface PlantTransactionServie {
	
	public String save(PlantTransaction plantTransaction);
	public List<PlantTransaction> findAll();
	public Optional<PlantTransaction> findById(Long id);
	
	public String delete(Long id);
	
	//Report date wise
	public List<PlantTransaction> find(String from,String to);
	
}
