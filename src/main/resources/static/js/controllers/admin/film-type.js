myApp.controller("filmTypeController", function($scope,$http){

    // Variables
	$scope.all = { list:[], next:true, prev:false};
	$scope.add = false;
	$scope.edit = false;
	$scope.page= 1;
    $scope.unPage = 1;
	$scope.loading = false;
    $scope.isDeleteOpen = false;
    $scope.idCategory = '';
    $scope.category = '';
    $scope.searchIn = '';
    
    // Functions
    $scope.getFilmTypes = function ($page){
        $scope.loading = true;
        $http.get('/api/filmtypes/all/'+$scope.unPage)
            .then(function successCallback(response){
                    $scope.loading = false;
                    $scope.all = response.data;
        			$scope.categoryCount = response.data.length-1;
                    if($page) $scope.page = $page;
            }, function errorCallback(response) {
        			console.log('Error....');
        			console.log(response);
            });
    }
    $scope.next = function(){ $scope.unPage = $scope.unPage + 1; $scope.getFilmTypes($scope.unPage);}
    $scope.prev = function(){ $scope.unPage = $scope.unPage - 1; $scope.getFilmTypes($scope.unPage);}
    $scope.setAdd = function(){
        if($scope.edit)
            $scope.edit = false;
        if(!$scope.add)
            $scope.category = '';
        $scope.add = !$scope.add;
    }
    $scope.setEdit = function(){
        if($scope.add)
            $scope.add = false;
         $scope.edit = !$scope.edit;}
    $scope.addCategory = function($category) {
        $http.post('/api/filmtypes/add/',{ typeFilm: $category })
            .then(function successCallback(){
                $scope.getFilmTypes();
                $scope.setAdd();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.updateCategory = function($id,$category) {
        $http.put('/api/filmtypes/update/',{ id: $id, typeFilm: $category })
            .then(function successCallback(){
                $scope.getFilmTypes();
                $scope.setEdit();
            }, function errorCallback(response) {
                console.log('Error....');
                console.log(response);
            });
    }
    $scope.prerareUpdate = function($id,category) {
        $scope.idCategory = $id;
        $scope.category = category;

        if($scope.add)
            $scope.add = false;
        $scope.edit = true;
    }
    $scope.prepareDelete = function($idCategory){
        $scope.isDeleteOpen = true;
        $scope.idCategory = $idCategory;
    }
    $scope.deleteCategory = function($idCategory){
        $http.delete('/api/filmtypes/delete/'+$idCategory)
            .then(function successCallback(){
                $scope.getFilmTypes();
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
            $scope.getFilmTypes(1);
        }
        else{
            $scope.loading = true;
            $http.get('/api/filmtypes/all/keyword/'+$scope.searchIn)
                .then(function successCallback(response){
                    console.log(response);
                        $scope.loading = false;
                        $scope.all = { list :response.data, next: false, prev:false};

                        $scope.categoryCount = response.data.length-1;
                }, function errorCallback(response) {
                        console.log('Error....');
                        console.log(response);
                });  
        }
    }

    $scope.getFilmTypes();

});