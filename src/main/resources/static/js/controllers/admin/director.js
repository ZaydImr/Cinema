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

myApp.controller("directorController", function($scope,$http){

    // Variables
	$scope.all = { list:[], next:true, prev:false};
	$scope.add = false;
	$scope.edit = false;
	$scope.page= 1;
    $scope.unPage = 1;
	$scope.loading = false;
    $scope.isDeleteOpen = false;
    $scope.idDirector = '';
    $scope.director =  {
        fullnameDirector:'',
        birthdayDirector:'',
        nationalityDirector: {},
        imgDirector: {}
    };
    $scope.file = '';
    $scope.nationalities = [];
    $scope.searchIn = '';

    // Functions
    $scope.getDirectors = function ($page){
        $scope.loading = true;
        $http.get('/api/director/all/'+$scope.unPage)
            .then(function successCallback(response){
                    $scope.loading = false;
                    $scope.all = response.data;
        			$scope.directorsCount = response.data.length-1;
                    if($page) $scope.page = $page;
            }, function errorCallback(response) {
        			console.log('Error....');
        			console.log(response);
            });
    }
    $scope.getNationalities = function (){
        $http.get('/api/nationality/all')
            .then(function successCallback(response){
                    $scope.nationalities = response.data;
                    $scope.director.nationalityDirector = $scope.nationalities[0];
            }, function errorCallback(response) {
        			console.log('Error....');
        			console.log(response);
            });
    }
    $scope.next = function(){ $scope.unPage = $scope.unPage + 1; $scope.getDirectors($scope.unPage);}
    $scope.prev = function(){ $scope.unPage = $scope.unPage - 1; $scope.getDirectors($scope.unPage);}
    $scope.setAdd = function(){
        if($scope.edit)
            $scope.edit = false;
        if(!$scope.add)
            $scope.director = {
                fullnameDirector:'',
                birthdayDirector:'',
                nationalityDirector: $scope.nationalities[0],
                imgDirector: ''
            };
        $scope.add = !$scope.add;
    }
    $scope.setEdit = function(){
        if($scope.add)
            $scope.add = false;
         $scope.edit = !$scope.edit;}
    $scope.addDirector = function() {
        $http.post('/api/director/add/', $scope.director  )
            .then(function successCallback(){
                $scope.getDirectors();
                $scope.setAdd();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.updateDirector = function() {
        $http.put('/api/director/update/', $scope.director )
            .then(function successCallback(){
                $scope.getDirectors();
                $scope.setEdit();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.prerareUpdate = function($id) {
        $scope.director = $scope.all.list.filter(di=> di.id === $id)[0];
        if($scope.director.birthdayDirector)
            $scope.director.birthdayDirector = new Date($scope.director.birthdayDirector);
        if($scope.add)
            $scope.add = false;
        $scope.edit = true;
    }
    $scope.prepareDelete = function($idDirector){
        $scope.isDeleteOpen = true;
        $scope.idDirector = $idDirector;
    }
    $scope.deleteDirector = function($idDirector){
        $http.delete('/api/director/delete/'+$idDirector)
            .then(function successCallback(){
                $scope.getDirectors();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.search = function() {
        if($scope.searchIn === "")
        {
            $scope.page = 1;
            $scope.unPage = 1;
            $scope.getDirectors(1);
        }
        else{
            $scope.loading = true;
            $http.get('/api/director/all/keyword/'+$scope.searchIn)
                .then(function successCallback(response){
                    console.log(response);
                        $scope.loading = false;
                        $scope.all = { list :response.data, next: false, prev:false};

                        $scope.directorsCount = response.data.length-1;
                }, function errorCallback(response) {
                        console.log('Error....');
                        console.log(response);
                });  
        }
    }
    
    $scope.addPhoto = function() {  

        var url = "/api/upload/add";

        var data = new FormData();

        data.append("description", "director");
        console.log($scope.director.imgDirector);
        for (i = 0; i < $scope.director.imgDirector.length; i++) {
            data.append("files", $scope.director.imgDirector[i]);
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
                $scope.director.imgDirector =  response.data;
                if($scope.add) $scope.addDirector();
                else $scope.updateDirector();
            },
            // Error
            function(response) {
                console.log(response.data);
            });
    };

    // Initialization
    $scope.getNationalities();
    $scope.getDirectors();

});