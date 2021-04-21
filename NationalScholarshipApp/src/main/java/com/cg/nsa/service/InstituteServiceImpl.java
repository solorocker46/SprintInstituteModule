package com.cg.nsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.repository.IInstituteRepository;

@Service
public class InstituteServiceImpl implements IInstituteService {

	@Autowired
	IInstituteRepository iRepository;
	
	@Override
	public Institution addInstitute(Institution institute) {
		// TODO Auto-generated method stub
		return iRepository.save(institute);
	}

	@Override
	public Institution editInstitute(String userId, Institution institute) {
		// TODO Auto-generated method stub
		Institution institution = iRepository.findByUserId(userId);
		institution.setUniversity(institute.getUniversity());
		institution.setTelephone(institute.getTelephone());
		institution.setPrincipal(institute.getPrincipal());
		return iRepository.save(institution);
	}

	@Override
	public Institution statusUpdate(int code, Institution institute) {
		// TODO Auto-generated method stub
		Institution institution = iRepository.findByCode(code);
		institution.setStatus(institute.getStatus());
		return iRepository.save(institution);
	}

	@Override
	public Institution getInstitute(int code) /*throws InvalidInstitutionException */{
		// TODO Auto-generated method stub
		Institution institute = iRepository.findByCode(code);
		if(institute == null)
		{
			throw new InvalidInstitutionException();
		}
		else
		{
			return institute;
		}
		
	}

	@Override
	public List<Institution> getAllInstitutes() {
		// TODO Auto-generated method stub
		return iRepository.findAll();
	}

	@Override
	public List<Institution> getInstitutesByState(String state) {
		// TODO Auto-generated method stub
		return iRepository.findByState(state);
	}

}
