package com.zensar.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class EmployeeInformation {
	private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;
	@Id
	private int empId;
	private String empName;
	private String role;
	private String technology;
	private int level;
	private String location;
	private String leadName;

	@JoinColumn(name = "leave_leaveID")
	@OneToOne( cascade = CascadeType.ALL)
	private LeavesInformation leavesInformations;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLeadName() {
		return leadName;
	}

	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}

	public LeavesInformation getLeavesInformations() {
		return leavesInformations;
	}

	public void setLeavesInformations(LeavesInformation leavesInformations) {
		this.leavesInformations = leavesInformations;
	}

	@Override
	public String toString() {
		return "EmployeeInformation [empId=" + empId + ", empName=" + empName + ", role=" + role + ", technology="
				+ technology + ", level=" + level + ", location=" + location + ", leadName=" + leadName
				+ ", leavesInformations=" + leavesInformations + "]";
	}

	public EmployeeInformation(int empId, String empName, String role, String technology, int level, String location,
			String leadName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.role = role;
		this.technology = technology;
		this.level = level;
		this.location = location;
		this.leadName = leadName;
	}

	public EmployeeInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

}
