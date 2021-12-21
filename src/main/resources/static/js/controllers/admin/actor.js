myApp.controller("actorController", function($scope,$http){

	$scope.all = { list:[], next:true, prev:false};
	$scope.addAct = false;
	$scope.editAct = false;
	$scope.page= 1;
    $scope.unPage = 1;
	$scope.loading = false;
    $scope.isDeleteOpen = false;
    $scope.idAct = '';
    $scope.nomActeur = '';
    $scope.birthActor= '';
    $scope.natActor = '';
    $scope.imgActor = '';
    //$scope.nationalite = '';
    $scope.searchIn = '';

    $scope.getAct = function ($page){
        $scope.loading = true;
        $http.get('/api/actor/all/'+$scope.unPage)
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
    $scope.next = function(){ $scope.unPage = $scope.unPage + 1; $scope.getAct($scope.unPage);}
    $scope.prev = function(){ $scope.unPage = $scope.unPage - 1; $scope.getAct($scope.unPage);}


    $scope.setAdd = function(){
        if($scope.editAct)
            $scope.editAct = false;
        if(!$scope.addAct)
             $scope.nomActeur = '';
             $scope.birthActor= '';
             $scope.natActor = '';
             $scope.imgActor = '';
             $scope.addAct = !$scope.addAct;
    }

    $scope.setEdit = function(){
        if($scope.addAct)
            $scope.addAct = false;
         $scope.editAct = !$scope.editAct;}


       
    $scope.addActor = function($nomActor,$birthActor,$natActor,$imgActor) {
        $http.post('/api/actor/add/',{ fullNameActor:$nomActor,birthdayActor:$birthActor,nationalityActor: $natActor, imgActor:$imgActor })
            .then(function successCallback(){
                $scope.getAct();
                $scope.setAdd();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.updateActor = function($idAct,$nomActor,$birthActor,$natActor,$imgActor) {
        $http.put('/api/actor/update/',{ id: $idAct, Actor:$nomActor,birthdayActor:$birthActor,nationalityActor: $natActor, imgActor:$imgActor })
            .then(function successCallback(){
                $scope.getAct();
                $scope.setEdit();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }

    //stoped
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
        $http.delete('/api/nationality/delete/'+$idNat)
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
            $http.get('/api/nationality/all/keyword/'+$scope.searchIn)
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

    $scope.getNat();

});