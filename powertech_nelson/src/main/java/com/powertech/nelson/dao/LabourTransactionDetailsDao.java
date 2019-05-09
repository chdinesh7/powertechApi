package com.powertech.nelson.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.powertech.nelson.entity.LabourTransactionDetails;

public interface LabourTransactionDetailsDao extends CrudRepository<LabourTransactionDetails, Long> {

}
