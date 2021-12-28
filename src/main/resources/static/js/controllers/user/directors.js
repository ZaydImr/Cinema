myApp.controller("directorsController", function ($scope, $http) {

  // Variables
  $scope.all = [];

  $scope.loading = false;

  $scope.searchIn = "";

  // Functions
  $scope.getDirectors = function ($page) {
    $scope.loading = true;
    $http.get("/api/director/all").then(
      function successCallback(response) {
        $scope.loading = false;
        $scope.all = response.data;

      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };

  $scope.search = function () {
    if ($scope.searchIn === "") {
         $scope.getDirectors();
    } else {
      $scope.loading = true;
      $http.get("/api/director/all/keyword/" + $scope.searchIn).then(
        function successCallback(response) {
          console.log(response);
          $scope.loading = false;
          $scope.all = response.data;

          $scope.directorsCount = response.data.length - 1;
        },
        function errorCallback(response) {
          console.log("Error....");
          console.log(response);
        }
      );
    }
  };

  // Initialization
  $scope.getDirectors();
});
