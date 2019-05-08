package com.powertech.nelson.service;

import java.util.List;
import java.util.Optional;

import com.powertech.nelson.entity.LabourTransaction;

public interface LabourTansactionService {
	
	public String save(LabourTransaction labourTransaction);
	public List<LabourTransaction> findAll();
	public Optional<LabourTransaction> findById(Long id);
	
	public String delete(Long id);
}
