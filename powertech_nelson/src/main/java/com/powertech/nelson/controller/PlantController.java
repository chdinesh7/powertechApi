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


import com.powertech.nelson.entity.Plant;
import com.powertech.nelson.exceptions.MessageDTO;
import com.powertech.nelson.service.PlantService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PlantController {
	@Autowired
	private PlantService plantService;
	
	@PostMapping("/plant")
	@ApiOperation(value = "plant", notes = "plant")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<String> save(@RequestBody Plant plant) {
		return new ResponseEntity<String>(plantService.save(plant), HttpStatus.OK);
	}
	
	@GetMapping(value = "/allPlants")
	@ApiOperation(value = "allPlants", notes = "allPlants")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<Plant>> allActivities() {		
		return new ResponseEntity<List<Plant>>(plantService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value="/singlePlant")
	@ApiOperation(value = "singlePlant", notes = "singlePlant")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
	@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<Plant> findById(@RequestParam Long id) {		
		return new ResponseEntity<Plant>(plantService.findById(id).get(),HttpStatus.OK);
	}
}
