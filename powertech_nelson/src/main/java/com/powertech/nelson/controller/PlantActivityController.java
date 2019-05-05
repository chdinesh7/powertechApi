package com.powertech.nelson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.powertech.nelson.entity.Activity;
import com.powertech.nelson.entity.PlantActivity;
import com.powertech.nelson.exceptions.MessageDTO;
import com.powertech.nelson.service.PlantActivityService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PlantActivityController {
	
	@Autowired
	private PlantActivityService plantActivityService;
	
	@PostMapping("/plantActivity")
	@ApiOperation(value = "plantActivity", notes = "plantActivity")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<String> save(@RequestBody PlantActivity plantActivity) {
		return new ResponseEntity<String>(plantActivityService.save(plantActivity), HttpStatus.OK);
	}
	
	@GetMapping(value = "/allPlantActivities")
	@ApiOperation(value = "allPlantActivities", notes = "allPlantActivities")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<PlantActivity>> allPlantActivities() {		
		return new ResponseEntity<List<PlantActivity>>(plantActivityService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value="/singlePlantActivities")
	@ApiOperation(value = "singlePlantActivities", notes = "singlePlantActivities")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
	@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<PlantActivity> findById(@RequestParam Long id) {		
		return new ResponseEntity<PlantActivity>(plantActivityService.findById(id).get(),HttpStatus.OK);
	}
}
