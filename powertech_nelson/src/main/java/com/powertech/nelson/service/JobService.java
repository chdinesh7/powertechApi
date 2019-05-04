package com.powertech.nelson.service;

import java.util.List;
import java.util.Optional;

import com.powertech.nelson.entity.Job;

public interface JobService {
	public String save(Job job);
	public List<Job> findAll();
	public Optional<Job> findById(Long id);

}
