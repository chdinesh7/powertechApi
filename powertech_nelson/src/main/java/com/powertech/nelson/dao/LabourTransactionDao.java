package com.powertech.nelson.dao;

import org.springframework.data.repository.CrudRepository;

import com.powertech.nelson.entity.LabourTransaction;

public interface LabourTransactionDao extends CrudRepository<LabourTransaction, Long> {

}
