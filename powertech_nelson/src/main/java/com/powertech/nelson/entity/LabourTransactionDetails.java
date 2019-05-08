package com.powertech.nelson.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class LabourTransactionDetails {
	@ApiModelProperty(value = "The unique identifier of the given LabourTransactionDetails", readOnly = true)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@ApiModelProperty(value = "activitytype", required = false)
	private String activity_type;
	@ApiModelProperty(value = "jobno", required = false)
	private String job_no;	
	@ApiModelProperty(value = "date", required = false)
	private Date date;
	@ApiModelProperty(value = "time", required = false)
	private String time;	
	@ApiModelProperty(value = "description", required = false)
	private String description;
	
	public LabourTransactionDetails() {
		
	}	

	public LabourTransactionDetails(long id, String activity_type, String job_no, Date date, String time,
			String description) {
		
		this.id = id;
		this.activity_type = activity_type;
		this.job_no = job_no;
		this.date = date;
		this.time = time;
		this.description = description;
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

	public String getJob_no() {
		return job_no;
	}

	public void setJob_no(String job_no) {
		this.job_no = job_no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	

}
