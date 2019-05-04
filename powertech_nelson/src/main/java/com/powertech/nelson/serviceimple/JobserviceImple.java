package com.powertech.nelson.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powertech.nelson.dao.JobDao;
import com.powertech.nelson.entity.Job;
import com.powertech.nelson.service.JobService;
@Service
public class JobserviceImple implements JobService {
	
	@Autowired
	private JobDao jobDao;
	
	@Override
	public String save(Job job) {
		jobDao.save(job);
		return "Job Saved Successfully";
	}

	@Override
	public List<Job> findAll() {		
		return (List<Job>) jobDao.findAll();
	}

	@Override
	public Optional<Job> findById(Long id) {		
		return jobDao.findById(id);
	}

}
