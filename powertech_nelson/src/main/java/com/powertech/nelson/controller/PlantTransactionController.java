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


import com.powertech.nelson.entity.PlantTransaction;
import com.powertech.nelson.exceptions.MessageDTO;
import com.powertech.nelson.service.PlantTransactionServie;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PlantTransactionController {

	@Autowired
	private PlantTransactionServie plantTransactionServie;
	
	@PostMapping("/transaction/plant")
	@ApiOperation(value = "plantTransaction", notes = "plantTransaction")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<String> save(@RequestBody PlantTransaction plantTransaction) {
		return new ResponseEntity<String>(plantTransactionServie.save(plantTransaction), HttpStatus.OK);
	}
	
	@GetMapping(value = "/transaction/allPlants")
	@ApiOperation(value = "allPlantsTransaction", notes = "allPlantsTransaction")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<PlantTransaction>> allActivities() {		
		return new ResponseEntity<List<PlantTransaction>>(plantTransactionServie.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value="/transaction/singlePlant")
	@ApiOperation(value = "singlePlantTransaction", notes = "singlePlantTransaction")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
	@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<PlantTransaction> findById(@RequestParam Long id) {		
		return new ResponseEntity<PlantTransaction>(plantTransactionServie.findById(id).get(),HttpStatus.OK);
	}
	
}
