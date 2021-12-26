myApp.controller("headerController", function($scope,$http){
    $scope.getUser = function(){
        if(localStorage.getItem('email'))
        {
            $http.get('/api/user/findByEmail/'+localStorage.getItem('email'))
                .then( function(res){
                    $scope.user = res.data;
                })
        }
    }
    
    $scope.getUser()
});
