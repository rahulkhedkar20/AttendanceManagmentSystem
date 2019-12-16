package com.zensar.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.Entity.EmployeeInformation;
import com.zensar.repository.EmployeeRepository;
import com.zensar.service.ExcelGeneration;

@RestController
public class ExcelController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(value = "/download/attendance.xlsx")
	public ResponseEntity<InputStreamResource> excelReport() throws IOException {
		List<EmployeeInformation> employeeInformations = (List<EmployeeInformation>) employeeRepository.findAll();

		ByteArrayInputStream in = ExcelGeneration.generateExcel(employeeInformations);
		// return IOUtils.toByteArray(in);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=attendance.xlsx");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}

}
