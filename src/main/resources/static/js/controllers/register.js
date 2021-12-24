myApp.controller("registerController", function ($scope, $http) {

    $scope.message = "igtg";
	$scope.user = {
	    fullnameUser: "",
	    phoneNumberUser: "",
	    email: "",
	    password: "",
	    rePassword: "",
	    birthdayUser: "",
	    imgUser: "",
	    check: false,
	    role: []
	};
	$scope.roles = [];

    $scope.getRoles = function () {
        $http.get("/api/role/all").then(
          function successCallback(response) {
            $scope.roles = response.data;
            $scope.user.role[0] = $scope.roles[0];
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
                location.replace('/login');
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