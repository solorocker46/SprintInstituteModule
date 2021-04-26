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

/**************************************************************
 * 
 * @author Sushma S
 * Version: 1.0
 * Description: This is the test class for institution module
 * Created date: 23-04-2021
 * 
 ***************************************************************/

@SpringBootTest
class NationalScholarshipAppApplicationTests {

	@Autowired
	IInstituteService iInstituteService;
	
	/*****************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 23-04-2021
	 * This is the test case to check addition of new institution details into the database
	 * 
	 ******************************************************************************************/
	
	@Test
	void testInstitution() {
		Institution institution = new Institution("SIMS667", "SIMS667", "Institution", 289, "Private", "Medical", "SIMS", "RGUHS", "Old Street", "Tumkur", "Karnataka", 2009, "9090665432", "Aishwarya UK", "Pending");
		institution.updateStatus("Pending");
		assertEquals(institution, iInstituteService.addInstitute(institution));
	}
	
	/******************************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 23-04-2021
	 * This is the test case to check addition of new institution details into the database which throws UniqueElementException
	 * 
	 ********************************************************************************************************************************/
	
	@Test
	void testInstitutionIntegrity()
	{
		Institution institution = new Institution("BIT@543", "BIT@783", "Institution", 234, "Private", "Engineering", "BIT", "VTU", "VVPuram", "Bangalore", "Karnataka", 1965, "8990443276", "Raghav Prasad", "Pending");
		assertThrows(UniqueElementException.class, () -> iInstituteService.addInstitute(institution));
	}
	
	/********************************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 23-04-2021
	 * This is the test case to check addition of new institution details into the database which throws UniqueElementException
	 * 
	 ********************************************************************************************************************************/
	
	@Test
	void testInstituteIdAttribute()
	{
		Institution institution = new Institution("BIT@890", "BIT@783", "Institution", 543, "Private", "Engineering", "BIT", "VTU", "VVPuram", "Bangalore", "Karnataka", 1965, "8990443276", "Raghav Prasad", "Pending");
		assertThrows(UniqueElementException.class, () -> iInstituteService.addInstitute(institution));
	}
	
	/***************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check updation of an existing institution's details in the database
	 * 
	 ****************************************************************************************************/
	
	@Test
	void testEditInstitute()
	{
		Institution institution = new Institution("BMSIT@123", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertEquals(institution, iInstituteService.editInstitute("BMSIT@123", institution));
	}
	
	/****************************************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check updation of an existing institution's details in the database which throws UserIdNotFoundException
	 * 
	 ****************************************************************************************************************************************/
	
	@Test
	void testEditInstituteIntegrity()
	{
		Institution institution = new Institution("BMSIT", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertThrows(UserIdNotFoundException.class, () -> iInstituteService.editInstitute("BMSIT", institution));
	}
	
	/***************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check retrieval of an existing institution's details from the database
	 * 
	 ****************************************************************************************************/
	
	@Test
	void testGetInstituteByCode()
	{
		Institution institution = new Institution("BMSIT@123", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertEquals(institution.getCategory(), iInstituteService.getInstitute(101).getCategory());
	}
	
	/***************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check retrieval of an existing institution's details from the database
	 * 
	 ****************************************************************************************************/
	
	@Test
	void testGetInstituteByCode2()
	{
		Institution institution = new Institution("BMSIT@123", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertEquals(institution, iInstituteService.getInstitute(101));
	}
	
	/***************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check retrieval of an existing institution's details from the database
	 * 
	 ****************************************************************************************************/
	
	@Test
	void testGetInstituteByCode3()
	{
		Institution institution = new Institution("BMSIT@123", "BMSIT@123", "Institution", 101, "Private", "Engineering", "BMSIT", "VTU", "Avalahalli", "Bangalore", "Karnataka", 2003, "9999077654", "Vishwakiran","Approved");
		institution.updateStatus("Approved");
		assertEquals(institution.findStatus(), iInstituteService.getInstitute(101).findStatus());
	}
	
	/*********************************************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check retrieval of an existing institution's details from the database which throws InvalidInstitutionException
	 * 
	 *********************************************************************************************************************************************/
	
	@Test
	void testGetInstituteByCode4()
	{
		assertThrows(InvalidInstitutionException.class, () -> iInstituteService.getInstitute(666));
	}
	
	/***************************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check retrieval of a list of existing institutions details from the database based on state
	 * 
	 ****************************************************************************************************************************/
	
	@Test
	void testGetInstituteByState1()
	{
		Institution institution1 = new Institution("Viu@123", "Viu788", "Institution", 766, "Private", "Law", "VIU Law College", "APU", "Nawabnagar", "Hyderabad", "Andhra Pradesh", 1988, "9987660090", "Sharan V Reddy","");
		institution1.updateStatus("Approved");
		List<Institution> institutions = new ArrayList<>();
		institutions.add(institution1);
		assertEquals(institutions, iInstituteService.getInstitutesByState("Andhra Pradesh"));
	}
	
	/*************************************************************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check retrieval of a list of existing institutions details from the database based on state which throws StateNotFoundException
	 * 
	 **************************************************************************************************************************************************************/
	
	@Test
	void testGetInstituteByState2()
	{
		assertThrows(StateNotFoundException.class, () -> iInstituteService.getInstitutesByState("Rajasthan"));
	}
	
	/***************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check updation of an institution's status in the database 
	 * 
	 ***************************************************************************************/
	
	@Test
	void testUpdateStatus1()
	{
		Institution institution = new Institution("Viu@123", "Viu788", "Institution", 766, "Private", "Law", "VIU Law College", "APU", "Nawabnagar", "Hyderabad", "Andhra Pradesh", 1988, "9987660090", "Sharan V Reddy","");
		institution.updateStatus("Approved");
		assertEquals(institution.findStatus(), iInstituteService.statusUpdate(766, "Approved").findStatus());
	}
	
	/*********************************************************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check updation of an institution's status in the database which throws InvalidInstitutionException 
	 * 
	 **********************************************************************************************************************************/
	
	@Test
	void testUpdateStatus2()
	{
		assertThrows(InvalidInstitutionException.class, () -> iInstituteService.statusUpdate(880, "Approved"));
	}
	
	/***************************************************************************************
	 * 
	 * @author Sushma S
	 * Created date: 25-04-2021
	 * This is the test case to check updation of an institution's status in the database 
	 * 
	 ***************************************************************************************/
	
	@Test
	void testUpdateStatus3()
	{
		Institution institution = new Institution("Viu@123", "Viu788", "Institution", 766, "Private", "Law", "VIU Law College", "APU", "Nawabnagar", "Hyderabad", "Andhra Pradesh", 1988, "9987660090", "Sharan V Reddy","");
		institution.updateStatus("Approved");
		assertEquals(institution, iInstituteService.statusUpdate(766, "Approved"));
	}
}
