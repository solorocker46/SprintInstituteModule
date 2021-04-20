package com.cg.nsa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.exception.InvalidInstitutionException;

@Service
public interface IInstituteService {

	Institution addInstitute(Institution institute);
	
	Institution editInstitute(int userId, Institution institute);
	
	Institution statusUpdate(int code, Institution institute);
	
	Institution getInstitute(int code); //throws InvalidInstitutionException;
	
	List<Institution> getAllInstitutes();
	
	List<Institution> getInstitutesByState(String state);
}
