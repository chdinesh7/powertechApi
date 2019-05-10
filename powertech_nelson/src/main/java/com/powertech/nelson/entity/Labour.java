package com.powertech.nelson.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Lobour", description = "Lobour Details")
@Entity
@Table
public class Labour extends Auditable<String> {
	@ApiModelProperty(value = "The unique identifier of the given labour", readOnly = true)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@ApiModelProperty(value = "labourtype", required = false)
	private String labour_type;
	
	public Labour() {	}

	public Labour(long id, String labour_type) {		
		this.id = id;
		this.labour_type = labour_type;
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
	
	
	
	
	
	

}
