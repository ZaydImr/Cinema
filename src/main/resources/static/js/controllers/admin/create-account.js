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
  

myApp.controller("createAdminAccoutController", function($scope,$http){

    // Variables
	$scope.user= {
        fullnameUser: '',
        birthdayUser: '',
        email: '',
        password: '',
        rePassword: '',
        phoneNumberUser: '',
        imgUser: '',
        roles:[],
        check : false
    };
    $scope.roles = [];
    
    // Methodes
    $scope.getRoles = function () {
        $http.get('/api/role/all')
        .then(function successCallback(res){
            $scope.user.roles[0] = res.data[0];
            $scope.roles = res.data;
        }, function errorCallback(response) {
            console.log('Error....');
            console.log(response);
        });
    };
    $scope.addUser = function() {
        $http.post('/api/user/add/', $scope.user )
            .then(function successCallback(){
                //location.replace('/admin');


            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    };

    $scope.addPhoto = function() {  

        var url = "/api/upload/add";
    
        var data = new FormData();
    
        data.append("description", (($scope.user.roles[0].role === "ROLE_ADMIN") ? "admin" : "user"));
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

    $scope.Cancel = function() {
        location.replace('/admin');
    };

    // Initialization
    $scope.getRoles()

});