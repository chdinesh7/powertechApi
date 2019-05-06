package com.powertech.nelson.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powertech.nelson.dao.LabourTransactionDao;
import com.powertech.nelson.entity.LabourTransaction;
import com.powertech.nelson.service.LabourTansactionService;
@Service
public class LabourTransactionServiceImple implements LabourTansactionService {
	
	@Autowired
	private LabourTransactionDao labourTransactionDao;
	
	@Override
	public String save(LabourTransaction labourTransaction) {
		labourTransactionDao.save(labourTransaction);
		return "Labour Transaction Saved Successfully";
	}

	@Override
	public List<LabourTransaction> findAll() {		
		return (List<LabourTransaction>) labourTransactionDao.findAll();
	}

	@Override
	public Optional<LabourTransaction> findById(Long id) {		
		return labourTransactionDao.findById(id);
	}

}
