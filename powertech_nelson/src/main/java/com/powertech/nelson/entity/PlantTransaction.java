package com.powertech.nelson.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PlantTransaction", description = "PlantTransaction")
@Entity
@Table
public class PlantTransaction {
	@ApiModelProperty(value = "The unique identifier of the given PlantTransaction", readOnly = true)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@ApiModelProperty(value = "palntcode", required = false)
	private String palnt_code;
	@ApiModelProperty(value = "employee id", required = false)
	private String emp_id;
	@ApiModelProperty(value = "Fault Allowance First on", required = false)
	private String allowance_first;
	@ApiModelProperty(value = "Fault Allowance Second on", required = false)
	private String allowance_second;
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=PlantTransactionDetails.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "p_id", referencedColumnName="id")
	private List<PlantTransactionDetails> plantTransactionDetails = new ArrayList<>();
	
	public PlantTransaction() {}

	public PlantTransaction(long id, String palnt_code, String allowance_first, String allowance_second,
			List<PlantTransactionDetails> plantTransactionDetails) {		
		this.id = id;
		this.palnt_code = palnt_code;
		this.allowance_first = allowance_first;
		this.allowance_second = allowance_second;
		this.plantTransactionDetails = plantTransactionDetails;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPalnt_code() {
		return palnt_code;
	}

	public void setPalnt_code(String palnt_code) {
		this.palnt_code = palnt_code;
	}

	public String getAllowance_first() {
		return allowance_first;
	}

	public void setAllowance_first(String allowance_first) {
		this.allowance_first = allowance_first;
	}

	public String getAllowance_second() {
		return allowance_second;
	}

	public void setAllowance_second(String allowance_second) {
		this.allowance_second = allowance_second;
	}

	public List<PlantTransactionDetails> getPlantTransactionDetails() {
		return plantTransactionDetails;
	}

	public void setPlantTransactionDetails(List<PlantTransactionDetails> plantTransactionDetails) {
		this.plantTransactionDetails = plantTransactionDetails;
	}
	
	
	
	

	
	

	
	
		
	
	
}
