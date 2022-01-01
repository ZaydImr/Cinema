myApp.controller("newsController", function ($scope, $http) {

  // Variables
  $scope.all = [];

  $scope.loading = false;
  $scope.email = '';

  // Functions


  $scope.addComment = function () {
    $scope.loading = true;
    $http.post("/api/subscription/add", { emailSubscriber: $scope.email }).then(
      function successCallback() {
        alert("You have been subscribed");
        $scope.loading = false;
      },
      function errorCallback(response) {
        console.log("Error....");
        console.log(response);
      }
    );
  };
  
});
