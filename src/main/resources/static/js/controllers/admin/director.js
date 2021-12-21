myApp.controller("directorController", function($scope,$http){

	$scope.all = { list:[], next:true, prev:false};
	$scope.addNat = false;
	$scope.editNat = false;
	$scope.page= 1;
    $scope.unPage = 1;
	$scope.loading = false;
    $scope.isDeleteOpen = false;
    $scope.idNat = '';
    $scope.director =  {
        fullnameDirector:'',
        birthdayDirector:'',
        nationalityDirector: {},
        imgDirector: ''
    };
    $scope.nationalities = [];
    $scope.searchIn = '';
    $scope.getNat = function ($page){
        $scope.loading = true;
        $http.get('/api/director/all/'+$scope.unPage)
            .then(function successCallback(response){
                    $scope.loading = false;
                    $scope.all = response.data;
        			$scope.natsCount = response.data.length-1;
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
    $scope.next = function(){ $scope.unPage = $scope.unPage + 1; $scope.getNat($scope.unPage);}
    $scope.prev = function(){ $scope.unPage = $scope.unPage - 1; $scope.getNat($scope.unPage);}
    $scope.setAdd = function(){
        if($scope.editNat)
            $scope.editNat = false;
        if(!$scope.addNat)
            $scope.director = {
                fullnameDirector:'',
                birthdayDirector:'',
                nationalityDirector: $scope.nationalities[0],
                imgDirector: ''
            };
            console.log($scope.director);
        $scope.addNat = !$scope.addNat;
    }
    $scope.setEdit = function(){
        if($scope.addNat)
            $scope.addNat = false;
         $scope.editNat = !$scope.editNat;}
    $scope.addNationalite = function() {
        $http.post('/api/director/add/', $scope.director )
            .then(function successCallback(){
                $scope.getNat();
                $scope.setAdd();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.updateNationalite = function($id,$nationalite) {
        $http.put('/api/director/update/', $scope.director )
            .then(function successCallback(){
                $scope.getNat();
                $scope.setEdit();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.prerareUpdate = function($id,$nat) {
        $scope.idNat = $id;
        $scope.nationalite = $nat;

        if($scope.addNat)
            $scope.addNat = false;
        $scope.editNat = true;
    }
    $scope.prepareDelete = function($idNat){
        $scope.isDeleteOpen = true;
        $scope.idNat = $idNat;
    }
    $scope.deleteNat = function($idNat){
        $http.delete('/api/director/delete/'+$idNat)
            .then(function successCallback(){
                $scope.getNat();
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
            $scope.getNat(1);
        }
        else{
            $scope.loading = true;
            $http.get('/api/director/all/keyword/'+$scope.searchIn)
                .then(function successCallback(response){
                    console.log(response);
                        $scope.loading = false;
                        $scope.all = { list :response.data, next: false, prev:false};

                        $scope.natsCount = response.data.length-1;
                }, function errorCallback(response) {
                        console.log('Error....');
                        console.log(response);
                });  
        }
    }

    $scope.getNationalities();
    $scope.getNat();

});