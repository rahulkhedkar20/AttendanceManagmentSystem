package com.zensar.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LeavesInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaveId;
	private String workFromHomes;
	private String leaves;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "leavesInformations")
	private EmployeeInformation employeeInformation;

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getWorkFromHomes() {
		return workFromHomes;
	}

	public void setWorkFromHomes(String workFromHomes) {
		this.workFromHomes = workFromHomes;
	}

	public String getLeaves() {
		return leaves;
	}

	public void setLeaves(String leaves) {
		this.leaves = leaves;
	}

	public EmployeeInformation getEmployeeInformation() {
		return employeeInformation;
	}

	public void setEmployeeInformation(EmployeeInformation employeeInformation) {
		this.employeeInformation = employeeInformation;
	}

	public LeavesInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
