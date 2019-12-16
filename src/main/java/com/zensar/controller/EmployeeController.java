package com.zensar.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.Entity.EmployeeInformation;
import com.zensar.repository.EmployeeRepository;
import com.zensar.repository.LeaveInformationRepository;
import com.zensar.service.EmployeeService;

//@Controller
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private LeaveInformationRepository leaveInformationRepository;
	@Autowired
	private EmployeeService empservice;

	@Value("#{'${sbpg.init.leadNames}'.split(',')}")
	private List<String> leadsname;

	@GetMapping("/getleadNames")
	public List<String> getleadnames() {
		return leadsname;
	}

	@RequestMapping(value = "/getEmployeelist/{lead}", method = RequestMethod.GET)
	public List<EmployeeInformation> GetEmployeeDetailsByLeadName(@PathVariable("lead") String lead) {
		System.out.println("lead name" + lead);

		List<EmployeeInformation> employeeInformations = employeeRepository.findbyLeadName(lead);

		return employeeInformations;
	}

	@PostMapping("/updateEmployee")
	public void addemployee(@RequestBody List<EmployeeInformation> employeeInformations) {

		logger.info("data" + employeeInformations);
		logger.error("error" + employeeInformations);
		System.out.println(employeeInformations);
		employeeRepository.saveAll(employeeInformations);

	}

	@PostMapping("/addEmployee")
	public void addEmployee(@RequestBody EmployeeInformation employeeInformations) {

		logger.info("data" + employeeInformations);
		logger.error("error" + employeeInformations);
		System.out.println(employeeInformations);
		employeeRepository.save(employeeInformations);

	}

	@GetMapping("/getEmployeelist")
	public List<EmployeeInformation> getEmployee() {
		return employeeRepository.findAll();
	}

}
