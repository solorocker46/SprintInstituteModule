package com.cg.nsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.entity.User;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.exception.StateNotFoundException;
import com.cg.nsa.exception.UniqueElementException;
import com.cg.nsa.exception.UserIdNotFoundException;
import com.cg.nsa.exception.ValidationException;
import com.cg.nsa.service.IInstituteService;

@SpringBootTest
class NationalScholarshipAppApplicationTests {

	@Autowired
	IInstituteService iInstituteService;
	
	/*
	@Test
	void testInstitution() {
		Institution institution = new Institution("BIT@543", "BIT@543", "Institution", 543, "Private", "Engineering", "BIT", "VTU", "VVPuram", "Bangalore", "Karnataka", 1965, "8990443276", "Raghav Prasad", "Pending");
		assertEquals(institution, service.addInstitute(institution));
	}
	*/
	
	
	@Test
	void testInstitutionIntegrity()
	{
		Institution institution = new Institution("BIT@543", "BIT@783", "Institution", 234, "Private", "Engineering", "BIT", "VTU", "VVPuram", "Bangalore", "Karnataka", 1965, "8990443276", "Raghav Prasad", "Pending");
		assertThrows(UniqueElementException.class, () -> iInstituteService.addInstitute(institution));
	}
	
	
	
	@Test
	void testInstituteIdAttribute()
	{
		Institution institution = new Institution("BIT@890", "BIT@783", "Institution", 543, "Private", "Engineering", "BIT", "VTU", "VVPuram", "Bangalore", "Karnataka", 1965, "8990443276", "Raghav Prasad", "Pending");
		assertThrows(UniqueElementException.class, () -> iInstituteService.addInstitute(institution));
	}
	
	
	/* Doesn't work
	@Test
	void testValidation()
	{
		Institution institution = new Institution("BIT@009", "BIT@jg", "Institution", 888, "", "Engineering", "BIT", "VTU", "", "Bangalore", "Karnataka", 1965, "8990443276", "Raghav Prasad", "Pending");
		assertThrows(ValidationException.class, () -> service.addInstitute(institution));
	}
	*/
	
	
	@Test
	void testEditInstitute()
	{
		Institution institution = new Institution("BMSIT@123", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertEquals(institution, iInstituteService.editInstitute("BMSIT@123", institution));
	}
	
	@Test
	void testEditInstituteIntegrity()
	{
		Institution institution = new Institution("BMSIT", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertThrows(UserIdNotFoundException.class, () -> iInstituteService.editInstitute("BMSIT", institution));
	}
	
	@Test
	void testGetInstituteByCode()
	{
		Institution institution = new Institution("BMSIT@123", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertEquals(institution.getCategory(), iInstituteService.getInstitute(101).getCategory());
	}
	
	@Test
	void testGetInstituteByCode2()
	{
		Institution institution = new Institution("BMSIT@123", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertEquals(institution, iInstituteService.getInstitute(101));
	}
	
	@Test
	void testGetInstituteByCode3()
	{
		Institution institution = new Institution("BMSIT@123", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertEquals(institution.findStatus(), iInstituteService.getInstitute(101).findStatus());
	}
	
	@Test
	void testGetInstituteByCode4()
	{
		assertThrows(InvalidInstitutionException.class, () -> iInstituteService.getInstitute(666));
	}
	
	@Test
	void testGetInstituteByState1()
	{
		Institution institution1 = new Institution("Viu@123", "Viu788", "Institution", 766, "Private", "Law", "VIU Law College", "APU", "Nawabnagar", "Hyderabad", "Andhra Pradesh", 1988, "9987660090", "Sharan V Reddy","");
		institution1.updateStatus("Approved");
		List<Institution> institutions = new ArrayList<>();
		institutions.add(institution1);
		assertEquals(institutions, iInstituteService.getInstitutesByState("Andhra Pradesh"));
	}
	
	@Test
	void testGetInstituteByState2()
	{
		assertThrows(StateNotFoundException.class, () -> iInstituteService.getInstitutesByState("Rajasthan"));
	}
	
	@Test
	void testUpdateDetails1()
	{
		Institution institution = new Institution("Viu@123", "Viu788", "Institution", 766, "Private", "Law", "VIU Law College", "APU", "Nawabnagar", "Hyderabad", "Andhra Pradesh", 1988, "9987660090", "Sharan V Reddy","");
		institution.updateStatus("Approved");
		assertEquals(institution.findStatus(), iInstituteService.statusUpdate(766, "Approved").findStatus());
	}
	
	@Test
	void testUpdateDetails2()
	{
		assertThrows(InvalidInstitutionException.class, () -> iInstituteService.statusUpdate(880, "Approved"));
	}
	
	@Test
	void testUpdateDetails3()
	{
		Institution institution = new Institution("Viu@123", "Viu788", "Institution", 766, "Private", "Law", "VIU Law College", "APU", "Nawabnagar", "Hyderabad", "Andhra Pradesh", 1988, "9987660090", "Sharan V Reddy","");
		institution.updateStatus("Approved");
		assertEquals(institution, iInstituteService.statusUpdate(766, "Approved"));
	}
}
