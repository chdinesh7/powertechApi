package com.powertech.nelson.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import io.swagger.annotations.ApiModelProperty;

@Entity
public class PlantTransactionDetails {
	@ApiModelProperty(value = "The unique identifier of the given PlantTransactionDetails", readOnly = true)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ApiModelProperty(value = "plantactivitytype", required = false)
	private String p_activity_type;
	@ApiModelProperty(value = "jobno", required = false)
	private String job_no;
	@ApiModelProperty(value = "unit", required = false)
	private String unit;
	@ApiModelProperty(value = "date", required = false)
	private Date date;
	@ApiModelProperty(value = "description", required = false)
	private String description;
	
	public PlantTransactionDetails() {
		
	}

	public PlantTransactionDetails(long id, String p_activity_type, String job_no, String unit, Date date,
			String description) {
		super();
		this.id = id;
		this.p_activity_type = p_activity_type;
		this.job_no = job_no;
		this.unit = unit;
		this.date = date;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getP_activity_type() {
		return p_activity_type;
	}

	public void setP_activity_type(String p_activity_type) {
		this.p_activity_type = p_activity_type;
	}

	public String getJob_no() {
		return job_no;
	}

	public void setJob_no(String job_no) {
		this.job_no = job_no;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
		
	
}
