package com.powertech.nelson.dto;

import com.powertech.nelson.entity.Activity;
import com.powertech.nelson.entity.EmployeeLabour;
import com.powertech.nelson.entity.Job;
import com.powertech.nelson.entity.Labour;

public class LabourTransationDTO {
	
	private Activity activity;
	private EmployeeLabour employeeLabour;	
	private Job job;
	private Labour labour;
	
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public EmployeeLabour getEmployeeLabour() {
		return employeeLabour;
	}
	public void setEmployeeLabour(EmployeeLabour employeeLabour) {
		this.employeeLabour = employeeLabour;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Labour getLabour() {
		return labour;
	}
	public void setLabour(Labour labour) {
		this.labour = labour;
	}
	
	

}
