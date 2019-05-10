package com.powertech.nelson.serviceimple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powertech.nelson.dao.PlantTransactionDao;
import com.powertech.nelson.dao.PlantTransactionDetailsDao;
import com.powertech.nelson.entity.PlantTransaction;
import com.powertech.nelson.entity.PlantTransactionDetails;
import com.powertech.nelson.service.PlantTransactionServie;
@Service
public class PlantTransactionServiceImple implements PlantTransactionServie {
	
	@Autowired
	private PlantTransactionDao plantTransactionDao;
	
	@Autowired
	private PlantTransactionDetailsDao plantTransactionDetailsDao;
	
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
	public List<PlantTransaction> find(String from, String to) {
	
		return plantTransactionDao.find(from, to);
	}

	@Override
	public List<PlantTransaction> empFind(String emp_id) {
		
		return plantTransactionDao.empFind(emp_id);
	}

	@Override
	public String update(PlantTransaction plantTransaction) {
		
		 Optional<PlantTransaction>  plantSingle=	plantTransactionDao.findById(plantTransaction.getId());
		    if (plantSingle.isPresent()){
		    	PlantTransaction p = plantSingle.get();
		    	p.setAllowance_first(plantTransaction.getAllowance_first());
		    	p.setAllowance_second(plantTransaction.getAllowance_second());
		    	p.setEmp_id(plantTransaction.getEmp_id());
		    	p.setPalnt_code(plantTransaction.getPalnt_code());		    	
		    	List<PlantTransactionDetails> child=new ArrayList<>();    		 
		    		    		   
		    	plantTransaction.getPlantTransactionDetails().forEach(newitem ->{		    			 
		    			   p.getPlantTransactionDetails().forEach(item -> { 		    				   
		 	    			  if(newitem.getId() == item.getId()) {	 	    			
		 	    				  child.add(newitem);				
		 	    				  
		 	    			  }else {	 	    				 
			    			   child.add(item);
		 	    			  }
			    	        });	    			  
		    			   if(newitem.getId()==0) {	
		    				  
		    			   child.add(newitem);
		    			   }
		    		   });	    	     
		    		 
		    	p.setPlantTransactionDetails(child);		    	   
		    	plantTransactionDao.save(p);
		       
		    }
		    else{
		      
		    }
		
		return null;
	}

	@Override
	public Optional<PlantTransactionDetails> plantD(Long id) {
		
		return plantTransactionDetailsDao.findById(id);
	}
	
	@Override
	public String delete(Long id) {
		plantTransactionDetailsDao.deleteById(id);
		return "Plant Transaction Details child deleted Successfully";
	}

}
