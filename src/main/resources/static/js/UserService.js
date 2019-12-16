'use strict'
angular.module('attendanceManagment.services', []).factory('UserService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};

			service.getAllEmployeeByLeadNames = function(leadname) {

				var url = CONSTANTS.getAllEmployeeByLeadNames + leadname;
				return $http.get(url);
			}
			service.getleadNames = function() {
				var url = CONSTANTS.getleadNames;
				return $http.get(url);
			}
			service.updateEmployee = function(employeelist) {
				return $http.post(CONSTANTS.UpdateEmployee, employeelist);
			}
			return service;
		} ]);