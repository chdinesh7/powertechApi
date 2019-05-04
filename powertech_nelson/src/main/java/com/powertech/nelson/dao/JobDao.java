package com.powertech.nelson.dao;

import org.springframework.data.repository.CrudRepository;

import com.powertech.nelson.entity.Job;

public interface JobDao extends CrudRepository<Job, Long> {

}
