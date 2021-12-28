Date.prototype.addDays = function (days) {
  var date = new Date(this.valueOf());
  date.setDate(date.getDate() + days);
  return date;
}

myApp.controller("accountController", function ($scope, $http) {

  $scope.edit = false;
  $scope.err = {
    error: '',
    message: '',
    status: ''
  };

  $scope.user = {
        email: "",
        password: "",
        fullnameUser: "",
        birthdayUser: "",
        phoneNumberUser: "",
        imgUser: ""
  };

  $scope.getFilmsCount = function () {

    if(localStorage.getItem('email'))
    {
      $http.get("/api/user/findByEmail/" + localStorage.getItem('email')).then(
        function successCallback(response) {
          $scope.user = response.data;
          $scope.user.birthdayUser = new Date($scope.user.birthdayUser);
        },
        function errorCallback(response) {
          $scope.err = response.data;
          console.log("Error....");
          console.log(response);

        }
      );
    }

    $scope.setEdit = function(){ $scope.edit = ! $scope.edit;}
    $scope.cancelEdit = function(){$scope.edit = ! $scope.edit; }

        $scope.updateUser = function() {
            $http.put('/api/user/update/', $scope.user )
                .then(function successCallback(){
                    $scope.edit = !$scope.edit;
                }, function errorCallback(response) {
                    console.log('Error....');
                    console.log(response);
                });
        }
    
  };

  $scope.getFilmsCount()

});