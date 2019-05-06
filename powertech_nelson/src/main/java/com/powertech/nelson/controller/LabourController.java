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


import com.powertech.nelson.entity.Labour;
import com.powertech.nelson.exceptions.MessageDTO;
import com.powertech.nelson.service.LabourService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class LabourController {
	@Autowired
	private LabourService labourService;
	
	@PostMapping("/labourtype")
	@ApiOperation(value = "labour", notes = "labour")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<String> save(@RequestBody Labour labour) {
		return new ResponseEntity<String>(labourService.save(labour), HttpStatus.OK);
	}
	
	@GetMapping(value = "/allLabours")
	@ApiOperation(value = "allLabours", notes = "allLabours")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<Labour>> allActivities() {		
		return new ResponseEntity<List<Labour>>(labourService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value="/singleLabourType")
	@ApiOperation(value = "singleLabourType", notes = "singleLabourType")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
	@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<Labour> findById(@RequestParam Long id) {		
		return new ResponseEntity<Labour>(labourService.findById(id).get(),HttpStatus.OK);
	}
} 
