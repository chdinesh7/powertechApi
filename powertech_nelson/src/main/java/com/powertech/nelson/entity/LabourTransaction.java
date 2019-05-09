package com.powertech.nelson.entity;

import java.sql.Time;
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

@ApiModel(value = "LabourTransaction", description = "LabourTransaction Details")
@Entity
@Table
public class LabourTransaction {
	@ApiModelProperty(value = "The unique identifier of the given LabourTransaction", readOnly = true)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@ApiModelProperty(value = "labourtype", required = false)
	private String labour_type;
	@ApiModelProperty(value = "employeeId", required = false)
	private String emp_id;
	@ApiModelProperty(value = "Fault Allowance First on", required = false)
	private String allowance_first;
	@ApiModelProperty(value = "Fault Allowance Second on", required = false)
	private String allowance_second;
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=LabourTransactionDetails.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "l_id", referencedColumnName="id")
	private List<LabourTransactionDetails> labourTransactionDetails = new ArrayList<>();
		
	public LabourTransaction() {}

	public LabourTransaction(long id, String labour_type, String emp_id, String allowance_first,
			String allowance_second, List<LabourTransactionDetails> labourTransactionDetails) {		
		this.id = id;
		this.labour_type = labour_type;
		this.emp_id = emp_id;
		this.allowance_first = allowance_first;
		this.allowance_second = allowance_second;
		this.labourTransactionDetails = labourTransactionDetails;
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

	public List<LabourTransactionDetails> getLabourTransactionDetails() {
		return labourTransactionDetails;
	}

	public void setLabourTransactionDetails(List<LabourTransactionDetails> labourTransactionDetails) {
		this.labourTransactionDetails = labourTransactionDetails;
	}



	
		

}
