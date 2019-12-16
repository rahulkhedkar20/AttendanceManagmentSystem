'use strict'
var module = angular.module('attendanceManagment.controllers', []);
module.controller("UserController", [
		"$scope",
		"UserService",
		function($scope, UserService) {

			UserService.getleadNames().then(function(value) {

				$scope.leadnames = value.data;
				console.log(value.data);
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});

			$scope.Onchange = function() {
				console.log($scope.leadNames);

				UserService.getAllEmployeeByLeadNames($scope.leadNames).then(
						function(value) {

							$scope.employeeList = value.data;
							console.log(value.data);
						}, function(reason) {
							console.log("error occured");
						}, function(value) {
							console.log("no callback");
						});
			}

			$scope.saveAllValues = function() {
				console.log($scope.employeeList);

				UserService.updateEmployee($scope.employeeList).then(
						function() {
						}, function(reason) {
							console.log("error occured");
						}, function(value) {
							console.log("no callback");
						});
				window.location.reload();
			}

		}

]);
