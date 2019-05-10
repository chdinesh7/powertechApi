package com.powertech.nelson.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "Plant", description = "Plant Details")
@Entity
@Table
public class Plant extends Auditable<String> {
	@ApiModelProperty(value = "The unique identifier of the given plant", readOnly = true)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@ApiModelProperty(value = "plantname", required = false)
	private String plant_name;
	@ApiModelProperty(value = "plantid", required = false)
	private String plant_id;
	@ApiModelProperty(value = "longitude", required = false)
	private String longitude;
	@ApiModelProperty(value = "latitude", required = false)
	private String latitude;
	@ApiModelProperty(value = "address", required = false)
	private String address;
	@ApiModelProperty(value = "address1", required = false)
	private String address1;
	@ApiModelProperty(value = "address2", required = false)
	private String address2;
	@ApiModelProperty(value = "phone", required = false)
	private String phone;
	@ApiModelProperty(value = "email", required = false)
	private String email;	
	@ApiModelProperty(value = "fax", required = false)
	private String fax;
	@ApiModelProperty(value = "website", required = false)
	private String website;
	@ApiModelProperty(value = "plant_description", required = false)
	private String plant_description;
	
	public Plant() {}

	public Plant(long id, String plant_name, String plant_id, String longitude, String latitude, String address,
			String address1, String address2, String phone, String email, String fax, String website,
			String plant_description) {		
		this.id = id;
		this.plant_name = plant_name;
		this.plant_id = plant_id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.address = address;
		this.address1 = address1;
		this.address2 = address2;
		this.phone = phone;
		this.email = email;
		this.fax = fax;
		this.website = website;
		this.plant_description = plant_description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlant_name() {
		return plant_name;
	}

	public void setPlant_name(String plant_name) {
		this.plant_name = plant_name;
	}

	public String getPlant_id() {
		return plant_id;
	}

	public void setPlant_id(String plant_id) {
		this.plant_id = plant_id;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPlant_description() {
		return plant_description;
	}

	public void setPlant_description(String plant_description) {
		this.plant_description = plant_description;
	}
	
	
	
	
	
	
	
}
