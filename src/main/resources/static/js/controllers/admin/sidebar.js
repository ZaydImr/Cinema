var myApp = angular.module('myApp',[]);

myApp.controller("sidebarController", function($scope,$location){
    $scope.route = $location.absUrl().split('/')[4];
    $scope.homeRoute = $location.absUrl().split('/')[3];
    $scope.account = false;
    $scope.sidebar = false;

    $scope.setSidebar = function(){
        $scope.sidebar = !$scope.sidebar;
    }
});