package com.powertech.nelson.serviceimple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powertech.nelson.dao.ActivityDao;
import com.powertech.nelson.dao.EmployeeLabourDao;
import com.powertech.nelson.dao.JobDao;
import com.powertech.nelson.dao.LabourDao;
import com.powertech.nelson.dao.LabourTransactionDao;
import com.powertech.nelson.dao.LabourTransactionDetailsDao;
import com.powertech.nelson.dto.LabourTransationDTO;
import com.powertech.nelson.entity.Activity;
import com.powertech.nelson.entity.EmployeeLabour;
import com.powertech.nelson.entity.Job;
import com.powertech.nelson.entity.Labour;
import com.powertech.nelson.entity.LabourTransaction;
import com.powertech.nelson.entity.LabourTransactionDetails;
import com.powertech.nelson.entity.PlantTransaction;
import com.powertech.nelson.service.LabourTansactionService;

@Service
public class LabourTransactionServiceImple implements LabourTansactionService {

	@Autowired
	private LabourTransactionDao labourTransactionDao;

	@Autowired
	private LabourTransactionDetailsDao labourTransactionDetailsDao;

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

	@Override
	public List<LabourTransaction> empFind(String emp_id) {
		return labourTransactionDao.empFind(emp_id);
	}

	@Override
	public String update(LabourTransaction labourTransaction) {

		Optional<LabourTransaction> labourOp = labourTransactionDao.findById(labourTransaction.getId());
		if (labourOp.isPresent()) {
			LabourTransaction l = labourOp.get();
			l.setAllowance_first(labourTransaction.getAllowance_first());
			l.setAllowance_second(labourTransaction.getAllowance_second());
			l.setEmp_id(labourTransaction.getEmp_id());
			l.setLabour_type(labourTransaction.getLabour_type());

			List<LabourTransactionDetails> child = new ArrayList<>();

			labourTransaction.getLabourTransactionDetails().forEach(newitem -> {

				l.getLabourTransactionDetails().forEach(item -> {

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

			l.setLabourTransactionDetails(child);

			labourTransactionDao.save(l);

		} else {

		}

		return "Labour Transaction Updated Successfully";
	}

	@Override
	public List<LabourTransaction> dateWise(String from, String to) {

		return labourTransactionDao.findDateWise(from, to);
	}

	@Override
	public Optional<LabourTransactionDetails> labourD(Long id) {

		return labourTransactionDetailsDao.findById(id);
	}

	@Override
	public String delete(Long id) {
		labourTransactionDetailsDao.deleteById(id);
		return "Labour Transaction Details deleted Successfully";
	}

	@Autowired
	private EmployeeLabourDao employeeLabourDao;

	@Override
	public List<LabourTransaction> empSarch(String emp_name) {

		List<EmployeeLabour> empMaster = employeeLabourDao.empFind(emp_name);
		List<LabourTransaction> listFind = new ArrayList<>();
		empMaster.forEach(item -> {
			List<LabourTransaction> f = labourTransactionDao.empFind(item.getId());
			f.forEach(i -> {
				i.setEmp_id(item.getFirestName()+"@"+item.getEmployeeId());
			
				listFind.add(i);
			});
		});
		
		return listFind;
	}
	
	@Autowired
	private LabourDao labourDao;
	
	@Autowired
	private ActivityDao activityDao;
	
	@Autowired
	private JobDao jobDao;
	
	@Override
	public List<LabourTransaction> report(Long id) {		
		Optional<LabourTransaction> single=labourTransactionDao.findById(id);
		List<LabourTransaction> listFind = new ArrayList<>();
		Optional<EmployeeLabour> emp;
		Optional<Labour> lab;
		
		if (single.isPresent()) {
			LabourTransaction re=single.get();
			emp=employeeLabourDao.findById(Long.parseLong(re.getEmp_id()));
			lab=labourDao.findById(Long.parseLong(re.getLabour_type()));
			
			re.setEmp_id(emp.get().getFirestName()+"@"+emp.get().getEmployeeId()+"@"+emp.get().getId());			
			re.setLabour_type(lab.get().getLabour_type()+"@"+lab.get().getId());
			re.getLabourTransactionDetails().forEach(i ->{
				
				Optional<Activity> act=activityDao.findById(Long.parseLong(i.getActivity_type()));
				Optional<Job> job= jobDao.findById(Long.parseLong(i.getJob_no()));
				
				i.setActivity_type(act.get().getActivity_type()+"@"+act.get().getId());
				i.setJob_no(job.get().getJob_type()+"@"+job.get().getId());
				
			});
			listFind.add(re);
		}
		return listFind;
	}

}
