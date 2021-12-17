var myApp = angular.module('myApp',[]);

myApp.controller("nationalityController", function($scope,$http){

	$scope.all = { list:[], next:true, prev:false};
	$scope.add = false;
	$scope.page= 1;
    $scope.unPage = 1;
	$scope.loading = false;
    $scope.getNat = function ($page){
        $scope.loading = true;
        $http.get('/api/nationality/all/'+$scope.unPage)
            .then(function successCallback(response){
                    $scope.loading = false;
                    $scope.all = response.data;
        			$scope.natsCount = response.data.length-1;
                    if($page) $scope.page = $page;
            }, function errorCallback(response) {
        			console.log('Error....');
        			console.log(response);
            });
    }
    $scope.next = function(){ $scope.unPage = $scope.unPage + 1; $scope.getNat($scope.unPage);}
    $scope.prev = function(){ $scope.unPage = $scope.unPage - 1; $scope.getNat($scope.unPage);}
    $scope.deleteNat = function($idNat){
        $http.delete('/api/nationality/delete/'+$idNat)
            .then(function successCallback(){
                $scope.getNat();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }

    $scope.getNat();

});