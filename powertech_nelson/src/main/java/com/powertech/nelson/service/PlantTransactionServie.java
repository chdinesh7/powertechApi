package com.powertech.nelson.service;

import java.util.List;
import java.util.Optional;

import com.powertech.nelson.entity.LabourTransaction;
import com.powertech.nelson.entity.LabourTransactionDetails;
import com.powertech.nelson.entity.PlantTransaction;
import com.powertech.nelson.entity.PlantTransactionDetails;

public interface PlantTransactionServie {
	
	public String save(PlantTransaction plantTransaction);
	public List<PlantTransaction> findAll();
	public Optional<PlantTransaction> findById(Long id);
	public String update(PlantTransaction plantTransaction);
	
	
	//Report date wise
	public List<PlantTransaction> find(String from,String to);
	
	public List<PlantTransaction> empFind(String emp_id);
	
	public Optional<PlantTransactionDetails> plantD(Long id);
	public String delete(Long id);
	
}
