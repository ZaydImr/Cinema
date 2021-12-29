myApp.controller("actorController", function ($scope, $http) {

  // Variables
  $scope.all = [];
  $scope.loading = false;

  $scope.searchIn = "";

  // Functions
  $scope.getActors = function () {
    $scope.loading = true;
    $http.get("/api/actor/all").then(
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
      $scope.getActors();
    } else {
      $scope.loading = true;
      $http.get("/api/actor/all/keyword/" + $scope.searchIn).then(
        function successCallback(response) {
          console.log(response);
          $scope.loading = false;
          $scope.all = response.data ;

        },
        function errorCallback(response) {
          console.log("Error....");
          console.log(response);
        }
      );
    }
  };

  // Initialization

  $scope.getActors();
});
