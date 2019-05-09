package com.powertech.nelson.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.powertech.nelson.entity.LabourTransaction;
import com.powertech.nelson.entity.LabourTransactionDetails;


public interface LabourTransactionDao extends CrudRepository<LabourTransaction, Long> {
		
	@Query(value="SELECT * FROM labour_transaction  WHERE emp_id=?1",nativeQuery=true)
	public List<LabourTransaction> empFind(String emp_id);
	
	@Query(value="SELECT * FROM labour_transaction a,labour_transaction_details b  where a.id=b.l_id and b.date BETWEEN (:from) AND (:to)",nativeQuery=true)
	public List<LabourTransaction> findDateWise(@Param("from") String from,@Param("to") String to);
	
	
}
