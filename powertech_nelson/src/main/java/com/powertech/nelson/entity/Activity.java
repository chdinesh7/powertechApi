package com.powertech.nelson.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Activity", description = "Activity Details")
@Entity
@Table
public class Activity extends Auditable<String> {
	@ApiModelProperty(value = "The unique identifier of the given activity", readOnly = true)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@ApiModelProperty(value = "activitytype", required = false)
	private String activity_type;
	public Activity() {}
	
	public Activity(long id, String activity_type) {		
		this.id = id;
		this.activity_type = activity_type;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getActivity_type() {
		return activity_type;
	}
	public void setActivity_type(String activity_type) {
		this.activity_type = activity_type;
	}
	
	
	

}
