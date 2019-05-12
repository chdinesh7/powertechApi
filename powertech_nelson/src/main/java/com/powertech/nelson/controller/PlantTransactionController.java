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
import com.powertech.nelson.entity.LabourTransactionDetails;
import com.powertech.nelson.entity.PlantTransaction;
import com.powertech.nelson.entity.PlantTransactionDetails;
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
	
	@PostMapping("/transaction/plantUpdate")
	@ApiOperation(value = "plantTransactionUpdate", notes = "plantTransactionUpdate")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<String> update(@RequestBody PlantTransaction plantTransaction) {
		return new ResponseEntity<String>(plantTransactionServie.update(plantTransaction), HttpStatus.OK);
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
	
	
	@PostMapping(value="/transaction/plantfind")
	@ApiOperation(value = "plantTransaction find", notes = "plantTransaction find")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<PlantTransaction>> find(@RequestParam String from,@RequestParam String to) {
		return new ResponseEntity<List<PlantTransaction>>(plantTransactionServie.find(from, to), HttpStatus.OK);
	}
	
	@PostMapping(value = "/transaction/plant_emp_find")
	@ApiOperation(value = "palnt employee find", notes = "palnt employee find")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<PlantTransaction>> find(@RequestParam String emp_id) {
		return new ResponseEntity<List<PlantTransaction>>(plantTransactionServie.empFind(emp_id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/transaction/singlePlantDetails")
	@ApiOperation(value = "singlePlantDetails", notes = "singlePlantDetails")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<PlantTransactionDetails> singleLD(@RequestParam Long id) {
		return new ResponseEntity<PlantTransactionDetails>(plantTransactionServie.plantD(id).get(), HttpStatus.OK);
	}
	
	@PostMapping(value="/transaction/single_plant_details_delete")
	@ApiOperation(value = "single plantTransactionDetails delete", notes = "single plantTransactionDetails delete")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long id) {
		return new ResponseEntity<String>(plantTransactionServie.delete(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/transaction/plantempsarch")
	@ApiOperation(value = "plant tran empsarch", notes = "plant tran empsarch")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad request", response = MessageDTO.class) })
	@ResponseBody
	public ResponseEntity<List<PlantTransaction>> empSarch(@RequestParam String emp_name) {		
		return new ResponseEntity<List<PlantTransaction>>(plantTransactionServie.empSarch(emp_name),HttpStatus.OK);
	}
	
	
}
