package com.zensar.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zensar.Entity.EmployeeInformation;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInformation, Integer>{

	@Query("select e  from EmployeeInformation e where e.leadName=?1 ")
	public List<EmployeeInformation>findbyLeadName(String leadname );
}
