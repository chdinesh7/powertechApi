package com.powertech.nelson.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Job", description = "Job Details")
@Entity
@Table
public class Job extends Auditable<String> {
	@ApiModelProperty(value = "The unique identifier of the given job", readOnly = true)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@ApiModelProperty(value = "jobtype", required = false)
	private String job_type;
	public Job() {	}
	public Job(long id, String job_type) {		
		this.id = id;
		this.job_type = job_type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getJob_type() {
		return job_type;
	}
	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}
	
	
	
	

}
