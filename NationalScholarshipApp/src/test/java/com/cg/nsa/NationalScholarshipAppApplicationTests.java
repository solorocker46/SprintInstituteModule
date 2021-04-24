package com.cg.nsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.entity.User;
import com.cg.nsa.exception.UniqueElementException;
import com.cg.nsa.exception.ValidationException;
import com.cg.nsa.service.IInstituteService;

@SpringBootTest
class NationalScholarshipAppApplicationTests {

	@Autowired
	IInstituteService service;
	
	/*
	@Test
	void testInstitution() {
		Institution institution = new Institution("BIT@543", "BIT@783", "Institution", 543, "Private", "Engineering", "BIT", "VTU", "VVPuram", "Bangalore", "Karnataka", 1965, "8990443276", "Raghav Prasad", "Pending");
		assertEquals(institution, service.addInstitute(institution));
	}
	*/
	
	/*
	@Test
	void testInstitutionIntegrity()
	{
		Institution institution = new Institution("BIT@783", "BIT@783", "Institution", 234, "Private", "Engineering", "BIT", "VTU", "VVPuram", "Bangalore", "Karnataka", 1965, "8990443276", "Raghav Prasad", "Pending");
		assertThrows(UniqueElementException.class, () -> service.addInstitute(institution));
	}
	*/
	
	/*@Test
	void testInstituteIdAttribute()
	{
		Institution institution = new Institution("BIT@783", "BIT@783", "Institution", 234, "Private", "Engineering", "BIT", "VTU", "VVPuram", "Bangalore", "Karnataka", 1965, "8990443276", "Raghav Prasad", "Pending");
		assertThrows(UniqueElementException.class, () -> service.addInstitute(institution));
	}*/
	
	@Test
	void testValidation()
	{
		Institution institution = new Institution("BIT@890", "BIT@jg", "Institution", 888, "Private", "Engineering", "BIT", "VTU", "", "Bangalore", "Karnataka", 1965, "8990443276", "Raghav Prasad", "Pending");
		assertThrows(ValidationException.class, () -> service.addInstitute(institution));
	}

}
