var myApp = angular.module('myApp',[]);

myApp.directive('input',function(){
  return {
    restrict: 'E',
    scope: {
      ngModel: '=',
      ngChange: '&',
      type: '@'
    },
    link: function (scope, element, attrs) {
      if(scope.type.toLowerCase()!='file'){
        return;
      }
      element.bind('change', function(){
        let files =  element[0].files;
        scope.ngModel = files;
        scope.$apply();
        scope.ngChange();
      });
    }
  }
  
})

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
    });
  };

  $scope.addUser = function () {
        $http.post('/api/user/add/', $scope.user ).then(
          function successCallback() {
                location.replace('/login');
                $scope.message = "The user with Email:" + $scope.user.email + "was added successfully !" ;
                console.log("Success");
          },
          function errorCallback(response) {
          $scope.message = "The user with Email:" + $scope.user.email + "wasn't added successfully !" ;
            console.log("Error....");
            console.log(response);
          }
        );
  };

  $scope.addPhoto = function() {  

    var url = "/api/upload/add";

    var data = new FormData();

    data.append("description", "admin");
    for (i = 0; i < $scope.user.imgUser.length; i++) {
        data.append("files", $scope.user.imgUser[i]);
    }

    var config = {
        transformRequest: angular.identity,
        transformResponse: angular.identity,
        headers: {
            'Content-Type': undefined
        }
    }

   $http.post(url, data, config).then(
        // Success
        function(response) {
            $scope.user.imgUser =  response.data;
            $scope.addUser();
        },
        // Error
        function(response) {
            console.log(response.data);
    });
  };
  
      
  // Initialization
  $scope.getRoles();


});