package com.powertech.nelson.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.powertech.nelson.entity.PlantTransaction;

public interface PlantTransactionDao extends CrudRepository<PlantTransaction, Long> {
	
	@Query(value="SELECT * FROM plant_transaction  WHERE date BETWEEN (:from) AND (:to)",nativeQuery=true)
	public List<PlantTransaction> find(@Param("from") String from,@Param("to") String to);
}
