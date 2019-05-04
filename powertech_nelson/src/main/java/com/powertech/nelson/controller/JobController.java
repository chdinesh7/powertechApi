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
import com.powertech.nelson.entity.Job;
import com.powertech.nelson.exceptions.MessageDTO;
import com.powertech.nelson.service.JobService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class JobController {
	@Autowired
	private JobService jobService;
	
	@PostMapping("/job")
	@ApiOperation(value = "job", notes = "job")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<String> save(@RequestBody Job job) {
		return new ResponseEntity<String>(jobService.save(job), HttpStatus.OK);
	}
	
	@GetMapping(value = "/allJobs")
	@ApiOperation(value = "allJobs", notes = "allJobs")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<Job>> allJobs() {		
		return new ResponseEntity<List<Job>>(jobService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value="/singleJob")
	@ApiOperation(value = "singleJob", notes = "singleJob")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
	@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<Job> findById(@RequestParam Long id) {		
		return new ResponseEntity<Job>(jobService.findById(id).get(),HttpStatus.OK);
	}
}
