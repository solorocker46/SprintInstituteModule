package com.cg.nsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.service.IInstituteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Institution controller")
@RestController
@RequestMapping("/institution")
public class InstituteController {
	
	@Autowired
	IInstituteService service;
	
	@ApiOperation("Add new institute")
	@PostMapping("/addInstitute")
	public ResponseEntity<Object> addInstitute(@RequestBody Institution institution)
	{
		service.addInstitute(institution);
		return new ResponseEntity<Object>("Added successfully", HttpStatus.OK);
	}
	
	@ApiOperation("Get all institutes")
	@GetMapping("/getAllInstitutes")
	public List<Institution> getAllInstitutes()
	{
		return service.getAllInstitutes();
	}
	
	@ApiOperation("Get institute by code")
	@GetMapping("/getInstituteByCode/{code}")
	public Institution getInstituteByCode(@PathVariable int code)
	{
		
		try
		{
			return service.getInstitute(code);
		}
		catch(InvalidInstitutionException exception)
		{
			throw new InvalidInstitutionException("The above code doesn't exist");
		}
	}
	
	@ApiOperation("Get institute by state")
	@GetMapping("/getInstituteByState/{state}")
	public List<Institution> getInstituteByState(@PathVariable String state)
	{
		return service.getInstitutesByState(state);
	}
	
	@ApiOperation("Edit institute details")
	@PutMapping("/editInstituteDetails/{userId}")
	public ResponseEntity<Object> editInstituteDetails(@PathVariable String userId, @RequestBody Institution institution)
	{
		service.editInstitute(userId, institution);
		return new ResponseEntity<Object>("Edited details successfully", HttpStatus.OK);
	}
	
	@ApiOperation("Update status")
	@PutMapping("/updateStatus/{code}")
	public ResponseEntity<Object> updateStatus(@PathVariable int code, @RequestBody Institution institution)
	{
		service.statusUpdate(code, institution);
		return new ResponseEntity<Object>("Updated successfully", HttpStatus.OK);
	}
}
