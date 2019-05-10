package com.powertech.nelson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.powertech.nelson.entity.LabourTransaction;
import com.powertech.nelson.entity.LabourTransactionDetails;
import com.powertech.nelson.entity.PlantTransaction;
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

	@PostMapping("/transaction/labourUpdate")
	@ApiOperation(value = "labourTransactionUpdate", notes = "labourTransactionUpdate")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<String> update(@RequestBody LabourTransaction labourTransaction) {
		return new ResponseEntity<String>(labourTansactionService.update(labourTransaction), HttpStatus.OK);
	}

	
	@GetMapping(value = "/transaction/allLabours")
	@ApiOperation(value = "allLaboursTransaction", notes = "allLaboursTransaction")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<LabourTransaction>> allActivities() {
		return new ResponseEntity<List<LabourTransaction>>(labourTansactionService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/transaction/singleLabourType")
	@ApiOperation(value = "singleLabourTransaction", notes = "singleLabourTransaction")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<LabourTransaction> findById(@RequestParam Long id) {
		return new ResponseEntity<LabourTransaction>(labourTansactionService.findById(id).get(), HttpStatus.OK);
	}

	

	@PostMapping(value = "/transaction/labour_emp_find")
	@ApiOperation(value = "employee find", notes = "employee find")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<LabourTransaction>> find(@RequestParam String emp_id) {
		return new ResponseEntity<List<LabourTransaction>>(labourTansactionService.empFind(emp_id), HttpStatus.OK);
	}
	
	@PostMapping(value="/transaction/labour_datewise_find")
	@ApiOperation(value = "date wise find", notes = "date wise find")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<LabourTransaction>> find(@RequestParam String from,@RequestParam String to) {
	return new ResponseEntity<List<LabourTransaction>>(labourTansactionService.dateWise(from, to), HttpStatus.OK);
	}
	
	@GetMapping(value = "/transaction/singleLaboursDetails")
	@ApiOperation(value = "singleLaboursDetails", notes = "singleLaboursDetails")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<LabourTransactionDetails> singleLD(@RequestParam Long id) {
		return new ResponseEntity<LabourTransactionDetails>(labourTansactionService.labourD(id).get(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/transaction/labourdelete")
	@ApiOperation(value = "labourTransactionDetails", notes = "labourTransactionDetails")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long id) {
		return new ResponseEntity<String>(labourTansactionService.delete(id), HttpStatus.OK);
	}
	

}
