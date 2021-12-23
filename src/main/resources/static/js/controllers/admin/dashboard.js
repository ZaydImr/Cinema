myApp.controller("dashboardController", function ($scope, $http) {
  $scope.todayVisitors = 0;
  $scope.totalClients = 0;
  $scope.totalFilms = 0;
  $scope.subscribers = 0;
  $scope.monthVisitors = [];

  $scope.getFilmsCount = function () {
    $http.get("/api/film/count").then(
      function successCallback(response) {
        $scope.totalFilms = response.data;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.getSubscribersCount = function () {
    $http.get("/api/subscription/count").then(
      function successCallback(response) {
        $scope.subscribers = response.data;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.getUsersCount = function () {
    $http.get("/api/user/count").then(
      function successCallback(response) {
        $scope.totalClients = response.data;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.getVisitorsPerDay = function () {
    $http.get("/api/visitors/today").then(
      function successCallback(response) {
        $scope.todayVisitors = response.data;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.getVisitors = function () {
    $http.get("/api/visitors/month").then(
      function successCallback(response) {
        $scope.monthVisitors = response.data;
        console.log($scope.monthVisitors);
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.getFilmsCount()
  $scope.getSubscribersCount()
  $scope.getUsersCount()
  $scope.getVisitorsPerDay()
  $scope.getVisitors()

});
