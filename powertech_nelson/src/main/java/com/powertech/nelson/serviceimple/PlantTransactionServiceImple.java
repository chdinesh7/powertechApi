package com.powertech.nelson.serviceimple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powertech.nelson.dao.EmployeeLabourDao;
import com.powertech.nelson.dao.JobDao;
import com.powertech.nelson.dao.PlantActivityDao;
import com.powertech.nelson.dao.PlantDao;
import com.powertech.nelson.dao.PlantTransactionDao;
import com.powertech.nelson.dao.PlantTransactionDetailsDao;
import com.powertech.nelson.entity.Activity;
import com.powertech.nelson.entity.EmployeeLabour;
import com.powertech.nelson.entity.Job;
import com.powertech.nelson.entity.Labour;
import com.powertech.nelson.entity.LabourTransaction;
import com.powertech.nelson.entity.Plant;
import com.powertech.nelson.entity.PlantActivity;
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

		return (List<PlantTransaction>) plantTransactionDao.findAll();
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

		Optional<PlantTransaction> plantSingle = plantTransactionDao.findById(plantTransaction.getId());
		if (plantSingle.isPresent()) {
			PlantTransaction p = plantSingle.get();
			p.setAllowance_first(plantTransaction.getAllowance_first());
			p.setAllowance_second(plantTransaction.getAllowance_second());
			p.setEmp_id(plantTransaction.getEmp_id());
			p.setPalnt_code(plantTransaction.getPalnt_code());
			List<PlantTransactionDetails> child = new ArrayList<>();

			plantTransaction.getPlantTransactionDetails().forEach(newitem -> {
				p.getPlantTransactionDetails().forEach(item -> {
					if (newitem.getId() == item.getId()) {
						child.add(newitem);

					} else {
						child.add(item);
					}
				});
				if (newitem.getId() == 0) {

					child.add(newitem);
				}
			});

			p.setPlantTransactionDetails(child);
			plantTransactionDao.save(p);

		} else {

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

	@Autowired
	private EmployeeLabourDao employeeLabourDao;

	@Override
	public List<PlantTransaction> empSarch(String emp_name) {
		List<EmployeeLabour> empMaster = employeeLabourDao.empFind(emp_name);
		List<PlantTransaction> listFind = new ArrayList<>();
		empMaster.forEach(item -> {
			List<PlantTransaction> f = plantTransactionDao.empFind(item.getId());
			f.forEach(i -> {
				i.setEmp_id(item.getFirestName() + "@" + item.getEmployeeId());
				
				Optional<Plant> plant = plantDao.findById(Long.parseLong(i.getPalnt_code()));
				i.setPalnt_code(plant.get().getPlant_id()+"@"+plant.get().getId());
				listFind.add(i);
				
			});
			
		});
		return listFind;

	}
	
	@Autowired
	private PlantDao plantDao;
	
	@Autowired
	private PlantActivityDao plantActivityDao;
	
	@Autowired
	private JobDao jobDao;

	@Override
	public List<PlantTransaction> report(Long id) {
		Optional<PlantTransaction> single=plantTransactionDao.findById(id);
		List<PlantTransaction> listFind = new ArrayList<>();
		Optional<EmployeeLabour> emp;
		Optional<Plant> plant;
		if (single.isPresent()) {
			PlantTransaction re=single.get();
			emp=employeeLabourDao.findById(Long.parseLong(re.getEmp_id()));
			plant=plantDao.findById(Long.parseLong(re.getPalnt_code()));
			
			re.setEmp_id(emp.get().getFirestName()+"@"+emp.get().getEmployeeId()+"@"+emp.get().getId());
			re.setPalnt_code(plant.get().getPlant_id()+"@"+plant.get().getId());
			re.getPlantTransactionDetails().forEach(item ->{
				Optional<PlantActivity> act=plantActivityDao.findById(Long.parseLong(item.getP_activity_type()));
				Optional<Job> job= jobDao.findById(Long.parseLong(item.getJob_no()));
				item.setP_activity_type(act.get().getPlant_activity_type()+"@"+act.get().getId());
				item.setJob_no(job.get().getJob_type()+"@"+job.get().getId());
			});
			listFind.add(re);
		}
		
		return listFind;
	}
	
	


}
