myApp.controller("sidebarController", function($scope,$location){
    $scope.route = $location.absUrl().split('/')[4];
});