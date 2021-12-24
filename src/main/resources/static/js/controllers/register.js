var myApp = angular.module('myApp',[]);

myApp.controller("registerController", function ($scope, $http) {
  
  $scope.message = "";
	$scope.user = {
	    fullnameUser: "",
	    phoneNumberUser: "",
	    email: "",
	    password: "",
	    rePassword: "",
	    birthdayUser: "",
	    imgUser: "",
	    check: false,
	    roles: []
	};

    $scope.getRoles = function () {
        $http.get("/api/role/find/ROLE_USER").then(
          function successCallback(response) {
            $scope.user.roles[0] = response.data;
          },
          function errorCallback(response) {
            console.log("Error....");
            console.log(response);
          }
        );
      };

    $scope.addUser = function () {
        $http.post('/api/user/add/', $scope.user ).then(
          function successCallback() {
                location.replace('/login);
                $scope.message = "The user with Email:" + $user.email + "was added successfully !" ;
                console.log("Success");
          },
          function errorCallback(response) {
          $scope.message = "The user with Email:" + $user.email + "wasn't added successfully !" ;
            console.log("Error....");
            console.log(response);
          }
        );
      };

    $scope.getRoles();
});