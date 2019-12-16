'use strict'
var attendancemanagmentApp = angular.module('attendanceManagment', [
		'ui.bootstrap', 'attendanceManagment.controllers',
		'attendanceManagment.services' ]);
attendancemanagmentApp.constant("CONSTANTS", {

	getAllEmployeeByLeadNames : "/employee/getEmployeelist/",

	UpdateEmployee : "/employee/updateEmployee",
	getleadNames : "/employee/getleadNames"
});