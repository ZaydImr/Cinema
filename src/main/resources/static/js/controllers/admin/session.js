myApp.controller("sessionController", function($scope,$http){

    // Variables
	$scope.all = { list:[], next:true, prev:false};
	$scope.add = false;
	$scope.edit = false;
	$scope.page= 1;
    $scope.unPage = 1;
	$scope.loading = false;
    $scope.isDeleteOpen = false;
    $scope.idSession = '';
    $scope.session = {
        dateBeginSession:'',
        tarif:'',
        film:{},
        room:{}
    };
    $scope.rooms=[];
    $scope.films=[];
    $scope.searchIn = '';

    // Functions
    $scope.getSessions = function ($page){
        $scope.loading = true;
        $http.get('/api/session/all/'+$scope.unPage)
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
    $scope.getFilms = function (){
        $http.get('/api/film/all')
            .then(function successCallback(response){
                    $scope.films = response.data;
                    $scope.session.film = $scope.films[0];
            }, function errorCallback(response) {
        			console.log('Error....');
        			console.log(response);
            });
    }
    $scope.getRooms = function (){
        $http.get('/api/room/all')
            .then(function successCallback(response){
                    $scope.rooms = response.data;
                    $scope.session.room = $scope.rooms[0];
            }, function errorCallback(response) {
        			console.log('Error....');
        			console.log(response);
            });
    }
    $scope.next = function(){ $scope.unPage = $scope.unPage + 1; $scope.getSessions($scope.unPage);}
    $scope.prev = function(){ $scope.unPage = $scope.unPage - 1; $scope.getSessions($scope.unPage);}
    $scope.setAdd = function(){
        if($scope.edit)
            $scope.edit = false;
        if(!$scope.add)
            $scope.session = {
                dateBeginSession:'',
                tarif:'',
                film:$scope.films[0],
                room:$scope.rooms[0]
            };
        $scope.add = !$scope.add;
    }
    $scope.setEdit = function(){
        if($scope.add)
            $scope.add = false;
         $scope.edit = !$scope.edit;
    }
    $scope.addSession = function() {
        $http.post('/api/session/add/', $scope.session)
            .then(function successCallback(){
                $scope.getSessions();
                $scope.setAdd();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.updateSession = function() {
        $http.put('/api/session/update/', $scope.session)
            .then(function successCallback(){
                $scope.getSessions();
                $scope.setEdit();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.prerareUpdate = function($id) {
        $scope.session=$scope.all.list.filter(sec=>sec.id ===$id)[0];        

        if($scope.session.dateBeginSession)
            $scope.session.dateBeginSession = new Date($scope.session.dateBeginSession);
        if($scope.add)
            $scope.add = false;
        $scope.edit = true;
    }
    $scope.prepareDelete = function($idSession){
        $scope.isDeleteOpen = true;
        $scope.idSession = $idSession;
    }
    $scope.deleteSession = function($idSession){
        $http.delete('/api/session/delete/'+$idSession)
            .then(function successCallback(){
                $scope.getSessions();
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
            $scope.getSessions(1);
        }
        else{
            $scope.loading = true;
            $http.get('/api/session/all/keyword/'+$scope.searchIn)
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

    // Initialization
    $scope.getSessions();
    $scope.getRooms();
    $scope.getFilms();

});