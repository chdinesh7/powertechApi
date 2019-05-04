package com.powertech.nelson.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PlantActivity", description = "PlantActivity Details")
@Entity
@Table
public class PlantActivity {
	@ApiModelProperty(value = "The unique identifier of the given plant activity", readOnly = true)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@ApiModelProperty(value = "plantactivitytype", required = false)
	private String plant_activity_type;
}
