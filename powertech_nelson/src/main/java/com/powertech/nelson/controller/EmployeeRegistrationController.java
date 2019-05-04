package com.powertech.nelson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.powertech.nelson.entity.Activity;
import com.powertech.nelson.entity.EmployeeRegistration;
import com.powertech.nelson.exceptions.MessageDTO;
import com.powertech.nelson.service.EmpolyeeRegistrationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/users")
public class EmployeeRegistrationController {
	@Autowired
	private EmpolyeeRegistrationService  employeeRegistrationService;
	
	
	@PostMapping("/sign-up")
	@ApiOperation(value = "registration", notes = "registration")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<String> save(@RequestBody EmployeeRegistration employeeRegistration) {
		return new ResponseEntity<String>(employeeRegistrationService.save(employeeRegistration), HttpStatus.OK);
	}
	
	@GetMapping(value = "/allEmplyee")
	@ApiOperation(value = "allEmplyee", notes = "allEmplyee")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<EmployeeRegistration>> allEmployees() {		
		return new ResponseEntity<List<EmployeeRegistration>>(employeeRegistrationService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value="/singleEmplyee")
	@ApiOperation(value = "singleEmplyee", notes = "singleEmplyee")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
	@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<EmployeeRegistration> findById(@RequestParam Long id) {		
		return new ResponseEntity<EmployeeRegistration>(employeeRegistrationService.findById(id).get(),HttpStatus.OK);
	}
}
