package com.powertech.nelson.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powertech.nelson.dao.ActivityDao;
import com.powertech.nelson.entity.Activity;
import com.powertech.nelson.service.ActivityService;
@Service
public class ActivityServiceImple implements ActivityService {
	
	@Autowired
	private ActivityDao activityDao;
	
	public String save(Activity activity) {
		activityDao.save(activity);
		return "Activity Saved Successfully";
	}

	@Override
	public List<Activity> findAll() {		
		return (List<Activity>) activityDao.findAll();
	}

	@Override
	public Optional<Activity> findById(Long id) {
		 
		return activityDao.findById(id);
	}

	
}
