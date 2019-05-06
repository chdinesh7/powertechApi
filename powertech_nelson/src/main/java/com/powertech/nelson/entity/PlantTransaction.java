package com.powertech.nelson.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PlantTransaction", description = "PlantTransaction Details")
@Entity
@Table
public class PlantTransaction {
	@ApiModelProperty(value = "The unique identifier of the given PlantTransaction", readOnly = true)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@ApiModelProperty(value = "labourtype", required = false)
	private String labour_type;
	@ApiModelProperty(value = "employeeId", required = false)
	private String emp_id;
	@ApiModelProperty(value = "activitytype", required = false)
	private String activity_type;
	@ApiModelProperty(value = "jobno", required = false)
	private String job_no;
	@ApiModelProperty(value = "unit", required = false)
	private String unit;
	@ApiModelProperty(value = "date", required = false)
	private Date date;
	@ApiModelProperty(value = "description", required = false)
	private String description;
	
	public PlantTransaction() {}

	public PlantTransaction(long id, String labour_type, String emp_id, String activity_type, String job_no,
			String unit, Date date, String description) {	
		this.id = id;
		this.labour_type = labour_type;
		this.emp_id = emp_id;
		this.activity_type = activity_type;
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

	public String getLabour_type() {
		return labour_type;
	}

	public void setLabour_type(String labour_type) {
		this.labour_type = labour_type;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getActivity_type() {
		return activity_type;
	}

	public void setActivity_type(String activity_type) {
		this.activity_type = activity_type;
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
