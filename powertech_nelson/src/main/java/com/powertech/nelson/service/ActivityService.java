package com.powertech.nelson.service;

import java.util.List;
import java.util.Optional;

import com.powertech.nelson.entity.Activity;

public interface ActivityService {	

	public String save(Activity activity);
	public List<Activity> findAll();
	public Optional<Activity> findById(Long id);
}
