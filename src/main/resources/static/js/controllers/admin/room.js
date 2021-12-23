myApp.controller("roomController", function($scope,$http){

    // Variables
	$scope.all = { list:[], next:true, prev:false};
	$scope.add = false;
	$scope.edit = false;
	$scope.page= 1;
    $scope.unPage = 1;
	$scope.loading = false;
    $scope.isDeleteOpen = false;
    $scope.idRoom = '';
    $scope.nameRoom = '';
    $scope.searchIn = '';

    // Functions
    $scope.getRooms = function ($page){
        $scope.loading = true;
        $http.get('/api/room/all/'+$scope.unPage)
            .then(function successCallback(response){
                    $scope.loading = false;
                    $scope.all = response.data;
        			$scope.roomsCount = response.data.length-1;
                    if($page) $scope.page = $page;
            }, function errorCallback(response) {
        			console.log('Error....');
        			console.log(response);
                    $scope.loading = false;
            });
    }
    $scope.next = function(){ $scope.unPage = $scope.unPage + 1; $scope.getRooms($scope.unPage);}
    $scope.prev = function(){ $scope.unPage = $scope.unPage - 1; $scope.getRooms($scope.unPage);}
    $scope.setAdd = function(){
        if($scope.edit)
            $scope.edit = false;
        if(!$scope.add)
            $scope.nameRoom = '';
        $scope.add = !$scope.add;
    }
    $scope.setEdit = function(){
        if($scope.add)
            $scope.add = false;
         $scope.edit = !$scope.edit;}
    $scope.addRoom = function(nameRoom) {
        $http.post('/api/room/add/',{ nameRoom })
            .then(function successCallback(){
                $scope.getRooms();
                $scope.setAdd();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.updateRoom = function($id,nameRoom) {
        $http.put('/api/room/update/',{ id: $id, nameRoom })
            .then(function successCallback(){
                $scope.getRooms();
                $scope.setEdit();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.prerareUpdate = function($id,$nameRoom) {
        $scope.idRoom = $id;
        $scope.nameRoom = $nameRoom;

        if($scope.add)
            $scope.add = false;
        $scope.edit = true;
    }
    $scope.prepareDelete = function($idRoom){
        $scope.isDeleteOpen = true;
        $scope.idRoom = $idRoom;
    }
    $scope.deleteRoom = function($idRoom){
        $http.delete('/api/room/delete/'+$idRoom)
            .then(function successCallback(){
                $scope.getRooms();
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
            $scope.getRooms(1);
        }
        else{
            $scope.loading = true;
            $http.get('/api/room/all/keyword/'+$scope.searchIn)
                .then(function successCallback(response){
                    console.log(response);
                        $scope.loading = false;
                        $scope.all = { list :response.data, next: false, prev:false};

                        $scope.roomsCount = response.data.length-1;
                }, function errorCallback(response) {
                        console.log('Error....');
                        console.log(response);
                });  
        }
    }

    // Initialization
    $scope.getRooms();

});