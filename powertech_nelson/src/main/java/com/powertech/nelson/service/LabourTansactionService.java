package com.powertech.nelson.service;

import java.util.List;
import java.util.Optional;

import com.powertech.nelson.entity.LabourTransaction;
import com.powertech.nelson.entity.LabourTransactionDetails;
import com.powertech.nelson.entity.PlantTransaction;

public interface LabourTansactionService {
	
	public String save(LabourTransaction labourTransaction);
	public List<LabourTransaction> findAll();
	public Optional<LabourTransaction> findById(Long id);
	
	public String update(LabourTransaction labourTransaction);
	
	
	
	public List<LabourTransaction> empFind(String emp_id);
	public List<LabourTransaction> dateWise(String from,String to);
	
	public Optional<LabourTransactionDetails> labourD(Long id);
	
	public String delete(Long id);
}
