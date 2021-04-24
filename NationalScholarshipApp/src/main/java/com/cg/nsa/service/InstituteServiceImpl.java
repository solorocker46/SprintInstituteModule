package com.cg.nsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.nsa.entity.Institution;
import com.cg.nsa.exception.InvalidInstitutionException;
import com.cg.nsa.exception.UniqueElementException;
import com.cg.nsa.exception.UserIdNotFoundException;
import com.cg.nsa.repository.IInstituteRepository;

/**
 * @author Sushma S
 * Version: 1.0
 * Description: This is service method implementation of IInstituteService interface
 * Created date: 20-04-2021
 */
@Service
public class InstituteServiceImpl implements IInstituteService {

	@Autowired
	IInstituteRepository iRepository;
	
	/***********************************************************
	 * 
	 * @return this method returns an Institution object
	 * @param this method takes in Institution object parameter
	 * @throws this method throws a UniqueElementException
	 * 
	 **********************************************************/
	@Override
	public Institution addInstitute(Institution institute) {
		// TODO Auto-generated method stub
		if(iRepository.findByCode(institute.getCode()) == null)
		{
			institute.setStatus("Pending");
			return iRepository.save(institute);
			
		}
		else
		{
			throw new UniqueElementException();
		}
	}

	/**
	 * @return this method returns an Institution object
	 * @param this method takes in userId of type String as a parameter
	 * @param this method takes in Institution object parameter
	 * @throws this method throws a UserIdNotFoundException
	 */
	@Override
	public Institution editInstitute(String userId, Institution institute) {
		// TODO Auto-generated method stub
		Institution institution = iRepository.findByUserId(userId);
		if(institution == null)
		{
			throw new UserIdNotFoundException();
		}
		else
		{
			institution.setUniversity(institute.getUniversity());
			institution.setTelephone(institute.getTelephone());
			institution.setPrincipal(institute.getPrincipal());
			return iRepository.save(institution);
		}
	}

	/**
	 * @return this method returns an Institution object
	 * @param this method takes in institution code of type int as a parameter
	 * @param this method takes in status of type String as a parameter
	 * @throws this method throws an InvalidInstitutionException
	 */
	@Override
	public Institution statusUpdate(int code, String status) {
		// TODO Auto-generated method stub
		Institution institution = iRepository.findByCode(code);
		if(institution == null)
		{
			throw new InvalidInstitutionException();
		}
		else
		{
			institution.setStatus(status);
			return iRepository.save(institution);
		}
		
	}

	/**
	 * @return this method returns an Institution object
	 * @param this method takes in institution code of type int as a parameter
	 * @throws this method throws an InvalidInstitutionException
	 */
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

	/**
	 * @return this method returns a list of Institution objects
	 */
	@Override
	public List<Institution> getAllInstitutes() {
		// TODO Auto-generated method stub
		return iRepository.findAll();
	}

	/**
	 * @return this method returns a list of Institution objects
	 * @param this method takes in state of type String as a parameter
	 */
	@Override
	public List<Institution> getInstitutesByState(String state) {
		// TODO Auto-generated method stub
		return iRepository.findByState(state);
	}

}
