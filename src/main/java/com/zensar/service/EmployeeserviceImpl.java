package com.zensar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.Entity.EmployeeInformation;
import com.zensar.Entity.LeavesInformation;
import com.zensar.repository.EmployeeRepository;

@Service
public class EmployeeserviceImpl  implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeInformation SaveEmployee(EmployeeInformation employeeInformation) {
		// TODO Auto-generated method stub
		
		EmployeeInformation emp= employeeInformation;
		
		LeavesInformation l1=employeeInformation.getLeavesInformations();
		emp.setLeavesInformations(l1);
		
	return	employeeRepository.save(emp);
	}

}
