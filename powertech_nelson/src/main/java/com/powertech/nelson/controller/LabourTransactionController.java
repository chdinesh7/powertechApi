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

import com.powertech.nelson.entity.LabourTransaction;
import com.powertech.nelson.exceptions.MessageDTO;
import com.powertech.nelson.service.LabourTansactionService;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class LabourTransactionController {

	@Autowired
	private LabourTansactionService labourTansactionService;
	
	@PostMapping("/transaction/labour")
	@ApiOperation(value = "labourTransaction", notes = "labourTransaction")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<String> save(@RequestBody LabourTransaction labourTransaction) {
		return new ResponseEntity<String>(labourTansactionService.save(labourTransaction), HttpStatus.OK);
	}
	
	@GetMapping(value = "/transaction/allLabours")
	@ApiOperation(value = "allLaboursTransaction", notes = "allLaboursTransaction")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<LabourTransaction>> allActivities() {		
		return new ResponseEntity<List<LabourTransaction>>(labourTansactionService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value="/transaction/singleLabourType")
	@ApiOperation(value = "singleLabourTransaction", notes = "singleLabourTransaction")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
	@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<LabourTransaction> findById(@RequestParam Long id) {		
		return new ResponseEntity<LabourTransaction>(labourTansactionService.findById(id).get(),HttpStatus.OK);
	}
	
	@PostMapping(value="/transaction/labourdelete")
	@ApiOperation(value = "labourTransaction", notes = "labourTransaction")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long id) {
		return new ResponseEntity<String>(labourTansactionService.delete(id), HttpStatus.OK);
	}
	
}
