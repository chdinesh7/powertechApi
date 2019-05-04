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
import com.powertech.nelson.exceptions.MessageDTO;
import com.powertech.nelson.service.ActivityService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	
	@PostMapping("/activity")
	@ApiOperation(value = "activity", notes = "activity")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<String> save(@RequestBody Activity activity) {
		return new ResponseEntity<String>(activityService.save(activity), HttpStatus.OK);
	}
	
	@GetMapping(value = "/allActivities")
	@ApiOperation(value = "allActivities", notes = "allActivities")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<Activity>> allActivities() {		
		return new ResponseEntity<List<Activity>>(activityService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value="/singleActivity")
	@ApiOperation(value = "singleActivity", notes = "singleActivity")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
	@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<Activity> findById(@RequestParam Long id) {		
		return new ResponseEntity<Activity>(activityService.findById(id).get(),HttpStatus.OK);
	}
}
