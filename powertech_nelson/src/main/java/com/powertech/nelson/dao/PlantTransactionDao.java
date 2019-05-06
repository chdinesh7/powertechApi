package com.powertech.nelson.dao;

import org.springframework.data.repository.CrudRepository;

import com.powertech.nelson.entity.PlantTransaction;

public interface PlantTransactionDao extends CrudRepository<PlantTransaction, Long> {

}
