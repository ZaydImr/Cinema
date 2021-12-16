var myApp = angular.module('myApp',[]);

myApp.controller("nationalityController", function($scope,$http,$location){

	$scope.allNationalities = [];
	$scope.add = false;
	console.log($location);

    $http.get('/api/nationality/all')
        .then(function successCallback(response){
            $scope.allNationalities = response.data;
			$scope.natsCount = response.data.length-1;
        }, function errorCallback(response) {
			console.log('Error....');
			console.log(response);
		});
});