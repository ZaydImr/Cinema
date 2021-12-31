myApp.controller("filmController", function ($scope, $http) {

  // Variables
  $scope.all = [];

  $scope.loading = false;

  $scope.film = {};
  $scope.galerie = [];

  // Functions
  $scope.getFilm = function () {
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

  $scope.getGalerie = function () {
    $scope.loading = true;
    $http.get("/api/filmimages/find/"+location.pathname.split('/')[location.pathname.split('/').length-1]).then(
      function successCallback(response) {
        $scope.loading = false;
        $scope.galerie = response.data;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  // Initialization
  $scope.getFilm();
  $scope.getGalerie();

});
