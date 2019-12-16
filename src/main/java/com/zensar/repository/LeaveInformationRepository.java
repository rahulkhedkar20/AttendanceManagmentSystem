package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zensar.Entity.LeavesInformation;

@Repository
public interface LeaveInformationRepository extends JpaRepository<LeavesInformation, Integer> {

	@Query("select l  from LeavesInformation l ,EmployeeInformation e where l.leaveId=?1 and e.empId=?2")
	public LeavesInformation getleaveinformation(int leavId, int empId);

}
