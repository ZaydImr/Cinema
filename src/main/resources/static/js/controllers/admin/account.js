Date.prototype.addDays = function (days) {
  var date = new Date(this.valueOf());
  date.setDate(date.getDate() + days);
  return date;
}

myApp.controller("accountController", function ($scope, $http) {

  $scope.err = {
    error: '',
    message: '',
    status: ''
  };
  $scope.user = {};

  $scope.getFilmsCount = function () {

    if(localStorage.getItem('email'))
    {
      $http.get("/api/user/findByEmail/" + localStorage.getItem('email')).then(
        function successCallback(response) {
          $scope.user = response.data;
        },
        function errorCallback(response) {
          $scope.err = response.data;
          console.log("Error....");
          console.log(response);

        }
      );
    }
    
  };

  $scope.getFilmsCount()

});