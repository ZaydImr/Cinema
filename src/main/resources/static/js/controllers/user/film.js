myApp.controller("filmController", function ($scope, $http) {

  // Variables
  $scope.all = [];

  $scope.loading = false;

  $scope.film = {};
  $scope.galerie = [];
  $scope.comments = [];
  $scope.comment = '';

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

  $scope.getComments = function () {
    $scope.loading = true;
    $http.get("/api/comment/find/"+location.pathname.split('/')[location.pathname.split('/').length-1]).then(
      function successCallback(response) {
        $scope.loading = false;
        $scope.comments = response.data;
        console.log(response.data);
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.addComment = function () {
    $scope.loading = true;
    $http.post("/api/comment/add", { contentComment: $scope.comment, film: $scope.film }).then(
      function successCallback() {
        $scope.getComments();
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
  $scope.getComments();

});
