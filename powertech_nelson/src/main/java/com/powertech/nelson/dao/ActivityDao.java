package com.powertech.nelson.dao;

import org.springframework.data.repository.CrudRepository;

import com.powertech.nelson.entity.Activity;

public interface ActivityDao extends CrudRepository<Activity, Long> {

}
