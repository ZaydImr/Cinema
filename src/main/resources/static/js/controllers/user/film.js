myApp.controller("filmController", function ($scope, $http) {

  // Variables
  $scope.all = [];

  $scope.loading = false;

  $scope.film = {};

  // Functions
  $scope.getFilm = function ($page) {
    $scope.loading = true;
    $http.get("/api/film/find/"+location.pathname.split('/')[location.pathname.split('/').length-1]).then(
      function successCallback(response) {
        $scope.loading = false;
        $scope.film = response.data;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  // Initialization
  $scope.getFilm();

});
