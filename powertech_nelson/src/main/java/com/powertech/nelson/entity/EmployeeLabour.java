package com.powertech.nelson.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "EmployeeLabour Registration", description = "EmployeeLabour Registration Details")
@Entity
@Table(name = "emp_labour")
public class EmployeeLabour extends Auditable<String> {	
	@ApiModelProperty(value = "The unique identifier of the given EmployeeLabour", readOnly = true)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;	
	@ApiModelProperty(value = "employeeId", required = false)
    private String employeeId;
	@ApiModelProperty(value = "email", required = false)
    private String email;
	@ApiModelProperty(value = "mobile", required = false)
    private String mobile;
	@ApiModelProperty(value = "dob", required = false)
    private Date  dob;
	@ApiModelProperty(value = "address", required = false)
    private String address;
	@ApiModelProperty(value = "designation", required = false)
    private String designation;
	@ApiModelProperty(value = "department", required = false)
    private String department;
	@ApiModelProperty(value = "firestName", required = false)
	private String firestName;
	@ApiModelProperty(value = "lastName", required = false)
	private String lastName;
	@ApiModelProperty(value = "l_type", required = false)
	private String l_type;
	
	public EmployeeLabour() {}
	public EmployeeLabour(long id, String employeeId, String email, String mobile, Date dob, String address,
			String designation, String department, String firestName, String lastName, String l_type) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.email = email;
		this.mobile = mobile;
		this.dob = dob;
		this.address = address;
		this.designation = designation;
		this.department = department;
		this.firestName = firestName;
		this.lastName = lastName;
		this.l_type = l_type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getFirestName() {
		return firestName;
	}
	public void setFirestName(String firestName) {
		this.firestName = firestName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getL_type() {
		return l_type;
	}
	public void setL_type(String l_type) {
		this.l_type = l_type;
	}
	
	
	
	
	
	
}
