package com.zensar.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zensar.Entity.DatesEntity;
import com.zensar.Entity.EmployeeInformation;

public class ExcelGeneration {

	public static ByteArrayInputStream generateExcel(List<EmployeeInformation> employeeInformations)
			throws IOException {

		List<LocalDate> datesofMonth = DatesEntity.getDatesBetweenUsingJava8();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Workbook workbook = new XSSFWorkbook();

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		Sheet sheet = workbook.createSheet("Attendance Sheet ");

		// create header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Role");
		header.createCell(1).setCellValue("Technology");
		header.createCell(2).setCellValue("Level");
		header.createCell(3).setCellValue("Location");
		header.createCell(4).setCellValue("Name");
		header.createCell(5).setCellValue("Person Responsible for updating data");
		header.createCell(6).setCellValue("Emp. Code");
		header.createCell(7).setCellValue("WFH");
		header.createCell(8).setCellValue("Leaves");
		System.out.println(datesofMonth.size());
		int j = 9;
		for (int i = 0; i < datesofMonth.size(); i++) {

			// System.out.println(date);
			Cell cell = header.createCell(j);
			cell.setCellValue(datesofMonth.get(i).toString());

			// header.createCell(j).setCellValue(datesofMonth.get(i).toString());
			j++;
		}
		header.createCell(j).setCellValue("Total Hours");
		header.createCell(j + 1).setCellValue("Days");
		// header.createCell(9).setCellValue("Date");

		// Create data cells
		int rowCount = 1;
		for (EmployeeInformation employeeInformation : employeeInformations) {
			Row courseRow = sheet.createRow(rowCount++);
			courseRow.createCell(0).setCellValue(employeeInformation.getRole());
			courseRow.createCell(1).setCellValue(employeeInformation.getTechnology());
			courseRow.createCell(2).setCellValue(employeeInformation.getLevel());
			courseRow.createCell(3).setCellValue(employeeInformation.getLocation());
			courseRow.createCell(4).setCellValue(employeeInformation.getEmpName());
			courseRow.createCell(5).setCellValue(employeeInformation.getLeadName());
			courseRow.createCell(6).setCellValue(employeeInformation.getEmpId());

			if (employeeInformation.getLeavesInformations().getWorkFromHomes() != null
					&& employeeInformation.getLeavesInformations().getWorkFromHomes().isEmpty() == false) {

				String[] w = employeeInformation.getLeavesInformations().getWorkFromHomes().split(",");

				courseRow.createCell(7).setCellValue(w.length);
			} else {
				courseRow.createCell(7).setCellValue(0);
			}

			List<String> list = new ArrayList<>();
			if (employeeInformation.getLeavesInformations().getLeaves() != null
					&& employeeInformation.getLeavesInformations().getLeaves().isEmpty() == false) {
				String[] l = employeeInformation.getLeavesInformations().getLeaves().split(",");
				courseRow.createCell(8).setCellValue(l.length);
				list = Arrays.asList(l);
			} else {
				courseRow.createCell(8).setCellValue(0);
			}

			// courseRow.createCell(2).setCellValue(DATE_FORMAT.format(course.getDate()));

			int c = 9;
			for (int i = 0; i < datesofMonth.size(); i++) {
				// System.out.println(datesofMonth.get(i));
				if (datesofMonth.get(i).getDayOfWeek() == DayOfWeek.SUNDAY
						|| datesofMonth.get(i).getDayOfWeek() == DayOfWeek.SATURDAY) {
					Cell cell = courseRow.createCell(c++);
					cell.setCellValue(0);
				} else if (list.contains(datesofMonth.get(i).toString())) {
					System.out.println(datesofMonth.get(i));
					Cell cell = courseRow.createCell(c++);
					cell.setCellValue(0);

				} else {
					Cell cell = courseRow.createCell(c++);
					cell.setCellValue(8);

				}

				// header.createCell(j).setCellValue(datesofMonth.get(i).toString());
				// c++;
			}

			int totaldays = (datesofMonth.size() - 8) - list.size();
			int totalhours = totaldays * 8;
			courseRow.createCell(c).setCellValue(totalhours);
			courseRow.createCell(c + 1).setCellValue(totaldays);
		}

		workbook.write(out);

		return new ByteArrayInputStream(out.toByteArray());
	}

}
