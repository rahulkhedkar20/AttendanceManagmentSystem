package com.zensar.Entity;


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DatesEntity {

	public static List<LocalDate> getDatesBetweenUsingJava8() {

		LocalDate date = LocalDate.now();
		LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());
		LocalDate lastday = date.with(TemporalAdjusters.lastDayOfMonth());

		System.out.println();

		long numOfDaysBetween = ChronoUnit.DAYS.between(firstDay, lastday);

		return IntStream.iterate(0, i -> i + 1).limit(numOfDaysBetween).mapToObj(i -> firstDay.plusDays(i))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();

		// first day of current month
		LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());

		System.out.println("firstDayOfMonth : " + firstDay);

		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		String formattedCurrentDate = firstDay.format(format1);

		// last day of current month
		LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
		// convert String to LocalDate
		LocalDate localDate1 = LocalDate.parse(formattedCurrentDate, format1);
		System.out.println(localDate1);
		System.out.println("lastDayOfMonth : " + lastDay);
		LocalDate d1 = LocalDate.parse("2012-06-01");
		LocalDate d2 = LocalDate.parse("2012-06-08");
		System.out.println(d1 + ":" + d2);

		ZoneId defaultZoneId = ZoneId.systemDefault();
		java.time.DayOfWeek dayOfWeek = firstDay.getDayOfWeek();
		System.out.println(firstDay + " was a " + dayOfWeek);

		System.out.println("AllDates" + getDatesBetweenUsingJava8());
		System.out.println(getDatesBetweenUsingJava8().size());

		System.out.println("java .utl date+:" + firstDay.toString());

		/*
		 * for(int i=0;i<datesofMonth.size();i++) { Date date =
		 * Date.from(datesofMonth.get(i).atStartOfDay(defaultZoneId).toInstant()); int
		 * j=7; // header.createCell(j).setCellValue(datesofMonth.get(i)); //
		 * System.out.println(date); header.createCell(j).setCellValue(date); j++; }
		 * 
		 * 
		 * for(int i=0;i<datesofMonth.size();i++) { int j=7; Date date =
		 * Date.from(datesofMonth.get(i).atStartOfDay(defaultZoneId).toInstant());
		 * DayOfWeek day=datesofMonth.get(i).getDayOfWeek(); System.out.println(day);
		 * 
		 * 
		 * // header.createCell(j).setCellValue(datesofMonth.get(i));
		 * //System.out.println(date); courseRow.createCell(j).setCellValue(date); j++;
		 * }
		 */
	}

}
