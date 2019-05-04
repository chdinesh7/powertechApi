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

import com.powertech.nelson.entity.EmployeeLabour;
import com.powertech.nelson.exceptions.MessageDTO;
import com.powertech.nelson.service.EmployeeLabourService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeLabourController {
	
	@Autowired
	private EmployeeLabourService employeeLabourService;
	
	@PostMapping("/labour")
	@ApiOperation(value = "labour", notes = "labour")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<String> save(@RequestBody EmployeeLabour employeeLabour) {
		return new ResponseEntity<String>(employeeLabourService.save(employeeLabour), HttpStatus.OK);
	}
	
	@GetMapping(value = "/allLabour")
	@ApiOperation(value = "allEmplyee", notes = "allEmplyee")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<EmployeeLabour>> allEmployeesLabour() {		
		return new ResponseEntity<List<EmployeeLabour>>(employeeLabourService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value="/singleLabour")
	@ApiOperation(value = "singleEmplyeeLabour", notes = "singleEmplyeeLabour")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
	@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<EmployeeLabour> findById(@RequestParam Long id) {		
		return new ResponseEntity<EmployeeLabour>(employeeLabourService.findById(id).get(),HttpStatus.OK);
	}
}
