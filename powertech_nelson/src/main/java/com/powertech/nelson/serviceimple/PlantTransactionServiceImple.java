package com.powertech.nelson.serviceimple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powertech.nelson.dao.PlantTransactionDao;
import com.powertech.nelson.entity.PlantTransaction;
import com.powertech.nelson.service.PlantTransactionServie;
@Service
public class PlantTransactionServiceImple implements PlantTransactionServie {
	
	@Autowired
	private PlantTransactionDao plantTransactionDao;
	
	@Override
	public String save(PlantTransaction plantTransaction) {
		plantTransactionDao.save(plantTransaction);
		return "Plant Transaction Saved Successfully";
	}

	@Override
	public List<PlantTransaction> findAll() {
		
		return (List<PlantTransaction>) plantTransactionDao.findAll() ;
	}

	@Override
	public Optional<PlantTransaction> findById(Long id) {
		
		return plantTransactionDao.findById(id);
	}

	@Override
	public String delete(Long id) {
		plantTransactionDao.deleteById(id);
		return "Labour Transaction deleted Successfully";
	}

	@Override
	public List<PlantTransaction> find(String from, String to) {
	
		return plantTransactionDao.find(from, to);
	}

}
