myApp.controller("filmController", function ($scope, $http) {

  // Variables
  $scope.all = [];

  $scope.loading = false;

  $scope.idFilm = "";

  $scope.searchIn = "";

  // Functions
  $scope.getFilms = function () {
    $scope.loading = true;
    $http.get("/api/film/all").then(
      function successCallback(response) {
        $scope.loading = false;
        $scope.all = response.data;
        $scope.filmsCount = response.data.length - 1;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.search = function () {
    if ($scope.searchIn === "") {
      $scope.getFilms();
    } else {
      $scope.loading = true;
      $http.get("/api/film/all/keyword/" + $scope.searchIn).then(
        function successCallback(response) {
          console.log(response);
          $scope.loading = false;
          $scope.all = response.data;

          $scope.filmsCount = response.data.length - 1;
        },
        function errorCallback(response) {
          console.log("Error....");
          console.log(response);
        }
      );
    }
  };

  // Initialization
  $http.post('/api/visitors/add', {data : window.clientInformation.appVersion})
  $scope.getFilms();
});
