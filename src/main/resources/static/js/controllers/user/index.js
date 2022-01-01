myApp.controller("filmController", function ($scope, $http) {

  // Variables
  $scope.all = [];
  $scope.nationalities = [];
  $scope.actors = [];
  $scope.directors = [];
  $scope.categories = [];

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
  $scope.getNationalities = function () {
    $http.get("/api/nationality/all").then(
      function successCallback(response) {
        $scope.nationalities = response.data;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };
  $scope.getTypeFilm = function () {
    $http.get("/api/filmtypes/all").then(
      function successCallback(response) {
        $scope.categories = response.data;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };
  $scope.getDirectors = function () {
    $http.get("/api/director/all").then(
      function successCallback(response) {
        $scope.directors = response.data;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };
  $scope.getActors = function () {
    $http.get("/api/actor/all").then(
      function successCallback(response) {
        $scope.actors = response.data;
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
  $scope.search();
  $scope.getNationalities();
  $scope.getTypeFilm();
  $scope.getDirectors();
  $scope.getActors();
});
