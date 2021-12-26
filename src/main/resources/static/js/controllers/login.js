var myApp = angular.module('myApp',[]);

myApp.controller("loginController", function($scope,$http){

    $scope.email = "";

	$scope.login = function(){
        localStorage.setItem('email',$scope.email);
    }

});