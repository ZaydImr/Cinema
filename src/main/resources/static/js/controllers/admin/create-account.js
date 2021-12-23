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
                location.replace('/admin');


            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    };
    $scope.Cancel = function() {
        location.replace('/admin');
    };

    // Initialization
    $scope.getRoles()

});